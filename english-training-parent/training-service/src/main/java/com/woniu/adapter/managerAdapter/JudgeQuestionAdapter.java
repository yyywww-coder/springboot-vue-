package com.woniu.adapter.managerAdapter;


import com.woniu.dao.managerDao.JudgeQuestionDao;
import com.woniu.domain.JudgeQuestion;
import com.woniu.po.JudgeQuestionPo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JudgeQuestionAdapter {
    @Autowired
    private JudgeQuestionDao judgeQuestionDao;
    public List<JudgeQuestion> getAll(Integer paperId){
        List<JudgeQuestionPo> judgeQuestions = judgeQuestionDao.getJudgeQuestions(paperId);
        List<JudgeQuestion> judgeQuestionList = new ArrayList<>();
        for (JudgeQuestionPo judgeQuestion : judgeQuestions) {
            JudgeQuestion judgeQuestion1 = new JudgeQuestion();
            BeanUtils.copyProperties(judgeQuestion,judgeQuestion1);
            judgeQuestionList.add(judgeQuestion1);
        }
        return judgeQuestionList;

    }

    public List<Integer> getBySubject(String subject,Integer pageNo){
        List<Integer> judges = judgeQuestionDao.getBySubject(subject,pageNo);
        return judges;
    }

    public Integer add(JudgeQuestion judgeQuestion){
        JudgeQuestionPo judgeQuestionPo = new JudgeQuestionPo();
        BeanUtils.copyProperties(judgeQuestion,judgeQuestionPo);
        Integer add = judgeQuestionDao.add(judgeQuestionPo);
        return add;
    }

    public JudgeQuestion findByQuestion(){
        JudgeQuestionPo judgeQuestionPo = judgeQuestionDao.findOnlyQuestionId();
        JudgeQuestion judgeQuestion = new JudgeQuestion();
        BeanUtils.copyProperties(judgeQuestionPo,judgeQuestion);
        return judgeQuestion;

    }
}
