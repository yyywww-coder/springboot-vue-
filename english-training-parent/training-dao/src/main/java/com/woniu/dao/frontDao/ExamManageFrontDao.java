package com.woniu.dao.frontDao;

import com.woniu.po.ExamManagePo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ExamManageFrontDao {

    public List<ExamManagePo> findExamByCode(String source);

    public ExamManagePo findByExamCode(Integer examCode);

}
