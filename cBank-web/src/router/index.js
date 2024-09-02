
import VueRouter from 'vue-router';
import bankIntroduction from "@/components/introduction/BankIntroduction.vue";
import achievementManagement from "@/components/achievement/AchievementManage.vue";
import users from "@/components/user/Users.vue";
import userView from "@/views/UserView.vue";

const routes = [
    {
        path:'/', name:'Home',
        component:()=>import('../views/Home.vue'),
        children:[
            {
                path:'/introduction', name: 'introduction',
                component: bankIntroduction
            },
            {   // 菜单成果管理
                path:'/achievementManagement', name: 'AchievementManagement',
                component: achievementManagement
            },
            {
                path:'user', name: 'user',
                component: userView
            }
        ]
    },
    {   // 测试一下是否可以展示用户的数据
        path: '/users', name: 'Users',
        component: users
    }


    // {
    //     path:'/Index',
    //     name:'IndexPage',
    //     component:()=>import('../components/IndexPage'),
    //     children:[
    //         {
    //             path:'/Home',
    //             name:'HomePage',
    //             meta:{
    //                 title:'首页'
    //             },
    //             component:()=>import('../components/HomePage')
    //         },
    //         /*{
    //             path:'/Admin',
    //             name:'admin',
    //             meta:{
    //                 title:'管理员管理'
    //             },
    //             component:()=>import('../components/admin/AdminManage.vue')
    //         },
    //         {
    //             path:'/User',
    //             name:'user',
    //             meta:{
    //                 title:'用户管理'
    //             },
    //             component:()=>import('../components/user/UserManage.vue')
    //         },*/
    //     ]
    // }
]

const router = new VueRouter({
    mode:'history',
    routes
})

export function resetRouter() {
    router.matcher = new VueRouter({
        mode:'history',
        routes: []
    }).matcher
}
const VueRouterPush = VueRouter.prototype.push
VueRouter.prototype.push = function push (to) {
    return VueRouterPush.call(this, to).catch(err => err)
}
export  default router;