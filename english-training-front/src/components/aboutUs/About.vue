<template>
  <div id="about">
    <div>
      <img src="../../assets/images/about/abouthead.jpg" alt="" />
    </div>
    <el-card>
      <div>
            <div class="info">
              <h4>海培英语简介</h4>
              <b>
                <p style="text-indent:2em">海培英语教育有限公司（简称海培英语）成立于1994年，是中国基础教育领域的知名品牌，主要开展教育培训、教育出版、加盟等多项业务.
                <span>在深厚的品牌积淀中，我们先后在全国开设多家直营分校和加盟机构，累计服务学员超过500万人次，深得学员、家长和社会的高度认可。<br></span>

                <span>海培英语依托多年积淀的文化底蕴和优质的教育资源，积极开拓教育服务全新模式，以教育教学研究、教师培训为方向，打造了一批具有竞争力的教学研发团队，</span>
                针对5-18岁青少年儿童研发了丰富的教学产品。</p>
                <p style="text-indent:2em">目前开设中小学英语、语文、数学，中学理科，综合素质全能课程、素质教育，国内外游学，冬夏令营等千余门优质课程。</p>
              </b>
            </div>
            <el-card style="background-color: #f9f9fb;">
              <div class="hpconcept">
                <h4>海培理念</h4>
                <li>
                  <p>学生至上<br>(CUSTOMER FOCUS)</p>
                  <img src="../../assets/images/about/working_one.jpg" alt="" />

                  <span></span>
                </li>
                <li>
                  <p>持续创新<br>(INNOVATION)</p>
                  <img src="../../assets/images/about/working_two.jpg" alt="" />

                  <span></span>
                </li>
                <li>
                  <p>强执行力<br>(EXECUTION)</p>
                  <img src="../../assets/images/about/working_three.jpg" alt="" />

                  <span></span>
                </li>
                <li>
                  <p>团队合作<br>(TEAMWORK)</p>
                  <img src="../../assets/images/about/working_four.jpg" alt="" />

                  <span></span>
                </li>
              </div>
            </el-card>

            <div class="abuat_bg bg">
              <div class="w1140">
                <div class="mission">
                  <div class="mission_time">
                    <i class="kong"></i>
                    <div>
                      <p class="purpose">我们的办学宗旨</p>
                      <span></span>
                      <p class="aboute_jiaoyu">做感动中国的教育</p>
                    </div>
                  </div>
                  <div class="mission_time">
                    <i class="kong"></i>
                    <div>
                      <p class="purpose">我们的使命</p>
                      <span></span>
                      <p class="aboute_jiaoyu">学习力成就未来</p>
                    </div>
                  </div>
                  <div class="mission_time">
                    <i class="kong"></i>
                    <div style="padding-top:20px;">
                      <p class="purpose">我们的愿景</p>
                      <span></span>
                      <p class="aboute_jiaoyu">成为最受信赖的提升<br>学习力的第三课堂</p>
                    </div>
                  </div>
                  <div class="mission_time">
                    <i class="kong"></i>
                    <div>
                      <p class="purpose">我们的精神</p>
                      <span></span>
                      <p class="aboute_jiaoyu">肯学肯干 全力以赴</p>
                    </div>
                  </div>
                  <div class="mission_time">
                    <i class="kong"></i>
                    <div style="padding-top:20px;">
                      <p class="purpose">我们的学习力原则</p>
                      <span></span>
                      <p class="aboute_jiaoyu">以学为主 以教为辅<br>主动学习 多元互动</p>
                    </div>
                  </div>

                </div>
              </div>
            </div>

            <div class="w1140">
              <div class="h40"></div>
              <div class="about_text">海培教育大事记</div>
              <div class="h40"></div>
              <div class="h10"></div>
              <div class="h10"></div>
              <el-carousel :interval="5000" arrow="always" style="margin-bottom:50px;">
                <el-carousel-item v-for="item in images" :key="item.index">
                 <img :src="item.src" style="height:100%;width:100%;" alt="图片丢失了" :title="item.title" />
                </el-carousel-item>
              </el-carousel>
            </div>
      </div>
    </el-card>
  </div>
</template>

<script>
  export default {
    name: "About",
    data(){
      return{
        tabPosition:'top',
        activities: [{
          content: '支持使用图标',
          timestamp: '2018-04-12 20:46',
          size: 'large',
          type: 'primary',
          icon: 'el-icon-more'
        }, {
          content: '支持自定义颜色',
          timestamp: '2018-04-03 20:46',
          color: '#0bbd87'
        }, {
          content: '支持自定义尺寸',
          timestamp: '2018-04-03 20:46',
          size: 'large'
        }, {
          content: '默认样式的节点',
          timestamp: '2018-04-03 20:46'
        }],
        images:[
          {
          name: "lj",
          src: require("@/assets/images/about/dsj_1.jpg"),
          title: "first.png"
          },
          {
            name: "logo",
            src: require("@/assets/images/about/dsj_2.jpg"),
            title: "secoud.png"
          }
        ]
      }
    }
  }
</script>

<style>
/*  发展历程 */
.h40 {
  height: 40px;
  clear: both;
  overflow: hidden;
}
.about_text{font-size:36px;text-align:center;color:#4c4c4c;}
.h10 {
  height: 10px;
  clear: both;
  overflow: hidden;
}
#about .el-carousel__item h3 {
    color: #475669;
    font-size: 18px;
    opacity: 0.75;
    line-height: 300px;
    margin: 0;
  }

#about .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;

  }

#about .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
  }


/*  海培使命 */
.abuat_bg{
  background-image: url("../../assets/images/about/abuat_bg.jpg");
  height: 200px;
}
.mission_time span{
  height: 3px;
}
.mission_time{display:inline-block;margin-right:5%;}
.mission_time div{display:inline-block;vertical-align:middle;}
.mission_time span{display:inline-block;width:40px;height:4px;background:white;}
.mission_time:nth-last-child(1){margin-right:0;}
.purpose{font-size:24px;font-weight:bold;line-height:48px;height:48px;}
.purpose {
  font-size: 24px;
  font-weight: bold;
  line-height: 53px;
  height: 38px;
}
.aboute_jiaoyu{
  margin-top: 11px;
}
.aboute_jiaoyu{font-size:16px;margin-top:18px;}
.kong{width:0.1px;height:100%;display:inline-block;line-height:100%;vertical-align:middle;}
.mission{text-align:center;color:white;}
.w1140 {
  width: 1140px;
  height: auto;
  margin: 0 auto;
}



/*  海培理念 */
.hpconcept{
  list-style: none;
  margin-left: 300px;

  height: 580px;
}
.hpconcept img{
  float: left;
}
.hpconcept li{
  margin-left: 50px;
}

.hpconcept h4{
  font-size: 25px;
  margin-left: 36%;
  margin-top: 50px;

}

#about .el-card__body {
    padding: 0px;
}
#about .el-tabs__item {

    padding: 40px;
    height: 120px;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
    line-height: 40px;
    display: inline-block;
    list-style: none;
    font-size: 28px;
    font-weight: 500;
    color: #303133;
    position: relative;
}

/*  个人简介 */
.info{
  margin-left: 14%;
  width: 76%;
  margin-top: 50px;
  margin-bottom: 100px;
}
.info h4{
  font-size: 30px;
  font-weight: 600;
  margin-left: 40%;
  color: #0000ff;
  margin-bottom: 50px;
}
.info p{
  font-size: 18px;

}

</style>
