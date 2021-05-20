package com.woniu.adapter.frontAdapter;

import com.github.pagehelper.PageInfo;
import com.woniu.dao.frontDao.FillQuestionFrontDao;
import com.woniu.dao.frontDao.JudgeQuestionFrontDao;
import com.woniu.po.FillQuestionPo;
import com.woniu.po.JudgeQuestionPo;
import com.woniu.redis.frontRedisDao.FillQuestionFrontRedisDao;
import com.woniu.redis.frontRedisDao.JudgeQuestionFrontRedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JudgeQuestionFrontAdapter {

    @Autowired
    private JudgeQuestionFrontDao judgeQuestionFrontDao;

    @Autowired
    private JudgeQuestionFrontRedisDao judgeQuestionFrontRedisDao;

    PageInfo<JudgeQuestionPo> poPageInfo = null;

    public List<JudgeQuestionPo> findByIdAndType (Integer id){
      return  judgeQuestionFrontDao.findByIdAndType(id);
    }

}
