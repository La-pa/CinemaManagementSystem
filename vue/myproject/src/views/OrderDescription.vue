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
                    <el-descriptions class="margin-top" title="订单详情"  border>
                        <template slot="extra">
                        <el-button type="primary" size="small" @click="ComeBack()">返回</el-button>
                        </template>
                        <el-descriptions-item>
                        <template slot="label">
                            <i class="el-icon-s-order"></i>
                            订单编号
                        </template>
                        {{ order.id }}
                        </el-descriptions-item>
                        <el-descriptions-item>
                        <template slot="label">
                            <i class="el-icon-mobile-phone"></i>
                            购票时间
                        </template>
                        {{ order.purchaseTime ? order.purchaseTime : '' }}
                        </el-descriptions-item>
                        <el-descriptions-item>
                        <template slot="label">
                            <i class="el-icon-location-outline"></i>
                            座位号
                        </template>
                        <span class="value" v-if="order.ticket && order.ticket.seat">{{ order.ticket.seat.seatRow }}{{ order.ticket.seat.seatCol }}</span>

                        </el-descriptions-item>
                        <el-descriptions-item>
                        <template slot="label">
                            <i class="el-icon-tickets"></i>
                            电影详情    
                        </template>
                        <el-tag size="small">{{order.ticket && order.ticket.session && order.ticket.session.movie.title}}            </el-tag>
                        <br>
                        <el-tag size="small" v-if="order.ticket && order.ticket.session">{{ '价格：￥' + order.ticket.session.price }}</el-tag>
                        <br>
                        <el-tag size="small">{{ order.ticket && order.ticket.session && order.ticket.session.movie.genre}}</el-tag>
                        
                        </el-descriptions-item>
                        <el-descriptions-item>
                        <template slot="label">
                            <i class="el-icon-office-building"></i>
                            放映厅
                        </template>
                        <span class="value" v-if="order.ticket && order.ticket.session && order.ticket.session.room">{{ order.ticket.session.room.name }}</span>

                        </el-descriptions-item>
                        <el-descriptions-item>
                            <template slot="label">
                                <i class="el-icon-timer"></i>
                                开始时间
                            </template>
                            <span class="value" v-if="order.ticket && order.ticket.session">{{ order.ticket.session.startTime}}</span>

                        </el-descriptions-item>
                        <el-descriptions-item>
                            <template slot="label">
                                <i class="el-icon-s-ticket"></i>
                                电影票编号
                            </template>
                            {{order.ticketId}}
                        </el-descriptions-item>
                    </el-descriptions>
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
          form: {
              name: '',
              region: '',
              date1: '',
              date2: '',
              delivery: false,
              type: [],
              resource: '',
              desc: '',
              },
          imageUrl:'',
          order: [],
          orderId:'',
        };
        
    },
    mounted(){
      this.orderId = this.$route.query.orderId;
      const url = `${this.$root.$baseUrl}/indents/`;
      this.axios.get(url).then((response) => {
        const data = response.data;
        console.log(data);
        if (data.code === 20000) {
          const all = data.data;
          this.order = all.find(item => item.id == this.orderId);
        } else {
          alert(data.msg);
        }
      });
    //   console.log(this.orderId);
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
        onSubmit() {
          console.log('submit!');
        },
        ComeBack(){
            window.history.back();
        }
  },

    components: {
      Divider,
    },
    created(){
      this.activeIndex = this.$router.currentRoute.query.index || '2';
    },
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