package com.woniu.dao.managerDao;

import com.github.pagehelper.PageInfo;
import com.woniu.po.StudentsPo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentsDao {

        //查询所有学生
        public List<StudentsPo> findAllStudents(StudentsPo student);

        public List<StudentsPo> findAll(String username);

        //修改学生信息
        public void  update(StudentsPo studentsPo);

        //删除学生
        public void delete(Integer id);

        //新增学生
        public void add(StudentsPo studentsPo);

        //获取总记录数
        public int getTotal();

        public List<Object> getNum();
}
