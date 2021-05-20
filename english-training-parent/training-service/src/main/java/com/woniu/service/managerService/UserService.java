package com.woniu.service.managerService;

import com.github.pagehelper.PageInfo;
import com.woniu.domain.User;
import com.woniu.po.UserPo;

import java.util.List;

public interface UserService {

    public void addUser();

    public void updateUser(String status,Integer id);

    public void deleteUser();

    public PageInfo<UserPo> findAllUsers(Integer pageIndex, Integer pageSize, String searchName, String status);

public User findByUserName(String username);

}
