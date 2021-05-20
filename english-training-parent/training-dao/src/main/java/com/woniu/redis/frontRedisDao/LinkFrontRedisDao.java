package com.woniu.redis.frontRedisDao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.woniu.po.LinksPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class LinkFrontRedisDao {

        @Autowired
        private RedisTemplate<String, String> redisTemplate;

        public List<LinksPo> list() {

                List<LinksPo> linksPoList = new ArrayList<>();
                BoundValueOperations<String, String> boundValueOps = redisTemplate.boundValueOps("links");
                String dataStr = boundValueOps.get();

                ObjectMapper objectMapper = new ObjectMapper();
                try {
                        if (!StringUtils.isEmpty(dataStr)) {
                                System.out.println("从redis缓存中取数据");
                                linksPoList = objectMapper.readValue(dataStr, new TypeReference<List<LinksPo>>() { });
                        }
                } catch (Exception ex) {
                        //ex.printStackTrace();
                }
                return linksPoList;
        }

        //更新redis
        public void addRedisLinkList(List<LinksPo> list) {

                ObjectMapper objectMapper = new ObjectMapper();
                BoundValueOperations<String, String> boundValueOps = redisTemplate.boundValueOps("links");
                try {
                        redisTemplate.delete("links");
                        String temp = objectMapper.writeValueAsString(list);
                        //3、然后把查到的结果存到redis里面
                        boundValueOps.set(temp);
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }
}
