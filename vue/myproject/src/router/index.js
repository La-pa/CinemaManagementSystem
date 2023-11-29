import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Page from '../views/Page.vue'
import FilmDescription from '../views/FilmDescription.vue'
import Film from '../views/Film.vue'
import Movies from '../views/Movies.vue'
import Seat from '../views/Seat.vue'
import Mine from '../views/Mine.vue'
import AccountManage from '../views/AccountManage.vue'
import MovieData from '../views/MovieData.vue'
import OrderDescription from '../views/OrderDescription.vue'



Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path:'/Page',
    name:'/Page',
    component:Page
  },
  {
    path:'/FilmDescription',
    name:'/FilmDescription',
    component:FilmDescription
  },
  {
    path:'/Movies',
    name:'/Movies',
    component:Movies
  },
  {
    path:'/Mine',
    name:'/Mine',
    component:Mine
  },
  {
    path: '/Film',
    name: 'Film',
    component: Film
  },
  {
    path:'/AccountManage',
    name:'AccountManage',
    component:AccountManage
  },
  {
    path:'/MovieData',
    name:'MovieData',
    component:MovieData
  },
  {
    path: '/Seat',
    name: 'Seat',
    component: Seat
  },
  {
    path:'/OrderDescription',
    name:'OrderDescription',
    component:OrderDescription
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  }
]

const router = new VueRouter({
  routes
})

export default router
