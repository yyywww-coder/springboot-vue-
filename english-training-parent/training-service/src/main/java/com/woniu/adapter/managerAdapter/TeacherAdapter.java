package com.woniu.adapter.managerAdapter;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.dao.managerDao.TeacherDao;
import com.woniu.domain.Manager;
import com.woniu.domain.Teacher;
import com.woniu.po.TeacherPo;
import com.woniu.redis.managerRedisDao.TeacherFrontRedisDao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class TeacherAdapter {

    @Resource
    private TeacherDao teacherFrontDao;

    @Autowired
    private TeacherFrontRedisDao managerRedisDao;

    PageInfo<TeacherPo> poPageInfo = null;


    /**
     * 查所有
     * @return
     */
    public List<Manager> findAll(){

       /* List<ManagerPo> managerList = managerRedisDao.list();
        ObjectMapper objectMapper = new ObjectMapper();
        if (managerList.size() == 0){
            managerList = managerDao.findAll();
            managerRedisDao.addRedisManagerList(managerList);
        }

        //把dao中的实体类对象转换为service中的实体类对象
        List<Manager> managers = new ArrayList<>();
        for (ManagerPo manager : managerList) {
            Manager item = new Manager();
            BeanUtils.copyProperties(manager,item);
            managers.add(item);
        }*/

        return null;
    }

//    public Manager findByAccount(String account){
//        ManagerPo m = managerDao.findByAccount(account);
//        Manager manager = new Manager();
//        BeanUtils.copyProperties(m,manager);
//        return manager;
//    }



    /**
     * 前台模糊查询
     * @param username
     * @return
     */
    public PageInfo<TeacherPo> findByUsername(Integer pageIndex,Integer pageSize,String username) {

        List<TeacherPo> managerPoList = managerRedisDao.list();
        if (managerPoList.size() == 0) {
            PageHelper.startPage(pageIndex,pageSize);
            managerPoList = teacherFrontDao.getList(username);
            poPageInfo = new PageInfo<>(managerPoList);
            managerRedisDao.addRedisManagerList(poPageInfo);
        }
        /*List<Manager> managerList = new ArrayList<>();
        for (ManagerPo managerPo : managerPoList) {
            Manager item = new Manager();
            BeanUtils.copyProperties(managerPo, item);
            managerList.add(item);
        }*/
        poPageInfo = new PageInfo<>(managerPoList);
        return poPageInfo;

    }

    //前台根据id查明细
    public Teacher findById(Integer id) {
       TeacherPo  teacherPo=teacherFrontDao.findByid(id);
       Teacher teacher=new Teacher();
        BeanUtils.copyProperties(teacherPo, teacher);
        return teacher;
    }
}
