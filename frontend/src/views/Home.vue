<template>
    <div>
        <el-container>
        <el-header>
            <router-link to="Home">首页</router-link>
            <router-link to="Movie">电影</router-link>
            <router-link to="My">我的</router-link>
        </el-header>
        <el-main>Main</el-main>
        </el-container>
    </div>
</template>

<script>

</script>

<style>
  .el-header, .el-footer {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 60px;
  }

  
  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 400px;
  }
  
  
</style>