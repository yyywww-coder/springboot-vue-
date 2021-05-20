package com.woniu.service.managerService;

import com.github.pagehelper.PageInfo;
import com.woniu.po.ContentPo;
import com.woniu.po.ManagerPo;

public interface ContentService {

    //查询所有
    public PageInfo<ContentPo> findAll(Integer pageIndex, Integer pageSize);
}
