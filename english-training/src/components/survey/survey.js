import axios from "axios";
export default {
  data() {
    return {
      pageIndex:1,
      totalCount:0,
      searchText: "",
      surveyData: [
        {
          id: "",
          sremarks: "",
          tremarks: "",
          suggestions: "",
         
        }
      ],
      //控制对话框是否显示
      addDialogFormVisible: false,
      survey: {
        id: "",
        sremarks: "",
        
        tremarks: "",
        suggestions: "",
      },
      rules: {
      },

      //修改对话框 判断
      dialogEditSurveyVisible: false,
      editSurvey: {
        id: "",
        sremarks: "",
        
        tremarks: "",
        suggestions: "",
      },
    }
  },

  methods: {
  //   //日期格式化
    formatDate:function(row, column){
      let data = row[column.property]
      if(data == null) {
        return null
      }
      let date = new Date(data);
    var o = { 
        "M+" : date.getMonth()+1,                 //月份 
        "d+" : date.getDate(),                    //日 
        "h+" : date.getHours(),                   //小时 
        "m+" : date.getMinutes(),                 //分 
        "s+" : date.getSeconds(),                 //秒 
        "q+" : Math.floor((date.getMonth()+3)/3), //季度 
        "S"  : date.getMilliseconds()             //毫秒 
    }; 
   var fmt = "yyyy-MM-dd hh:mm:ss";
  if(/(y+)/.test(fmt)) {
            fmt=fmt.replace(RegExp.$1, (date.getFullYear()+"").substr(4 - RegExp.$1.length)); 
    }
     for(var k in o) {
        if(new RegExp("("+ k +")").test(fmt)){
             fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
         }
     }
      return fmt ;
    },
    //携带token 自定义请求头
    loadSurvey(seacheText = '', pageIndex = 1) {
      this.searchText = seacheText
      var token = localStorage.getItem("token");
      this.$axios.get("/survey/list", {
      // axios
      //   .get("http://localhost:8081/survey/list", {
          // .get("http://192.168.246.129:8080/survey/list", {

          params: {
            pageIndex: this.pageIndex,
            pageSize: 4,
            name: this.searchText
          },
          headers: { Authorization: token }
        })
        .then(res => {
          console.log(res);
          //获取当前页
          this.pageIndex = res.data.data.pageNum;
          //获取总记录数
          this.totalCount = res.data.data.total;
          console.log(res.data.data.pages);
          console.log( this.totalCount);
          this.surveyData = res.data.data.list;
          // console.log(res.data.data.user);

        });
    },
  //修改当前页码 触发的事件方法
  changeCurrentPage(curpage) {
    this.pageIndex = curpage;
    this.loadSurvey(this.searchText,this.pageIndex);
  },


    //查询分页
    startQuery() {
      this.pageIndex = 1;
      this.loadSurvey(this.searchText);
      // this.loadSurvey(this.forma);
    },

    //打开对话框 添加
    showAddSurveyDialog() {
      this.addDialogFormVisible = true;
    },


    //添加 确定方法
    addSurvey() {
      this.$axios.post("/survey/adds",this.survey,  {
        // axios.post("http://localhost:8081/survey/adds", this.survey, {
      // axios.post("http://192.168.246.129:8080/survey/add", this.survey, {
        headers: {
          Authorization: localStorage.getItem('token')
        }
      }).then(res => {

        if (res.data.code == 200) {
          this.$message({ type: 'success', message: "添加成功", duration: 800 });
          this.addDialogFormVisible = false;

          //重新加载页面
          this.loadSurvey('', 1)
        }
        else {
          this.$message({ type: 'warning', message: "没有添加权限", duration: 800 });
        }
      })
    },

    //显示修改对话框 
    showEditSurveyDialog(row) {
        this.dialogEditSurveyVisible = true;
      this.editSurvey.id = row.id;
      this.editSurvey.sremarks = row.sremarks;
      this.editSurvey.tremarks = row.tremarks;
      this.editSurvey.suggestions = row.suggestions;
    },

    //提交修改
    updateSurvey() {
      this.$axios.post("/survey/update",this.editSurvey,  {
      // axios.post("http://localhost:8081/survey/update", this.editSurvey, {
        // axios.post("http://192.168.246.129:8080/survey/update", this.editSurvey, {
        headers: {
          Authorization: localStorage.getItem('token')
        }
      }).then(res => {
        if (res.data.code == 200) {
          this.$message({ type: 'success', message: "修改成功", duration: 800 });
          this.dialogEditSurveyVisible = false;

          //重新加载页面
          this.loadSurvey('', 1)

        } else {
          this.$message({ type: 'warning', message: "没有修改权限", duration: 800 });
        }
      })
    },

    //删除
    delSurvey(id) {
      console.log('触发删除');
      this.$axios.post("/survey/delete?id=" + id, {
     
        headers: {
          Authorization: localStorage.getItem('token')
        }
      }).then(res => {

        if (res.data.code == 200) {
          this.$message({ type: 'success', message: "删除成功", duration: 800 });
          //重新加载页面
          this.loadSurvey('', 1)
        } else {
          this.$message({ type: 'warning', message: "没有删除权限", duration: 800 });
        }
      })
    }
    ,
    //添加弹窗显示
    showSurveyDialog() {
     
       this.addDialogFormVisible = true;
    }

  },
  created() {
    this.loadSurvey();

  }

}