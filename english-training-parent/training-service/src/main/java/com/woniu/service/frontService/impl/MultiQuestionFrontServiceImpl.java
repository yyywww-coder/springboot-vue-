package com.woniu.service.frontService.impl;

import com.woniu.adapter.frontAdapter.MultiQuestionFrontAdapter;
import com.woniu.po.MultiQuestionPo;
import com.woniu.service.frontService.MultiQuestionFrontService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MultiQuestionFrontServiceImpl implements MultiQuestionFrontService {

    @Autowired
    private MultiQuestionFrontAdapter multiQuestionFrontAdapter;

    @Override
    public List<MultiQuestionPo> findByIdAndType(Integer PaperId) {
        return multiQuestionFrontAdapter.findByIdAndType(PaperId);
    }
}
