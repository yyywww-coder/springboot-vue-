<template>
  <div class="app-container">
    <!-- 面包屑 -->
    <el-breadcrumb separator="/">
      <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item><a href="/banner">Banner管理</a></el-breadcrumb-item>
      <el-breadcrumb-item>Banner列表</el-breadcrumb-item>
    </el-breadcrumb>

    <!--查询表单-->
    <el-form :inline="true" class="demo-form-inline" style="margin-top: 20px;margin-bottom: 15px">
      <el-form-item>
        <el-input v-model="bannerQuery" placeholder="Banner标题"/>
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

      <el-table-column prop="gmtCreate" label="添加时间" width="240" :formatter="formatTime"/>

      <el-table-column label="操作" width="200" align="center">
        <template slot-scope="scope">
          <router-link :to="'/banner/edit/'+scope.row.id">
            <el-button type="primary" size="mini" icon="el-icon-edit">修改</el-button>
          </router-link>
          <el-button type="danger" size="mini" icon="el-icon-delete" @click="removeDataById(scope.row.id)">删除</el-button>
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
    //写核心代码位置
    data() { //定义变量和初始值
      return {
        list:null,//查询之后接口返回集合
        page:1,//当前页
        limit:5,//每页记录数
        total:0,//总记录数
        bannerQuery:'' //条件对象
      }
    },
    created() { //页面渲染之前执行，一般调用methods定义的方法
      //调用
      this.getList()
    },
    methods:{  //创建具体的方法，调用teacher.js定义的方法
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
      //Banner列表的方法
      getList(bannerQuery='',page=1,limit=5) {
        this.$axios.post("banner/list",null,
          {params:{page,limit,bannerQuery}}).then(res=>{
            this.list=res.data.data.list
          this.page=res.data.data.pageNum
          this.limit=res.data.data.pageSize
          this.total=res.data.data.total
            console.log(res)

        })

      },
      changeCurrentPage(curpage){
        this.page = curpage;
        this.getList(this.bannerQuery,this.page,this.limit);
      },
      startQuery(){
        this.page=1
        this.getList(this.bannerQuery,this.page,this.limit)
      },
      resetData() {//清空的方法
        //表单输入项数据清空
        this.bannerQuery = ''
        //查询所有Banner数据
        this.getList()
      },
      //删除Banner的方法
      removeDataById(id) {
        this.$confirm('此操作将永久删除讲师记录, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {  //点击确定，执行then方法
          //调用删除的方法
         this.$axios.get(`banner/remove/${id}`)
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

<style scoped lang="less">
  .el-breadcrumb {
    background: #d4dae0;
    padding-left: 20px;
    height: 40px;
    line-height: 40px;
  }
</style>
