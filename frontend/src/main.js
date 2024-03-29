import Vue from 'vue';
import App from './App.vue';
import router from './router';
import store from './store';
import ElementUI from 'element-ui';
import axios from 'axios';
import 'element-ui/lib/theme-chalk/index.css';
Vue.config.productionTip = false

axios.defaults.baseURL = "https://8.130.82.226:9090"
// axios.defaults.baseURL = "http://localhost:9099"
axios.defaults.withCredentials = true;
Vue.prototype.$http = axios
Vue.config.productionTip = false
Vue.use(ElementUI);

new Vue({
  router,
  store,
  el: '#app',
  render: h => h(App)
}).$mount('#app')
