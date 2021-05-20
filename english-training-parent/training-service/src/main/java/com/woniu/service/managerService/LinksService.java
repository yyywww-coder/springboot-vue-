package com.woniu.service.managerService;

import com.woniu.domain.Links;
import com.woniu.po.LinksPo;

import java.util.List;


public interface LinksService {

        //查询所有链接
        public List<LinksPo> findAllLinks();

        //更改链接
        public void update(LinksPo linksPo);

        //删除链接
        public void delete(Integer id);

        //添加链接
        public void add(LinksPo linksPo);
}
