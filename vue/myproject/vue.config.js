const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: ['vue-cookies'],
  // transpileDependencies: true,
  devServer: {
    // proxy: {
    //   '/movies': {
    //     target: 'http://8.130.82.226:9090',
    //     changeOrigin: true
    //   },
    //   '/users': {
    //     target: 'http://8.130.82.226:9090',
    //     changeOrigin: true,
    //   }
    // }
      proxy: 'http://8.130.82.226:9090'
     
  }
})
