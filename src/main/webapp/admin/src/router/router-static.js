import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
import adminexam from '@/views/modules/exampaperlist/exam'
    import examfailrecord from '@/views/modules/examfailrecord/list'
    import jingsaichengji from '@/views/modules/jingsaichengji/list'
    import jingsaixinxi from '@/views/modules/jingsaixinxi/list'
    import xuesheng from '@/views/modules/xuesheng/list'
    import examquestion from '@/views/modules/examquestion/list'
    import jingsaibaoming from '@/views/modules/jingsaibaoming/list'
    import jiaoshi from '@/views/modules/jiaoshi/list'
    import guizetongzhi from '@/views/modules/guizetongzhi/list'
    import exampaper from '@/views/modules/exampaper/list'
    import discusshuojiangzhanshi from '@/views/modules/discusshuojiangzhanshi/list'
    import users from '@/views/modules/users/list'
    import exampaperlist from '@/views/modules/exampaperlist/list'
    import discussjingsaixinxi from '@/views/modules/discussjingsaixinxi/list'
    import huojiangzhanshi from '@/views/modules/huojiangzhanshi/list'
    import jingsaijingfei from '@/views/modules/jingsaijingfei/list'
    import config from '@/views/modules/config/list'
    import examrecord from '@/views/modules/examrecord/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/examfailrecord',
        name: '错题本',
        component: examfailrecord
      }
      ,{
	path: '/jingsaichengji',
        name: '竞赛成绩',
        component: jingsaichengji
      }
      ,{
	path: '/jingsaixinxi',
        name: '竞赛信息',
        component: jingsaixinxi
      }
      ,{
	path: '/xuesheng',
        name: '学生',
        component: xuesheng
      }
      ,{
	path: '/examquestion',
        name: '试题管理',
        component: examquestion
      }
      ,{
	path: '/jingsaibaoming',
        name: '竞赛报名',
        component: jingsaibaoming
      }
      ,{
	path: '/jiaoshi',
        name: '教师',
        component: jiaoshi
      }
      ,{
	path: '/guizetongzhi',
        name: '规则通知',
        component: guizetongzhi
      }
      ,{
	path: '/exampaper',
        name: '模拟训练管理',
        component: exampaper
      }
      ,{
	path: '/discusshuojiangzhanshi',
        name: '获奖展示评论',
        component: discusshuojiangzhanshi
      }
      ,{
	path: '/users',
        name: '管理员',
        component: users
      }
      ,{
	path: '/exampaperlist',
        name: '模拟训练列表',
        component: exampaperlist
      }
      ,{
	path: '/discussjingsaixinxi',
        name: '竞赛信息评论',
        component: discussjingsaixinxi
      }
      ,{
	path: '/huojiangzhanshi',
        name: '获奖展示',
        component: huojiangzhanshi
      }
      ,{
	path: '/jingsaijingfei',
        name: '竞赛经费',
        component: jingsaijingfei
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
      ,{
	path: '/examrecord',
        name: '考试记录',
        component: examrecord
      }
    ]
  },
  {
    path: '/adminexam',
    name: 'adminexam',
    component: adminexam,
    meta: {icon:'', title:'adminexam'}
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '系统首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
