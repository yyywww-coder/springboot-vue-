<template>
  <div class="table">
    <p class="title">我的分数</p>
    <section class="content-el">
      <el-table ref="filterTable" :data="score" >
        <el-table-column
          prop="answerDate"
          label="考试日期"
          sortable
          width="300"
          column-key="answerDate"
          >
        </el-table-column>
        <el-table-column
          prop="subject"
          label="课程名称"
          width="300"
          filter-placement="bottom-end">
          <template slot-scope="scope">
            <el-tag>{{scope.row.subject}}</el-tag>
          </template>
        </el-table-column>
        <el-table-column prop="etScore" label="考试分数" width="200"></el-table-column>
        <el-table-column label="是否及格" width="100">
          <template slot-scope="scope">
            <el-tag :type="scope.row.etScore>= 60 ? 'success' : 'danger'">{{scope.row.etScore >= 60 ? "及格" : "不及格"}}</el-tag>
          </template>
        </el-table-column>
      </el-table>
      <el-row type="flex" justify="center" align="middle" class="pagination">
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

      </el-row>
    </section>
  </div>
</template>

<script>
export default {
  data() {
    return {
      pageIndex:1,
      totalCount:0,
      score: [],
    }
  },
  created() {
    this.getScore()
    //this.loading = true //数据加载则遮罩表格
  },
  methods: {
    getScore() {
      let studentId = '2'
      this.$axios.get("front/score/find",{params:{
          pageIndex:this.pageIndex,pageSize:4,studentId
      }}).then(res=>{
          console.log(res);
          this.score = res.data.data.list
           this.pageIndex = res.data.data.pageNum
            this.totalCount = res.data.data.total
      })
  },
   //修改当前页码 触发的事件方法
    changeCurrentPage(curpage){
      this.pageIndex = curpage;
      this.getScore()
    },
}
}
</script>

<style lang="scss" scoped>
.pagination {
  padding-top: 20px;
}
.table {
  width: 980px;
  margin: 0 auto;
  .title {
    margin: 20px;
  }
  .content-el {
    background-color: #fff;
    padding: 20px;
  }
}
</style>
