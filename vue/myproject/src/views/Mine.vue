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
                    <el-table :data="tableData" style="width: 100%"> 
                    <el-table-column prop="orderNumber" label="订单号"></el-table-column> 
                    <el-table-column prop="movieName" label="电影名"></el-table-column> 
                    <el-table-column prop="submitTime" label="提交时间"></el-table-column> 
                    <el-table-column label="操作"> 
                        <template slot-scope="scope"> 
                            <el-button type="primary" size="small" @click="handleEdit(scope.row)">详情</el-button>
                            <el-button type="danger" size="small" @click="handleDelete(scope.row)">删除</el-button>
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
    import { Divider } from 'element-ui';
    import { MessageBox } from 'element-ui';
import { isReactive } from 'vue';
import { RouterLink } from 'vue-router';

    export default {
        data() {
            return {
                tableData: [

                ]
            };
        },
        mounted(){
          const url = `${this.$root.$baseUrl}/indents/`
          this.axios.get(url).then(response => {
              const data = response.data
              console.log(data);
              const code = data.code;
              const orders = data.data;
            this.tableData = orders.map((order) => ({
                orderNumber: order.id,
                movieName: order.ticket.session.movie.title,
                // submitTime: order.purchaseTime.split('T')[0]+' '+order.purchaseTime.split('T')[1].split(':')[0]+':'+order.purchaseTime.split('T')[1].split(':')[1],
                submitTime: order.purchaseTime,
            }));
              if(code === 20000) {
                  this.$store.state.code = 20000;
                } else {
                  this.$store.state.code = data.code;
                  alert(data.msg);
                }
            })
        },
        methods: {
            handleEdit(row) {
                // 编辑订单 
                alert('您即将进入订单详情页面');
                this.$router.push({ path: '/OrderDescription', query: { orderId: row.orderNumber } });
            },
            handleDelete(row) {
                MessageBox.confirm('确定要删除该订单吗?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning',
                })
                .then(() => {
                const url1 = `${this.$root.$baseUrl}/indents/`;
                const url = url1 + row.orderNumber;
               console.log(url);
                this.axios.delete(url).then(response => {
                    const data = response.data
                    console.log(data);
                    const code = data.code;
                    if(code === 20000)
                    {   this.$store.state.code = 20000;
                        alert('订单已经删除');
                        location.reload(); // 刷新页面
                    }
                    else{
                        this.$store.state.code = 20000;
                        alert(data.msg)
                    }
                })

                })
                .catch(() => {
                alert('您已取消删除订单', row);
                });
            },
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



