package com.woniu.service.frontService;

import com.github.pagehelper.PageInfo;
import com.woniu.po.ExamManagePo;
import com.woniu.po.ScorePo;

public interface ScoreFrontService {

   public void add(ScorePo scorePo);

   public PageInfo<ScorePo> findById(Integer pageIndex,Integer pageSize,Integer id);

}
