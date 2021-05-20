package com.woniu.service.managerService;

import com.github.pagehelper.PageInfo;
import com.woniu.domain.Order;
import com.woniu.domain.Survey;

import java.util.List;

/**
 * ClassName: SurveyManagerService <br/>
 * Description: <br/>
 * date: 2021/4/29 20:04<br/>
 *
 * @author hasee<br />
 */

public interface OrderManagerService {

    int update(Order order);
     PageInfo<Order> list(Integer a, Integer pageSize,String name);
    int remove(int id);
    int add(Order order);
}
