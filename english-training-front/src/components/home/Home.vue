<template>
  <div id="homeDiv">\

    <el-dialog title="客服中心" :visible.sync="service" label-width="100px" >
      <div class="talk_con">
        <div class="talk_show" id="words">
          <div class='guanggao-area'><p style="font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 16px; line-height: normal; border: 0px none; padding: 0px; white-space: normal; text-align: left;"><span style="font-size: 12px;"><strong><span style="border: 0px none; margin: 0px; padding: 0px;">学IT技术，来蜗牛学院，专业、负责、口碑好。我们崇尚技术，爱惜人才，以就业为导向，只为成就更好的你！</span></strong></span></p><p style="font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 16px; line-height: normal; border: 0px none; padding: 0px; white-space: normal; text-align: left;"><span style="font-size: 12px;"><strong style="text-align: justify; font-family: 微软雅黑, &quot;Microsoft YaHei&quot;, 宋体, Arial, Helvetica, sans-serif, Tahoma; border: 0px none; margin: 0px; padding: 0px;"><strong style="border: 0px none; margin: 0px; padding: 0px;"><strong style="border: 0px none; margin: 0px; padding: 0px;"><span style="font-size: 12px; border: 0px none; margin: 0px; padding: 0px;">联系电话：19150192914&nbsp; &nbsp; &nbsp;</span></strong></strong></strong><strong style="text-align: justify; font-family: 微软雅黑, &quot;Microsoft YaHei&quot;, 宋体, Arial, Helvetica, sans-serif, Tahoma; border: 0px none; margin: 0px; padding: 0px;"><strong style="border: 0px none; margin: 0px; padding: 0px;"><strong style="border: 0px none; margin: 0px; padding: 0px;"><span style="font-size: 12px; border: 0px none; margin: 0px; padding: 0px;">咨询QQ：1964006600</span></strong></strong></strong><strong style="text-align: justify; font-family: 微软雅黑, &quot;Microsoft YaHei&quot;, 宋体, Arial, Helvetica, sans-serif, Tahoma; border: 0px none; margin: 0px; padding: 0px;"><strong style="border: 0px none; margin: 0px; padding: 0px;"><strong style="border: 0px none; margin: 0px; padding: 0px;"><span style="font-size: 12px; border: 0px none; margin: 0px; padding: 0px;"></span></strong></strong></strong><strong style="text-align: justify; font-family: 微软雅黑, &quot;Microsoft YaHei&quot;, 宋体, Arial, Helvetica, sans-serif, Tahoma; border: 0px none; margin: 0px; padding: 0px;"><strong style="border: 0px none; margin: 0px; padding: 0px;"><strong style="border: 0px none; margin: 0px; padding: 0px;"><span style="font-size: 12px; border: 0px none; margin: 0px; padding: 0px;"></span></strong></strong></strong><strong style="text-align: justify; font-family: 微软雅黑, &quot;Microsoft YaHei&quot;, 宋体, Arial, Helvetica, sans-serif, Tahoma; border: 0px none; margin: 0px; padding: 0px;"><strong style="border: 0px none; margin: 0px; padding: 0px;"><strong style="border: 0px none; margin: 0px; padding: 0px;"><span style="font-size: 12px; border: 0px none; margin: 0px; padding: 0px;"></span></strong></strong></strong></span></p><p style="font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 16px; line-height: normal; border: 0px none; padding: 0px; white-space: normal; text-align: left;"><br/></p></div>
          <div class="atalk">客服小姐姐:欢迎来到happy英语学院，如遇小姐姐回复不及时，请直接拨打上方电话或QQ咨询。开设课程：初中英语、小学英语、高中英语。您也可以点击下方按钮自动预约哦
              <el-button type="success" size="medium " @click="handleAdd" >免费预约</el-button>
          </div>

        </div>
        <div class="talk_input">
          <select class="whotalk" id="who">
            <option value="0">A：</option>
            <option value="1">B：</option>
          </select>
          <input type="text" class="talk_word" id="talkwords">
          <input type="button" value="发送" class="talk_sub" id="talksub">
        </div>
      </div>
    </el-dialog>

    <!-- 添加员工 -->
          <el-dialog title="预约" :visible.sync="addForm" label-width="100px" >
            <el-form  :model="addArrange" :rules="rules" ref="addArrange" >
              <el-form-item label="姓名" prop="username">
          <el-input v-model="addArrange.username" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="年龄" prop="age">
          <el-input v-model=" addArrange.age" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="性别">
          <el-radio v-model="addArrange.gender" label="1">男</el-radio>
          <el-radio v-model="addArrange.gender" label="0">女</el-radio>
        </el-form-item>
        <el-form-item label="联系方式" prop="telephone">
          <el-input v-model="addArrange.telephone" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="班级" prop="className">
          <el-select v-model="addArrange.className" filterable  placeholder="请选择">
            <el-option
              v-for="item in gradeList"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            >
            </el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="addForm = false">取 消</el-button>
        <el-button type="primary" @click="submitAdd(addArrange)">确 定</el-button>
      </div>
    </el-dialog>
