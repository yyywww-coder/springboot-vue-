package com.woniu.service.frontService;

import com.github.pagehelper.PageInfo;
import com.woniu.po.ExamManagePo;
import com.woniu.po.PaperManagePo;

import java.util.List;

public interface PaperManageFrontService {

    public PaperManagePo findById(Integer paperId);

}
