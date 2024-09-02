<template>
  <div>
    <el-input v-model="input" placeholder="请输入内容" style="width: 180px; margin-right: 10px"></el-input>
    <el-button @click="search" type="primary">搜索</el-button>

    <!-- 用户信息表格 -->
    <el-table :data="tableData" style="width: 100%">
      <el-table-column prop="date" label="日期" width="180">
      </el-table-column>
      <el-table-column prop="name" label="姓名" width="180">
      </el-table-column>
      <el-table-column prop="email" label="邮箱" width="180">
      </el-table-column>
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
  </div>
</template>

<script>
import request from "@/utils/request";

export default {
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
      request.get('user/list').then(res=>{
        console.log(res)
      });
    }
  },
  data() {
    return {
      input:'',
      tableData: [{
        date: '2024-8-1',
        name: '折浪',
        email: '1664890190@qq.com'
      },{
        date: '2024-8-1',
        name: '折浪',
        email: '1664890190@qq.com'
      },{
        date: '2024-8-1',
        name: '折浪',
        email: '1664890190@qq.com'
      },{
        date: '2024-8-1',
        name: '折浪',
        email: '1664890190@qq.com'
      },{
        date: '2024-8-1',
        name: '折浪',
        email: '1664890190@qq.com'
      }
      ],
      currentPage1: 5,
      currentPage2: 5,
      currentPage3: 5,
      currentPage4: 4
    }
  }
}
</script>