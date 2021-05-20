package com.woniu.adapter.managerAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.dao.managerDao.ManagerDao;
import com.woniu.domain.Manager;
import com.woniu.po.ManagerPo;
import com.woniu.redis.managerRedisDao.ManagerRedisDao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
@SuppressWarnings("all")
public class ManagerAdapter {

    @Resource
    private ManagerDao managerDao;

    @Autowired
    private ManagerRedisDao managerRedisDao;

    PageInfo<ManagerPo> poPageInfo = null;


    /**
     * 查所有
     * @return
     */
    public List<Manager> findAll(){

       /* List<ManagerPo> managerList = managerRedisDao.list();
        ObjectMapper objectMapper = new ObjectMapper();
        if (managerList.size() == 0){
            managerList = managerDao.findAll();
            managerRedisDao.addRedisManagerList(managerList);
        }

        //把dao中的实体类对象转换为service中的实体类对象
        List<Manager> managers = new ArrayList<>();
        for (ManagerPo manager : managerList) {
            Manager item = new Manager();
            BeanUtils.copyProperties(manager,item);
            managers.add(item);
        }*/

        return null;
    }

    public Manager findByAccount(String account){
        ManagerPo m = managerDao.findByAccount(account);
        Manager manager = new Manager();
        BeanUtils.copyProperties(m,manager);
        return manager;
    }

    /**
     * 验证登录
     * @param manager
     * @return
     */
    public Manager doLogin(ManagerPo manager){
        ManagerPo m = managerDao.doLogin(manager);
        Manager item = new Manager();
        BeanUtils.copyProperties(m,item);
        return item;
    }

    /**
     * 删除
     * @param id
     */
    public void delManager(Integer id){
        managerDao.delManager(id);
        List<ManagerPo> list = managerDao.findAll();
        poPageInfo = new PageInfo<>(list);
        managerRedisDao.addRedisManagerList(poPageInfo);
    }

    public void updateManager(ManagerPo manager){
        managerDao.updateManager(manager);
        List<ManagerPo> list = managerDao.findAll();
        poPageInfo = new PageInfo<>(list);
        managerRedisDao.addRedisManagerList(poPageInfo);
    }

    /**
     * 添加
     */
    public void addManager(ManagerPo manager){
        managerDao.addManager(manager);
        List<ManagerPo> list = managerDao.findAll();
        poPageInfo = new PageInfo<>(list);
        managerRedisDao.addRedisManagerList(poPageInfo);
    }

    /**
     * 模糊查询
     * @param username
     * @return
     */
    public PageInfo<ManagerPo> findByUsername(Integer pageIndex,Integer pageSize,String username) {

        List<ManagerPo> managerPoList = managerRedisDao.list();
        if (managerPoList.size() == 0) {
            PageHelper.startPage(pageIndex,pageSize);
            managerPoList = managerDao.findByUsername(username);
            poPageInfo = new PageInfo<>(managerPoList);
            managerRedisDao.addRedisManagerList(poPageInfo);
        }
        /*List<Manager> managerList = new ArrayList<>();
        for (ManagerPo managerPo : managerPoList) {
            Manager item = new Manager();
            BeanUtils.copyProperties(managerPo, item);
            managerList.add(item);
        }*/
        poPageInfo = new PageInfo<>(managerPoList);
        return poPageInfo;

    }

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    public Manager findById(Integer id){
        Manager manager = new Manager();
        ManagerPo managerPo = managerDao.findById(id);
        BeanUtils.copyProperties(managerPo,manager);
        return manager;
    }

    /**
     * 查询所有的老师
     * @param managerPo
     * @return
     */
    public List<Manager> findAllTeacher(ManagerPo managerPo){
        List<Manager> managers = new ArrayList<>();
        List<ManagerPo> allTeacher = managerDao.findAllTeacher(managerPo);
        for (ManagerPo po : allTeacher) {
            Manager manager = new Manager();
            BeanUtils.copyProperties(po,manager);
            managers.add(manager);
        }
        return managers;
    }



}
