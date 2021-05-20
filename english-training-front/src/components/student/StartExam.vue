// 我的考试页面
<template>
  <div id="myExam">
    <div class="title">我的练习</div>
    <div class="wrapper">
      <ul class="top">
        <li class="order">
          <el-badge :value="12" class="item" type="primary">
            <span>全部</span>
          </el-badge>
        </li>
        <li class="order">
          <el-badge :value="1" class="item" type="primary">
            <span>未开始</span>
          </el-badge>
        </li>
        <li class="order">
          <el-badge :value="2" class="item" type="primary">
            <span>已开始</span>
          </el-badge>
        </li>
        <li class="order">
          <el-badge :value="1" class="item">
            <span>已过期</span>
          </el-badge>
        </li>
        <li class="search-li"><div class="icon"><input type="text" placeholder="试卷名称" class="search" v-model="source"><i class="el-icon-search"></i></div></li>
        <li><el-button type="primary" @click="startQuery()">搜索试卷</el-button></li>
      </ul>
     <ul class="paper" >
        <li class="item" v-for="(item,index) in examData" :key="index">
          <h4 @click="toExamMsg(item.examCode)">{{item.source}}</h4>
          <p class="name">{{item.source}}-{{item.description}}</p>
          <div class="info">
            <i class="el-icon-loading"></i><span>{{item.examDate.substr(0,10)}}</span>
            <i class="iconfont icon-icon-time"></i><span v-if="item.totalTime != null">{{item.totalTime}}限时分钟</span>
            <i class="iconfont icon-fenshu"></i><span>满分{{item.totalScore}}分</span>
          </div>
        </li>
      </ul>
      <!-- 分页 -->
  <el-pagination
  :background="true"
  layout="prev, pager, next"
  :total="totalCount"
  :page-size="4"
  :current-page="pageIndex"
  @current-change='changeCurrentPage'
  >
</el-pagination>
    </div>
  </div>
</template>

<script>
export default {
  // name: 'myExam'
  data() {
    return {
     source:'',
       pageIndex:1,
      totalCount:0,
      examData:[],
    }
  },
  created() {
    this.loadExam();
  },
  // watch: {
    
  // },
  methods: {
    //获取当前所有考试信息
   //加载列表
    loadExam(source='',pageIndex=1){
      source = this.source;
      this.pageIndex = pageIndex;
        this.$axios.get("front/exam/list",{params:{
          pageIndex:this.pageIndex,pageSize:4,source
        }}).then(r=>{
            console.log(r.data.data.list);
            this.examData = r.data.data.list
            this.pageIndex = r.data.data.pageNum
            this.totalCount = r.data.data.total
        })
    },
    //修改当前页码 触发的事件方法
    changeCurrentPage(curpage){
      this.pageIndex = curpage;
      this.loadExam(this.source,this.pageIndex);
    },
     //查询
    startQuery(){
      this.pageIndex = 1;
      this.loadExam(this.source,this.pageIndex);
    },
    //跳转到试卷详情页
    toExamMsg(examCode) {
      this.$router.push({path: '/examMsg', query: {examCode: examCode}})
      console.log(examCode)
    }
  }
}
</script>


<style lang="scss" scoped>

.paper {
  h4 {
    cursor: pointer;
  }
}
.paper .item a {
  color: #000;
}
.wrapper .top .order {
  cursor: pointer;
}
.wrapper .top .order:hover {
  color: #0195ff;
  border-bottom: 2px solid #0195ff;
}
.wrapper .top .order:visited {
  color: #0195ff;
  border-bottom: 2px solid #0195ff;
}
.item .info i {
  margin-right: 5px;
  color: #0195ff;
}
.item .info span {
  margin-right: 14px;
}
.paper .item {
  width: 380px;
  border-radius: 4px;
  padding: 20px 30px;
  border: 1px solid #eee;
  box-shadow: 0 0 4px 2px rgba(217,222,234,0.3);
  transition: all 0.6s ease;
}
.paper .item:hover {
  box-shadow: 0 0 4px 2px rgba(140, 193, 248, 0.45);
  transform: scale(1.03);
}
.paper .item .info {
  font-size: 14px;
  color: #88949b;
}
.paper .item .name {
  font-size: 14px;
  color: #88949b;
}
.paper * {
  margin: 20px 0;
}
.wrapper .paper {
  display: flex;
  justify-content: space-around;
  flex-wrap: wrap;
}
.top .el-icon-search {
  position: absolute;
  right: 10px;
  top: 10px;
}
.top .icon {
  position: relative;
}
.wrapper .top {
  border-bottom: 1px solid #eee;
  margin-bottom: 20px;
}
#myExam .search-li {
  margin-left: auto;
}
.top .search-li {
  margin-left: auto;
}
.top li {
  display: flex;
  align-items: center;
}
.top .search {
  margin-left: auto;
  padding: 10px;
  border-radius: 4px;
  border: 1px solid #eee;
  box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
  transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
}
.top .search:hover {
  color: #0195ff;
  border-color: #0195ff;
}
.wrapper .top {
  display: flex;
}
.wrapper .top li {
  margin: 20px;
}
#myExam {
  width: 980px;
  margin: 0 auto;
}
#myExam .title {
  margin: 20px;
}
#myExam .wrapper {
  background-color: #fff;
}
.wrapper .top .order {
  cursor: pointer;
}
.wrapper .top .order:hover {
  color: #0195ff;
  border-bottom: 2px solid #0195ff;
}
.wrapper .top .order:visited {
  color: #0195ff;
  border-bottom: 2px solid #0195ff;
}
.item .info i {
  margin-right: 5px;
  color: #0195ff;
}
.item .info span {
  margin-right: 14px;
}
.paper .item {
  border-radius: 4px;
  padding: 20px 30px;
  border: 1px solid #eee;
  box-shadow: 0 0 4px 2px rgba(217,222,234,0.3);
  transition: all 0.6s ease;
}
.paper .item:hover {
  box-shadow: 0 0 4px 2px rgba(140, 193, 248, 0.45)
}
.paper .item .info {
  font-size: 14px;
  color: #88949b;
}
.paper .item .name {
  font-size: 14px;
  color: #88949b;
}
.paper * {
  margin: 20px 0;
}
.wrapper .paper {
  display: flex;
  justify-content: space-around;
  flex-wrap: wrap;
}
.top .el-icon-search {
  position: absolute;
  right: 10px;
  top: 10px;
}
.top .icon {
  position: relative;
}
.wrapper .top {
  border-bottom: 1px solid #eee;
}
#myExam .search-li {
  margin-left: auto;
}
.top .search-li {
  margin-left: auto;
}
.top li {
  display: flex;
  align-items: center;
}
.top .search {
  margin-left: auto;
  padding: 10px;
  border-radius: 4px;
  border: 1px solid #eee;
  box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
  transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
}
.top .search:hover {
  color: #0195ff;
  border-color: #0195ff;
}
.wrapper .top {
  display: flex;
}
.wrapper .top li {
  margin: 20px;
}
#myExam {
  width: 980px;
  margin: 0 auto;
}
#myExam .title {
  margin: 20px;
}
#myExam .wrapper {
  background-color: #fff;
}
</style>
