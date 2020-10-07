import Vue from 'vue'
import login from './login.vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import axios from 'axios'
axios.defaults.baseURL = '/loginApi'
Vue.prototype.$axios = axios // 把axios挂载到vue上，$myAxios这个名称可以自定义
Vue.use(ElementUI)
new Vue({
  el: '#login',
  render: h=>h(login)
})
