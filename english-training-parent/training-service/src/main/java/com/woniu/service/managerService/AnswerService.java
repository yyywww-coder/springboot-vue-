package com.woniu.service.managerService;

import com.github.pagehelper.PageInfo;
import com.woniu.po.FillQuestionPo;

import java.util.List;

public interface AnswerService {
    PageInfo<FillQuestionPo> getAllQuestion(Integer pageIndex, Integer pageSize);
}
