package com.woniu.controller.managerController;

import com.woniu.domain.JudgeQuestion;
import com.woniu.service.managerService.JudgeQuestionService;
import com.woniu.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("judgeQuestion")
public class JudgeQuestionController {
    @Autowired
    private JudgeQuestionService judgeQuestionService;

    @RequestMapping("JudgeQuestion")
    public ResponseResult add(@RequestBody JudgeQuestion judgeQuestion){
        int res = judgeQuestionService.add(judgeQuestion);
        if (res != 0) {

            return ResponseResult.SUCCESS;
        }
        return new ResponseResult(400,"添加失败");
    }
    @RequestMapping("judgeQuestionId")
    public ResponseResult<JudgeQuestion> findOnlyQuestionId(){
        JudgeQuestion judgeQuestion = judgeQuestionService.findOnlyQuestionId();
        return new ResponseResult<>(judgeQuestion);
    }
}
