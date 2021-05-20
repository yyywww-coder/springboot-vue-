package com.woniu.service.managerService;

import com.github.pagehelper.PageInfo;
import com.woniu.domain.Score;
import com.woniu.po.ScorePo;

import java.util.List;

public interface ScoreService {

        //查询所有阶段分数
        public List<ScorePo> findById(String studentId);

        public List<ScorePo> findByCode(Integer examCode);

        //更改阶段分数
        public void update(ScorePo scorePo);

        //删除阶段分数
        public void delete(Integer id);

        //添加分数
        public void add(ScorePo scorePo);
}
