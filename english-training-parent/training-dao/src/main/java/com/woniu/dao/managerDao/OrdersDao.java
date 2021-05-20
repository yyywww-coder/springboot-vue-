package com.woniu.dao.managerDao;

import com.woniu.po.OrderPo;
import com.woniu.po.SurveyPo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author: ekang
 * @date: 2021/4/29 17:46
 * @description:后台订单Dao层
 */
@Repository
public interface OrdersDao {
    SurveyPo get(int id);

    List<OrderPo> list(String username);

    int count(Map<String, Object> map);

    int save(OrderPo order);

    int update(OrderPo survey);

    int remove(int id);

    int batchRemove(String[] ids);

    //条件查询
    List<OrderPo> findBycont(OrderPo order);
}
