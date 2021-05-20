package com.woniu.dao.managerDao;

import com.woniu.po.ScorePo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ScoreDao {

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
