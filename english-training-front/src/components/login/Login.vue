<template>
    <div id="div1">
     <div class="section dwo">
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
    </div>
</template>

<script>


export default {
    data(){
        return{
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
        //  登录
        dologin(){
            this.$axios.get("/users/dologin",{
                params:{account:this.loginAcc,password:this.loginPass}
                }).then(ref=>{
                console.log(ref)
                if(ref.data.code ==200){
                        this.$message({
                            type: 'success',
                            message: `登录成功`,
                            duration:800
                        });
                        //保存token
                        localStorage.setItem("token",ref.data.msg)
                        this.$router.push("/home")
                    }else{
                        this.$message({
                            message: ref.data.msg,
                            type: 'warning',
                            duration:800
                        });
                    }
            })
            //this.$router.push('/home')
        },
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
        }
    }

}
</script>

<style  scoped>
@import '../../assets/css/bootstrap.min.css';
@import '../../assets/css/style.css';


.mb-4,.flex-fill{
    color: #ffffff;
}
.mb-0{
    color: #ffffff;
}
</style>
