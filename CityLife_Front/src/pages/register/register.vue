<template>
  <div>
    <div id="wrap">
      <div class="sign-wrap sign-wrap-v2" style="display: block">

        <!--注册-->
        <div class="sign-form sign-register" style="display:block;">
          <div class="sign-slide-box">
            <a class="logo" href="https://www.zhipin.com/" ka="header-logo">
              <div>
                <p>找工作</p>
                <p>我要跟老板谈</p>
              </div>
            </a>
            <ul class="geek-slide ">
              <li>
                <i class="icon"></i>
                <span>沟通</span>
                <span>在线职位及时沟通</span>
              </li>
              <li>
                <i class="icon"></i>
                <span>任性选</span>
                <span>各大行业职位任你选</span>
              </li>
            </ul>
            <ul class="boss-slide hide">
              <li>
                <i class="icon"></i>
                <span>招聘效果好</span>
                <span>与职场牛人在线开聊</span>
              </li>
              <li>
                <i class="icon"></i>
                <span>更多在线牛人</span>
                <span>入职速度快</span>
              </li>
              <li>
                <i class="icon"></i>
                <span>人才匹配度高</span>
                <span>获取更精准的牛人</span>
              </li>
            </ul>
          </div>
          <div class="sign-content">
            <div class="inner-box">
              <h3 class="title">注册BOSS直聘</h3>


              <el-form :model="ruleForm" :rules="rules" ref="ruleForm" class="demo-ruleForm">
                <div class="purpose-row" style="margin-bottom: 25px">
                  <span class="cur" >我要找工作</span>
                  <span class="">我要招聘</span>
                </div>
                <el-form-item style="height:40px;margin-left: 0px" class="form-row" prop="phone">
                  <el-input style="width: 324px" type="tel" class="ipt-phone required" v-model="ruleForm.phone"
                            placeholder="手机号" name="phone">
                    <i slot="prefix" style="display: flex;align-items: center;" class="icon-sign-phone">
                    </i>
                  </el-input>
                </el-form-item>
                <el-form-item style="height:40px;margin-left: 0px" class="form-row" prop="pwd">
                  <el-input style="width: 324px" type="password" class="ipt-pwd required" v-model="ruleForm.pwd"
                            placeholder="密码" name="pwd">
                    <i slot="prefix" style="display: flex;align-items: center;" class="icon-sign-pwd">
                    </i>
                  </el-input>
                </el-form-item>
                <el-form-item style="height:40px;margin-left: 0px" class="form-row" prop="checkPwd">
                  <el-input style="width: 324px" type="password" class="ipt-pwd required" v-model="ruleForm.checkPwd"
                            placeholder="重复密码" name="checkPwd">
                    <i slot="prefix" style="display: flex;align-items: center;" class="icon-sign-pwd">
                    </i>
                  </el-input>
                </el-form-item>
                <el-form-item style="height:40px;margin-left: 0px" class="form-row" prop="phoneCode">
                  <el-input style="width:200px" type="text" class="ipt-sms required" v-model="ruleForm.phoneCode"
                            placeholder="短信验证码" name="phoneCode">
                    <i slot="prefix" style="display: flex;align-items: center;" class="icon-sign-sms">
                    </i>
                  </el-input>
                  <el-button id="smsBtn" type="button" class="btn btn-sms" @click="sendMessageCode(this)">发送验证码</el-button>
                </el-form-item>
                <el-form-item style="height: 40px">
                  <el-button id="submitBtn" disabled @click="submitForm('ruleForm')" class="btn btn-disabled"
                             style="width: 324px;">注册
                  </el-button>
                </el-form-item>
                <div class="text-tip">
                  <div class="tip-error"></div>
                  <input type="checkbox" class="agree-policy" name="policy">我已同意<a
                  href="https://www.zhipin.com/activity/cc/registerprotocol.html" target="_blank"
                  class="user-agreement">用户协议及隐私政策</a>
                  <a href="/login.html" class="link-signin">直接登录</a>
                </div>
              </el-form>


            </div>
          </div>
        </div>

        <!--注册成功完善简历-->
        <div class="sign-form sign-welcome">
          <h3 class="title">欢迎来到BOSS直聘</h3>
          <div class="welcome-box">
            <div class="welcome-text">
              <b>快速完善简历</b>
              <p>做好与Boss对话前的准备吧。</p>
            </div>
            <img src="/v2/web/geek/images/icon-sign-welcome.png" alt=""/>
            <div class="form-btn"><a ka="registe-complete" href="/web/geek/guide" class="btn">开始完善</a>
            </div>
            <div class="count-down"><em class="num">3s</em> 后自动跳转</div>
          </div>
        </div>
      </div>
    </div>
    <div style="position: absolute;right: 20px;bottom: 20px;color: #fff">
      <div class="tel"><i class="iboss-call"></i>客户服务热线: xxx xxx xxxx</div>
    </div>
  </div>
</template>

