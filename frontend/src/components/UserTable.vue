<template>
    <div>
        <el-table
        :data="tableData"
        style="width: 100%">
        <el-table-column
            prop="id"
            label="编号">
        </el-table-column>
        <el-table-column
            prop="username"
            label="姓名">
        </el-table-column>
        <el-table-column
            prop="password"
            label="密码">
        </el-table-column>
        </el-table>
    </div>
  </template>

  <script>
  export default {
      data() {
        return {
          tableData: []
        }
      },
      created: function() {
        console.log("组件被创建")
      },
      mounted: function () {
        this.$http.get("/users").then((response) => {

            console.log(response.data)
            this.tableData = response.data.data
        }).catch((error) => {
            // alert("nihao")
            console.log(error)
        })
      }
    }
  </script>