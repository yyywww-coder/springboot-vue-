<template>
  <div id="div3">
    <h2>全部课程</h2>
    <el-tabs type="border-card">
      <el-tab-pane>
        <span class="menutext" slot="label" @click="showSmall()"><i class="iconfont icon-xiaoxue3"></i> 少儿</span>

        <!-- 排序降序 -->
        <el-row>
          <el-button type="primary"  @click="searchBuyCount()" v-html="buyCountSort" plain>销量</el-button>
          <el-button type="success" @click="searchGmtCreate('1')" v-model="sort" v-html="gmtCreateSort" plain>最新</el-button>
          <el-button type="info" @click="searchPrice('4')" v-model="money" v-html="priceSort" plain>价格</el-button>
        </el-row>

        <!-- 视频卡片 -->
        <el-row :gutter="24">
          <el-col :span="8" v-for="(item, index) in videos" :key="item.id" :offset="index > 0 ? 2 : 0" >
            <el-card>
              <img :src="item.imageUrl" class="image">
              <VideoVod
                v-if="videoVisibleVod"
                ref="videoVod"
                @my-event="getVodEvent"
              ></VideoVod>
              <div style="padding: 14px;">
                <span>{{ item.title }}</span>
                <span id="span">{{ item.price }}</span>
                <div class="bottom clearfix">
                  <time class="time">{{ item.username }}</time>
                  <el-button type="primary" @click="approveVod(item.videoSourceId)"
                  >视&nbsp;&nbsp;&nbsp;频&nbsp;&nbsp;&nbsp;介&nbsp;&nbsp;&nbsp;绍</el-button>
                </div>
              </div>
            </el-card>
          </el-col>
        </el-row>

        <!-- 分页 -->
        <el-pagination
          :background="true"
          layout="prev, pager, next"
          :total="totalCount"
          :page-size="6"
          :current-page="pageIndex"
          @current-change = "changeCurrentPage"
        >
        </el-pagination>
      </el-tab-pane>

      <!-- 初中 -->
      <el-tab-pane>
        <span class="menutext" @click="showMiddle()" slot="label"><i class="iconfont icon-chuzhong"></i>初中</span>

        <!-- 排序降序 -->
        <el-row>
          <el-button type="primary"  @click="searchBuyCount()" v-html="buyCountSort" plain>销量</el-button>
          <el-button type="success" @click="searchGmtCreate('2')" v-html="gmtCreateSort" plain>最新</el-button>
          <el-button type="info" @click="searchPrice('5')" v-html="priceSort" plain>价格</el-button>
        </el-row>

        <!-- 视频卡片 -->
        <el-row :gutter="24">
          <el-col :span="8" v-for="(item, index) in videos" :key="item.id" :offset="index > 0 ? 2 : 0">
            <el-card  v-if="item.status==1">
              <img :src="item.imageUrl" class="image">
              <div style="padding: 14px;">
                <span>{{ item.title }}</span>
                <span id="span">{{ item.price }}</span>
                <div class="bottom clearfix">
                  <time class="time">{{ item.username }}</time>
                  <el-button type="text" class="button" @click="goBuy()">点击购买</el-button>
                </div>
              </div>
            </el-card>
          </el-col>
        </el-row>

        <!-- 分页 -->
        <el-pagination
          :background="true"
          layout="prev, pager, next"
          :total="totalCount"
          :page-size="6"
          :current-page="pageIndex"
          @current-change = "changeCurrentPage"
        >
        </el-pagination>
      </el-tab-pane>

      <!-- 高中 -->
      <el-tab-pane>
        <span class="menutext" @click="showHight()" slot="label"><i class="iconfont icon-gaozhong"></i>高中</span>

        <!-- 排序降序 -->
        <el-row>
          <el-button type="primary"  @click="searchBuyCount()" v-html="buyCountSort" plain>销量</el-button>
          <el-button type="success" @click="searchGmtCreate('3')" v-html="gmtCreateSort" plain>最新</el-button>
          <el-button type="info" @click="searchPrice('6')" v-html="priceSort" plain>价格</el-button>
        </el-row>

        <!-- 视频卡片 -->
        <el-row :gutter="24">
          <el-col :span="8" v-for="(item, index) in videos" :key="item.id" :offset="index > 0 ? 2 : 0">
            <el-card  v-if="item.status==2">
              <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png" class="image">
              <div style="padding: 14px;">
                <span>{{ item.title }}</span>
                <span id="span">{{ item.price }}</span>
                <div class="bottom clearfix">
                  <time class="time">{{ item.username }}</time>
                  <el-button type="text" class="button" @click="goBuy()">点击购买</el-button>
                </div>
              </div>
            </el-card>
          </el-col>
        </el-row>

        <!-- 分页 -->
        <el-pagination
          :background="true"
          layout="prev, pager, next"
          :total="totalCount"
          :page-size="6"
          :current-page="pageIndex"
          @current-change = "changeCurrentPage"
        >
        </el-pagination>
      </el-tab-pane>
    </el-tabs>


  </div>
