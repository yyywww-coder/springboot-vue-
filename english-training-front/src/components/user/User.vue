<template>
  <div id="userInfoDive">
<el-container>
<el-header style="height: 20%;padding:0;">
<div class="con-header">
        <div class="con-header-body">
            <div class="row">
                <div id="topDiv">
                    <div class="portrait">
                        <div class="div-icon">
                            <img id="info-icon" height="160" width="160" src="../../assets/images/default.jpg">
                            <div class="changeIcon" style=""> <!-- margin-left:-80px;margin-top:20px -->
                                <el-button type="info" round @click="changeAva()">更改头像</el-button>
                            </div>
                        </div>
                    </div>
                </div>
                <div id="userInfo">
                    <div class="col-md-9 col-sm-9 col-xs-9 intro">
                        <div class="row"><h3>{{userinfo.username}} <small>  </small> <small>  </small></h3></div>
                            <div class="row user-infor" style="text-align:left">
                                <div class="col-md-4 col-sm-4 col-xs-4  p-text">
                                    <p>电话：<span>{{userinfo.phone}}</span></p>
                                    <p>邮箱：<span>{{userinfo.email==null?'待完善':userinfo.email}}</span></p>
                                    <p>性别：<span>{{userinfo.gender==0?'女':'男'}}</span></p>
                                </div>
                                <div class="col-md-4 col-sm-4 col-xs-4 p-text">
                                    <p>父母电话：<span>{{userinfo.pPhone==null?'待完善':userinfo.pPhone}}</span></p>
                                    <p>父母姓名：<span>{{userinfo.pName==null?'待完善':userinfo.pName}}</span></p>
                                    <p>所在城市：<span>{{userinfo.address==null?'待完善':userinfo.address}}</span></p>
                                </div>
                                <div class="col-md-4 col-sm-4 col-xs-4 p-text">
                                    <p>年龄：<span>{{userinfo.age}}</span></p>
                                    <p>职位：<span>待完善</span></p>
                                    <p>城市：<span>待完善</span></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
        </div>
</div>
</el-header>

