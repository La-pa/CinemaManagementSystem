  <template>
    <div class = "all">
        <el-container style="height:100vh"> 
            <el-aside width="130px">
            </el-aside>
            <el-container style="height:100%">
                <el-header>
                    <div class="header-content">
                        <el-breadcrumb separator-class="el-icon-arrow-right" class="bread">
                        
                            <el-breadcrumb-item :to="{ path: '/Page' }"><i class="el-icon-s-home">首页</i></el-breadcrumb-item>
                            <el-breadcrumb-item :to="{path:'/Movies'}"><i class="el-icon-film" >电影</i></el-breadcrumb-item>
                            <el-breadcrumb-item :to="{path:'/Mine'}"><i class="el-icon-user-solid" >我的</i></el-breadcrumb-item>
                        </el-breadcrumb>
                    </div>
                </el-header>
                <el-main style="overflow-y: auto;display:flex ;height:8 0%">
                  <div class="content-container" style="flex:1;height:70%;width:50%;">
                    <h2 class="image-title" style="margin-top: 8px;">{{ movie.title }}</h2>  
                    <img :src="movie.imageUrl" alt="图片" class="photo" style="margin-top: -10px;">
                    <el-button style="display:block;margin-left:38%;width:25%" @click="BookTicket" :disabled="movie.showStatus != 1" :title="movie.showStatus === 1 ? '' : '该电影暂不可选座'">点我选座</el-button>
                  </div>
                  <div class="text-container" style="flex:1;height:70%;width:50%;">
                    <p class="p1">导演:{{movie.director}}</p>
                    <p class="p2">类型:{{movie.genre}}</p>
                    <p class="p2">首映时间:{{movie.releaseDate}}</p>
                    <p class="p2">仍在上映:{{movie.showStatus == 1?'是':'否'}}</p>
                    <!-- <h2>{{title}}的电影剧情简介.....</h2> -->
                    <!-- <p>{{description}}</p> -->
                  </div>
                </el-main>
                <div class="movieIntro" style="display:block;height:20%">
                    <h2>{{ movie.title }}的电影剧情简介</h2>
                    <p>{{movie.introduction}}</p>
                  </div>
                <el-footer></el-footer>
            </el-container>
            <el-aside width="130px"></el-aside>
        </el-container>
    </div>
  </template>
<script> 
    export default{ 
        data(){ 
            return{ 
              movie:[],
                id:'',  
                userId:'',

            } 
        }, 
        mounted(){  
            this.id = this.$route.query.id//获取传递的id
            this.userId = this.$route.query.userId
            // alert(userId);
            // alert(this.id);
            const url = `${this.$root.$baseUrl}/movies/${this.id}`;
            this.axios.get(url).then(response => {
                const data = response.data;
                console.log(data);
                this.movie = data.data; // 直接将返回的data数组赋值给this.movies
                if (data.code === 20000) { // 修改判断条件为20000
                    this.$store.state.code = 20000; // 请求成功的状态码修改为20000
                } else {
                    this.$store.state.code = data.code; // 其他状态码
                    alert(data.msg); // 显示后端返回的消息
                }
                })
                .catch(error => {
                console.log(error);
                });
        },
        methods:{
          ComeBack(){
            this.$router.push({path:'/Page'})
          },
          BookTicket(){
            this.$message({
                type:'success',
                message:'操作成功,即将进入选座界面',
                duration:1000
              })
              setTimeout(() => {
                this.$router.push({
                  path: '/Seat',
                  query: {
                    id: this.id,
                    title: this.movie.title,
                    introduction: this.movie.introduction
                  }
                });
              }, 1000); // 设置延迟时间，单位为毫秒
              
          }
        }
    } 
    
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
  .photo{
    width:50%;
    height:400px;
    /* object-fit: contain; */
  }
  .text-container {
  height: 100%;
  width: 50%;

  }
  .p1{
    margin-top: 23%;
  }
  .p2{
    margin-top: 10%;
  }
  .text-container p{
    color: yellowgreen;
    width: 70%;
    margin-left:-10%;
    /* margin-top: 17%; */
  }
  </style>