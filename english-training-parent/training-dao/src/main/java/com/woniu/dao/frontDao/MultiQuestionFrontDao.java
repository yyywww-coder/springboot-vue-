package com.woniu.dao.frontDao;

import com.woniu.po.MultiQuestionPo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MultiQuestionFrontDao {

    List<MultiQuestionPo> findByIdAndType(Integer PaperId);
}
