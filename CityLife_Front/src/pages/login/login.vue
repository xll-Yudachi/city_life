<template>
  <div>
    <div id="wrap">
      <div class="sign-wrap sign-wrap-v2" style="display: block">
        <!--密码登录-->
        <div class="sign-form sign-pwd" style="display:block;">
          <div class="sign-slide-box">
            <a class="logo" href="https://www.zhipin.com/" ka="header-logo">
              <div>
                <p>找工作</p>
                <p>我要跟老板谈</p>
              </div>
            </a>
            <ul>
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
          </div>
          <div class="sign-content">
            <div class="inner-box">
              <h3 class="title">登录BOSS直聘</h3>
              <el-form :model="loginForm">
                <div class="purpose-row sign-tab" style="margin-bottom: 50px">
                  <span class="link-signin cur">密码登录</span><span class="link-sms">短信登录</span>
                </div>
                <el-form-item style="height:40px;margin-left: 0px" class="form-row" prop="phone">
                  <el-input style="width: 324px" type="tel" class="ipt-phone required" v-model="loginForm.phone"
                            placeholder="手机号" name="phone">
                    <i slot="prefix" style="display: flex;align-items: center;" class="icon-sign-phone">
                    </i>
                  </el-input>
                </el-form-item>
                <el-form-item style="height:40px;margin-left: 0px" class="form-row" prop="pwd">
                  <el-input style="width: 324px" type="password" class="ipt-pwd required" v-model="loginForm.pwd"
                            placeholder="密码" name="pwd">
                    <i slot="prefix" style="display: flex;align-items: center;" class="icon-sign-pwd">
                    </i>
                  </el-input>
                </el-form-item>
                <el-form-item>
                  <el-button @click="pwdLogin" class="btn"
                             style="width: 324px;">登录
                  </el-button>
                </el-form-item>
              </el-form>
            </div>
          </div>
        </div>


        <!--短信登录-->
       <!-- <div class="sign-form sign-sms" style="display:none;">
          <div class="sign-slide-box">
            <a class="logo" href="https://www.zhipin.com/" ka="header-logo">
              <div>
                <p>找工作</p>
                <p>我要跟老板谈</p>
              </div>
            </a>
            <ul>
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
          </div>
          <div class="sign-content">
            <div class="inner-box">
              <h3 class="title">登录BOSS直聘</h3>
              <form action="/wapi/zppassport/login/phone" method="post">
                <div class="sign-tab"><span class="link-signin">密码登录</span><span class="link-sms cur">短信登录</span></div>
                <div class="tip-error tip-error-form"></div>
                <div class="form-row row-select">
                  <span class="ipt-wrap"><i class="icon-sign-phone"></i>
                    <input type="tel" class="ipt ipt-phone required" ka="signin-account" placeholder="手机号"
                           name="phone"/>
                  </span>
                  <div class="dropdown-menu">

                    <ul>
                      <li data-val="+86"><span class="num">+86</span>中国大陆</li>
                      <li data-val="+852"><span class="num">+852</span>中国香港</li>
                      <li data-val="+853"><span class="num">+853</span>中国澳门</li>
                      <li data-val="+886"><span class="num">+886</span>中国台湾</li>
                      <li data-val="+1"><span class="num">+1</span>美国</li>
                      <li data-val="+81"><span class="num">+81</span>日本</li>
                      <li data-val="+44"><span class="num">+44</span>英国</li>
                      <li data-val="+82"><span class="num">+82</span>韩国</li>
                      <li data-val="+33"><span class="num">+33</span>法国</li>
                      <li data-val="+7"><span class="num">+7</span>俄罗斯</li>
                      <li data-val="+39"><span class="num">+39</span>意大利</li>
                      <li data-val="+61"><span class="num">+61</span>澳大利亚</li>
                      <li data-val="+65"><span class="num">+65</span>新加坡</li>
                      <li data-val="+63"><span class="num">+63</span>菲律宾</li>
                      <li data-val="+60"><span class="num">+60</span>马来西亚</li>
                      <li data-val="+64"><span class="num">+64</span>新西兰</li>
                      <li data-val="+34"><span class="num">+34</span>西班牙</li>
                      <li data-val="+95"><span class="num">+95</span>缅甸</li>
                      <li data-val="+230"><span class="num">+230</span>毛里求斯</li>
                      <li data-val="+263"><span class="num">+263</span>津巴布韦</li>
                      <li data-val="+20"><span class="num">+20</span>埃及</li>
                      <li data-val="+92"><span class="num">+92</span>巴基斯坦</li>
                      <li data-val="+880"><span class="num">+880</span>孟加拉国</li>
                    </ul>
                  </div>
                  <div class="tip-error"></div>
                </div>
                <div class="form-row">
                  <span class="ipt-wrap"><i class="icon-sign-sms"></i><input type="text" class="ipt ipt-pwd required"
                                                                             ka="signin-password" placeholder="验证码"
                                                                             name="code"/></span>
                  <div class="tip-error"></div>
                </div>
                <input type="hidden" name="csessionId">
                <input type="hidden" name="csig">
                <input type="hidden" name="ctoken">
                <input type="hidden" name="cscene" value="nc_login">
                <input type="hidden" value="FFFF0N00000000006DC1" name="cappKey">
                <div class="form-btn">
                  <button type="submit" class="btn">登录</button>
                </div>
              </form>
            </div>
          </div>
        </div>-->
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
            return {
                loginForm: {
                    phone: "",
                    pwd: "",
                    phoneCode: ""
                }
            }
        },

        //监听器
        watch: {},

        created() {

        },
        methods: {
            pwdLogin() {
                this.$axios({
                    method: "post",
                    url: "/login",
                    data: Qs.stringify(this.loginForm),
                    params:{
                        methodName : 'password'
                    }
                }).then(res => {
                    if (res.data.success) {
                        localStorage.setItem("uid", res.data.data.id)
                        window.location.href = 'index.html'
                    } else {
                        this.$message.error(res.data.message)
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

  /deep/ .el-input--prefix .el-input__inner {
    padding-left: 45px;
  }

  /deep/ .el-form-item__content {
    height: 40px;
  }

  /deep/ .el-button:focus, .el-button:hover {
    color: #5dd5c8;
    border-color: #5dd5c8;
    background-color: white;
  }

  /deep/ .el-input__inner:focus {
    border-color: #5dd5c8;
  }
</style>
