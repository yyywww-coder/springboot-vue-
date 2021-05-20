package com.woniu.service.managerService;

import com.github.pagehelper.PageInfo;
import com.woniu.domain.Course;
import com.woniu.domain.Manager;
import com.woniu.po.ManagerPo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ManagerService {

    //查找所有
    public List<Manager> findAll();

    //登录
    public Manager doLogin(ManagerPo managerPo);

    //删除
    public void delManager(Integer id);

    //修改
    public void updateManager(ManagerPo manager);

    //根据用户名查
    public Manager findByAccount(String account);

    //添加
    public void addManager(ManagerPo manager);

    //模糊查询
    public PageInfo<ManagerPo> findByUsername(Integer pageIndex,Integer pageSize,String username);
    //根据id查询用户信息
    public Manager findById(Integer id);

    public List<Manager> findAllTeacher(ManagerPo managerPo);

    public String uploadImage(MultipartFile file);




}
