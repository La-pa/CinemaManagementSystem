import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

Vue.prototype.$baseUrl = 'https://8.130.82.226:9090';
Vue.config.productionTip = false
Vue.use(ElementUI);


import axios from 'axios'
axios.defaults.withCredentials = true 
import VueAxios from 'vue-axios'

// Vue.prototype.$axios = axios;
Vue.use(VueAxios,axios)


new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')





