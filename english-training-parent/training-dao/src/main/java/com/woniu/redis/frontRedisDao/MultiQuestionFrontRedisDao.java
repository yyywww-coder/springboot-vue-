package com.woniu.redis.frontRedisDao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniu.po.MultiQuestionPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
@Component
public class MultiQuestionFrontRedisDao {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public List<MultiQuestionPo> list() {

        List<MultiQuestionPo> MultiquestionList = new ArrayList<>();
        BoundValueOperations<String, String> boundValueOps = redisTemplate.boundValueOps("multiQuestion");
        String dataStr = boundValueOps.get();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            if (!StringUtils.isEmpty(dataStr)) {
                System.out.println("从redis缓存中取数据");
                MultiquestionList = objectMapper.readValue(dataStr, new TypeReference<List<MultiQuestionPo>>() { });
            }
        } catch (Exception ex) {
            //ex.printStackTrace();
        }
        return MultiquestionList;
    }

    //更新redis
    public void addRedisMultiQuestionList(List<MultiQuestionPo> list) {

        ObjectMapper objectMapper = new ObjectMapper();
        BoundValueOperations<String, String> boundValueOps = redisTemplate.boundValueOps("multiQuestion");
        try {
            redisTemplate.delete("multiQuestion");
            String temp = objectMapper.writeValueAsString(list);
            //3、然后把查到的结果存到redis里面
            boundValueOps.set(temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
