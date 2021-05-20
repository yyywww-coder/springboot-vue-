package com.woniu.dao.managerDao;

import com.woniu.po.FillQuestionPo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FillQuestionDao {
    List<FillQuestionPo> getFillQuestions(Integer paperId);

    List<Integer> getBySubject(@Param("subject") String subject, @Param("pageNo") Integer pageNo);

    Integer add(FillQuestionPo fillQuestionPo);

    FillQuestionPo findOnlyQuestionId();


}
