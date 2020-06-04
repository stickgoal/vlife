import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import router from './router'
import axios from 'axios'

Vue.use(ElementUI)

Vue.prototype.$ax=axios

axios.defaults.baseURL="http://localhost:9000"
axios.defaults.headers.common['auth_token']=localStorage.authToken;

Vue.config.productionTip = false


new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
