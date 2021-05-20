package com.woniu.adapter.frontAdapter;

import com.github.pagehelper.PageInfo;
import com.woniu.dao.frontDao.MultiQuestionFrontDao;
import com.woniu.po.MultiQuestionPo;
import com.woniu.redis.frontRedisDao.MultiQuestionFrontRedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MultiQuestionFrontAdapter {

    @Autowired
    private MultiQuestionFrontDao multiQuestionFrontDao;

    @Autowired
    private MultiQuestionFrontRedisDao multiQuestionFrontRedisDao;

    PageInfo<MultiQuestionPo> poPageInfo = null;

    public List<MultiQuestionPo> findByIdAndType (Integer id){
      return  multiQuestionFrontDao.findByIdAndType(id);
    }

}
