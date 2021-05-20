package com.woniu.service.managerService;


import com.woniu.domain.JudgeQuestion;

import java.util.List;

public interface JudgeQuestionService {

    List<JudgeQuestion> findByIdAndType(Integer paperId);

    List<Integer> getBySubject(String subject,Integer pageNo);

    Integer add(JudgeQuestion judgeQuestion);

    JudgeQuestion findOnlyQuestionId();

}
