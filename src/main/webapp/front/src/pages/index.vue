<template>
	<div class="main-containers">
		<div class="top-container" :style='{"boxShadow":"0 0px 0px rgba(90, 180, 80, .2)","padding":"0px","alignItems":"center","display":"flex","justifyContent":"space-between","overflow":"hidden","top":"0","left":"0","background":"url(http://codegen.caihongy.cn/20230107/dea79ac2d91b477982110bfab76bb07b.png) no-repeat center top","width":"100%","position":"relative","height":"152px","zIndex":"1002"}'>
			<img v-if='true' :style='{"width":"0px","objectFit":"cover","borderRadius":"100%","display":"block","height":"0px"}' src='http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg'>
			<div v-if="true" :style='{"margin":"0 auto","overflow":"hidden","color":"#333","textAlign":"center","left":"20%","background":"none","width":"60%","fontSize":"30px","lineHeight":"74px","position":"absolute","height":"64px"}'>基于SSM的学科竞赛全流程管理系统的设计与实现</div>
			<div>
				<div v-if="false" :style='{"color":"#333","fontSize":"16px","display":"inline-block"}'>0753-1234567</div>
				<div v-if="Token" :style='{"color":"#333","fontSize":"16px","display":"inline-block"}'>{{username}}</div>
				<el-button v-if="!Token" @click="toLogin()" :style='{"padding":"0 12px","margin":"0 0 0 10px","color":"#333","borderRadius":"2px","background":"#d3f4cf","display":"inline-block","fontSize":"14px","lineHeight":"32px","height":"32px"}'>登录/注册</el-button>
                <el-button v-if="Token" @click="logout" :style='{"padding":"0 12px","margin":"0 50px 0 10px","color":"#666","borderRadius":"2px","background":"#f4f4f5","display":"inline-block","fontSize":"14px","lineHeight":"32px","height":"32px"}'>退出</el-button>
			</div>
		</div>
		
		
		<div class="body-containers" :style='"horizontal" == "vertical" ? {"minHeight":"100vh","padding":"64px 0 0","margin":"0 0 0 210px","position":"relative","background":"rgba(64, 158, 255, .3)","display":"block"} : {"padding":"0","margin":"0","position":"relative","background":"url(http://codegen.caihongy.cn/20230108/caf263fc0a304a7a907e11691deb7ae2.jpg) fixed repeat-y"}'>
			<div class="menu-preview" :style='{"padding":"0","borderColor":"#efefef","margin":"10px 0px 2px","background":"none","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}'>
				<el-menu class="el-menu-horizontal-demo" :style='{"border":0,"padding":"0","listStyle":"none","margin":"0","flexWrap":"wrap","background":"#FFF","display":"flex","position":"relative","justifyContent":"center"}' :default-active="activeIndex" :unique-opened="true" mode="horizontal" :router="true" @select="handleSelect">
					<el-image v-if="false" :style='{"width":"44px","margin":"8px 10px 8px 0","objectFit":"cover","borderRadius":"100%","float":"left","height":"44px"}' src="http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg" fit="cover"></el-image>
					<el-menu-item v-for="(menu, index) in menuList" :index="index + ''" :key="index" :route="menu.url">
						<i v-if="false" :style='{"padding":"0 10px","margin":"0","color":"inherit","width":"14px","lineHeight":"60px","fontSize":"14px","height":"60px"}' :class="iconArr[index]"></i>
						<span :style='{"color":"inherit","fontSize":"16px"}'>{{menu.name}}</span>
					</el-menu-item>
					<el-menu-item @click="goBackend">
						<i v-if="false" :style='{"padding":"0 10px","margin":"0","color":"inherit","width":"14px","lineHeight":"60px","fontSize":"14px","height":"60px"}' class="el-icon-box"></i>
						<span :style='{"color":"inherit","fontSize":"16px"}'>后台管理</span>
					</el-menu-item>
					<el-menu-item :index="menuList.length + 2 + ''" v-if="Token && notAdmin" @click="goMenu('/index/center')">
						<i v-if="false" :style='{"padding":"0 10px","margin":"0","color":"inherit","width":"14px","lineHeight":"60px","fontSize":"14px","height":"60px"}' class="el-icon-user"></i>
						<span :style='{"color":"inherit","fontSize":"16px"}'>个人中心</span>
					</el-menu-item>
				</el-menu>
			</div>
			
			<div class="banner-preview" :style='{"width":"100%","height":"auto"}'>
				<el-carousel :style='{"width":"100%","margin":"0 auto","height":"100%"}' trigger="click" indicator-position="inside" arrow="always" type="default" direction="horizontal" height="550px" :autoplay="true" :interval="5000" :loop="true">
					<el-carousel-item :style='{"borderRadius":"0","width":"100%","height":"100%"}' v-for="item in carouselList" :key="item.id">
						<el-image :style='{"objectFit":"cover","width":"100%","height":"100%"}' :src="baseUrl + item.value" fit="cover"></el-image>
					</el-carousel-item>
				</el-carousel>
			</div>
			
			<router-view></router-view>
			
			<div class="bottom-preview" :style='{"minHeight":"200px","padding":"20px 0","borderColor":"#097523","alignItems":"center","background":"#249940","flexDirection":"column","borderWidth":"0 0 36px","display":"flex","width":"100%","borderStyle":"solid","justifyContent":"center"}'>
			    <img :style='{"width":"44px","objectFit":"cover","borderRadius":"100%","display":"none","height":"44px"}' src="http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg" >
			    <div :style='{"margin":"10px 0 0","fontSize":"14px","lineHeight":"28px","color":"#333"}'></div>
			    <div :style='{"margin":"10px 0 0","fontSize":"14px","lineHeight":"28px","color":"#333"}'></div>
			    <div :style='{"margin":"10px 0 0","fontSize":"14px","lineHeight":"28px","color":"#333"}'></div>
			</div>
		</div>
		
	</div>
