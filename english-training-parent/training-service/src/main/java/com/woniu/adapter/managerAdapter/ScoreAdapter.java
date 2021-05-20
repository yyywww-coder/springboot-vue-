package com.woniu.adapter.managerAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.dao.managerDao.ScoreDao;
import com.woniu.domain.Score;
import com.woniu.domain.Students;
import com.woniu.po.ManagerPo;
import com.woniu.po.ScorePo;
import com.woniu.po.StudentsPo;
import com.woniu.redis.managerRedisDao.ScoreRedisDao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ScoreAdapter {

        @Autowired
        private ScoreDao scoreDao;
        @Autowired
        private ScoreRedisDao scoreRedisDao;

        PageInfo<ScorePo> poPageInfo = null;

        /**
         * 分数列表
         * @return
         */
        public List<ScorePo> findScore(String studentId){
                return scoreDao.findById(studentId);
        }

        public List<ScorePo> findByCode(Integer examCode){
                List<ScorePo> scorePoList = scoreDao.findByCode(examCode);
                System.out.println(scorePoList);
                return scorePoList;
        }

        /**
         * 修改分数
         * @param scorePo
         */
        public void update(ScorePo scorePo){
                scoreDao.update(scorePo);
        }

        /**
         * 根据ID删除学员分数
         * @param id
         */
        public void delete(Integer id){
                scoreDao.delete(id);
        }

        /**
         * 新增
         * @param scorePo
         */
        public void add(ScorePo scorePo){
                scoreDao.add(scorePo);
        }
}
