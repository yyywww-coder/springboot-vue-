<template>
  <div class="exam">
    <!-- 面包屑 -->
    <el-breadcrumb separator="/">
      <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item><a href="/exam">考试管理</a></el-breadcrumb-item>
      <el-breadcrumb-item>考试列表</el-breadcrumb-item>
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
          <el-button @click="edit(scope.row.examCode)" type="primary" size="small">编辑</el-button>
          <el-button @click="deleteRecord(scope.row.examCode)" type="danger" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
<!--    分页-->
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="pagination.pageNum"
      :page-sizes="[4, 8, 10, 20]"
      :page-size="pagination.pageSize"
      layout="total, sizes, prev, pager, next, jumper"
      :total="pagination.total" class="page">
    </el-pagination>
    <!-- 编辑对话框-->
    <el-dialog
      title="编辑试卷信息"
      :visible.sync="dialogVisible"
      width="30%"
      :before-close="handleClose">
      <section class="update">
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="试卷名称">
            <el-input v-model="form.source"></el-input>
          </el-form-item>
          <el-form-item label="介绍">
            <el-input v-model="form.description"></el-input>
          </el-form-item>
          <el-form-item label="所属学院">
            <el-input v-model="form.institute"></el-input>
          </el-form-item>
          <el-form-item label="所属专业">
            <el-input v-model="form.major"></el-input>
          </el-form-item>
          <el-form-item label="年级">
            <el-input v-model="form.grade"></el-input>
          </el-form-item>
          <el-form-item label="考试日期">
            <el-col :span="11">
              <el-date-picker type="date" placeholder="选择日期" v-model="form.examDate" style="width: 100%;"></el-date-picker>
            </el-col>
          </el-form-item>
          <el-form-item label="持续时间">
            <el-input v-model="form.totalTime"></el-input>
          </el-form-item>
          <el-form-item label="总分">
            <el-input v-model="form.totalScore"></el-input>
          </el-form-item>
          <el-form-item label="试卷类型">
            <el-input v-model="form.type"></el-input>
          </el-form-item>
          <el-form-item label="考生提示">
            <el-input type="textarea" v-model="form.tips"></el-input>
          </el-form-item>
        </el-form>
      </section>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="submit()">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
  export default {
    name: "Exam",
    data() {
      return {
        form: {}, //保存点击以后当前试卷的信息
        pagination: { //分页后的考试信息
          pageNum: 1, //当前页
          total: null, //记录条数
          pageSize: 4 //每页条数
        },
        dialogVisible: false,
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
      edit(examCode) { //编辑试卷
        this.dialogVisible = true
        this.$axios.get(`/exam/beforeUpdate/${examCode}`).then(res => { //根据试卷id请求后台
          if(res.data.code == 200) {
            console.log(res)
            this.form = res.data.data
          }
        })
      },
      handleClose(done) { //关闭提醒
        this.$confirm('确认关闭？')
          .then(_ => {
            done();
          }).catch(_ => {});
      },
      submit() { //提交修改后的试卷信息
        this.dialogVisible = false
        this.$axios({
          url: '/exam/update',
          method: 'put',
          data: {
            ...this.form
          }
        }).then(res => {
          if(res.data.code == 200) {
            this.$message({ //成功修改提示
              message: '更新成功',
              type: 'success',
              duration:800
            })
          }
          this.getExamInfo()
        })
      },
      deleteRecord(examCode) {
        this.$confirm("确定删除该记录吗,该操作不可逆！！！","删除提示",{
          confirmButtonText: '确定删除',
          cancelButtonText: '算了,留着',
          type: 'danger'
        }).then(()=> { //确认删除
          this.$axios({
            url: `/exam/delete/${examCode}`,
            method: 'delete',
          }).then(res => {
            if(res.data.code==200){
              this.$message({type: 'success', message:"删除成功",  duration:800});
            }
            this.getExamInfo()
          })
        }).catch(() => {

        })
      },
      getExamInfo() { //分页查询所有试卷信息
        this.$axios.get(`/exam/list/${this.pagination.pageNum}/${this.pagination.pageSize}`,{params:{searchName:this.searchText}}).then(res => {
          console.log(res)
          this.pagination = res.data.data
        }).catch(error => {
        })
      },
      //改变当前记录条数
      handleSizeChange(val) {
        console.log(val)
        this.pagination.pageSize = val
        // if(val<4){
        //   this.pagination.size=4
        // }
        // this.pagination.current=1
        this.getExamInfo()
      },
      //改变当前页码，重新发送请求
      handleCurrentChange(val) {
        this.pagination.pageNum = val
        // if(this.pagination.size<4){
        //   this.pagination.size=4
        // }
        this.getExamInfo()
      },
    },
  }
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
  .el-breadcrumb {
    background: #d4dae0;
    padding-left: 20px;
    height: 40px;
    line-height: 40px;
  }

</style>
