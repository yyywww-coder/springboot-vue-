package com.woniu.controller.frontController;

import com.woniu.utils.AliyunUpload;
import com.woniu.utils.ConstantPropertiesUtil;
import com.woniu.utils.ResponseResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("oss/file")
public class VodController {

    @GetMapping("createUploadVideo")
    public ResponseResult<Map<String, Object>> createUploadVideo(@RequestParam Map<String, Object> params){
        params.put("regionId",ConstantPropertiesUtil.REGIONID);
        params.put("accessKeyId",ConstantPropertiesUtil.ACCESS_KEY_ID);
        params.put("accessKeySecret",ConstantPropertiesUtil.ACCESS_KEY_SECRET);

        Map<String, Object> resultMap = AliyunUpload.createUploadVideo(params);
        return new ResponseResult<>(resultMap);
    }

    @GetMapping("refreshUploadVideo")
    public ResponseResult<Map<String, Object>> refreshUploadVideo( @RequestParam Map<String, Object> params){
        params.put("regionId",ConstantPropertiesUtil.REGIONID);
        params.put("accessKeyId",ConstantPropertiesUtil.ACCESS_KEY_ID);
        params.put("accessKeySecret",ConstantPropertiesUtil.ACCESS_KEY_SECRET);

        Map<String, Object> resultMap = AliyunUpload.refreshUploadVideo(params);
        return new ResponseResult<>(resultMap);
    }

    @GetMapping("getVideoPlayAuth")
    public ResponseResult<Map<String, Object>> getVideoPlayAuth(@RequestParam Map<String, Object> params){
        params.put("regionId",ConstantPropertiesUtil.REGIONID);
        params.put("accessKeyId",ConstantPropertiesUtil.ACCESS_KEY_ID);
        params.put("accessKeySecret",ConstantPropertiesUtil.ACCESS_KEY_SECRET);
        params.put("authInfoTimeout",3000);//播放凭证过期时间。取值范围：100~3000。

        Map<String, Object> resultMap = AliyunUpload.getVideoPlayAuth(params);
        return new ResponseResult<>(resultMap);
    }
}
