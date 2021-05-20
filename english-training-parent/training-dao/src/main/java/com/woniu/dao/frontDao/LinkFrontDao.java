package com.woniu.dao.frontDao;


import com.woniu.po.LinksPo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 前台页面页脚友情链接
 */
@Component
public interface LinkFrontDao {

        //查找所有链接
        public List<LinksPo> findAllLink();
}
