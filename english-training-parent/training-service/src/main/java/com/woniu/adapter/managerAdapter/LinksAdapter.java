package com.woniu.adapter.managerAdapter;

import com.woniu.dao.managerDao.LinksDao;
import com.woniu.po.LinksPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LinksAdapter {

        @Autowired
        private LinksDao linksDao;

        /**
         * 链接列表
         * @return
         */
        public List<LinksPo> findLinksLists(){
                List<LinksPo> allLinks = linksDao.findAllLinks();
                return allLinks ;
        }


        /**
         * 修改链接信息
         * @param linksPo
         */
        public void updateLinks(LinksPo linksPo){

                linksDao.update(linksPo);
        }


        /**
         * 新增链接
         * @param linksPo
         */
        public void addLinks(LinksPo linksPo){
                linksDao.add(linksPo);
        }


        /**
         * 根据id删除
         * @param id
         */
        public void deleteLinks(Integer id){
                linksDao.delete(id);
        }



}
