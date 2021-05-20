package com.woniu.dao.frontDao;

import com.github.pagehelper.PageInfo;
import com.woniu.po.ScorePo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ScoreFrontDao {

    public void add(ScorePo scorePo);

    public List<ScorePo> findById(Integer id);

}