</template>

<script scoped>
  import VideoVod from "./VideoVod.vue"
  export default {
    data(){
      return{
        // 下标
        status:0,
        //  总数
        totalCount:0,
        //  当前页
        pageIndex:1,
        // 视频表
        videos:[],
        data:{
          total:1,
          items:{
            id:1,
            cover:'',
            price:69.9,
            title:'少儿英语启蒙专业课程',
            buyCount:500,
            viewCount:50,
          }
        },
        //  销量排序
        buyCountSort:"销量",
        //  最新排序
        gmtCreateSort:"最新",
        //  价格排序
        priceSort:"价格",
        //  最新排序触发标志
        sort:'',
        //  价格排序触发标志
        money:'',
        // 视频播放
        videoVisibleVod: false,
      }
    },
    methods:{

      approveVod (videoId) {
        if (videoId == null) {
          this.$message('没有视频喔')
          return
        }
        console.log(videoId)
        this.videoVisibleVod = true
        this.$nextTick(() => {
          this.$refs.videoVod.init(videoId)

        })
      },
      getVodEvent (vid) {
        console.log('接收的数据--------->' + vid)
        this.videoVisibleVod = false
      },

      //  改变当前页触发
      changeCurrentPage(val){
        this.pageIndex=val
        this.showSmall(this.pageIndex,this.sort);
      },

      //  查找所有少儿视频
      showSmall(pageIndex=1,sortt='',moneys=''){
        this.pageIndex=pageIndex;
        this.sort=sortt;
        this.status='0';
        this.money=moneys;
        this.$axios.get("front/video/list",
          {
            params:{
              pageIndex:this.pageIndex,
              pageSize:6,
              status:this.status,
              sorts:this.sort,
              moneyy:this.money
            }
          }).then(res=>{
          console.log(res);
          this.totalCount=res.data.data.total;
          this.videos=res.data.data.list
          this.pageIndex=res.data.data.pageNum

        })
      },

      //  查找所有初中视频
      showMiddle(pageIndex=1,sortt='',moneys=''){
        this.sort=sortt
        this.pageIndex=pageIndex;
        this.status='1';
        this.money=moneys
        this.$axios.get("/videofront/list",
          {
            params:{
              pageIndex:this.pageIndex,
              pageSize:6,
              status:this.status,
              sorts:this.sort,
              moneyy:this.money
            }
          }).then(res=>{
          console.log(res);
          this.totalCount=res.data.data.total;
          this.videos=res.data.data.list
          this.pageIndex=res.data.data.pageNum
        })
      },

      //  查找所有高中视频
      showHight(pageIndex=1,sortt='',moneys=''){
        this.sort=sortt
        this.pageIndex=pageIndex;
        this.status='2';
        this.money=moneys
        this.$axios.get("/videofront/list",
          {
            params:{
              pageIndex:this.pageIndex,
              pageSize:6,
              status:this.status,
              sorts:this.sort,
              moneyy:this.money
            }
          }).then(res=>{
          console.log(res);
          this.totalCount=res.data.data.total;
          this.videos=res.data.data.list
          this.pageIndex=res.data.data.pageNum
        })
      },


      //  跳转到支付宝支付页面
      goBuy(){

      },

      //6 根据销量排序
      searchBuyCount() {
        //设置对应变量值，为了样式生效
        this.buyCountSort = "<i class='iconfont icon-xiangxiajiantou'></i>销量"
        this.gmtCreateSort = "最新"
        this.priceSort = "价格"

        //把值赋值到searchObj
        this.searchObj.buyCountSort = this.buyCountSort
        this.searchObj.gmtCreateSort = this.gmtCreateSort;
        this.searchObj.priceSort = this.priceSort;

        //调用方法查询
        this.gotoPage(1)
      },

      //7 最新排序
      searchGmtCreate(num) {
        //设置对应变量值，为了样式生效
        this.buyCountSort = "销量"
        this.gmtCreateSort = "<i class='iconfont icon-xiangxiajiantou'></i>最新"
        this.priceSort = "价格"
        this.pageIndex=1;
        if(num=='1'){
          this.sort='1';
          this.money='';
          //调用方法查询
          this.showSmall(this.pageIndex,this.sort,this.money);
        }else if(num=='2'){
          this.sort='2'
          this.money='';
          //调用方法查询
          this.showMiddle(this.pageIndex,this.sort,this.money);
        }else if(num=='3'){
          this.sort='3'
          this.money='';
          this.showHight(this.pageIndex,this.sort,this.money);
        }
      },

      //8 价格排序
      searchPrice(num) {
        //设置对应变量值，为了样式生效
        this.buyCountSort = "销量"
        this.gmtCreateSort = "最新"
        this.priceSort = "<i class='iconfont icon-xiangxiajiantou'></i>价格"
        this.pageIndex=1;
        //调用方法查询
        if(num=='4'){
          this.money='4';
          this.sort='';
          //调用方法查询
          this.showSmall(this.pageIndex,this.sort,this.money);
        }else if(num=='5'){
          this.money='5'
          this.sort='';
          //调用方法查询
          this.showMiddle(this.pageIndex,this.sort,this.money);
        }else if(num=='6'){
          this.money='6'
          this.sort='';
          this.showHight(this.pageIndex,this.sort,this.money);
        }
      }
    },
    created(){
      this.showSmall();
    },
    components: {
      VideoVod
    }
  }
