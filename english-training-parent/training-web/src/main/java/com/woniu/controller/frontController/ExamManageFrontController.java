package com.woniu.controller.frontController;

import com.github.pagehelper.PageInfo;
import com.woniu.domain.ExamManage;
import com.woniu.po.ExamManagePo;
import com.woniu.service.frontService.ExamManageFrontService;
import com.woniu.utils.ResponseResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("front/exam")
public class ExamManageFrontController {

    @Autowired
    private ExamManageFrontService examManageFrontService;

    @RequestMapping("/list")
    public ResponseResult<PageInfo<ExamManage>> findExamBySource(Integer pageIndex, Integer pageSize, String source){
        PageInfo<ExamManagePo> examManagePoPageInfo = examManageFrontService.findExamBySource(pageIndex, pageSize, source);
        PageInfo<ExamManage> poPageInfo = new PageInfo<>();
        BeanUtils.copyProperties(examManagePoPageInfo,poPageInfo);
        return new ResponseResult<>(poPageInfo);
    }

    @RequestMapping("/examCode")
    public ResponseResult findByExamCode(Integer examCode){
        ExamManagePo examManagePo = examManageFrontService.findByExamCode(examCode);
        ExamManage examManage = new ExamManage();
        BeanUtils.copyProperties(examManagePo,examManage);
        return new ResponseResult(examManage);
    }
    
}
