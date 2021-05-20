package com.woniu.adapter.frontAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.dao.frontDao.VideoFrontDao;
import com.woniu.po.VideoPo;
import com.woniu.redis.frontRedisDao.VideoFrontRedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VideoFrontAdapter {

        @Autowired
        private VideoFrontDao videoFrontDao;

        @Autowired
        private VideoFrontRedisDao videoFrontRedisDao;

        /**
         * 视频列表
         * @return
         */
        public PageInfo<VideoPo> findVideoLists(Integer pageIndex, Integer pageSize, VideoPo videoPo){
                List<VideoPo> videoPoList = new ArrayList<>();
                PageInfo<VideoPo> pageInfo = null;

                if(videoPo.getCreateTime()!=null && !videoPo.getCreateTime().equals("")
                        || videoPo.getPrice() !=null && videoPo.getPrice()>0) {
                        //从数据库查数据
                        PageHelper.startPage(pageIndex, pageSize);
                        videoPoList = videoFrontDao.getAllVideo(videoPo);
                        pageInfo = new PageInfo<>(videoPoList);
                        //存入redis的缓存中
                        videoFrontRedisDao.addRedisVideoList(pageInfo);
               }else {
                        videoPoList = videoFrontRedisDao.list();
                        ObjectMapper objectMapper = new ObjectMapper();
                        if (videoPoList.size() == 0) {
                                //从数据库查数据
                                PageHelper.startPage(pageIndex, pageSize);
                                videoPoList = videoFrontDao.getAllVideo(videoPo);
                                pageInfo = new PageInfo<>(videoPoList);
                                //存入redis的缓存中
                                videoFrontRedisDao.addRedisVideoList(pageInfo);
                        }
                }
//                //把dao的 userList UserPo --- 转成  List<User>
//                List<Students> students = new ArrayList<Students>();
//                for(StudentsPo studentsPo : studentsPoList) {
//                        Students item = new Students();
//                        BeanUtils.copyProperties(studentsPo, item);
//                        students.add(item);
//                }
                return pageInfo ;
        }
}
