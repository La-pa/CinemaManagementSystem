<template>
    <div class="login-container">
      <el-card class="login-card" v-show="showLogin">
          <h3>欢迎使用</h3>
          <h2>电影预约系统</h2>
          <el-form ref="loginForm" :model="loginForm" :rules="loginRules" label-width="80px" class="login-form">
            <el-form-item label="账号" prop="id">
              <el-input v-model="loginForm.id"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="password">
              <el-input type="password" v-model="loginForm.password"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="handleLogin">登录</el-button>
              <el-button @click="showLogin = false,showRegister = true">注册</el-button>
              <el-button @click="showAdminLogin = true,showLogin = false,showRegister = false">管理员登录</el-button>
            </el-form-item>
          </el-form>
        </el-card>
        <el-card class="register-card" v-show="showRegister">
          <h3>用户注册</h3>
          <el-form ref="registerForm" :model="registerForm" :rules="registerRules" label-width="80px" class="register-form">
            <el-form-item label="账号" prop="id">
              <el-input v-model="registerForm.id"></el-input>
            </el-form-item>
            <el-form-item label="用户名" prop="username">
              <el-input v-model="registerForm.username"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="password">
              <el-input type="password" v-model="registerForm.password"></el-input>
            </el-form-item>
            
            <el-form-item>
              <el-button type="primary" @click="handleRegister">注册</el-button>
              <el-button @click="showLogin = true,showRegister = false">登录</el-button>
              <el-button @click="showLogin = false,showRegister = false,showAdminLogin = true">管理员登录</el-button>
            </el-form-item>
          </el-form>
        </el-card>
      <el-card class="admin-login-card" v-show="showAdminLogin">
        <h3>管理员登录</h3>
        <el-form ref="adminLoginForm" :model="adminLoginForm" :rules="adminLoginRules" label-width="80px" class="admin-login-form">
          <el-form-item label="账号" prop="id">
            <el-input v-model="adminLoginForm.id"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="password">
            <el-input type="password" v-model="adminLoginForm.password"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="handleAdminLogin">登录</el-button>
            <el-button @click="showAdminLogin = false,showLogin = true">取消</el-button>
          </el-form-item>
        </el-form>
      </el-card>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        showLogin: true,
        showAdminLogin: false,
        loginForm: {
          id: '',
          password: ''
        },
        loginRules: {
          id: [{ required: true, message: '请输入账号', trigger: 'blur' }],
          password: [{ required: true, message: '请输入密码', trigger: 'blur' }]
        },
        registerForm: {
          id: '',
          username: '',
          password: ''
          
        },
        registerRules: {
          id: [{ required: true, message: '请输入账号', trigger: 'blur' }],
          password: [{ required: true, message: '请输入密码', trigger: 'blur' }],
          username: [{ required: true, message: '请输入用户名', trigger: 'blur' }]
        },
        adminLoginForm: {
          id: '',
          password: ''
        },
        adminLoginRules: {
          id: [{ required: true, message: '请输入账号', trigger: 'blur' }],
          password: [{ required: true, message: '请输入密码', trigger: 'blur' }]
        }
      }
    },
    created:function() {
        console.log('组件已创建！');
    },
    methods: {
      
      handleLogin() {
        // 处理登录逻辑
        const data = {
          id: this.loginForm.id,
          password: this.loginForm.password,
        };
        this.$http.post("/users/login", data)
            .then((response) => {
              if (response.data.msg == "登入成功") {
                console.log("登入成功");
                <el-alert
                  title="登入成功"
                  type="success"
                  show-icon>
                </el-alert>
                this.$router.push({ name: 'Home' })
              } else {
                alert("登入失败")
                console.log("登入失败");
              }
            })
            .catch((error) => {
            console.error(error);
            });
      },
      handleRegister() {
        // 处理注册逻辑
        const data = {
          id: this.registerForm.id,
          username: this.registerForm.username,
          password: this.registerForm.password,
        };
        this.$http.post("/users/register", data)
            .then((response) => {
              if (response.data) {
                console.log("注册成功");
                this.$notify({
                  title: '成功',
                  message: '注册成功',
                  type: 'success'
                });
                window.location.reload();
              } else {
                alert("注册失败")
                console.log("注册失败");
              }
            })
            .catch((error) => {
            console.error(error);
            });
      },
      handleAdminLogin() {
        this.$refs.adminLoginForm.validate(valid => {
          if (valid) {
            // 处理管理员登录逻辑
            console.log('管理员登录成功'),
            this.showLogin = false
          }
        })
      }
    }
  }
  </script>
  <style scoped>
    .login-container {
      display: flex;
      justify-content: center;
      align-items: center;
      height: 70vh;
    }
    .login-card,
    .register-card {
      width: 400px;
      margin: 0 20px;
    }
    .login-form,
    .register-form {
      margin-top: 20px;
    }
    </style>