<el-scrollbar>
 <div style="height:100%;width:100%">

 <el-container style="height:100%;width:100%;">

   <!-- 头部引人 -->

<el-main style="height:100%;padding:0px;margin:0px;" >
  <el-carousel :interval="5000" arrow="never" height="600px">
    <el-carousel-item v-for="(item,index) in images" :key="index">
      <h3 class="medium"><img :src="item.imageUrl"></h3>
    </el-carousel-item>
  </el-carousel>

<el-card style="background-color: darkcyan;">
  <div class="course">
        <p>海培英语课程</p>
    </div>
  <el-row :gutter="18" style="margin-left:250px;">

    <el-col :span="7">
      <el-card shadow="hover" style="border-radius:25px;width:413px;">
         <img src="../../assets/images/dj6z.png" class="image">
          <p style="margin-top: -30px;">
            <h4>培升中学英语<br>扎实基础与国际素养</h4>
          </p>
      </el-card>
    </el-col>
    <el-col :span="7">
      <el-card shadow="hover" style="border-radius:25px;width:413px;">
        <img src="../../assets/images/mwgp.png" class="image">
          <p style="margin-top: -30px;">
            <h4>少儿听说英语<br>启蒙听说及培养兴趣</h4>
          </p>
      </el-card>
    </el-col>
    <el-col :span="7">
      <el-card shadow="hover" style="border-radius:25px;width:413px;">
        <img src="../../assets/images/vsos.png" class="image">
          <p style="margin-top: -30px;">
            <h4>初中英语新视野<br>培养听说读写综合能力</h4>
          </p>
      </el-card>
    </el-col>
  </el-row>
</el-card>


 <el-card>
   <div class="course">
     <p>免费体验▶开口说英语</p>
   </div>
   <div class="yuyue" style="margin-left: 25%;">
     <li>
      <img src="../../assets/images/module43-icon01.png" alt=""/>
      <i class="iconfont icon-zhixian" style="color: #6ac572;"></i>
      <p>免费注册<br>领取新人大礼包</p>
     </li>
     <li>
      <img src="../../assets/images/module43-icon02.png"/>
      <i class="iconfont icon-zhixian" style="color: #6ac572;"></i>
      <p>专项测试<br>快速了解自己水平</p>
    </li>
     <li>
     <img src="../../assets/images/module43-icon03.png"/>
     <i class="iconfont icon-zhixian" style="color: #6ac572;"></i>
      <p>定制学习<br>1对1定制学习规划</p>
     </li>
     <li>
     <img src="../../assets/images/module43-icon04.png"/>
     <i class="iconfont icon-zhixian" style="color: #6ac572;"></i>
      <p>方法指导<br>中教外教面授指导</p>
     </li>
    <li>
     <img src="../../assets/images/module43-icon05.png"/>
     <i  class="iconfont icon-zhixian" style="color: #ffffff;"></i>
     <p>试听课程<br>真实场景体验学习</p>
     </li>
   </div>
   <div style="margin:100px 100px 200px 250px;">
      <el-button type="success" size="medium " @click="goService" >免费预约</el-button>
   </div>
</el-card>


 <el-card style="background-color:#f4f4f4;">
