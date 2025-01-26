<template>
<div :style='{"width":"1200px","padding":"20px","margin":"0px auto","position":"relative","background":"none"}'>
    <el-form
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
    >
          <el-form-item :style='{"border":"3px solid #c6ecc6","padding":"10px","margin":"0 0 10px","background":"#fff"}' label="竞赛名称" prop="jingsaimingcheng">
            <el-input v-model="ruleForm.jingsaimingcheng" 
                placeholder="竞赛名称" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"3px solid #c6ecc6","padding":"10px","margin":"0 0 10px","background":"#fff"}'  label="竞赛类型" prop="jingsaileixing">
            <el-select v-model="ruleForm.jingsaileixing" placeholder="请选择竞赛类型"  >
              <el-option
                  v-for="(item,index) in jingsaileixingOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"border":"3px solid #c6ecc6","padding":"10px","margin":"0 0 10px","background":"#fff"}' label="竞赛图片" v-if="type!='cross' || (type=='cross' && !ro.jingsaitupian)" prop="jingsaitupian">
            <file-upload
            tip="点击上传竞赛图片"
            action="file/upload"
            :limit="3"
            :multiple="true"
            :fileUrls="ruleForm.jingsaitupian?ruleForm.jingsaitupian:''"
            @change="jingsaitupianUploadChange"
            ></file-upload>
          </el-form-item>
            <el-form-item :style='{"border":"3px solid #c6ecc6","padding":"10px","margin":"0 0 10px","background":"#fff"}' class="upload" v-else label="竞赛图片" prop="jingsaitupian">
                <img v-if="ruleForm.jingsaitupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.jingsaitupian.split(',')[0]" width="100" height="100">
                <img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.jingsaitupian.split(',')" :src="baseUrl+item" width="100" height="100">
            </el-form-item>
          <el-form-item :style='{"border":"3px solid #c6ecc6","padding":"10px","margin":"0 0 10px","background":"#fff"}' label="竞赛人数" prop="jingsairenshu">
            <el-input v-model="ruleForm.jingsairenshu" 
                placeholder="竞赛人数" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"3px solid #c6ecc6","padding":"10px","margin":"0 0 10px","background":"#fff"}' label="竞赛时间" prop="jingsaishijian" >
              <el-date-picker
                  value-format="yyyy-MM-dd HH:mm:ss"
                  v-model="ruleForm.jingsaishijian" 
                  type="datetime"
                  placeholder="竞赛时间">
              </el-date-picker>
          </el-form-item>
          <el-form-item :style='{"border":"3px solid #c6ecc6","padding":"10px","margin":"0 0 10px","background":"#fff"}' label="竞赛地点" prop="jingsaididian">
            <el-input v-model="ruleForm.jingsaididian" 
                placeholder="竞赛地点" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"3px solid #c6ecc6","padding":"10px","margin":"0 0 10px","background":"#fff"}' label="倒计结束时间" prop="reversetime" >
              <el-date-picker
                  value-format="yyyy-MM-dd HH:mm:ss"
                  v-model="ruleForm.reversetime" 
                  type="datetime"
                  placeholder="倒计结束时间">
              </el-date-picker>
          </el-form-item>
          <el-form-item :style='{"border":"3px solid #c6ecc6","padding":"10px","margin":"0 0 10px","background":"#fff"}' label="竞赛规则" prop="jingsaiguize">
            <el-input
              type="textarea"
              :rows="8"
              placeholder="竞赛规则"
              v-model="ruleForm.jingsaiguize">
            </el-input>
          </el-form-item>
          <el-form-item :style='{"border":"3px solid #c6ecc6","padding":"10px","margin":"0 0 10px","background":"#fff"}' label="竞赛介绍" prop="jingsaijieshao">
            <editor 
                :style='{"padding":"0","boxShadow":"0 0 6px rgba(75,223,201,.5)","margin":"0","borderColor":"#ccc","backgroundColor":"#fff","borderRadius":"0","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}'
                v-model="ruleForm.jingsaijieshao" 
                class="editor" 
                action="file/upload">
            </editor>
          </el-form-item>

      <el-form-item :style='{"padding":"0","margin":"0"}'>
        <el-button :style='{"cursor":"pointer","padding":"0","margin":"0 20px 0 0","borderColor":"#59b450","color":"#333","outline":"none","borderRadius":"4px","background":"#c6ecc6","borderWidth":"4px 0","width":"128px","fontSize":"14px","borderStyle":"solid","height":"40px"}'  type="primary" @click="onSubmit">提交</el-button>
        <el-button :style='{"cursor":"pointer","padding":"0","margin":"0","borderColor":"#999999","color":"#333","outline":"none","borderRadius":"4px","background":"#dddddd","borderWidth":"4px 0","width":"128px","fontSize":"14px","borderStyle":"solid","height":"40px"}' @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
