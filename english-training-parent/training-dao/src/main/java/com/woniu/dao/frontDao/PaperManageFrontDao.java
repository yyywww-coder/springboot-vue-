package com.woniu.dao.frontDao;

import com.woniu.po.ExamManagePo;
import com.woniu.po.PaperManagePo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PaperManageFrontDao {


    PaperManagePo findById(Integer paperId);


}
