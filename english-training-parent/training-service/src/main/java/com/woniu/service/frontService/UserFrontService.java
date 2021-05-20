package com.woniu.service.frontService;

import com.woniu.po.UserPo;
import org.springframework.web.multipart.MultipartFile;

public interface UserFrontService {

        //注册
        public void registeUuser(UserPo userPo);

        //查询邮箱是否存在
        public UserPo getByEmail(String email);

        //用户登录
        public UserPo getByAccount(String account);

        //修改用户
        public void updateUser(UserPo userPo);

        //更换图片
        public String uploadImage(MultipartFile file);
}
