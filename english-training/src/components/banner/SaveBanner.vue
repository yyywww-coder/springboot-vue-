<template>
  <div class="app-container">
    Banner表单
    <el-form label-width="120px">
      <el-form-item label="Banner标题">
        <el-input v-model="banner.title"/>
      </el-form-item>
      <el-form-item label="Banner图片">

        <el-upload
          :show-file-list="false"
          :on-success="handleAvatarSuccess"
          :before-upload="beforeAvatarUpload"
          action="http://localhost:8899/banner/add"
          :headers={Authorization:this.token}
          class="avatar-uploader">
          <img :src="banner.imageUrl">
        </el-upload>

      </el-form-item>

      <el-form-item>
        <el-button :disabled="saveBtnDisabled" type="primary" @click="saveOrUpdate()">保存</el-button>
      </el-form-item>
    </el-form>

  </div>
</template>

<script>
  export default {
    name: "SaveBanner",
    data(){
      return{
        banner:{
          title:"",
          imageUrl:'/static/01.jpg'
        },
        saveBtnDisabled:false,  // 保存按钮是否禁用,
        token:localStorage.getItem("token")

      }
    },
    methods:{

      //上传Banner图片成功调用的方法
      handleAvatarSuccess(res, file) {
        console.log(res)
        this.banner.imageUrl = res.data
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
      saveOrUpdate(){
        this.$axios.post("/banner/save",this.banner).then(res=>{
          console.log(res)
          if(res.data.code==200) {
            this.$message({type: 'success', message: "添加成功", duration: 800})
          }
        })
      }
    }
  }
</script>

<style lang="less">

</style>
