package com.woniu.service.frontService;

import com.woniu.po.FillQuestionPo;
import com.woniu.po.JudgeQuestionPo;

import java.util.List;

public interface JudgeQuestionFrontService {

    List<JudgeQuestionPo> findByIdAndType(Integer PaperId);

}
