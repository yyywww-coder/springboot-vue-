package com.woniu.redis.frontRedisDao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniu.po.FillQuestionPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
@Component
public class FillQuestionFrontRedisDao {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public List<FillQuestionPo> list() {

        List<FillQuestionPo> FillQuestionList = new ArrayList<>();
        BoundValueOperations<String, String> boundValueOps = redisTemplate.boundValueOps("fillQuestion");
        String dataStr = boundValueOps.get();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            if (!StringUtils.isEmpty(dataStr)) {
                System.out.println("从redis缓存中取数据");
                FillQuestionList = objectMapper.readValue(dataStr, new TypeReference<List<FillQuestionPo>>() { });
            }
        } catch (Exception ex) {
            //ex.printStackTrace();
        }
        return FillQuestionList;
    }

    //更新redis
    public void addRedisFillQuestionList(List<FillQuestionPo> list) {

        ObjectMapper objectMapper = new ObjectMapper();
        BoundValueOperations<String, String> boundValueOps = redisTemplate.boundValueOps("fillQuestion");
        try {
            redisTemplate.delete("fillQuestion");
            String temp = objectMapper.writeValueAsString(list);
            //3、然后把查到的结果存到redis里面
            boundValueOps.set(temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
