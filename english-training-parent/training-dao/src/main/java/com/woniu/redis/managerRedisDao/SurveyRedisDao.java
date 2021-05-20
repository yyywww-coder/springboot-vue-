package com.woniu.redis.managerRedisDao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.github.pagehelper.PageInfo;
import com.woniu.dao.exception.SurveyException;
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
public class SurveyRedisDao {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public List<SurveyPo> list()   {
        System.out.println("进入redis功能");
        List<SurveyPo> surveyLists = new ArrayList<>();
        BoundValueOperations<String, String> boundValueOps = redisTemplate.boundValueOps("list");
        String dataStr = boundValueOps.get();

        ObjectMapper objectMapper = new ObjectMapper();

            if (!StringUtils.isEmpty(dataStr)) {
                System.out.println("从redis缓存中取数据");
                try {
                    surveyLists = objectMapper.readValue(dataStr, new TypeReference<List<SurveyPo>>() { });
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }

            }
        return surveyLists;
    }

    //更新redis
//    public void addRedisSurveyList(List<SurveyPo> lists) {
        public void addRedisSurveyList(PageInfo<SurveyPo> pageInfo) {
        System.out.println("进入redis更新功能");
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("删除redis");
//        redisTemplate.delete("list");
        BoundValueOperations<String, String> boundValueOps = redisTemplate.boundValueOps("list");
        try {
            String temp = objectMapper.writeValueAsString(pageInfo);
            //3、然后把查到的结果存到redis里面
            boundValueOps.set(temp);
        } catch (Exception exception) {
            throw new SurveyException("redis更新失败");
        }
    }



}
