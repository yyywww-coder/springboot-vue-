package com.woniu.redis.managerRedisDao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.woniu.po.StudentsPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentsRedisDao {

        @Autowired
        private RedisTemplate<String, String> redisTemplate;

        public List<StudentsPo> list() {

                List<StudentsPo> studentsPoList = new ArrayList<>();
                BoundValueOperations<String, String> boundValueOps = redisTemplate.boundValueOps("students");
                String dataStr = boundValueOps.get();

                ObjectMapper objectMapper = new ObjectMapper();
                try {
                        if (!StringUtils.isEmpty(dataStr)) {
                                System.out.println("从redis缓存中取数据");
                                studentsPoList = objectMapper.readValue(dataStr, new TypeReference<List<StudentsPo>>() { });
                        }
                } catch (Exception ex) {
                        //ex.printStackTrace();
                }
                return studentsPoList;
        }

        //更新redis
        public void addRedisStudentList(PageInfo<StudentsPo> pageInfo) {

                ObjectMapper objectMapper = new ObjectMapper();
                BoundValueOperations<String, String> boundValueOps = redisTemplate.boundValueOps("students");
                try {
                        redisTemplate.delete("students");
                        String temp = objectMapper.writeValueAsString(pageInfo);
                        //3、然后把查到的结果存到redis里面
                        boundValueOps.set(temp);
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }
}
