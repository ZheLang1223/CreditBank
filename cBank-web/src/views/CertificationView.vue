<template>
  <div>
    <el-input v-model="searchQuery" placeholder="输入关键词" style="width: 300px; margin-bottom: 20px;"></el-input>
    <el-button type="primary" @click="searchCertifications">查询</el-button>

    <!-- 下拉菜单 -->
    <el-tabs v-model="first" >
      <el-tab-pane label="用户管理" name="first">用户管理</el-tab-pane>
      <el-tab-pane label="配置管理" name="second">配置管理</el-tab-pane>
      <el-tab-pane label="角色管理" name="third">角色管理</el-tab-pane>
      <el-tab-pane label="定时任务补偿" name="fourth">定时任务补偿</el-tab-pane>
    </el-tabs>
    <!-- 认证记录展示 -->
    <el-table :data="certificationData" style="width: 100%; margin-top: 20px;">
      <el-table-column prop="id" label="ID" width="80"></el-table-column>
      <el-table-column prop="achievement_name" label="成果名称"></el-table-column>
      <el-table-column prop="applicant_id" label="申请人ID"></el-table-column>
      <el-table-column prop="reviewer_id" label="审核人ID"></el-table-column>
      <el-table-column prop="application_date" label="申请日期"></el-table-column>
      <el-table-column prop="review_date" label="审核日期"></el-table-column>
      <el-table-column prop="status" label="认证状态"></el-table-column>
      <el-table-column prop="remark" label="备注"></el-table-column>
    </el-table>
  </div>
</template>

<script>
import request from '@/utils/request'; // 假设你有一个配置好的 axios 实例

export default {
  data() {
    return {
      searchQuery: '', // 用户输入的查询条件
      certificationData: [] // 存储认证数据
    };
  },
  methods: {
    searchCertifications() {
      // 发送请求到后端，根据查询条件搜索认证记录
      request.get('/certification/search', {
        params:{
          achievementName: this.searchQuery,
        },
      }).then(res => {
        if (res && res.data) {
          this.certificationData = res.data; // 将返回的认证数据存储在 certificationData 中
          console.log(res.data);
        }
      }).catch(error => {
        console.error('查询认证记录失败:', error);
      });
    }
  },
  mounted() {
    // 页面加载时，获取所有认证记录
    this.searchCertifications();
  }
}
</script>
