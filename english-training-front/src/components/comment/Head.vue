<template>
  <div id="headDiv">
<el-header style="height:15%;padding:0;background-color:#dbdbdb;">
<el-row>
      <!-- 左 -->
  <el-col :span="8">
    <div>
      <img src="@/assets/images/logo.png" alt="" />
    </div>
    <div class="grid-content bg-purple"></div>
</el-col>
      <!-- 中 -->
  <el-col :span="8">
    <div>
        <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
        <el-menu-item index="/home">首页</el-menu-item>
            <el-menu-item index="/video">课程</el-menu-item>
            <el-menu-item index="/news">海培新闻</el-menu-item>
            <el-menu-item index="/question">调查问卷</el-menu-item>
          <el-menu-item index="/teacher">名师</el-menu-item>
          <el-menu-item index="/index">学员中心</el-menu-item>
            <el-submenu index="2">
                <template slot="title">海培英语</template>
                    <el-menu-item index="/book">好书推荐</el-menu-item>
            </el-submenu>

        </el-menu>
    </div>
    <div class="grid-content bg-purple-light"></div>
    </el-col>
    <!-- 右 -->
    <el-col :span="8">
        <div class="top_right">
            <el-button  :hidden="loginBut"  icon="el-icon-user-solid" @click="showLogin()">登录</el-button>
            <!-- <el-button type="primary" icon="el-icon-user">注册</el-button> -->

        </div>
        <div class="demo-type" :hidden="avatar" >
                <el-avatar :size="60" >
                    <img src="../../assets/images/default.jpg" @click="myslfe()"/>
                </el-avatar>
        </div>
        <div class="loginOut">
            <el-button  :hidden="avatar" @click="loginOut()" icon="el-icon-switch-button">注销</el-button>
        </div>

        <div class="grid-content bg-purple"></div>
    </el-col>
</el-row>


    <el-dialog   width="30%"  :visible.sync="modelShow" :show-close="false">
            <div class="section dwo" :hidden="openlogin">
                <div class="container">
                    <div class="row full-height justify-content-center">
                        <div class="col-12 text-center align-self-center py-5">
                            <div class="section pb-5 pt-5 pt-sm-2 text-center">
                                <input class="checkbox" type="checkbox" id="reg-log" name="reg-log">
                                <div class="card-3d-wrap mx-auto">
                                    <div class="card-3d-wrapper">
                                        <div class="card-front">
                                            <div class="center-wrap">
                                                <div class="section text-center">
                                                    <h4 class="mb-4 pb-3" >海培英语</h4>
                                                    <div class="form-group">
                                                        <i class="iconfont icon-yonghu3"><input type="email"  v-model="loginAcc" name="logemail" class="form-style " placeholder="请输入账号" id="logemail" autocomplete="off">
                                                    </i>
                                                    </div>
                                                    <div class="form-group mt-2">
                                                        <i class="iconfont icon-mima1"></i><input type="password" v-model="loginPass" name="logpass" class="form-styles" placeholder="请输入密码" id="logpass" autocomplete="off">

                                                    </div>
                                                    <a href="javascript:" @click.prevent="dologin()" class="btn mt-4">登录</a>
                                                    <div class="d-flex justify-content-between mt-4 text-left">
                                                        <div class="flex-fill">
                                                            <p>没有帐号？<label for="reg-log">立即注册</label></p>
                                                        </div>
                                                        <div class="flex-fill text-right">
                                                            <p><a href="javascript:" class="forgot link">忘记密码？</a></p>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="card-back">
                                            <div class="center-wrap">
                                                <div class="section text-center">
                                                    <h4 class="mb-4 pb-3">注册</h4>
                                                    <div class="form-group">
                                                        <input type="text" v-model="users.account" name="logname" class="form-style" placeholder="请输入用户名" id="logname" autocomplete="off">
                                                        <i class="input-icon uil uil-user"></i>
                                                    </div>
                                                    <div class="form-group mt-2">
                                                        <input type="email" v-model="users.email" name="logemail" class="form-style" placeholder="请输入电子邮箱" id="logemail" autocomplete="off">
                                                        <i class="input-icon uil uil-at"></i>
                                                    </div>
                                                    <div class="form-group mt-2">
                                                        <input type="password" v-model="users.password" name="logpass" class="form-style" placeholder="请输入密码" id="logpass" autocomplete="off">
                                                        <i class="input-icon uil uil-lock-alt"></i>
                                                    </div>
                                                    <a href="javascript:" @click.prevent="doregister()" class="btn mt-4">注册</a>
                                                    <p class="mb-0 mt-4 text-center">已有帐号？<label for="reg-log">立即登录</label> <span v-html="html"></span></p>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


        </el-dialog>

        <el-dialog   width="30%"  :visible.sync="huakuai" :show-close="false">
            <slide-verify :hidden="verify" :l="42"
                :r="10"
                :w="310"
                :h="155"
                @success="onSuccess"
                @fail="onFail"
                @refresh="onRefresh"

                :slider-text="text"
                ></slide-verify>
                <div>{{msg}}</div>
        </el-dialog>

</el-header>
  </div>

</template>

