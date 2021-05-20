package com.woniu.service.managerService;

import com.github.pagehelper.PageInfo;
import com.woniu.domain.Students;
import com.woniu.po.StudentsPo;

import java.util.List;

public interface StudentsService {

        //查询所有学生
        public PageInfo<StudentsPo> getAllStudents(Integer pageIndex, Integer pageSize, StudentsPo student);

        public PageInfo<StudentsPo> findAll(Integer pageIndex,Integer pageSize,String username);

        //修改学生信息
        public void  update(StudentsPo studentsPo);

        //删除学生
        public void delete(Integer id);

        //新增学生
        public void add(StudentsPo studentsPo);

        //总记录数
        public int getTotal();

        //查询各科人数
        public List<Object> getNum();
}
