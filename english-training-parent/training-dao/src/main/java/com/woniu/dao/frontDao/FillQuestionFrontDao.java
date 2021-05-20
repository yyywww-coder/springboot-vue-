package com.woniu.dao.frontDao;

import com.woniu.po.FillQuestionPo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface FillQuestionFrontDao {

    List<FillQuestionPo> findByIdAndType(Integer PaperId);
}
