package com.woniu.service.managerService.impl;

import com.github.pagehelper.PageInfo;
import com.woniu.adapter.managerAdapter.ExamAdapter;
import com.woniu.domain.Exam;
import com.woniu.service.managerService.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ExamServiceImpl implements ExamService {
    @Autowired
    private ExamAdapter examAdapter;
    @Override
    public PageInfo<Exam> getAllExam(Integer pageIndex, Integer pageSize,String source) {
        PageInfo<Exam> pageInfo = examAdapter.getAllExam(pageIndex,pageSize,source);
        return pageInfo;
    }

    @Override
    public void deleteByExamCode(Integer examCode) {
        examAdapter.deleteByExamCode(examCode);
    }

    @Override
    public Exam getByExamCode(Integer examCode) {
        return examAdapter.getByExamCode(examCode);
    }

    @Override
    public void updateExam(Exam exam) {
        examAdapter.updateExam(exam);
    }

    @Override
    public Exam findPaperId() {
        return examAdapter.findPaperId();
    }

    @Override
    public void addExam(Exam exam) {
        examAdapter.addExam(exam);
    }
}
