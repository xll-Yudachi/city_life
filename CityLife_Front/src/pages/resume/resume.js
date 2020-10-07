import Vue from 'vue'
import resume from './resume.vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import axios from 'axios'
Vue.prototype.$axios = axios // 把axios挂载到vue上，$myAxios这个名称可以自定义
import VueAreaLinkage from 'vue-area-linkage'
Vue.prototype.baseImageUrl = "http://139.159.134.136:10086/"
Vue.use(ElementUI)
Vue.use(VueAreaLinkage)
new Vue({
  el: '#resume',
  render: h=>h(resume)
})
