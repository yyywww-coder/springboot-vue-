package com.woniu.service.managerService.impl;

import com.woniu.adapter.managerAdapter.FillQuestionAdapter;
import com.woniu.domain.FillQuestion;
import com.woniu.service.managerService.FillQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FillQuestionServiceImpl implements FillQuestionService {

    @Autowired
    private FillQuestionAdapter fillQuestionAdapter;

    @Override
    public List<FillQuestion> findByIdAndType(Integer paperId) {
        return fillQuestionAdapter.getAll(paperId);
    }

    @Override
    public List<Integer> findBySubject(String subject, Integer pageNo) {
        return fillQuestionAdapter.getBySubject(subject,pageNo);
    }

    @Override
    public Integer add(FillQuestion fillQuestion) {
        return fillQuestionAdapter.add(fillQuestion);
    }

    @Override
    public FillQuestion findOnlyQuestionId() {
        return fillQuestionAdapter.findOnlyQuestionId();
    }

}
