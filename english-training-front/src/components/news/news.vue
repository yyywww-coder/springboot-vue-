<template>
    <div id="newsDiv">
			<el-tabs type="border-card">

				<el-tab-pane>
					<span class="menutext" slot="label" @click="showParent()"><i class="iconfont icon-xiaoxue3"></i>父母讲堂</span>
						<!-- 教育资讯卡片 -->
						<el-card class="parent">
								<div class="container">
									<div class="title">父母讲堂</div>
									<p class="dlo">不忘初心，共创未来</p>
										<div>
											<img src="../../assets/images/news/003.png" class="img-responsive" alt="Responsive image" />
										</div>
										<div class="listnew">
										<div class="thenew" >最新动态</div>
											<ul style="list-style-type:none;">
												<li class="clearfix" v-for="(item, index) in newsData" :key="item.id" :offset="index > 0 ? 2 : 0">
													
													<a href="#" @click.prevent="goBuy(item.id)" target="_blank">{{ item.title }}</a>
													<span>{{item.day}}</span>
												</li>
												<!-- <li class="clearfix" v-for="(item, index) in newsData" :key="item.id" :offset="index > 0 ? 2 : 0">
													
													<a href="#" @click.prevent="goBuy(item.id)" target="_blank">{{ item.title }}</a>
													<span>{{item.day}}</span>
												</li>
												<li class="clearfix" v-for="(item, index) in newsData" :key="item.id" :offset="index > 0 ? 2 : 0">
													
													<a href="#" @click.prevent="goBuy(item.id)" target="_blank">{{ item.title }}</a>
													<span>{{item.day}}</span>
												</li>
												<li class="clearfix" v-for="(item, index) in newsData"   :key="item.id" :offset="index > 0 ? 2 : 0">
													
													<a href="#" @click.prevent="goBuy(item.id)" target="_blank">{{ item.title }}</a>
													<span>{{item.day}}</span>
												</li> -->
												<br>
												<br>
												<!-- 分页 -->
												<el-pagination
													:background="true"
													layout="prev, pager, next"
													:total="totalCount"
													:page-size="6"
													:current-page="pageIndex"
													@current-change = "changeCurrentPage"  
													>
												</el-pagination>
											</ul>
										</div>
									</div>
						</el-card>
						
				</el-tab-pane>

				<!-- 品牌新闻 -->
				<el-tab-pane>
					<span class="menutext" @click="showActive()" slot="label"><i class="iconfont icon-chuzhong"></i>活动信息</span>
						<el-card class="parent">
								<div class="container">
									<div class="title2">海培动态</div>
									<p class="dlo">不忘初心，共创未来</p>
										<div>
											<img src="../../assets/images/news/001.jpg" class="img-responsive" alt="Responsive image" />
										</div>
										<div class="listnew">
										<div class="thenew" >最新动态</div>
											<ul style="list-style-type:none;">
												<li class="clearfix" v-for="(item, index) in newsData" :key="item.id" :offset="index > 0 ? 2 : 0">
													
													<a href="#" @click.prevent="goBuy(item.id)" target="_blank">{{ item.title }}</a>
													<span>{{item.day}}</span>
												</li>
												<!-- <li class="clearfix" v-for="(item, index) in newsData" :key="item.id" :offset="index > 0 ? 2 : 0">
													
													<a href="#" @click.prevent="goBuy(item.id)" target="_blank">{{ item.title }}</a>
													<span>{{item.day}}</span>
												</li>
												<li class="clearfix" v-for="(item, index) in newsData" :key="item.id" :offset="index > 0 ? 2 : 0">
													
													<a href="#" @click.prevent="goBuy(item.id)" target="_blank">{{ item.title }}</a>
													<span>{{item.day}}</span>
												</li> -->
												<li class="clearfix" v-for="(item, index) in newsData" :key="item.id" :offset="index > 0 ? 2 : 0">
													
													<a href="#" @click.prevent="goBuy(item.id)" target="_blank">{{ item.title }}</a>
													<span>{{item.day}}</span>
												</li>
												<br>
												<br>
												<!-- 分页 -->
												<el-pagination
													:background="true"
													layout="prev, pager, next"
													:total="totalCount"
													:page-size="6"
													:current-page="pageIndex"
													@current-change = "changeCurrentPage"  
													>
												</el-pagination>
											</ul>
										</div>
									</div>
						</el-card>
				</el-tab-pane>
				
			</el-tabs>

			
	</div>
