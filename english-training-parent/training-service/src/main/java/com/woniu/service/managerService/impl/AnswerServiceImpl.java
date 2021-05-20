package com.woniu.service.managerService.impl;

import com.github.pagehelper.PageInfo;
import com.woniu.adapter.managerAdapter.AnswerAdapter;
import com.woniu.domain.FillQuestion;
import com.woniu.po.FillQuestionPo;
import com.woniu.service.managerService.AnswerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    private AnswerAdapter answerAdapter;
    @Override
    public PageInfo<FillQuestionPo> getAllQuestion(Integer pageIndex,Integer pageSize) {
        PageInfo<FillQuestionPo> fillQuestionPoPageInfo = answerAdapter.getAllAnswer(pageIndex,pageSize);

        return fillQuestionPoPageInfo;
    }
}
