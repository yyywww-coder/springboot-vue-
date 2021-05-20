package com.woniu.service.managerService;

import com.github.pagehelper.PageInfo;
import com.woniu.domain.Arrange;
import com.woniu.po.ArrangePo;

import java.util.List;

public interface ArrangeService {
    //模糊查询
    public PageInfo<ArrangePo> findByUsername(Integer pageIndex, Integer pageSize, String username);

    //新增预约
    void addArrange(ArrangePo arrange);

    public List<Arrange> getCourse();

    public List<Object> getNum();

    public void updateArrange(String status,Integer id);
}
