import axios from "axios";
export default {
  data() {
    return {
      pageIndex:1,
      totalCount:0,
      searchText: "",
      videoText:"",
      orderData: [
        {
          id: "",
           userid: "",
           username:"",
           videoname:"",
          videoid: "",
          orderTime: "",
          payType: "",
        }
      ],
      //控制对话框是否显示
      addDialogFormVisible: false,
      order: {
        id: "",
        userid: "",
        username:"",
        videoname:"",
       videoid: "",
       orderTime: "",
       payType: "",
      },
      rules: {
      },

      //修改对话框 判断
      dialogEditOrderVisible: false,
      editOrder: {
        id: "",
        userid: "",
        username:"",
        videoname:"",
       videoid: "",
       orderTime: "",
       payType: "",
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
    loadOrder(seacheText = '',videoText='', pageIndex = 1) {
      this.videoText = videoText;

            this.$axios.get("/order/list", {
          params: {
            pageIndex: this.pageIndex,
            pageSize: 4,
            name: this.searchText,
            // video: this.videoText
          },
        })
        .then(res => {
          console.log(res);
          console.log(res.data.data.list);
          console.log(res.data.data.list);
          console.log(res.data.data.current);
          // this.orderData = res.data.data;
          this.orderData = res.data.data.list;
          //获取当前页
          this.pageIndex = res.data.data.pageNum;
          //获取总记录数
          this.totalCount = res.data.data.total;



        });
    },
  //修改当前页码 触发的事件方法
  changeCurrentPage(curpage) {
    this.pageIndex = curpage;
    this.loadOrder(this.searchText,this.pageIndex);
  },


    //查询分页
    startQuery() {
      this.loadOrder(this.searchText);
      // this.loadOrder(this.forma);
    },

    //打开对话框 添加
    showAddOrderDialog() {
      this.addDialogFormVisible = true;
    },


    //添加 确定方法
    addOrder() {
      this.$axios.post("/order/adds",this.order).then(res => {

        if (res.data.code == 200) {
          this.$message({ type: 'success', message: "添加成功", duration: 800 });
          this.addDialogFormVisible = false;

          //重新加载页面
          this.loadOrder('', 1)
        }
        else {
          this.$message({ type: 'warning', message: "添加失败，没有该用户或者视频名", duration: 800 });
        }
      })
    },

    //显示修改对话框
    showEditOrderDialog(row) {
        this.dialogEditOrderVisible = true;
      this.editOrder.id = row.id;
      this.editOrder.username = row.username;
      this.editOrder.videoname = row.videoname;
      this.editOrder.orderTime = row.orderTime;
      // this.editOrder.username = row.user.username;
      console.log("a"+ row.user.username);
      this.editOrder.payType = row.payType;
    },

    //提交修改
    updateOrder() {
      // if (this.editOrder.status) {
      //   this.editOrder.status = 'y'
      // } else {
      //   this.editOrder.status = 'n'
      // }
      this.$axios.post("/order/update", this.editOrder
      // axios.post("http://localhost:8081/order/update", this.editOrder, {
        // axios.post("http://192.168.246.129:8080/order/update", this.editOrder, {
       ).then(res => {

        if (res.data.code == 200) {
          this.$message({ type: 'success', message: "修改成功", duration: 800 });
          this.dialogEditOrderVisible = false;

          //重新加载页面
          this.loadOrder('', 1)

        } else {
          this.$message({ type: 'warning', message: "修改失败，没有要修改成的用户或视频", duration: 800 });
        }
      })
    },

    //删除
    delOrder(id) {
      console.log('触发删除');
      this.$axios.post("/order/delete?id=" + id, {

        headers: {
          Authorization: localStorage.getItem('token')
        }
      }).then(res => {
        if (res.data.code == 200) {
          this.$message({ type: 'success', message: "删除成功", duration: 800 });
          //重新加载页面
          this.loadOrder('', 1)
        } else {
          this.$message({ type: 'warning', message: "没有删除权限", duration: 800 });
        }
      })
    }
    ,
    //添加弹窗显示
    showOrderDialog() {

       this.addDialogFormVisible = true;
    }

  },
  created() {
    this.loadOrder();

  }

}