<el-container>
    <el-main>
       <el-tabs  style="height: 600px;font-size:30px;margin-left: 200px;">
            <el-tab-pane label="个人资料">
                <el-form ref="userinfo" :rules="rules" status-icon :label-position="labelPosition" label-width="80px" :model="userinfo" style="margin-top:100px;">
                    <div class="leftInput">
                        <el-form-item label="名称:" prop="username">
                            <el-input v-model="userinfo.username"></el-input>
                        </el-form-item>
                        <el-form-item label="邮箱:" prop="email">
                            <el-input v-model="userinfo.email" ></el-input>
                        </el-form-item>
                        <el-form-item label="电话:" prop="phone">
                            <el-input v-model="userinfo.phone"  maxlength="11" show-word-limit></el-input>
                        </el-form-item>
                    </div>

                    <div class="rightInput">
                        <el-form-item label="年龄:" prop="age">
                            <el-input v-model.number="userinfo.age" type="number"></el-input>
                        </el-form-item>
                        <el-form-item label="性别:" prop="gender">
                            <el-radio-group v-model="userinfo.gender" size="medium">
                                <el-radio  label="0">女</el-radio>
                                <el-radio  label="1">男</el-radio>
                            </el-radio-group>
                        </el-form-item>
                        <el-form-item label="区域:" prop="address">
                            <el-input v-model="userinfo.address" type="textarea"></el-input>
                        </el-form-item>
                        <!-- <el-form-item label="">
                            <el-upload
                                :show-file-list="false"
                                :on-success="handleAvatarSuccess"
                                :before-upload="beforeAvatarUpload"
                                action="http://localhost:8081/users/uploadImage"
                                :headers={Authorization:this.token}
                                class="avatar-uploader">
                                <el-button size="small" type="primary">上传图片</el-button> -->

                                <!-- <img :src="userinfo.avatar"> -->
                            <!-- </el-upload>
                        </el-form-item> -->
                    </div>

                    <div class="footInput">
                        <el-form-item style="margin-left:400px;width:500px">
                            <el-button type="primary" @click="submitForm()">修改</el-button>
                            <el-button @click="resetForm('userinfo')">重置</el-button>
                            <el-popover
                                title="密码修改"
                                placement="top-end"
                                width="650px"
                                trigger="click"
                                v-model="visible"
                                >
                                <el-form :model="changePass" status-icon :rules="passRules" ref="changePass" label-width="100px" class="demo-ruleForm">
                                    <el-form-item label="原密码">
                                        <el-input v-model="changePass.password"></el-input>
                                    </el-form-item>
                                    <el-form-item label="密码" prop="pass">
                                        <el-input  type="password" v-model="changePass.pass" autocomplete="off"></el-input>
                                    </el-form-item>
                                    <el-form-item label="确认密码" prop="checkPass">
                                        <el-input type="password" v-model="changePass.checkPass" autocomplete="off"></el-input>
                                    </el-form-item>
                                    <div class="changePassBut">
                                        <!-- <el-button type="primary"  @click="doChange()">确 定</el-button>
                                        <el-button @click="dialogTableVisible = false">取 消</el-button> -->
                                        <div style="text-align: center; margin: 0">
                                            <el-button type="primary" size="mini" @click="doChange()">确定</el-button>
                                            <el-button size="mini" type="text" @click="visible = false">取消</el-button>
                                        </div>
                                    </div>
                                </el-form>
                                <el-button style="margin-left:30px;background-color: darkturquoise;color: white;" slot="reference">密码修改</el-button>
                            </el-popover>
                        </el-form-item>
                    </div>
                </el-form>


            </el-tab-pane>
            <el-tab-pane label="订单管理">
                <el-table
                    :data="userOrder"
                    style="width: 100%"
                    border
                    >
                    <el-table-column
                    prop="userOrder.videoid"
                    label="课程"
                    width="180">
                    </el-table-column>
                    <el-table-column
                    prop="userOrder.money"
                    label="金额"
                    sortable
                    width="180">
                    </el-table-column>
                    <el-table-column
                    prop="userOrder.payType"
                    label="支付方式"
                    width="180">
                    </el-table-column>
                    <el-table-column
                    prop="userOrder.orderTime"
                    label="支付时间"
                    sortable>
                    </el-table-column>
                </el-table>
            </el-tab-pane>
            <el-tab-pane label="查看课程">查看课程</el-tab-pane>
            <el-tab-pane label="邀请注册">
                <div class="invitation">
                    <li class="shaoma">
                        <img src="../../assets/images/erweima.png" alt="" />
                        <p>邀请用户扫码注册</p>
                    </li>
                    <li class="copyusr">
                        <span>复制链接邀请用户注册</span>
                        <p><input class="qrCode" value="www.haipei.com" type="text" readonly="readonly"></p>
						<p><button id="copyUrl" class="btn btn-info pull-right" @click="copy">复制链接</button></p>
                    </li>
                </div>
            </el-tab-pane>
        </el-tabs>
    </el-main>
</el-container>

</el-container>
  </div>
</template>


