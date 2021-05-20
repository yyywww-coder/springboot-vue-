package com.woniu.service.managerService.impl;

import com.github.pagehelper.PageInfo;
import com.woniu.adapter.managerAdapter.ManagerAdapter;
import com.woniu.adapter.managerAdapter.TeacherAdapter;
import com.woniu.domain.Manager;
import com.woniu.domain.Teacher;
import com.woniu.po.ManagerPo;
import com.woniu.po.TeacherPo;
import com.woniu.service.managerService.ManagerService;
import com.woniu.service.managerService.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherAdapter managerAdapter;

    /**
     * 前台的查询
     * @param pageIndex
     * @param pageSize
     * @param username
     * @return
     */
    @Override
    public PageInfo<TeacherPo> findByUsername(Integer pageIndex, Integer pageSize, String username) {
        return managerAdapter.findByUsername(pageIndex,pageSize,username);
    }


    @Override
    public Teacher findByid(Integer id) {
         return managerAdapter.findById(id);
    }

    public List<Manager> findAll() {
        return managerAdapter.findAll();
    }
//
//    @Override
//    public void updateManager(ManagerPo manager) {
//        managerAdapter.updateManager(manager);
//    }
//
//    @Override
//    public void addManager(ManagerPo manager) {
//        managerAdapter.addManager(manager);
//    }
//
//    @Override
//    public Manager findByAccount(String account) {
//        return managerAdapter.findByAccount(account);
//    }
//
//    @Override
//    public void delManager(Integer id) {
//        managerAdapter.delManager(id);
//    }
//
//    @Override
//    public Manager doLogin(ManagerPo managerPo) {
//        return managerAdapter.doLogin(managerPo);
//    }
}
