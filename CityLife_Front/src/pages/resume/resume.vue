<template>
  <div>
    <header>
      <div class="header-box">
        <div class="logo-nav"><img
          src="https://z.zhipin.com/resume/static/images/zp-logo.5c68ed05.png"
          alt="" class="logo">
          <ul class="nav-list">
            <li class="nav-item" @click="toHome">首页</li>
            <li class="nav-item active">我的简历</li>
          </ul>
        </div>
        <div class="login-nav">
          <div class="nav-user" @mouseleave="hideUserInfo" @mouseover="showUserInfo"> {{curUser}}
            <svg aria-hidden="true" class="icon icon-arrow-down">
              <use xlink:href="#icon-arrow-down"></use>
            </svg>
            <ul data-v-cb9e9410="" class="user-menu">
              <li data-v-cb9e9410="">我的简历</li>
              <li data-v-cb9e9410="">退出登录</li>
            </ul>
          </div>
        </div>
      </div>
    </header>
    <div id="container" class="resume-container">
      <div class="left-sider">
        <div class="left-sider-container">
          <div class="row">
            <div class="container">
              <h3>简历目录</h3>
              <side-catalog
                class="catalog"
                v-bind="catalogProps"
              />
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="resume-content">
      <div id="demo">
        <h3 style="margin-left: 25px;margin-bottom: 25px">个人信息</h3>
        <el-form ref="form" :model="form" label-width="80px" style="width: 610px;margin: 0 auto;">
          <el-form-item style="vertical-align: top" label="姓名" label-width="40px">
            <el-input placeholder="请输入您的姓名" clearable v-model="form.name"
                      style="width: 290px;display: inline-block"></el-input>
          </el-form-item>
          <el-form-item id="avatar" style="margin-left: 15px;width: 300px;height: 105px;margin-bottom: 0px;"
                        label="上传照片">
            <p style="font-size: 12px;font-weight: 400;color: #61687c;line-height: 17px;width: 210px;display: inline-block;margin-top: 20px;    vertical-align: top;
