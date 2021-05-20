package com.woniu.redis.managerRedisDao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.woniu.po.ScorePo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class ScoreRedisDao {

        @Autowired
        private RedisTemplate<String, String> redisTemplate;

        public List<ScorePo> list() {

                List<ScorePo> scorePoList = new ArrayList<>();
                BoundValueOperations<String, String> boundValueOps = redisTemplate.boundValueOps("scores");
                String dataStr = boundValueOps.get();

                ObjectMapper objectMapper = new ObjectMapper();
                try {
                        if (!StringUtils.isEmpty(dataStr)) {
                                System.out.println("从redis缓存中取数据");
                                scorePoList = objectMapper.readValue(dataStr, new TypeReference<List<ScorePo>>() { });
                        }
                } catch (Exception ex) {  }
                return scorePoList;
        }

        //更新redis
        public void addRedisScoreList(PageInfo<ScorePo> poPageInfo) {

                ObjectMapper objectMapper = new ObjectMapper();
                BoundValueOperations<String, String> boundValueOps = redisTemplate.boundValueOps("scores");
                try {
                        String temp = objectMapper.writeValueAsString(poPageInfo);
                        //3、然后把查到的结果存到redis里面
                        boundValueOps.set(temp);
                } catch (Exception exception) {  }
        }
}
