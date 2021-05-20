package com.woniu.service.frontService;

import com.github.pagehelper.PageInfo;
import com.woniu.po.ExamManagePo;

public interface ExamManageFrontService {

    public PageInfo<ExamManagePo> findExamBySource(Integer pageIndex,Integer pageSize,String source);

    public ExamManagePo findByExamCode(Integer examCode);

}
