<template>
  <div class="main-content" :style='{"minHeight":"100vh","padding":"30px 40px 30px","backgroundAttachment":"fixed","background":"url(http://codegen.caihongy.cn/20230316/ceb93d14d79c4fe1835e7b1e4ec86ed2.jpg)","backgroundSize":"100% 100%","backgroundPosition":"left top","backgroundRepeat":"no-repeat","height":"auto"}'>
    <!-- 列表页 -->
    <div v-if="!showFlag">
      <el-form :style='{"padding":"50px 30px","boxShadow":"0 0px 0px rgba(64, 158, 255, .3)","borderRadius":"6px","flexWrap":"wrap","background":"rgba(221,242,242,1)","display":"flex"}' :inline="true" :model="searchForm" class="add-update-preview">
        <el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' label="模拟训练">
          <el-input v-model="searchForm.papername" placeholder="模拟训练名称" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' label="试题">
          <el-input v-model="searchForm.questionname" placeholder="试题名称" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"padding":"0","margin":"20px 0 0"}'>
          <el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"5px","background":"#458C8C","width":"128px","lineHeight":"40px","fontSize":"18px","height":"40px"}' round @click="search()">查询</el-button>
        </el-form-item>
        <el-form-item :style='{"padding":"0","margin":"20px 0 0"}'>
          <el-button :style='{"border":"0px solid rgba(64, 158, 255, 1)","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#fff","borderRadius":"5px","background":"#458C8C","width":"128px","lineHeight":"40px","fontSize":"18px","height":"40px"}' type="primary" round @click="back()">返回</el-button>
        </el-form-item>
      </el-form>
      <div class="table-content">
        <el-table
          :data="dataList"
          border
          v-loading="dataListLoading"
          @selection-change="selectionChangeHandler"
          style="width: 100%;"
        >
          <el-table-column type="selection" header-align="center" align="center" width="50"></el-table-column>
          <el-table-column prop="username" header-align="center" align="center" sortable label="姓名"></el-table-column>
          <el-table-column
            prop="papername"
            header-align="center"
            align="center"
            sortable
            label="模拟训练"
          ></el-table-column>
          <el-table-column
            prop="questionname"
            header-align="center"
            align="center"
            sortable
            label="试题名称"
          ></el-table-column>
          <el-table-column prop="score" header-align="center" align="center" sortable label="分值"></el-table-column>
          <el-table-column prop="answer" header-align="center" align="center" sortable label="正确答案"></el-table-column>
          <el-table-column
            prop="myanswer"
            header-align="center"
            align="center"
            sortable
            label="考生答案"
          ></el-table-column>
          <el-table-column
            prop="myscore"
            header-align="center"
            align="center"
            sortable
            label="考生分值"
          >
            <template slot-scope="scope">
              <el-tag v-if="scope.row.myscore==0" type="info">{{scope.row.myscore}}</el-tag>
              <el-tag v-else type="warning">{{scope.row.myscore}}</el-tag>
            </template>
          </el-table-column>
          <el-table-column
            prop="addtime"
            header-align="center"
            align="center"
            sortable
            width="170"
            label="考试时间"
          ></el-table-column>
        </el-table>
        <el-pagination
          @size-change="sizeChangeHandle"
          @current-change="currentChangeHandle"
          :current-page="pageIndex"
          :page-sizes="[10, 20, 50, 100]"
          :page-size="pageSize"
          :total="totalPage"
          layout="total, sizes, prev, pager, next, jumper"
          class="pagination-content"
        ></el-pagination>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      searchForm: {
        key: ""
      },
      dataList: [],
      pageIndex: 1,
      pageSize: 10,
      totalPage: 0,
      dataListLoading: false,
      dataListSelections: [],
      showFlag: false,
      paperid: 0,
      userid: 0
    };
  },
  props: ["parent"],
  components: {},
  methods: {
    init(row) {
      console.log("row:"+row)
      this.paperid = row.paperid;
      this.userid = row.userid;
      this.getDataList();
    },
    search() {
      this.pageIndex = 1;
      this.getDataList();
    },
    // 获取数据列表
    getDataList() {
      this.dataListLoading = true;
      var params = {
        page: this.pageIndex,
        limit: this.pageSize,
        paperid: this.paperid,
        userid: this.userid
        // sort: "id"
      };
      if (this.searchForm.papername) {
        params["papername"] = `%${this.searchForm.papername}%`;
      }
      if (this.searchForm.questionname) {
        params["questionname"] = `%${this.searchForm.questionname}%`;
      }
      this.$http({
        url: this.$api.examrecordpage,
        method: "get",
        params: params
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.dataList = data.data.list;
          this.totalPage = data.data.total;
        } else {
          this.dataList = [];
          this.totalPage = 0;
        }
        this.dataListLoading = false;
      });
    },
    // 每页数
    sizeChangeHandle(val) {
      this.pageSize = val;
      this.pageIndex = 1;
      this.getDataList();
    },
    // 当前页
    currentChangeHandle(val) {
      this.pageIndex = val;
      this.getDataList();
    },
    // 多选
    selectionChangeHandler(val) {
      this.dataListSelections = val;
    },
    back() {
      console.log("back")
      this.parent.showFlag = false;
    }
  }
};
</script>
<style lang="scss" scoped>
.form-content {
	background: transparent;
}
.table-content {
	background: transparent;
}

	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  color: #000;
	  	  font-weight: 500;
	  	  width: 130px;
	  	  font-size: 14px;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 130px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  border: 2px solid #797979;
	  	  border-radius: 4px;
	  	  padding: 0 12px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: #000;
	  	  width: auto;
	  	  font-size: 14px;
	  	  min-width: 350px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  	  border: 2px solid #797979;
	  	  border-radius: 0;
	  	  padding: 0 10px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: #000;
	  	  width: auto;
	  	  font-size: 14px;
	  	  min-width: 300px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  border: 2px solid #797979;
	  	  border-radius: 0;
	  	  padding: 0 10px 0 30px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: #000;
	  	  width: auto;
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
	  	  border: 1px solid #797979;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #797979;
	  	  background: #fff;
	  	  width: 90px;
	  	  font-size: 32px;
	  	  line-height: 90px;
	  	  text-align: center;
	  	  height: 90px;
	  	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  border: 1px solid #797979;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #797979;
	  	  background: #fff;
	  	  width: 90px;
	  	  font-size: 32px;
	  	  line-height: 90px;
	  	  text-align: center;
	  	  height: 90px;
	  	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  border: 1px solid #797979;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #797979;
	  	  background: #fff;
	  	  width: 90px;
	  	  font-size: 32px;
	  	  line-height: 90px;
	  	  text-align: center;
	  	  height: 90px;
	  	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  border: 2px solid #797979;
	  	  border-radius: 0;
	  	  padding: 12px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: #000;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  min-height: 150px;
	  	  height: auto;
	  	}
</style>
