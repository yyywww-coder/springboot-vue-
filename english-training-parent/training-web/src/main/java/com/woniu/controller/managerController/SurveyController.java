package com.woniu.controller.managerController;

import com.github.pagehelper.PageInfo;
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
@RequestMapping("survey")
public class SurveyController {

    @Autowired
    private SurveyManagerService surveyManagerService;

    /**
     * 所有
     * @return
     */
    @RequestMapping("/list")
    public ResponseResult<PageInfo<Survey>> findAll(Integer pageIndex, Integer pageSize, String name){
//        public ResponseResult<PageInfo<Survey>> findAll(Integer pageIndex, Integer pageSize, @RequestBody Survey survey){
        System.out.println("pageIndex"+pageIndex);
        System.out.println("pageSize"+pageSize);
//        System.out.println("survey"+survey);
        PageInfo<Survey> surveyList = null;

        surveyList = surveyManagerService.list(pageIndex,pageSize,name);


        System.out.println(surveyList);
        return new ResponseResult<PageInfo<Survey>>(surveyList);
    }

    /**
     * 添加
     */
    @RequestMapping("adds")
    public ResponseResult addOrder(@RequestBody Survey survey){

        System.out.println("进入添加方法");
        System.out.println(survey);
        int flag=surveyManagerService.add(survey);
        if(flag==1){
            return new ResponseResult(200,"删除成功");
        }else{
            return new ResponseResult(500,"删除失败");
        }
    }




    /**
     * 删除
     */
    @RequestMapping("delete")
    public ResponseResult del(Integer id){
     int flag=surveyManagerService.remove(id);
        if(flag==1){
            return new ResponseResult(200,"删除成功");
        }else{
            return new ResponseResult(500,"删除失败");
        }
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseResult update(@RequestBody Survey survey){
        System.out.println("要修改"+survey);
        int flag=surveyManagerService.update(survey);
        if(flag==1){
            return new ResponseResult(200,"删除成功");
        }else{
            return new ResponseResult(500,"删除失败");
        }
    }

}
