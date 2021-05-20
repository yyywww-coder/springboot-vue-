<template>
  <div id="div1">

      <!-- 面包屑 -->
    <el-breadcrumb separator="/" align=middle>
        <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item><a href="/teacher">讲师管理</a></el-breadcrumb-item>
        <el-breadcrumb-item>讲师列表</el-breadcrumb-item>
    </el-breadcrumb>

     <el-row :gutter="10">
       <el-col :span="8">
            <el-button @click="showAddLinkDialog">添加链接</el-button>
        </el-col>
    </el-row>

    <el-table
    :data="tableData"
    style="width: 100%">
    
    <el-table-column
      label="编号"
      width="150" 
      align="center"
      >
      <template slot-scope="scope">
        <span style="margin-left: 10px">{{ scope.row.id}}</span>
      </template>
    </el-table-column>

    <el-table-column
      label="链接名"
      width="150" 
      align="center"
      >
      <template slot-scope="scope">
        <span style="margin-left: 10px">{{ scope.row.linkname}}</span>
      </template>
    </el-table-column>
    <el-table-column
      label="链接地址"
      width="150" 
      align="center"
      >
      <template slot-scope="scope">
        <span style="margin-left: 10px">{{ scope.row.linkaddress}}</span>
      </template>
    </el-table-column>
    
    
    <el-table-column label="操作" align="center">
      <template slot-scope="scope">
        <el-button
          size="mini"
          @click="handleEdit(scope.row)">编辑</el-button>
        <el-button
          size="mini"
          type="danger"
          @click="handleDelete(scope.$index, scope.row)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>

  <!-- 分页 -->
    <el-pagination
        :background="true"
        layout="total,prev, pager, next"
        :current-page="pageIndex"
        :page-size="5"
        :total="total"
        @current-change="handleCurrentChange"
        >
    </el-pagination>

    <!-- 添加链接 对话框 
    :visible 是否显示对话框，如果 dialogFormVisible：true 就显示  否则就不显示
    rules 就是表单每项的数据校验  ref  就是将来可以通过 this.$ref.addStudent
    el-form-item :就是el-form表单里面的每项-->
    <el-dialog title="添加链接" :visible.sync="addDialogFormVisible" 
       label-width="100px" >
        <el-form :model="links" :rules='rules' ref = "links">
            
          <div style="margin: 20px 0;"></div>

            <el-form-item label="链接名" prop="linkname" >
                <el-input  placeholder="请输入链接名"  v-model="links.linkname" suffix-icon="el-icon-user"></el-input>
            </el-form-item>
            <el-form-item label="链接地址" prop="linkaddress">
                <el-input v-model="links.linkaddress"  placeholder="请输入链接地址" suffix-icon="el-icon-date"></el-input>
            </el-form-item>

        </el-form> 
        <div slot="footer" class="dialog-footer">
            <el-button @click="addDialogFormVisible = false">取 消</el-button>
            <el-button type="primary" @click="addLinks(links)">确 定</el-button>
        </div>
     </el-dialog>


    <!-- 修改链接 -->
     <el-dialog title="修改链接" :visible.sync="updateDialogFormVisible" 
      :rules='rules' label-width="100px" >
        <el-form :model="updateLink" ref = "updateLink">
          <div style="margin: 20px 0;"></div>
            <el-form-item label="链接名" prop="linkname" >
                <el-input  placeholder="请输入里链接名"  v-model="updateLink.linkname" suffix-icon="el-icon-user"></el-input>
            </el-form-item>
            <el-form-item label="链接地址" prop="linkaddress">
                <el-input v-model="updateLink.linkaddress" placeholder="请输入链接地址" suffix-icon="el-icon-date"></el-input>
            </el-form-item>
        </el-form> 
        <div slot="footer" class="dialog-footer">
            <el-button @click="updateDialogFormVisible = false">取 消</el-button>
            <el-button type="primary" @click="upLink()">确 定</el-button>
        </div>
     </el-dialog>
  </div>
</template>

<script>
    
  export default {
    data() {
      return {
        pageIndex:1,
        total:0,
        // 链接列表
        tableData: [{
             id:'',
            linkname:'',
            linkaddress:''
        }],
        // 添加弹窗显示
        addDialogFormVisible:false,
        // 添加教师字段规则
        rules:{
          linkname:[
              {required: true,message: "请输入链接名称",trigger: "blur"}
          ],
          linkaddress:[
            {required: true,message: "请输入链接地址",trigger: "blur"}
          ]
        },
        // 添加链接集合
        links:{
          
        },
        text: '',
        textarea: '',
        // 修改链接弹窗显示
        updateDialogFormVisible:false,
        // 修改链接集合
        updateLink:{
            id:'',
            linkname:'',
            linkaddress:''
        }
      }
    },
    methods: {
       // 查询显示所有链接列表
        showLinks(pageIndex=1){
        this.pageIndex=pageIndex;
            this.$axios.get("/links/list",{
            params:{
                pageIndex:this.pageIndex,
                pageSize:5
                }
            }).then(ref=>{
                console.log(ref)
                this.tableData=ref.data.data.list;
                // 获取当前页
                this.pageIndex=ref.data.data.pageNum
                // 获取总记录数
                this.total=ref.data.data.total
            })
        },

        // 当前页发生改变
        handleCurrentChange(val){
        this.pageIndex=val;
        this.showLinks(this.pageIndex);
        },
    
        //  显示添加链接窗口
        showAddLinkDialog(){
        this.addDialogFormVisible=true;
        },

        //  添加链接
        addLinks(links){

          this.$refs.links.validate((valid) =>{
            if (valid) {
               this.$axios.post("/links/add",this.links).then(ref=>{
            console.log(ref)
            if(ref.data.code==200){
            this.$message({type: 'success', message:"添加成功",  duration:800});
                    this.addDialogFormVisible = false;
                    //重新加载页面
                    this.showLinks()
            }
        })
            }else{
              this.$message({type: 'warning', message:"请填写完整信息",  duration:800});
            }
          })

        
        },

        //  显示修改链接窗口
        handleEdit(row){
            this.updateDialogFormVisible =true;
            this.updateLink.id=row.id
            this.updateLink.linkname=row.linkname
            this.updateLink.linkaddress=row.linkaddress
        },

        //  修改链接
        upLink(){
            this.$axios.post("/links/update",this.updateLink).then(ref=>{
            console.log(ref)
            if(ref.data.code == 200){
                this.$message({type: 'success', message:"修改成功",  duration:800});
                this.updateDialogFormVisible=false
                //重新加载页面
                this.showLinks(1)
            }
            })
        },

        //  删除链接
        handleDelete(index, row) {
        console.log(index, row);
        this.$axios.get("/links/delete?id="+row.id).then(ref=>{
            if(ref.data.code == 200){
                this.$message({type: 'success', message:"删除成功",  duration:800});
                //重新加载页面
                this.showLinks(1)
            }
        })
        }
    },
    created(){
      this.showLinks();
    }
  }
</script>

<style>
    .el-breadcrumb{
        
        line-height: 40px;
    }
    .el-row{
        margin-left: 60px;
    }
    *{
        margin-top: 0;
        padding-top: 0;
    }
    .el-dialog{
      width: 650px;
    }

</style>