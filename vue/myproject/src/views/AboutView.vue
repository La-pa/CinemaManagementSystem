<template>
  <div class="about">
    <h1>This is an about page</h1>
  </div>
</template>



<template>
    <div class = "all">
        <el-container>
            <el-aside width="130px">Aside</el-aside>
            <el-container>
                <el-header>Header</el-header>
                <el-main>
                    <div class="movie-row" v-for="row in 2">
                        <div class="movie" v-for="movie in movies.slice((row-1)*5, row*5)">
                            <div class="movie-image" :style="{ backgroundImage: `url(${movie.image})` }" @click="BookTicket">
                                <img :src="movie.image" >
                                <span>
                                    <h4>{{ movie.title }}</h4>
                                </span>
                            </div>
                        </div>
                    </div>
                </el-main>
                <el-footer></el-footer>
            </el-container>
            <el-aside width="130px">Aside</el-aside>
        </el-container>
    </div>
</template>

<script>
    export default{
        data(){
  
            return{
                movies: [
                    {
                        title: '电影名字',
                        image: 'https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2890135815.webp'
                    },
                    {
                        title: '电影名字',
                        image: 'https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2890135815.webp'
                    },
                    {
                        title: '电影名字',
                        image: 'https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2890135815.webp'
                    },
                    {
                        title: '电影名字',
                        image: 'https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2890135815.webp'
                    },
                    {
                        title: '电影名字',
                        image: 'https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2890135815.webp'
                    },
                    {
                        title: '电影名字',
                        image: 'https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2890135815.webp'
                    },
                    {
                        title: '电影名字',
                        image: 'https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2890135815.webp'
                    },
                    {
                        title: '电影名字',
                        image: 'https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2890135815.webp'
                    },
                    {
                        title: '电影名字',
                        image: 'https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2890135815.webp'
                    },
                    {
                        title: '电影名字',
                        image: 'https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2890135815.webp'
                    },
        

                ]
            }
        }, 
        methods:{
          BookTicket(){
            
          }
        }  
    }
</script>

<style >
  body{
    background-color: rgb(247,247,247);
  }
  .class {
    background-color: rgb(247,247,247);
  }
  .el-header {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 235px;
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
    line-height: 745px;
  }
  
.movie-row {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  margin-bottom: 20px;
}

.movie {

  width: calc(20% - 10px);
  margin-bottom: 20px;
  text-align: center;
}

.movie-image {
  width: 75%;
  height: 0;
  padding-bottom: 120%;     
  background-color: #f2f2f2;
  background-size: cover;
  background-position: center;
  position: relative;
}

.movie-image img {
 
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