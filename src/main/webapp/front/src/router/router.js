import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import ExamPaper from '../pages/exam/examPaper'
import Exam from '../pages/exam/exam'
import ExamList from '../pages/exam/examList'
import ExamRecord from '../pages/exam/examRecord'
import Storeup from '../pages/storeup/list'
import jiaoshiList from '../pages/jiaoshi/list'
import jiaoshiDetail from '../pages/jiaoshi/detail'
import jiaoshiAdd from '../pages/jiaoshi/add'
import xueshengList from '../pages/xuesheng/list'
import xueshengDetail from '../pages/xuesheng/detail'
import xueshengAdd from '../pages/xuesheng/add'
import jingsaixinxiList from '../pages/jingsaixinxi/list'
import jingsaixinxiDetail from '../pages/jingsaixinxi/detail'
import jingsaixinxiAdd from '../pages/jingsaixinxi/add'
import jingsaibaomingList from '../pages/jingsaibaoming/list'
import jingsaibaomingDetail from '../pages/jingsaibaoming/detail'
import jingsaibaomingAdd from '../pages/jingsaibaoming/add'
import jingsaichengjiList from '../pages/jingsaichengji/list'
import jingsaichengjiDetail from '../pages/jingsaichengji/detail'
import jingsaichengjiAdd from '../pages/jingsaichengji/add'
import huojiangzhanshiList from '../pages/huojiangzhanshi/list'
import huojiangzhanshiDetail from '../pages/huojiangzhanshi/detail'
import huojiangzhanshiAdd from '../pages/huojiangzhanshi/add'
import guizetongzhiList from '../pages/guizetongzhi/list'
import guizetongzhiDetail from '../pages/guizetongzhi/detail'
import guizetongzhiAdd from '../pages/guizetongzhi/add'
import jingsaijingfeiList from '../pages/jingsaijingfei/list'
import jingsaijingfeiDetail from '../pages/jingsaijingfei/detail'
import jingsaijingfeiAdd from '../pages/jingsaijingfei/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'examPaper',
					component: ExamPaper
				},
				{
					path: 'examList',
					component:ExamList
				},
				{
					path: 'examRecord/:type',
					component:ExamRecord
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'jiaoshi',
					component: jiaoshiList
				},
				{
					path: 'jiaoshiDetail',
					component: jiaoshiDetail
				},
				{
					path: 'jiaoshiAdd',
					component: jiaoshiAdd
				},
				{
					path: 'xuesheng',
					component: xueshengList
				},
				{
					path: 'xueshengDetail',
					component: xueshengDetail
				},
				{
					path: 'xueshengAdd',
					component: xueshengAdd
				},
				{
					path: 'jingsaixinxi',
					component: jingsaixinxiList
				},
				{
					path: 'jingsaixinxiDetail',
					component: jingsaixinxiDetail
				},
				{
					path: 'jingsaixinxiAdd',
					component: jingsaixinxiAdd
				},
				{
					path: 'jingsaibaoming',
					component: jingsaibaomingList
				},
				{
					path: 'jingsaibaomingDetail',
					component: jingsaibaomingDetail
				},
				{
					path: 'jingsaibaomingAdd',
					component: jingsaibaomingAdd
				},
				{
					path: 'jingsaichengji',
					component: jingsaichengjiList
				},
				{
					path: 'jingsaichengjiDetail',
					component: jingsaichengjiDetail
				},
				{
					path: 'jingsaichengjiAdd',
					component: jingsaichengjiAdd
				},
				{
					path: 'huojiangzhanshi',
					component: huojiangzhanshiList
				},
				{
					path: 'huojiangzhanshiDetail',
					component: huojiangzhanshiDetail
				},
				{
					path: 'huojiangzhanshiAdd',
					component: huojiangzhanshiAdd
				},
				{
					path: 'guizetongzhi',
					component: guizetongzhiList
				},
				{
					path: 'guizetongzhiDetail',
					component: guizetongzhiDetail
				},
				{
					path: 'guizetongzhiAdd',
					component: guizetongzhiAdd
				},
				{
					path: 'jingsaijingfei',
					component: jingsaijingfeiList
				},
				{
					path: 'jingsaijingfeiDetail',
					component: jingsaijingfeiDetail
				},
				{
					path: 'jingsaijingfeiAdd',
					component: jingsaijingfeiAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
		{
			path: '/exam',
			component: Exam
		}
	]
})
