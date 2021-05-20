<template>
  <div>

      <!-- 面包屑 -->
    <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item><a href="/teacher">学生管理</a></el-breadcrumb-item>
        <el-breadcrumb-item>学生列表</el-breadcrumb-item>
    </el-breadcrumb>

     <el-row style="margin-top:20px;margin-button:20px">
       <el-col :span="8">
            <el-input placeholder="请输入内容" v-model="searchText">
                <el-button  @click="startQuery"  slot="append"  icon="el-icon-search" ></el-button>
            </el-input>
        </el-col>
        <el-col :span="2">
          <el-dropdown trigger="click" @command="handleCommand">
            <el-button type="primary" class="el-dropdown-link btn send time-send small-hand" id="custom-sebd-btn">
                                  {{custom}}<i class="el-icon-arrow-down el-icon--right"></i>
            </el-button>
              <el-dropdown-menu slot="dropdown">
                  <el-dropdown-item :command="grades.none">无</el-dropdown-item>
                  <el-dropdown-item :command="grades.gradeOne">少儿</el-dropdown-item>
                  <el-dropdown-item :command="grades.gradeTwo">初中</el-dropdown-item>
                  <el-dropdown-item :command="grades.gradeThr">高中</el-dropdown-item>
              </el-dropdown-menu>
          </el-dropdown>
        </el-col>
       <el-col :span="1.5">
         <el-button type="primary" @click="showAddTeacherDialog()" icon="el-icon-circle-plus-outline">添加学员</el-button>
       </el-col>
    </el-row>

    <el-table
    :data="tableData"
    style="width: 100%">
    <el-table-column
      label="年级"
      width="150"
      align="center"
      >
      <template slot-scope="scope">
        <span style="margin-left: 10px">{{ scope.row.grade}}</span>
      </template>
    </el-table-column>

    <el-table-column
      label="姓名"
      width="150"
      align="center"
      >
      <template slot-scope="scope">
        <el-popover trigger="hover" placement="top">
          <p>父母姓名: {{ scope.row.pName ==null?'无':scope.row.pName }}</p>
          <p>父母电话: {{ scope.row.pPhone ==null?'无':scope.row.pPhone }}</p>
          <p>本人电话: {{ scope.row.phone ==null?'无':scope.row.phone }}</p>
          <p>住址: {{ scope.row.address ==null?'无':scope.row.address }}</p>
          <p>邮箱: {{ scope.row.email ==null?'无':scope.row.email }}</p>
          <div slot="reference" class="name-wrapper">
            <el-tag size="medium">{{ scope.row.username }}</el-tag>
          </div>
        </el-popover>
      </template>
    </el-table-column>
    <el-table-column
      label="性别"
      width="150"
      align="center"
      >
      <template slot-scope="scope">
        <span style="margin-left: 10px">{{ scope.row.gender=='0' ?'女':'男' }}</span>
      </template>
    </el-table-column>
    <el-table-column
      label="年龄"
      width="150"
      align="center"
      >
      <template slot-scope="scope">

        <span style="margin-left: 10px">{{ scope.row.age }}</span>
      </template>
    </el-table-column>
    <el-table-column
      label="整体评价"
      width="150"
      align="center"
      >
      <template slot-scope="scope">
        <el-popover trigger="hover" placement="top">
          <b>老师评语: {{ scope.row.evaluation ==null?'无':scope.row.evaluation }}</b>
          <div slot="reference" class="name-wrapper">
            <el-tag size="medium">{{ scope.row.comment | comment }}</el-tag>
          </div>
        </el-popover>
      </template>
    </el-table-column>
    <el-table-column
      label="状态"
      width="180"
      align="center"
      >
      <template slot-scope="scope">
        <span style="margin-left: 10px">{{ scope.row.status| status }}</span>
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

    <!-- 添加学员 对话框
    :visible 是否显示对话框，如果 dialogFormVisible：true 就显示  否则就不显示
    rules 就是表单每项的数据校验  ref  就是将来可以通过 this.$ref.addStudent
    el-form-item :就是el-form表单里面的每项-->
    <el-dialog title="添加学生" :visible.sync="addDialogFormVisible"
       label-width="100px" >
        <el-form :model="student" :rules='rules' ref = "student">

          <div style="margin: 20px 0;"></div>

            <el-form-item label="姓名" prop="username" >

                <el-input  placeholder="请输入姓名"  v-model="student.username" suffix-icon="el-icon-user"></el-input>
            </el-form-item>
             <el-form-item label="性别" prop="gender" >
                <template>
                  <el-radio v-model="student.gender" label="0">女</el-radio>
                  <el-radio v-model="student.gender" label="1">男</el-radio>
                </template>
            </el-form-item>
            <el-form-item label="年龄" prop="age">
                <el-input v-model="student.age" maxlength="11" placeholder="请输入年龄" suffix-icon="el-icon-date"></el-input>
            </el-form-item>
            <el-form-item label="本人电话" prop="phone">
                <el-input v-model="student.phone" maxlength="11" placeholder="请输入本人电话" show-word-limit suffix-icon="el-icon-mobile"></el-input>
            </el-form-item>
            <el-form-item label="父母电话" prop="pPhone" >
                <el-input v-model="student.pPhone" maxlength="11" placeholder="请输入父母电话" show-word-limit suffix-icon="el-icon-mobile"></el-input>
            </el-form-item>
            <el-form-item label="父亲姓名" prop="pName">
                <el-input v-model="student.pName" maxlength="11" placeholder="请输入父亲姓名" suffix-icon="el-icon-s-custom"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="password">
                <el-input v-model="student.password" maxlength="11" placeholder="请输入密码" suffix-icon="el-icon-key"></el-input>
            </el-form-item>

              <el-form-item label="年级" prop="grade">
                <el-select v-model="grade" filterable  placeholder="请选择">
                  <el-option
                    v-for="item in gradeList"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value"
                    >
                  </el-option>
                </el-select>
              </el-form-item>


        </el-form>
        <div slot="footer" class="dialog-footer">
            <el-button @click="addDialogFormVisible = false">取 消</el-button>
            <el-button type="primary" @click="addTeacher(student)">确 定</el-button>
        </div>
     </el-dialog>


    <!-- 修改学员 -->
     <el-dialog title="修改学生" :visible.sync="updateDialogFormVisible"
      :rules='rules' label-width="100px" ref = "updateStudent">
        <el-form :model="updateStudent">

          <div style="margin: 20px 0;"></div>

            <el-form-item label="姓名" prop="username" >

                <el-input  placeholder="请输入姓名"  v-model="updateStudent.username" suffix-icon="el-icon-user"></el-input>
            </el-form-item>
             <el-form-item label="性别" prop="gender" >
                <template>
                  <el-radio v-model="updateStudent.gender" :label="0">女</el-radio>
                  <el-radio v-model="updateStudent.gender" :label="1">男</el-radio>
                </template>
            </el-form-item>
            <el-form-item label="年龄" prop="age">
                <el-input v-model="updateStudent.age" maxlength="11" placeholder="请输入年龄" suffix-icon="el-icon-date"></el-input>
            </el-form-item>
            <el-form-item label="本人电话" prop="phone">
                <el-input v-model="updateStudent.phone" maxlength="11" placeholder="请输入本人电话" show-word-limit suffix-icon="el-icon-mobile"></el-input>
            </el-form-item>
            <el-form-item label="父母电话" prop="pPhone" >
                <el-input v-model="updateStudent.pPhone" maxlength="11" placeholder="请输入父母电话" show-word-limit suffix-icon="el-icon-mobile"></el-input>
            </el-form-item>
            <el-form-item label="父亲姓名" prop="pName">
                <el-input v-model="updateStudent.pName" maxlength="11" placeholder="请输入父亲姓名" suffix-icon="el-icon-s-custom"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="password">
                <el-input v-model="updateStudent.password" maxlength="11" placeholder="请输入密码" suffix-icon="el-icon-key"></el-input>
            </el-form-item>

            <el-form-item label="评价">
                <el-select v-model="updateStudent.comment" filterable  placeholder="请选择">
                  <el-option
                    v-for="item in commentList"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value"
                    >
                  </el-option>
                </el-select>
              </el-form-item>

            <!-- <el-form-item label="评价" prop="comment">
                <el-input v-model="updateStudent.comment" placeholder="请填写评价" suffix-icon="el-icon-chat-line-round"></el-input>
            </el-form-item> -->

            <el-form-item label="祝语" prop="evaluation">
                <el-input v-model="updateStudent.evaluation" placeholder="请填写祝语" suffix-icon="el-icon-chat-line-round"></el-input>
            </el-form-item>
            <el-form-item label="地址" prop="address">
                <el-input v-model="updateStudent.address" placeholder="请填写地址" suffix-icon="el-icon-map-location"></el-input>
            </el-form-item>
            <el-form-item label="邮箱" prop="email">
                <el-input v-model="updateStudent.email" placeholder="请填写邮箱" suffix-icon="el-icon-message"></el-input>
            </el-form-item>


        </el-form>
        <div slot="footer" class="dialog-footer">
            <el-button @click="updateDialogFormVisible = false">取 消</el-button>
            <el-button type="primary" @click="upStudent()">确 定</el-button>
        </div>
     </el-dialog>
  </div>
