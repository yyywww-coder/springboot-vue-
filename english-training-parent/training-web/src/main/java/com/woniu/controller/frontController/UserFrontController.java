package com.woniu.controller.frontController;

import com.woniu.po.UserPo;
import com.woniu.service.frontService.UserFrontService;
import com.woniu.utils.JwtTokenUtil;
import com.woniu.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@RequestMapping("/users/")
public class UserFrontController {

        @Autowired
        private UserFrontService userFrontService;

        /**
         * 登录
         * @param account
         * @param password
         * @return
         * @throws Exception
         */
        @RequestMapping("dologin")
        public ResponseResult dologin(String  account,String password) throws Exception {
                UserPo byAccount = userFrontService.getByAccount(account);
                if(byAccount != null){
                       if(byAccount.getPassword().equals(password)){
                               String token = JwtTokenUtil.createSign(byAccount.getUsername());
                               return new ResponseResult(200,token);
                       }else{
                               return new ResponseResult(400,"密码错误");
                       }
                }else{
                        return new ResponseResult(400,"账号不存在");
                }
        }


        /**
         * 注册
         * @param userPo
         * @return
         */
        @RequestMapping("doregister")
        public ResponseResult doregister(@RequestBody UserPo userPo){
                //首先检查是否存在相同邮箱
                UserPo byEmail = userFrontService.getByEmail(userPo.getEmail());
                if(byEmail !=null){
                        return new ResponseResult(400,"邮箱已存在");
                }else{
                        userPo.setAvatar("/default.jpg");
                        userPo.setStatus("0");
                        try {
                                // 调用新增方法
                                userFrontService.registeUuser(userPo);
                                return ResponseResult.SUCCESS;
                        } catch (Exception e) {
                                return new ResponseResult(400,"添加用户失败");
                        }
                }
        }


        /**
         * 查找个人信息
         * @param account
         * @return
         */
        @RequestMapping("userinfo")
        public ResponseResult userinfo(String account){
                UserPo byAccount = userFrontService.getByAccount(account);
                return new ResponseResult(byAccount);
        }


        /**
         * 修改
         * @param userPo
         * @return
         */
        @RequestMapping("update")
        public ResponseResult update(@RequestBody UserPo userPo){
                userFrontService.updateUser(userPo);

                return ResponseResult.SUCCESS;
        }


        /**
         * 修改密码
         * @return
         */
        @RequestMapping("changePass")
        public ResponseResult updatePass(@RequestBody UserPo userPo,String pass,String password){
                // 查找是否有该密码
                UserPo byAccount = userFrontService.getByAccount(userPo.getAccount());
                if(byAccount.getPassword().equals(password)){
                        userPo.setPassword(pass);
                        userFrontService.updateUser(userPo);
                        return ResponseResult.SUCCESS;
                }else{
                        return new ResponseResult(400,"原密码错误");
                }

        }

        /**
         * 图片上传至阿里云
         * @param file
         * @return
         */
        @PostMapping("uploadImage")
        public ResponseResult<String> uploadImage(MultipartFile file){
                String uploadImage = userFrontService.uploadImage(file);
                return new ResponseResult<>(uploadImage);
        }


        /**
         * 更换用户图片路径
         * @return
         */
        @RequestMapping("updateImg")
        public ResponseResult updateImg(@RequestBody UserPo userPo){
                userFrontService.updateUser(userPo);
                return ResponseResult.SUCCESS;
        }

}
