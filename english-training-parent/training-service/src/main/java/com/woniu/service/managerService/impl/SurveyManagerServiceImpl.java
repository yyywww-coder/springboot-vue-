package com.woniu.service.managerService.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageInfo;
import com.woniu.adapter.managerAdapter.SurveyAdapter;
import com.woniu.domain.Survey;
import com.woniu.service.managerService.SurveyManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SurveyManagerServiceImpl implements SurveyManagerService {

    @Autowired
    private SurveyAdapter surveyAdapter;

    /**
     * @description:添加评论功能
     * @author:ekang
     * @date:
     */
    public int add(Survey survey) {
        return surveyAdapter.saveSurvey(survey);
    }

    /**
     * @description:移除功能
     * @author:ekang
     * @date:
     */
    @Override
    public int remove(int id) {
        return surveyAdapter.remove(id);
    }

    /**
     * @description:获得评论列表
     * @author:ekang
     * @date:
     * @return
     */
    @Override
    public PageInfo<Survey> list(Integer a,Integer pageSize,String name)   {
        return surveyAdapter.findLists(a,pageSize,name);
    }
    /**
     * @description:修改功能
     * @author:ekang
     * @date:
     */
    @Override
    public int update(Survey survey) {
        return surveyAdapter.updateSurvey(survey);
    }


}
