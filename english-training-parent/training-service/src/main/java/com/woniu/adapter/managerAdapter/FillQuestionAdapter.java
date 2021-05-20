package com.woniu.adapter.managerAdapter;

import com.woniu.dao.managerDao.FillQuestionDao;
import com.woniu.domain.FillQuestion;
import com.woniu.po.FillQuestionPo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FillQuestionAdapter {
    @Autowired
    private FillQuestionDao fillQuestionDao;
    public List<FillQuestion> getAll(Integer paperId){
        List<FillQuestionPo> fillQuestions = fillQuestionDao.getFillQuestions(paperId);
        List<FillQuestion> fillQuestionList = new ArrayList<>();
        for (FillQuestionPo fillQuestion : fillQuestions) {
            FillQuestion fillQuestion1 = new FillQuestion();
            BeanUtils.copyProperties(fillQuestion,fillQuestion1);
            fillQuestionList.add(fillQuestion1);
        }
        return fillQuestionList;

    }

    public List<Integer> getBySubject(String subject,Integer pageNo){
        List<Integer> fills = fillQuestionDao.getBySubject(subject, pageNo);
        return fills;

    }

    public Integer add(FillQuestion fillQuestion){
        FillQuestionPo fillQuestionPo = new FillQuestionPo();
        BeanUtils.copyProperties(fillQuestion,fillQuestionPo);
        Integer add = fillQuestionDao.add(fillQuestionPo);
        return add;
    }

    public FillQuestion findOnlyQuestionId(){
        FillQuestionPo onlyQuestionId = fillQuestionDao.findOnlyQuestionId();
        FillQuestion fillQuestion = new FillQuestion();
        BeanUtils.copyProperties(onlyQuestionId,fillQuestion);
        return fillQuestion;
    }

}