<script>
import $ from 'jquery' //在需要使用的页面中
export default {

    data(){
        return{
            openlogin:false,
            checks:true,
            verify:false,
            msg: '',
            text: '向右滑',
            activeIndex: '1',
            activeIndex2: '1',
            modelShow:false,
            huakuai:false,
            loginBut:false,
            avatar:true,
            //  登录账号
            loginAcc:'zhangsan',
            loginPass:'123456',
            //  注册账号
            users:{
                account:'',
                email:'',
                password:''
            },
            //  注册成功提示
            html:""
        }
    },
    methods:{
        direction(){},

        onSuccess(){
            this.openlogin=true;
            this.$axios.get("/users/dologin",{
                params:{account:this.loginAcc,password:this.loginPass}
                }).then(ref=>{
                console.log(ref)
                if(ref.data.code ==200){
                    this.$message({
                        type: 'success',
                        message: '欢迎你'+this.loginAcc,
                        duration:800
                    });
                    this.verify=true;
                    this.huakuai=false;
                    this.$router.push('/')
                    //保存token
                    localStorage.setItem("token",ref.data.msg)
                    console.log(ref.data.msg)
                    this.modelShow=false;
                    this.loginBut=true;
                    this.avatar=false;
                    this.$router.push('/')
                }else{
                    this.$confirm(ref.data.msg, '提示', {
                        confirmButtonText: '确定',
                        type: 'warning'
                        }).then(() => {
                            this.verify=true;
                            this.huakuai=false;
                            this.modelShow=true;
                            this.$router.go('/')
                        })
                }
            })

            // this.msg = 'login success'
        },


        onFail(){
            this.msg = ''
        },
        onRefresh(){
            this.msg = ''
        },

        //  顶部跳转页面
        handleSelect(key, keyPath) {
        console.log(key, keyPath);
        this.$router.push(key)
        },
        showLogin(){
            this.modelShow=true
        },
        //  登录
        dologin(){
            this.huakuai=true;
            this.modelShow=false;
            this.verify=false;
            // this.$axios.get("/users/dologin",{
            //     params:{account:this.loginAcc,password:this.loginPass}
            //     }).then(ref=>{
            //     console.log(ref)
            //     if(ref.data.code ==200){
            //         this.$message({
            //             type: 'success',
            //             message: '欢迎你'+this.loginAcc,
            //             duration:800
            //         });
            //         //保存token
            //         localStorage.setItem("token",ref.data.msg)
            //         console.log(ref.data.msg)
            //         this.modelShow=false;
            //         this.loginBut=true;
            //         this.avatar=false;
            //     }else{
            //         this.$message({
            //             message: ref.data.msg,
            //             type: 'warning',
            //             duration:800
            //         });
            //     }
            // })
            //this.$router.push('/home')
        },
        //  注册
        doregister(){
            this.$axios.post("/users/doregister",this.users).then(ref=>{
                console.log(ref)
                if(ref.data.code ==200){
                        this.$message({
                            type: 'success',
                            message: `注册成功`,
                            duration:800
                        });
                        //this.$router.go(-1)
                        this.users.account='';
                        this.users.email='';
                        this.users.password='';
                        this.html="<b style='color:red'class='iconfont icon-60'></b>"
                    }else{
                        this.$message({
                            message: ref.data.msg,
                            type: 'warning',
                            duration:1000
                        });
                    }
            })
        },
        //  退出
        loginOut(){
            this.$confirm('确定注销吗?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
                }).then(() => {
                    window.localStorage.removeItem('token');
                    if(localStorage.getItem("token") ==null){
                        this.$message({
                            type: 'success',
                            message: '注销成功',
                            duration:800
                        });
                        this.$router.go(0)
                        this.loginBut=false;
                        this.avatar=true;
                    }else{
                        this.$message({
                            message: '注销失败',
                            type: 'warning',
                            duration:800
                        });
                    }
                }).catch(() => {
                this.$message({
                    type: 'info',
                    message: '已取消',
                    duration:1000
                });
                });
        },
        //  自己个人信息页面
        myslfe(){
            // 根据用户名获取用户信息
            this.$axios.get("/users/userinfo",{
                params:{
                    account:this.loginAcc
                }
            }).then(ref=>{
                console.log(ref)
                localStorage.setItem("users",ref.data.data.account)
                this.$router.push("/user")
                //console.log(localStorage.getItem("users"))
            })
        }
    },
    created(){
    //     刚创建时判断浏览器中是否缓存有token
        if(localStorage.getItem("token") !=null){
            this.loginBut=true;
            this.avatar=false;

        }
        if(localStorage.getItem("token")==null){
            this.loginBut=false;

        }
    }

}
</script>

<style >
@import '../../assets/css/bootstrap.min.css';
@import '../../assets/css/style.css';

.demo-type{

    float: left;
    margin-left: 200px;
}
.loginOut{
    float: right;
    margin-right: 250px;
}
#headDiv .el-dialog{
    height: 0px;
    width: 0px;
}


.mb-4,.flex-fill{
    color: #ffffff;
}
.mb-0{
    color: #ffffff;
}


#headDiv .el-header{
    color: rgb(44, 14, 216);
    text-align: center;
    line-height: 60px;
  }
.top_right{
  margin-top: 20px;
}
#headDiv .el-menu-demo{
  background-color: transparent;
  margin-top: 20px;
}
</style>
