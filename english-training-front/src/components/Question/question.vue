<template>
    <div id="div1">
      <div class="demo-image__placeholder">
        <div class="block">
          <img src="../../assets/images/abo-banner.jpg" alt="" />
        </div>
      </div>
      <el-card style="padding:5%;">
        <div class="suggest">
          <span>
            投诉建议
          </span>

          <li>
            <p>
            感谢您对海培英语的关注，如果您对我们的网站有任何的疑义或者相关建议，可以通过以下方式联系我们
            </p>
            1、联系之前为您服务的客服<br>
            2、拨打海培英语投诉电话：400-700-2022<br>
            3、发送邮件到海培英语信箱：haipei@163.com<br>
            4、给我们在线留言
          </li>
        </div>
        <div class="choose">

            <p>反馈科目：</p>
            <div >
            <el-radio-group v-model="radio1">
              <el-radio-button label="少儿"></el-radio-button>
              <el-radio-button label="初中"></el-radio-button>
              <el-radio-button label="高中"></el-radio-button>
            </el-radio-group>
          </div>
          <p>反馈类型：</p>
           <div style="margin: 20px 0 0 50px">
            <el-radio v-model="radio2" label="1" border size="medium">支付问题</el-radio>
            <el-radio v-model="radio2" label="2" border size="medium">课程教学</el-radio>
            <el-radio v-model="radio2" label="3" border size="medium">求助建议</el-radio>
            <el-radio v-model="radio2" label="4" border size="medium">主讲教师</el-radio>
            <el-radio v-model="radio2" label="5" border size="medium">其它</el-radio>
          </div>
        </div>
        <el-form ref="form" :model="form" label-width="100px" width="80px" style="margin-left:50px;">
          <el-form-item label="自我评价:" >

            <el-input maxlength="20" show-word-limit type="text" placeholder="请输入评价" v-model="form.sRemarks"  ><i class="el-icon-edit el-input__icon" slot="suffix"></i>

            </el-input>
          </el-form-item>

          <el-form-item label="老师评价:">

            <el-input type="textarea" :rows="6" placeholder="请详细描述您对讲师建议" v-model="form.tRemarks" maxlength="35" show-word-limit ></el-input>

          </el-form-item>

          <el-form-item label="海培建议:">
            <el-input type="textarea" :rows="6" placeholder="请详细描述您的建议、意见、问题等。" v-model="form.suggestions" maxlength="35" show-word-limit></el-input>
          </el-form-item>
          <el-form-item>
            <el-button style="margin-right:20px;" type="primary" @click="onSubmit">提交评论</el-button>
              <el-switch
                v-model="value1"
                active-text="同意">
              </el-switch>
            <el-button type="text" @click="dialogVisible = true">《海培用户隐私保护协议》</el-button>
          </el-form-item>
        </el-form>

        <el-dialog
          title="提示"
          :visible.sync="dialogVisible"
          width="30%"
          style="background-color: #dfdfdf;color:#000000;"
          :before-close="handleClose">
          <span >隐私条款（请认真阅读以下内容）<br>
1.您的个人资料<br>
我们的网站记录您的电脑的IP地址和浏览器类型，但是我们不将该数据与任何能够确定您的个人身份的东西相连。这意味着用户上网的情形将被追踪，但用户仍然保持匿名。我们记录这一资料，以便监测客户的用量规律和网站的使用情况，这帮助我们不断改进海培英语的设计和布局。 以上做法有任何疑问，请与我们联络。<br>

2.安全措施<br>
我们使用的是具有安全设置的服务器来接收您的信用卡信息。 我们只有用正确的密码才能得到您的个人信息和课程情况，以防有人非法盗用。如果您在没有登出的状态下离开电脑，我们会让您在一定时间后自动登出。<br>

3.会员注册<br>
海培英语提供丰富的英语课程体验。如果您想参加一门课程，享受免费试用或成为我们团体服务的用户之一，您需要成为海培英语的会员。您一旦成为会员，便意味着您同意海培英语和其它海培英语旗下公司使用您参加海培英语期间生成的图像，言论，照片，视频短片等资料在任何媒体上进行海培英语的推广和宣传，包括所有的广告，邀请或商业活动。<br>

