package com.woniu.service.managerService;

import com.github.pagehelper.PageInfo;
import com.woniu.domain.Manager;
import com.woniu.domain.Teacher;
import com.woniu.po.ManagerPo;
import com.woniu.po.TeacherPo;

import java.util.List;

public interface TeacherService {
//
//    //查询所有阶段分数
//    public List<Manager> getAllTeacher();
//
//    //更改阶段分数
//    public void updateTeacher(Manager manager);
//
//    //删除阶段分数
//    public void deleteTeacher(Integer id);
//
//    //添加分数
//    public void addTeacher(Manager manager);
//
//

//前台的查询教师详情
    public  Teacher findByid(Integer id);

    //前台的查询
    public PageInfo<TeacherPo> findByUsername(Integer pageIndex, Integer pageSize, String username);

}
