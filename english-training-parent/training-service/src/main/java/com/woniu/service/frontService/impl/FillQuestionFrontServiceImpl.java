package com.woniu.service.frontService.impl;

import com.woniu.adapter.frontAdapter.FillQuestionFrontAdapter;
import com.woniu.po.FillQuestionPo;
import com.woniu.service.frontService.FillQuestionFrontService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FillQuestionFrontServiceImpl implements FillQuestionFrontService {

    @Autowired
    private FillQuestionFrontAdapter fillQuestionFrontAdapter;

    @Override
    public List<FillQuestionPo> findByIdAndType(Integer PaperId) {
        return fillQuestionFrontAdapter.findByIdAndType(PaperId);
    }
}
