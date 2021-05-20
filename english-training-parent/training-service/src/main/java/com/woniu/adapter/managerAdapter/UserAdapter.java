package com.woniu.adapter.managerAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.dao.managerDao.UserDao;
import com.woniu.domain.User;
import com.woniu.po.UserPo;
import com.woniu.redis.managerRedisDao.UserRedisDao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserAdapter {

    @Resource
    private UserDao userDao;

    @Autowired
    private UserRedisDao userRedisDao;

    PageInfo<UserPo> poPageInfo = null;

    /**
     * 查所有用户
     * @param searchName
     * @param status
     * @return
     */
    public PageInfo<UserPo> findUserLists(Integer pageIndex,Integer pageSize,String searchName,String status){

        List<UserPo> userList = userRedisDao.list();
        ObjectMapper objectMapper = new ObjectMapper();
        if(userList.size() == 0){
            PageHelper.startPage(pageIndex,pageSize);
            //从数据库查数据
            userList = userDao.findAllUsers(searchName,status);
            poPageInfo = new PageInfo<>(userList);
            //存入redis的缓存中
            userRedisDao.addRedisUserList(poPageInfo);
        }
        //把dao的 userList UserPo --- 转成  List<User>
        /*List<User> users = new ArrayList<User>();
        for(UserPo user : userList) {
            User item = new User();
            BeanUtils.copyProperties(user, item);
            users.add(item);
        }*/
        poPageInfo = new PageInfo<>(userList);
        return poPageInfo ;
    }

    /**
     * 修改用户状态
     * @param status
     * @param id
     */
    public void updateUser(String status,Integer id){
        userDao.updateUser(status,id);
        List<UserPo> userPoList = userDao.findAllUsers("", "");
        poPageInfo = new PageInfo<>(userPoList);
        userRedisDao.addRedisUserList(poPageInfo);
    }


    public User findByUserName(String username){
        User user=new User();
        UserPo userPo=userDao.findByAccount(username);
        if(userPo==null){
            return null;
        }
        else{ BeanUtils.copyProperties(userPo, user);}

        return user;
    }
}