</template>

<script>

  export default {
    data() {
      return {
        searchText:'',
        pageIndex:1,
        total:0,
        // 学生列表
        tableData: [{
            grade:'',
            username:'',
            gender:'',
            age:'',
            comment:'',
            evaluation:'',
            pName:'',
            pPhone:'',
            address:'',
            email:'',
            phone:'',
            status:'',
        }],
        // 添加弹窗显示
        addDialogFormVisible:false,
        // 添加教师字段规则
        rules:{
          username:[
            {required: true,message: "请输入学生名称",trigger: "blur"}
          ],
          age:[
            {required: true,message: "请输入年龄",trigger: "blur"}
          ],
          phone:[
            { required: true, message: '请输入手机号', trigger: 'blur' },
            {
            pattern: /^0{0,1}(13[0-9]|15[7-9]|153|156|18[7-9])[0-9]{8}$/,
            message: "手机号格式不对",
            trigger: "blur",
            },
          ],
          gender:[
            {required: true,message: "请选择性别",trigger: "blur"}
          ],
          pPhone:[
            {required: true,message: "请输入家长电话",trigger: "blur"}
          ],
          pName:[
            {required: true,message: "请输入家长姓名",trigger: "blur"}
          ],
          password:[
            {required: true,message: "请设置密码",trigger: "blur"}
          ],
         /* grade:[
            {required: true,message: "请选择年级",trigger: "blur"}
          ]*/
        },
        // 添加学生集合
        student:{

        },

        // 下拉框绑定年级值
        grade:'',

        // 单选框默认选中值
        radio: '1',
        //
        text: '',
        textarea: '',
        // 修改学生弹窗显示
        updateDialogFormVisible:false,
        // 修改学生集合
        updateStudent:{
            id:'',
            grade:'',
            username:'',
            gender:'',
            age:'',
            comment:'',
            evaluation:'',
            pName:'',
            pPhone:'',
            address:'',
            email:'',
            phone:'',
            status:'',
            password:''
        },
        // 下拉菜单年级集合
        gradeList:[
          {
            value: '1',
            label: '少儿'
          },{
            value: '2',
            label: '初中'
          },
            {
              value: '3',
              label: '高中'
            }
        ],

        //  修改评价下拉框
        commentList:[
          {
            value: '0',
            label: '差'
          },{
            value: '1',
            label: '中'
          },
            {
              value: '2',
              label: '优'
            }
        ],

        //  年级
        grades:{
          none:'无',
          gradeOne:'少儿',
          gradeTwo:'初中',
          gradeThr:'高中'
        },

        //  年级搜索下拉框
        custom:''
      }

    },
    methods: {
       // 查询显示所有学员列表
    showStudents(seacheText='',cutom='年级',pageIndex=1){
      this.pageIndex=pageIndex;
      this.searchText =seacheText;
      this.custom =cutom;
        this.$axios.get("/student/list",{
          params:{
              pageIndex:this.pageIndex,
              pageSize:5,
              seachText:this.searchText,
              customs:this.custom
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
      this.showStudents(this.searchText,this.custom,this.pageIndex);
    },

    //  根据条件搜索
    startQuery(){
      //console.log(this.searchText)
      this.pageIndex = 1;
      this.showStudents(this.searchText,this.custom,this.pageIndex);
    },

    //  显示添加学员窗口
    showAddTeacherDialog(){
      this.addDialogFormVisible=true;
    },

    //  添加学员

    addTeacher(student){
      this.$refs.student.validate((valid) =>{
        if (valid) {
          this.$axios.post("/student/add",this.student,{
        params:{
          grade:this.grade
        }
      }).then(ref=>{
        console.log(ref)
        if(ref.data.code==200){
          this.$message({type: 'success', message:"添加成功",  duration:800});
                this.addDialogFormVisible = false;
                //重新加载页面
                this.showStudents()
        }
      })
        }else{
          this.$message({type: 'warning', message:"请填写完整信息",  duration:800});
        }

      })

    },

    //  显示修改学员窗口
    handleEdit(row){

      this.updateDialogFormVisible=true;

      if(row.comment=='0'){
        this.updateStudent.comment='差'
      }else if(row.comment=='1'){
        this.updateStudent.comment='中'
      }else if(row.comment=='2'){
        this.updateStudent.comment='优'
      }else{
        this.updateStudent.comment='无'
      }

      if(row.gender=='0'){
        this.updateStudent.gender=0
      }else if(row.gender=='1'){
        this.updateStudent.gender=1
      }

      this.updateStudent.id=row.id
      this.updateStudent.grade=row.grade
      this.updateStudent.className=row.className
      this.updateStudent.username=row.username
      this.updateStudent.age=row.age
      this.updateStudent.evaluation=row.evaluation
      this.updateStudent.pName=row.pName
      this.updateStudent.pPhone=row.pPhone
      this.updateStudent.address=row.address
      this.updateStudent.email=row.email
      this.updateStudent.phone=row.phone
      this.updateStudent.status=row.status
      this.updateStudent.password=row.password
    },

    //  修改学员
    upStudent(){
            if(this.updateStudent.comment=='差'){
              this.updateStudent.comment='0'
            }else if(this.updateStudent.comment=='中'){
              this.updateStudent.comment='1'
            }else if(this.updateStudent.comment=='优'){
              this.updateStudent.comment='2'
            }
            this.$axios.post("/student/update",this.updateStudent).then(ref=>{
              console.log(ref)
              if(ref.data.code == 200){

                this.$message({type: 'success', message:"修改成功",  duration:800});
                this.updateDialogFormVisible=false
                //重新加载页面
                this.showStudents('',1)
            }
            })
    },

    //  删除学员
    handleDelete(index, row) {
      console.log(index, row);
      this.$axios.get("/student/delete?id="+row.id).then(ref=>{
        if(ref.data.code == 200){
              this.$message({type: 'success', message:"删除成功",  duration:800});
              //重新加载页面
              this.showStudents('',1)
          }
      })
    },

    //
    handleCommand(command){
        console.log(command)
            this.custom = command;
    },

  },
    filters:{
        status(status){
            if(status ==0){return '在读'}
            else if(status ==1){return '休学'}
            else{return '毕业'}
        },
        comment(comment){
            if(comment ==0){return '差'}
            else if(comment ==1){return '中'}
            else if(comment== 2){return '优'}
            else{
              return '无'
            }
        },

    },
    created(){
      this.showStudents();
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
