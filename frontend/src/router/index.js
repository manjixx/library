import Vue from 'vue'
import Router from 'vue-router'

/* 导入编写好的组件 */
import AppIndex from '../components/home/Appindex'
import Login from '@/components/Login'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/Login',
      name: 'Login',
      component: Login
    },
    {
      path: '/index',
      name: 'AppIndex',
      component: AppIndex
    }
  ]
})
