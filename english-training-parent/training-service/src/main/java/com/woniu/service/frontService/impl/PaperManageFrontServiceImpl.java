package com.woniu.service.frontService.impl;

import com.github.pagehelper.PageInfo;
import com.woniu.adapter.frontAdapter.ExamManageFrontAdapter;
import com.woniu.adapter.frontAdapter.PaperManageFrontAdapter;
import com.woniu.po.ExamManagePo;
import com.woniu.po.PaperManagePo;
import com.woniu.service.frontService.ExamManageFrontService;
import com.woniu.service.frontService.PaperManageFrontService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PaperManageFrontServiceImpl implements PaperManageFrontService {

    @Autowired
    private PaperManageFrontAdapter paperManageFrontAdapter;

    @Override
    public PaperManagePo findById(Integer paperId) {
        return paperManageFrontAdapter.findById(paperId);
    }
}
