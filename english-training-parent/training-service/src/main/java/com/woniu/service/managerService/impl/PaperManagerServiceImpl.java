package com.woniu.service.managerService.impl;

import com.woniu.adapter.managerAdapter.PaperManagerAdapter;
import com.woniu.domain.PaperManage;
import com.woniu.service.managerService.PaperManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PaperManagerServiceImpl implements PaperManagerService {
    @Autowired
    private PaperManagerAdapter paperManagerAdapter;
    @Override
    public Integer add(PaperManage paperManage) {
        return paperManagerAdapter.add(paperManage);
    }
}
