package com.woniu.adapter.managerAdapter;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.dao.managerDao.SurveyDao;
import com.woniu.domain.Survey;

import com.woniu.po.SurveyPo;
import com.woniu.po.UserPo;
import com.woniu.redis.managerRedisDao.SurveyRedisDao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SurveyAdapter {

    @Autowired
    private SurveyDao surveyDao;

    @Autowired
    private SurveyRedisDao surveyRedisDao;

    /**
     * @description:查所有
     * @author:ekang
     * @date:
     */

    public PageInfo<Survey> findLists(Integer a,Integer pageSize,String name)  {
        PageHelper.startPage(a, pageSize);
        List<SurveyPo> surveyPos=surveyDao.list(name);
        System.out.println("surveypos"+surveyPos);
        PageInfo  pageInfo = new PageInfo<>(surveyPos);

        System.out.println("pageinfo"+pageInfo);
        ObjectMapper objectMapper = new ObjectMapper();
        if (surveyPos.size() == 0) {
            //redis分页
            PageHelper.startPage(a, pageSize);
            //从数据库查数据
            surveyPos = surveyDao.list(name);
            PageInfo  pageInfo1 = new PageInfo<>(surveyPos);
            //存入redis的缓存中
            surveyRedisDao.addRedisSurveyList(pageInfo1);
        }
        //转换对象类型
        List<Survey> surveyPos1 = new ArrayList<Survey>();
        for (SurveyPo survey : surveyPos) {
            Survey survey1 = new Survey();
            BeanUtils.copyProperties(survey, survey1);
            surveyPos1.add(survey1);
        }
        return pageInfo;
    }

    /**
     * @description:添加
     * @author:ekang
     * @date:
     */
    public int saveSurvey(Survey survey) {
        SurveyPo surveyPo = new SurveyPo();
        //转换对象
        BeanUtils.copyProperties(survey, surveyPo);
        int flag = surveyDao.save(surveyPo);


        return flag;
    }


    /**
     * @description:修改
     * @author:ekang
     * @date:
     */
    public int updateSurvey(Survey survey) {
        SurveyPo surveyPo = new SurveyPo();
        //转换对象
        BeanUtils.copyProperties(survey, surveyPo);
        int flag = surveyDao.update(surveyPo);

        return flag;
    }

    /**
     * @description:移除方法
     * @author:ekang
     * @date:
     */
    public int remove(int id) {
        return surveyDao.remove(id);
    }


}
