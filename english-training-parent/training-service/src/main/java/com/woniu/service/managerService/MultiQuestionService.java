package com.woniu.service.managerService;


import com.woniu.domain.MultiQuestion;

import java.util.List;

public interface MultiQuestionService {

    List<MultiQuestion> findByIdAndType(Integer PaperId);


    List<Integer> getAllSubject(String subject,Integer changeNumber);

    Integer add(MultiQuestion multiQuestion);

    MultiQuestion findOnlyQuestionId();

}
