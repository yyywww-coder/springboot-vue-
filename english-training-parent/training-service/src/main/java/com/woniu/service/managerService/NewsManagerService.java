package com.woniu.service.managerService;

import com.github.pagehelper.PageInfo;
import com.woniu.domain.News;

/**
 * ClassName:  <br/>
 * Description: <br/>
 * date: 2021/4/29 20:04<br/>
 *
 * @author hasee<br />
 */

public interface NewsManagerService {

    int update(News news);
     PageInfo<News> list(Integer a, Integer pageSize);
    PageInfo<News> list2(Integer a, Integer pageSize);
    int remove(int id);
    int add(News news);

    News selectById(Integer id);

    PageInfo<News> list3(Integer pageIndex, Integer pageSize, String name);
}