"> 图片大小，格式为jpg，png，gif 形象需要保证整洁 </p>
            <el-upload
              class="avatar-uploader"
              :action="uploadAvatarUrl"
              :show-file-list="false"
              :on-success="handleAvatarSuccess"
              :before-upload="beforeAvatarUpload">
              <img v-if="imageUrl" :src="imageUrl" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
          </el-form-item>
          <el-form-item style="vertical-align: top;position:relative;top: -25px" label="当前求职状态" label-width="96px">
            <el-input placeholder="例如：已离职-随时到岗、在职-月内到岗" clearable v-model="form.guard"
                      style="width: 290px;display: inline-block"></el-input>
          </el-form-item>
          <el-form-item id="sex"
                        style="margin-left: 15px;width: 300px;height: 105px;margin-bottom: 0px;position: relative;top: -25px;"
                        label="性别"
                        label-width="40px">
            <el-radio v-model="form.sex" label="0">女</el-radio>
            <el-radio v-model="form.sex" label="1">男</el-radio>
          </el-form-item>
          <el-form-item id="attach"
                        style="vertical-align: top;width: 290px;position: relative;top: -40px;margin-bottom: 0px;"
                        label="开始工作时间" label-width="96px">
            <el-date-picker
              style="width: 290px"
              v-model="form.attach_time"
              type="date"
              placeholder="请选择参加工作时间">
            </el-date-picker>
          </el-form-item>
          <el-form-item
            style="margin-left: 15px;width: 300px;height: 90px;margin-bottom: 0px;position: relative;top: -40px;"
            label="生日"
            label-width="40px">
            <el-date-picker
              style="width: 290px"
              v-model="form.birth"
              type="date"
              placeholder="请选择生日">
            </el-date-picker>
          </el-form-item>
          <el-form-item style="vertical-align: top;width: 290px;position: relative;top: -40px;" label="微信号"
                        label-width="54px">
            <el-input placeholder="请输入您的微信号" clearable v-model="form.wxId"
                      style="width: 290px;display: inline-block"></el-input>
          </el-form-item>
          <el-form-item
            style="margin-left: 15px;width: 300px;height: 90px;margin-bottom: 0px;position: relative;top: -40px;"
            label="电话"
            label-width="40px">
            <el-input placeholder="请输入您的手机号" clearable v-model="form.phone"
                      style="width: 290px;display: inline-block"></el-input>
          </el-form-item>
          <el-form-item style="vertical-align: top;width: 290px;position: relative;top: -50px;" label="邮箱"
                        label-width="40px">
            <el-input placeholder="请输入您的邮箱" clearable v-model="form.email"
                      style="width: 290px;display: inline-block"></el-input>
          </el-form-item>
          <el-form-item
            style="margin-left: 15px;width: 300px;height: 90px;margin-bottom: 0px;position: relative;top: -50px;"
            label="期望职位"
            label-width="68px">
            <el-input placeholder="例如：UI设计师" clearable v-model="form.direction"
                      style="width: 290px;display: inline-block"></el-input>
          </el-form-item>
          <el-form-item style="vertical-align: top;width: 290px;position: relative;top: -55px;" label="薪资要求"
                        label-width="68px">
            <div style="display: inline-block;width: 295px;">
              <el-select style="width: 135px;display: inline-block" v-model="startSalary" placeholder="请选择起始薪资">
                <el-option v-for="item in startSalaryList" :key="item.label" :label="item.label"
                           :value="item.value"></el-option>
              </el-select>
              至
              <el-select style="width: 135px;display: inline-block" v-model="endSalary" placeholder="请选择最高薪资">
                <el-option v-for="item in endSalaryList" :label="item.label" :value="item.value"
                           :key="item.label"></el-option>
              </el-select>
            </div>
          </el-form-item>
          <el-form-item
            style="margin-left: 15px;width: 300px;height: 90px;margin-bottom: 0px;position: relative;top: -55px;"
            label="城市"
            label-width="40px">
            <div>
              <area-cascader type="text" v-model="form.position" :data="pcaa"></area-cascader>
            </div>
          </el-form-item>
          <el-form-item style="float: right;position: relative;top: -50px;right: 10px;">
            <el-button size="small"
                       style="background-color: #24827f;border-color: #24827f;color: #fff;border-radius: 19px;min-width: 70px;font-size: 12px"
                       type="primary" @click="onSubmit">完成
            </el-button>
          </el-form-item>
        </el-form>

        <h3 style="margin:15px 25px">工作经历</h3>
        <el-form ref="workExp" :model="workExp" label-width="80px" style="width: 610px;margin: 0 auto;">
          <el-form-item style="vertical-align: top" label="公司名称" label-width="70px">
            <el-input placeholder="例如： 北京华品博睿网络技术有限公司" clearable v-model="workExp.comName"
                      style="width: 290px;display: inline-block"></el-input>
          </el-form-item>
          <el-form-item style="vertical-align: top;position: relative;
    top: -10px;" label="职位类型" label-width="70px">
            <el-input placeholder="例如： UI设计师" clearable v-model="workExp.jobType"
                      style="width: 290px;display: inline-block"></el-input>
          </el-form-item>
          <el-form-item style="vertical-align: top;width: 290px;position: relative;top: -10px;margin-left: 15px"
                        label="在职时间" label-width="68px">
            <div style="display: inline-block;width: 295px;">
              <el-date-picker
                v-model="workExp.startTime"
                type="date"
                style="width: 135px;"
                placeholder="选择在职时间">
              </el-date-picker>
              至
              <el-date-picker
                style="width: 135px;"
                v-model="workExp.endTime"
                type="date"
                placeholder="选择在职时间">
              </el-date-picker>
            </div>
          </el-form-item>
          <el-form-item style="vertical-align: top;position: relative;
    top: -20px;" label="工作内容" label-width="70px">
            <el-input
              style="width: 600px"
              type="textarea"
              placeholder="请输入工作内容"
              v-model="workExp.workContent"
              maxlength="1600"
              show-word-limit
            />
          </el-form-item>
          <el-form-item style="vertical-align: top;position: relative;
    top: -25px;" label="工作业绩" label-width="70px">
            <el-input
              style="width: 600px"
              type="textarea"
              placeholder="请输入工作业绩"
              v-model="workExp.workResult"
              maxlength="300"
              show-word-limit
            />
          </el-form-item>
          <el-form-item style="float: right;position: relative;top: -30px;right: 10px;">
            <el-button size="small"
                       style="background-color: #24827f;border-color: #24827f;color: #fff;border-radius: 19px;min-width: 70px;font-size: 12px"
                       type="primary" @click="onSubmitWorkExp">完成
            </el-button>
          </el-form-item>
        </el-form>


        <h3 style="margin:30px 25px">教育经历</h3>
        <el-form ref="studyExp" :model="studyExp" label-width="80px" style="width: 610px;margin: 0 auto;">
          <el-form-item style="vertical-align: top;width: 320px;display: block" label="学校名称" label-width="70px">
            <el-input placeholder="例如： 北京大学" clearable v-model="studyExp.schoolName"
                      style="width: 290px;display: inline-block"></el-input>
          </el-form-item>
          <el-form-item style="vertical-align: top;width: 290px;position: relative;top: -10px;" label="学历"
                        label-width="40px">
            <el-select style="width: 290px" v-model="studyExp.degree" placeholder="选择学历">
              <el-option
                v-for="item in degreeList"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item style="vertical-align: top;position: relative;
    top: -10px;margin-left: 15px" label="专业" label-width="40px">
            <el-input placeholder="例如：计算机科学与技术" clearable v-model="studyExp.major"
                      style="width: 290px;display: inline-block"></el-input>
          </el-form-item>
          <el-form-item style="vertical-align: top;position: relative;
    top: -20px;" label="时间段" label-width="54px">
            <div style="display: inline-block">
              <el-date-picker
                v-model="studyExp.startYear"
                type="year"
                style="width: 290px"
                placeholder="选择年">
              </el-date-picker>
              至
              <el-date-picker
                style="width: 290px"
                v-model="studyExp.endYear"
                type="year"
                placeholder="选择年">
              </el-date-picker>
            </div>
          </el-form-item>

          <el-form-item style="vertical-align: top;position: relative;
    top: -25px;" label="在校经历" label-width="70px">
            <el-input
              style="width: 600px"
              type="textarea"
              placeholder="请填写内容"
              v-model="studyExp.studyContent"
              maxlength="300"
              show-word-limit
            />
          </el-form-item>

          <el-form-item style="float: right;position: relative;top: -30px;right: 10px;">
            <el-button size="small"
                       style="background-color: #24827f;border-color: #24827f;color: #fff;border-radius: 19px;min-width: 70px;font-size: 12px"
                       type="primary" @click="onSubmitStudyExp">完成
            </el-button>
          </el-form-item>
        </el-form>

        <h3 style="margin:30px 25px">自我评价</h3>
        <el-form ref="evalForm" :model="evalForm" label-width="80px" style="width: 610px;margin: 0 auto;">
          <el-form-item style="vertical-align: top;position: relative;
    top: -25px;" label="编辑自我评价" label-width="96px">
            <el-input
              style="width: 600px"
              type="textarea"
              placeholder="输入自我评价"
              v-model="evalForm.evaluation"
              maxlength="1000"
              show-word-limit
            />
          </el-form-item>
          <el-form-item style="float: right;position: relative;top: -30px;right: 10px;">
            <el-button size="small"
                       style="background-color: #24827f;border-color: #24827f;color: #fff;border-radius: 19px;min-width: 70px;font-size: 12px"
                       type="primary" @click="onSubmitEvaluation">完成
            </el-button>
          </el-form-item>
        </el-form>

      </div>
    </div>
  </div>
