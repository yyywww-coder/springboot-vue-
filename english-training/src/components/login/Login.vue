<template>
  <div class="login-container">
    <el-form ref="loginForm" :model="loginForm" :rules="loginRules" class="login-form" auto-complete="on" label-position="left">
      <h3 class="title">海培英语后台管理系统</h3>
      <el-form-item prop="account">

        <el-input v-model="loginForm.account" name="account" type="text" auto-complete="on" placeholder="account" />
      </el-form-item>
      <el-form-item prop="password">

        <el-input
          :type="pwdType"
          v-model="loginForm.password"
          name="password"
          auto-complete="on"
          placeholder="password"
          @keyup.enter.native="handleLogin" />

      </el-form-item>

<slide-verify :l="42"
            :r="10"
            :w="310"
            :h="155"
            style="margin-left:100px"
            @success="onSuccess"
            @fail="onFail"
            @refresh="onRefresh"
            :slider-text="text"
            ></slide-verify>
<div>{{msg}}</div>


      <el-form-item>
        <el-button :loading="loading" type="primary" style="width:100%;" @click="handleLogin()">
          登录
        </el-button>
      </el-form-item>
      <div class="tips">
      </div>
    </el-form>
  </div>
</template>

<script>
  import { isvalidUsername } from '@/assets/js/validate'
  export default {
    name: "Login",
    data() {
      const validateUsername = (rule, value, callback) => {
        if (!isvalidUsername(value)) {
          callback(new Error('请输入正确的用户名'))
        } else {
          callback()
        }
      }
      const validatePass = (rule, value, callback) => {
        if (value.length < 3) {
          callback(new Error('密码不能小于3位'))
        } else {
          callback()
        }
      }
      return {
        msg:'',
        text:'向右滑',
        loginForm: {
          account: 'kzh',
          password: '123'
        },
        loginRules: {
          account: [{ required: true, trigger: 'blur', validator: validateUsername }],
          password: [{ required: true, trigger: 'blur', validator: validatePass }]
        },
        loading: false,
        pwdType: 'password',
        redirect: undefined
      }
    },
    watch: {
      $route: {
        handler: function(route) {
          this.redirect = route.query && route.query.redirect
        },
        immediate: true
      }
    },
    methods: {
      onSuccess(){
        this.msg = 'login success'
             this.$message({
              type: 'success',
              message: "nice",
              duration:1000,
            });
        },
        onFail(){
             this.$message({
              type: 'warning',
              message: "请重试",
              duration:1000,
            });
        },
        onRefresh(){
             this.$message({
              type: 'warning',
              message: "请重试",
              duration:1000,
            });
        },
      showPwd() {
        if (this.pwdType === 'password') {
          this.pwdType = ''
        } else {
          this.pwdType = 'password'
        }
      },
      handleLogin() {
        this.$refs.loginForm.validate(valid => {
          if (valid) {
            console.log(this.loginForm);

            this.$axios.post("manager/login",this.loginForm).then(r=>{
              alert(this.loginForm.account)
              console.log(r);
              if(r.data.code == 200){
                 this.$message({
              type: 'success',
              message: "登录成功",
              duration:1000,
            });
            localStorage.setItem("account",this.loginForm.account);
            localStorage.setItem("token",r.data.msg);
            this.$router.push({
                path: `/home`,
            });

              }else{
                this.$message({
              type: 'warning',
              message: r.data.msg,
              duration:1000,
            });
              }
            })
          } else {
            console.log('error submit!!')
            return false
          }
        })
      }
  }
  }
</script>


<style rel="stylesheet/less" lang="less">

  /* reset element-ui css */
  .login-container {
    .el-input {
      display: inline-block;
      height: 47px;
      width: 85%;
      input {
        background: transparent;
        border: 0px;
        -webkit-appearance: none;
        border-radius: 0px;
        padding: 12px 5px 12px 15px;
        color: #eee;
        height: 47px;
        &:-webkit-autofill {
          -webkit-box-shadow: 0 0 0px 1000px #2d3a4b inset !important;
          -webkit-text-fill-color: #fff !important;
        }
      }
    }
    .el-form-item {
      border: 1px solid rgba(255, 255, 255, 0.1);
      background: rgba(0, 0, 0, 0.1);
      border-radius: 5px;
      color: #454545;
    }
  }

</style>

<style rel="stylesheet/less" lang="less" scoped>
  .login-container {
    position: fixed;
    height: 100%;
    width: 100%;
    background-color: #2d3a4b;
    .login-form {
      position: absolute;
      left: 0;
      right: 0;
      width: 520px;
      max-width: 100%;
      padding: 35px 35px 15px 35px;
      margin: 120px auto;
    }
    .tips {
      font-size: 14px;
      color: #fff;
      margin-bottom: 10px;
      span {
        &:first-of-type {
          margin-right: 16px;
        }
      }
    }
    .svg-container {
      padding: 6px 5px 6px 15px;
      color: #889aa4;
      vertical-align: middle;
      width: 30px;
      display: inline-block;
    }
    .title {
      font-size: 26px;
      font-weight: 400;
      color: #eee;
      margin: 0px auto 40px auto;
      text-align: center;
      font-weight: bold;
    }
    .show-pwd {
      position: absolute;
      right: 10px;
      top: 7px;
      font-size: 16px;
      color: #889aa4;
      cursor: pointer;
      user-select: none;
    }
  }
</style>
