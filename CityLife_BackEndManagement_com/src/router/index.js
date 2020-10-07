import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '@/layout'

/**
 * Note: sub-menu only appear when route children.length >= 1
 * Detail see: https://panjiachen.github.io/vue-element-admin-site/guide/essentials/router-and-nav.html
 *
 * hidden: true                   if set true, item will not show in the sidebar(default is false)
 * alwaysShow: true               if set true, will always show the root menu
 *                                if not set alwaysShow, when item has more than one children route,
 *                                it will becomes nested mode, otherwise not show the root menu
 * redirect: noRedirect           if set noRedirect will no redirect in the breadcrumb
 * name:'router-name'             the name is used by <keep-alive> (must set!!!)
 * meta : {
    roles: ['admin','editor']    control the page roles (you can set multiple roles)
    title: 'title'               the name show in sidebar and breadcrumb (recommend set)
    icon: 'svg-name'             the icon show in the sidebar
    breadcrumb: false            if set false, the item will hidden in breadcrumb(default is true)
    activeMenu: '/example/list'  if set path, the sidebar will highlight the path you set
  }
 */

/**
 * constantRoutes
 * a base page that does not have permission requirements
 * all roles can be accessed
 */
export const constantRoutes = [
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true
  },

  {
    path: '/404',
    component: () => import('@/views/404'),
    hidden: true
  },

  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    children: [{
      path: 'dashboard',
      name: 'Dashboard',
      component: () => import('@/views/dashboard/index'),
      meta: { title: '首页', icon: 'dashboard' }
    }]
  },
  {
    path: '/comInfo',
    component: Layout,
    redirect: '/comInfo',
    name: 'comInfo',
    meta: { title: '申请资质审核', icon: 'example' },
    children: [
      {
        path: '/app',
        name: 'App',
        component: () => import('@/views/comInfoForm/index'),
        meta: { title: '申请资质审核', icon: 'comInfoForm' }
      },
    ]
  },
  {
    path: '/pubJob',
    component: Layout,
    redirect: '/pubJob',
    name: 'pubJob',
    meta: { title: '发布职位', icon: 'pubJob' },
    children: [
      {
        path: '/template',
        name: 'template',
        component: () => import('@/views/job/template'),
        meta: { title: '创建职位模板', icon: 'template' }
      },
      {
        path: '/tlManager',
        name: 'tlManager',
        component: () => import('@/views/job/tlManager'),
        meta: { title: '职位模板管理', icon: 'tlManager' }
      },
      {
        path: '/associated',
        name: 'associated',
        component: () => import('@/views/job/associated'),
        meta: { title: '关联公司与职位', icon: 'associated' }
      }
    ]
  },

  {
    path: '/resumeInfo',
    component: Layout,
    redirect: '/resumeInfo',
    name: 'resumeInfo',
    meta: { title: '求职者信息', icon: 'resumeInfo' },
    children: [
      {
        path: '/baseInfo',
        name: 'baseInfo',
        component: () => import('@/views/resume/baseInfo'),
        meta: { title: '基本信息', icon: 'baseInfo' }
      },
      {
        path: '/resume',
        name: 'resume',
        component: () => import('@/views/resume/resume'),
        meta: { title: '简历信息', icon: 'resume' }
      },
    ]
  },

  {
    path: '/Email',
    component: Layout,
    redirect: '/Email',
    name: 'Email',
    meta: { title: '发送邮件', icon: 'sendEmail' },
    children: [
      {
        name: 'sendEmail',
        path: '/sendEmail',
        component: () => import('@/views/email/sendEmail'),
        meta: { title: '发送邮件', icon: 'sendEmail' }
      }
    ]
  },
  // 404 page must be placed at the end !!!
  { path: '*', redirect: '/404', hidden: true }
]

const createRouter = () => new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})

const router = createRouter()

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router
