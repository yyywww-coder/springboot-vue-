package com.woniu.controller.frontController;

import com.github.pagehelper.PageInfo;
import com.woniu.domain.ExamManage;
import com.woniu.domain.Score;
import com.woniu.po.ExamManagePo;
import com.woniu.po.ScorePo;
import com.woniu.service.frontService.ExamManageFrontService;
import com.woniu.service.frontService.ScoreFrontService;
import com.woniu.service.managerService.ScoreService;
import com.woniu.utils.ResponseResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.PublicKey;

@RestController
@CrossOrigin
@RequestMapping("front/score")
public class ScoreFrontController {

    @Autowired
    private ScoreFrontService scoreFrontService;

    @RequestMapping("/add")
    public ResponseResult add(@RequestBody ScorePo scorePo){
        scoreFrontService.add(scorePo);
        return ResponseResult.SUCCESS;
    }

    @RequestMapping("/find")
    public ResponseResult<PageInfo<Score>> findById(Integer pageIndex,Integer pageSize,Integer studentId){
        PageInfo<ScorePo> poPageInfo = scoreFrontService.findById(pageIndex, pageSize, studentId);
        PageInfo<Score> pageInfo = new PageInfo<>();
        BeanUtils.copyProperties(poPageInfo,pageInfo);
        return new ResponseResult<>(pageInfo);
    }


}
