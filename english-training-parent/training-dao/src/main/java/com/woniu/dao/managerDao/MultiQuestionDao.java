package com.woniu.dao.managerDao;

import com.woniu.po.MultiQuestionPo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MultiQuestionDao {
    List<MultiQuestionPo> getMultiQuestions(Integer paperId);


    List<Integer> findBySubject(@Param("subject") String subject, @Param("pageNo") Integer changeNumber);

    /**
     * 查询最后一条记录的questionId
     * @return MultiQuestion
     */
    MultiQuestionPo findOnlyQuestionId();

    Integer add(MultiQuestionPo multiQuestionPo);

}
