<template>
  <div>
    <el-breadcrumb separator="/">
      <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item><a href="/">讲师管理</a></el-breadcrumb-item>
      <el-breadcrumb-item>讲师列表</el-breadcrumb-item>
    </el-breadcrumb>

    <el-row style="margin-top:20px;margin-button:20px">
      <el-col :span="8">
        <el-input placeholder="请输入内容" v-model="searchText">
    <el-button slot="append" @click="startQuery" icon="el-icon-search"></el-button>
  </el-input>
      </el-col>
      <el-col :span="8">
        <el-button type="primary"  @click="handleAdd">添加员工</el-button>
      </el-col>
    </el-row>

     <el-table
    :data="teacherData"
    style="width: 100%"
    height="450px">
    <el-table-column
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
      prop="education"
      label="教育背景"
      width="120">
    </el-table-column>
    <el-table-column
      prop="isfamous"
      label="水平"
      width="120">
      <template slot-scope="scope">{{scope.row.isfamous=='y'?'高级':'中级'}}</template>
    </el-table-column>
    <el-table-column
      prop="telephone"
      label="电话"
      width="120">
    </el-table-column>
    <el-table-column
      prop="status"
      label="状态"
      width="120">
      <template slot-scope="scope">{{scope.row.status=='1'?'管理员':'教师'}}</template>
    </el-table-column>
    <el-table-column label="操作">
      <template slot-scope="scope">
        <el-button
          icon="el-icon-edit"
          size="mini"
          @click="handleEdit(scope.row)">编辑</el-button>
        <el-button
          icon="el-icon-delete"
          size="mini"
          type="danger"
          @click="handleDelete(scope.row)">删除</el-button>
          <el-button
            icon="el-icon-coin"
           type="success" size="mini" @click="showRightsDialog(scope.row.id)"
          >权限</el-button>
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

<!-- 添加员工 -->
<el-dialog title="添加讲师" :visible.sync="addForm" label-width="100px" >
  <el-form :model="addManager" :rules="rules" ref="addManager">
      <el-form-item label="账号" prop="account">
      <el-input v-model="addManager.account" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="密码" prop="password">
      <el-input v-model="addManager.password" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="姓名" prop="username">
      <el-input v-model="addManager.username" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="年龄" prop="age">
      <el-input v-model="addManager.age" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="教育背景" prop="education">
      <el-input v-model="addManager.education" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="电话" prop="telephone">
      <el-input v-model="addManager.telephone" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="性别">
        <el-radio v-model="addManager.gender" label="1">男</el-radio>
        <el-radio v-model="addManager.gender" label="0">女</el-radio>
    </el-form-item>
    <el-form-item label="是否名师" >
        <el-radio v-model="addManager.isfamous" label="y">高级</el-radio>
        <el-radio v-model="addManager.isfamous" label="n">普通</el-radio>
    </el-form-item>

    <el-form-item label="身份">
        <el-radio v-model="addManager.status" label="1">管理员</el-radio>
        <el-radio v-model="addManager.status" label="0">教师</el-radio>
    </el-form-item>
    <el-form-item label="员工图片">
          <el-upload
            :show-file-list="false"
            :on-success="handleAvatarSuccess"
            :before-upload="beforeAvatarUpload"
            action="http://localhost:8899/manager/uploadImage"
            :headers={Authorization:this.token}
            class="avatar-uploader">
            <el-button size="small" type="primary">上传图片</el-button>
            <img :src="addManager.imageUrl">
          </el-upload>

        </el-form-item>

  </el-form>
  <div slot="footer" class="dialog-footer">
    <el-button @click="addForm = false">取 消</el-button>
    <el-button type="primary" @click="submitAdd(addManager)">确 定</el-button>
  </div>
</el-dialog>

