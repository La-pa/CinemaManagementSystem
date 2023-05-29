const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true
})

// module.exports = {
//   devServer: {
//     // host: 'localhost',  //前端ip，本地就是localhost或者127.0.0.1
//     // port: 8080,  //前端port
//     //配置代理
//     proxy: {
//       '/api':{
//           target:'localhost',
//           changeOrigin:true,
//           pathRewrite:{
//               '/api':''
//           }
//       }
//     }
//   }
// }
