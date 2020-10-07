<template>
    <div class="app-container">
      <div class="filter-container" style="margin-bottom: 15px">
        <el-input v-model="listQuery.name" placeholder="职位名称" style="width: 200px;" class="filter-item" />
        <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">
          查找
        </el-button>
      </div>
      <el-table
        v-loading="listLoading"
        :data="list"
        element-loading-text="Loading"
        border
        fit
        highlight-current-row
      >
        <el-table-column align="center" label="职位模板ID" width="95">
          <template slot-scope="scope">
            {{ scope.row.id }}
          </template>
        </el-table-column>
        <el-table-column label="职位名称" align="center" width="230">
          <template slot-scope="scope">
            {{ scope.row.name }}
          </template>
        </el-table-column>
        <el-table-column label="职位薪资" width="110" align="center">
          <template slot-scope="scope">
            <span>{{ scope.row.salary }}</span>
          </template>
        </el-table-column>
        <el-table-column label="职位省份" width="170" align="center">
          <template slot-scope="scope">
            {{ scope.row.province}}
          </template>
        </el-table-column>
        <el-table-column label="职位经历要求" width="110" align="center">
          <template slot-scope="scope">
            {{ scope.row.exp}}
          </template>
        </el-table-column>
        <el-table-column label="职位学历要求" width="110" align="center">
          <template slot-scope="scope">
            {{ scope.row.degree}}
          </template>
        </el-table-column>
        <el-table-column label="职业技能要求" width="140" align="center">
          <template slot-scope="scope">
            {{ scope.row.skillTag}}
          </template>
        </el-table-column>
        <el-table-column class-name="status-col" label="操作" width="180" align="center">
          <template slot-scope="{row}">
            <el-button type="primary" size="small" style="float: left" icon="el-icon-edit" @click="handleUpdate(row)">更新</el-button>
            <el-button type="danger" size="small" style="float: right;margin:0px 5px;" icon="el-icon-delete" @click="handleDelete(row,'published')">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
      <pagination v-show="total>0" :total="total" :page.sync="listQuery.page" :limit.sync="listQuery.limit" @pagination="loadJobTemplate" />

      <el-dialog title="更新职位模板" :before-close="handleDialogClose" :visible.sync="dialogFormVisible">
        <el-form :model="form">
          <el-form-item label="职位名称" :label-width="formLabelWidth">
            <el-input @input="$forceUpdate()" v-model="form.name" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="职位薪资" :label-width="formLabelWidth">
            <el-input @input="$forceUpdate()" v-model="form.salary" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="职位省份" :label-width="formLabelWidth">
            <area-cascader v-if="show" :level="1" type="text" placeholder="请选择地区" v-model="form.province" :data="pcaa" class="region"></area-cascader>
          </el-form-item>
          <el-form-item label="职位经历要求" :label-width="formLabelWidth">
            <el-select @change="$forceUpdate()" style="width: 250px" v-model="form.exp" placeholder="请选择工作经验">
              <el-option v-for="item in comExpList"
                         :label="item.label" :value="item.value"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="职位学历要求" :label-width="formLabelWidth">
            <el-select @change="$forceUpdate()" style="width: 250px" v-model="form.degree" placeholder="请选择学历">
              <el-option v-for="item in comDegreeList"
                         :label="item.label" :value="item.value"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="职业技能要求" :label-width="formLabelWidth">
            <el-tag
              :key="tag"
              v-for="tag in dynamicTags"
              closable
              :disable-transitions="true"
              @close="handleClose(tag)">
              {{tag}}
            </el-tag>
            <el-input
              class="input-new-tag"
              v-if="inputVisible"
              v-model="inputValue"
              ref="saveTagInput"
              size="small"
              @keyup.enter.native="handleInputConfirm"
              @blur="handleInputConfirm"
            >
            </el-input>
            <el-button style="display: block;margin-left: 0px;margin-top: 10px;" v-else class="button-new-tag" size="small" @click="showInput">+ 添加技能标签</el-button>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button type="primary" @click="submitUpdate">确 定</el-button>
          <el-button @click="dialogFormVisible = false">取 消</el-button>
        </div>
      </el-dialog>
    </div>
</template>

