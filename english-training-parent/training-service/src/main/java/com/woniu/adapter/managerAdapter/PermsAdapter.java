package com.woniu.adapter.managerAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniu.dao.managerDao.ManagerDao;
import com.woniu.dao.managerDao.PermsDao;
import com.woniu.domain.Manager;
import com.woniu.domain.Perms;
import com.woniu.po.ManagerPo;
import com.woniu.po.PermsPo;
import com.woniu.redis.managerRedisDao.PermsRedisDao;
import com.woniu.service.managerService.ManagerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@SuppressWarnings("all")
public class PermsAdapter {

    @Resource
    private PermsDao permsDao;

    @Autowired
    private PermsRedisDao permsRedisDao;
    @Autowired
    private ManagerDao managerDao;

    public List<Perms> findPermByUsername(String account){

        List<PermsPo> permsPoList = permsRedisDao.list(account);
        ObjectMapper objectMapper = new ObjectMapper();
        if (permsPoList.size() == 0){
            permsPoList = permsDao.findPermByUsername(account);
            permsRedisDao.addRedisPermsPoList(permsPoList,account);
        }

        List<Perms> permsList = new ArrayList<>();
        for (PermsPo permsPo : permsPoList) {
            Perms item = new Perms();
            BeanUtils.copyProperties(permsPo,item);
            permsList.add(item);
        }
        return permsList;

    }

    public void addPerms(Map<String, Integer> maps,Integer id){
        ManagerPo managerPo = managerDao.findById(id);
        permsDao.addPerms(maps);
        List<PermsPo> permsPoList = permsDao.findPermByUsername(managerPo.getAccount());

        permsRedisDao.addRedisPermsPoList(permsPoList,managerPo.getAccount());
    }

    public List<Perms> getById(Integer id){
        List<PermsPo> permsPoList = permsDao.getById(id);
        List<Perms> permsList = new ArrayList<>();
        for (PermsPo permsPo : permsPoList) {
            Perms item = new Perms();
            BeanUtils.copyProperties(permsPo,item);
            permsList.add(item);
        }
        return permsList;
    }


    /**
     * 查询操作权限
     * @param username
     * @return
     */
    public List<String> findPermsByUsername(String username){
        List<String> stringList = permsDao.findPermsByUsername(username);
        return stringList;
    }

}
