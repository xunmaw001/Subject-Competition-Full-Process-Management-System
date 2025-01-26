<template>
<div class="home-preview" :style='{"width":"100%","margin":"0px auto","flexWrap":"wrap","justifyContent":"center","display":"flex"}'>






<div class="lists" :style='{"width":"100%","margin":"0px auto","textAlign":"center","background":"url(http://codegen.caihongy.cn/20230108/caf263fc0a304a7a907e11691deb7ae2.jpg) repeat-y","display":"block"}'>
	<div v-if="false" class="idea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
		<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
	<div class="title" :style='{"width":"100%","margin":"30px auto 50px","lineHeight":"52px","textAlign":"center","background":"url(http://codegen.caihongy.cn/20230108/7c8f15334365458b8ec1c7beedb0d8f4.png) no-repeat center bottom"}'>
	  <span :style='{"padding":"0 4px 0 20px","fontSize":"20px","lineHeight":"52px","color":"#249940"}'>竞赛信息展示</span>
	</div>
	
	
	
	
	
	
	<!-- 样式五 -->
	<div class="list list5 index-pv1">
		<div id="lists-five-swiperjingsaixinxi" class="swiper-container lists-five-swiper" :style='{"width":"100%","padding":"80px 10px","margin":"0","background":"none"}'>
			<div class="swiper-wrapper">
				<div :style='{"border":"0","cursor":"pointer","borderRadius":"8px","background":"#fff","width":"320px","fontSize":"0","position":"relative","height":"240px"}' class="swiper-slide" v-for="(item,index) in jingsaixinxiList" :key="index" @click="toDetail('jingsaixinxiDetail', item)">
					<img :style='{"border":"4px solid #d0d0d0","width":"320px","borderRadius":"4px","background":"#fff","height":"240px"}' v-if="preHttp(item.jingsaitupian)" :src="item.jingsaitupian.split(',')[0]" alt="" />
					<img :style='{"border":"4px solid #d0d0d0","width":"320px","borderRadius":"4px","background":"#fff","height":"240px"}' v-else :src="baseUrl + (item.jingsaitupian?item.jingsaitupian.split(',')[0]:'')" alt="" />
				</div>
			</div>
			<!-- Add Arrows -->
			<div class="swiper-button-next"></div>
			<div class="swiper-button-prev"></div>
		</div>
	</div>
	
	
	
	
	
	<div @click="moreBtn('jingsaixinxi')" :style='{"border":"0","padding":"0 20px","margin":"30px auto 40px","borderColor":"#b5e8af","textAlign":"center","display":"inline-block","minWidth":"110px","background":"#fff","borderWidth":"1px 4px","width":"auto","lineHeight":"40px","borderStyle":"solid","height":"40px"}'>
		<span :style='{"color":"#333","fontSize":"14px"}'>查看更多</span>
		<i v-if="true" :style='{"color":"#333","fontSize":"14px"}' class="el-icon-d-arrow-right"></i>
	</div>
	

</div>
<div class="lists" :style='{"width":"100%","margin":"0px auto","textAlign":"center","background":"url(http://codegen.caihongy.cn/20230108/caf263fc0a304a7a907e11691deb7ae2.jpg) repeat-y","display":"block"}'>
	<div v-if="false" class="idea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
		<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
	<div class="title" :style='{"width":"100%","margin":"30px auto 50px","lineHeight":"52px","textAlign":"center","background":"url(http://codegen.caihongy.cn/20230108/7c8f15334365458b8ec1c7beedb0d8f4.png) no-repeat center bottom"}'>
	  <span :style='{"padding":"0 4px 0 20px","fontSize":"20px","lineHeight":"52px","color":"#249940"}'>获奖展示展示</span>
	</div>
	
	
	
	
	
	
	<!-- 样式五 -->
	<div class="list list5 index-pv1">
		<div id="lists-five-swiperhuojiangzhanshi" class="swiper-container lists-five-swiper" :style='{"width":"100%","padding":"80px 10px","margin":"0","background":"none"}'>
			<div class="swiper-wrapper">
				<div :style='{"border":"0","cursor":"pointer","borderRadius":"8px","background":"#fff","width":"320px","fontSize":"0","position":"relative","height":"240px"}' class="swiper-slide" v-for="(item,index) in huojiangzhanshiList" :key="index" @click="toDetail('huojiangzhanshiDetail', item)">
					<img :style='{"border":"4px solid #d0d0d0","width":"320px","borderRadius":"4px","background":"#fff","height":"240px"}' v-if="preHttp(item.fengmian)" :src="item.fengmian.split(',')[0]" alt="" />
					<img :style='{"border":"4px solid #d0d0d0","width":"320px","borderRadius":"4px","background":"#fff","height":"240px"}' v-else :src="baseUrl + (item.fengmian?item.fengmian.split(',')[0]:'')" alt="" />
				</div>
			</div>
			<!-- Add Arrows -->
			<div class="swiper-button-next"></div>
			<div class="swiper-button-prev"></div>
		</div>
	</div>
	
	
	
	
	
	<div @click="moreBtn('huojiangzhanshi')" :style='{"border":"0","padding":"0 20px","margin":"30px auto 40px","borderColor":"#b5e8af","textAlign":"center","display":"inline-block","minWidth":"110px","background":"#fff","borderWidth":"1px 4px","width":"auto","lineHeight":"40px","borderStyle":"solid","height":"40px"}'>
		<span :style='{"color":"#333","fontSize":"14px"}'>查看更多</span>
		<i v-if="true" :style='{"color":"#333","fontSize":"14px"}' class="el-icon-d-arrow-right"></i>
	</div>
	

