package com.woniu.adapter.managerAdapter;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.dao.managerDao.AnswerDao;
import com.woniu.domain.FillQuestion;
import com.woniu.po.ArrangePo;
import com.woniu.po.FillQuestionPo;
import com.woniu.po.ManagerPo;
import com.woniu.redis.managerRedisDao.AnswerRedisDao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AnswerAdapter {
    @Autowired
    private AnswerDao answerDao;
    @Autowired
    private AnswerRedisDao answerRedisDao;

    PageInfo<FillQuestionPo> poPageInfo = null;


    public PageInfo<FillQuestionPo> getAllAnswer(Integer pageIndex, Integer pageSize) {

        List<FillQuestionPo> fillQuestionPos = answerRedisDao.list();
        if (fillQuestionPos.size() == 0) {
            PageHelper.startPage(pageIndex,pageSize);
            fillQuestionPos = answerDao.getAllQuestion();
            poPageInfo = new PageInfo<>(fillQuestionPos);
            answerRedisDao.addRedisAnswerList(poPageInfo);
        }
        /*List<Manager> managerList = new ArrayList<>();
        for (ManagerPo managerPo : managerPoList) {
            Manager item = new Manager();
            BeanUtils.copyProperties(managerPo, item);
            managerList.add(item);
        }*/
        poPageInfo = new PageInfo<>(fillQuestionPos);
        return poPageInfo;

    }



//    public List<FillQuestion> getAllQuestion(){
//        List<FillQuestionPo> allQuestion = answerDao.getAllQuestion();
//        List<FillQuestion> fillQuestionList = new ArrayList<>();
//        for (FillQuestionPo fillQuestionPo : allQuestion) {
//            FillQuestion fillQuestion = new FillQuestion();
//            BeanUtils.copyProperties(fillQuestionPo,fillQuestion);
//            fillQuestionList.add(fillQuestion);
//        }
//        return fillQuestionList;
//    }
}
