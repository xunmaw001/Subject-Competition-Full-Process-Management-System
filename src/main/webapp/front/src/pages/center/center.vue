<template>
<div class="center-preview" :style='{"padding":"20px 10% 40px","margin":"0px auto","flexWrap":"wrap","background":"none","display":"flex","width":"100%","position":"relative","justifyContent":"space-between"}'>
	<div class="title" :style='{"margin":"10px 0","color":"#fff","textAlign":"center","background":"#5bb450","width":"100%","fontSize":"20px","lineHeight":"54px"}'>{{ title }}</div>

    <el-tabs tab-position="left" :style='{"alignItems":"center","flexWrap":"wrap","background":"#fff","display":"flex","width":"100%","position":"relative","justifyContent":"center"}' @tab-click="handleClick">
      <el-tab-pane label="个人中心">
        <el-form class="center-preview-pv" ref="sessionForm" :model="sessionForm" :rules="rules" label-width="120px">
          <el-form-item :style='{"border":"3px solid #c6ecc6","padding":"10px","margin":"0 0 10px","background":"#fff"}' v-if="userTableName=='jiaoshi'" label="教师工号" prop="jiaoshigonghao">
            <el-input v-model="sessionForm.jiaoshigonghao" placeholder="教师工号" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"3px solid #c6ecc6","padding":"10px","margin":"0 0 10px","background":"#fff"}' v-if="userTableName=='jiaoshi'" label="密码" prop="mima">
            <el-input type="password" v-model="sessionForm.mima" placeholder="密码"></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"3px solid #c6ecc6","padding":"10px","margin":"0 0 10px","background":"#fff"}' v-if="userTableName=='jiaoshi'" label="头像">
            <el-upload
              class="avatar-uploader"
              :action="uploadUrl"
              :headers="headers"
              :show-file-list="false"
              :on-success="jiaoshitouxiangHandleAvatarSuccess">
              <img :style='{"border":"1px solid #bfecb9","cursor":"pointer","color":"#666","borderRadius":"6px","textAlign":"center","background":"#eff8ee","width":"100px","fontSize":"32px","lineHeight":"100px","height":"100px"}' v-if="sessionForm.touxiang" :src="baseUrl + sessionForm.touxiang" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
          </el-form-item>
          <el-form-item :style='{"border":"3px solid #c6ecc6","padding":"10px","margin":"0 0 10px","background":"#fff"}' v-if="userTableName=='jiaoshi'" label="教师姓名" prop="jiaoshixingming">
            <el-input v-model="sessionForm.jiaoshixingming" placeholder="教师姓名" ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"3px solid #c6ecc6","padding":"10px","margin":"0 0 10px","background":"#fff"}' v-if="userTableName=='jiaoshi'" label="性别">
            <el-select v-model="sessionForm.xingbie" placeholder="请选择性别" >
              <el-option v-for="(item, index) in dynamicProp.xingbie" :key="index" :label="item" :value="item"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"border":"3px solid #c6ecc6","padding":"10px","margin":"0 0 10px","background":"#fff"}' v-if="userTableName=='jiaoshi'" label="联系电话" prop="lianxidianhua">
            <el-input v-model="sessionForm.lianxidianhua" placeholder="联系电话" ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"3px solid #c6ecc6","padding":"10px","margin":"0 0 10px","background":"#fff"}' v-if="userTableName=='jiaoshi'" label="邮箱" prop="youxiang">
            <el-input v-model="sessionForm.youxiang" placeholder="邮箱" ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"3px solid #c6ecc6","padding":"10px","margin":"0 0 10px","background":"#fff"}' v-if="userTableName=='xuesheng'" label="学号" prop="xuehao">
            <el-input v-model="sessionForm.xuehao" placeholder="学号" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"3px solid #c6ecc6","padding":"10px","margin":"0 0 10px","background":"#fff"}' v-if="userTableName=='xuesheng'" label="密码" prop="mima">
            <el-input type="password" v-model="sessionForm.mima" placeholder="密码"></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"3px solid #c6ecc6","padding":"10px","margin":"0 0 10px","background":"#fff"}' v-if="userTableName=='xuesheng'" label="学生姓名" prop="xueshengxingming">
            <el-input v-model="sessionForm.xueshengxingming" placeholder="学生姓名" ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"3px solid #c6ecc6","padding":"10px","margin":"0 0 10px","background":"#fff"}' v-if="userTableName=='xuesheng'" label="头像">
            <el-upload
              class="avatar-uploader"
              :action="uploadUrl"
              :headers="headers"
              :show-file-list="false"
              :on-success="xueshengtouxiangHandleAvatarSuccess">
              <img :style='{"border":"1px solid #bfecb9","cursor":"pointer","color":"#666","borderRadius":"6px","textAlign":"center","background":"#eff8ee","width":"100px","fontSize":"32px","lineHeight":"100px","height":"100px"}' v-if="sessionForm.touxiang" :src="baseUrl + sessionForm.touxiang" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
          </el-form-item>
          <el-form-item :style='{"border":"3px solid #c6ecc6","padding":"10px","margin":"0 0 10px","background":"#fff"}' v-if="userTableName=='xuesheng'" label="性别">
            <el-select v-model="sessionForm.xingbie" placeholder="请选择性别" >
              <el-option v-for="(item, index) in dynamicProp.xingbie" :key="index" :label="item" :value="item"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"border":"3px solid #c6ecc6","padding":"10px","margin":"0 0 10px","background":"#fff"}' v-if="userTableName=='xuesheng'" label="手机号码" prop="shoujihaoma">
            <el-input v-model="sessionForm.shoujihaoma" placeholder="手机号码" ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"3px solid #c6ecc6","padding":"10px","margin":"0 0 10px","background":"#fff"}' v-if="userTableName=='xuesheng'" label="邮箱" prop="youxiang">
            <el-input v-model="sessionForm.youxiang" placeholder="邮箱" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"0","margin":"0"}'>
            <el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","borderColor":"#5bb450","color":"#333","outline":"none","borderRadius":"4px","background":"#d1f0d1","borderWidth":"4px 0","width":"128px","fontSize":"14px","borderStyle":"solid","height":"40px"}' type="primary" @click="onSubmit('sessionForm')">更新信息</el-button>
            <el-button :style='{"cursor":"pointer","padding":"0","margin":"0","borderColor":"#999999","color":"#333","outline":"none","borderRadius":"4px","background":"#e2e2e2","borderWidth":"4px 0","width":"128px","fontSize":"14px","borderStyle":"solid","height":"40px"}' type="danger" @click="logout">退出登录</el-button>
          </el-form-item>
        </el-form>
		
        <el-dialog title="用户充值" :visible.sync="dialogFormVisibleMoney" width="726px" center>
          <el-form :model="chongzhiForm">
            <el-form-item label="充值金额" label-width="120px">
              <el-input type="number" v-model="chongzhiForm.money" autocomplete="off" placeholder="充值金额"></el-input>
            </el-form-item>
            <el-form-item label-width="120px">
              <el-radio-group v-model="chongzhiForm.radio">
                <el-radio style="margin-bottom: 30px" label="微信支付">
                  <el-image
                    style="width: 60px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/weixin.png')"
                    fit="fill"></el-image>
                    <span style="display: inline-block;margin-left: 10px">微信支付</span>
                </el-radio>
                <el-radio label="支付宝支付">
                  <el-image
                    style="width: 60px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/zhifubao.png')"
                    fit="fill"></el-image>
                    <span style="display: inline-block;margin-left: 10px">支付宝支付</span>
                </el-radio>
                <el-radio label="中国建设银行支付">
                  <el-image
                    style="width: 120px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/jianshe.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="中国农业银行支付">
                  <el-image
                    style="width: 126px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/nongye.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="中国银行支付">
                  <el-image
                    style="width: 140px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/zhongguo.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="交通银行支付">
                  <el-image
                    style="width: 120px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/jiaotong.png')"
                    fit="fill"></el-image>
                </el-radio>
              </el-radio-group>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisibleMoney = false">取 消</el-button>
            <el-button type="primary" @click="chongzhi">确认充值</el-button>
          </div>
        </el-dialog>
        <el-dialog title="会员购买" :visible.sync="dialogFormVisibleVip" width="726px" center>
          <el-form :model="chongzhiForm">
            <el-form-item label="会员卡" label-width="120px">
              <el-input readonly autocomplete="off" value="￥199/年"></el-input>
            </el-form-item>
            <el-form-item label-width="120px">
              <el-radio-group v-model="chongzhiForm.radio">
                <el-radio style="margin-bottom: 30px" label="微信支付">
                  <el-image
                    style="width: 60px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/weixin.png')"
                    fit="fill"></el-image>
                    <span style="display: inline-block;margin-left: 10px">微信支付</span>
                </el-radio>
                <el-radio label="支付宝支付">
                  <el-image
                    style="width: 60px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/zhifubao.png')"
                    fit="fill"></el-image>
                    <span style="display: inline-block;margin-left: 10px">支付宝支付</span>
                </el-radio>
                <el-radio label="中国建设银行支付">
                  <el-image
                    style="width: 120px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/jianshe.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="中国农业银行支付">
                  <el-image
                    style="width: 126px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/nongye.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="中国银行支付">
                  <el-image
                    style="width: 140px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/zhongguo.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="交通银行支付">
                  <el-image
                    style="width: 120px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/jiaotong.png')"
                    fit="fill"></el-image>
                </el-radio>
              </el-radio-group>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisibleVip = false">取 消</el-button>
            <el-button type="primary" @click="chongzhivip">确认支付</el-button>
          </div>
        </el-dialog>
      </el-tab-pane>
      <el-tab-pane label="考试记录"></el-tab-pane>
      <el-tab-pane label="错题本"></el-tab-pane>
      <el-tab-pane label="我的收藏"></el-tab-pane>
    </el-tabs>