</div>
<div class="lists" :style='{"width":"100%","margin":"0px auto","textAlign":"center","background":"url(http://codegen.caihongy.cn/20230108/caf263fc0a304a7a907e11691deb7ae2.jpg) repeat-y","display":"block"}'>
	<div v-if="false" class="idea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
		<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
	<div class="title" :style='{"width":"100%","margin":"30px auto 50px","lineHeight":"52px","textAlign":"center","background":"url(http://codegen.caihongy.cn/20230108/7c8f15334365458b8ec1c7beedb0d8f4.png) no-repeat center bottom"}'>
	  <span :style='{"padding":"0 4px 0 20px","fontSize":"20px","lineHeight":"52px","color":"#249940"}'>规则通知展示</span>
	</div>
	
	
	
	
	
	
	<!-- 样式五 -->
	<div class="list list5 index-pv1">
		<div id="lists-five-swiperguizetongzhi" class="swiper-container lists-five-swiper" :style='{"width":"100%","padding":"80px 10px","margin":"0","background":"none"}'>
			<div class="swiper-wrapper">
				<div :style='{"border":"0","cursor":"pointer","borderRadius":"8px","background":"#fff","width":"320px","fontSize":"0","position":"relative","height":"240px"}' class="swiper-slide" v-for="(item,index) in guizetongzhiList" :key="index" @click="toDetail('guizetongzhiDetail', item)">
					<img :style='{"border":"4px solid #d0d0d0","width":"320px","borderRadius":"4px","background":"#fff","height":"240px"}' v-if="preHttp(item.tupian)" :src="item.tupian.split(',')[0]" alt="" />
					<img :style='{"border":"4px solid #d0d0d0","width":"320px","borderRadius":"4px","background":"#fff","height":"240px"}' v-else :src="baseUrl + (item.tupian?item.tupian.split(',')[0]:'')" alt="" />
				</div>
			</div>
			<!-- Add Arrows -->
			<div class="swiper-button-next"></div>
			<div class="swiper-button-prev"></div>
		</div>
	</div>
	
	
	
	
	
	<div @click="moreBtn('guizetongzhi')" :style='{"border":"0","padding":"0 20px","margin":"30px auto 40px","borderColor":"#b5e8af","textAlign":"center","display":"inline-block","minWidth":"110px","background":"#fff","borderWidth":"1px 4px","width":"auto","lineHeight":"40px","borderStyle":"solid","height":"40px"}'>
		<span :style='{"color":"#333","fontSize":"14px"}'>查看更多</span>
		<i v-if="true" :style='{"color":"#333","fontSize":"14px"}' class="el-icon-d-arrow-right"></i>
	</div>
	

</div>

	

</div>
</template>

