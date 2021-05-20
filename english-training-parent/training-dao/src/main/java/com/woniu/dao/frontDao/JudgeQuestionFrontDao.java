package com.woniu.dao.frontDao;

import com.woniu.po.FillQuestionPo;
import com.woniu.po.JudgeQuestionPo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface JudgeQuestionFrontDao {

    List<JudgeQuestionPo> findByIdAndType(Integer PaperId);

}
