package com.woniu.dao.managerDao;

import com.woniu.po.FillQuestionPo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerDao {
    public List<FillQuestionPo> getAllQuestion();
}