<div>
  <div class="course">
    <p>
      海培学员精彩瞬间
    </p>
  </div>

   <el-radio-group v-model="direction">
    <el-radio label="ltr">
      <img @click="summer = true" src="../../assets/images/wonderfulImg/SummerVacation/hanshujia.jpg"/>
      <p>寒暑假班</p>
    </el-radio>
    <el-radio label="rtl">
      <img @click="outdoor = true" src="../../assets/images/wonderfulImg/outdoor/outdoors.jpg"/>
      <p>户外课</p>
    </el-radio>
    <el-radio label="ttb">
      <img @click="star = true" src="../../assets/images/wonderfulImg/monthStar/suporstar.jpg"/>
      <p>每月之星</p>
      </el-radio>
    <el-radio label="btt">
      <img @click="active = true" src="../../assets/images/wonderfulImg/activities/zhutihuod.jpg"/>
      <p>主题活动</p>
      </el-radio>
  </el-radio-group>

  <!-- <el-button @click="drawer = true" type="primary" style="margin-left: 16px;">
    点我打开
  </el-button> -->
  <el-drawer
  title="寒暑假"
  :visible.sync="summer"
  :before-close="handleClose"
  size="830px">
  <div>
    <li class="summer" style="margin-top:-20px;">
      <img src="../../assets/images/wonderfulImg/SummerVacation/FullSizeRender(17).jpg" alt=""/>
      <img src="../../assets/images/wonderfulImg/SummerVacation/FullSizeRender(30).jpg" alt=""/>
      <img src="../../assets/images/wonderfulImg/SummerVacation/FullSizeRender(31).jpg" alt=""/>
      <img src="../../assets/images/wonderfulImg/SummerVacation/FullSizeRender(33).jpg" alt=""/>
      <img src="../../assets/images/wonderfulImg/SummerVacation/IMG_2642.jpg" alt=""/>
      <img src="../../assets/images/wonderfulImg/SummerVacation/IMG_7960.jpg" alt=""/>
    </li>
  </div>
</el-drawer>

<el-drawer
  title="户外活动"
  :visible.sync="outdoor"
  :before-close="handleClose"
  size="830px">
  <div>
    <li class="summer" style="margin-top:-20px;">
      <img src="../../assets/images/wonderfulImg/outdoor/10月茶艺户外课IMG_9070.jpg" alt=""/>
      <img src="../../assets/images/wonderfulImg/outdoor/10月茶艺户外课IMG_9076.jpg" alt=""/>
      <img src="../../assets/images/wonderfulImg/outdoor/10月茶艺户外课IMG_9081.jpg" alt=""/>
      <img src="../../assets/images/wonderfulImg/outdoor/IMG_5348.jpg" alt=""/>
      <img src="../../assets/images/wonderfulImg/outdoor/IMG_5394.jpg" alt=""/>
      <img src="../../assets/images/wonderfulImg/outdoor/IMG_5433.jpg" alt=""/>
    </li>
  </div>
</el-drawer>
<el-drawer
  title="每月之星"
  :visible.sync="star"
  :before-close="handleClose"
  size="830px"
  >
  <div>
    <li class="summer" style="margin-top:-20px;">
      <img src="../../assets/images/wonderfulImg/monthStar/全勤小明星.jpg" alt=""/>
      <img src="../../assets/images/wonderfulImg/monthStar/最佳进步小明星.jpg" alt=""/>
      <img src="../../assets/images/wonderfulImg/monthStar/活动参与小明星.jpg" alt=""/>
      <img src="../../assets/images/wonderfulImg/monthStar/海培之星--张晋荣.jpg" alt=""/>
      <img src="../../assets/images/wonderfulImg/monthStar/英语之星-万子暄.jpg" alt=""/>
      <img src="../../assets/images/wonderfulImg/monthStar/课后复习小明星.jpg" alt=""/>
    </li>
  </div>
</el-drawer>

<el-drawer
  title="主题活动"
  :visible.sync="active"
  :before-close="handleClose"
  size="830px"
  >
  <div>
    <li class="summer" style="margin-top:-20px;">
      <img src="../../assets/images/wonderfulImg/activities/IMG_7658.jpg" alt=""/>
      <img src="../../assets/images/wonderfulImg/activities/IMG_7660.jpg" alt=""/>
      <img src="../../assets/images/wonderfulImg/activities/IMG_7673.jpg" alt=""/>
      <img src="../../assets/images/wonderfulImg/activities/IMG_7674.jpg" alt=""/>
      <img src="../../assets/images/wonderfulImg/activities/IMG_7680.jpg" alt=""/>
      <img src="../../assets/images/wonderfulImg/activities/IMG_7681.jpg" alt=""/>
    </li>
  </div>
</el-drawer>

</div>
</el-card>


</el-main>

</el-container>

   <router-view></router-view>


    <!-- 底部引入-->

</div>
</el-scrollbar>
  </div>
</template>

