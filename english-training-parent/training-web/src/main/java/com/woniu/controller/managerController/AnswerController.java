package com.woniu.controller.managerController;

import com.github.pagehelper.PageInfo;
import com.woniu.domain.FillQuestion;
import com.woniu.po.FillQuestionPo;
import com.woniu.service.managerService.AnswerService;
import com.woniu.utils.ResponseResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("question")
public class AnswerController {
    @Autowired
    private AnswerService answerService;
    @RequestMapping("list/{pageIndex}/{pageSize}")
    public ResponseResult<PageInfo<FillQuestion>> getAllQuestion(@PathVariable("pageIndex") Integer pageIndex, @PathVariable("pageSize") Integer pageSize){
        PageInfo<FillQuestionPo> allQuestion = answerService.getAllQuestion(pageIndex, pageSize);
        PageInfo<FillQuestion> fillQuestionPageInfo = new PageInfo<>();
        BeanUtils.copyProperties(allQuestion,fillQuestionPageInfo);
        return new ResponseResult<>(fillQuestionPageInfo);
    }
}
