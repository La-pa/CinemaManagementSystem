<template>
    <div class = "all">
        <el-container>
            <el-aside width="130px"></el-aside>
            <el-container>
                <el-header>
                    <div class="header-content">
                        <el-breadcrumb separator-class="el-icon-arrow-right" class="bread">
                        
                            <el-breadcrumb-item :to="{ path: '/Page' }"><i class="el-icon-s-home">首页</i></el-breadcrumb-item>
                            <el-breadcrumb-item :to="{path:'/Movies'}"><i class="el-icon-film" >电影</i></el-breadcrumb-item>
                            <el-breadcrumb-item :to="{path:'/Mine'}"><i class="el-icon-user-solid">我的</i></el-breadcrumb-item>
                        </el-breadcrumb>
                    </div>
                </el-header>
                <div class="elmenu">
                    <el-menu router :default-active="$route.path" class="el-menu-demo" mode="horizontal" >
                        <el-menu-item index="/HottestFilm">最热电影</el-menu-item>
                        <el-menu-item index="/NewestFilm">最新电影</el-menu-item>
                        <el-menu-item index="3">高分电影</el-menu-item>
                    </el-menu>
                </div>
                <el-main>
                    <div>
                        
                    </div>
                        <div class="movie-row" v-for="row in 2" >
                            <div class="movie" v-for="movie in movies.slice((row-1)*5, row*5)" >
                                <div class="movie-image" :style="{ backgroundImage: `url(${movie.image})` }" @click="BookTicket(movie)">
                                    <img :src="movie.imageUrl"  >
                                    <span>
                                        <h4>{{ movie.title }}</h4>
                                    </span>
                                </div>
                            </div>
                        </div>
                </el-main>
                <el-footer></el-footer>
            </el-container>
            <el-aside width="130px"></el-aside>
        </el-container>
    </div>
</template>

<script>
import { Message } from 'element-ui';
    export default{
        data(){
  
            return{

                movies:[],
                userId:'',
                
            };
        },
        methods:{
            BookTicket(movie){
                this.$router.push({ path:'/FilmDescription', 
                                    query: { 
                                        id:movie.id,
                                        image: movie.imageUrl,  
                                        userId:this.userId,
                                        }});
                this.$message({
                    title: '成功',
                    message: '操作成功',
                    type: 'success',
                    duration:1000    
                })
            },
        },
        mounted() {
            console.log(this.$route.query.id)   
            this.userId = this.$route.query.id
            const url = `${this.$root.$baseUrl}/movies/new`;
            this.axios.get(url).then(response => {
                const data = response.data;
                console.log(data);
                this.movies = data.data; // 直接将返回的data数组赋值给this.movies
                if (data.code === 20000) { // 修改判断条件为20000
                    this.$store.state.code = 20000; // 请求成功的状态码修改为20000
                    // alert('操作成功')
                } else {
                    this.$store.state.code = data.code; // 其他状态码
                    alert(data.msg); // 显示后端返回的消息
                }
                })
                .catch(error => {
                console.log(error);
                });
        },
    }
</script>

<style scoped>
  body{
    background-color: rgb(247,247,247);
  }
  .elmenu{
    text-align: center;
  }
  .el-header {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 235px;
   }
  .header-content { 
    margin-left: 550px;
    margin-top: 20px;

   }

  .el-footer{
    background-color: rgb(247,247,247);
    text-align: center;
   }

  
  .el-aside {
    background-color: rgb(247,247,247);

  }
  
  .el-main {
    background-color: rgb(255,255,255);
    /* color: #333; */
    text-align: center;
    line-height: 725px;
  }
  
.movie-row {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  margin-bottom: 20px;
}
.bread{
    margin-left:-80px;
}
.movie {
  width: calc(20% - 10px);
  margin-bottom: 20px;
  text-align: center;
}

.movie-image {
  width: 85%;
  height: 0;
  padding-bottom: 150%;     
  /* background-color: #f2f2f2; */
  background-size: cover;
  background-position: center;
  position: relative;
  
}
.movie-image img { 
    position:absolute;
    width: 100%; 
    height: 100%; 
    top: 0;
    left: 0;
    /* object-fit: cover;  */
    border: 2px solid #fff;
}
.movie h4 { font-size: 16px; margin: 10px 0; }
.movie p {
  font-size: 12px;
  line-height: 1.5;
}

.no-movies {
  text-align: center;
  margin-top: 50px;
}

</style>