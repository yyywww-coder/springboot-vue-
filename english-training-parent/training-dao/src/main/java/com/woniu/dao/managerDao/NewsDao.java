package com.woniu.dao.managerDao;

import com.woniu.po.NewsPo;
import com.woniu.po.SurveyPo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author: ekang
 * @date: 2021/4/29 17:46
 * @description:后台订单Dao层
 */
@Repository
public interface NewsDao {
    SurveyPo get(int id);

    List<NewsPo> list();

    List<NewsPo> list2();

    int count(Map<String, Object> map);

    int save(NewsPo newsPo);

    int update(NewsPo newsPo);

    int remove(int id);

    int batchRemove(String[] ids);

    //条件查询
    List<NewsPo> findBycont(NewsPo newsPo);

    NewsPo selectById(Integer id);

    List<NewsPo> list3(String name);
}
