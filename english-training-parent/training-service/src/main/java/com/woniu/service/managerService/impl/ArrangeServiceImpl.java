package com.woniu.service.managerService.impl;

import com.github.pagehelper.PageInfo;
import com.woniu.adapter.managerAdapter.ArrangeAdapter;
import com.woniu.domain.Arrange;
import com.woniu.po.ArrangePo;
import com.woniu.service.managerService.ArrangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ArrangeServiceImpl implements ArrangeService {

    @Autowired
    ArrangeAdapter arrangeAdapter;

    @Override
    public List<Arrange> getCourse() {
        return arrangeAdapter.getCourse();
    }

    @Override
    public List<Object> getNum() {
        return arrangeAdapter.getNum();
    }

    @Override
    public void updateArrange(String status, Integer id) {
        arrangeAdapter.updateArrange(status,id);
    }

    @Override
    public PageInfo<ArrangePo> findByUsername(Integer pageIndex, Integer pageSize, String username) {
        return arrangeAdapter.findByUsername(pageIndex,pageSize,username);
    }

    @Override
    public void addArrange(ArrangePo arrange) {
        arrangeAdapter.addArrange(arrange);
    }
}
