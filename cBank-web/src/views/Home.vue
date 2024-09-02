<!--
  @Date: 2024/9/1
  @author: zhelang

  系统首页
-->
<template>
  <div class="common-layout">
    <el-container>
      <!-- 顶部导航栏 -->
      <el-header>
        <el-row type="flex" align="middle">
          <el-col :span="1"></el-col>
          <el-col :span="3">终身学习学分银行</el-col>
          <el-col :span="18">
            <el-menu :default-active="'1'" class="el-menu-demo" mode="horizontal" @select="handleSelect">
              <el-menu-item index="1" @click="navigateTo('/introduction')">
                <i class="el-icon-apple"></i>
                <span slot="title">首页</span>
              </el-menu-item>
              <el-menu-item index="2" @click="navigateTo('/achievementManagement')">
                <i class="el-icon-menu"></i>
                <span slot="title">成果管理</span>
              </el-menu-item>
              <el-menu-item index="3">
                <i class="el-icon-menu"></i>
                <span slot="title">成果认证（未完成）</span>
              </el-menu-item>
              <el-menu-item index="4" @click="navigateTo('/user')">
                <i class="el-icon-menu"></i>
                <span slot="title">用户管理</span>
              </el-menu-item>
            </el-menu>
          </el-col>
          <el-col :span="2">个人中心</el-col>
        </el-row>
      </el-header>

      <el-container>
        <!-- 侧边栏菜单：还没修改呢 -->
        <el-aside style="height: 100vh; width: 200px">
          <el-menu
              default-active="2"
              class="el-menu-vertical-demo"
              style="height: 100vh"
              @open="handleOpen"
              @close="handleClose"
              active-text-color="#ffd04b">
            <el-menu-item index="1">处理中心</el-menu-item>
            <el-menu-item index="3" disabled>消息中心</el-menu-item>
            <el-menu-item index="4"><a href="https://www.ele.me" target="_blank">订单管理</a></el-menu-item>
          </el-menu>
        </el-aside>
        <!-- 页面主要内容 -->
        <el-main>
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
    },
    data () {
      return {
        activeIndex: '1'
      }
    }
  }
}


</script>

<style scoped>

</style>