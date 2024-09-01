<!--
  @Date: 2024/9/1
  @author: zhelang

  系统首页
-->
<template>
  <div class="common-layout">
    <el-container>
      <!-- 侧边栏菜单 -->
      <el-aside style="height: 100vh; width: 200px">
          <el-menu
              default-active="2"
              class="el-menu-vertical-demo"
              style="height: 100vh"
              @open="handleOpen"
              @close="handleClose"
              background-color="#545c64"
              text-color="#fff"
              active-text-color="#ffd04b">
            <el-menu-item>
              <i class="el-icon-apple"></i>
              <span slot="title">首页</span>
            </el-menu-item>
            <el-menu-item index="2">
              <i class="el-icon-menu"></i>
              <span slot="title">导航二</span>
            </el-menu-item>

          </el-menu>
      </el-aside>

      <el-container>
        <!-- 标头 -->
        <el-header>
          <h3>标头</h3>
        </el-header>
        <!-- 主要内容 -->
        <el-main>

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
    }
  }
}
</script>

<style scoped>

</style>