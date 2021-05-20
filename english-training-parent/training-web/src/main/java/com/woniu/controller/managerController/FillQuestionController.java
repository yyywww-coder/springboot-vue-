package com.woniu.controller.managerController;

import com.woniu.domain.FillQuestion;
import com.woniu.service.managerService.FillQuestionService;
import com.woniu.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("fillQuestion")
public class FillQuestionController {
    @Autowired
    private FillQuestionService fillQuestionService;

    @RequestMapping("FillQuestion")
    public ResponseResult add(@RequestBody FillQuestion fillQuestion){
        int res = fillQuestionService.add(fillQuestion);
        if (res != 0) {

            return ResponseResult.SUCCESS;
        }
        return new ResponseResult(400,"添加失败");
    }
    @RequestMapping("fillQuestionId")
    public ResponseResult<FillQuestion> findOnlyQuestionId(){
        FillQuestion onlyQuestionId = fillQuestionService.findOnlyQuestionId();
        return new ResponseResult<>(onlyQuestionId);
    }
}
