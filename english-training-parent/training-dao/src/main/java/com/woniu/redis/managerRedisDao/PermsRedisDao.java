package com.woniu.redis.managerRedisDao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniu.po.PermsPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Component
@SuppressWarnings("all")
public class PermsRedisDao {

        @Autowired
        private RedisTemplate<String, String> redisTemplate;

       public List<PermsPo> list(String account){


               List<PermsPo> permsPoList = new ArrayList<>();
               BoundValueOperations<String, String> boundValueOps = redisTemplate.boundValueOps(account);
               String dataStr = boundValueOps.get();

               ObjectMapper objectMapper = new ObjectMapper();

               try {
                       if (!StringUtils.isEmpty(dataStr)){
                               System.out.println("redis~~~~~~~~~~~");
                               permsPoList = objectMapper.readValue(dataStr, new TypeReference<List<PermsPo>>() {
                               });
                       }
               }catch (Exception e){
                       e.printStackTrace();
               }
               return permsPoList;
       }

        /**
         * 更新
         * @param permsPoList
         * @param account
         */
       public void addRedisPermsPoList(List<PermsPo> permsPoList,String account){
               ObjectMapper objectMapper = new ObjectMapper();
               redisTemplate.delete(account);
               System.out.println("删除redis");
               BoundValueOperations<String, String> boundValueOps = redisTemplate.boundValueOps(account);
               try {
                       String temp = objectMapper.writeValueAsString(permsPoList);
                       //3、然后把查到的结果存到redis里面
                       boundValueOps.set(temp);
                       System.out.println("更新了redis");
               } catch (Exception exception) {  }

       }

}
