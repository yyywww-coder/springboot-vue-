package com.woniu.dao.managerDao;

import com.woniu.po.JudgeQuestionPo;
import org.apache.ibatis.annotations.Param;

import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface JudgeQuestionDao {
    List<JudgeQuestionPo> getJudgeQuestions(Integer paperId);


    List<Integer> getBySubject(@Param("subject") String subject, @Param("pageNo") Integer pageNo);

    Integer add(JudgeQuestionPo judgeQuestionPo);

    JudgeQuestionPo findOnlyQuestionId();

}