</div>
</template>

<script>
  export default {
    data() {
      return {
        id: '',
        baseUrl: '',
        ro:{
            jingsaimingcheng : false,
            jingsaileixing : false,
            jingsaitupian : false,
            jingsaiguize : false,
            jingsairenshu : false,
            jingsaishijian : false,
            jingsaididian : false,
            jingsaijieshao : false,
            reversetime : false,
        },
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          jingsaimingcheng: '',
          jingsaileixing: '',
          jingsaitupian: '',
          jingsaiguize: '',
          jingsairenshu: '',
          jingsaishijian: '',
          jingsaididian: '',
          jingsaijieshao: '',
          reversetime: '',
        },
        jingsaileixingOptions: [],
        rules: {
          jingsaimingcheng: [
            { required: true, message: '竞赛名称不能为空', trigger: 'blur' },
          ],
          jingsaileixing: [
            { required: true, message: '竞赛类型不能为空', trigger: 'blur' },
          ],
          jingsaitupian: [
          ],
          jingsaiguize: [
          ],
          jingsairenshu: [
            { required: true, message: '竞赛人数不能为空', trigger: 'blur' },
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          jingsaishijian: [
            { required: true, message: '竞赛时间不能为空', trigger: 'blur' },
          ],
          jingsaididian: [
          ],
          jingsaijieshao: [
          ],
          reversetime: [
          ],
        },
      };
    },
    computed: {



    },
    created() {
	  //this.bg();
      let type = this.$route.query.type ? this.$route.query.type : '';
      this.init(type);
      this.baseUrl = this.$config.baseUrl;
    },
    methods: {
      getMakeZero(s) {
          return s < 10 ? '0' + s : s;
      },
      // 下载
      download(file){
        window.open(`${file}`)
      },
      // 初始化
      init(type) {
        this.type = type;
        if(type=='cross'){
          var obj = JSON.parse(localStorage.getItem('crossObj'));
          for (var o in obj){
            if(o=='jingsaimingcheng'){
              this.ruleForm.jingsaimingcheng = obj[o];
              this.ro.jingsaimingcheng = true;
              continue;
            }
            if(o=='jingsaileixing'){
              this.ruleForm.jingsaileixing = obj[o];
              this.ro.jingsaileixing = true;
              continue;
            }
            if(o=='jingsaitupian'){
              this.ruleForm.jingsaitupian = obj[o].split(",")[0];
              this.ro.jingsaitupian = true;
              continue;
            }
            if(o=='jingsaiguize'){
              this.ruleForm.jingsaiguize = obj[o];
              this.ro.jingsaiguize = true;
              continue;
            }
            if(o=='jingsairenshu'){
              this.ruleForm.jingsairenshu = obj[o];
              this.ro.jingsairenshu = true;
              continue;
            }
            if(o=='jingsaishijian'){
              this.ruleForm.jingsaishijian = obj[o];
              this.ro.jingsaishijian = true;
              continue;
            }
            if(o=='jingsaididian'){
              this.ruleForm.jingsaididian = obj[o];
              this.ro.jingsaididian = true;
              continue;
            }
            if(o=='jingsaijieshao'){
              this.ruleForm.jingsaijieshao = obj[o];
              this.ro.jingsaijieshao = true;
              continue;
            }
            if(o=='reversetime'){
              this.ruleForm.reversetime = obj[o];
              this.ro.reversetime = true;
              continue;
            }
          }
        }
        // 获取用户信息
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
          }
        });
        this.jingsaileixingOptions = "个人赛,团体赛".split(',')
      },

    // 多级联动参数
      // 多级联动参数
      info(id) {
        this.$http.get('jingsaixinxi/detail/${id}', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // 提交
      onSubmit() {

        //更新跨表属性
        var crossuserid;
        var crossrefid;
        var crossoptnum;
        this.$refs["ruleForm"].validate(valid => {
          if(valid) {
            if(this.type=='cross'){
                 var statusColumnName = localStorage.getItem('statusColumnName');
                 var statusColumnValue = localStorage.getItem('statusColumnValue');
                 if(statusColumnName && statusColumnName!='') {
                     var obj = JSON.parse(localStorage.getItem('crossObj'));
                     if(!statusColumnName.startsWith("[")) {
                         for (var o in obj){
                             if(o==statusColumnName){
                                 obj[o] = statusColumnValue;
                             }
                         }
                         var table = localStorage.getItem('crossTable');
                         this.$http.post(table+'/update', obj).then(res => {});
                     } else {
                            crossuserid=Number(localStorage.getItem('userid'));
                            crossrefid=obj['id'];
                            crossoptnum=localStorage.getItem('statusColumnName');
                            crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                     }
                 }
            }
            if(crossrefid && crossuserid) {
                 this.ruleForm.crossuserid=crossuserid;
                 this.ruleForm.crossrefid=crossrefid;
                 var params = {
                     page: 1,
                     limit: 10,
                     crossuserid:crossuserid,
                     crossrefid:crossrefid,
                 }
                 this.$http.get('jingsaixinxi/list', {
                  params: params
                 }).then(res => {
                     if(res.data.data.total>=crossoptnum) {
                         this.$message({
                          message: localStorage.getItem('tips'),
                          type: 'success',
                          duration: 1500,
                         });
                          return false;
                     } else {
                         // 跨表计算


                          this.$http.post('jingsaixinxi/add', this.ruleForm).then(res => {
                              if (res.data.code == 0) {
                                  this.$message({
                                      message: '操作成功',
                                      type: 'success',
                                      duration: 1500,
                                      onClose: () => {
                                          this.$router.go(-1);
                                      }
                                  });
                              } else {
                                  this.$message({
                                      message: res.data.msg,
                                      type: 'error',
                                      duration: 1500
                                  });
                              }
                          });
                     }
                 });
             } else {


                  this.$http.post('jingsaixinxi/add', this.ruleForm).then(res => {
                     if (res.data.code == 0) {
                          this.$message({
                              message: '操作成功',
                              type: 'success',
                              duration: 1500,
                              onClose: () => {
                                  this.$router.go(-1);
                              }
                          });
                      } else {
                          this.$message({
                              message: res.data.msg,
                              type: 'error',
                              duration: 1500
                          });
                      }
                  });
             }
          }
        });
      },
      // 获取uuid
      getUUID () {
        return new Date().getTime();
      },
      // 返回
      back() {
        this.$router.go(-1);
      },
      jingsaitupianUploadChange(fileUrls) {
          this.ruleForm.jingsaitupian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");;
      },
    }
  };
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  padding: 0 10px 0 0;
	  color: #666;
	  font-weight: 500;
	  width: 80px;
	  font-size: 14px;
	  line-height: 40px;
	  text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 80px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  border: 0;
	  border-radius: 4px;
	  padding: 0 12px;
	  outline: none;
	  color: #333;
	  background: #eff8ee;
	  width: 400px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  border: 0;
	  border-radius: 4px;
	  padding: 0 10px;
	  outline: none;
	  color: #333;
	  background: #eff8ee;
	  width: 200px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  border: 0;
	  border-radius: 4px;
	  padding: 0 10px 0 30px;
	  outline: none;
	  color: #333;
	  background: #eff8ee;
	  width: 200px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
	  border: 1px dashed #333;
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
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  border: 1px dashed #333;
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
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  border: 1px dashed #333;
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
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  border: 0;
	  border-radius: 4px;
	  padding: 12px;
	  outline: none;
	  color: #333;
	  background: #eff8ee;
	  width: 400px;
	  font-size: 14px;
	  height: 120px;
	}
</style>
