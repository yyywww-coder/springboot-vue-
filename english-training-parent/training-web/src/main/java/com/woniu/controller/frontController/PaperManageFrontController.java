package com.woniu.controller.frontController;

import com.woniu.domain.*;
import com.woniu.po.*;
import com.woniu.service.frontService.*;
import com.woniu.utils.ResponseResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("front/paper")
public class PaperManageFrontController {

    @Autowired
    private PaperManageFrontService paperManageFrontService;

    @Autowired
    private MultiQuestionFrontService multiQuestionFrontService;

    @Autowired
    private FillQuestionFrontService fillQuestionFrontService;

    @Autowired
    private JudgeQuestionFrontService judgeQuestionFrontService;


    @RequestMapping("paperId")
    public ResponseResult<Map<Integer, List<?>>> findById(Integer paperId){
        //选择题
        List<MultiQuestionPo> multiquestionPos = multiQuestionFrontService.findByIdAndType(paperId);
        List<MultiQuestion> multiQuestions = new ArrayList<>();
        for (MultiQuestionPo multiquestionPo : multiquestionPos) {
            MultiQuestion multiQuestion = new MultiQuestion();
            BeanUtils.copyProperties(multiquestionPo,multiQuestion);
            multiQuestions.add(multiQuestion);
        }

        //填空题
        List<FillQuestionPo> fillQuestionPos = fillQuestionFrontService.findByIdAndType(paperId);
        List<FillQuestion> fillQuestions = new ArrayList<>();
        for (FillQuestionPo fillQuestionPo : fillQuestionPos) {
            FillQuestion fillQuestion = new FillQuestion();
            BeanUtils.copyProperties(fillQuestionPo,fillQuestion);
            fillQuestions.add(fillQuestion);
        }

        //判断题
        List<JudgeQuestionPo> judgeQuestionPos = judgeQuestionFrontService.findByIdAndType(paperId);
        List<JudgeQuestion> judgeQuestions = new ArrayList<>();
        for (JudgeQuestionPo judgeQuestionPo : judgeQuestionPos) {
            JudgeQuestion judgeQuestion = new JudgeQuestion();
            BeanUtils.copyProperties(judgeQuestionPo,judgeQuestion);
            judgeQuestions.add(judgeQuestion);
        }

        Map<Integer, List<?>> map = new HashMap<>();
        map.put(1,multiQuestions);
        map.put(2,fillQuestions);
        map.put(3,judgeQuestions);
        return new ResponseResult<>(map);

    }
    
}
