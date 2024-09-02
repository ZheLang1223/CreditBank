<!--
  @Date: 2024/9/1
  @author: zhelang

  系统首页
-->
<template>
  <div class="common-layout">
    <el-container>
      <!-- 顶部导航栏 -->
      <el-header >
        <el-row type="flex" align="middle">
          <!-- Logo和系统名称 -->
          <el-col :span="4" class="logo-section" style="display: flex; align-items: center;">
            <img src="../assets/logo.png" alt="Logo" style="height: 40px; margin-right: 10px;"/>
            <span style="font-size: 20px; font-weight: bold;">终身学习学分银行</span>
          </el-col>

          <!-- 导航菜单 -->
          <el-col :span="16">
            <el-menu :default-active="'1'" class="el-menu-demo" mode="horizontal" @select="handleSelect"
                     style="justify-content: center;">
              <el-menu-item index="1" @click="navigateTo('/introduction')" style="margin-right: 20px;">
                <i class="el-icon-apple"></i>
                <span slot="title">首页</span>
              </el-menu-item>
              <el-menu-item index="2" @click="navigateTo('/achievement')" style="margin-right: 20px;">
                <i class="el-icon-menu"></i>
                <span slot="title">成果管理</span>
              </el-menu-item>
              <el-menu-item index="3" @click="navigateTo('/certification')" style="margin-right: 20px;">
                <i class="el-icon-menu"></i>
                <span slot="title">成果认证</span>
              </el-menu-item>
              <el-menu-item index="4" @click="navigateTo('/user')" style="margin-right: 20px;">
                <i class="el-icon-menu"></i>
                <span slot="title">用户管理</span>
              </el-menu-item>
            </el-menu>
          </el-col>

          <!-- 个人中心 -->
          <el-col :span="4" class="personal-center" style="text-align: right;">
            <el-dropdown>
          <span class="el-dropdown-link" style="cursor: pointer;">
            <i class="el-icon-user"></i>
            <span style="margin-left: 5px;">个人中心</span>
          </span>
              <el-dropdown-menu slot="dropdown">
                <el-dropdown-item @click.native="navigateTo('/userInfo')">个人信息</el-dropdown-item>
                <el-dropdown-item>退出登录</el-dropdown-item>
              </el-dropdown-menu>
            </el-dropdown>
          </el-col>
        </el-row>
      </el-header>

      <el-container>
        <!-- 侧边栏菜单 -->
<!--        <el-aside style="height: 100vh; width: 200px">-->
<!--          -->
<!--        </el-aside>-->
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
    navigateTo(path) {
      this.$router.push(path);
    },
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    }
  }
}
</script>

<style scoped>
.logo-section {
  display: flex;
  align-items: center;
}

.el-menu-demo {
  background-color: transparent;
  color: #fff;
}


</style>