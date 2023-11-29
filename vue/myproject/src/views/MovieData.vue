<template>
    <div class = "all">
        <el-container style="height:100vh"> 
            <el-aside width="130px">
              <el-col :span="12" style="width:100%;height:100%">
                  <el-menu
                      class="el-menu-vertical-demo"
                      background-color="#545c64"
                      text-color="#fff"
                      active-text-color="#ffd04b" style="height:100%"
                      :default-active="activeIndex">
                      <el-menu-item index="1" @click="toAccount">
                          <i class="el-icon-user-solid"></i>
                          <span slot="title">账号管理</span>
                      </el-menu-item>
                      <el-menu-item index="2" @click="toOrder">
                          <i class="el-icon-s-order"></i>
                          <span slot="title">订单管理</span>
                      </el-menu-item>
                      <el-menu-item index="3" @click="toData">
                          <i class="el-icon-s-data"></i>
                          <span slot="title">电影数据</span>
                      </el-menu-item>
                  </el-menu>
              </el-col>
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
                <el-main style="overflow-y: auto;">
                  <div>
                  </div>
                </el-main>
                <el-footer></el-footer>
            </el-container>
            <el-aside width="130px"></el-aside>
        </el-container>
    </div>
  </template>
  
  
  <script> 
      import { Divider } from 'element-ui';
  
      export default {
          data() {
              return {
                  tableData: [
                      { orderNumber: "001", movieName: "复仇者联盟", submitTime: "2021-01-01 10:00:00" },
                      { orderNumber: "002", movieName: "星际穿越", submitTime: "2021-01-02 10:00:00" },
                      { orderNumber: "003", movieName: "阿凡达", submitTime: "2021-01-03 10:00:00" },
                      { orderNumber: "003", movieName: "阿凡达", submitTime: "2021-01-03 10:00:00" },
                      { orderNumber: "003", movieName: "阿凡达", submitTime: "2021-01-03 10:00:00" },
                      { orderNumber: "003", movieName: "阿凡达", submitTime: "2021-01-03 10:00:00" },
                      { orderNumber: "003", movieName: "阿凡达", submitTime: "2021-01-03 10:00:00" },
                      { orderNumber: "003", movieName: "阿凡达", submitTime: "2021-01-03 10:00:00" },
                      { orderNumber: "003", movieName: "阿凡达", submitTime: "2021-01-03 10:00:00" },
                      { orderNumber: "003", movieName: "阿凡达", submitTime: "2021-01-03 10:00:00" },
                      { orderNumber: "003", movieName: "阿凡达", submitTime: "2021-01-03 10:00:00" },
                  ]
              };
          },
          methods: {
            toAccount(){
                  this.$router.push({path:'/AccountManage',query:{index:1}})
              },
              toOrder(){
                  this.$router.push({path:'/Mine',query:{index:2}})
              },
              toData(){
                  this.$router.push({path:'/MovieData',query:{index:3}})
              },
  
          },
          components: {
            Divider,
          },
          created(){
            this.activeIndex = this.$router.currentRoute.query.index || '3';
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
  </style>