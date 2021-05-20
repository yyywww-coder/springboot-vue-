package com.woniu.redis.frontRedisDao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.woniu.po.ExamManagePo;
import com.woniu.po.ScorePo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
@Component
public class ScoreFrontRedisDao {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public List<ScorePo> list() {

        List<ScorePo> ScorePoList = new ArrayList<>();
        BoundValueOperations<String, String> boundValueOps = redisTemplate.boundValueOps("score");
        String dataStr = boundValueOps.get();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            if (!StringUtils.isEmpty(dataStr)) {
                System.out.println("从redis缓存中取数据");
                ScorePoList = objectMapper.readValue(dataStr, new TypeReference<List<ScorePo>>() { });
            }
        } catch (Exception ex) {
            //ex.printStackTrace();
        }
        return ScorePoList;
    }

    //更新redis
    public void addRedisScoreList(PageInfo<ScorePo> pageInfo) {

        ObjectMapper objectMapper = new ObjectMapper();
        BoundValueOperations<String, String> boundValueOps = redisTemplate.boundValueOps("score");
        try {
            redisTemplate.delete("score");
            String temp = objectMapper.writeValueAsString(pageInfo);
            //3、然后把查到的结果存到redis里面
            boundValueOps.set(temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
