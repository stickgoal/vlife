<template>
    <div>
        <el-container>
            <el-aside><img :src="movie.posterUrl" alt=""></el-aside>
            <el-main>
                <h2>{{movie.movieName}}</h2>
                <div>{{movie.description}}</div>
                <div>
                    <div v-for="v in movie.reviews" :key="v.reviewId" style="margin-top:20px">
                        <el-card class="box-card" body-style="text-align:left;">

                        <el-row gutter="20">

                            <el-col :span="6">
                                <img style="width:48px;height:48px" :src="v.avatar" alt="v.username">
                                {{v.username}}
                            </el-col>
                            <el-col :span="18" style="text-align:right">
                                发表于 {{v.publishDate}}
                            </el-col>
                        </el-row>

                        <div>
                            {{v.content}}
                        </div>
                        </el-card>

                    </div>
                </div>
            </el-main>
        </el-container>


    </div>
</template>

<script>
    export default {
        name: "Detail",
        data() {
            return {movie: {}}
        },
        mounted() {

            this.$ax.get("/movie/detail?movieId=" + this.$route.params.id).then(
                (res) => {
                    this.movie = res.data;
                }
            )
        }
    }
</script>

<style scoped>

</style>