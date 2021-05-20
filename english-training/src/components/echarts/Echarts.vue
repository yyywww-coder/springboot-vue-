<template>
  <div class="Echarts">
    <div id="main" style="width: 600px;height:400px;"></div>
  </div>
</template>

<script>
export default {
  name: 'Echarts',
  methods:{
	  myEcharts(){
		  // 基于准备好的dom，初始化echarts实例
		  var myChart = this.$echarts.init(document.getElementById('main'));
        this.$axios.get("student/num").then(res=>{
          console.log(res);
          //console.log(res.data.data.list[1].grade);
          myChart.hideLoading();
          var data = res.data;
          // 指定图表的配置项和数据
		  myChart.setOption({
			  title: {
                text: '线下学习人数'
            },
			  legend: {},
    tooltip: {},
    xAxis: {data:data.data.list},
    yAxis: {},
    series:[{
      type:'bar',
      data:data.data.list2
    }],
		  });
        })
		 
		  }
  },
  mounted() {
  	this.myEcharts();
  },
}
</script>

<style>

</style>
