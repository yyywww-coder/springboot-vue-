<template>
  <div>
    <!-- 面包屑 -->
    <el-breadcrumb separator="/">
      <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item><a href="/exam">题库管理</a></el-breadcrumb-item>
      <el-breadcrumb-item>添加题目</el-breadcrumb-item>
    </el-breadcrumb>

    <el-row style="margin-top:20px;margin-button:20px">
      <el-col :span="8">
        <el-input placeholder="请输入内容" v-model="searchText">
          <el-button  @click="startQuery"  slot="append"  icon="el-icon-search" ></el-button>
        </el-input>
      </el-col>
    </el-row>

    <el-table :data="pagination.list" border>
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
          <el-button @click="add(scope.row.paperId,scope.row.source)" type="primary" size="small">增加题库</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="pagination.pageNum"
      :page-sizes="[4, 8, 10, 20]"
      :page-size="pagination.pageSize"
      layout="total, sizes, prev, pager, next, jumper"
      :total="pagination.total" class="page">
    </el-pagination>
  </div>
</template>

<script>
  export default {
    name: "AddQuestion",
    data() {
      return {
        form: {}, //保存点击以后当前试卷的信息
        pagination: { //分页后的考试信息
          pageNum: 1, //当前页
          total: null, //记录条数
          pageSize: 4 //每页条数
        },
        searchText:''
      }
    },
    created() {
      this.getExamInfo()
    },
    methods: {
      startQuery(){
        this.getExamInfo()
      },
      getExamInfo() { //分页查询所有试卷信息
        this.$axios.get(`/exam/exams/${this.pagination.pageNum}/${this.pagination.pageSize}`,{params:{searchName:this.searchText}}).then(res => {
          this.pagination = res.data.data
        }).catch(error => {
        })
      },
      //改变当前记录条数
      handleSizeChange(val) {
        this.pagination.pageSize = val
        this.getExamInfo()
      },
      //改变当前页码，重新发送请求
      handleCurrentChange(val) {
        this.pagination.pageNum = val
        this.getExamInfo()
      },
      add(paperId,source) { //增加题库
        this.$router.push({path:'/addAnswerChildren',query: {paperId: paperId,subject:source}})
      }
    },
  }
</script>

<style lang="less">
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
  .el-breadcrumb {
    background: #d4dae0;
    padding-left: 20px;
    height: 40px;
    line-height: 40px;
  }
</style>
