<template>
  <div>
    <el-input v-model="name" placeholder="输入关键词" @change="search" style="width: 180px; margin-right: 10px"></el-input>
    <el-button type="primary" @click="search">搜索</el-button>
    <el-button type="primary" @click="add">添加用户</el-button>

    <!-- 用户信息表格 -->
    <el-table :data="tableData" style="width: 100%">
        <el-table-column prop="id" label="ID" width="80"></el-table-column>
        <el-table-column prop="username" label="账号"></el-table-column>
        <el-table-column prop="nickname" label="昵称"></el-table-column>
        <el-table-column prop="realname" label="真实姓名"></el-table-column>
<!--        <el-table-column prop="email" label="邮箱"></el-table-column>-->
        <el-table-column prop="age" label="年龄"></el-table-column>
        <el-table-column prop="gender" label="性别"></el-table-column>
        <el-table-column prop="phone" label="电话"></el-table-column>
<!--        <el-table-column prop="role" label="身份"></el-table-column>-->
        <el-table-column prop="joined_date" label="加入日期"></el-table-column>
<!--        <el-table-column prop="status" label="状态"></el-table-column>-->
      <el-table-column label="操作">
        <el-button type="success">编辑</el-button>
        <el-button type="danger">删除</el-button>
      </el-table-column>
    </el-table>

    <!-- 分页管理 -->
    <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="currentPage3"
        :page-sizes="[100, 200, 300, 400]"
        :page-size="100"
        layout="total, sizes, prev, pager, next, jumper"
        :total="400">
    </el-pagination>

<!--    <user-manage></user-manage>-->
  </div>
</template>

<script>
import request from "@/utils/request";
// import UserManage from "@/components/user1/UserManage.vue";

export default {
  // components: {UserManage},
  methods: {
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
    },
    // 发送请求访问后端查询用户信息
    search() {
      console.log("点击搜索");
      console.log(this.name);
      let params={
        realname:this.name
      }
      request.get('/user/search',{params}).then(res=>{
        if(res && res.data){
          this.tableData = res.data;  // 返回的数据是用户列表
        }
        console.log(res)
      });
    },
    // 点击添加，填写表单以添加用户
    add() {

    }
  },
  data() {
    return {
      input:'',
      name:"",
      tableData: [],
      currentPage1: 5,
      currentPage2: 5,
      currentPage3: 5,
      currentPage4: 4
    }
  }
}
</script>