package com.woniu.adapter.managerAdapter;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.dao.managerDao.ArrangeDao;
import com.woniu.domain.Arrange;
import com.woniu.po.ArrangePo;
import com.woniu.redis.managerRedisDao.ArrangeRedisDao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
@Component
public class ArrangeAdapter {

    @Autowired
    private ArrangeRedisDao arrangeRedisDao;

    @Autowired
    private ArrangeDao arrangeDao;

    PageInfo<ArrangePo> poPageInfo = null;


    /**
     * 模糊查询
     * @param username
     * @return
     */
    public PageInfo<ArrangePo> findByUsername(Integer pageIndex, Integer pageSize, String username) {

        List<ArrangePo> arrangePoList = arrangeRedisDao.list();
        if (arrangePoList.size() == 0) {
            PageHelper.startPage(pageIndex,pageSize);
            arrangePoList = arrangeDao.findByUsername(username);
            poPageInfo = new PageInfo<>(arrangePoList);
            arrangeRedisDao.addRedisStudentList(poPageInfo);
        }
        /*List<Manager> managerList = new ArrayList<>();
        for (ManagerPo managerPo : managerPoList) {
            Manager item = new Manager();
            BeanUtils.copyProperties(managerPo, item);
            managerList.add(item);
        }*/
        poPageInfo = new PageInfo<>(arrangePoList);
        return poPageInfo;

    }

    /**
     * 新增预约
     * @param arrange
     */
    public void addArrange(ArrangePo arrange) {
        arrangeDao.add(arrange);
        List<ArrangePo> arrangePoList = arrangeRedisDao.list();
        poPageInfo = new PageInfo<>(arrangePoList);
        arrangeRedisDao.addRedisStudentList(poPageInfo);
    }

    /**
     * 查询科目
     * @return
     */
    public List<Arrange> getCourse(){
        List<ArrangePo> arrangePoList = arrangeDao.getCourse();
        List<Arrange> arrangeList = new ArrayList<>();
        for (ArrangePo arrangePo : arrangePoList) {
            Arrange item = new Arrange();
            BeanUtils.copyProperties(arrangePo, item);
            arrangeList.add(item);
        }
        return arrangeList;
    }

    public List<Object> getNum(){
       return arrangeDao.getNum();
    }

    /**
     * 修改预约信息
     * @param status
     * @param id
     */
    public void updateArrange(String status,Integer id){
        arrangeDao.updateArrange(status,id);
        List<ArrangePo> arrangePoList = arrangeDao.findByUsername("");
        poPageInfo = new PageInfo<>(arrangePoList);
        arrangeRedisDao.addRedisStudentList(poPageInfo);
    }

}
