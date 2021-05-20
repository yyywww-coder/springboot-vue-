<template>
  <div id="div1">
<table style="width:100%" class="myTable">
 <!-- <h1 style="color:green ; font-size:35px">全部讲师</h1> -->
<!-- <div style="width:500px; border:1px solid red;"></div> -->

 <img src="@/assets/images/teacher.png" alt=""  width="120%"/>

<el-row>
  <el-col :span="8" v-for="(item, index) in teacherData" :key="item.id" :offset="index > 0 ? 2 : 0">
    <el-card :body-style="{ padding: '14px' }">
      	<img :src="item.imageUrl" class="image">
      <div style="padding: 14px;">
      		<span>姓名：{{ item.username }}</span>
        <div class="bottom clearfix">
         		<span>教育背景：{{ item.education }}</span><br>
             	<span>级别：{{ item.isFamous =='y'?'资深名师':'高级教师'}}</span>
       
       	<el-button type="text" class="button" @click="goBuy(item.id)">查看详情</el-button>
        </div>
      </div>
    </el-card>
  </el-col>
</el-row>



 <router-view></router-view>

</table>

    
    <div >
     <!-- 分页   默认情况下 每10条   保存当前页(current-page)   改变页码的事件   每页多少条(page-size)
     @current-change改变当前页的事件  changeCurrentPage   内部传了一个当前页的实参-->
     <el-pagination
     :background="true"
     layout="prev, pager, next"
     :total="totalCount"
     :page-size="4"
     :current-page="pageIndex"
     @current-change = "changeCurrentPage"
     >
 </el-pagination>

    </div>
  </div>
</template>
  <script>
export default {
  data() {
    return {
       verificationImg: '',

      totalCount: 0,
      pageIndex: 1,
      teacherData: [{
        id:"",
        username: "",
        education: "",
        isFamous: "",
        imageUrl:""
      }],
    };
  },
  methods: {

    loadTeachers(pageIndex=1) {

      // this.searchText =seacheText;
      // this.pageIndex = pageIndex;
      var token = localStorage.getItem("token");
    	this.$axios.get("/front/teacher/list",{
          params: {
            pageIndex: this.pageIndex,
            pageSize: 4

          },

          headers: { Authorization: token }
        })
        .then(res => {
          console.log(res);
          //获取图片地址
            //  this.verificationImg = window.URL.createObjectURL(res.data.data.list.avatar);
               console.log(this.verificationImg)
          //获取分页数据
          this.teacherData = res.data.data.list;
          // //获取当前页
          // this.pageIndex = res.data.data.current;
          // //获取总记录数
          // this.totalCount = res.data.data.total;
         //获取当前页
          this.pageIndex = res.data.data.pageNum;
          //获取总记录数
          this.totalCount = res.data.data.total;
          console.log(res.data.data.pages);
          console.log( this.totalCount);
        });

    },
      //修改当前页码 触发的事件方法
  changeCurrentPage(curpage) {
    this.pageIndex = curpage;
    this.loadTeachers(this.searchText,this.pageIndex);
  },

  	goBuy(id){
            //  this.$router.push('/home')
			  this.$router.push({path:"/teacheritem/"+id})    // 跳转的详情页面拼接id
			// this.$router.push({name:'newsitem',query:id})
		}


  },
   created() {
      this.loadTeachers();

    },
};
</script>

  <style>
#div1 {
  padding: 0%;
}


nav ul
{
	list-style:none;
	display:inline;
}

nav li
{
	width:200px;
	display:inline-block;
	/* background-color:red; */
}

</style>
