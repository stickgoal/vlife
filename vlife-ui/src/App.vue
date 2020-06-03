<template>
    <div id="app">
        <img alt="Vue logo" src="./assets/movie.png">
        <h2> v-life · 私影生活</h2>
        <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" router>
            <el-menu-item index="/login">登录</el-menu-item>
            <el-menu-item index="/movie">电影</el-menu-item>
        </el-menu>

        <router-view></router-view>
    </div>
</template>

<script>

    export default {
        name: 'App',
        data() {
            return {activeIndex:"/movie"}
        },
        components: {
        }
    }
</script>

<style>
    #app {
        font-family: Avenir, Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        color: #2c3e50;
        margin-top: 10px;
    }
</style>
