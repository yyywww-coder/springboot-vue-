package com.woniu.dao.managerDao;

import com.woniu.po.UserPo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    /**
     * 查找所有的用户
     * @return
     */
    public List<UserPo> findAllUsers(@Param("account") String account,@Param("status") String status);


    /**
     * 根据账号查找用户
     * @return
     */
    public UserPo findByAccount(String account);

    /**
     * 添加用户
     */
    public void addUser(UserPo user);

    /**
     * 修改用户信息
     */
    public void updateUser(@Param("status") String status, @Param("id") Integer id);

    /**
     * 根据id删除用户
     * @param id
     */
    public void deleteUserById(Integer id);


}
