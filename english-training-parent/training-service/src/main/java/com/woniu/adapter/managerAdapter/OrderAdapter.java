package com.woniu.adapter.managerAdapter;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.dao.managerDao.OrdersDao;
import com.woniu.domain.Order;
import com.woniu.po.OrderPo;
import com.woniu.redis.managerRedisDao.OrderRedisDao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderAdapter {


    @Autowired
    private OrdersDao ordersDao;

    @Autowired
    private OrderRedisDao orderRedisDao;

    /**
     * @description:查所有
     * @author:ekang
     * @date:
     */
    public PageInfo<Order> findLists(Integer a,Integer pageSize,String name) {
        PageHelper.startPage(a, pageSize);
        List<OrderPo> orderPos = ordersDao.list(name);
        ObjectMapper objectMapper = new ObjectMapper();
        PageInfo pageInfo = new PageInfo<>(orderPos);
        System.out.println("pageinfo"+pageInfo);
        if (orderPos.size() == 0) {
            //从数据库查数据
            orderPos = ordersDao.list(name);
            //存入redis的缓存中
            orderRedisDao.addRedisOrderList(orderPos);
        }
        //转换对象类型
        List<Order> orderList = new ArrayList<Order>();
        for (OrderPo orderPo : orderPos) {
            Order order = new Order();
            BeanUtils.copyProperties(orderPo, order);
            orderList.add(order);
        }
        return pageInfo;
    }

    /**
     * @description:添加
     * @author:ekang
     * @date:
     */
    public int saveSurvey(Order order) {
        OrderPo orderPo = new OrderPo();
        //转换对象
        BeanUtils.copyProperties(order, orderPo);
        int flag = ordersDao.save(orderPo);

//        if (surveyPos.size() == 0) {
//            //清空redis
//
//            //从数据库查数据
//            surveyPos = surveyDao.list();
//            //存入redis的缓存中
//            surveyRedisDao.addRedisSurveyList(surveyPos);
//        }

        return flag;
    }


    /**
     * @description:修改
     * @author:ekang
     * @date:
     */
    public int updateSurvey(Order order) {
        OrderPo orderPo = new OrderPo();
        //转换对象
        BeanUtils.copyProperties(order, orderPo);
        int flag = ordersDao.update(orderPo);
        //redis数据处理
//        if (surveyPos.size() == 0) {
//            //从数据库查数据
//            surveyPos = surveyDao.list();
//            //存入redis的缓存中
//            surveyRedisDao.addRedisSurveyList(surveyPos);
//        }
        //转换对象类型

        return flag;
    }

    /**
     * @description:移除方法
     * @author:ekang
     * @date:
     */
    public int remove(int id) {
        return ordersDao.remove(id);
    }


}
