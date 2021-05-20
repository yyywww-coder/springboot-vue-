package com.woniu.dao.managerDao;

import com.woniu.po.LinksPo;
import com.woniu.po.ScorePo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LinksDao {

        //查询所有链接
        public List<LinksPo> findAllLinks();

        //更改链接
        public void update(LinksPo linksPo);

        //删除链接
        public void delete(Integer id);

        //添加链接
        public void add(LinksPo linksPo);

}
