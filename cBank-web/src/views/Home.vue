<!--
  @Date: 2024/9/1
  @author: zhelang

  系统首页
-->
<template>
  <div class="common-layout">
    <el-container>
      <el-header>
        <el-row type="flex" justify="space-between" align="middle">
          <el-col :span="1"></el-col>
          <el-col :span="3">终身学习学分银行</el-col>
          <el-col :span="18">
            <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
              <el-menu-item index="1" @click="navigateTo('/introduction')">
                <i class="el-icon-apple"></i>
                <span slot="title">首页</span>
              </el-menu-item>
              <el-menu-item index="3" @click="navigateTo('/achievementManagement')">
                <i class="el-icon-menu"></i>
                <span slot="title">Admin成果管理</span>
              </el-menu-item>
              <el-menu-item index="2">
                <i class="el-icon-menu"></i>
                <span slot="title">成果认证</span>
              </el-menu-item>
            </el-menu>
          </el-col>
          <el-col :span="2">个人中心</el-col>
        </el-row>
      </el-header>

      <el-container>
        <!-- 侧边栏菜单 -->
        <el-aside style="height: 100vh; width: 200px">
          <el-menu
              default-active="2"
              class="el-menu-vertical-demo"
              style="height: 100vh"
              @open="handleOpen"
              @close="handleClose"
              active-text-color="#ffd04b">
            <el-menu-item index="1">处理中心</el-menu-item>
            <el-submenu index="2">
              <template slot="title">我的工作台</template>
              <el-menu-item index="2-1">选项1</el-menu-item>
              <el-menu-item index="2-2">选项2</el-menu-item>
              <el-menu-item index="2-3">选项3</el-menu-item>
              <el-submenu index="2-4">
                <template slot="title">选项4</template>
                <el-menu-item index="2-4-1">选项1</el-menu-item>
                <el-menu-item index="2-4-2">选项2</el-menu-item>
                <el-menu-item index="2-4-3">选项3</el-menu-item>
              </el-submenu>
            </el-submenu>
            <el-menu-item index="3" disabled>消息中心</el-menu-item>
            <el-menu-item index="4"><a href="https://www.ele.me" target="_blank">订单管理</a></el-menu-item>
          </el-menu>
        </el-aside>
        <!-- 主要内容 -->
        <el-main>
          <!-- 介绍面板 -->
          <router-view/>
        </el-main>
      </el-container>
    </el-container>

  </div>
</template>

<script>
export default {
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    },
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    },
    navigateTo(path) {
      this.$router.push(path);  // 跳转到指定路径
    }

  }
}


</script>

<style scoped>

</style>