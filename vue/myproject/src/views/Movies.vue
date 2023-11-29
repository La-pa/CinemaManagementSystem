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
                          <el-breadcrumb-item :to="{path:'/Mine'}"><i class="el-icon-user-solid" >我的</i></el-breadcrumb-item>
                      </el-breadcrumb>
                  </div>
              </el-header>
              <el-main>
                <div>
                  <el-input class="input" v-model="search" placeholder="请输入电影名" style="width: 200px; margin-bottom: 10px; margin-right: 200px;"></el-input>
                  <el-input class="input" v-model="searchGenre" placeholder="电影类型" style="width: 200px;"></el-input>
                  <el-table :data="filteredMovies" :sort-order="sortOrder" :sort-by="sortColumn" style="width:100%">
                    <el-table-column prop="title" label="电影名" sortable ></el-table-column>
                    <el-table-column prop="releaseDate" label="上映时间" sortable ></el-table-column>
                    <el-table-column prop="genre" label="电影类型" ></el-table-column>
                    <el-table-column label="操作">
                      <template slot-scope="scope">
                        <el-button type="text" @click="handleMovieClick(scope.row)">查看详情</el-button>
                      </template>
                    </el-table-column>
                  </el-table>
                </div>
              </el-main>
              <el-footer></el-footer>
          </el-container>
          <el-aside width="130px"></el-aside>
      </el-container>
  </div>
</template>


  <script>
  export default {
    data() {
      return {
        movies: [],
        search: '',
        searchGenre: '',
        sortColumn: '',
        sortOrder: ''
      };
    },
    mounted() {
      // 从后端获取电影数据
     const url = `${this.$root.$baseUrl}/movies/`;
     this.axios.get(url).then(response=>{
      const data = response.data; 
      const code = data.code; 
      if(code === 20000) {
            this.$store.state.code = 20000;
          } else {
            this.$store.state.code = data.code;
            alert(data.msg);
          }
      this.movies = data.data;
      console.log(this.movies);
     })
    },
    computed: {
      filteredMovies() {
        // 根据电影名和电影类型搜索电影
        return this.movies.map(movie => {
              // const releaseDate = movie.releaseDate.split(' ')[0]+' '+movie.releaseDate.split('T')[1].split(':')[0]+':'+movie.releaseDate.split('T')[1].split(':')[1]
                 const releaseDate = movie.releaseDate
          
          // 返回修改后的电影对象
          return {
            ...movie,
            releaseDate: releaseDate
          };
        }).filter(movie => {
          const nameMatch = movie.title.includes(this.search);
          const genreMatch = movie.genre.includes(this.searchGenre);
          return nameMatch && genreMatch;
        });
      }
    },
    watch: {
      // 监听表格排序
      sortColumn(val) {
        if (val) {
          this.filteredMovies.sort((a, b) => {
            const sortVal = a[val] > b[val] ? 1 : -1;
            return this.sortOrder === 'ascending' ? sortVal : -sortVal;
          });
        }
      }
    },
    methods:{
        ComeBack(){
            this.$router.push({path:'/Page'});
        },
        handleMovieClick(movie) {
      // 执行跳转到电影详情页的操作
        this.$router.push({
          path: '/FilmDescription',
          query: {
            id: movie.id,
            image: movie.imageUrl,
          }
        });
      },
    },
   
  };
  </script>
  
<style scoped>

body{
    background-color: rgb(247,247,247);
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

  
.bread{
    margin-left:-80px;
}
 
</style>





{ title: '肖申克的救赎', releaseDate: '1994-09-10', genre: '剧情' },
        { title: '霸王别姬', releaseDate: '1993-01-01', genre: '剧情' },
        { title: '阿甘正传', releaseDate: '1994-07-06', genre: '剧情' },
        { title: '这个杀手不太冷', releaseDate: '1994-09-14', genre: '动作' },
        { title: '泰坦尼克号', releaseDate: '1997-12-19', genre: '爱情' },
        { title: '泰坦尼克号', releaseDate: '1997-12-19', genre: '爱情' },
        { title: '泰坦尼克号', releaseDate: '1997-12-19', genre: '爱情' },
        { title: '泰坦尼克号', releaseDate: '1997-12-19', genre: '爱情' },
        { title: '泰坦尼克号', releaseDate: '1997-12-19', genre: '爱情' },
        { title: '泰坦尼克号', releaseDate: '1997-12-19', genre: '爱情' },
        { title: '泰坦尼克号', releaseDate: '1997-12-19', genre: '爱情' },
        { title: '泰坦尼克号', releaseDate: '1997-12-19', genre: '爱情' },
        { title: '泰坦尼克号', releaseDate: '1997-12-19', genre: '爱情' },
        { title: '泰坦尼克号', releaseDate: '1997-12-19', genre: '爱情' },
        { title: '泰坦尼克号', releaseDate: '1997-12-19', genre: '爱情' },   