<!-- 编辑 -->
<el-dialog title="编辑讲师" :visible.sync="updateForm" ref="addManager">
  <el-form :model="updateTeacher">
      <el-form-item label="账号" >
      <el-input v-model="updateTeacher.account" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="密码" >
      <el-input v-model="updateTeacher.password" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="姓名" >
      <el-input v-model="updateTeacher.username" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="年龄" >
      <el-input v-model="updateTeacher.age" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="教育背景" >
      <el-input v-model="updateTeacher.education" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="电话" >
      <el-input v-model="updateTeacher.telephone" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="性别">
        <el-radio v-model="updateTeacher.gender" label="1">男</el-radio>
        <el-radio v-model="updateTeacher.gender" label="0">女</el-radio>
    </el-form-item>
    <el-form-item label="级别">
        <el-radio v-model="updateTeacher.isfamous" label="y">高级</el-radio>
        <el-radio v-model="updateTeacher.isfamous" label="n">普通</el-radio>
    </el-form-item>
    <el-form-item label="身份">
        <el-radio v-model="updateTeacher.status" label="1">管理员</el-radio>
        <el-radio v-model="updateTeacher.status" label="0">教师</el-radio>
    </el-form-item>
  </el-form>
  <div slot="footer" class="dialog-footer">
    <el-button @click="updateForm = false">取 消</el-button>
    <el-button type="primary" @click="submitUpdate">确 定</el-button>
  </div>
</el-dialog>

<!-- 权限列表 -->
    <el-dialog title="设置权限" :visible.sync="dialogRightsVisible">
      <el-tree
      :data="data"
      show-checkbox
      node-key="id"
      ref="tree"
      default-expand-all=""
      :props="defaultProps">
    </el-tree>
    <div slot="footer" class="dialog-footer">
        <el-button @click="dialogRightsVisible = false">取 消</el-button>
        <el-button type="primary" @click="addRights()">修 改</el-button>
    </div>
    </el-dialog>

  </div>
</template>

