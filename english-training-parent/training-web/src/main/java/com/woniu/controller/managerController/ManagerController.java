package com.woniu.controller.managerController;


import com.woniu.domain.Manager;
import com.github.pagehelper.PageInfo;
import com.woniu.po.ManagerPo;
import com.woniu.service.managerService.ManagerService;
import com.woniu.utils.JwtTokenUtil;
import com.woniu.utils.ResponseResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@RequestMapping("manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    /**
     * 所有
     * @return
     */
    /*@RequestMapping("/list")
    public ResponseResult<List> findAll(){
        List<ManagerPo> managerList = managerService.findAll();
        System.out.println(managerList);
        return new ResponseResult<>(managerList);
    }*/
    @RequestMapping("/list")
    public ResponseResult<PageInfo<Manager>> list(Integer pageIndex, Integer pageSize, String searchText){
        if (searchText != null){
            PageInfo<ManagerPo> poPageInfo = managerService.findByUsername(pageIndex,pageSize,searchText);
            PageInfo<Manager> pageInfo = new PageInfo<>();
            BeanUtils.copyProperties(poPageInfo,pageInfo);
            return new ResponseResult<>(pageInfo);
        }

        return null;
    }

    /**
     * 登录
     */
    @RequestMapping("/login")
    public ResponseResult doLogin(@RequestBody Manager manager) throws Exception{
        System.out.println(manager);
        Manager m = managerService.findByAccount(manager.getAccount());
        if (m != null){
            if (!m.getPassword().equals(manager.getPassword())){
                return new ResponseResult(400,"账号或密码错误");
            }else{
                String token= JwtTokenUtil.createSign(manager.getAccount());
                return new ResponseResult(200,token);
            }
        }else{
            return new ResponseResult(400,"该账号不存在");
        }

    }

    /**
     * 删除
     */
    @RequestMapping("del")
    @RequiresPermissions("teacher:delete")
    public ResponseResult del(Integer id){
        managerService.delManager(id);
        return new ResponseResult(200,"删除成功");
    }

    @RequestMapping("goUpdate")
    @RequiresPermissions("teacher:update")
    public ResponseResult goupdate(){
        return ResponseResult.SUCCESS;

    }

    /**
     * 修改
     * @param manager
     * @return
     */
    @RequestMapping("update")
    //@RequiresPermissions("teacher:update")
    public ResponseResult update(@RequestBody ManagerPo manager){
        managerService.updateManager(manager);
        return ResponseResult.SUCCESS;

    }


    @RequestMapping("goAdd")
    @RequiresPermissions("teacher:add")
    public ResponseResult goAdd(){
        return ResponseResult.SUCCESS;

    }

    /**
     * 添加
     * @param manager
     * @return
     */
    @RequestMapping("add")
    public ResponseResult add(@RequestBody ManagerPo manager){
        managerService.addManager(manager);
        return ResponseResult.SUCCESS;

    }

    @RequestMapping("getByAccount")
    public ResponseResult getByAccount(String account){
        Manager manager = managerService.findByAccount(account);
        return new ResponseResult<>(manager);
    }
    @PostMapping("uploadImage")
    public ResponseResult<String> uploadImage(MultipartFile file){
        String uploadImage = managerService.uploadImage(file);
        return new ResponseResult<>(uploadImage);
    }

    @RequestMapping("unauthenticated")
    public ResponseResult<Void> unauthenticated(){
        return ResponseResult.Unauthenticated;
    }

}
