package com.woniu.dao.managerDao;
import com.woniu.po.ManagerPo;
import com.woniu.po.TeacherPo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TeacherDao {

    //查询所有阶段分数
    public List<ManagerPo> findAllTeacher();

    //更改阶段分数
    public void updateTeacher(ManagerPo managerPo);

    //删除阶段分数
    public void deleteTeacher(Integer id);

    //添加分数
    public void addTeacher(ManagerPo managerPo);

    //模糊查询
    public List<TeacherPo> getList(String username);

    TeacherPo findByid(Integer id);
}