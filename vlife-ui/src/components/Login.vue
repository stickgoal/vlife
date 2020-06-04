<template>
    <div>
        <el-main>
            <el-row>
                <el-col :span="12" style="text-align: center">

                    <el-form label-width="80px" :model="loginFrom">
                        <el-form-item label="用户名">
                            <el-input v-model="loginFrom.username"></el-input>
                        </el-form-item>
                        <el-form-item label="密码">
                            <el-input v-model="loginFrom.password"></el-input>
                        </el-form-item>
                        <el-form-item>
                            <el-button type="primary" @click="submitLogin">登录</el-button>
                            <el-button>取消</el-button>
                        </el-form-item>
                    </el-form>
                </el-col>
            </el-row>
        </el-main>
    </div>
</template>

<script>
    import qs from 'qs';

    export default {
        name: "Login",
        data() {
            return {
                labelPosition: 'right',
                loginFrom: {
                    username: '',
                    password: '',
                }
            };
        },
        methods: {
            submitLogin: function () {

                this.$ax.post('/login', qs.stringify(this.loginFrom))
                    .then((res) => {
                        console.log(res);
                        if (res.data.success) {

                            localStorage.authToken=res.data.data.auth_token;
                            this.$ax.defaults.headers.common['auth_token']=res.data.data.auth_token;
                            this.$router.push("/Movie");

                        } else {
                            const h = this.$createElement;
                            this.$notify.warning({
                                title: "登录失败",
                                message: h('i', {style: 'color: teal'}, res.data.message),
                                duration: 3000
                            });
                        }
                    })
                    .catch(function (err) {
                        console.error(err);
                    })
            }
        }
    }
</script>

<style scoped>

</style>