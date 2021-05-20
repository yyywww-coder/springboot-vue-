package com.woniu.dao.managerDao;

import com.woniu.po.PermsPo;

import java.util.List;
import java.util.Map;

public interface PermsDao {

    //根据账号查询权限
    public List<PermsPo> findPermByUsername(String account);

    //获取所有权限
    public List<PermsPo> findAllPerms();

    //添加权限
    public void addPerms(Map<String, Integer> maps);

    //删除
    void delById(Integer id);

    List<PermsPo> getById(Integer id);

    //操作权限
    public List<String> findPermsByUsername(String username);


}
