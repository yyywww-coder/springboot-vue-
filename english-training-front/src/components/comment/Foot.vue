<template>
    <el-card class="box-card">
      <div class="container-fluid">
        <div class="row">
            <div class="container" id="footer">
              <div class="row hidden-xs hidden-sm">
                <div class="col-md-10 col-sm-offset-1">
                  <div class="footnav" style="padding-top:15px;float:left;width:100%;height:35px;font-size:16px">
                    <div style="padding-left:15px; padding-right:15px; width:20%; text-align:center;float:left" class="f16">
                      <router-link  to="/video"><a target="_blank"><i class="el-icon-s-claim"></i>课程</a></router-link></div>


                    <div style="padding-left:15px; padding-right:15px; width:20%; text-align:center;float:left" class="f16">
                      <router-link  to="/connect"><a target="_blank"><i class="el-icon-phone"></i>联系我们</a></router-link></div>

                    <div style="padding-left:15px; padding-right:15px; width:20%; text-align:center;float:left" class="f16">
                      <router-link  to="/aboutUs"><a target="_blank"><i class="el-icon-s-promotion"></i>关于我们</a></router-link></div>

                    <div style="padding-left:15px; padding-right:15px; width:20%; text-align:center;float:left" class="f16">
                      <router-link  to="/choose"><a target="_blank"><i class="el-icon-s-promotion"></i>选择我们的理由</a></router-link></div>

                  </div>
                  <div  style="padding-top:25px;width:100%;float:left;color:#000">
                    <center>© 海培教育 <a href="https://beian.miit.gov.cn" target="_blank">鄂ICP备05064294号-1</a> 鄂公网安备33010602004015号 </center>
                  </div>
                  <div  style="padding-top:5px;margin-left:auto;margin-right:auto;float:left;width:100%;color:#000">
                    <center>全国客服热线：95059</center>
                  </div>
                </div>
              </div>
            </div>
        </div>
      </div>

      <!-- 底部链接栏 -->
      <div style="padding-top:15px;margin-left:auto;margin-right:auto;float:left;width:100%;">
          <center><b style="color:green">友情链接：</b><b v-for="item in links" :key="item.id">
            <el-button @click.prevent="goLink(item.linkaddress)" type="text">{{item.linkname}}</el-button>-</b>
          </center>
      </div>
    </el-card>
</template>

<script>
export default {
    data(){
        return{
            //  链接集合
            links:{
                linkname:'',
                linkaddress:'',
                logo:''
            }
        }
    },
    methods:{
    //  查找所有链接
      showAllLinks(){
        this.$axios.get("front/link/list").then(ref=>{
          console.log(ref)
          this.links=ref.data.data;
        })
      },
      //  点击跳转链接
      goLink(linkaddress){
       location.href=linkaddress;
      }
    },
    created(){
      this.showAllLinks();
    }
}
</script>

<style scoped>
.footnav{
  margin-left: 90px;
}

.box-card{
  background-color: #f4f4f4;
  border-top: white 2px solid;
}
a {
    font-size: 20px;
    color:#000;
    text-decoration: none;
}

a:hover
{
     color:#00A0C6;
     text-decoration:none;
     cursor:pointer;
}
</style>