<script>
export default {
  data() {
    return {
      dialogRightsVisible:false,
      data: [{
          id: '',
          label: '',
          children: [{
            id: '',
            label: '',
            children: [{
              id: '',
              label: ''
            }, {
              id: '',
              label: ''
            }]
          }]
        }
        ],
        defaultProps: {
          children: 'children',
          label: 'name'
        },
        managerId:"",
     pageIndex:1,
      totalCount:0,
      searchText:"",
        rules: {
        account: [
          { required: true, message: '请输入账号', trigger: 'blur' },],
          password: [
          { required: true, message: '请输入密码', trigger: 'blur' },],
          username: [
          { required: true, message: '请输入用户名', trigger: 'blur' },],
          age: [
          { required: true, message: '请输入年龄', trigger: 'blur' },],
          education: [
          { required: true, message: '请输入经验', trigger: 'blur' },],
           telephone: [
          { required: true, message: '请输入11位号码', trigger: 'blur' },]
      },

        addManager:{account:'',password:'',username:'',age:'',education:'',isfamous:'1',gender:'y',telephone:'',status:'1',imageUrl:''},

        token:localStorage.getItem("token"),
    addForm:false,
      subjects:[],
      searchText:'',
        teacherData:[{
            id:'1',
            account:'kzh',
            username:'kzh',
            gender:'1',
            age:'21',
            education:'啊大苏打',
           isfamous:'y',
           telephone:'',
            status:'1',

        }],
        updateForm:false,
        updateTeacher:{account:'',password:'',username:'',age:'',education:'',isfamous:'',telephone:'',gender:'',status:''},
        id:''
    };
  },
  methods:{
     //上传视频图片成功调用的方法
      handleAvatarSuccess(res, file) {
        console.log(res)
        this.addManager.imageUrl = res.data
      },
      //上传之前调用的方法
      beforeAvatarUpload(file) {
        const isJPG = file.type === 'image/jpeg'
        const isLt2M = file.size / 1024 / 1024 < 2

        if (!isJPG) {
          this.$message.error('上传头像图片只能是 JPG 格式!')
        }
        if (!isLt2M) {
          this.$message.error('上传头像图片大小不能超过 2MB!')
        }
        return isJPG && isLt2M
      },

     //加载所有权限
    loadRights(){
      this.$axios.get("perms/all",{params:{},
     }).then(res=>{
        this.data=res.data.data
      })
    },

    //显示权限
    showRightsDialog(id){
      this.managerId = id;
      this.dialogRightsVisible=true
      this.$axios.get("perms/perm",{
        params:{id}
      }).then(res=>{
        if(res.data.code==200){
          this.$refs.tree.setCheckedKeys(res.data.data)
          console.log(res)
        }
      })
    },
    addRights(id){
      alert(this.managerId)
      let key1=this.$refs.tree.getCheckedKeys()
      let key2=this.$refs.tree.getHalfCheckedKeys()
      let keys=key1.concat(key2);
      this.$axios.get("perms/add",{params:{
        "keys":keys.join(","),id:this.managerId
      }}).then(res=>{
        console.log(res)
      if(res.data.code==200){
        this.$message({type: 'success', message:"修改成功",  duration:800});
        this.dialogRightsVisible=false;
        this.loadManager();
      }else{
        this.$message({type: 'error', message:"修改失败",  duration:800});
        this.dialogRightsVisible=false;
      }
      })
    },
    //加载列表
    loadManager(searchText='',pageIndex=1){
      this.searchText = searchText;
      this.pageIndex = pageIndex;
        this.$axios.get("manager/list",{params:{
          pageIndex:this.pageIndex,pageSize:4,searchText:this.searchText
        }}).then(r=>{
            console.log(r);
            this.teacherData = r.data.data.list
            this.pageIndex = r.data.data.pageNum
            this.totalCount = r.data.data.total
        })
    },
    //修改当前页码 触发的事件方法
    changeCurrentPage(curpage){
      this.pageIndex = curpage;
      this.loadManager(this.searchText,this.pageIndex);
    },
     //查询
    startQuery(){
      this.pageIndex = 1;
      this.loadManager(this.searchText,this.pageIndex);
    },
    handleAdd(){
      this.$axios.get("manager/goAdd").then(res=>{
        if(res.data.code != 200){
           this.$message({
              type: 'warning',
              message: "无权限",
              duration:1000,
            });
        }else{
          this.addForm = true
        }
      })
    },
    //提交添加
    submitAdd(addManager){
      this.$refs.addManager.validate((valid) =>{
        if (valid) {
          this.$axios.post("manager/add",this.addManager).then(r=>{
            console.log(r);
            if(r.data.code == 200){
        this.$message({
              type: 'success',
              message: "添加成功",
              duration:1000,
            });
        this.addForm = false
        //重新加载页面
        this.loadManager();
      }
        })
        }else{
          this.$message({
              type: 'warning',
              message: "请填写完整信息",
              duration:1000,
            });
        }
      })

    },
    //修改弹窗
    handleEdit(row){
      this.$axios.get("manager/goUpdate").then(res=>{
        if (res.data.code != 200) {
          this.$message({
              type: 'warning',
              message: "无权限",
              duration:1000,
            });
        }else{
 this.updateForm = true;
      this.updateTeacher.id = row.id;
      this.updateTeacher.account = row.account;
      this.updateTeacher.password = row.password;
      this.updateTeacher.username = row.username;
      this.updateTeacher.age = row.age;
      this.updateTeacher.education = row.education;
      this.updateTeacher.isfamous = row.isfamous;
        this.updateTeacher.telephone = row.telephone
        this.updateTeacher.gender = row.gender;
        this.updateTeacher.status = row.status;
        }
      })

    },
    //提交修改
    submitUpdate(){
       if(this.updateTeacher.isfamous){
             this.updateTeacher.isfamous = 'y'
         }else{
             this.updateTeacher.isfamous = 'n'
         }
        this.$axios.post("manager/update",this.updateTeacher).then(r=>{
          console.log(r);
          if(r.data.code == 200){
                this.$message({type: 'success', message:"修改成功",  duration:800});
                this.updateForm = false;
          }
          this.loadManager();
        })
    },
    //删除
    handleDelete(row){
      this.$axios.post("manager/del?id="+row.id).then(r=>{
            console.log(r);
             if(r.data.code == 200){
                this.$message({type: 'success', message:"删除成功",  duration:800});

                //重新加载页面
                this.loadManager();
             }else{
               this.$message({type: 'warning', message:"无权限",  duration:800});
             }
         })
    },
  },
  created(){
    this.loadManager();
    this.loadRights();
  }
};
</script>


<style lang="less" scoped>
  .el-breadcrumb {
    background: #d4dae0;
    padding-left: 20px;
    height: 40px;
    line-height: 40px;
  }


</style>
