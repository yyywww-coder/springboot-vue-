package com.woniu.redis.managerRedisDao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniu.po.CoursePo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseRedisDao {

        @Autowired
        private RedisTemplate<String, String> redisTemplate;

        public List<CoursePo> list() {

                List<CoursePo> coursePoList = new ArrayList<>();
                BoundValueOperations<String, String> boundValueOps = redisTemplate.boundValueOps("course");
                String dataStr = boundValueOps.get();

                ObjectMapper objectMapper = new ObjectMapper();
                try {
                        if (!StringUtils.isEmpty(dataStr)) {
                                System.out.println("从redis缓存中取数据");
                                coursePoList = objectMapper.readValue(dataStr, new TypeReference<List<CoursePo>>() { });
                        }
                } catch (Exception ex) {  }
                return coursePoList;
        }

        //更新redis
        public void addRedisCourseList(List<CoursePo> lists) {

                ObjectMapper objectMapper = new ObjectMapper();
                BoundValueOperations<String, String> boundValueOps = redisTemplate.boundValueOps("course");
                try {
                        String temp = objectMapper.writeValueAsString(lists);
                        //3、然后把查到的结果存到redis里面
                        boundValueOps.set(temp);
                } catch (Exception exception) {  }
        }

}
