package com.woniu.service.frontService.impl;

import com.woniu.adapter.frontAdapter.LinkFrontAdapter;
import com.woniu.domain.Links;
import com.woniu.exception.LinkException;
import com.woniu.service.frontService.LinkFrontService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LinkFrontServiceImpl implements LinkFrontService {

        @Autowired
        private LinkFrontAdapter linkFrontAdapter;

        /**
         * 查找所有链接
         * @return
         */
        @Override
        public List<Links> getAllLink() {

                List<Links> linkLists = linkFrontAdapter.findLinkLists();
                if(linkLists ==null){
                        throw new LinkException("无相关数据");
                }
                return linkLists;
        }
}
