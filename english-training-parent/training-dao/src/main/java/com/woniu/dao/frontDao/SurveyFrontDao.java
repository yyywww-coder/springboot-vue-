package com.woniu.dao.frontDao;

import com.woniu.po.SurveyPo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author: ekang
 * @date: 2021/4/29 17:46
 * @description:后台评论Dao层
 */
@Repository
public interface SurveyFrontDao {
    SurveyPo get(int id);

    List<SurveyPo> list();

    int count(Map<String, Object> map);

    int save(SurveyPo survey);

    int update(SurveyPo survey);

    int remove(int id);

    int batchRemove(String[] ids);

}
