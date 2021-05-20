package com.woniu.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.vod.model.v20170321.*;

import java.util.HashMap;
import java.util.Map;

public class AliyunUpload {


    //初始化客户端
    public static DefaultAcsClient initVodClient(Map<String, Object> param) {
        DefaultProfile profile = DefaultProfile.getProfile(param.get("regionId").toString(), param.get("accessKeyId").toString(), param.get("accessKeySecret").toString());
        DefaultAcsClient client = new DefaultAcsClient(profile);
        return client;
    }

    /**
     * 获取视频上传地址和凭证
     */
    public static HashMap<String, Object> createUploadVideo(Map<String, Object> param) {
        DefaultAcsClient client = initVodClient(param);

        CreateUploadVideoRequest request = new CreateUploadVideoRequest();
        request.setTitle(param.get("title").toString());
        request.setFileName(param.get("fileName").toString());
        //JSONObject userData = new JSONObject();
        //JSONObject messageCallback = new JSONObject();
        //messageCallback.put("CallbackURL", "http://xxxxx");
        //messageCallback.put("CallbackType", "http");
        //userData.put("MessageCallback", messageCallback.toJSONString());
        //JSONObject extend = new JSONObject();
        //extend.put("MyId", "user-defined-id");
        //userData.put("Extend", extend.toJSONString());
        //request.setUserData(userData.toJSONString());
        HashMap<String, Object> map = new HashMap<>();
        try {
            CreateUploadVideoResponse response = client.getAcsResponse(request);
            map.put("Code", "0");
            map.put("VideoId", response.getVideoId());
            map.put("UploadAddress", response.getUploadAddress());
            map.put("UploadAuth", response.getUploadAuth());
            map.put("RequestId", response.getRequestId());
        } catch (ClientException e) {
            e.printStackTrace();
            map.put("Code", "1");
            map.put("ErrorMessage", e.getLocalizedMessage());
            System.out.println(e.getLocalizedMessage());
        }

        return map;
    }

    /**
     * 刷新视频上传凭证
     */
    public static Map<String, Object> refreshUploadVideo(Map<String, Object> param) {
        DefaultAcsClient client = initVodClient(param);
        RefreshUploadVideoRequest request = new RefreshUploadVideoRequest();
        request.setVideoId(param.get("videoId").toString());

        Map<String, Object> map = new HashMap<>();
        try {
            RefreshUploadVideoResponse response = client.getAcsResponse(request);
            map.put("Code", "0");
            map.put("VideoId", response.getVideoId());
            map.put("UploadAddress", response.getUploadAddress());
            map.put("UploadAuth", response.getUploadAuth());
        } catch (ClientException e) {
            e.printStackTrace();
            map.put("Code", "1");
            map.put("ErrorMessage", e.getLocalizedMessage());
            System.out.println(e.getLocalizedMessage());
        }
        return map;
    }

    /*获取播放凭证函数*/
    public static Map<String, Object> getVideoPlayAuth(Map<String, Object> param) {
        DefaultAcsClient client = initVodClient(param);
        GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();
        request.setVideoId(param.get("videoId").toString());
        request.setAuthInfoTimeout(Long.valueOf(param.get("authInfoTimeout").toString()));
        Map<String, Object> map = new HashMap<>();
        try {
            GetVideoPlayAuthResponse response = client.getAcsResponse(request);
            map.put("Code", "0");
            map.put("PlayAuth", response.getPlayAuth());
            map.put("RequestId", response.getRequestId());
            map.put("VideoId", response.getVideoMeta().getVideoId());
            map.put("Title", response.getVideoMeta().getTitle());
            map.put("CoverUrl", response.getVideoMeta().getCoverURL());
        } catch (ClientException e) {
            e.printStackTrace();
            map.put("Code", "1");
            map.put("ErrorMessage", e.getLocalizedMessage());
            System.out.println(e.getLocalizedMessage());
        }
        return map;
    }
}
