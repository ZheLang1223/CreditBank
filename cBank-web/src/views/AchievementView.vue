<template>
  <div>
    <el-input v-model="searchQuery" placeholder="输入成就名称查询" style="width: 300px; margin-bottom: 20px;"></el-input>
    <el-button type="primary" @click="searchAchievements">查询</el-button>

    <el-table :data="achievementData" style="width: 100%; margin-top: 20px;">
      <el-table-column prop="id" label="ID" width="80"></el-table-column>
      <el-table-column prop="name" label="成就名称"></el-table-column>
      <el-table-column prop="description" label="成就描述"></el-table-column>
      <el-table-column prop="type" label="成就类型"></el-table-column>
      <el-table-column prop="credits" label="学分" width="100"></el-table-column>
      <el-table-column prop="created_date" label="创建时间"></el-table-column>
      <el-table-column prop="status" label="状态"></el-table-column>
      <el-table-column prop="level" label="等级"></el-table-column>
    </el-table>
  </div>
</template>

<script>
import request from '@/utils/request'; // 假设你有一个配置好的 axios 实例

export default {
  data() {
    return {
      searchQuery: '', // 用户输入的查询条件
      achievementData: [] // 存储成就数据
    };
  },
  methods: {
    searchAchievements() {
      // 发送请求到后端，根据查询条件搜索成就记录
      request.get('/achievement/list', {
        params: {
          name: this.searchQuery // 将查询条件作为参数发送到后端
        }
      }).then(res => {
        if (res && res.data) {
          this.achievementData = res.data; // 将返回的成就数据存储在 achievementData 中
          console.log(res.data);
        }
      }).catch(error => {
        console.error('查询成就记录失败:', error);
      });
    }
  },
  mounted() {
    // 页面加载时，获取所有成就记录
    this.searchAchievements();
  }
}
</script>
