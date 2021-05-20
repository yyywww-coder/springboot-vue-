<template>
  <el-container>
    <el-header>
      <el-row>
        <el-col :span="8" class="col_l">
          <img src="../../assets/images/logo.png" alt="">
        </el-col>
        <el-col :span="8">
          <h1>海培英语培训后台管理系统</h1>
        </el-col>

        <el-col :span="8" >
          <div style="text-align: right;">
            <p>欢迎您:<el-avatar> {{username}} </el-avatar><a href="#" @click.prevent="logout()">退出</a></p>
          </div>

        </el-col>
      </el-row>
    </el-header>

    <el-container>
      <el-aside width="200px">

          <el-menu
            style="height:100%"
            default-active="2"
            class="el-menu-vertical-demo"
            background-color="#545c64"
            text-color="#fff"
            active-text-color="#ffd04b"
            :router="true">
            <el-submenu :index="item.id+''" v-for="item in perms" :key="item.id">
              <template slot="title">
                <i class="el-icon-location"></i>
                <span>{{item.name}}</span>
              </template>
              <el-menu-item :index="son.link" v-for="son in item.children" :key="son.id">{{son.name}}</el-menu-item>
            </el-submenu>
          </el-menu>
      </el-aside>
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
  export default {
    data(){
      return{
        username:'',
        account:'',
        perms:[]
      }
    },
    methods: {
      //加载权限列表
      loadMenu(){
        this.$axios.post("perms/menu").then(r=>{
          console.log(r);
          this.perms = r.data.data
        })
      },
      getByAccount(){
        let account = localStorage.getItem("account");
        this.$axios.get("manager/getByAccount",{params:{
            account
        }}).then(res=>{
         this.username = res.data.data.username
        })
      },
      logout(){
        this.$confirm("确定退出账号吗？","提示",{
          confirmButtonText:"确定",
          cancelButtonText:"取消",
          type:"warning"
        }).then(res=>{
          localStorage.removeItem("token");
          this.$router.push('/login')
          this.$message({
            message:"退出成功",
            type:"success",
            duration:900
          });
        }).catch(res=>{
          this.$message({
            message:"退出已取消",
            type:"info",
            duration:900
          });
        })
      }
    },
    created(){
      this.loadMenu()
      // this.account=this.$route.params.account
      this.getByAccount()
    }
  }

</script>

<style scoped lang="less">
  .el-container{
    height: 100%;
  }
  .el-header{
    background: gainsboro;
    padding: 0;
  h1{
    color: #fff;
    text-align: center;
    line-height: 60px;
    font-size: 26px;
  }
  .col_r{
    line-height: 60px;
    text-align: right;
    padding-right: 30px;
  a{
    color: orange;
  }
  }
  .col_l{
    text-align: left;
  }
  }
  .el-aside{
    background: #545c64;
  }
  .el-main{
    background: #eaeef1;
  }
  .el-menu{
    height: 100%;
  }
</style>
