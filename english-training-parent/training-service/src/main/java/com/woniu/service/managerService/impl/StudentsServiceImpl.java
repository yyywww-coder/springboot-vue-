package com.woniu.service.managerService.impl;

import com.github.pagehelper.PageInfo;
import com.woniu.adapter.managerAdapter.StudentsAdapter;
import com.woniu.domain.Students;
import com.woniu.exception.ManagerException;
import com.woniu.po.StudentsPo;
import com.woniu.service.managerService.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentsServiceImpl implements StudentsService {

        @Autowired
        private StudentsAdapter studentsAdapter;

        /**
         * 获取所有学员信息
         * @return
         */
        @Override
        public PageInfo<StudentsPo> getAllStudents(Integer pageIndex, Integer pageSize, StudentsPo student) {

                PageInfo<StudentsPo> pageInfo = studentsAdapter.findStudentLists(pageIndex,pageSize,student);
                if(pageInfo ==null){
                        throw new ManagerException("无学员信息相关数据");
                }
                return pageInfo;
        }

        @Override
        public PageInfo<StudentsPo> findAll(Integer pageIndex, Integer pageSize, String username) {
                return studentsAdapter.findAll(pageIndex,pageSize,username);
        }

        /**
         * 修改学员信息
         * @param studentsPo
         */
        @Override
        public void update(StudentsPo studentsPo) {
                studentsAdapter.updateStudent(studentsPo);
        }

        /**
         * 根据ID删除
         * @param id
         */
        @Override
        public void delete(Integer id) {
                studentsAdapter.deleteStudent(id);
        }


        /**
         * 新增
         * @param studentsPo
         */
        @Override
        public void add(StudentsPo studentsPo) {
                studentsAdapter.addStudents(studentsPo);
        }


        /**
         * 获得总记录数
         * @return
         */
        @Override
        public int getTotal() {
                return studentsAdapter.getTotal();
        }

        @Override
        public List<Object> getNum() {
                return studentsAdapter.getNum();
        }
}
