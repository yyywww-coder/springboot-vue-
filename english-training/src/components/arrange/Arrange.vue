<template>
    <div>
        <el-breadcrumb separator="/">
      <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item><a href="/">预约</a></el-breadcrumb-item>
      <el-breadcrumb-item>预约列表</el-breadcrumb-item>
    </el-breadcrumb>

<el-row :gutter="10">
      <el-col :span="8">
        <el-input placeholder="请输入内容" v-model="searchText">
    <el-button slot="append" @click="startQuery" icon="el-icon-search"></el-button>
  </el-input>
      </el-col>
    </el-row>

<el-table
    :data="arrangeData"
    style="width: 100%"
    height="450px">
    <el-table-column
      fixed
      prop="id"
      label="id"
      width="150"
      >
    </el-table-column>
    
    <el-table-column
      prop="username"
      label="姓名"
      width="120">
    </el-table-column>
    <el-table-column
      prop="gender"
      label="性别"
      width="120">
      <template slot-scope="scope">{{scope.row.gender=='1'?'男':'女'}}</template>
    </el-table-column>
    <el-table-column
      prop="age"
      label="年龄"
      width="120">
    </el-table-column>
    <el-table-column
      prop="telephone"
      label="电话"
      width="120">
    </el-table-column>
    <el-table-column
      prop="orderTime"
      label="预约时间"
      width="120" :formatter="formatTime">
    </el-table-column>
   <el-table-column
      prop="className"
      label="年级"
      width="120">
    </el-table-column>
    <el-table-column label="状态" width="180">
            <template slot-scope="scope">
        <span>{{scope.row.status==='1'?'待处理':'已处理'}}</span>
      </template>
        </el-table-column>
    <el-table-column label="操作">
        <template slot-scope="scope">
                <el-button @click="changeStatus(scope.row)" slot="append" type="primary">{{scope.row.status==='1'?'处理':'已处理'}}</el-button>
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
    data(){
        return{
            arrangeData:[{id:'1',username:'kzh',age:'1',gender:'1',telephone:'123',orderTime:'',className:''}],
             pageIndex:1,
      totalCount:0,
      searchText:"",
        }
    },
    methods:{
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
        //加载列表
    loadArranges(searchText='',pageIndex=1){
      this.searchText = searchText;
      this.pageIndex = pageIndex;
        this.$axios.get("arrange/list",{params:{
          pageIndex:this.pageIndex,pageSize:4,searchText:this.searchText
        }}).then(r=>{
            console.log(r);
            this.arrangeData = r.data.data.list
            this.pageIndex = r.data.data.pageNum
            this.totalCount = r.data.data.total
        })
    },
    //修改当前页码 触发的事件方法
    changeCurrentPage(curpage){
      this.pageIndex = curpage;
      this.loadArranges(this.searchText,this.pageIndex);
    },
     //查询
    startQuery(){
      this.pageIndex = 1;
      this.loadArranges(this.searchText,this.pageIndex);
    },
    //修改预约状态
        changeStatus(row) {
            if (row.status == "1") {
                row.status = "2"
            } else {
                row.status = "1"
            }
            this.$axios.get("/arrange/update", {
                params: {
                    id: row.id,
                    status: row.status
                }
            }).then(res => {
                //alert(res.config)
                console.log(res);
                //alert(res);
                if (res.data.code == 200) {
                    this.$message({ type: 'success', message: "修改成功", duration: 800 });
                    //重新加载页面
                   this.loadArranges();
                } else if (res.data.code == 403) {
                    this.$message({ type: 'warning', message: "没有该权限", duration: 800 });
                }
            })
        },
    },
    created(){
        this.loadArranges();
    }
}
</script>

<style>

</style>