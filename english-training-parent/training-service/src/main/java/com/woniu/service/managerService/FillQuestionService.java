package com.woniu.service.managerService;

import com.woniu.domain.FillQuestion;

import java.util.List;

public interface FillQuestionService {

    List<FillQuestion> findByIdAndType(Integer paperId);

    List<Integer> findBySubject(String subject,Integer pageNo);

    Integer add(FillQuestion fillQuestion);

    FillQuestion findOnlyQuestionId();


}
