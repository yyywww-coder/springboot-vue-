package com.woniu.controller.managerController;

import com.github.pagehelper.PageInfo;
import com.woniu.domain.News;
import com.woniu.service.managerService.NewsManagerService;
import com.woniu.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
@RequestMapping("news")
public class NewsController {

    @Autowired
    private NewsManagerService newsManagerService;

    /**
     * 所有
     * @return
     */
    @RequestMapping("/list")
    public ResponseResult<PageInfo<News>> findAll(Integer pageIndex, Integer pageSize, String name){
//        public ResponseResult<PageInfo<Survey>> findAll(Integer pageIndex, Integer pageSize, @RequestBody Survey survey){
        System.out.println("pageIndex"+pageIndex);
        System.out.println("pageSize"+pageSize);
        System.out.println("name"+name);
        PageInfo<News> newsPageInfo = null;
        newsPageInfo = newsManagerService.list3(pageIndex,pageSize,name);

        System.out.println(newsPageInfo);
        return new ResponseResult<PageInfo<News>>(newsPageInfo);
    }

    /**
     * 添加
     */
    @RequestMapping("adds")
    public ResponseResult addOrder(@RequestBody News news){

        System.out.println("进入添加方法");
        System.out.println(news);
        int flag=newsManagerService.add(news);
        if(flag==1){
            return new ResponseResult(200,"删除成功");
        }else{
            return new ResponseResult(500,"删除失败");
        }
    }

    /**
     * 删除
     */
    @RequestMapping("delete")
    public ResponseResult del(Integer id){
     int flag=newsManagerService.remove(id);
        if(flag==1){
            return new ResponseResult(200,"删除成功");
        }else{
            return new ResponseResult(500,"删除失败");
        }
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseResult update(@RequestBody News news){
        System.out.println("要修改"+news);
        int flag=newsManagerService.update(news);
        if(flag==1){
            return new ResponseResult(200,"删除成功");
        }else{
            return new ResponseResult(500,"删除失败");
        }
    }
}
