package com.woniu.service.managerService;


import com.github.pagehelper.PageInfo;
import com.woniu.domain.Survey;

/**
 * ClassName: SurveyManagerService <br/>
 * Description: <br/>
 * date: 2021/4/29 20:04<br/>
 *
 * @author hasee<br />
 */

public interface SurveyManagerService {

    int update(Survey survey);

    PageInfo<Survey> list(Integer a,Integer pageSize,String name)  ;
    int remove(int id);
    int add(Survey survey);
}
