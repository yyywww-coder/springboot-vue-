package com.woniu.service.frontService;

import com.woniu.po.FillQuestionPo;

import java.util.List;

public interface FillQuestionFrontService {

    List<FillQuestionPo> findByIdAndType(Integer PaperId);

}
