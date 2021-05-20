package com.woniu.service.frontService;

import com.woniu.po.MultiQuestionPo;

import java.util.List;

public interface MultiQuestionFrontService {

    List<MultiQuestionPo> findByIdAndType(Integer PaperId);

}
