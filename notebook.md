# 使用 CLI 搭建 Vue.js 项目

## 前言

- 前后端分离：核心思想是前端页面通过 ajax 调用后端的 restful api 进行数据交互
    - 单体——> 前端应用 + 后端应用 
    - 前端应用：负责数据展示和用户交互
    - 后端应用：负责提供数据处理接口
    - 前端HTML——>Ajax——>RestFul后端数据接口
    
    ![传统单体结构](https://img-blog.csdnimg.cn/20210323161011938.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NjU5NDc5Ng==,size_16,color_FFFFFF,t_70)

    ![前后端分离结构](https://img-blog.csdnimg.cn/20210323162022406.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NjU5NDc5Ng==,size_16,color_FFFFFF,t_70)

- 单页面应用:(single page web application，SPA)，就是只有一张页面，并在用户与应用程序交互时动态更新该页面的 Web 应用程序。

## 一. 安装Vue-CLI

## 二. 构建前端项目

### 2.1 通用方法

### 2.2 使用IDEA


## 三 Vue项目结构

### 1 概览
![vue目录概览](./picture/vue目录概览.png)
![vue目录](https://img-blog.csdnimg.cn/2019040120135655.png)

### 2.index.html
首页初始代码如下：
```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <title>frontend</title>
  </head>
  <body>
    <div id="app"></div>
    <!-- built files will be auto injected -->
  </body>
</html>
```
- <div id="app"></div> ，下面有一行注释，构建的文件将会被自动注入，也就是说我们编写的其它的内容都将在这个 div 中展示。
- 整个项目只有这一个 html 文件，所以这是一个 单页面应用，当我们打开这个应用，表面上可以有很多页面，实际上它们都只不过在一个 div 中。

### 3.App.vue
- 将文件称为“根组件”，因为其它的组件又都包含在这个组件中。.vue 文件是一种自定义文件类型，在结构上类似 html，一个 .vue 文件即是一个 vue 组件。
  
- 初始代码如下：
```html
<template>
  <div id="app">
    <img src="./assets/logo.png">
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
```
- ```<script>``` 标签里的内容即该组件的脚本，也就是 js 代码，export default 是 ES6 的语法，意思是将这个组件整体导出，之后就可以使用 import 导入组件了。大括号里的内容是这个组件的相关属性。

- ```html<router-view/>```，是一个容器，名字叫“路由视图”，意思是当前路由（ URL）指向的内容将显示在这个容器中。也就是说，其它的组件即使拥有自己的路由（URL，需要在 router 文件夹的 index.js 文件里定义），也只不过表面上是一个单独的页面，实际上只是在根组件 App.vue 中。

### 4 main.js

```js
import Vue from 'vue'
import App from './App'
import router from './router'

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
```
- 最上面 import 了几个模块:
  - vue 模块在 node_modules 中
  - App 即 App.vue 里定义的组件 
  - router 即 router 文件夹里定义的路由。
- Vue.config.productionTip = false ,作用是阻止vue 在启动时生成生产提示。

- 在这个 js 文件中，我们创建了一个 Vue 对象（实例），el 属性提供一个在页面上已存在的 DOM 元素作为 Vue 对象的挂载目标，router 代表该对象包含 Vue Router，并使用项目中定义的路由。components 表示该对象包含的 Vue 组件，template 是用一个字符串模板作为 Vue 实例的标识使用，类似于定义一个 html 标签。

## 四 Error
- [Mac(m1)下npm install报错解决方案](https://www.cnblogs.com/eisenshu/p/15753955.html)

****


# Vue + Spring Boot 项目实战（三）：前后端结合测试（登录页面开发）

## 前言

## 一. 后端项目创建

## 二. 登录页面开发

### 1 前后端结合
- 前面提到过前后端分离的意思是前后端之间通过 RESTful API 传递 JSON 数据进行交流。不同于 JSP 之类，后端是不涉及页面本身的内容的。

- 在开发的时候，前端用前端的服务器（Nginx），后端用后端的服务器（Tomcat），当我开发前端内容的时候，可以把前端的请求通过前端服务器转发给后端（称为反向代理），这样就能实时观察结果，并且不需要知道后端怎么实现，而只需要知道接口提供的功能，两边的开发人员（两个我）就可以各司其职啦。

### 2 正向代理与反向代理

#### 正向代理

![正向代理](https://images2015.cnblogs.com/blog/305504/201611/305504-20161112124853014-1532060796.png)

- 正向代理:是一个位于客户端和原始服务器(origin server)之间的服务器，为了从原始服务器取得内容，客户端向代理发送一个请求并指定目标(原始服务器)，然后代理向原始服务器转交请求并将获得的内容返回给客户端。客户端必须要进行一些特别的设置才能使用正向代理。

- 正向代理的用途：
  - 1. 访问原来无法访问的资源，如google
  - 2. 可以做缓存，加速访问资源
  - 3. 户端访问授权，上网进行认证
  - 4. 可以记录用户访问记录（上网行为管理），对外隐藏用户信息

#### 反向代理

- 初次接触方向代理的感觉是，客户端是无感知代理的存在的，反向代理对外都是透明的，访问者者并不知道自己访问的是一个代理。因为客户端不需要任何配置就可以访问。

- 反向代理（Reverse Proxy）实际运行方式是指以代理服务器来接受internet上的连接请求，然后将请求转发给内部网络上的服务器，并将从服务器上得到的结果返回给internet上请求连接的客户端，此时代理服务器对外就表现为一个服务器。

- 反向代理的作用
  - 1. 保证内网的安全，可以使用反向代理提供WAF功能，阻止web攻击
       ![反向代理保证内网安全](https://images2015.cnblogs.com/blog/305504/201611/305504-20161112124341280-1435223816.png)

  - 2. 负载均衡，通过反向代理服务器来优化网站的负载
       ![负载均衡](https://images2015.cnblogs.com/blog/305504/201611/305504-20161112124423530-566240666.png)

#### 二者区别

实际上proxy在两种代理中做的事都是代为收发请求和响应，不过从结构上来看正好左右互换了下，所以把后出现的那种代理方式叫成了反向代理。

- 正向代理中，proxy和client同属一个LAN，对server透明；

- 反向代理中，proxy和server同属一个LAN，对client透明。

![正向代理与反向代理的区别](https://pic2.zhimg.com/80/480c1c45d2565e2f92fd930d25b73a18_720w.jpg?source=1940ef5c)


### 3 前端界面开发

- 创建Login.vue
- components/home/Appindex.vue
- 设置反向代理
```vue
// 设置反向代理，前端请求默认发送到 http://localhost:8443/api
var axios = require('axios')
axios.defaults.baseURL = 'http://localhost:8443/api'
// 全局注册，之后可在其他组件中通过 this.$axios 发送数据
Vue.prototype.$axios = axios
Vue.config.productionTip = false
```

- 页面路由配置：修改 ```src\router\index.js``` 

- 在``` config\index.js ```进行跨域配置
```vue
 proxyTable: {
      '/api': {
        target: 'http://localhost:8443',
        changeOrigin: true,
        pathRewrite: {
          '^/api': ''
        }
      }
    }
```

### 4 后端开发

- 新建pojo包，创建User类
- 新建result包，创建Result类
- 新建controller包，创建loginController类
- ```application.properties```文件配置端口，即加上```server.port=8443```



