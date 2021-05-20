import Vue from 'vue'
import Router from 'vue-router'
import Login from "../components/login/Login.vue";
import Home from "../components/home/Home.vue";
import User from "../components/user/User.vue";
import Teacher from "../components/teacher/Teacher.vue";
import student from "../components/student/Student.vue";
import link from "../components/link/Link.vue";
import order from "../components/order/order.vue";
import survey from "../components/survey/survey.vue"
import Banner from "../components/banner/Banner.vue";
import SavrBanner from  "../components/banner/SaveBanner.vue"
import Video from "../components/video/Video.vue"
import AddVideo from "../components/video/AddVideo.vue";
import Arrange from "../components/arrange/Arrange.vue";
import Echarts from "../components/echarts/Echarts.vue";
import Exam from "../components/exam/Exam.vue";
import addExam from "../components/exam/addExam.vue";
import QuestionBank from "../components/questionBank/QuestionBank.vue";
import AddQuestion from "../components/questionBank/AddQuestion.vue";
import AddAnswerChildren from "../components/questionBank/AddAnswerChildren.vue";
import AllStudentScore from '../components/score/AllStudentGrade.vue'
import grade from '../components/echarts/grade.vue'
import PartScore from '../components/score/PartScore.vue'
import ScorePart from '../components/echarts/ScorePart.vue'
import news from "../components/news/news.vue";
import Welcome from "../components/welcome/Welcome.vue";


Vue.use(Router)

export default new Router({
    routes: [
        { path: '/', redirect: '/login' },
        { path: '/login', component: Login },
        {
            path: '/home',
            component: Home,
            children: [
              {path:'/',component:Welcome},
                { path: '/teacher', component: Teacher },
                { path: '/user', component: User },
                // { path: '/content', component: Content },
                { path: '/student', component: student },
                { path: '/link', component: link },
                { path: '/order', component: order },
                { path: '/survey', component: survey },
              {path:'/banner',component:Banner},
              {path:'/addbanner',component:SavrBanner},
              {path:'/video',component:Video},
              {path:'/addvideo',component:AddVideo},
                { path: '/comment', component: survey },
              {path:'/banner',component:Banner},
                { path: '/arrange', component: Arrange },
                { path: '/echarts', component: Echarts },
              {path:'/exam',component:Exam},
              {path:'/addexam',component:addExam},
              {path:'/questionBank',component:QuestionBank},
              {path:'/addquestion',component:AddQuestion},
              {path:'/addAnswerChildren',component:AddAnswerChildren},
              {path: '/score', component:AllStudentScore},
              {path: '/grade', component:grade},
              {path: '/partScore', component: PartScore},
              {path: '/ScorePart', component: ScorePart},
              { path: '/news', component: news }

            ]
        }



    ]
})
