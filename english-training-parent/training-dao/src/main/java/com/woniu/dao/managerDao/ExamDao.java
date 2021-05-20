package com.woniu.dao.managerDao;

import com.woniu.po.ExamPo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamDao {
    //查询所有的考试
    List<ExamPo> getAllExam(String source);
    //根据examCode删除数据
    void deleteByExamCode(@Param("examCode") Integer examCode);
    //根据examCode获取数据
    ExamPo getByExamCode(Integer examCode);
    //修改数据
    void updateExam(ExamPo examPo);
    //查询最后一条记录的paperId,返回给前端达到自增效果
    ExamPo findOnlyPaperId();
    //添加考试
    void addExam(ExamPo examPo);
}
