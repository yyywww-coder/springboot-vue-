package com.woniu.service.managerService.impl;

import com.github.pagehelper.PageInfo;
import com.woniu.adapter.managerAdapter.OrderAdapter;
import com.woniu.adapter.managerAdapter.SurveyAdapter;
import com.woniu.domain.Order;
import com.woniu.domain.Survey;
import com.woniu.service.managerService.ManagerService;
import com.woniu.service.managerService.OrderManagerService;
import com.woniu.service.managerService.SurveyManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderManagerServiceImpl implements OrderManagerService {

    @Autowired
    private OrderAdapter orderAdapter;

    /**
     * @description:添加评论功能
     * @author:ekang
     * @date:
     */
    public int add(Order order) {
        return orderAdapter.saveSurvey(order);
    }

    /**
     * @description:移除功能
     * @author:ekang
     * @date:
     */
    @Override
    public int remove(int id) {
        return orderAdapter.remove(id);
    }

    /**
     * @description:获得评论列表
     * @author:ekang
     * @date:
     */

    public PageInfo<Order> list(Integer a, Integer pageSize,String name) {
        return orderAdapter.findLists(a,pageSize,name);
    }

    /**
     * @description:修改功能
     * @author:ekang
     * @date:
     */
    public int update(Order order) {
        return orderAdapter.updateSurvey(order);
    }
}
