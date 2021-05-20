package com.woniu.service.managerService.impl;

import com.woniu.adapter.managerAdapter.JudgeQuestionAdapter;
import com.woniu.domain.JudgeQuestion;
import com.woniu.service.managerService.JudgeQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JudgeQuestionServiceImpl implements JudgeQuestionService {

    @Autowired
    private JudgeQuestionAdapter judgeQuestionAdapter;

    @Override
    public List<JudgeQuestion> findByIdAndType(Integer paperId) {
        return judgeQuestionAdapter.getAll(paperId);
    }

    @Override
    public List<Integer> getBySubject(String subject, Integer pageNo) {
        return judgeQuestionAdapter.getBySubject(subject,pageNo);
    }

    @Override
    public Integer add(JudgeQuestion judgeQuestion) {
        return judgeQuestionAdapter.add(judgeQuestion);
    }

    @Override
    public JudgeQuestion findOnlyQuestionId() {
        return judgeQuestionAdapter.findByQuestion();
    }

}
