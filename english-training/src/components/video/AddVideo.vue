<template>
    <div class="app-container">
      <h2 style="text-align: center;">发布新课程</h2>
    <!-- 添加和修改课时表单 -->

      <el-form :model="video" label-width="120px">
        <el-form-item label="视频标题">
          <el-input v-model="video.title"/>
        </el-form-item>
        <el-form-item label="视频价格">
          <el-input v-model="video.price"/>
        </el-form-item>
        <el-form-item label="视频类别">
          <el-dropdown trigger="click" type="primary" @command="handleCommand">
            <el-button type="primary" class="el-dropdown-link btn send time-send small-hand" id="custom-sebd-btn">
              {{custom}}<i class="el-icon-arrow-down el-icon--right"></i>
            </el-button>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item :command="grades.gradeOne">少儿</el-dropdown-item>
              <el-dropdown-item :command="grades.gradeTwo">初中</el-dropdown-item>
              <el-dropdown-item :command="grades.gradeThr">高中</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </el-form-item>

        <el-form-item label="讲课老师">
          <el-dropdown trigger="click" type="primary" @command="teacherCommand">
            <el-button type="primary" class="el-dropdown-link btn send time-send small-hand">
              {{tName}}<i class="el-icon-arrow-down el-icon--right"></i>
            </el-button>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item v-for="(teacher,index) in teachers" :command="teacher" :key="index">{{teacher.username}}</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </el-form-item>

        <el-form-item label="视频图片">
          <el-upload
            :show-file-list="false"
            :on-success="handleAvatarSuccess"
            :before-upload="beforeAvatarUpload"
            action="http://localhost:8899/video/addpic"
            :headers={Authorization:this.token}
            class="avatar-uploader">
            <el-button size="small" type="primary">上传图片</el-button>
            <img :src="video.imageUrl">
          </el-upload>
        </el-form-item>

        <el-form-item label="上传视频">
          <el-upload
            :on-success="handleVodUploadSuccess"
            :on-remove="handleVodRemove"
            :before-remove="beforeVodRemove"
            :on-exceed="handleUploadExceed"
            action="http://localhost:8899/video/upload"
            :headers={Authorization:this.token}
            :limit="1"
            class="upload-demo">
            <el-button size="small" type="primary">上传视频</el-button>
            <el-tooltip placement="right-end">
              <div slot="content">最大支持1G，<br>
                支持3GP、ASF、AVI、DAT、DV、FLV、F4V、<br>
                GIF、M2T、M4V、MJ2、MJPEG、MKV、MOV、MP4、<br>
                MPE、MPG、MPEG、MTS、OGG、QT、RM、RMVB、<br>
                SWF、TS、VOB、WMV、WEBM 等视频格式上传</div>
              <i class="el-icon-question"/>
            </el-tooltip>
          </el-upload>
        </el-form-item>
        <el-form-item label="视频描述">
          <!-- 课程简介-->
            <el-input type="textarea" :row="5" v-model="video.description"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button :disabled="saveVideoBtnDisabled" type="primary" @click="saveOrUpdateVideo">确 定</el-button>
      </div>

  </div>
</template>

<script>
  export default {
    name: "AddVideo",
    data(){
      return{
        video: {
          title: '',
          price: 0,
          courseId:1,
          videoSourceId: '',
          videoOriginalName:'',//视频名称
         imageUrl:'',
          description:'',
          teacherId:1
        },
        token:localStorage.getItem("token"),
        saveVideoBtnDisabled:false,
        //  年级
        grades:{
          gradeOne:"少儿",
          gradeTwo:"初中",
          gradeThr:"高中"
        },
        custom:'年级',
        teachers:[],
        tName:'主讲老师'
      }
    },
    created(){
      this.getAllTeacher()
    },
    methods: {
      //获取所有的教师姓名
      getAllTeacher(){
        this.$axios.get("video/teachers").then(res=>{
          this.teachers=res.data.data
          console.log(res)
        })
      },
      teacherCommand(command){
        this.tName=command.username
        this.video.teacherId=command.id
      },
      handleCommand(command){
        this.custom=command
        if(command=="少儿"){
          this.video.courseid=1
        }else if(command=="初中"){
          this.video.courseid=2
        }else{
          this.video.courseid=3
        }
        console.log(this.video.courseid)
      },
      //点击确定调用的方法
      handleVodRemove() {
        //调用接口的删除视频的方法

      },
      //点击×调用这个方法
      beforeVodRemove(file, fileList) {
        return this.$confirm(`确定移除 ${file.name}？`);
      },
      //上传视频成功调用的方法
      handleVodUploadSuccess(res, file, fileList) {
        this.video.videoSourceId=res.data
        console.log(res)
        //上传视频id赋值
        //this.video.videoSourceId = res.data.videoId
        //上传视频名称赋值
        //this.video.videoOriginalName = file.name
      },
      handleUploadExceed() {
        this.$message.warning('想要重新上传视频，请先删除已上传的视频')
      },
      saveOrUpdateVideo(){
        this.$axios.post("video/save",this.video).then(res=>{
          console.log(res)
          if(res.data.code==200) {
            this.$message({type: 'success', message: "添加成功", duration: 800})
          }
        })
      },
      //上传视频图片成功调用的方法
      handleAvatarSuccess(res, file) {
        console.log(res)
        this.video.imageUrl = res.data
      },
      //上传之前调用的方法
      beforeAvatarUpload(file) {
        const isJPG = file.type === 'image/jpeg'
        const isLt2M = file.size / 1024 / 1024 < 2

        if (!isJPG) {
          this.$message.error('上传头像图片只能是 JPG 格式!')
        }
        if (!isLt2M) {
          this.$message.error('上传头像图片大小不能超过 2MB!')
        }
        return isJPG && isLt2M
      },
    }
  }
</script>

<style lang="less" scoped>

</style>
