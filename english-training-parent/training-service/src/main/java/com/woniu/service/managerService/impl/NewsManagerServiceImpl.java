package com.woniu.service.managerService.impl;

import com.github.pagehelper.PageInfo;
import com.woniu.adapter.managerAdapter.NewsAdapter;
import com.woniu.domain.News;
import com.woniu.service.managerService.NewsManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class NewsManagerServiceImpl implements NewsManagerService {
    @Override
    public PageInfo<News> list3(Integer pageIndex, Integer pageSize, String name) {
        return newsAdapter.findLists3(pageIndex,pageSize,name);
    }

    @Autowired
    private NewsAdapter newsAdapter;

    @Override
    //根据id查询详情
    public News selectById(Integer id) {
        return newsAdapter.selectById(id);
    }

    /**
     * @description:添加评论功能
     * @author:ekang
     * @date:
     */
    public int add(News news) {
        return newsAdapter.saveNews(news);
    }

    /**
     * @description:移除功能
     * @author:ekang
     * @date:
     */
    @Override
    public int remove(int id) {
        return newsAdapter.remove(id);
    }

    /**
     * @description:获得评论列表
     * @author:ekang
     * @date:
     * @return
     */
    @Override
    public PageInfo<News> list(Integer a, Integer pageSize)   {
        return newsAdapter.findLists(a,pageSize);
    }

    /**
     * @description:获得评论列表
     * @author:ekang
     * @date:
     * @return
     */
    @Override
    public PageInfo<News> list2(Integer a, Integer pageSize)   {
        return newsAdapter.findLists2(a,pageSize);
    }

    /**
     * @description:修改功能
     * @author:ekang
     * @date:
     */
    @Override
    public int update(News news) {
        return newsAdapter.updateSurvey(news);
    }
}
