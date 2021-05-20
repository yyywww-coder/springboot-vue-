package com.woniu.dao.frontDao;

import com.woniu.po.UserPo;
import org.springframework.stereotype.Component;

/**
 * 前台用户
 */
@Component
public interface UserFrontDao {

        //注册
        public void userRegister(UserPo userPo);

        //查询邮箱是否存在
        public UserPo findByEmail(String email);

        //用户登录
        public UserPo findByAccount(String account);

        //修改用户
        public void updateUser(UserPo userPo);

}
