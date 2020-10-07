import Vue from 'vue'
import jobDetail from './jobDetail.vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import footer_cl from '../footer/footer'
import siderbar from "../siderbar/siderbar";
import axios from 'axios'
axios.defaults.baseURL = '/jobDetailApi'
Vue.prototype.$axios = axios // 把axios挂载到vue上，$myAxios这个名称可以自定义
Vue.use(ElementUI)
Vue.prototype.imageBaseUrl = "http://139.159.134.136:10086/"
new Vue({
  el: '#jobDetail',
  render: h=>h(jobDetail),
  components:{footer_cl, siderbar}
})
