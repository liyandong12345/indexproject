/*
 * @Author: your name
 * @Date: 2020-03-04 15:15:57
 * @LastEditTime: 2020-03-05 17:41:33
 * @LastEditors: your name
 * @Description: In User Settings Edit
 * @FilePath: \pro1-vue\pro-li\src\router\index.js
 */
import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/pages/Home'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    }
  ]
})
