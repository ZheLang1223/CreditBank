
import VueRouter from 'vue-router';
import bankIntroduction from "@/components/introduction/BankIntroduction.vue";
import userView from "@/views/UserView.vue";
import achievementView from "@/views/AchievementView.vue";
import certificationView from "@/views/CertificationView.vue";


const routes = [
    {
        path:'/', name:'Home',
        component:()=>import('../views/Home.vue'),
        children:[
            {
                path:'/introduction', name: 'introduction',
                component: bankIntroduction
            },
            {   // 成果
                path:'/achievement', name: 'achievement',
                component: achievementView
            },
            {
                path:'/user', name: 'user',
                component: userView
            },
            {
                path: '/certification', name: 'certification',
                component: certificationView
            }
        ]
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