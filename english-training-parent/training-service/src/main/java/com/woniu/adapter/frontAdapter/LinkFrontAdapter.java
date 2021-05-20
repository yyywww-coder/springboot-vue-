package com.woniu.adapter.frontAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.dao.frontDao.LinkFrontDao;
import com.woniu.dao.frontDao.VideoFrontDao;
import com.woniu.domain.Links;
import com.woniu.domain.User;
import com.woniu.po.LinksPo;
import com.woniu.po.UserPo;
import com.woniu.po.VideoPo;
import com.woniu.redis.frontRedisDao.LinkFrontRedisDao;
import com.woniu.redis.frontRedisDao.VideoFrontRedisDao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LinkFrontAdapter {

        @Autowired
        private LinkFrontDao linkFrontDao;

        @Autowired
        private LinkFrontRedisDao linkFrontRedisDao;

        /**
         * 链接列表
         *
         * @return
         */
        public List<Links> findLinkLists() {
                List<LinksPo> linksPoList = linkFrontRedisDao.list();
                ObjectMapper objectMapper = new ObjectMapper();
                if (linksPoList.size() == 0) {
                        //从数据库查数据
                        linksPoList = linkFrontDao.findAllLink();
                        //存入redis的缓存中
                        linkFrontRedisDao.addRedisLinkList(linksPoList);
                }
                //把dao的 userList UserPo --- 转成  List<User>
                List<Links> links = new ArrayList<Links>();
                for (LinksPo linksPo : linksPoList) {
                        Links item = new Links();
                        BeanUtils.copyProperties(linksPo, item);
                        links.add(item);
                }
                return links;
        }
}
