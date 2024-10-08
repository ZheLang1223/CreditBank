import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui'; // 导入组件
import 'element-ui/lib/theme-chalk/index.css';  // 导入样式
import './assets/global.css';
import axios from "axios";
import VueRouter from 'vue-router';
import router from './router';
import store from './store';

Vue.prototype.$axios=axios;
Vue.prototype.$httpUrl='http://localhost:9000'
Vue.config.productionTip = false
Vue.use(ElementUI);
Vue.use(VueRouter);
//Vue.use(ElementUI,{size:'small'});
new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app')
