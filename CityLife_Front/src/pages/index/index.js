import Vue from 'vue'
import index from './index.vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import axios from 'axios'
Vue.prototype.$axios = axios // 把axios挂载到vue上，$myAxios这个名称可以自定义
Vue.prototype.baseImageUrl = "http://139.159.134.136:10086/"
Vue.use(ElementUI)
new Vue({
  el: '#index',
  render: h=>h(index)
})