</template>

<script>
    //import teacher from '@/api/admin/edu/teacher'
    import Qs from 'qs'
    import SideCatalog from 'vue-side-catalog'
    import 'vue-side-catalog/lib/vue-side-catalog.css'
    import 'vue-area-linkage/dist/index.css'
    import {pca, pcaa} from 'area-data'

    const startSalaryList = [
        {value: '面议', label: '面议'},
        {value: '1k', label: '1k'},
        {value: '2k', label: '2k'},
        {value: '3k', label: '3k'},
        {value: '4k', label: '4k'},
        {value: '5k', label: '5k'},
        {value: '6k', label: '6k'},
        {value: '7k', label: '7k'},
        {value: '8k', label: '8k'},
        {value: '9k', label: '9k'},
        {value: '10k', label: '10k'},
        {value: '15k', label: '15k'},
        {value: '20k', label: '20k'},
        {value: '25k', label: '25k'},
        {value: '30k', label: '30k'},
        {value: '35k', label: '35k'},
        {value: '40k', label: '40k'},
        {value: '45k', label: '45k'},
        {value: '50k', label: '50k'},
        {value: '50k以上', label: '50k以上'}
    ]
    const endSalaryList = [
        {value: '面议', label: '面议'},
        {value: '5k', label: '5k'},
        {value: '6k', label: '6k'},
        {value: '7k', label: '7k'},
        {value: '8k', label: '8k'},
        {value: '9k', label: '9k'},
        {value: '10k', label: '10k'},
        {value: '15k', label: '15k'},
        {value: '20k', label: '20k'},
        {value: '25k', label: '25k'},
        {value: '30k', label: '30k'},
        {value: '35k', label: '35k'},
        {value: '40k', label: '40k'},
        {value: '45k', label: '45k'},
        {value: '50k', label: '50k'},
        {value: '55k', label: '55k'},
        {value: '60k', label: '60k'},
        {value: '65k', label: '65k'},
        {value: '70k', label: '70k'},
        {value: '80k', label: '80k'},
        {value: '90k', label: '90k'},
        {value: '100k及以上', label: '100k及以上'}
    ]
    const degreeList = [
        {"label": "初中及以下", "value": "初中及以下"},
        {"label": "中专/中技", "value": "中专/中技"},
        {"label": "高中", "value": "高中"},
        {"label": "大专", "value": "大专"},
        {"label": "本科", "value": "本科"},
        {"label": "硕士", "value": "硕士"},
        {"label": "博士", "value": "博士"},
    ]
    export default {
        //组件
        components: {SideCatalog},
        // 定义数据
        data() {
            return {
                uploadAvatarUrl: '/resumeApi/resume?methodName=uploadAvatar&uid=' + localStorage.getItem("uid"),
                evalForm: {
                    uid: localStorage.getItem("uid"),
                    evaluation: ''
                },
                degreeList,
                pca: pca,
                pcaa: pcaa,
                startSalaryList,
                endSalaryList,
                catalogProps: {
                    container: '#demo',
                },
                endSalary: '',
                startSalary: '',
                studyExp: {
                    uid: localStorage.getItem("uid"),
                    schoolName: '',
                    degree: '',
                    startYear: '',
                    endYear: '',
                    major: '',
                    studyContent: ''
                },
                workExp: {
                    uid: localStorage.getItem("uid"),
                    comName: '',
                    startTime: '',
                    endTime: '',
                    jobType: '',
                    workContent: '',
                    workResult: ''
                },
                form: {
                    name: '',
                    guard: '',
                    sex: '0',
                    attach_time: '',
                    birth: '',
                    wxId: '',
                    phone: '',
                    email: '',
                    direction: '',
                    position: [],
                    uid: localStorage.getItem('uid'),
                    salary: ''
                },
                imageUrl: '',
                curUser: '',
                curResume: null
            }
        },

        //监听器
        watch: {},

        created() {
            this.loadUserInfo()
            this.loadResume()
        },
        methods: {
            toHome(){
              window.location.href="/"
            },
            loadResume() {
                this.$axios({
                    method: 'get',
                    url: '/resumeApi/resume',
                    params: {
                        methodName: 'findResumeByUid',
                        uid: localStorage.getItem("uid")
                    }
                }).then(res => {
                    if (res.data.success) {
                        this.curResume = res.data.data
                        if (res.data.data != null) {
                            if (res.data.data.avatar !== undefined && res.data.data.avatar !== '') {
                                this.imageUrl = this.baseImageUrl + res.data.data.avatar
                            }
                            this.form.sex = res.data.data.sex + ""
                            this.form.guard = res.data.data.guard
                            this.form.name = res.data.data.name
                            this.form.phone = res.data.data.phone
                            this.form.wxId = res.data.data.wxId
                            this.form.attach_time = new Date(res.data.data.attachTime)
                            this.form.birth = new Date(res.data.data.birth)
                            this.form.position = res.data.data.position.split(" ")
                            this.form.direction = res.data.data.direction
                            this.form.salary = res.data.data.salary
                            this.startSalary = res.data.data.salary.split("-")[0]
                            this.endSalary = res.data.data.salary.split("-")[1]
                            this.form.email = res.data.data.email
                            let workExp = JSON.parse(res.data.data.workExp)
                            this.workExp.comName = workExp.comName
                            this.workExp.jobType = workExp.jobType
                            this.workExp.workContent = workExp.workContent
                            this.workExp.workResult = workExp.workResult
                            this.workExp.startTime = new Date(workExp.workTime.split("/")[0])
                            this.workExp.endTime = new Date(workExp.workTime.split("/")[1])
                            let studyExp = JSON.parse(res.data.data.studyExp)
                            this.studyExp.schoolName = studyExp.schoolName
                            this.studyExp.degree = studyExp.degree
                            this.studyExp.major = studyExp.major
                            this.studyExp.studyContent = studyExp.studyContent
                            this.studyExp.startYear = new Date(studyExp.studyTime.split("-")[0])
                            this.studyExp.endYear = new Date(studyExp.studyTime.split("-")[1])
                            this.evalForm.evaluation = res.data.data.evaluation
                        }
                    }
                })
            },
            showUserInfo() {
                $(".user-menu").show()
            },
            hideUserInfo() {
                $(".user-menu").hide()
            },
            loadUserInfo() {
                if (localStorage.getItem("uid") !== null){
                    this.$axios({
                        method: 'get',
                        url: '/userApi/user',
                        params: {
                            uid: localStorage.getItem("uid"),
                            methodName: 'findUserById'
                        }
                    }).then(res => {
                        if (res.data.success) {
                            this.curUser = res.data.data.username
                        }
                    })
                }else{
                    window.location.href="/login.html"
                }
            },
            handleAvatarSuccess(res, file) {
                this.imageUrl = URL.createObjectURL(file.raw);
            },
            beforeAvatarUpload(file) {
                const isJPG = file.type === 'image/jpeg';
                const isLt2M = file.size / 1024 / 1024 < 2;

                if (!isJPG) {
                    this.$message.error('上传头像图片只能是 JPG 格式!');
                }
                if (!isLt2M) {
                    this.$message.error('上传头像图片大小不能超过 2MB!');
                }
                return isJPG && isLt2M;
            },
            onSubmit() {
                if (this.startSalary !== '' && this.endSalary !== '') {
                    this.form.salary = this.startSalary + "-" + this.endSalary
                }
                if (this.form.position !== null && this.form.position.length > 0) {
                    this.form.position = this.form.position.join(" ")
                }
                // 插入
                if (this.curResume === null || this.curResume === undefined) {
                    this.$axios({
                        method: 'post',
                        url: '/resumeApi/resume',
                        data: Qs.stringify(this.form),
                        params: {
                            methodName: 'insertPersonInfo'
                        }
                    }).then(res => {
                        if (res.data.success) {
                            this.$message.success(res.data.message)
                            this.curResume = this.loadResume()
                        }
                    })
                } else {
                    // 更新
                    this.$axios({
                        method: 'post',
                        url: '/resumeApi/resume',
                        data: Qs.stringify(this.form),
                        params: {
                            methodName: 'updatePersonInfo'
                        }
                    }).then(res => {
                        if (res.data.success) {
                            this.$message.success(res.data.message)
                            this.curResume = this.loadResume()
                        }
                    })
                }

            },
            onSubmitWorkExp() {
                // 插入
                if (this.curResume === null || this.curResume === undefined) {
                    this.$axios({
                        method: 'post',
                        url: '/resumeApi/resume',
                        data: Qs.stringify(this.workExp),
                        params: {
                            methodName: 'insertWorkExp'
                        }
                    }).then(res => {
                        if (res.data.success) {
                            this.$message.success(res.data.message)
                            this.curResume = this.loadResume()
                        }
                    })
                } else {
                    // 更新
                    this.$axios({
                        method: 'post',
                        url: '/resumeApi/resume',
                        data: Qs.stringify(this.workExp),
                        params: {
                            methodName: 'updateWorkExp'
                        }
                    }).then(res => {
                        if (res.data.success) {
                            this.$message.success(res.data.message)
                            this.curResume = this.loadResume()
                        }
                    })
                }
            },
            onSubmitStudyExp() {
                // 插入
                if (this.curResume === null || this.curResume === undefined) {
                    this.$axios({
                        method: 'post',
                        url: '/resumeApi/resume',
                        data: Qs.stringify(this.studyExp),
                        params: {
                            methodName: 'insertStudyExp'
                        }
                    }).then(res => {
                        if (res.data.success) {
                            this.$message.success(res.data.message)
                            this.curResume = this.loadResume()
                        }
                    })
                } else {
                    // 更新
                    this.$axios({
                        method: 'post',
                        url: '/resumeApi/resume',
                        data: Qs.stringify(this.studyExp),
                        params: {
                            methodName: 'updateStudyExp'
                        }
                    }).then(res => {
                        if (res.data.success) {
                            this.$message.success(res.data.message)
                            this.curResume = this.loadResume()
                        }
                    })
                }
            },
            onSubmitEvaluation() {
                // 插入
                if (this.curResume === null || this.curResume === undefined) {
                    this.$axios({
                        method: 'post',
                        url: '/resumeApi/resume',
                        data: Qs.stringify(this.evalForm),
                        params: {
                            methodName: 'insertEvaluation'
                        }
                    }).then(res => {
                        if (res.data.success) {
                            this.$message.success(res.data.message)
                            this.curResume = this.loadResume()
                        }
                    })
                } else {
                    // 更新
                    this.$axios({
                        method: 'post',
                        url: '/resumeApi/resume',
                        data: Qs.stringify(this.evalForm),
                        params: {
                            methodName: 'updateEvaluation'
                        }
                    }).then(res => {
                        if (res.data.success) {
                            this.$message.success(res.data.message)
                            this.curResume = this.loadResume()
                        }
                    })
                }
            }
        }
    }
</script>

<style scoped>
  /deep/ .el-form-item {
    display: inline-block;
  }

  /deep/ .el-form-item__content {
    margin-left: 0px !important;
  }

  /deep/ .el-input__inner {
    height: 35px;
  }

  .avatar-uploader {
    width: 84px;
    height: 84px;
    display: inline-block;
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
    top: -20px;
  }

  .avatar-uploader:hover {
    border-color: #24827f;
  }

  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 84px;
    height: 84px;
    line-height: 84px;
    text-align: center;
  }

  .avatar {
    width: 84px;
    height: 84px;
    display: block;
  }

  /deep/ .area-select.large {
    width: 290px;
    top: 3px;
  }

  /deep/ .area-select {
    line-height: 21px;
  }

  /deep/ .el-textarea__inner {
    min-height: 124px !important;
  }

  /deep/ .cascader-menu-list .cascader-menu-option.selected {
    background-color: #e4e8f1;
    color: #24827f;
    font-weight: 700;
  }
</style>
