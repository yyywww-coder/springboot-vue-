<template>
  <div id="div3">
    
	  <h2 id="title" style="font-size:15px;color:#FF5100;">{{teacherData.title}}</h2>
	<img :src="teacherData.imageUrl" class="image"  >
	  <span style="font-size:15px;color:#FF5100;">{{teacherData.username}}</span> <br>
  <span style="font-size:15px;color:#FF5100;">{{teacherData.education}}</span> <br>
    <span style="font-size:15px;color:#FF5100;">{{ teacherData.isFamous =='y'?'资深名师':'高级教师'}}</span>
      <span style="font-size:15px;color:#FF5100;">{{teacherData.cotent}}</span>



       
       	<!-- <el-button type="text" class="button" @click="goBuy(item.id)">查看详情</el-button> -->
        </div>
      </div>
    </el-card>
	  </div>
</template>

<script>
export default {
  data() {
    return {
      id: this.$route.params.id, //这样我们的id就拿到了然后在接口处拼接
      teacherData: {
         id:"",
        username: "",
        education: "",
        isFamous: "",
        imageUrl:""
      },
    };
  },

  created() {
    let id = this.id;
    this.$axios
      .get("/front/teacher/item", {
        params: {
          id: id,
        },
      })
      .then((ref) => {
        console.log(ref);
        this.totalCount = ref.data.data.total;
        this.teacherData = ref.data.data;
        this.pageIndex = ref.data.data.pageNum;
      });
  },
};
</script>

<style scoped>
@import "../../assets/css/allCss/global";
@import "../../assets/css/allCss/iconfont";
@import "../../assets/css/allCss/reset";
@import "../../assets/css/allCss/sign";
@import "../../assets/css/allCss/theme";
@import "../../assets/css/allCss/web";

#title{
	text-align: center;
	font-style: 
}



#div3 {
  width: 80%;
  margin-left: 200px;
  height: 600px;
}
#span {
  padding: 0;
  float: right;
  color: red;
}
h2 {
  margin-top: 15px;
}
.el-tabs {
  margin-top: 20px;
}
.el-card {
  margin-bottom: 20px;
}
.el-row {
  margin-top: 10px;
}
.el-col {
  transition: transform 0.25s ease;
  /* float: left; */
  /* width: 200px;
		height: 200px; */
  /* line-height: 200px;  */

  /* margin: 10px;  */
  /* background-color: #00b5e1; */
  list-style: none;
}
.el-col :hover {
  transform: scale(1.05, 1.05);
  /* box-shadow: 0 0 10px #0000ff; */
  cursor: pointer;
  /* text-align: center; */
}
.menutext {
  font-size: 25px;
}
.time {
  font-size: 13px;
  color: #999;
}

.bottom {
  margin-top: 13px;
  line-height: 12px;
}
.button {
  padding: 0;
  float: right;
}

.image {
  width: 20%;
  height: 300px;
  display: block;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both;
}
</style>