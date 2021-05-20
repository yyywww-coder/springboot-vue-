package com.woniu.redis.managerRedisDao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.woniu.po.UserPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRedisDao {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public List<UserPo> list() {

        List<UserPo> userLists = new ArrayList<>();
        BoundValueOperations<String, String> boundValueOps = redisTemplate.boundValueOps("users");
        String dataStr = boundValueOps.get();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            if (!StringUtils.isEmpty(dataStr)) {
                System.out.println("从redis缓存中取数据");
                userLists = objectMapper.readValue(dataStr, new TypeReference<List<UserPo>>() { });
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return userLists;
    }

    //更新redis
    public void addRedisUserList(PageInfo<UserPo> pageInfo) {

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("删除redis");
        redisTemplate.delete("users");
        BoundValueOperations<String, String> boundValueOps = redisTemplate.boundValueOps("users");
        try {
            String temp = objectMapper.writeValueAsString(pageInfo);
            //3、然后把查到的结果存到redis里面
            boundValueOps.set(temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
