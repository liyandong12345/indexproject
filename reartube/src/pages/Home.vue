<!--
 * @Author: your name
 * @Date: 2020-03-05 17:38:33
 * @LastEditTime: 2020-03-05 17:52:50
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \pro1-vue\pro-li\src\pages\index.vue
 -->
<template>
  <div class="hello">
     <div>
       <HelloWorld/>
  </div>
  </div>
  
</template>
<script>
import HelloWorld from '@/components/HelloWorld'
export default {
  name: 'Home',
  components:{
      HelloWorld
  },
  data () {
    return {
      msg: '财务分析导航页',
   }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
