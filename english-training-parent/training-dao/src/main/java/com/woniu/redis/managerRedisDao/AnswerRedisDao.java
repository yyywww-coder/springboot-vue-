package com.woniu.redis.managerRedisDao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.woniu.po.ArrangePo;
import com.woniu.po.FillQuestionPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AnswerRedisDao {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public List<FillQuestionPo> list(){

        List<FillQuestionPo> fillQuestionPos = new ArrayList<>();
        BoundValueOperations<String, String> boundValueOps = redisTemplate.boundValueOps("questions");
        String dataStr = boundValueOps.get();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            if (!StringUtils.isEmpty(dataStr)) {
                System.out.println("从redis缓存中取数据");
                fillQuestionPos = objectMapper.readValue(dataStr, new TypeReference<List<FillQuestionPo>>() { });
            }
        } catch (Exception ex) {
            //ex.printStackTrace();
        }
        return fillQuestionPos;
    }

    //更新redis
    public void addRedisAnswerList(PageInfo<FillQuestionPo> pageInfo) {

        ObjectMapper objectMapper = new ObjectMapper();
        BoundValueOperations<String, String> boundValueOps = redisTemplate.boundValueOps("questions");
        try {
            redisTemplate.delete("questions");
            String temp = objectMapper.writeValueAsString(pageInfo);
            //3、然后把查到的结果存到redis里面
            boundValueOps.set(temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