</template>

<script>
export default {
    data(){
		return{
			// 下标
			status:0,
			//  总数
			totalCount:0,
			//  当前页
			pageIndex:1,
			// 视频表		
			newsData:{
				total:1,
				items:{
					title:'中国足球队成功进入世界杯总决赛',
					image:'../../assets/images/default.jpg',
					day:'2020.12.8 12:20',
				}
			},
		}
	},
	methods:{

  //日期格式化
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

		//  改变当前页触发
		changeCurrentPage(val){
			this.pageIndex=val
			this.showParent(this.pageIndex,this.sort);
		},

		//  查找父母讲堂信息
		showParent(pageIndex=1){
			this.pageIndex=pageIndex;
			this.log=0;	
			this.$axios.get("/front/news/list1",
			{
				params:{
					pageIndex:this.pageIndex,
					pageSize:6,
					// log:this.log,
				}
			}).then(ref=>{
				console.log(ref);
				this.totalCount=ref.data.data.total;
				this.newsData=ref.data.data.list
				this.pageIndex=ref.data.data.pageNum

			})
		},


		//  查找所有活动信息
	showActive(pageIndex=1){
			this.pageIndex=pageIndex;
			this.log=0;	
			this.$axios.get("/front/news/list2",
			{
				params:{
					pageIndex:this.pageIndex,
					pageSize:6,
					// log:this.log,
				}
			}).then(ref=>{
				console.log(ref);
				this.totalCount=ref.data.data.total;
				this.newsData=ref.data.data.list
				this.pageIndex=ref.data.data.pageNum

			})
		},
		goBuy(id){
            //  this.$router.push('/home')
			  this.$router.push({path:"/newsitem/"+id})    // 跳转的详情页面拼接id
			// this.$router.push({name:'newsitem',query:id})
		}
	},
	
        created(){
		this.showParent();
	}
    }
</script>

<style scoped>
 .parent{
	background: url('../../assets/images/news/ba6.jpg');
	/* background: url('../../assets/images/news/bg2.jpg'); */
	
	
}
.hpNew {
	background: url('../../assets/images/news/bg2.jpg');
}

.img-responsive {
	 display: block; max-width: 100%; height: auto; 
}
.title2{
	 margin: 0 auto;
    background: url('../../assets/images/news/bg_title_blue.png') no-repeat top center;
    background-size: 100% 66px;
    max-width: 100%;
    width: 459px;
    margin: 5% auto 0 auto;
    line-height: 60px;
    z-index: 1;
    height: 66px;
    text-align: center;
    font-size: 24px;
    font-family: Microsoft YaHei;
    color: #fff;
    font-weight: bold;
	margin-top: -10px;
}
.title{
    margin: 0 auto;
    background: url('../../assets/images/news/bg_titel_Purple.png') no-repeat top center;
    background-size: 100% 66px;
    max-width: 100%;
    width: 459px;
    margin: 5% auto 0 auto;
    line-height: 60px;
    z-index: 1;
    height: 66px;
    text-align: center;
    font-size: 24px;
    font-family: Microsoft YaHei;
    color: #fff;
    font-weight: bold;
	margin-top: -10px;
	
}
.dlo {
    font-size: 18px;
    color: #4A4A4A;
    font-family: 'Microsoft YaHei';
    text-align: center;
    padding-top: 12.5px;
}
.dlo2{
	font-size: 18px;
    color: #4A4A4A;
    font-family: 'Microsoft YaHei';
    text-align: center;
    padding-top: 12.5px;
}
.container img{
	width: 400px;
	height: 400px;
	float:left;
}
.containerNew img{
	width: 400px;
	height: 400px;
	float:left;
}

.thenew{
	
    font-size: 24px;
    font-family: Microsoft YaHei;
    font-weight: bold;
    color: #4A4A4A;
}
.thenew2{
	font-size: 24px;
    font-family: Microsoft YaHei;
    font-weight: bold;
    color: #4A4A4A;
}
.listnew{
	float:left;
	margin-left: 100px;
	font-size: 20px;
}
.listnew2{
	float:left;
	margin-left: 100px;
	font-size: 20px;
}
.listnew span{
	margin-left: 50px;
}
.listnew2 span{
	margin-left: 50px;
}
</style>