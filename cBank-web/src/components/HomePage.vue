<template>
    <div class="homePage-class">
        <el-descriptions  title="个人中心" :column="2" size="medium" border>
            <el-descriptions-item>
                <template slot="label">
                    <i class="el-icon-s-custom"></i>
                    <span> 账号</span>
                </template>
                <p>{{user.no}}</p>
            </el-descriptions-item>
            <el-descriptions-item>
                <template slot="label">
                    <i class="el-icon-mobile-phone"></i>
                    <span> 电话</span>
                </template>
                {{user.phone}}
            </el-descriptions-item>
            <el-descriptions-item>
                <template slot="label">
                    <i class="el-icon-location-outline"></i>
                    <span> 性别</span>
                </template>
                <el-tag
                        :type="user.sex === '1' ? 'primary' : 'danger'"
                        disable-transitions>
                  <i :class="user.sex === 1 ? 'el-icon-male' : 'el-icon-female'"></i>
                  {{user.sex===1?"男":"女"}}
                </el-tag>
            </el-descriptions-item>
            <el-descriptions-item>
                <template slot="label">
                    <i class="el-icon-tickets"></i>
                    <span> 角色</span>
                </template>
                <el-tag
                        type="success"
                        disable-transitions>
                  {{user.roleId === 0 ? "超级管理员" : (user.roleId === 1 ? "管理员" : "用户")}}
                </el-tag>
            </el-descriptions-item>
        </el-descriptions>

        <DateUtils></DateUtils>
    </div>
</template>

<script>
    import DateUtils from "./DateUtils";
    export default {
        name: "HomePage",
        components: {DateUtils},
        data() {
            return {
                user:{}
            }
        },
        computed:{

        },
        methods:{
            init(){
                this.user = JSON.parse(sessionStorage.getItem('CurUser'))
            }
        },
        created(){
            this.init()
        }
    }
</script>

<style scoped>
    .el-descriptions{
        width:90%;

        margin: 0 auto;
        text-align: center;
    }
    .homePage-class{
      text-align: center;
      background-color: #f1f1f3;
      height: 100%;
      padding: 0;
      margin: 0;
    }

</style>