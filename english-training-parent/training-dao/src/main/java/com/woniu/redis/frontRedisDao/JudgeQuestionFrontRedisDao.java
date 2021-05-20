package com.woniu.redis.frontRedisDao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniu.po.FillQuestionPo;
import com.woniu.po.JudgeQuestionPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
@Component
public class JudgeQuestionFrontRedisDao {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public List<JudgeQuestionPo> list() {

        List<JudgeQuestionPo> JudgeQuestionList = new ArrayList<>();
        BoundValueOperations<String, String> boundValueOps = redisTemplate.boundValueOps("judgeQuestion");
        String dataStr = boundValueOps.get();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            if (!StringUtils.isEmpty(dataStr)) {
                System.out.println("从redis缓存中取数据");
                JudgeQuestionList = objectMapper.readValue(dataStr, new TypeReference<List<JudgeQuestionPo>>() { });
            }
        } catch (Exception ex) {
            //ex.printStackTrace();
        }
        return JudgeQuestionList;
    }

    //更新redis
    public void addRedisFillQuestionList(List<JudgeQuestionPo> list) {

        ObjectMapper objectMapper = new ObjectMapper();
        BoundValueOperations<String, String> boundValueOps = redisTemplate.boundValueOps("judgeQuestion");
        try {
            redisTemplate.delete("judgeQuestion");
            String temp = objectMapper.writeValueAsString(list);
            //3、然后把查到的结果存到redis里面
            boundValueOps.set(temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
