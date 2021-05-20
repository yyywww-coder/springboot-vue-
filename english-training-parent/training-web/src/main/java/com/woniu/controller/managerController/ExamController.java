package com.woniu.controller.managerController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.domain.Exam;
import com.woniu.service.managerService.ExamService;
import com.woniu.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("exam")
public class ExamController {
    @Autowired
    private ExamService examService;
    @RequestMapping("list/{pageIndex}/{pageSize}")
    public ResponseResult<PageInfo<Exam>> getExam(@PathVariable("pageIndex") Integer pageIndex,@PathVariable("pageSize") Integer pageSize,@RequestParam("searchName") String searchName){
        PageInfo<Exam> pageInfo = examService.getAllExam(pageIndex,pageSize,searchName);
        return new ResponseResult<>(pageInfo);
    }

    @DeleteMapping("delete/{examCode}")
    public ResponseResult deleteByExamCode(@PathVariable("examCode")Integer examCode){
        examService.deleteByExamCode(examCode);
        return ResponseResult.SUCCESS;
    }

    @RequestMapping("beforeUpdate/{examCode}")
    public ResponseResult<Exam> getByExamCode(@PathVariable("examCode") Integer examCode){
        Exam exam = examService.getByExamCode(examCode);
        return new ResponseResult<>(exam);
    }
    @RequestMapping("update")
    public ResponseResult updateExam(Exam exam){
        examService.updateExam(exam);
        return ResponseResult.SUCCESS;
    }
    @RequestMapping("paperId")
    public ResponseResult<Exam> findPaperId(){
        Exam exam = examService.findPaperId();
        return new ResponseResult<>(exam);
    }
    @RequestMapping("addexam")
    public ResponseResult addExam(@RequestBody Exam exam){
        examService.addExam(exam);
        return ResponseResult.SUCCESS;
    }

    @RequestMapping("exams/{pageIndex}/{pageSize}")
    public ResponseResult<PageInfo<Exam>> getAllExam(@PathVariable("pageIndex") Integer pageIndex,@PathVariable("pageSize") Integer pageSize,@RequestParam("searchName") String searchName){
        PageInfo<Exam> pageInfo = examService.getAllExam(pageIndex,pageSize,searchName);
        return new ResponseResult<>(pageInfo);
    }

    @RequestMapping("/findAll")
    public ResponseResult<PageInfo<Exam>> findAll(String source,Integer pageIndex,Integer pageSize){
        PageInfo<Exam> pageInfo = examService.getAllExam(pageIndex, pageSize, source);

        return new ResponseResult<>(pageInfo);
    }


}
