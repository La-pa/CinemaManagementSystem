<template>
    <div class="all">
      <el-container style="height:100vh">
        <!-- 左侧菜单栏 -->
        <el-aside width="130px">
          <el-col :span="12" style="width:100%;height:100%">
            <el-menu class="el-menu-vertical-demo" background-color="#545c64" text-color="#fff" active-text-color="#ffd04b" style="height:100%" :default-active="activeIndex">
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
                <el-breadcrumb-item :to="{ path: '/Page' }">
                  <i class="el-icon-s-home">首页</i>
                </el-breadcrumb-item>
                <el-breadcrumb-item :to="{ path: '/Movies' }">
                  <i class="el-icon-film">电影</i>
                </el-breadcrumb-item>
                <el-breadcrumb-item :to="{ path: '/Mine' }">
                  <i class="el-icon-user-solid">我的</i>
                </el-breadcrumb-item>
              </el-breadcrumb>
            </div>
          </el-header>
          <el-main style="overflow-y: auto;">
            <el-form :model="form" ref="passwordForm" label-width="120px" style="margin-top: 20px;width:30%;">
                <el-form-item label="初始密码" prop="currentPassword" style="margin-top:40px">
                    <el-input type="password" v-model="form.currentPassword" ></el-input>
                </el-form-item>
              <el-form-item label="新密码" prop="newPassword" style="margin-top:50px">
                <el-input type="password" v-model="form.newPassword"></el-input>
              </el-form-item>
              <el-form-item label="确认密码" prop="confirmPassword" style="margin-top:50px">
                <el-input type="password" v-model="form.confirmPassword"></el-input>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="submitForm">提交</el-button>
              </el-form-item>
            </el-form>
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
        form: {
          currentPassword: '',
          newPassword: '',
          confirmPassword: ''
        },
        userId: '',
        showPassword: false
      };
    },
    mounted() {
      const url = `${this.$root.$baseUrl}/indents/`;
      this.axios.get(url).then(response => {
        const data = response.data;
        const code = data.code;
        if (code === 20000) {
          this.$store.state.code = 20000;
        } else {
          this.$store.state.code = data.code;
          alert(data.msg);
        }
        this.order = data.data;
        this.uesrId = this.order[0].userId;
        console.log(this.order);
      });
    },
    methods: {
        togglePasswordVisibility() {
      this.showPassword = !this.showPassword;
    },  
      toAccount() {
        this.$router.push({ path: '/AccountManage', query: { index: 1 } });
      },
      toOrder() {
        this.$router.push({ path: '/Mine', query: { index: 2 } });
      },
      toData() {
        this.$router.push({ path: '/MovieData', query: { index: 3 } });
      },
      submitForm() {
        // 表单验证
        this.$refs.passwordForm.validate(valid => {
          if (valid) {
            // 发送请求验证初始密码是否正确
            const validateUrl = `${this.$root.$baseUrl}/validatePassword/`;
            const validateData = {
              userId: this.userId,
              password: this.form.currentPassword
            };
  
            this.axios.post(validateUrl, validateData).then(response => {
              const data = response.data;
              const code = data.code;
              if (code === 20000) {
                // 验证成功，发送请求修改密码
                const updateUrl = `${this.$root.$baseUrl}/updatePassword/`;
                const updateData = {
                  userId: this.userId,
                  newPassword: this.form.newPassword
                };
  
                this.axios.put(updateUrl, updateData).then(response => {
                  const data = response.data;
                  const code = data.code;
                  if (code === 20000) {
                    // 修改密码成功
                    alert('密码修改成功');
                  } else {
                    // 修改密码失败
                    alert(data.msg);
                  }
                });
              } else {
                // 密码验证失败
                alert('初始密码验证失败');
              }
            });
          } else {
            // 表单验证失败
            return false;
          }
        });
      }
    },
    created() {
      this.activeIndex = this.$router.currentRoute.query.index || '1';
    }
  };
  </script>
<style scoped>
body {
  background-color: rgb(247, 247, 247);
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

.bread {
  margin-left: -80px;
}

.show-password-button {
  margin-left: 10px;
  height: 32px;
  padding: 4px;
  font-size: 16px;
}

.show-password-button {
  position: absolute;
  right: 10px;
  top: 50%;
  transform: translateY(-50%);
  cursor: pointer;
}

.el-icon-view-show:before {
  content: '\\e6b4';
}

/* 新添加的样式 */

</style>  