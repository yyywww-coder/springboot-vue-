import Vue from 'vue'
import Router from 'vue-router'

import Home from "../components/home/Home.vue";
import user from "../components/user/User.vue"
import teacher from "../components/Teacher/teacher.vue";
import question from "../components/Question/question.vue";
import aboutUs from "../components/aboutUs/About.vue";
import video from "../components/englishvideo/Video.vue"
import Index from "../components/student/Index.vue"
import MyExam from "../components/student/MyExam.vue"
import ExamMsg from "../components/student/ExamMsg.vue"
import Answer from "../components/student/Answer.vue"
import StudentScore from "../components/student/StudentScore.vue"
import StartExam from "../components/student/StartExam.vue"
import ScoreTable from "../components/student/ScoreTable.vue"
import Choose from "../components/choose/Choose.vue";
import Connect from "../components/connect/Connect.vue";
import book from "../components/book/book.vue";
import news from "../components/news/news.vue";
import newsitem from "../components/news/newsitem.vue";
import teacheritem from "../components/Teacher/teacheritem.vue";


import BaiduMap from 'vue-baidu-map'

Vue.use(BaiduMap, {
  // ak 是在百度地图开发者平台申请的密钥 详见 http://lbsyun.baidu.com/apiconsole/key */
  ak: '2COzFaICuIyVj7V3VetKfmdRVnX8BhVr'
})


Vue.use(Router)

const router = new Router({
    routes: [{path: '/', redirect: '/home'},
      {path: '/home', component: Home},
      {path: '/video', component: video},
      {path: '/user', component: user},
        {path: '/teacher',component: teacher},
        {path: '/question',component: question},
      {path: '/aboutUs', component: aboutUs},
      {path: '/index',component: Index},
      {path: '/student',component: Index,
        children: [{path: '/', component: MyExam},
          {path: '/examMsg',component: ExamMsg},
          {path: '/studentScore', component: StudentScore},
          {path: '/startExam', component: StartExam},
          {path: '/scoreTable', component: ScoreTable}]
      },
      {path: '/answer', component: Answer},
        {
          path: '/news',
          component: news,
        },
        {
          path: '/choose',
          component: Choose,
        },
        {
          path: '/connect',
          component: Connect,
        },
        {
          path: '/book',
          component: book,
        },
        {
          path: '/newsitem/:id',   // 记得此处拼接id
          name: 'newsitem',
           meta:{
             title:'课程详情页'
           },
           component: newsitem,
          },
          {
            path: '/teacheritem/:id',   // 记得此处拼接id
            name: 'teacheritem',
             meta:{
               title:'教师详情页'
             },
             component: teacheritem,
            }
    ]

})

// router.beforeEach((to, from, next) => {
//     if (to.path === '/home') return next()
//         // 获得token字符串
//     const token = window.localStorage.getItem("token");
//     if (!token)
//         return next('/')
//     next()
// })



// router.beforeEach((to, from, next) => {
//     if (to.path === '/home') return next()
//         // 获得token字符串
//     const token = window.localStorage.getItem("token");
//     if (!token)
//         return next('/')
//     next()
// })


export default router