<script>
  export default {
    //数据集合
    data() {
      return {
        baseUrl: '',
        newsList: [],

        jingsaixinxiList: [],
        huojiangzhanshiList: [],
        guizetongzhiList: [],
      }
    },
    created() {
      this.baseUrl = this.$config.baseUrl;
      this.getList();
    },
    //方法集合
    methods: {
      preHttp(str) {
          return str && str.substr(0,4)=='http';
      },
		getList() {
          let autoSortUrl = "";
			
			this.$http.get('jingsaixinxi/list', {params: {
				page: 1,
				limit: 5,
			}}).then(res => {
				if (res.data.code == 0) {
					this.jingsaixinxiList = res.data.data.list;
					
					// 商品列表样式五
					this.$nextTick(() => {
						new Swiper('#lists-five-swiperjingsaixinxi', {
							loop: true,
							speed: 500,
							slidesPerView: Number(5),
							spaceBetween: Number(10),
							autoplay: {"delay":3000,"disableOnInteraction":false},
							centeredSlides: true,
							watchSlidesProgress: true,
							on: {
								setTranslate: function() {
									var slides = this.slides
									for (var i = 0; i < slides.length; i++) {
										var slide = slides.eq(i)
										var progress = slides[i].progress
										// slide.html(progress.toFixed(2)); //看清楚progress是怎么变化的
										slide.css({
											'opacity': '',
											'background': ''
										});
										slide.transform(''); //清除样式
						
										slide.transform('scale(' + (1.5 - Math.abs(progress) / 4) + ')');
									}
								},
								setTransition: function(transition) {
									for (var i = 0; i < this.slides.length; i++) {
										var slide = this.slides.eq(i)
										slide.transition(transition);
									}
								},
							},
							navigation: {"nextEl":".swiper-button-next","prevEl":".swiper-button-prev"},
						});
					})
					
				}
			});
			this.$http.get('huojiangzhanshi/list', {params: {
				sort : 'fabushijian',
				order: 'desc',
				page: 1,
				limit: 5,
			}}).then(res => {
				if (res.data.code == 0) {
					this.huojiangzhanshiList = res.data.data.list;
					
					// 商品列表样式五
					this.$nextTick(() => {
						new Swiper('#lists-five-swiperhuojiangzhanshi', {
							loop: true,
							speed: 500,
							slidesPerView: Number(5),
							spaceBetween: Number(10),
							autoplay: {"delay":3000,"disableOnInteraction":false},
							centeredSlides: true,
							watchSlidesProgress: true,
							on: {
								setTranslate: function() {
									var slides = this.slides
									for (var i = 0; i < slides.length; i++) {
										var slide = slides.eq(i)
										var progress = slides[i].progress
										// slide.html(progress.toFixed(2)); //看清楚progress是怎么变化的
										slide.css({
											'opacity': '',
											'background': ''
										});
										slide.transform(''); //清除样式
						
										slide.transform('scale(' + (1.5 - Math.abs(progress) / 4) + ')');
									}
								},
								setTransition: function(transition) {
									for (var i = 0; i < this.slides.length; i++) {
										var slide = this.slides.eq(i)
										slide.transition(transition);
									}
								},
							},
							navigation: {"nextEl":".swiper-button-next","prevEl":".swiper-button-prev"},
						});
					})
					
				}
			});
			this.$http.get('guizetongzhi/list', {params: {
				sort : 'fabushijian',
				order: 'desc',
				page: 1,
				limit: 5,
			}}).then(res => {
				if (res.data.code == 0) {
					this.guizetongzhiList = res.data.data.list;
					
					// 商品列表样式五
					this.$nextTick(() => {
						new Swiper('#lists-five-swiperguizetongzhi', {
							loop: true,
							speed: 500,
							slidesPerView: Number(5),
							spaceBetween: Number(10),
							autoplay: {"delay":3000,"disableOnInteraction":false},
							centeredSlides: true,
							watchSlidesProgress: true,
							on: {
								setTranslate: function() {
									var slides = this.slides
									for (var i = 0; i < slides.length; i++) {
										var slide = slides.eq(i)
										var progress = slides[i].progress
										// slide.html(progress.toFixed(2)); //看清楚progress是怎么变化的
										slide.css({
											'opacity': '',
											'background': ''
										});
										slide.transform(''); //清除样式
						
										slide.transform('scale(' + (1.5 - Math.abs(progress) / 4) + ')');
									}
								},
								setTransition: function(transition) {
									for (var i = 0; i < this.slides.length; i++) {
										var slide = this.slides.eq(i)
										slide.transition(transition);
									}
								},
							},
							navigation: {"nextEl":".swiper-button-next","prevEl":".swiper-button-prev"},
						});
					})
					
				}
			});
		},
		toDetail(path, item) {
			this.$router.push({path: '/index/' + path, query: {detailObj: JSON.stringify(item)}});
		},
		moreBtn(path) {
			this.$router.push({path: '/index/' + path});
		}
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.home-preview {
	
		.recommend {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list5 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
        }
        
        .list5 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list5 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 {
				.swiper-slide-prev {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-next {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-active {
					position: relative;
					z-index: 5;
				}
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: translate3d(0px, 10px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
		
		.news {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list6 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list6 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list6 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list6 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: translate3d(0px, -8px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
	
		.lists {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
        }
        
        .list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list5 .swiper-button-prev::after {
				color: #249940;
			}
			
			.list5 .swiper-button-next {
            left: auto;
            right: 10px;
			}
			
			.list5 .swiper-button-next::after {
				color: #249940;
			}
			
			.list5 {
				.swiper-slide-prev {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-next {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-active {
					position: relative;
					z-index: 5;
				}
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: rotate(360deg) scale(1.2) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: rotate(360deg) scale(0.8) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
	}
</style>
