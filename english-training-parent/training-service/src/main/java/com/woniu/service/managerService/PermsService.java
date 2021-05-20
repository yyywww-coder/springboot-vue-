package com.woniu.service.managerService;

import com.woniu.domain.Perms;
import com.woniu.po.PermsPo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface PermsService {

    //根据账号查询权限
    public List<Perms> findPermByUsername(String account);

    //获取所有权限
    public List<PermsPo> findAllPerms();

    public void addPerms(Map<String, Integer> maps,Integer id);

    void delPermsById(Integer id);

    List<Perms> getById(Integer id);

    public List<String> findPermsByUsername(String username);

}