4.Cookies<br>
“Cookies”是用来记录您浏览器或硬盘中储存的信息。 我们只是用它来确定您所在的国家，以便给您提供相应的语种服务。 我们的“Cookies”不会从您的浏览器或硬盘里攫取更多的信息。大多数浏览器可以让您选择不接受“Cookies”，但这样做可能会使您失去海培英语更多更好的服务。 如果您点击我们的广告客户在我们的网站所做的广告，您可能存储cookies！我们对这些不进行控制，同样也不享有他们可能收集的任何信息。<br>

5.IP地址和浏览器类型<br>
我们索取您的信息，主要目的是给您提供更加个性化的服务。我们尊重您的隐私，不会出售、出租或交换您的姓名及个人信息给其他的机构。</span>
          <span slot="footer" class="dialog-footer">
            <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
          </span>
        </el-dialog>
      </el-card>

    </div>
</template>
  <script>
      import axios from "axios";
    export default {
      data() {
        return {
          // 反馈课程
          radio1:'',
          // 反馈类型
          radio2:'',
          // 用户协议弹框
          dialogVisible: false,
          // 是否同意协议
          value1: true,
          form: {
           sRemarks:"",
            tRemarks:"",
            suggestions:"",
          }
        }
      },
      methods: {
        onSubmit() {
          console.log(this.form);
          	this.$axios.post("front/survey/adds",this.form,{
        headers: {
          Authorization: localStorage.getItem('token')
        },
      }).then(res => {

        if (res.data.code == 200) {
          this.$message({ type: 'success', message: "谢谢您的评论,多谢合作", duration: 800 });
          this.addDialogFormVisible = false;

          //重新加载页面
        //   this.loadSurvey('', 1)
        }
        else {
          this.$message({ type: 'warning', message: "没有添加权限", duration: 800 });
        }
      })
        }
      }
    }
  </script>

<style>
/*  投诉类型 */
.choose{
  margin-left: 100px;
  margin-bottom: 50px;
}
.choose p{
  font-size: 20px;
}
.choose div{
  margin-left: 25px;
}
/*  投诉建议顶部文字 */
.suggest{
  list-style: none;
  margin-bottom: 60px;
  margin-left: 100px;
}
.suggest span{
  font-size: 25px;
  color: green;
  margin-bottom: 50px;

}
.suggest p{
  font-size: 20px;
}
.suggest li{
  margin-top: 80px;

}
.choose div{
  margin-left: 25px;
}
/*  投诉建议顶部文字 */
.suggest{
  list-style: none;
  margin-bottom: 60px;
  margin-left: 100px;
}
.suggest span {
  font-size: 25px;
  color: green;
  margin-bottom: 50px;
}

/* .el-textarea__inner {
  width:30%;
} */
#div1 .el-textarea{
   width:30%;
   font-size: 18px;
}
#div1 .el-input__inner {
    height: 50px;
    font-size: 20px;
   width: 800px;
}
#div1 .el-input--suffix{
  width: 800px;
}
.suggest p{
  font-size: 20px;
}
.suggest li{
  margin-top: 80px;
}

/* .el-textarea__inner {
  width:30%;
} */
#div1 .el-textarea{
   width:30%;
   font-size: 18px;
}
#div1 .el-input__inner {
    height: 50px;
    font-size: 20px;
   width: 800px;
}
#div1 .el-input--suffix{
  width: 800px;
}
#div1 .el-input__inner:hover {
    border-color: #e9e9e9;
}

#div1 .el-input__inner:focus {
    border-color: #42a5f5;
    box-shadow: none;
    transition-duration: .5s;
}

#div1 .el-input__inner::-webkit-input-placeholder {
    line-height: 20px;
}

#div1 .el-input__inner, .el-checkbox__inner, .el-textarea__inner, .el-button {
    border-radius: 0;
}

  </style>
