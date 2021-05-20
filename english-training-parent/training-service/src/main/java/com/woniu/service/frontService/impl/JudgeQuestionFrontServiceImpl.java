package com.woniu.service.frontService.impl;

import com.woniu.adapter.frontAdapter.FillQuestionFrontAdapter;
import com.woniu.adapter.frontAdapter.JudgeQuestionFrontAdapter;
import com.woniu.po.FillQuestionPo;
import com.woniu.po.JudgeQuestionPo;
import com.woniu.service.frontService.FillQuestionFrontService;
import com.woniu.service.frontService.JudgeQuestionFrontService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class JudgeQuestionFrontServiceImpl implements JudgeQuestionFrontService {

    @Autowired
    private JudgeQuestionFrontAdapter judgeQuestionFrontAdapter;

    @Override
    public List<JudgeQuestionPo> findByIdAndType(Integer PaperId) {
        return judgeQuestionFrontAdapter.findByIdAndType(PaperId);
    }
}
