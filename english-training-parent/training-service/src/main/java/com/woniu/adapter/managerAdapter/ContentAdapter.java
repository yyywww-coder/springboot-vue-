package com.woniu.adapter.managerAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.dao.managerDao.ContentDao;
import com.woniu.domain.Content;
import com.woniu.po.ContentPo;
import com.woniu.po.ManagerPo;
import com.woniu.redis.managerRedisDao.ContentRedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class ContentAdapter {

    PageInfo<ContentPo> poPageInfo = null;

    @Resource
    private ContentDao contentDao;

    @Autowired
    private ContentRedisDao contentRedisDao;

    public PageInfo<ContentPo> findAll(Integer pageIndex,Integer pageSize){
        List<ContentPo> contentList = contentRedisDao.list();
        ObjectMapper objectMapper = new ObjectMapper();
        if (contentList.size() == 0){
            PageHelper.startPage(pageIndex,pageSize);
            contentList = contentDao.findAll();
            poPageInfo = new PageInfo<>(contentList);
            contentRedisDao.addRedisContentList(poPageInfo);
        }
        poPageInfo = new PageInfo<>(contentList);
        return poPageInfo;
    }

}
