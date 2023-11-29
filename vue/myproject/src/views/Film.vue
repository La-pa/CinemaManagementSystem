<template>
  <div>
    <el-menu
      :default-active="activeIndex2"
      class="el-menu-demo"
      mode="horizontal"
      @select="handleSelect"
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b">
      <el-menu-item index="1" class = "page" @click="showRecentFilms">首页</el-menu-item>
      
      <el-menu-item index="2" >
      <el-input
          class ="inSearch"
          v-model="search"
          placeholder="请输入搜索关键字"
          suffix-icon="el-icon-search"
          style="margin-left: 0px"
          @search="handleSearch"
        ></el-input>
      </el-menu-item>
      <el-menu-item index="3" class="myOrder">
        <a href="javacript:;" target="_blank">
         <el-avatar> 我的 </el-avatar>
        </a>
    </el-menu-item>
    </el-menu>
    <el-card shadow="hover" v-for="(movie, index) in movieList" :key="index">
      <img :src="movie.poster" class="movie-poster">
      <div class="movie-info">
        <h1>{{ movie.title }}</h1>
        <p>{{ movie.description }}</p>
        <el-button type="primary" @click="buyTicket(movie)">选座购票</el-button>
      </div>
    </el-card>
  </div>
</template>

<script>
export default {
  data() {
    return {
      movieList: [1,2,3]
    }
  },
  mounted() {
    this.fetchMovies()
  },
  methods: {
    fetchMovies() {
      // 发送请求获取影片列表
      axios.get('/api/movies').then(response => {
        this.movieList = response.data
      }).catch(error => {
        console.log(error)
      })
    },
    buyTicket(movie) {
      // alert('购买了' + movie.title + '的电影票！')
      this.$router.push({path:'/Seat'})
    }
  }
}
</script>

<style scoped>
.movie-poster {
  width: 40%;
  height: 600px;
  object-fit: cover;
}
.page{
  width:350px;
}
.inSearch{
  width:850px;
  
}
.myOrder{
  width:350px;
}
.movie-info {
  padding: 20px;
}
</style>