</script>

<style scoped>
  @import '../../assets/css/allCss/global.css';
  @import '../../assets/css/allCss/iconfont.css';
  @import '../../assets/css/allCss/reset.css';
  @import '../../assets/css/allCss/sign.css';
  @import '../../assets/css/allCss/theme.css';
  @import '../../assets/css/allCss/web.css';

  #div3{
    width: 80%;
    margin-left: 200px;
  }
  #span{
    padding: 0;
    float: right;
    color: red;
  }
  h2{
    margin-top: 15px;
  }
  .el-tabs{
    margin-top: 20px;
  }
  .el-card{
    margin-bottom: 20px;
  }
  .el-row{
    margin-top: 10px;
  }
  .el-col{
    transition: transform 0.25s ease;
    /* float: left; */
    /* width: 200px;
    height: 200px; */
    /* line-height: 200px;  */

    /* margin: 10px;  */
    /* background-color: #00b5e1; */
    list-style: none;
  }
  .el-col :hover{
    transform: scale(1.05,1.05);
    /* box-shadow: 0 0 10px #0000ff; */
    cursor: pointer;
    /* text-align: center; */
  }
  .menutext{
    font-size: 25px;
  }
  .time {
    font-size: 13px;
    color: #999;
  }

  .bottom {
    margin-top: 13px;
    line-height: 12px;
  }
  .button {
    padding: 0;
    float: right;
  }

  .image {
    width: 100%;
    height: 250px;
    display: block;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }

  .clearfix:after {
    clear: both
  }

</style>
