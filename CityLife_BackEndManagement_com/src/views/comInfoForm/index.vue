<template>
  <div class="app-container">
    <div style="margin-left: 25px;">
      <h3 style="margin-bottom: 30px;">申请审核</h3>
    </div>
    <el-steps :active="active" align-center style="margin-bottom: 35px;">
      <el-step title="步骤1" description="填写公司基本信息"></el-step>
      <el-step title="步骤2" description="完善公司信息"></el-step>
      <el-step title="步骤3" description="完成申请"></el-step>
    </el-steps>
    <div v-if="active === 0" style="margin-left: 15px;">
      <el-form ref="form" :model="form" :rules="rules" label-width="120px" style="margin-left: 12px;">
        <el-form-item prop="comName" label="公司名称">
          <el-input label-width="100px" v-model="form.comName" style="width: 300px"></el-input>
        </el-form-item>
        <el-form-item prop="comAbbreviation" label="企业简称" label-width="120px">
          <el-input aria-placeholder="" v-model="form.comAbbreviation" style="width: 300px"></el-input>
        </el-form-item>
        <el-form-item prop="comLr" label="公司法人">
          <el-input aria-placeholder="" label-width="100px" v-model="form.comLr" style="width: 300px"></el-input>
        </el-form-item>
        <el-form-item prop="comUsd" label="公司注册资金" label-width="120px">
          <el-input aria-placeholder="" v-model="form.comUsd" style="width: 300px"></el-input>
        </el-form-item>
        <el-form-item prop="comWebSite" label="企业门户网页" label-width="120px">
          <el-input aria-placeholder="" v-model="form.comWebSite" style="width: 300px"></el-input>
        </el-form-item>
        <el-form-item prop="comEsTime" label="企业成立时间" label-width="120px">
          <el-date-picker
            style="width: 250px"
            v-model="form.comEsTime"
            type="date"
            placeholder="选择日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item prop="comEmpType" label="企业类型" label-width="120px">
          <el-select v-model="form.comEmpType" placeholder="请选择企业阶段" style="width: 250px">
            <el-option v-for="item in comEmpTypeList" :label="item.empType" :value="item.id"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item prop="comStage" label="企业阶段" label-width="120px">
          <el-select style="width: 250px" v-model="form.comStage" placeholder="请选择企业阶段">
            <el-option v-for="item in comStageList" :label="item.label" :value="item.value"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item prop="comScale" label="企业规模" label-width="120px">
          <el-select style="width: 250px" v-model="form.comScale" placeholder="请选择企业规模">
            <el-option v-for="item in comScaleList
              " :label="item.label" :value="item.value"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item prop="comIndustry" label="行业方向" label-width="120px">
          <el-select style="width: 250px" v-model="form.comIndustry" placeholder="请选择企业行业方向">
            <el-option v-for="item in comIndustryList
              " :label="item.industry" :value="item.industry"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item prop="comLogo" label="企业Logo" label-width="120px">
          <el-image v-if="form.comLogo" :src="form.comLogo" style="width: 148px;height: 148px"></el-image>
          <el-upload
            accept=".jpg,.jpeg,.png,.gif,.bmp,.JPG,.JPEG,.GIF,.BMP"
            ref="upload"
            action="#"
            list-type="picture-card"
            :on-change="handleChange"
            :http-request="uploadFile"
            :auto-upload="false">
            <i slot="default" class="el-icon-plus"></i>
            <div slot="file" slot-scope="{file}">
              <img
                class="el-upload-list__item-thumbnail"
                :src="file.url" alt=""
              >
              <span class="el-upload-list__item-actions">
                <span
                  class="el-upload-list__item-preview"
                  @click="handlePictureCardPreview(file)"
                >
                  <i class="el-icon-zoom-in"></i>
                </span>
                <span
                  v-if="!disabled"
                  class="el-upload-list__item-delete"
                  @click="handleDownload(file)"
                >
                  <i class="el-icon-download"></i>
                </span>
                <span
                  v-if="!disabled"
                  class="el-upload-list__item-delete"
                  @click="handleRemove(file)"
                >
                  <i class="el-icon-delete"></i>
                </span>
                </span>
            </div>
          </el-upload>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm('form')">提交基本信息</el-button>
        </el-form-item>
      </el-form>
      <el-dialog :visible.sync="dialogVisible">
        <img width="100%" :src="dialogImageUrl" alt="">
      </el-dialog>
    </div>
    <div v-if="active === 1" style="margin-left: 15px">
      <div style="margin-left: 15px;margin-bottom: 15px;">公司福利</div>
      <div style="margin-left: 15px;margin-bottom: 20px;">
        <el-tag
          :key="tag"
          v-for="tag in dynamicTags"
          closable
          :disable-transitions="false"
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
        <el-button v-else class="button-new-tag" size="small" @click="showInput">+ 添加福利</el-button>
      </div>
      <div style="margin-left: 15px;margin-bottom: 20px;">公司描述</div>
      <div style="margin-left: 15px;">
        <el-card style="height: 610px;">
          <Editor v-model="content" :height="440"/>
        </el-card>
      </div>
      <div>
        <el-button style="margin-bottom: 30px;float: left;margin-left: 15px;margin-top: 20px;" type="primary"
                   @click="pre">上一步
        </el-button>
        <el-button style="margin-bottom: 30px;float: right;margin-top: 20px;" type="primary" @click="next">下一步
        </el-button>
      </div>
    </div>
    <div v-if="active === 2" style="margin-left: 15px">
      <el-button style="margin-bottom: 30px;float: left;margin-left: 15px;margin-top: 20px;" type="primary"
                 @click="finalPre">上一步
      </el-button>
      <el-button style="margin-bottom: 30px;margin-top: 20px;" type="primary" @click="finalSubmit">确认提交
      </el-button>
    </div>
  </div>
