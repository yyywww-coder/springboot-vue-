<template>
  <div class="app-container">
    <!-- 面包屑 -->
    <el-breadcrumb separator="/">
      <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item><a href="/video">视频管理</a></el-breadcrumb-item>
      <el-breadcrumb-item>视频列表</el-breadcrumb-item>
    </el-breadcrumb>

    <!--查询表单-->
    <el-form :inline="true" class="demo-form-inline" style="margin-top: 20px;margin-bottom: 15px">
      <el-form-item>
        <el-input v-model="video.title" placeholder="视频标题"/>
      </el-form-item>

      <el-form-item label="讲课老师">
        <el-dropdown trigger="click" type="primary" @command="teacherCommand">
          <el-button type="primary" class="el-dropdown-link btn send time-send small-hand" id="custom-sebd-btn">
            {{tName}}<i class="el-icon-arrow-down el-icon--right"></i>
          </el-button>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item v-for="(teacher,index) in teachers" :command="teacher" :key="index">{{teacher.account}}</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </el-form-item>

      <el-form-item label="年级">
        <el-dropdown trigger="click" type="primary" @command="gradeCommand">
          <el-button type="primary" class="el-dropdown-link btn send time-send small-hand">
            {{gName}}<i class="el-icon-arrow-down el-icon--right"></i>
          </el-button>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item v-for="(course,index) in grades" :command="course" :key="index">{{course.grade}}</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </el-form-item>

      <el-button type="primary" icon="el-icon-search" @click="startQuery">查询</el-button>
      <el-button type="default" @click="resetData()">清空</el-button>
    </el-form>

    <!-- 表格 -->
    <el-table
      :data="list"
      border
      fit
      highlight-current-row>

      <el-table-column
        label="序号"
        width="70"
        align="center">
        <template slot-scope="scope">
          {{ (page - 1) * limit + scope.$index + 1 }}
        </template>
      </el-table-column>

      <el-table-column prop="title" label="标题" width="300" />

      <el-table-column prop="imageUrl" label="图片地址"   />

      <el-table-column prop="createTime" label="添加时间" width="240" :formatter="formatTime"/>

      <el-table-column label="操作" width="200" align="center">
        <template slot-scope="scope">
          <router-link :to="'/banner/edit/'+scope.row.id">
            <el-button type="primary" size="mini" icon="el-icon-edit">修改</el-button>
          </router-link>
          <el-button type="danger" size="mini" icon="el-icon-delete" @click="removeDataById(scope.row.videoSourceId)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!-- 分页 -->
    <el-pagination
      :current-page="page"
      :page-size="limit"
      :total="total"
      style="padding: 30px 0; text-align: center;"
      layout="total, prev, pager, next, jumper"
      @current-change="changeCurrentPage"
    />

  </div>
</template>

<script>
  export default {
    name: "Video",
    data(){
      return{
        list:null,//查询之后接口返回集合
        page:1,//当前页
        limit:5,//每页记录数
        total:0,//总记录数
        teachers:[],
        tName:'主讲老师',
        gName:'班级',
        video:{teacherId:0,
          courseId:0,
          title:''},
        grades:[]
      }
    },
    created(){
      this.getAllTeacher()
      this.getAllGrade()
      this.getList()
    },
    methods: {
       //转换时间格式
       formatTime (row, column) {
      const date = new Date(row[column.property])
      var month = date.getMonth()
      month = parseInt(month) + 1
      return date.getFullYear() + '年' +
        month + '月' +
        date.getDate() + '日 ' +
        date.getHours()
        + ':' + date.getMinutes() + ':' +
        date.getSeconds()
    },
      //获取所有的教师姓名
      getAllTeacher() {
        this.$axios.get("video/teachers").then(res => {
          this.teachers = res.data.data
          console.log(res)
        })
      },
      //获取所有的班级
      getAllGrade() {
        this.$axios.get("video/grades").then(res => {
          this.grades = res.data.data
          console.log(res)
        })
      },
      teacherCommand(command) {
        this.tName = command.account
        this.video.teacherId = command.id
      },
      gradeCommand(command){
        this.gName=command.grade
        this.video.courseId=command.id
      },
      //视频列表的方法
      getList() {
        this.$axios.post("video/list",this.video,
          {params:{page:this.page,limit:this.limit}}).then(res=>{
          this.list=res.data.data.list
          this.page=res.data.data.pageNum
          this.limit=res.data.data.pageSize
          this.total=res.data.data.total
          console.log(res)

        })

      },
      changeCurrentPage(curpage){
        this.page = curpage;
        this.getList();
      },
      startQuery(){
        this.page=1
        this.getList()
      },
      resetData() {//清空的方法
        //表单输入项数据清空
        this.bannerQuery = ''
        //查询所有Banner数据
        this.getList()
      },
      removeDataById(id){
        this.$confirm('此操作将永久删除讲师记录, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {  //点击确定，执行then方法
          //调用删除的方法
          this.$axios.get(`video/remove/${id}`)
            .then(res =>{//删除成功
              //提示信息
              this.$message({
                type: 'success',
                message: '删除成功!'
              });
              //回到列表页面
              this.getList()
            })
        }) //点击取消，执行catch方法
      }
    }
  }
</script>

<style lang="less">

</style>
