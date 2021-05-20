//查询所有考试跳转到分段页面
<template>
  <div class="exam">
    <el-table :data="examData" border>
      <el-table-column fixed="left" prop="source" label="试卷名称" width="180"></el-table-column>
      <el-table-column prop="description" label="介绍" width="200"></el-table-column>
      <el-table-column prop="institute" label="所属学院" width="120"></el-table-column>
      <el-table-column prop="major" label="所属专业" width="200"></el-table-column>
      <el-table-column prop="grade" label="年级" width="100"></el-table-column>
      <el-table-column prop="examDate" label="考试日期" width="120"></el-table-column>
      <el-table-column prop="totalTime" label="持续时间" width="120"></el-table-column>
      <el-table-column prop="totalScore" label="总分" width="120"></el-table-column>
      <el-table-column prop="type" label="试卷类型" width="120"></el-table-column>
      <el-table-column prop="tips" label="考生提示" width="400"></el-table-column>
      <el-table-column fixed="right" label="操作" width="150">
        <template slot-scope="scope">
          <el-button @click="toPart(scope.row.examCode,scope.row.source)" type="primary" size="small">查看分段</el-button>
        </template>
      </el-table-column>
    </el-table>
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
</template>

<script>
  export default {
    data() {
      return {
        source:'',
        pageIndex:1,
        totalCount:0,
        examData:[],
        dialogVisible: false
      }
    },
    created() {
      this.loadExam()
    },
    methods: {
      loadExam(source='',pageIndex=1){
        source = this.source;
        this.pageIndex = pageIndex;
        this.$axios.get("exam/findAll",{params:{
            pageIndex:this.pageIndex,pageSize:4,source
          }}).then(r=>{
          console.log(r);
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
      toPart(examCode,source) { //跳转到分段charts页面
        this.$router.push({path: '/scorePart', query:{examCode: examCode, source: source}})
      }
    },
  };
</script>
<style lang="less" scoped>
  .exam {
    padding: 0px 40px;
    .page {
      margin-top: 20px;
      display: flex;
      justify-content: center;
      align-items: center;
    }
    .edit{
      margin-left: 20px;
    }
  }
</style>
