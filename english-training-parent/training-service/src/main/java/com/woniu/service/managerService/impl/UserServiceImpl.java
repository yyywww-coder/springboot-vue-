package com.woniu.service.managerService.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.adapter.managerAdapter.UserAdapter;
import com.woniu.domain.User;
import com.woniu.po.UserPo;
import com.woniu.service.managerService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserAdapter userAdapter;


    @Override
    public void addUser() {

    }

    @Override
    public void updateUser(String status,Integer id) {
        userAdapter.updateUser(status,id);
    }

    @Override
    public void deleteUser() {

    }

    @Override
    public User findByUserName(String username) {
        return userAdapter.findByUserName(username);
    }

    @Override
    public PageInfo<UserPo> findAllUsers(Integer pageIndex, Integer pageSize, String searchName, String status) {
      /*  try {

        }catch (UserException ex){

        }*/
       return userAdapter.findUserLists(pageIndex,pageSize,searchName,status);

    }
}
