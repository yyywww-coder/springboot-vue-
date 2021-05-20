package com.woniu.controller.frontController;


import com.github.pagehelper.PageInfo;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.woniu.domain.News;
import com.woniu.domain.Survey;
import com.woniu.service.managerService.NewsManagerService;
import com.woniu.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("front/news")
public class NewsFrontController {

    @Autowired
    private NewsManagerService newsManagerService;

    /**
     * 父母讲堂列表遍历
     */
    @RequestMapping("list1")
    public ResponseResult<PageInfo<News>> findAll(Integer pageIndex, Integer pageSize){

        Survey survey=new Survey();
        System.out.println(survey);
        System.out.println("进入父母讲堂list查询");
        //用户名查询
        System.out.println("pageIndex"+pageIndex);
        System.out.println("pageSize"+pageSize);
        //查询列表
        String username="";
        PageInfo<News> newsPageInfo = newsManagerService.list(pageIndex,pageSize);

        return new ResponseResult<PageInfo<News>>(newsPageInfo);
    }

    /**
     * 父母讲堂列表遍历
     */
    @RequestMapping("list2")
    public ResponseResult<PageInfo<News>> findAll2(Integer pageIndex, Integer pageSize){
        System.out.println("进入父母讲堂list查询");
        //用户名查询
        System.out.println("pageIndex"+pageIndex);
        System.out.println("pageSize"+pageSize);
        //查询列表
        String username="";
        PageInfo<News> newsPageInfo = newsManagerService.list2(pageIndex,pageSize);

        return new ResponseResult<PageInfo<News>>(newsPageInfo);
    }

    /**
     * 详情
     */
    @RequestMapping("item")
    public ResponseResult<News> getItem(Integer id){
        System.out.println("进入详情展示");
        News news=newsManagerService.selectById(id);
        System.out.println(news);
//        System.out.println("进入父母讲堂list查询");
//        //用户名查询
//        System.out.println("pageIndex"+pageIndex);
//        System.out.println("pageSize"+pageSize);
//        //查询列表
//        String username="";
//        PageInfo<News> newsPageInfo = newsManagerService.list(pageIndex,pageSize);

        return new ResponseResult<News>(news);
    }
}
