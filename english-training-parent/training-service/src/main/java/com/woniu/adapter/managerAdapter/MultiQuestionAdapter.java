package com.woniu.adapter.managerAdapter;

import com.woniu.dao.managerDao.MultiQuestionDao;
import com.woniu.domain.MultiQuestion;
import com.woniu.po.MultiQuestionPo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MultiQuestionAdapter {
    @Autowired
    private MultiQuestionDao multiQuestionDao;

    public List<MultiQuestion> getAll(Integer paperId){
        List<MultiQuestionPo> multiQuestions = multiQuestionDao.getMultiQuestions(paperId);
        List<MultiQuestion> multiQuestionList = new ArrayList<>();
        for (MultiQuestionPo multiQuestion : multiQuestions) {
            MultiQuestion multiQuestion1 = new MultiQuestion();
            BeanUtils.copyProperties(multiQuestion,multiQuestion1);
            multiQuestionList.add(multiQuestion1);
        }
        return multiQuestionList;
    }

    public List<Integer> getAllSubject(String subject,Integer changeNumber){
        List<Integer> bySubject = multiQuestionDao.findBySubject(subject, changeNumber);

        return bySubject;

    }

    public Integer add(MultiQuestion multiQuestion){
        MultiQuestionPo m = new MultiQuestionPo();
        BeanUtils.copyProperties(multiQuestion,m);
        Integer add = multiQuestionDao.add(m);
        return add;
    }

    public MultiQuestion findOnlyQuestionId(){
        MultiQuestionPo onlyQuestionId = multiQuestionDao.findOnlyQuestionId();
        MultiQuestion multiQuestion = new MultiQuestion();
        BeanUtils.copyProperties(onlyQuestionId,multiQuestion);
        return multiQuestion;
    }

}
