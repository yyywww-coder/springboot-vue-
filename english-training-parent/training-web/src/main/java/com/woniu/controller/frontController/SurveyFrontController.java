package com.woniu.controller.frontController;


import com.woniu.domain.Survey;
import com.woniu.service.managerService.SurveyManagerService;
import com.woniu.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("front/survey")
public class SurveyFrontController {

    @Autowired
    private SurveyManagerService surveyManagerService;

    /**
     * 添加
     */
    @RequestMapping("adds")
    public ResponseResult addSurvey(@RequestBody Survey survey){

        System.out.println("进入添加方法");

        System.out.println(survey);
        int flag=surveyManagerService.add(survey);
        if(flag==1){
            return new ResponseResult(200,"评论添加成功");
        }else{
            return new ResponseResult(500,"评论添加失败");
        }
    }

}
