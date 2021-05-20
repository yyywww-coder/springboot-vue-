package com.woniu.adapter.frontAdapter;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.dao.frontDao.ExamManageFrontDao;
import com.woniu.dao.frontDao.PaperManageFrontDao;
import com.woniu.po.ExamManagePo;
import com.woniu.po.PaperManagePo;
import com.woniu.redis.frontRedisDao.ExamManageFrontRedisDao;
import com.woniu.redis.frontRedisDao.PaperManageFrontRedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PaperManageFrontAdapter {

    @Autowired
    private PaperManageFrontDao paperManageFrontDao;

    @Autowired
    private PaperManageFrontRedisDao paperManageFrontRedisDao;

    public PaperManagePo findById(Integer paperId){
       return paperManageFrontDao.findById(paperId);
    }


}
