import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Login from '../views/Login.vue'
import Home from '../views/Home.vue'
import AboutView from '../views/AboutView.vue'
import My from '../views/My.vue'
import Movie from '../views/Movie.vue'

Vue.use(VueRouter)

const routes = [
  { path: '/',redirect:"/login"},
  { path: '/HomeView', name: 'HomeView', component: HomeView },
  { path: '/login', name: 'Login', component: Login },
  { path: '/Home', name: 'Home', component: Home },
  { path: '/AboutView', name: 'AboutView', component: AboutView },
  { path: '/My', name: 'My', component: My },
  { path: '/Movie', name: 'Movie', component: Movie}
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
