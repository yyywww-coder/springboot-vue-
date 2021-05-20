package com.woniu.service.managerService.impl;

import com.github.pagehelper.PageInfo;
import com.woniu.adapter.managerAdapter.ContentAdapter;
import com.woniu.po.ContentPo;
import com.woniu.service.managerService.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentAdapter contentAdapter;

    @Override
    public PageInfo<ContentPo> findAll(Integer pageIndex, Integer pageSize) {
        return contentAdapter.findAll(pageIndex,pageSize);
    }
}
