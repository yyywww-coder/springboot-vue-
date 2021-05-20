package com.woniu.adapter.frontAdapter;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.dao.frontDao.ScoreFrontDao;
import com.woniu.domain.Manager;
import com.woniu.domain.Score;
import com.woniu.po.ScorePo;
import com.woniu.redis.frontRedisDao.ScoreFrontRedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScoreFrontAdapter {

    @Autowired
    private ScoreFrontDao scoreFrontDao;

    @Autowired
    private ScoreFrontRedisDao scoreFrontRedisDao;


    public void add(ScorePo scorePo){
        scoreFrontDao.add(scorePo);
    }

    public PageInfo<ScorePo> findById(Integer pageIndex,Integer pageSize,Integer id){
        PageHelper.startPage(pageIndex,pageSize);
        List<ScorePo> scorePoList = scoreFrontDao.findById(id);
        PageInfo<ScorePo> poPageInfo = new PageInfo<>(scorePoList);
        return poPageInfo;

    }

}
