package com.woniu.service.frontService.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.woniu.adapter.frontAdapter.UserFrontAdapter;
import com.woniu.po.UserPo;
import com.woniu.service.frontService.UserFrontService;
import com.woniu.utils.ConstantPropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Service
@Transactional
public class UserFrontServiceImpl implements UserFrontService {

        @Autowired
        private UserFrontAdapter userFrontAdapter;

        @Override
        public void registeUuser(UserPo userPo) {
                userFrontAdapter.userRegister(userPo);
        }

        @Override
        public UserPo getByEmail(String email) {
                return userFrontAdapter.findByEmail(email);
        }

        @Override
        public UserPo getByAccount(String account) {
                return userFrontAdapter.findAccount(account);
        }

        @Override
        public void updateUser(UserPo userPo) {
                userFrontAdapter.updateUser(userPo);
        }


        public String uploadImage(MultipartFile file) {
                // yourEndpoint填写Bucket所在地域对应的Endpoint。以华东1（杭州）为例，Endpoint填写为https://oss-cn-hangzhou.aliyuncs.com。
                String endpoint = ConstantPropertiesUtil.END_POINT;
                // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
                String accessKeyId = ConstantPropertiesUtil.ACCESS_KEY_ID;
                String accessKeySecret = ConstantPropertiesUtil.ACCESS_KEY_SECRET;
                String bucketName = ConstantPropertiesUtil.BUCKET_NAME;

                try {
                        // 创建OSSClient实例。
                        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

                        // 填写本地文件的完整路径。如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件流。
                        InputStream inputStream = file.getInputStream();
                        //获取文件名称
                        String fileName = file.getOriginalFilename();
                        // 填写Bucket名称和Object完整路径。Object完整路径中不能包含Bucket名称。
                        ossClient.putObject(bucketName, fileName, inputStream);

                        // 关闭OSSClient。
                        ossClient.shutdown();
                        //把上传之后文件路径返回
                        //需要把上传到阿里云oss路径手动拼接出来
                        String uploadUrl = "https://"+bucketName+"."+endpoint+"/"+fileName;
                        return uploadUrl;
                } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                }
        }
}
