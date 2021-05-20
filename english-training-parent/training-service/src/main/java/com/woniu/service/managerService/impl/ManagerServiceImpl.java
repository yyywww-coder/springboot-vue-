package com.woniu.service.managerService.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.github.pagehelper.PageInfo;
import com.woniu.adapter.managerAdapter.ManagerAdapter;
import com.woniu.domain.Manager;
import com.woniu.po.ManagerPo;
import com.woniu.service.managerService.ManagerService;
import com.woniu.utils.ConstantPropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {



    @Autowired
    private ManagerAdapter managerAdapter;

    @Override
    public PageInfo<ManagerPo> findByUsername(Integer pageIndex,Integer pageSize,String username) {
        return managerAdapter.findByUsername(pageIndex,pageSize,username);
    }

    @Override
    public List<Manager> findAll() {
        return managerAdapter.findAll();
    }

    @Override
    public void updateManager(ManagerPo manager) {
        managerAdapter.updateManager(manager);
    }

    @Override
    public void addManager(ManagerPo manager) {
        managerAdapter.addManager(manager);
    }

    @Override
    public Manager findByAccount(String account) {
        return managerAdapter.findByAccount(account);
    }

    @Override
    public void delManager(Integer id) {
        managerAdapter.delManager(id);
    }

    @Override
    public Manager doLogin(ManagerPo managerPo) {
        return managerAdapter.doLogin(managerPo);
    }

    @Override
    public Manager findById(Integer id) {
        return managerAdapter.findById(id);
    }

    @Override
    public List<Manager> findAllTeacher(ManagerPo managerPo) {
        managerPo.setStatus("0");
        return managerAdapter.findAllTeacher(managerPo);
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
