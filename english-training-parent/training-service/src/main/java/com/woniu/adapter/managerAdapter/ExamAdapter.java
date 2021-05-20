package com.woniu.adapter.managerAdapter;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.dao.managerDao.ExamDao;
import com.woniu.domain.Exam;
import com.woniu.po.ExamPo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExamAdapter {
    @Autowired
    private ExamDao examDao;

    /**
     * 查询全部的考试
     * @return
     */
    public PageInfo<Exam> getAllExam(Integer pageIndex,Integer pageSize,String source){
        PageHelper.startPage(pageIndex,pageSize);
        List<ExamPo> examPos = examDao.getAllExam(source);
        PageInfo<ExamPo> poPageInfo = new PageInfo<>(examPos);
        PageInfo<Exam> pageInfo = new PageInfo<>();
        BeanUtils.copyProperties(poPageInfo,pageInfo);
        return pageInfo;
    }

    public void deleteByExamCode(Integer examCode){
        examDao.deleteByExamCode(examCode);
    }

    /**
     * 根据examCode获取数据
     * @param examCode
     * @return
     */
    public Exam getByExamCode(Integer examCode){
        ExamPo examPo = examDao.getByExamCode(examCode);
        Exam exam = new Exam();
        BeanUtils.copyProperties(examPo,exam);
        return exam;
    }

    public void updateExam(Exam exam){
        ExamPo examPo = new ExamPo();
        BeanUtils.copyProperties(exam,examPo);
        examDao.updateExam(examPo);

    }

    public Exam findPaperId(){
        ExamPo examPo = examDao.findOnlyPaperId();
        Exam exam = new Exam();
        BeanUtils.copyProperties(examPo,exam);
        return exam;
    }

    public void addExam(Exam exam){
        ExamPo examPo = new ExamPo();
        BeanUtils.copyProperties(exam,examPo);
        examDao.addExam(examPo);
    }
}
