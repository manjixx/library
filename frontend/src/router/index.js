import Vue from 'vue'
import Router from 'vue-router'
import Home from '../components/Home'
import Library from '../components/Library/LibraryIndex'

/* 导入编写好的组件 */
import AppIndex from '../components/home/Appindex'
import Login from '@/components/Login'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/home',
      name: 'Home',
      component: Home,
      // home页面并不需要被访问
      redirect: '/index',
      children: [
        {
          path: '/index',
          name: 'AppIndex',
          component: AppIndex,
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/library',
          name: 'LibraryIndex',
          component: Library,
          meta: {
            requireAuth: true
          }
        }
      ]
    },
    {
      path: '/Login',
      name: 'Login',
      component: Login
    }
  ]
})
