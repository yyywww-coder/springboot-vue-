package com.woniu.adapter.frontAdapter;

import com.github.pagehelper.PageInfo;
import com.woniu.dao.frontDao.FillQuestionFrontDao;
import com.woniu.po.FillQuestionPo;
import com.woniu.redis.frontRedisDao.FillQuestionFrontRedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FillQuestionFrontAdapter {

    @Autowired
    private FillQuestionFrontDao fillQuestionFrontDao;

    @Autowired
    private FillQuestionFrontRedisDao fillQuestionFrontRedisDao;

    PageInfo<FillQuestionPo> poPageInfo = null;

    public List<FillQuestionPo> findByIdAndType (Integer id){
      return  fillQuestionFrontDao.findByIdAndType(id);
    }

}
