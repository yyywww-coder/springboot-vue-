package com.woniu.service.frontService.impl;

import com.github.pagehelper.PageInfo;
import com.woniu.adapter.frontAdapter.ExamManageFrontAdapter;
import com.woniu.po.ExamManagePo;
import com.woniu.service.frontService.ExamManageFrontService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.ExecutorService;

@Service
@Transactional
public class ExamManageFrontServiceImpl implements ExamManageFrontService {

    @Autowired
    private ExamManageFrontAdapter examManageFrontAdapter;

    @Override
    public ExamManagePo findByExamCode(Integer examCode) {
        return examManageFrontAdapter.findByExamCode(examCode);
    }

    @Override
    public PageInfo<ExamManagePo> findExamBySource(Integer pageIndex, Integer pageSize, String source) {
        return examManageFrontAdapter.findExamBySource(pageIndex, pageSize, source);
    }
}