<script>
    //import teacher from '@/api/admin/edu/teacher'
    import Qs from 'qs'
    export default {
        //组件
        components: {},
        // 定义数据
        data() {
            let validatePhone = (rule, value, callback) => {
                if (!(/^1[3|4|5|7|8][0-9]{9}$/).test(value)) {
                    callback(new Error('请输入正确的手机号'));
                } else {
                    callback()
                }
            };
            let validatePwd = (rule, value, callback) => {
                if (value.length <= 7 || value.length >= 16) {
                    callback(new Error('密码长度为8-15位'));
                } else {
                    callback()
                }
            };
            let validatecheckPwd = (rule, value, callback) => {
                if (value !== this.ruleForm.pwd) {
                    callback(new Error('两次密码不一致'));
                } else {
                    callback()
                }
            };
            let validatephoneCode = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请输入短信验证码'))
                } else {
                    callback()
                }
            }

            return {
                registerInfo: {
                    phone: '',
                    pwd: '',
                    phoneCode: '',
                    rank:''
                },
                ruleForm: {
                    phone: '',
                    pwd: '',
                    checkPwd: '',
                    phoneCode: '',
                },
                rules: {
                    phone: [
                        {validator: validatePhone, required: true, trigger: 'blur'}
                    ],
                    pwd: [
                        {validator: validatePwd, required: true, trigger: 'blur'}
                    ],
                    checkPwd: [
                        {validator: validatecheckPwd, required: true, trigger: 'blur'}
                    ],
                    phoneCode: [
                         {validator: validatephoneCode , required: true, trigger: 'blur' }
                    ]
                }
            }
        },

        //监听器
        watch: {},

        created() {

        },

        methods: {
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        this.registerInfo.phone = this.ruleForm.phone
                        this.registerInfo.pwd = this.ruleForm.pwd
                        this.registerInfo.phoneCode = this.ruleForm.phoneCode
                        if ("我要找工作" === $(".purpose-row > span[class=cur]")[0].innerText){
                            this.registerInfo.rank = 0
                        }else{
                            this.registerInfo.rank = 1
                        }
                        this.$axios({
                            method: 'post',
                            url: "/register",
                            data: Qs.stringify(this.registerInfo)
                        }).then(res=>{
                            if (res.data.success){
                                window.location.href = "/login.html"
                            }else{
                                this.$message.error(res.data.message)
                            }
                        })
                    } else {
                        this.$message.error('请正确填写信息！');
                        return false;
                    }
                });
            },

            sendMessageCode(item){
                //点击按钮时，按钮禁用
                $('#smsBtn').attr("disabled", true)
                $('#smsBtn').addClass('btn-disabled')
                // 倒计时60秒
                let index = 60;
                // 按钮文字为获取验证码(60)
                $('#smsBtn')[0].innerText = `重新获取 (${index}) `;
                // 定时器，延迟 1s
                let timer = setInterval(function () {
                    index--;
                    $('#smsBtn')[0].innerText = `重新获取 (${index}) `;
                    // 当倒计时等等为0时
                    if (index == 0) {
                        // 停止计时
                        clearInterval(timer);
                        // 按钮禁用取消
                        $('#smsBtn').removeAttr('disabled');
                        $('#smsBtn').removeClass('btn-disabled')
                        // 将文字值重置为获取验证码
                        $('#smsBtn')[0].innerText = '发送验证码';
                    }
                }, 1000)
                this.$axios({
                    method: 'get',
                    url: "/sms",
                    params:{
                        phone: this.ruleForm.phone
                    }
                }).then(response=>{
                    if (!response.data.success){
                        this.$message.error(response.data.message)
                    }
                })
            }
        },

        mounted() {
        }
    }
</script>

<style scoped>
  #wrap {
    position: static;
  }

  #wrap {
    min-height: 100%;
    overflow: visible;
    /* overflow-x: hidden; */
  }

  .sign-form .ipt-phone {
    padding-left: 0px;
    width: 266px;
  }

  .sign-form .ipt-pwd {
    padding-left: 0px;
    width: 266px;
  }

  .sign-form .ipt-sms {
    padding-left: 0px;
    width: 266px;
  }

  /deep/ .el-input--prefix .el-input__inner {
    padding-left: 45px;
  }

  /deep/ .el-form-item__content {
    height: 40px;
  }

  .page-sign .sign-wrap-v2 .text-tip {
    padding: 0 0 0 0
  }

  /deep/ .el-input__inner:focus {
    border-color: #5dd5c8;
  }

  /deep/ .el-button:focus, .el-button:hover {
    color: #5dd5c8;
    border-color: #c6e2ff;
    background-color: white;
  }

  .sign-form .btn-sms {
    width: 110px;
    top: 3px;
    padding-left: 10px;
    font-size: 14px;
    background-color: #fff;
    background-position: 0 -356px;
    min-width: 109px;
    color: #5dd5c8;
    border: 0;
    margin-left: 10px;
  }
</style>