</div>
</template>

<script>
  import config from '@/config/config'
  import Vue from 'vue'
  export default {
    //数据集合
    data() {
      return {
        title: '个人中心',
        baseUrl: config.baseUrl,
        sessionForm: {},
        rules: {},
        chongzhiForm: {
          money: '',
          radio: ''
        },
        disabled: false,
        dialogFormVisibleMoney: false,
        dialogFormVisibleVip: false,
        uploadUrl: config.baseUrl + 'file/upload',
        imageUrl: '',
        headers: {Token: localStorage.getItem('Token')},
        userTableName: localStorage.getItem('UserTableName'),
        dynamicProp: {}
      }
    },
    created() {
      if ('jiaoshi' == this.userTableName) {
        this.$set(this.sessionForm, 'jiaoshigonghao', null);
      }
      if ('jiaoshi' == this.userTableName) {
        this.$set(this.sessionForm, 'mima', null);
      }
      if ('jiaoshi' == this.userTableName) {
        this.$set(this.sessionForm, 'touxiang', null);
      }
      if ('jiaoshi' == this.userTableName) {
        this.$set(this.sessionForm, 'jiaoshixingming', null);
      }
      if ('jiaoshi' == this.userTableName) {
        this.$set(this.sessionForm, 'xingbie', null);
      }
      if ('jiaoshi' == this.userTableName) {
        this.$set(this.sessionForm, 'lianxidianhua', null);
      }
      if ('jiaoshi' == this.userTableName) {
        this.$set(this.sessionForm, 'youxiang', null);
      }
      if ('xuesheng' == this.userTableName) {
        this.$set(this.sessionForm, 'xuehao', null);
      }
      if ('xuesheng' == this.userTableName) {
        this.$set(this.sessionForm, 'mima', null);
      }
      if ('xuesheng' == this.userTableName) {
        this.$set(this.sessionForm, 'xueshengxingming', null);
      }
      if ('xuesheng' == this.userTableName) {
        this.$set(this.sessionForm, 'touxiang', null);
      }
      if ('xuesheng' == this.userTableName) {
        this.$set(this.sessionForm, 'xingbie', null);
      }
      if ('xuesheng' == this.userTableName) {
        this.$set(this.sessionForm, 'shoujihaoma', null);
      }
      if ('xuesheng' == this.userTableName) {
        this.$set(this.sessionForm, 'youxiang', null);
      }

      if ('jiaoshi' == this.userTableName) {
        this.$set(this.rules, 'jiaoshigonghao', [{ required: true, message: '请输入教师工号', trigger: 'blur' }]);
      }
      if ('jiaoshi' == this.userTableName) {
        this.$set(this.rules, 'mima', [{ required: true, message: '请输入密码', trigger: 'blur' }]);
      }
			if ('jiaoshi' == this.userTableName) {
        this.$set(this.rules, 'lianxidianhua', [{ required: false, validator: this.$validate.isMobile, trigger: 'blur' }]);
      }
			if ('jiaoshi' == this.userTableName) {
        this.$set(this.rules, 'youxiang', [{ required: false, validator: this.$validate.isEmail, trigger: 'blur' }]);
      }
      if ('xuesheng' == this.userTableName) {
        this.$set(this.rules, 'xuehao', [{ required: true, message: '请输入学号', trigger: 'blur' }]);
      }
      if ('xuesheng' == this.userTableName) {
        this.$set(this.rules, 'mima', [{ required: true, message: '请输入密码', trigger: 'blur' }]);
      }
      if ('xuesheng' == this.userTableName) {
        this.$set(this.rules, 'xueshengxingming', [{ required: true, message: '请输入学生姓名', trigger: 'blur' }]);
      }
			if ('xuesheng' == this.userTableName) {
        this.$set(this.rules, 'shoujihaoma', [{ required: false, validator: this.$validate.isMobile, trigger: 'blur' }]);
      }
			if ('xuesheng' == this.userTableName) {
        this.$set(this.rules, 'youxiang', [{ required: false, validator: this.$validate.isEmail, trigger: 'blur' }]);
      }

      this.init();
      this.getSession();
    },
    //方法集合
    methods: {
      init() {
        if ('jiaoshi' == this.userTableName) {
          this.dynamicProp.xingbie = '男,女'.split(',');
        }
        if ('xuesheng' == this.userTableName) {
          this.dynamicProp.xingbie = '男,女'.split(',');
        }
      },
      getSession() {
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.sessionForm = res.data.data;
            localStorage.setItem('userid', res.data.data.id);
            if(res.data.data.vip) {
                localStorage.setItem('vip', res.data.data.vip);
            }
            if(res.data.data.touxiang) {
                localStorage.setItem('headportrait', res.data.data.touxiang);
            } else if(res.data.data.headportrait) {
                localStorage.setItem('headportrait', res.data.data.headportrait);
            }
          }
        });
      },
      onSubmit(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$http.post(this.userTableName + '/update', this.sessionForm).then(res => {
              if (res.data.code == 0) {
                this.$message({
                  message: '更新成功',
                  type: 'success',
                  duration: 1500
                });
              }
            });
          } else {
            return false;
          }
        });
      },
      jiaoshitouxiangHandleAvatarSuccess(res, file) {
        if (res.code == 0) {
          if ('jiaoshi' == this.userTableName) {
            this.sessionForm.touxiang = 'upload/' + res.file;
          }
        }
      },
      xueshengtouxiangHandleAvatarSuccess(res, file) {
        if (res.code == 0) {
          if ('xuesheng' == this.userTableName) {
            this.sessionForm.touxiang = 'upload/' + res.file;
          }
        }
      },
      chongzhi() {
        if (this.chongzhiForm.money == '') {
          this.$message({
            message: '请输入充值金额',
            type: 'error',
            duration: 1500
          });
          return;
        }
        if (this.chongzhiForm.money <= 0) {
          this.$message({
            message: '请输入正确的充值金额',
            type: 'error',
            duration: 1500
          });
          return;
        }
        if (this.chongzhiForm.radio == '') {
          this.$message({
            message: '请选择充值方式',
            type: 'error',
            duration: 1500
          });
          return;
        }
        this.sessionForm.money = parseInt(this.sessionForm.money) + parseInt(this.chongzhiForm.money);
        this.$http.post(this.userTableName + '/update', this.sessionForm).then(res => {
          if (res.data.code == 0) {
            this.$message({
              message: '充值成功',
              type: 'success',
              duration: 1500,
              onClose: () => {
                this.dialogFormVisibleMoney = false;
              }
            });
          }
        });
      },
      chongzhivip() {
        this.chongzhiForm.money == 199;
        if (this.chongzhiForm.radio == '') {
          this.$message({
            message: '请选择支付方式',
            type: 'error',
            duration: 1500
          });
          return;
        }
        if(this.sessionForm.vip == '是') {
          this.$message({
            message: '您已是我们的尊贵会员。',
            type: 'success',
            duration: 1500
          });
          return;
        }
        
        this.sessionForm.vip = "是"
        this.$http.post(this.userTableName + '/update', this.sessionForm).then(res => {
          if (res.data.code == 0) {
            this.$message({
              message: '会员购买成功',
              type: 'success',
              duration: 1500,
              onClose: () => {
                localStorage.setItem('vip', this.sessionForm.vip);
                this.dialogFormVisibleVip = false;
              }
            });
          }
        });
      },
      handleClick(tab, event) {
        switch(event.target.outerText) {
          case '个人中心':
            tab.$router.push('/index/center');
            break;
          case '考试记录':
            tab.$router.push('/index/examList');
            break;
          case '错题本':
            tab.$router.push('/index/examRecord/0');
            break;
          case '我的收藏':
            localStorage.setItem('storeupType', 1);
            tab.$router.push('/index/storeup');
            break;
        }

        this.title = event.target.outerText;
      },
      logout() {
        localStorage.clear();
        Vue.http.headers.common['Token'] = "";
        this.$router.push('/index/home');
        this.activeIndex = '0'
        localStorage.setItem('keyPath', this.activeIndex)
        this.$forceUpdate()
        this.$message({
            message: '登出成功',
            type: 'success',
            duration: 1500,
        });
      }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .center-preview {
  
    .el-tabs {
      & /deep/ .el-tabs__header {
        .el-tabs__nav-wrap {
          margin: 0;
  
          &::after {
            content: none;
          }
        }
  
        .el-tabs__active-bar {
          display: none !important;
        }
      }
  
      .center-preview-pv {
        .el-date-editor.el-input {
          width: auto;
        }
  
        .balance {
          .el-input {
            width: auto;
          }
        }
      }
    }
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header {
	background: #fff;
	display: flex;
	width: 100%;
	border-color: #eee;
	border-width: 0 1px 0 0;
	justify-content: center;
	position: relative;
	border-style: solid;
	min-width: 1200px;
	height: 110px;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item {
  	padding: 0 10px;
  	color: #333;
  	background: linear-gradient(320deg, rgba(238,238,238,1) 0%, rgba(255,255,255,1) 25%, rgba(238,238,238,1) 100%);
  	font-weight: 500;
  	display: inline-block;
  	font-size: 14px;
  	border-color: #9DDA97;
  	border-width: 0 0 4px;
  	line-height: 45px;
  	border-style: solid;
  	text-align: center;
  	height: 45px;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item:hover {
  	padding: 0 10px;
  	background: #9dda96;
  	font-weight: 500;
  	font-size: 14px;
  	line-height: 45px;
  	position: relative;
  	text-align: center;
  	height: 45px;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item.is-active {
  	padding: 0 10px;
  	background: #9dda96;
  	font-weight: 500;
  	font-size: 14px;
  	line-height: 45px;
  	position: relative;
  	text-align: center;
  	height: 45px;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__content .el-tab-pane {
  	padding: 10px 50px;
  	background: #fff;
  	flex: 1;
  	position: relative;
  	min-width: 1200px;
  }
  
  .center-preview-pv .el-form-item /deep/ .el-form-item__label {
  	padding: 0 10px 0 0;
  	color: #666;
  	font-weight: 500;
  	width: 120px;
  	font-size: 14px;
  	line-height: 40px;
  	text-align: right;
  }
  
  .center-preview-pv .el-form-item .el-form-item__content {
    margin-left: 120px;
  }
  
  .center-preview-pv .el-input /deep/ .el-input__inner {
  	border: 1px solid #bfecb9;
  	border-radius: 4px;
  	padding: 0 12px;
  	outline: none;
  	color: #333;
  	background: #eff8ee;
  	width: 400px;
  	font-size: 14px;
  	height: 40px;
  }
  
  .center-preview-pv .el-select /deep/ .el-input__inner {
  	border: 1px solid #bfecb9;
  	border-radius: 4px;
  	padding: 0 12px;
  	outline: none;
  	color: #333;
  	background: #eff8ee;
  	width: 400px;
  	font-size: 14px;
  	height: 40px;
  }
  
  .center-preview-pv .el-date-editor /deep/ .el-input__inner {
  	border: 1px solid #bfecb9;
  	border-radius: 4px;
  	padding: 0 10px 0 30px;
  	outline: none;
  	color: #333;
  	background: #eff8ee;
  	width: 200px;
  	font-size: 14px;
  	height: 40px;
  }
  
  .center-preview-pv /deep/ .avatar-uploader-icon {
  	border: 1px solid #bfecb9;
  	cursor: pointer;
  	border-radius: 6px;
  	color: #666;
  	background: #eff8ee;
  	width: 100px;
  	font-size: 32px;
  	line-height: 100px;
  	text-align: center;
  	height: 100px;
  }
  
  .center-preview-pv .el-form-item.balance /deep/ .el-input__inner {
  	border: 1px solid #bfecb9;
  	border-radius: 4px;
  	padding: 0 12px;
  	outline: none;
  	color: #333;
  	background: #eff8ee;
  	display: inline-block;
  	width: 200px;
  	font-size: 14px;
  	height: 40px;
  }
</style>
