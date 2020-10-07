import Vue from 'vue'

import 'normalize.css/normalize.css' // A modern alternative to CSS resets

import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import locale from 'element-ui/lib/locale/lang/zh-CN' // lang i18n
import '@/styles/index.scss' // global css
import axios from 'axios'
import App from './App'
import store from './store'
import router from './router'

// 省市区联动组件
import VueAreaLinkage from 'vue-area-linkage';
import 'vue-area-linkage/dist/index.css'
Vue.use(VueAreaLinkage)

import '@/icons' // icon
import '@/permission' // permission control

/**
 * If you don't want to use mock-server
 * you want to use MockJs for mock api
 * you can execute: mockXHR()
 *
 * Currently MockJs will be used in the production environment,
 * please remove it before going online! ! !
 */
import { mockXHR } from '../mock'
if (process.env.NODE_ENV === 'production') {
  mockXHR()
}

// set ElementUI lang to EN
Vue.use(ElementUI, { locale })
Vue.prototype.$axios = axios
Vue.prototype.baseImageUrl = 'http://139.159.134.136:10086/'
Vue.config.productionTip = false
// 引入echarts
import echarts from 'echarts'
Vue.prototype.$echarts = echarts
new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App)
})
