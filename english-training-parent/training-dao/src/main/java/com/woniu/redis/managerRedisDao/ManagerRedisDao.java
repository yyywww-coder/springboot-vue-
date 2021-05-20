package com.woniu.redis.managerRedisDao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.woniu.po.ManagerPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class  ManagerRedisDao {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    public List<ManagerPo> list() {

        List<ManagerPo> managerList = new ArrayList<>();
        BoundValueOperations<String, String> boundValueOps = redisTemplate.boundValueOps("list");
        String dataStr = boundValueOps.get();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            if (!StringUtils.isEmpty(dataStr)){
                System.out.println("redis~~~~~~~~~~~");
                managerList = objectMapper.readValue(dataStr, new TypeReference<List<ManagerPo>>(){});
            }
        }catch (Exception e){
        }
        return managerList;
    }

    //更新redis
    public void addRedisManagerList(PageInfo<ManagerPo> poPageInfo){

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("删除redis");
        redisTemplate.delete("list");
        BoundValueOperations<String, String> boundValueOps = redisTemplate.boundValueOps("list");
        try {
            String temp = objectMapper.writeValueAsString(poPageInfo);
            //3、然后把查到的结果存到redis里面
            boundValueOps.set(temp);
            System.out.println("更新了redis---------------------");
        } catch (Exception exception) {

        }
    }

}

