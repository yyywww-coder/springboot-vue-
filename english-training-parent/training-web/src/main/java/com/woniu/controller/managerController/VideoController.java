package com.woniu.controller.managerController;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.vod.model.v20170321.DeleteVideoRequest;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.domain.Course;
import com.woniu.domain.Manager;
import com.woniu.domain.Video;
import com.woniu.po.ManagerPo;
import com.woniu.service.managerService.CourseService;
import com.woniu.service.managerService.ManagerService;
import com.woniu.service.managerService.VideoService;
import com.woniu.utils.ConstantPropertiesUtil;
import com.woniu.utils.InitVodCilent;
import com.woniu.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("video")
@CrossOrigin
public class VideoController {
    @Autowired
    private VideoService videoService;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private CourseService courseService;
    @PostMapping("upload")
    public ResponseResult<String> uploadVideo(@RequestParam("file") MultipartFile file) throws Exception {

        String videoId = videoService.uploadVideo(file);
        return new ResponseResult<>(videoId);
    }
    @PostMapping("addpic")
    public ResponseResult<String> addBanner(MultipartFile file){
        String uploadUrl = videoService.uploadPic(file);
        return new ResponseResult<>(uploadUrl);
    }
    @RequestMapping("teachers")
    public ResponseResult<List<Manager>> getAllTeacher(){
        ManagerPo managerPo = new ManagerPo();
        List<Manager> allTeacher = managerService.findAllTeacher(managerPo);

        return new ResponseResult<>(allTeacher);
    }
    @RequestMapping("grades")
    public ResponseResult<List<Course>> getAllGrade(){
        List<Course> courses = courseService.findAllGradeAndClass();
        return new ResponseResult<>(courses);
    }

    @PostMapping("save")
    public ResponseResult savaVideo(@RequestBody Video video){
        System.out.println(video);
        video.setCreateTime(new Date());
        video.setType("y");
        videoService.saveVideo(video);
        return ResponseResult.SUCCESS;
    }

    @RequestMapping("list")
    public ResponseResult<PageInfo<Video>> getList(@RequestBody Video video, Integer page, Integer limit){
        System.out.println(video);
        PageHelper.startPage(page,limit);
        List<Video> videos = videoService.getList(video);
        PageInfo<Video> pageInfo = new PageInfo<>(videos);
        return new ResponseResult<>(pageInfo);
    }

    //根据视频id删除阿里云视频
    @RequestMapping("remove/{id}")
    public ResponseResult removeAlyVideo(@PathVariable String id) {
        try {
            //初始化对象
            DefaultAcsClient client = InitVodCilent.initVodClient(ConstantPropertiesUtil.ACCESS_KEY_ID, ConstantPropertiesUtil.ACCESS_KEY_SECRET);
            //创建删除视频request对象
            DeleteVideoRequest request = new DeleteVideoRequest();
            //向request设置视频id
            request.setVideoIds(id);
            //调用初始化对象的方法实现删除
            client.getAcsResponse(request);
            //删除数据库的视频
            videoService.removeById(id);
            return ResponseResult.SUCCESS;
        }catch(Exception e) {
            e.printStackTrace();
//            throw new JiacongException(20001,"删除视频失败");
            return null;
        }
    }
}
