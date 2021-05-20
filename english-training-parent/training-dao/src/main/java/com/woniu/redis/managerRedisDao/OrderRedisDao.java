package com.woniu.redis.managerRedisDao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.woniu.dao.exception.OrderException;
import com.woniu.po.OrderPo;
import com.woniu.po.SurveyPo;
import com.woniu.po.UserPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderRedisDao {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public List<OrderPo> list() {

        List<OrderPo> orderLists = new ArrayList<>();
        BoundValueOperations<String, String> boundValueOps = redisTemplate.boundValueOps("list");
        String dataStr = boundValueOps.get();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            if (!StringUtils.isEmpty(dataStr)) {
                System.out.println("从redis缓存中取数据");
                orderLists = objectMapper.readValue(dataStr, new TypeReference<List<OrderPo>>() { });
            }
        } catch (Exception ex) {
            throw new OrderException("redis查找不到数据");
        }
        return orderLists;
    }

    //更新redis
    public void addRedisOrderList(List<OrderPo> lists) {

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("删除redis");
        redisTemplate.delete("list");
        BoundValueOperations<String, String> boundValueOps = redisTemplate.boundValueOps("list");
        try {
            String temp = objectMapper.writeValueAsString(lists);
            //3、然后把查到的结果存到redis里面
            boundValueOps.set(temp);
        } catch (Exception exception) {
            throw new OrderException("redis更新失败");
        }
    }



}
