package com.woniu.redis.managerRedisDao;

import com.alibaba.druid.util.StringUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.woniu.po.ContentPo;
import com.woniu.po.ManagerPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContentRedisDao {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public List<ContentPo> list(){
        List<ContentPo> contentPoList = new ArrayList<>();
        BoundValueOperations<String, String> boundValueOps = redisTemplate.boundValueOps("Content");
        String dataStr = boundValueOps.get();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            if (!StringUtils.isEmpty(dataStr)){
                System.out.println("redis~~~~~~~~~~~");
                /*redisTemplate.delete("list");*/
                System.out.println("删除redis--------------------");
                contentPoList = objectMapper.readValue(dataStr, new TypeReference<List<ContentPo>>() {
                });
            }
        }catch (Exception e){

        }
        return contentPoList;
    }

    public void addRedisContentList(PageInfo<ContentPo> poPageInfo){
        ObjectMapper objectMapper = new ObjectMapper();
        redisTemplate.delete("Content");
        BoundValueOperations<String, String> boundValueOps = redisTemplate.boundValueOps("Content");
        try {
            String temp = objectMapper.writeValueAsString(poPageInfo);

            //3、然后把查到的结果存到redis里面
            boundValueOps.set(temp);
            System.out.println("更新了redis---------------------");
        } catch (Exception exception) {

        }

    }


}
