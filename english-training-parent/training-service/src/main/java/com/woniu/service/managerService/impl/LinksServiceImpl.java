package com.woniu.service.managerService.impl;

import com.woniu.adapter.managerAdapter.LinksAdapter;
import com.woniu.dao.managerDao.LinksDao;
import com.woniu.domain.Links;
import com.woniu.po.LinksPo;
import com.woniu.service.managerService.LinksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LinksServiceImpl implements LinksService {

        @Autowired
        private LinksAdapter linksAdapter;

        @Override
        public List<LinksPo> findAllLinks() {
                return linksAdapter.findLinksLists();
        }

        @Override
        public void update(LinksPo linksPo) {
                linksAdapter.updateLinks(linksPo);
        }

        @Override
        public void delete(Integer id) {
                linksAdapter.deleteLinks(id);
        }

        @Override
        public void add(LinksPo linksPo) {
                linksAdapter.addLinks(linksPo);
        }
}
