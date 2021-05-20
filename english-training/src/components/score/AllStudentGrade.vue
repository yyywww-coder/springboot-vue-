// 所有学生
<template>
  <div class="all">

    <el-breadcrumb separator="/">
      <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item><a href="/">成绩管理</a></el-breadcrumb-item>
      <el-breadcrumb-item>成绩列表</el-breadcrumb-item>
    </el-breadcrumb>

    <br/>

    <el-col :span="8">
      <el-input placeholder="请输入内容" v-model="searchText">
        <el-button slot="append" @click="startQuery" icon="el-icon-search"></el-button>
      </el-input>
    </el-col>
    <br/> <br/>
    <el-table :data="studentData" border>
      <el-table-column fixed="left" prop="username" label="姓名" width="180"></el-table-column>
      <el-table-column prop="institute" label="学院" width="200"></el-table-column>
<!--      <el-table-column prop="major" label="专业" width="200"></el-table-column>-->
      <el-table-column prop="grade" label="年级" width="200"></el-table-column>
      <el-table-column prop="clazz" label="班级" width="100"></el-table-column>
      <el-table-column
        prop="gender"
        label="性别"
        width="120">
        <template slot-scope="scope">{{scope.row.gender=='1'?'男':'女'}}</template>
      </el-table-column>
      <el-table-column prop="phone" label="联系方式" width="120"></el-table-column>
      <el-table-column fixed="right" label="查看成绩" width="150">

        <template slot-scope="scope">
          <el-button @click="checkGrade(scope.row.id)" type="primary" size="small">查看成绩</el-button>
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
        pageIndex:1,
        totalCount:0,
        searchText:"",
        studentData:[{
          id:'',username:'',institute: '',major:'',clazz:'',grade:'',gender:'',phone:''
        }]
      };
    },
    created() {
      this.loadScore();
    },
    methods: {
      //加载列表
      loadScore(searchText='',pageIndex=1){
        this.searchText = searchText;
        this.pageIndex = pageIndex;
        this.$axios.get("student/find",{params:{
            pageIndex:this.pageIndex,pageSize:4,searchText:this.searchText
          }}).then(r=>{
          console.log(r);
          this.studentData = r.data.data.list
          this.pageIndex = r.data.data.pageNum
          this.totalCount = r.data.data.total
        })
      },
      //修改当前页码 触发的事件方法
      changeCurrentPage(curpage){
        this.pageIndex = curpage;
        this.loadScore(this.searchText,this.pageIndex);
      },
      //查询
      startQuery(){
        this.pageIndex = 1;
        this.loadScore(this.searchText,this.pageIndex);
      },
      checkGrade(id){
        this.$router.push({ path: "/grade", query: { id: id } });
      }
    }
  };
</script>
<style lang="less" scoped>
  .all {
    padding: 0px 40px;
    .page {
      margin-top: 20px;
      display: flex;
      justify-content: center;
      align-items: center;
    }
    .edit {
      margin-left: 20px;
    }
    .el-table tr {
      background-color: #dd5862 !important;
    }
  }
  .el-table .warning-row {
    background: #000 !important;
  }

  .el-table .success-row {
    background: #dd5862;
  }
</style>