</template>

<script>
    import Editor from '@/components/Tinymce'
    import Qs from 'qs'

    const comStageList = [
        {value: 0, label: "未上市"},
        {value: 1, label: "已上市"}
    ]
    const comScaleList = [
        {value: "0-20人", label: "0-20人"},
        {value: "20-99人", label: "20-99人"},
        {value: "100-499人", label: "100-499人"},
        {value: "500-999人", label: "500-999人"},
        {value: "1000-9999人", label: "1000-9999人"},
        {value: "10000人以上", label: "10000人以上"},
    ]
    export default {
        //组件
        components: {Editor},
        // 定义数据
        data() {
            return {
                content: "",
                editorOption: {},
                active: 0,
                dialogImageUrl: '',
                dialogVisible: false,
                disabled: false,
                comStageList,
                comScaleList,
                comEmpTypeList: [],
                comIndustryList: [],
                form: {
                    comEsTime: '',
                    comAbbreviation: '',
                    comWebSite: '',
                    comStage: '',
                    comScale: '',
                    comName: '',
                    comLr: '',
                    comUsd: '',
                    comEmpType: '',
                    comIndustry: '',
                    comLogo: ''
                },
                rules: {
                    comName: [
                        {required: true, message: '请输入公司名称', trigger: 'blur'},
                    ],
                    comLr: [
                        {required: true, message: '请输入公司法人', trigger: 'blur'}
                    ],
                    comUsd: [
                        {required: true, message: '请输入公司注册资金', trigger: 'blur'}
                    ],
                    comEsTime: [
                        {type: 'date', required: true, message: '请选择日期', trigger: 'change'}
                    ],
                    comEmpType: [
                        {required: true, message: '请选择企业类型', trigger: 'change'}
                    ],
                    comStage: [
                        {required: true, message: '请选择企业阶段', trigger: 'change'}
                    ],
                    comScale: [
                        {required: true, message: '请选择企业规模', trigger: 'change'}
                    ],
                    comIndustry: [
                        {required: true, message: '请选择行业方向', trigger: 'change'}
                    ],
                    comLogo: [
                        {required: true, message: '请上传公司Logo'}
                    ]
                },
                submitFormInfo: new FormData(),
                dynamicTags: [],
                inputVisible: false,
                inputValue: '',
                moreCompanyInfo: {
                    comId: '',
                    comDescribe: '',
                    comWelfare: '',
                    comDescribeId: '',
                    comWelfareId: ''
                },
                companyApply: {
                    uid: "",
                    cid: "",
                }
            }
        },
        //监听器
        watch: {},

        created() {
            this.loadCompanyInfo()
            this.loadIndustryInfo()
            this.loadEmptypeInfo()
            this.loadCompanyWelfare()
            this.loadCompanyDescribe()
        },
        inject: ['reload'],
        methods: {
            finalPre() {
                this.active = 1
            },
            finalSubmit() {
                this.companyApply.cid = sessionStorage.getItem("cid")
                this.companyApply.uid = localStorage.getItem("uid")
                this.$axios({
                    method: 'post',
                    url: '/companyApi/company',
                    data: Qs.stringify(this.companyApply),
                    params: {
                        methodName: 'insertCompanyApply'
                    }
                }).then(res => {
                    if (res.data.success) {
                        sessionStorage.removeItem("cid")
                        sessionStorage.removeItem("comDescribeId")
                        sessionStorage.removeItem("comWelfareId")
                        this.active = 0
                        this.reload()
                    } else {
                        this.$message.error(res.data.message)
                    }
                })
            },
            loadCompanyWelfare() {
                if (sessionStorage.getItem("comWelfareId") !== null && sessionStorage.getItem("comWelfareId") !== undefined && sessionStorage.getItem("comWelfareId") !== '') {
                    this.$axios({
                        method: 'get',
                        url: '/companyWelfareApi/welfare',
                        params: {
                            methodName: 'findCompanyWelfareById',
                            id: sessionStorage.getItem("comWelfareId")
                        }
                    }).then(res => {
                        if (res.data.success) {
                            this.dynamicTags = res.data.data.welfare.split(",")
                        }
                    })
                }
            },
            loadCompanyDescribe() {
                if (sessionStorage.getItem("comDescribeId") !== null && sessionStorage.getItem("comDescribeId") !== undefined && sessionStorage.getItem("comDescribeId") !== '') {
                    this.$axios({
                        method: 'get',
                        url: '/companyDescribeApi/describe',
                        params: {
                            methodName: 'findCompanyDescribeById',
                            id: sessionStorage.getItem("comDescribeId")
                        }
                    }).then(res => {
                        if (res.data.success) {
                            console.log(res.data.data);
                            this.content = res.data.data.content
                        }
                    })
                }
            },
            loadCompanyInfo() {
                if (sessionStorage.getItem("cid") !== null && sessionStorage.getItem("cid") !== undefined && sessionStorage.getItem("cid") !== '') {
                    this.$axios({
                        method: 'get',
                        url: '/companyApi/company',
                        params: {
                            methodName: 'findCompanyById',
                            cid: sessionStorage.getItem("cid")
                        }
                    }).then(res => {
                        if (res.data.success) {
                            let data = res.data.data
                            this.form.comAbbreviation = data.abbreviation
                            this.form.comEmpType = data.empType
                            this.form.comEsTime = new Date(data.establishTime)
                            this.form.comIndustry = data.industry
                            this.form.comLr = data.legalRep
                            this.form.comLogo = this.baseImageUrl + data.logo
                            this.form.comName = data.name
                            this.form.comScale = data.scale
                            this.form.comStage = data.stage
                            this.form.comUsd = data.usd
                            this.form.comWebSite = data.webSite
                        }
                    })
                } else {
                    this.form = {
                        comEsTime: '',
                        comAbbreviation: '',
                        comWebSite: '',
                        comStage: '',
                        comScale: '',
                        comName: '',
                        comLr: '',
                        comUsd: '',
                        comEmpType: '',
                        comIndustry: '',
                        comLogo: ''
                    }
                }
            },
            pre() {
                this.active = 0;
                this.reload()
            },
            next() {
                if (sessionStorage.getItem("comDescribeId") === null && sessionStorage.getItem("comWelfareId") === null) {
                    if (sessionStorage.getItem("cid") !== null && sessionStorage.getItem("cid") != undefined && sessionStorage.getItem("cid") !== '') {
                        this.moreCompanyInfo.comId = sessionStorage.getItem("cid")
                        this.moreCompanyInfo.comDescribe = this.content
                        this.moreCompanyInfo.comWelfare = this.dynamicTags.join(",")
                        this.$axios({
                            method: 'post',
                            url: '/companyApi/company',
                            data: Qs.stringify(this.moreCompanyInfo),
                            params: {
                                methodName: 'insertWelAndDes'
                            }
                        }).then(res => {
                            if (res.data.success) {
                                sessionStorage.setItem("comWelfareId", res.data.data.comWelfareId)
                                sessionStorage.setItem("comDescribeId", res.data.data.comDescribeId)
                                this.active = 2
                            } else {
                                this.$message.error(res.data.message)
                            }
                        })
                    } else {
                        this.$message.error("请先完成公司基本信息的填写！")
                    }
                } else {
                    if (sessionStorage.getItem("cid") !== null && sessionStorage.getItem("cid") != undefined && sessionStorage.getItem("cid") !== '') {
                        this.moreCompanyInfo.comWelfareId = sessionStorage.getItem("comWelfareId")
                        this.moreCompanyInfo.comDescribeId = sessionStorage.getItem("comDescribeId")
                        this.moreCompanyInfo.comDescribe = this.content
                        this.moreCompanyInfo.comWelfare = this.dynamicTags.join(",")
                        this.$axios({
                            method: 'post',
                            url: '/companyApi/company',
                            data: Qs.stringify(this.moreCompanyInfo),
                            params: {
                                methodName: 'updateWelAndDes'
                            }
                        }).then(res => {
                            if (res.data.success) {
                                this.active = 2
                            } else {
                                this.$message.error(res.data.message)
                            }
                        })
                    } else {
                        this.$message.error("请先完成公司基本信息的填写！")
                    }
                }
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
            handleChange(file) {
                this.rules.comLogo = file
                if (this.form.comLogo !== '') {
                    this.form.comLogo = ''
                }
            },
            handleRemove(file) {
                console.log(file);
            },
            handlePictureCardPreview(file) {
                this.dialogImageUrl = file.url;
                this.dialogVisible = true;
            },
            handleDownload(file) {
                console.log(file);
            },
            // 上传文件
            uploadFile(file) {
                this.submitFormInfo.append('files', file.file)
            },
            // 提交公司基本信息
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        const conf = {
                            headers: {
                                'Content-Type': 'multipart/form-data'
                            }
                        }
                        this.$refs.upload.submit()
                        this.submitFormInfo.append('comEsTime', this.form.comEsTime)
                        this.submitFormInfo.append('comAbbreviation', this.form.comAbbreviation)
                        this.submitFormInfo.append('comStage', this.form.comStage)
                        this.submitFormInfo.append('comScale', this.form.comScale)
                        this.submitFormInfo.append('comName', this.form.comName)
                        this.submitFormInfo.append('comLr', this.form.comLr)
                        this.submitFormInfo.append('comUsd', this.form.comUsd)
                        this.submitFormInfo.append('comEmpType', this.form.comEmpType)
                        this.submitFormInfo.append('comIndustry', this.form.comIndustry)
                        this.submitFormInfo.append('comWebSite', this.form.comWebSite)
                        if (sessionStorage.getItem("cid") !== null && sessionStorage.getItem("cid") !== undefined && sessionStorage.getItem("cid") !== '') {
                            // 更新
                            this.$axios({
                                method: 'post',
                                url: '/companyApi/company',
                                data: this.submitFormInfo,
                                params: {
                                    methodName: 'updateById',
                                    id: sessionStorage.getItem("cid")
                                },
                                config: conf
                            }).then(res => {
                                if (res.data.success) {
                                    this.$refs['upload'].clearFiles()
                                    this.active = 1
                                } else {
                                    this.$message.error(res.data.message)
                                    return false;
                                }
                            })
                        } else {
                            // 新增
                            this.$axios({
                                method: 'post',
                                url: '/companyApi/company',
                                data: this.submitFormInfo,
                                params: {
                                    methodName: 'insert'
                                },
                                config: conf
                            }).then(res => {
                                if (res.data.success) {
                                    sessionStorage.setItem("cid", res.data.data)
                                    this.$refs['upload'].clearFiles()
                                    this.active = 1
                                } else {
                                    this.$message.error(res.data.message)
                                    return false;
                                }
                            })
                        }
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            loadIndustryInfo() {
                this.$axios({
                    method: 'get',
                    url: "/industryApi/industry",
                    params: {
                        methodName: 'findAllIndustry'
                    }
                }).then(res => {
                    if (res.data.success) {
                        this.comIndustryList = res.data.data
                    }
                })
            },
            loadEmptypeInfo() {
                this.$axios({
                    method: 'get',
                    url: "/empTypeApi/emptype",
                    params: {
                        methodName: 'findAllEmpType'
                    }
                }).then(res => {
                    if (res.data.success) {
                        this.comEmpTypeList = res.data.data
                    }
                })
            }
        }
    }
</script>

<style scoped>
  /deep/ .el-form-item__label {
    text-align: left;
  }

  /*步骤条样式修改*/
  /deep/ .el-steps.el-steps--horizontal /deep/ .el-step.is-horizontal.is-center /deep/ .el-step__head.is-finish {
    color: #67c23a;
    border-color: #67c23a;
  }

  /deep/ .el-steps.el-steps--horizontal /deep/ .el-step.is-horizontal.is-center /deep/ .el-step__title.is-finish {
    color: #666666;
  }

  /deep/ .el-steps.el-steps--horizontal /deep/ .el-step.is-horizontal.is-center /deep/ .el-step__description.is-finish {
    color: #999999;
  }


  .el-tag + .el-tag {
    margin-top: 10px;
    margin-left: 10px;
  }

  .button-new-tag {
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
</style>
