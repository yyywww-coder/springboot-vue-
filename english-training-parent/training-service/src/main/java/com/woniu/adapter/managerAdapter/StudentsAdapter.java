package com.woniu.adapter.managerAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.dao.managerDao.StudentsDao;
import com.woniu.domain.Students;
import com.woniu.domain.User;
import com.woniu.po.StudentsPo;
import com.woniu.po.UserPo;
import com.woniu.redis.managerRedisDao.StudentsRedisDao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentsAdapter {

        @Autowired
        private StudentsDao studentsDao;
        @Autowired
        private StudentsRedisDao studentsRedisDao;

        /**
         * 学生列表
         * @return
         */
        public PageInfo<StudentsPo> findStudentLists(Integer pageIndex, Integer pageSize, StudentsPo student){
                List<StudentsPo> studentsPoList = new ArrayList<>();
                PageInfo<StudentsPo> pageInfo = null;
                if(student.getUsername() !=null && student.getUsername() !="" || student.getCourseid() !=null){

                        studentsPoList = studentsDao.findAllStudents(student);
                        pageInfo = new PageInfo<>(studentsPoList);
                }else{
                        studentsPoList = studentsRedisDao.list();
                        ObjectMapper objectMapper = new ObjectMapper();
                        if(studentsPoList.size() == 0){
                                //从数据库查数据
                                PageHelper.startPage(pageIndex,pageSize);
                                studentsPoList = studentsDao.findAllStudents(student);
                                pageInfo  = new PageInfo<>(studentsPoList);
                                //存入redis的缓存中
                                studentsRedisDao.addRedisStudentList(pageInfo);
                        }
                }
//                //把dao的 userList UserPo --- 转成  List<User>
//                List<Students> students = new ArrayList<Students>();
//                for(StudentsPo studentsPo : studentsPoList) {
//                        Students item = new Students();
//                        BeanUtils.copyProperties(studentsPo, item);
//                        students.add(item);
//                }
                return pageInfo ;
        }

        public PageInfo<StudentsPo> findAll(Integer pageIndex, Integer pageSize,String username){
            PageInfo<StudentsPo> pageInfo = null;

            List<StudentsPo> list = studentsRedisDao.list();
            if (list.size() == 0){
                PageHelper.startPage(pageIndex,pageSize);
               list =  studentsDao.findAll(username);
               pageInfo = new PageInfo<>(list);
               return pageInfo;
            }

            pageInfo = new PageInfo<>(list);
            return pageInfo;

        }

        /**
         * 修改学员信息
         * @param studentsPo
         */
        public void updateStudent(StudentsPo studentsPo){
                studentsDao.update(studentsPo);
                List<StudentsPo> allStudents = studentsDao.findAllStudents(null);
                PageInfo<StudentsPo> poPageInfo = new PageInfo<>(allStudents);
                studentsRedisDao.addRedisStudentList(poPageInfo);
        }


        /**
         * 新增学员
         * @param studentsPo
         */
        public void addStudents(StudentsPo studentsPo){
                studentsDao.add(studentsPo);
                List<StudentsPo> allStudents = studentsDao.findAllStudents(null);
                PageInfo<StudentsPo> poPageInfo = new PageInfo<>(allStudents);
                studentsRedisDao.addRedisStudentList(poPageInfo);
        }


        /**
         * 根据id删除
         * @param id
         */
        public void deleteStudent(Integer id){
                studentsDao.delete(id);
                List<StudentsPo> allStudents = studentsDao.findAllStudents(null);
                PageInfo<StudentsPo> poPageInfo = new PageInfo<>(allStudents);
                studentsRedisDao.addRedisStudentList(poPageInfo);
        }

        /**
         * 查询学生列表总记录数
         * @return
         */
        public int getTotal(){
                return studentsDao.getTotal();
        }

        public List<Object> getNum(){
                return studentsDao.getNum();
        }

}
