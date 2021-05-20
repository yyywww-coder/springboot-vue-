package com.woniu.dao.managerDao;

import com.woniu.po.ManagerPo;

import java.util.List;

public interface ManagerDao {

    //验证登录
    public ManagerPo doLogin(ManagerPo manager);

    //根据用户名查
    public ManagerPo findByAccount(String account);

    //查所有
    public List<ManagerPo> findAll();

    //删除
    public void delManager(Integer id);

    //修改
    public void updateManager(ManagerPo manager);

    //添加
    public void addManager(ManagerPo manager);

    //模糊查询
    public List<ManagerPo> findByUsername(String username);

    //根据id查询用户信息
    public ManagerPo findById(Integer id);

    //查询所有的老师
    public List<ManagerPo> findAllTeacher(ManagerPo managerPo);


}