<script>
import App from '../../App.vue';
export default {
  components: { App },
    data() {
      return {

        addArrange:
          {username:'',age:'',gender:'',telephone:'',className:''},

        rules: {
          username: [
            { required: true, message: '请输入姓名', trigger: 'blur' },],
          age: [
            { required: true, message: '请输入年龄', trigger: 'blur' },],
          gender: [
            { required: true, message: '请选择性别', trigger: 'blur' },],
          age: [
            { required: true, message: '请输入年龄', trigger: 'blur' },],
          className: [
            { required: true, message: '请选择班级', trigger: 'blur' },],
          telephone: [
            { required: true, message: '请输入11位号码', trigger: 'blur' },]
        },

        gradeList:[
          {
            value: '1',
            label: '少儿'
          },{
            value: '2',
            label: '初中'
          },
          {
            value: '3',
            label: '高中'
          }
        ],

        activeName: 'second',
        images:[],
        summer: false,
        outdoor:false,
        star:false,
        active:false,
        addForm:false,
        service:false
      };
    },

    methods: {

      submitAdd(addArrange){
        //alert(localStorage.getItem("token"))
        this.$refs.addArrange.validate((valid) =>{
          if (valid){
              this.$axios.post('front/arrange/add',this.addArrange).then(res =>{
                console.log(res)
                this.$message({
                  message: '预约成功',
                  type: 'success',
                  duration:800
                });
                this.addForm = false;
              })
          } else{
            this.$message({
              message: '请填写完整信息哦',
              type: 'warning',
              duration:800
            });
          }
        })
      },
      goService(){
        this.service = true
      },

      handleAdd(){
        this.service = false
          this.addForm = true;
      },
      handleClick(tab, event) {
        console.log(tab, event);
      },
      getImages(){
        this.$axios.get("front/banner/list").then(res=>{
          this.images=res.data.data
            console.log(res)
        })
      },
      handleClose(done) {
        this.$confirm('确认关闭？')
          .then(_ => {
            done();
            this.direction='';
          })
          .catch(_ => {});
      },
      tabChange(tab){
        if('ltr'==tab){
          this.direction='寒暑假'
        }else if('rtl'==tab){
          this.direction='户外活动'
        }else if('ttb'==tab){
          this.direction='每月之星'
        }else if('btt'==tab){
          this.direction='主题活动'
        }
      }
    },
  created(){
    this.getImages()
  }
}
</script>

<style scoped>
  .talk_con {
    width: 600px;
    height: 500px;
    border: 1px solid #666;
    margin: 50px auto 0;
    background: #f9f9f9;
  }

  .talk_show {
    width: 580px;
    height: 420px;
    border: 1px solid #666;
    background: #fff;
    margin: 10px auto 0;
    overflow: auto;
  }

  .talk_input {
    width: 580px;
    margin: 10px auto 0;
  }

  .whotalk {
    width: 80px;
    height: 30px;
    float: left;
    outline: none;
  }

  .talk_word {
    width: 420px;
    height: 26px;
    padding: 0px;
    float: left;
    margin-left: 10px;
    outline: none;
    text-indent: 10px;
  }

  .talk_sub {
    width: 56px;
    height: 30px;
    float: left;
    margin-left: 10px;
  }

  .atalk {
    margin: 10px;
  }

  .atalk span {
    display: inline-block;
    background: #0181cc;
    border-radius: 10px;
    color: #fff;
    padding: 5px 10px;
  }

  .btalk {
    margin: 10px;
    text-align: right;
  }

  .btalk span {
    display: inline-block;
    background: #ef8201;
    border-radius: 10px;
    color: #fff;
    padding: 5px 10px;
  }
/*  精彩瞬间 */
.el-radio-group p{
  font-size: 25px;
}
.summer img{
  border-radius:25px;
}

/*  预约样式 */
.yuyue li{
  float: left;
  list-style: none;

}
/* 预约下的文字 */
.yuyue p{
  margin-right: 130px;
}

.course{

  margin-left: 40%;
  margin-bottom: 20px;
  height: 81px;
  width: 475px;
  background-image:url("../../assets/images/pc3d.png");
}
.course p{

  margin-right: 30px;
  line-height: 80px;
  font-size: 30px;
  font-weight: 800;
  color: #ffffff;
}
.choose{
  margin-left: 200px;
}

.el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 160px;
    overflow: auto;
    /* overflow-y: hidden; */
    /* height: 1500px; */
}

.el-carousel__item h3 {
    color: #475669;
    font-size: 18px;
    opacity: 0.75;
    line-height: 300px;
    margin: 0;
  }

  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }

  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
  }

.el-scrollbar{
    height: 100%;
  }
.el-scrollbar__wrap {

overflow-x: hidden;
}

body > .el-container {
    margin-bottom: 40px;
}

</style>
