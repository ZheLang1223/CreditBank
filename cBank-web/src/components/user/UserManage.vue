<template>
  <div>
    <!-- 触发弹窗的按钮 -->
    <el-button type="primary" @click="openDialog">添加用户</el-button>

    <!-- 弹窗对话框 -->
    <el-dialog title="添加用户" :visible.sync="dialogVisible" width="50%">
      <el-form :model="userForm" ref="userForm" :rules="rules" label-width="120px">
        <el-form-item label="昵称" prop="nickname">
          <el-input v-model="userForm.nickname"></el-input>
        </el-form-item>
        <el-form-item label="账号" prop="username">
          <el-input v-model="userForm.username"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input type="password" v-model="userForm.password"></el-input>
        </el-form-item>
        <el-form-item label="真实姓名" prop="realname">
          <el-input v-model="userForm.realname"></el-input>
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
          <el-input v-model="userForm.email"></el-input>
        </el-form-item>
        <el-form-item label="年龄" prop="age">
          <el-input type="number" v-model="userForm.age"></el-input>
        </el-form-item>
        <el-form-item label="性别" prop="gender">
          <el-select v-model="userForm.gender" placeholder="请选择性别">
            <el-option label="男" value="M"></el-option>
            <el-option label="女" value="F"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="电话" prop="phone">
          <el-input v-model="userForm.phone"></el-input>
        </el-form-item>
        <el-form-item label="身份" prop="role">
          <el-select v-model="userForm.role" placeholder="请选择身份">
            <el-option label="超级管理员" value="0"></el-option>
            <el-option label="管理员" value="1"></el-option>
            <el-option label="用户" value="2"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <!-- 弹窗底部的操作按钮 -->
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="submitForm">提交</el-button>
      </div>
    </el-dialog>
  </div>
</template>


<script>
import request from "@/utils/request";


export default {
  data() {
    return {
      userForm: {
        nickname: '',
        username: '',
        password: '',
        realname: '',
        email: '',
        age: null,
        gender: '',
        phone: '',
        role: '',
        joined_date: new Date().toISOString() // 初始化为当前日期时间
      }
    };
  },
  methods: {
    submitForm() {
      this.$refs.userForm.validate((valid) => {
        if (valid) {
          // 将用户数据发送到后端
          this.addUser();
        } else {
          console.log('表单验证失败');
          return false;
        }
      });
    },
    resetForm() {
      this.$refs.userForm.resetFields();
      // 重置后重新设置 joined_date 为当前时间
      this.userForm.joined_date = new Date().toISOString();
    },
    addUser() {
      // 发送 POST 请求到后端添加用户
      request.post('user/add', this.userForm).then(res => {
        console.log('用户添加成功', res);
        // 处理成功的逻辑，比如跳转页面或显示提示信息
      }).catch(error => {
        console.error('用户添加失败', error);
      });
    }
  }
}
</script>