<script>
    //import teacher from '@/api/admin/edu/teacher'
    import Qs from 'qs'
    import pagination from '@/components/Pagination'
    import {pca, pcaa} from 'area-data';
    const comExpList = [
        {value: "在校生", label: "在校生"},
        {value: "应届生", label: "应届生"},
        {value: "1年以内", label: "1年以内"},
        {value: "1-3年", label: "1-3年"},
        {value: "3-5年", label: "3-5年"},
        {value: "5-10年", label: "5-10年"},
        {value: "10年以上", label: "10年以上"},
    ]
    const comDegreeList = [
        {value: "初中及以下", label: "初中及以下"},
        {value: "中专/中技", label: "中专/中技"},
        {value: "高中", label: "高中"},
        {value: "大专", label: "大专"},
        {value: "本科", label: "本科"},
        {value: "硕士", label: "硕士"},
        {value: "博士", label: "博士"},
    ]
    export default {
        filters: {
            statusFilter(status) {
                const statusMap = {
                    published: 'success',
                    draft: 'gray',
                    deleted: 'danger'
                }
                return statusMap[status]
            }
        },
        //组件
        components: {pagination},
        // 定义数据
        data() {
            return {
                comExpList,
                comDegreeList,
                dynamicTags: [],
                inputVisible: false,
                inputValue: '',
                pca: pca,
                pcaa: pcaa,
                formLabelWidth: '120px',
                list: null,
                listLoading: false,
                listQuery: {
                    page: 1,
                    limit: 20,
                    name:'',
                    uid:''
                },
                total: 0,
                form: {
                    id: '',
                    uid: '',
                    name: '',
                    salary: '',
                    province: '',
                    exp: '',
                    degree: '',
                    skill_tag: '',
                    used:''
                },
                dialogFormVisible: false,
                show:true,
                updateId:''
            }
        },

        //监听器
        watch: {},

        created() {
            this.loadJobTemplate()
        },
        inject:['reload'],
        methods: {
            handleDialogClose(){
                this.form = {}
                this.dialogFormVisible = false
            },
            handleClose(tag) {
                this.dynamicTags.splice(this.dynamicTags.indexOf(tag), 1);
            },
            showInput() {
                this.inputVisible = true;
                this.$nextTick(_ => {
                    this.$refs.saveTagInput.$refs.input.focus();
                });
            },
            handleInputConfirm() {
                let inputValue = this.inputValue;
                if (inputValue) {
                    this.dynamicTags.push(inputValue);
                }
                this.inputVisible = false;
                this.inputValue = '';
            },
            submitUpdate(){
                this.form.skill_tag = this.dynamicTags.join(",")
                this.form.province = this.form.province.join(" ")
                this.form.id = this.updateId
                this.$axios({
                    method:'post',
                    url:'/jobApi/template',
                    data: Qs.stringify(this.form),
                    params:{
                        methodName: 'update'
                    }
                }).then(res=>{
                   if (res.data.success){
                      this.handleFilter()
                   }
                })
                this.dialogFormVisible = false
            },
            handleDelete(row){
                this.$confirm('确定删除嘛?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.$axios({
                        method:'put',
                        url:'/jobApi/template',
                        params:{
                            methodName:'delete',
                            id: row.id
                        }
                    }).then(res=>{
                        if (res.data.success){
                            this.handleFilter()
                        }else{
                            this.$message.error(res.data.message)
                        }
                    })
                }).catch(() => {
                });
            },
            handleUpdate(row){
                this.updateId = row.id
                this.show = false
                this.form = {}
                setTimeout(()=>{
                    this.show = true
                }, 0)
                this.dialogFormVisible = true
                this.$axios({
                    method:'get',
                    url:'/jobApi/template',
                    params:{
                        methodName:'findJobTemplateById',
                        id: row.id
                    }
                }).then(res=>{
                    if (res.data.success){
                        this.form.name = res.data.data.name
                        this.form.salary = res.data.data.salary
                        this.form.province = res.data.data.province.split(" ")
                        this.form.exp = res.data.data.exp
                        this.form.degree = res.data.data.degree
                        this.dynamicTags = res.data.data.skillTag.split(",")
                    }
                })
            },
            handleFilter(){
                this.listQuery.page = 1
                this.loadJobTemplate()
            },
            loadJobTemplate(){
                this.listQuery.uid = localStorage.getItem("uid")
                this.$axios({
                    method:'post',
                    url:'/jobApi/template',
                    data: Qs.stringify(this.listQuery),
                    params:{
                        methodName: 'findAllByQuery'
                    }
                }).then(res=>{
                    if (res.data.success){
                        this.list = res.data.data.rows
                        this.total = res.data.data.total
                    }
                })
            }
        }
    }
</script>

<style scoped>
  .el-tag + .el-tag {
    margin-left: 10px;
  }

  .button-new-tag {
    margin-left: 10px;
    height: 32px;
    line-height: 30px;
    padding-top: 0;
    padding-bottom: 0;
  }

  .input-new-tag {
    width: 90px;
    margin-left: 10px;
    vertical-align: bottom;
  }

  /deep/ .el-table th.gutter{
    display: table-cell!important;
  }
  /deep/ .el-table__header-wrapper, .el-table__footer-wrapper {
    border-bottom: 1px solid #dfe6ec;
  }
  /deep/ .el-table th{
    top: 1px;
  }
  .region .area-select {
    height: 40px;
    line-height: 25px
  }

  /deep/ .area-select {
    height: 40px;
  }

  /deep/ .area-select .area-selected-trigger {
    padding-left: 15px;
    padding-bottom: 0px;
    padding-top: 0px;
  }

  /deep/ .area-select.large {
    width: 250px;
  }
</style>