<script>
export default {
    data (){
        //  密码验证规则
        var validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'));
        } else {
          if (this.changePass.checkPass !== '') {
                this.$refs.changePass.validateField('checkPass');
          }
          callback();
        }
      };
        //   再次输入密码验证规则
      var validatePass2 = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入密码'));
        } else if (value !== this.changePass.pass) {
          callback(new Error('两次输入密码不一致!'));
        } else {
          callback();
        }
      };

        return{
            // 当前登录用户
            account:'',
            tabPosition: 'left',
            //  修改个人简介字体靠右
            labelPosition: 'right',
            token:localStorage.getItem("token"),
            //  用户个人信息
            userinfo:{

            },
            rules: {
                email: [
                        {required:true,message:"邮箱不能为空",trigger: 'blur'},
                     {type: 'email', message: '请输入正确邮箱格式', trigger: 'change'}
                ],
                age: [

                ],
                phone:[
                    {required: true, message: '不能为空', trigger: 'blur'},
                    {pattern: /^0{0,1}(13[0-9]|15[7-9]|153|156|18[7-9])[0-9]{8}$/, message: '请输入正确的手机号', trigger: 'blur'}
                ]
            },
            visible:false,
            //  修改密码
            changePass:{
                password:'',
                pass:'',
                checkPass:''
            },
            //  修改密码规则
            passRules:{
                pass:[
                    { validator: validatePass, trigger: 'blur' },
                    { required: true, message: '请输入密码', trigger: 'blur' },
                    { min: 5, max: 12, message: '长度在 5 到 12 个字符', trigger: 'blur' }
                ],
                checkPass:[
                    { validator: validatePass2, trigger: 'blur' }
                ]
            },

            //  头像集合
            sizeForm:{
                avatar:''
            },
            //  用户订单集合
            userOrder:[]
        }


    },
    methods:{
        //  自己个人信息页面
        myslfe(){
        // 根据用户名获取用户信息
        this.$axios.get("/users/userinfo",{
                params:{
                    account:localStorage.getItem("users")
                }
            }).then(ref=>{
                console.log(ref)
                this.userinfo=ref.data.data
            })
        },
        //  提交修改按钮
        submitForm(){
            this.$axios.post("/users/update",this.userinfo).then(ref=>{
                console.log(ref)
                if(ref.data.code ==200){
                    this.$message({
                        type: 'success',
                        message: '修改成功',
                        duration:800
                    });
                }else{
                    this.$message({
                        message: '修改失败',
                        type: 'warning',
                        duration:800
                    });
                }
            })
        },
        //  重置按钮
        resetForm(userinfo){
            this.$refs[userinfo].resetFields();
        },
        //  修改密码
        doChange(){
            this.$axios.post("/users/changePass",this.userinfo,{

                params:{
                    password:this.changePass.password,
                    pass:this.changePass.pass
                }
            }).then(ref=>{
                console.log(ref)

                if(ref.data.code==200){
                    this.$message({
                        message:'修改密码成功,请重新登录',
                        type:'success',
                        duration:1500
                    });
                    window.localStorage.removeItem('token');
                    this.$router.push("/")
                }else{
                    this.$message({
                        message:ref.data.msg,
                        type:'error',
                        duration:800
                    })
                }
            })
        },
        //  更换头像
        changeAva(){
            this.$axios.post("/users/update",this.userinfo).then(ref=>{
                console.log(ref)
            })
        },
        copy(){
            $(".qrCode").select();
                document.execCommand("Copy"); // 执行浏览器复制命令
                //邀请注册链接复制提醒
                layer.tips('邀请链接已复制，赶快分享给好友吧！', '#copyUrl', {time: 2000,
                tips: [1, '#666666']
                });
        }
        //上传视频图片成功调用的方法
    //   handleAvatarSuccess(res, file) {
    //     console.log(res)
    //     this.userinfo.avatar = res.data
    //   },
      //上传之前调用的方法
    //   beforeAvatarUpload(file) {
    //     const isJPG = file.type === 'image/jpeg'
    //     const isLt2M = file.size / 1024 / 1024 < 2

    //     if (!isJPG) {
    //       this.$message.error('上传头像图片只能是 JPG 格式!')
    //     }
    //     if (!isLt2M) {
    //       this.$message.error('上传头像图片大小不能超过 2MB!')
    //     }
    //     return isJPG && isLt2M
    //   },
        //  格式化指定列
        // formatter(row, column) {
        //     return row.address;
        // }



    },
    created(){

        this.myslfe();
    }

}
</script>


<style>
/*  邀请用户注册 */
.invitation{
    margin-left: 100px;
    margin-top: 100px;
    list-style: none;
}
.shaoma p{
    margin-top:20px;
    margin-left: 0px;
    font-size: 25px;
}
.shaoma span{
    margin-bottom:50px;
    margin-left: 40px;
}

/*  复制链接 */
.copyusr{
    float: left;
    margin-left: 100px;
}
.copyusr input{
    width: 300px;
    height: 50px;
}

/*  扫码 */
.shaoma{
    float: left;

}

.footInput{

   padding-top: 200px;
}
.rightInput{
    float: left;
    margin-left: 100px;
}
.leftInput{
    float: left;
}

#userInfoDive .el-input{
    width: 400px;
}

#userInfoDive .el-tabs__item {
    padding: 0 20px;
    height: 40px;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
    line-height: 40px;
    display: inline-block;
    list-style: none;
    font-size: 30px;
    font-weight: 500;
    color: #303133;
    position: relative;
    margin-top: 70px;
}


#userInfoDive .el-header{
    width: 100%;
    height: 220px;
}
 .con-header {
    width: 100%;
    height: 220px;
    background-image: url('../../assets/images/userinfo-head.jpg') ;
    border: 1px blue solid;
}
#userInfoDive .row{
    color: white;
}
#topDiv{

    margin-left: 250px;
}
#userInfo{
    margin-left: 100px;
    width: 900px;
    height: 150px;
}
#info-icon{

    border-radius:160px
}

.row p {
        display: block;
        margin-block-start: 1em;
        margin-block-end: 1em;
        margin-inline-start: 0px;
        margin-inline-end: 0px;
}
p-text p{

 width: 120px;
}

</style>
