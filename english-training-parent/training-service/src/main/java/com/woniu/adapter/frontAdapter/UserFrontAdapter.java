package com.woniu.adapter.frontAdapter;

import com.woniu.dao.frontDao.UserFrontDao;
import com.woniu.po.UserPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserFrontAdapter {

        @Autowired
        private UserFrontDao userFrontDao;


        /**
         * 查找账号是否存在
         * @param account
         * @return
         */
        public UserPo findAccount(String account){
                UserPo byAccount = userFrontDao.findByAccount(account);
                        return byAccount;

        }


        /**
         * 注册邮箱时查询邮箱是否已经存在
         * @param email
         * @return
         */
        public UserPo findByEmail(String email){
                UserPo byEmail = userFrontDao.findByEmail(email);
                return byEmail;
        }


        /**
         * 注册
         * @param userPo
         */
        public void userRegister(UserPo userPo){
                userFrontDao.userRegister(userPo);
        }


        /**
         * 修改用户
         * @param userPo
         */
        public void updateUser(UserPo userPo){
                userFrontDao.updateUser(userPo);
        }
}
