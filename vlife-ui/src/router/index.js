import Login from '@/components/Login'
import Movie from '@/components/Movie'
import Detail from '@/components/Detail'
import VueRouter from 'vue-router'
import Vue from 'vue'

Vue.use(VueRouter);


const routes=[
    { path: '/login', component: Login },
    { path: '/movie', component: Movie },
    { path: '/detail/:id', component: Detail }
];

const router = new VueRouter({
    routes
})

export default router;