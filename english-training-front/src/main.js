// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import './assets/css/commons.css'
import './assets/font_ali/iconfont.css';
import SlideVerify from 'vue-monoplasty-slide-verify';

Vue.use(SlideVerify);
Vue.prototype.$axios = axios
axios.defaults.baseURL = "http://localhost:8899"

axios.interceptors.request.use(function(config) {
        config.headers.Authorization = localStorage.getItem("token")
        return config
    },
    function(error) {
        return Promise.reject(error)
    }
)
Vue.config.productionTip = false


Vue.use(ElementUI)



new Vue({
    el: '#app',
    router,
    components: { App },
    template: '<App/>'
})
