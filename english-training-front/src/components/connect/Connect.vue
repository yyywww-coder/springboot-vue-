<template>
<div id="div1">
  <baidu-map class="bm-view"  :center="center" :zoom="zoom"  @ready="handler"  style="float:left">
       <!-- <bm-marker :position="{lng: 119.904, lat: 31.915}" :dragging="true" animation="BMAP_ANIMATION_BOUNCE">
      <bm-label content="蜗牛学院" :labelStyle="{color: 'red', fontSize : '12px'}" :offset="{width: -35, height: 30}"/>
    </bm-marker> -->
      <bm-marker :position="{lng: 114.421227, lat:30.454784}" :dragging="true" animation="BMAP_ANIMATION_BOUNCE">
      <bm-label content="武汉海培英语滨湖路总校" :labelStyle="{color: 'red', fontSize : '12px'}" :offset="{width: -35, height: 30}"/>
    </bm-marker>
  </baidu-map>
<div id="div2">
<p style="font-size:15px;color:pink;" >
    <br>
    免费试听：400-660-6615
    <br><br>
    滨湖路总校：
    TEL: 63088766
    ADD:  武汉滨湖路18号
    <!-- <br><br>
    巴南校区
    TEL: 62868806
    ADD: 重庆巴南区李家沱恒大城一期
    <br><br>
    美利山校区
    TEL: 63088766
    ADD: 重庆渝北区鸳鸯美利山
    <br><br>
    金渝校区
    TEL: 62868806
    ADD: 重庆渝北金渝小学对面
    <br> -->
  
    <img src="@/assets/images/二维码.png" alt="" /> <br>
     扫描微信公众号，惊喜等着您！
    <br><br>
    网站：
<a href="www.happyenglish.com ">www.happyenglish.com </a>    
</p>
</div>
</div>
</template>

<script>
export default {
  data () {
    return {
      center: {lng:114.421227, lat: 30.454784},
      zoom: 5
    }
  },
  methods: {
    handler ({BMap, map}) {
      console.log(BMap, map)
      this.center.lng =114.421227
      this.center.lat = 30.454784
      this.zoom = 14
    }
  }
}
</script>

<style scoped>
#div1{ padding: 3%;}
 #div2{ padding: 3%;}
p
 {
     margin-left: 120px;
     padding: 0.5cm 2.5cm}

.bm-view {
  width: 50%;
  height: 550px;
}
</style>