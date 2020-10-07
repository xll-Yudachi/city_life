<template>
  <div class="app-container">
    <div>
      <div>
        <h3>选择公司和职位模板</h3>
      </div>
      <div style="margin-right:30px;display: inline-block;vertical-align:top;width: 250px">
        <el-input
          placeholder="输入公司名进行过滤"
          v-model="filterCompanyText"
          style="margin-bottom: 10px"
        >
        </el-input>
        <el-tree
          class="filter-tree"
          :data="companyData"
          :props="defaultProps"
          default-expand-all
          :filter-node-method="filterCompanyNode"
          show-checkbox
          node-key="id"
          :highlight-current="true"
          :expand-on-click-node="false"
          @check-change="handleCheckChange"
          :check-strictly="true"
          @node-click="handleNodeClick"
          ref="companyTree">
        </el-tree>
      </div>
      <div style="display: inline-block;vertical-align:top;width: 250px">
        <el-input
          placeholder="输入职位名进行过滤"
          v-model="filterJobText"
          style="margin-bottom: 10px"
        >
        </el-input>
        <el-tree
          class="filter-tree"
          :data="jobData"
          :props="defaultProps"
          default-expand-all
          :filter-node-method="filterJobNode"
          show-checkbox
          node-key="id"
          :highlight-current="true"
          :expand-on-click-node="false"
          @check-change="handleJobCheckChange"
          :check-strictly="true"
          @node-click="handleJobNodeClick"
          ref="jobTree">
        </el-tree>
      </div>
    </div>
    <div class="content">
      <div>
        <h3>完善职位信息</h3>
      </div>
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="工作地址" style="width: 400px">
          <el-input v-model="form.address"></el-input>
        </el-form-item>
        <el-form-item label="工作描述">
          <div>
            <el-card style="height: 610px;">
              <Editor v-model="form.content" :height="440"/>
            </el-card>
          </div>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit">立即关联</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
    import Qs from 'qs'
    import Editor from '@/components/Tinymce'

    export default {
        //组件
        components: {Editor},
        // 定义数据
        data() {
            return {
                form: {
                    address: '',
                    content: '',
                    jobId:'',
                    companyId:''
                },
                filterCompanyText: '',
                filterJobText: '',
                jobData: [{
                    id: 0,
                    label: '可选职位',
                    children: []
                }],
                companyData: [{
                    id: 0,
                    label: '可选公司',
                    children: []
                }],
                defaultProps: {
                    children: 'children',
                    label: 'label'
                },
                companyCurrentCheckId: '',
                companyCurrentCheckKeys: '',
                companyCurrentCheckData: '',
                jobCurrentCheckId: '',
                jobCurrentCheckKeys: '',
                jobCurrentCheckData: '',
            }
        },

        //监听器
        watch: {
            filterCompanyText(val) {
                this.$refs.companyTree.filter(val);
            },
            filterJobText(val) {
                this.$refs.jobTree.filter(val);
            }
        },

        created() {
            this.loadCompany();
            this.loadJobTemplate();
        },
        inject:['reload'],
        methods: {
            onSubmit() {
                if (this.jobCurrentCheckData === '' || this.companyCurrentCheckData === ''){
                    this.$message.error("请选择关联的公司和职位模板")
                }else{
                    this.form.jobId = this.jobCurrentCheckId
                    this.form.companyId = this.companyCurrentCheckId
                    this.$axios({
                        method:'post',
                        url:'/jobApi/job',
                        data: Qs.stringify(this.form),
                        params:{
                            methodName:'insert'
                        }
                    }).then(res=>{
                        this.reload()
                    })
                }
            },
            loadJobTemplate() {
                this.$axios({
                    method: 'get',
                    url: '/jobApi/template',
                    params: {
                        methodName: 'findJobTemplateByUid',
                        uid: localStorage.getItem("uid")
                    }
                }).then(res => {
                    if (res.data.success) {
                        let jobTemplateList = res.data.data;
                        for (let i = 0; i < jobTemplateList.length; i++) {
                            this.jobData[0].children.push({
                                "id": jobTemplateList[i].id,
                                "label": jobTemplateList[i].name
                            })
                        }
                    }
                })
            },
            loadCompany() {
                this.$axios({
                    method: 'get',
                    url: '/companyApi/company',
                    params: {
                        methodName: 'findCompanyByUid',
                        uid: localStorage.getItem("uid")
                    }
                }).then(res => {
                    if (res.data.success) {
                        let companyList = res.data.data;
                        for (let i = 0; i < companyList.length; i++) {
                            this.companyData[0].children.push({
                                "id": companyList[i].id,
                                "label": companyList[i].name
                            })
                        }
                    }
                })
            },
            handleCheckChange(data, checked, indeterminate) {
                this.companyCurrentCheckKeys = [data.id]
                if (checked === true) {
                    this.companyCurrentCheckId = data.id
                    this.$refs.companyTree.setCheckedKeys([data.id])
                    this.companyCurrentCheckData = data
                } else {
                    if (this.companyCurrentCheckId === data.id) {
                        this.$refs.companyTree.setCheckedKeys([])
                    }
                }
            },
            handleNodeClick(data, checked, indeterminate) {
                this.companyCurrentCheckId = data.id;
                this.$refs.companyTree.setCheckedKeys([data.id])
            },
            filterCompanyNode(value, data) {
                if (!value) return true;
                return data.label.indexOf(value) !== -1;
            },
            handleJobCheckChange(data, checked, indeterminate) {
                this.jobCurrentCheckKeys = [data.id]
                if (checked === true) {
                    this.jobCurrentCheckId = data.id
                    this.$refs.jobTree.setCheckedKeys([data.id])
                    this.jobCurrentCheckData = data
                } else {
                    if (this.jobCurrentCheckId === data.id) {
                        this.$refs.jobTree.setCheckedKeys([])
                    }
                }
            },
            handleJobNodeClick(data, checked, indeterminate) {
                this.jobCurrentCheckId = data.id;
                this.$refs.jobTree.setCheckedKeys([data.id])
            },
            filterJobNode(value, data) {
                if (!value) return true;
                return data.label.indexOf(value) !== -1;
            }
        }
    }
</script>

<style scoped>
  .content {
    vertical-align: top;
    padding-top: 25px;
    margin-top: 25px;
  }

  .content h3 {
    margin-top: 5px;
  }
</style>
