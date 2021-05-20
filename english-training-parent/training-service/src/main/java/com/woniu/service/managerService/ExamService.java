package com.woniu.service.managerService;

import com.github.pagehelper.PageInfo;
import com.woniu.domain.Exam;

import java.util.List;

public interface ExamService {
    public PageInfo<Exam> getAllExam(Integer pageIndex, Integer pageSize,String source);

    public void deleteByExamCode(Integer examCode);

    public Exam getByExamCode(Integer examCode);

    public void updateExam(Exam exam);

    public Exam findPaperId();

    public void addExam(Exam exam);
}
