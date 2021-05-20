package com.woniu.service.managerService.impl;

import com.woniu.adapter.managerAdapter.ScoreAdapter;
import com.woniu.domain.Score;
import com.woniu.exception.ManagerException;
import com.woniu.po.ScorePo;
import com.woniu.service.managerService.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ScoreServiceImpl implements ScoreService {
        
        @Autowired
        private ScoreAdapter scoreAdapter;

        @Override
        public List<ScorePo> findByCode(Integer examCode) {
                return scoreAdapter.findByCode(examCode);
        }

        /**
         * 分数列表
         * @return
         */
        @Override
        public List<ScorePo> findById(String studentId) {
                return scoreAdapter.findScore(studentId);
        }

        /**
         * '修改分数
         * @param scorePo
         */
        @Override
        public void update(ScorePo scorePo) {
                scoreAdapter.update(scorePo);
        }

        /**
         * 根据ID删除
         * @param id
         */
        @Override
        public void delete(Integer id) {
                scoreAdapter.delete(id);
        }


        /**
         * 新增分数
         * @param scorePo
         */
        @Override
        public void add(ScorePo scorePo) {
                scoreAdapter.add(scorePo);
        }
}
