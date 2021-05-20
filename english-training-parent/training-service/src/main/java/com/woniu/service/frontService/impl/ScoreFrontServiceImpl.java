package com.woniu.service.frontService.impl;

import com.github.pagehelper.PageInfo;
import com.woniu.adapter.frontAdapter.ExamManageFrontAdapter;
import com.woniu.adapter.frontAdapter.ScoreFrontAdapter;
import com.woniu.adapter.managerAdapter.ScoreAdapter;
import com.woniu.po.ExamManagePo;
import com.woniu.po.ScorePo;
import com.woniu.service.frontService.ExamManageFrontService;
import com.woniu.service.frontService.ScoreFrontService;
import com.woniu.service.managerService.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ScoreFrontServiceImpl implements ScoreFrontService {

    @Autowired
    private ScoreFrontAdapter scoreFrontAdapter;

    @Override
    public PageInfo<ScorePo> findById(Integer pageIndex, Integer pageSize, Integer id) {
        return scoreFrontAdapter.findById(pageIndex,pageSize,id);
    }

    @Override
    public void add(ScorePo scorePo) {
        scoreFrontAdapter.add(scorePo);
    }
}
