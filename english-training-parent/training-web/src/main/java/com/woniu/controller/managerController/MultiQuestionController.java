package com.woniu.controller.managerController;

import com.woniu.domain.MultiQuestion;
import com.woniu.service.managerService.MultiQuestionService;
import com.woniu.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("multiQuestion")
public class MultiQuestionController {
    @Autowired
    private MultiQuestionService multiQuestionService;

    @PostMapping("/MultiQuestion")
    public ResponseResult add(@RequestBody MultiQuestion multiQuestion) {
        int res = multiQuestionService.add(multiQuestion);
        if (res != 0) {

            return ResponseResult.SUCCESS;
        }
        return new ResponseResult(400,"添加失败");
    }

    @RequestMapping("multiQuestionId")
    public ResponseResult<MultiQuestion> findOnlyQuestionId(){
        MultiQuestion onlyQuestionId = multiQuestionService.findOnlyQuestionId();
        return new ResponseResult<>(onlyQuestionId);
    }
}
