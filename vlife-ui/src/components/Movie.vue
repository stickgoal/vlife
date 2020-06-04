<template>
    <div>
        <el-row :gutter="20">
            <el-col :md="6" :sm="12" :xs="24" v-for="m in movies" :key="m.movieId">
                <el-card :body-style="{ padding: '0px'}">
                    <img :src="m.posterUrl" class="image">
                    <div style="padding: 14px;">
                        <span>{{m.movieName}}</span>
                        <div class="bottom clearfix">
                            <div>{{ m.shortDescription }}</div>
                            <el-button type="text" class="button"> <router-link :to="'/detail/'+m.movieId">详情</router-link></el-button>
                            </div>
                        </div>
                </el-card>

            </el-col>
        </el-row>
    </div>
</template>

<script>
    export default {
        name: "Movie",
        data: function() {
            return {
                activeIndex: '1',
                activeIndex2: '1',
                currentDate: new Date(),
                movies: [],
                dialogVisible: false,
                movie: {}
            }
        },
        methods: {
            showMovie: function(movie) {
                this.movie = movie;
                this.dialogVisible = true;
            }
        },
        mounted: function() {
            console.log(this.$ax.defaults);
            this.$ax.get("/movie/movies").then(
              (res)=> {
                    console.log(res);
                    this.movies = res.data;
                }
            )
        }
    }
</script>

<style scoped>

</style>