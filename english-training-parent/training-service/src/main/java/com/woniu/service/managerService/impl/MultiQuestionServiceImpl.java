package com.woniu.service.managerService.impl;

import com.woniu.adapter.managerAdapter.MultiQuestionAdapter;
import com.woniu.domain.MultiQuestion;
import com.woniu.service.managerService.MultiQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class MultiQuestionServiceImpl implements MultiQuestionService {

    @Autowired
    private MultiQuestionAdapter multiQuestionAdapter;
    @Override
    public List<MultiQuestion> findByIdAndType(Integer PaperId) {
        return multiQuestionAdapter.getAll(PaperId);
    }

    @Override
    public List<Integer> getAllSubject(String subject, Integer changeNumber) {
        return multiQuestionAdapter.getAllSubject(subject,changeNumber);
    }

    /**
     * 添加数据
     * @param multiQuestion
     * @return
     */
    @Override
    public Integer add(MultiQuestion multiQuestion) {
        return multiQuestionAdapter.add(multiQuestion);
    }

    @Override
    public MultiQuestion findOnlyQuestionId() {
        return multiQuestionAdapter.findOnlyQuestionId();
    }

}