</template>

<script>
import Vue from 'vue'
export default {
    data() {
		return {
            activeIndex: '0',
			roleMenus: [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-taxi","buttons":["新增","查看","修改","删除"],"menu":"教师","menuJump":"列表","tableName":"jiaoshi"}],"menu":"教师管理"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["新增","查看","修改","删除"],"menu":"学生","menuJump":"列表","tableName":"xuesheng"}],"menu":"学生管理"},{"child":[{"appFrontIcon":"cuIcon-taxi","buttons":["新增","查看","修改","删除","查看评论"],"menu":"竞赛信息","menuJump":"列表","tableName":"jingsaixinxi"}],"menu":"竞赛信息管理"},{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["查看","修改","删除","审核"],"menu":"竞赛报名","menuJump":"列表","tableName":"jingsaibaoming"}],"menu":"竞赛报名管理"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["查看","修改","删除","竞赛成绩分析"],"menu":"竞赛成绩","menuJump":"列表","tableName":"jingsaichengji"}],"menu":"竞赛成绩管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["新增","查看","修改","删除","查看评论"],"menu":"获奖展示","menuJump":"列表","tableName":"huojiangzhanshi"}],"menu":"获奖展示管理"},{"child":[{"appFrontIcon":"cuIcon-link","buttons":["新增","查看","修改","删除"],"menu":"规则通知","menuJump":"列表","tableName":"guizetongzhi"}],"menu":"规则通知管理"},{"child":[{"appFrontIcon":"cuIcon-vipcard","buttons":["新增","查看","修改","删除","竞赛经费分析"],"menu":"竞赛经费","menuJump":"列表","tableName":"jingsaijingfei"}],"menu":"竞赛经费管理"},{"child":[{"appFrontIcon":"cuIcon-copy","buttons":["新增","查看","修改","删除"],"menu":"模拟训练管理","tableName":"exampaper"}],"menu":"模拟训练管理"},{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["新增","查看","修改","删除"],"menu":"试题管理","tableName":"examquestion"}],"menu":"试题管理"},{"child":[{"appFrontIcon":"cuIcon-pay","buttons":["新增","查看","修改","删除"],"menu":"管理员","tableName":"users"}],"menu":"管理员管理"},{"child":[{"appFrontIcon":"cuIcon-medal","buttons":["新增","查看","修改","删除"],"menu":"轮播图管理","tableName":"config"}],"menu":"系统管理"},{"child":[{"appFrontIcon":"cuIcon-list","buttons":["查看","修改","删除"],"menu":"错题本","tableName":"examfailrecord"},{"appFrontIcon":"cuIcon-baby","buttons":["新增","查看","修改","删除"],"menu":"模拟训练列表","tableName":"exampaperlist"},{"appFrontIcon":"cuIcon-addressbook","buttons":["查看","修改","删除"],"menu":"考试记录","tableName":"examrecord"}],"menu":"考试管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["查看","报名"],"menu":"竞赛信息列表","menuJump":"列表","tableName":"jingsaixinxi"}],"menu":"竞赛信息模块"},{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["查看"],"menu":"规则通知列表","menuJump":"列表","tableName":"guizetongzhi"}],"menu":"规则通知模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-time","buttons":["新增","查看","修改","删除","竞赛成绩分析"],"menu":"竞赛成绩","menuJump":"列表","tableName":"jingsaichengji"}],"menu":"竞赛成绩管理"},{"child":[{"appFrontIcon":"cuIcon-link","buttons":["新增","查看","修改","删除"],"menu":"规则通知","menuJump":"列表","tableName":"guizetongzhi"}],"menu":"规则通知管理"},{"child":[{"appFrontIcon":"cuIcon-copy","buttons":["新增","查看","修改","删除"],"menu":"模拟训练管理","tableName":"exampaper"}],"menu":"模拟训练管理"},{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["新增","查看","修改","删除"],"menu":"试题管理","tableName":"examquestion"}],"menu":"试题管理"},{"child":[{"appFrontIcon":"cuIcon-addressbook","buttons":["查看","修改","删除"],"menu":"考试记录","tableName":"examrecord"},{"appFrontIcon":"cuIcon-list","buttons":["查看","修改","删除"],"menu":"错题本","tableName":"examfailrecord"},{"appFrontIcon":"cuIcon-baby","buttons":["新增","查看","修改","删除"],"menu":"模拟训练列表","tableName":"exampaperlist"}],"menu":"考试管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["查看","报名"],"menu":"竞赛信息列表","menuJump":"列表","tableName":"jingsaixinxi"}],"menu":"竞赛信息模块"},{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["查看"],"menu":"规则通知列表","menuJump":"列表","tableName":"guizetongzhi"}],"menu":"规则通知模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"否","roleName":"教师","tableName":"jiaoshi"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["查看"],"menu":"竞赛报名","menuJump":"列表","tableName":"jingsaibaoming"}],"menu":"竞赛报名管理"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["查看"],"menu":"竞赛成绩","menuJump":"列表","tableName":"jingsaichengji"}],"menu":"竞赛成绩管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["查看","报名"],"menu":"竞赛信息列表","menuJump":"列表","tableName":"jingsaixinxi"}],"menu":"竞赛信息模块"},{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["查看"],"menu":"规则通知列表","menuJump":"列表","tableName":"guizetongzhi"}],"menu":"规则通知模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"学生","tableName":"xuesheng"}],
			baseUrl: '',
			carouselList: [],
			menuList: [],
			form: {
				ask: '',
				userid: localStorage.getItem('userid')
			},
			Token: localStorage.getItem('Token'),
            username: localStorage.getItem('username'),
            notAdmin: localStorage.getItem('sessionTable')!='"users"',
			timer: '',
			iconArr: [
				'el-icon-star-off',
				'el-icon-goods',
				'el-icon-warning',
				'el-icon-question',
				'el-icon-info',
				'el-icon-help',
				'el-icon-picture-outline-round',
				'el-icon-camera-solid',
				'el-icon-video-camera-solid',
				'el-icon-video-camera',
				'el-icon-bell',
				'el-icon-s-cooperation',
				'el-icon-s-order',
				'el-icon-s-platform',
				'el-icon-s-operation',
				'el-icon-s-promotion',
				'el-icon-s-release',
				'el-icon-s-ticket',
				'el-icon-s-management',
				'el-icon-s-open',
				'el-icon-s-shop',
				'el-icon-s-marketing',
				'el-icon-s-flag',
				'el-icon-s-comment',
				'el-icon-s-finance',
				'el-icon-s-claim',
				'el-icon-s-opportunity',
				'el-icon-s-data',
				'el-icon-s-check'
			],	
		}
    },
    created() {
		this.baseUrl = this.$config.baseUrl;
		this.menuList = this.$config.indexNav;
		this.getCarousel();
    },
    mounted() {
        this.activeIndex = localStorage.getItem('keyPath') || '0';
    },
    watch: {
        $route(newValue) {
            let that = this
            let url = window.location.href
            let arr = url.split('#')
            for (let x in this.menuList) {
                if (newValue.path == this.menuList[x].url) {
                    this.activeIndex = x
                }
            }
            this.Token = localStorage.getItem('Token')
        },
    },
    methods: {
        handleSelect(keyPath) {
            if (keyPath) {
                localStorage.setItem('keyPath', keyPath)
            }
        },
		toLogin() {
		  this.$router.push('/login');
		},
        logout() {
            localStorage.clear();
            Vue.http.headers.common['Token'] = "";
            this.$router.push('/index/home');
            this.activeIndex = '0'
            localStorage.setItem('keyPath', this.activeIndex)
            this.Token = ''
            this.$forceUpdate()
            this.$message({
                message: '登出成功',
                type: 'success',
                duration: 1000,
            });
        },
		getCarousel() {
			this.$http.get('config/list', {params: { page: 1, limit: 3 }}).then(res => {
				if (res.data.code == 0) {
					this.carouselList = res.data.data.list;
				}
			});
		},
		goBackend() {
			window.open(`${this.$config.baseUrl}admin/dist/index.html`, "_blank");
		},
		goMenu(path) {
            if (!localStorage.getItem('Token')) {
                this.toLogin();
            } else {
                this.$router.push(path);
            }
		},
    }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.menu-preview {
	  .el-scrollbar {
	    height: 100%;
	
	    & /deep/ .scrollbar-wrapper {
	      overflow-x: hidden;
	    }
	  }
	}
	
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item {
		cursor: pointer;
		border: 0;
		padding: 0 20px;
		color: #5a1f7d;
		background: #fff;
		font-weight: 600;
		display: flex;
		font-size: 16px;
		line-height: 66px;
		align-items: center;
		position: relative;
		height: 66px;
	}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item:hover {
		cursor: pointer;
		padding: 0 20px;
		color: #5a1f7d;
		background: url(http://codegen.caihongy.cn/20230107/2cb7bee027e741cc91256a809511e024.png) no-repeat center bottom / 100% auto;
		font-size: 16px;
		line-height: 66px;
		height: 66px;
	}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item.is-active {
		cursor: pointer;
		border: 0;
		padding: 0 20px;
		color: #5a1f7d;
		background: url(http://codegen.caihongy.cn/20230107/2cb7bee027e741cc91256a809511e024.png) no-repeat center bottom / 100% auto;
		font-size: 16px;
		line-height: 66px;
		height: 66px;
	}
	
	.banner-preview {
	  .el-carousel /deep/ .el-carousel__indicator button {
	    width: 0;
	    height: 0;
	    display: none;
	  }
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left {
		background: rgba(0,0,0,.2);
		width: 36px;
		font-size: 12px;
		height: 36px;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left:hover {
		background: red;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right {
		background: rgba(0,0,0,.2);
		width: 36px;
		font-size: 12px;
		height: 36px;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right:hover {
		background: red;
	}

	.banner-preview .el-carousel /deep/ .el-carousel__indicators {
		z-index: 2;
		top: -35px;
		width: 100%;
		position: relative;
		list-style: none;
		text-align: center;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__indicators li {
		border-radius: 10px;
		padding: 0;
		margin: 0 4px;
		background: rgba(255,255,255,.5);
		display: inline-block;
		width: 12px;
		opacity: 0.4;
		transition: 0.3s;
		height: 12px;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__indicators li:hover {
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 24px;
		opacity: 1;
		height: 12px;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__indicators li.is-active {
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 24px;
		opacity: 1;
		height: 12px;
	}

    .chat-content {
      .left-content {
          width: 100%;
          text-align: left;
      }
      .right-content {
          width: 100%;
          text-align: right;
      }
    }
</style>
