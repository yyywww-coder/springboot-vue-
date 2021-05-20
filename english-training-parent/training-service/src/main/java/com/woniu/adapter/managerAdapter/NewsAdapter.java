package com.woniu.adapter.managerAdapter;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.dao.managerDao.NewsDao;
import com.woniu.domain.News;
import com.woniu.po.NewsPo;
import com.woniu.redis.managerRedisDao.NewsRedisDao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NewsAdapter {

    @Autowired
    private NewsDao newsDao;

    @Autowired
    private NewsRedisDao newsRedisDao;

    /**
     * @description:查所有
     * @author:ekang
     * @date:
     */
        public PageInfo<News> findLists(Integer a, Integer pageSize)  {
            System.out.println("进入newsadapt");
        PageHelper.startPage(a, pageSize);
            List<NewsPo>  newsPos=newsDao.list();
            System.out.println("surveyPos"+newsPos);
      PageInfo pageInfo = new PageInfo<>(newsPos);
        System.out.println("pageinfo"+pageInfo);
//        ObjectMapper objectMapper = new ObjectMapper();
//        if (newsPos.size() == 0) {
//                //redis分页
//            PageHelper.startPage(a, pageSize);
//            //从数据库查数据
//            newsPos = newsDao.list();
//            PageInfo pageInfo1 = new PageInfo<>(newsPos);
//        }

        return pageInfo;
    }

    public PageInfo<News> findLists2(Integer a, Integer pageSize)  {
        System.out.println("进入newsadapt");
        PageHelper.startPage(a, pageSize);
//        List<SurveyPo> surveyPos = surveyRedisDao.list();
        List<NewsPo>  newsPos=newsDao.list2();
        System.out.println("surveyPos"+newsPos);
        PageInfo pageInfo = new PageInfo<>(newsPos);
        System.out.println("pageinfo"+pageInfo);
        ObjectMapper objectMapper = new ObjectMapper();
        if (newsPos.size() == 0) {
            //redis分页
            PageHelper.startPage(a, pageSize);
            //从数据库查数据
            newsPos = newsDao.list();
            PageInfo pageInfo1 = new PageInfo<>(newsPos);

        }

        return pageInfo;
    }

    /**
     * @description:添加
     * @author:ekang
     * @date:
     */
    public int saveNews(News news) {
        NewsPo newsPo = new NewsPo();
        //转换对象
        BeanUtils.copyProperties(news, newsPo);
        int flag = newsDao.save(newsPo);
        return flag;
    }


    /**
     * @description:修改
     * @author:ekang
     * @date:
     */
    public int updateSurvey(News news) {
        NewsPo newsPo = new NewsPo();
        //转换对象
        BeanUtils.copyProperties(news, newsPo);
        int flag = newsDao.update(newsPo);
        return flag;
    }

    /**
     * @description:根据id查询详情
     * @author:ekang
     * @date:
     */
    public int remove(int id) {
        return newsDao.remove(id);
    }


    public News selectById(Integer id) {
        NewsPo newPo=newsDao.selectById(id);
         News news=new News();
        BeanUtils.copyProperties(newPo, news);
        System.out.println(news);
        return news;
    }

    public PageInfo<News> findLists3(Integer pageIndex, Integer pageSize, String name) {
        System.out.println("进入newsadapt");
        PageHelper.startPage(pageIndex, pageSize);
        List<NewsPo>  newsPos=newsDao.list3(name);
        System.out.println("surveyPos"+newsPos);
        PageInfo pageInfo = new PageInfo<>(newsPos);
        System.out.println("pageinfo"+pageInfo);
        ObjectMapper objectMapper = new ObjectMapper();
        if (newsPos.size() == 0) {

            PageHelper.startPage(pageIndex, pageSize);
            //从数据库查数据
            newsPos = newsDao.list3(name);
            PageInfo pageInfo1 = new PageInfo<>(newsPos);
        }
        return pageInfo;
    }
}
