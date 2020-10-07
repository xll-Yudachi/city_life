<template>
  <div>
    <div id="wrap" class="search-job-list-wrap">
      <div id="header">
        <div class="inner home-inner">
          <div class="logo">
            <a href="https://www.zhipin.com/" ka="header-home-logo" title="BOSS直聘"><span>BOSS直聘</span></a>
          </div>
          <div class="nav">
            <ul>
              <li class=""><a ka="header-home" href="/">首页</a></li>
              <li class="cur"><a ka="header-job" href="https://www.zhipin.com/job_detail/">职位</a></li>
              <li class=""><a class="nav-school-new" ka="header-school" href="https://www.zhipin.com/xiaoyuan/">校园</a>
              </li>
              <li class=""><a ka="header_brand" href="https://www.zhipin.com/gongsi/">公司</a></li>
              <li class=""><a ka="header-app" href="https://app.zhipin.com/">APP</a></li>
              <li class=""><a ka="header-article" href="https://news.zhipin.com/">资讯</a></li>
            </ul>
          </div>
          <div class="user-nav">
            <!--未登录-->
            <div class="btns">
              <a href="https://www.zhipin.com/geek/attresume/parser.html" rel="nofollow" ka="nlp_resume_upload"
                 class="link-sign-resume" title="上传简历，解析内容，完善注册">上传简历</a>
              <a href="https://www.zhipin.com/geek/attresume/parser.html" rel="nofollow" ka="header-geek"
                 class="link-sign-resume" title="上传简历，解析内容，完善注册">我要找工作<span class="new"
                                                                            style="display: inline;">hot</span></a>
              <a href="https://signup.zhipin.com?intent=1" rel="nofollow" class="link-scan" ka="header-boss"
                 title="我要招聘">我要招聘</a>
              <a href="https://signup.zhipin.com" ka="header-register" class="btn btn-outline">注册</a>
              <a href="https://login.zhipin.com" ka="header-login" class="btn btn-outline">登录</a>
            </div>
          </div>
        </div>
      </div>
      <div id="filter-box">
        <div class="inner home-inner">
          <div class="search-box">
            <div class="search-form ">
                <div class="search-form-con">
                  <div class="city-sel">
                    <i class="line"></i>
                    <span class="label-text"><b>全国</b><i class="icon-arrow-down"></i></span>
                  </div>
                  <div class="industry-sel" ka="search_bos_sel_industry">
                    <i class="line"></i>
                    <span class="label-text"><b>公司行业</b><i class="icon-arrow-down"></i></span>
                  </div>
                  <div class="position-sel" ka="search_box_sel_jobtype">
                    <i class="line"></i>
                    <span class="label-text"><b>职位类型</b><i class="icon-arrow-down"></i></span>
                  </div>
                  <p class="ipt-wrap"><input type="text" name="query" value="" autocomplete="off" v-model="query.keyword" class="ipt-search" maxlength="50" placeholder="搜索职位、公司"></p>
                </div>
                <button class="btn btn-search" @click="submitSearch">搜索</button>
                <div class="suggest-result">
                  <ul>
                  </ul>
                </div>
                <div class="city-box">
                  <ul class="dorpdown-province">
                  </ul>
                  <div class="dorpdown-city">
                  </div>
                </div>
                <div class="industry-box">
                  <ul>
                  </ul>
                </div>
                <div class="position-box">
                  <div class="dropdown-menu">
                    <!--<script>
                        var jobData = positionList;
                    </script>-->
                    <div class="select-tree" data-level="3"></div>
                  </div>
                </div>
            </div>
            <!-- 广告 -->
            <!--
            <div class="search-banner">
                <img src="http://172.16.24.210/v2/web/geek/images/listbanner.png" alt="">
            </div>
            -->
          </div>
          <div class="condition-box">
            <dl class="condition-city show-condition-district">
              <dd class="city-wrapper">
                <a href="javascript:;" class="disabled" title="全国招聘">全国</a>
                <span class="hot-text">热门城市：</span>
                <a href="/c100010000/" ka="sel-city-100010000">全国</a>
                <a href="/c101010100/" ka="sel-city-101010100">北京</a>
                <a href="/c101020100/" ka="sel-city-101020100">上海</a>
                <a href="/c101280100/" ka="sel-city-101280100">广州</a>
                <a href="/c101280600/" ka="sel-city-101280600">深圳</a>
                <a href="/c101210100/" ka="sel-city-101210100">杭州</a>
                <a href="/c101030100/" ka="sel-city-101030100">天津</a>
                <a href="/c101110100/" ka="sel-city-101110100">西安</a>
                <a href="/c101190400/" ka="sel-city-101190400">苏州</a>
                <a href="/c101200100/" ka="sel-city-101200100">武汉</a>
                <a href="/c101230200/" ka="sel-city-101230200">厦门</a>
                <a href="/c101250100/" ka="sel-city-101250100">长沙</a>
                <a href="/c101270100/" ka="sel-city-101270100">成都</a>
                <a href="/c101180100/" ka="sel-city-101180100">郑州</a>
                <a href="/c101040100/" ka="sel-city-101040100">重庆</a>
                <a href="javascript:;" class="btn-allcity">全部城市</a>
              </dd>
            </dl>
          </div>
          <div class="box-shadow-box"></div>
          <div class="filter-select-box">
            <div class="dropdown-wrap">
              <el-dropdown @command="handleExpCommand">
                <span class="dropdown-select">
                  <input type="text" id="sel-exp" value="工作经验" class="ipt" readonly>
                  <i class="icon-select-arrow"></i>
                         <el-dropdown-menu slot="dropdown">
                           <el-dropdown-item command="工作经验">不限</el-dropdown-item>
                           <el-dropdown-item command="在校生">在校生</el-dropdown-item>
                           <el-dropdown-item command="应届生">应届生</el-dropdown-item>
                           <el-dropdown-item command="1年以内">1年以内</el-dropdown-item>
                           <el-dropdown-item command="1-3年">1-3年</el-dropdown-item>
                           <el-dropdown-item command="3-5年">3-5年</el-dropdown-item>
                           <el-dropdown-item command="5-10年">5-10年</el-dropdown-item>
                           <el-dropdown-item command="10年以上">10年以上</el-dropdown-item>
                         </el-dropdown-menu>
                    </span>
              </el-dropdown>
            </div>
            <div class="dropdown-wrap">
              <el-dropdown @command="handleDegreeCommand">
                <span class="dropdown-select">
                            <input type="text" id="sel-degree" value="学历要求" class="ipt" readonly>
 <i class="icon-select-arrow"></i>
                         <el-dropdown-menu slot="dropdown">
                           <el-dropdown-item command="学历要求">不限</el-dropdown-item>
                           <el-dropdown-item command="初中及以下">初中及以下</el-dropdown-item>
                           <el-dropdown-item command="中专/中技">中专/中技</el-dropdown-item>
                           <el-dropdown-item command="高中">高中</el-dropdown-item>
                           <el-dropdown-item command="大专">大专</el-dropdown-item>
                           <el-dropdown-item command="本科">本科</el-dropdown-item>
                           <el-dropdown-item command="硕士">硕士</el-dropdown-item>
                           <el-dropdown-item command="博士">博士</el-dropdown-item>
                         </el-dropdown-menu>
                    </span>
              </el-dropdown>
            </div>
            <div class="dropdown-wrap">
              <el-dropdown>
                <span class="dropdown-select">
                            <input type="text" ka="sel-exp" value="薪资要求" class="ipt" readonly>
 <i class="icon-select-arrow"></i>
                         <el-dropdown-menu slot="dropdown">
                           <el-dropdown-item command="1">不限</el-dropdown-item>
                           <el-dropdown-item command="2">3K以下</el-dropdown-item>
                           <el-dropdown-item command="3">3-5K</el-dropdown-item>
                           <el-dropdown-item command="4">5-10K</el-dropdown-item>
                           <el-dropdown-item command="5">10-15K</el-dropdown-item>
                           <el-dropdown-item command="6">15-20K</el-dropdown-item>
                           <el-dropdown-item command="7">20-30K</el-dropdown-item>
                           <el-dropdown-item command="8">30K-50K</el-dropdown-item>
                           <el-dropdown-item command="9">50K以上</el-dropdown-item>
                         </el-dropdown-menu>
                    </span>
              </el-dropdown>
            </div>
            <div class="dropdown-wrap">
              <el-dropdown>
                <span class="dropdown-select">
                            <input type="text" ka="sel-exp" value="融资阶段" class="ipt" readonly>
 <i class="icon-select-arrow"></i>
                         <el-dropdown-menu slot="dropdown">
                           <el-dropdown-item command="1">不限</el-dropdown-item>
                           <el-dropdown-item command="2">未融资</el-dropdown-item>
                           <el-dropdown-item command="3">天使轮</el-dropdown-item>
                           <el-dropdown-item command="4">A轮</el-dropdown-item>
                           <el-dropdown-item command="5">B轮</el-dropdown-item>
                           <el-dropdown-item command="6">C轮</el-dropdown-item>
                           <el-dropdown-item command="7">D轮及以上</el-dropdown-item>
                           <el-dropdown-item command="8">已上市</el-dropdown-item>
                           <el-dropdown-item command="9">不需要融资</el-dropdown-item>
                         </el-dropdown-menu>
                    </span>
              </el-dropdown>
            </div>
            <div class="dropdown-wrap">
              <el-dropdown>
                <span class="dropdown-select">
                            <input type="text" ka="sel-exp" value="公司规模" class="ipt" readonly>
 <i class="icon-select-arrow"></i>
                         <el-dropdown-menu slot="dropdown">
                           <el-dropdown-item command="1">不限</el-dropdown-item>
                           <el-dropdown-item command="2">0-20人</el-dropdown-item>
                           <el-dropdown-item command="3">20-99人</el-dropdown-item>
                           <el-dropdown-item command="4">100-499人</el-dropdown-item>
                           <el-dropdown-item command="5">500-999人</el-dropdown-item>
                           <el-dropdown-item command="6">1000-9999人</el-dropdown-item>
                           <el-dropdown-item command="7">10000人以上</el-dropdown-item>
                         </el-dropdown-menu>
                    </span>
              </el-dropdown>
            </div>
            <a href="/c100010000/?query=" ka="empty-filter" class="empty-filter" rel="nofollow">清空筛选条件</a>
          </div>
        </div>
      </div>
      <div id="main" class="inner home-inner">
        <div class="job-box">
          <div class="sider">

            <div class="sign-wrap sign-wrap-v2">
              <div class="sign-form sign-quick" style="display: block;">
                <canvas id="sign-side" width="250" height="50"></canvas>
                <h3 class="title">各大行业职位任你选</h3>
                <form action="/wapi/zppassport/login/phone" method="post" ka="sup_g_right_done">
                  <div class="tip-error tip-error-form"></div>
                  <div class="form-row row-select">
                  <i class="icon-sign-phone"></i><input type="tel" style="width: 166px" class="ipt ipt-phone required" ka="signin-account" placeholder="手机号" name="phone"/>
                  </div>
                  <div class="form-row">
                    <div class="row-code" id="loginVerrifyCode2"></div>
                    <div class="tip-error"></div>
                  </div>
                  <div class="form-row">
                             <span class="ipt-wrap">
                                 <i class="icon-sign-sms"></i>
                                 <input type="text" class="ipt ipt-sms required" ka="signup-sms" placeholder="短信验证码"
                                        name="phoneCode" maxlength="6"/>
                                 <input type="hidden" name="smsType" value="7"/>
                                 <button type="button" class="btn btn-sms" data-url="/wapi/zppassport/send/smsCode">发送验证码</button>
                             </span>
                    <div class="tip-error"></div>
                  </div>
                  <div class="form-btn">
                    <button type="submit" class="btn" ka="sup_g_right">登录/注册</button>
                  </div>
                  <div class="text-tip">
                    <input type="checkbox" class="agree-policy" name="policy">我已同意<a
                    href="https://www.zhipin.com/activity/cc/registerprotocol.html" target="_blank" rel="nofollow">用户协议及隐私政策</a>
                  </div>
                </form>
              </div>
            </div>

            <div class="complete-resume">
              <a href="https://www.zhipin.com/geek/attresume/parser.html" class="btn" rel="nofollow">上传简历一键注册</a>
            </div>
            <div class="sider-list" style="display:none">
              <h3>看过的职位</h3>
              <ul>
              </ul>
            </div>
            <!--<div class="promotion-img nomargin"><a href="/activity/personality/index.html" target="_blank" ka="ad_banner_0"><img src="https://z.zhipin.com/web/upload/market/coop/20180421-03.jpg" alt="" /></a></div> -->
            <div class="promotion-img"><a href="/app.html" target="_blank" ka="ad_banner_1" rel="nofollow"><img
              src="https://static.zhipin.com/zhipin-geek/v309/web/geek/images/pro-1.png" alt=""/></a></div>
            <div class="promotion-img"><a href="/user/login.html?initType=3" target="_blank" ka="ad_banner_2"
                                          rel="nofollow"><img
              src="https://static.zhipin.com/zhipin-geek/v309/web/geek/images/pro-2.png" alt=""/></a></div>
          </div>
          <div class="job-list">
            <div class="job-tab" style="display: none" data-filter="" data-keyword="" data-l3code="" data-rescount="64"
                 data-page="1" data-source="2">
              <a href="javascript:;" class="cur" ka="recommend-job-list">热门职位</a><a href="javascript:;"
                                                                                    ka="new-job-list">最新职位</a>
            </div>

            <div class="company-list">
            </div>
            <ul>
              <li @click="toJobDetail(item.jobId)" v-for="item in rows">
                <div class="job-primary">
                  <div class="info-primary">
                    <div class="primary-wrapper">
                      <div class="primary-box" href="/job_detail/40dd7b708ab8764133R83dW0E1E~.html"
                           data-jid="40dd7b708ab8764133R83dW0E1E~" data-itemid="1" data-lid="nlp-4nYdJngY70S.search.1"
                           data-jobid="80668933" data-index="0" ka="search_list_1" target="_blank">
                        <div class="job-title">
                          <span class="job-name"><a href="/job_detail/40dd7b708ab8764133R83dW0E1E~.html"
                                                    title="（异地招聘）java开发工程师/python测试" target="_blank"
                                                    ka="search_list_jname_1" data-jid="40dd7b708ab8764133R83dW0E1E~"
                                                    data-itemid="1" data-lid="nlp-4nYdJngY70S.search.1"
                                                    data-jobid="80668933"
                                                    data-index="0" v-html="item.jobName"></a></span>
                          <span class="job-area-wrapper">
                                                        <span class="job-area" v-html="item.jobProvince"></span>
                                                    </span>
                          <span class="job-pub-time"></span>
                        </div>
                        <div class="job-limit clearfix">
                          <span class="red">{{item.jobSalary}}</span>
                          <p>{{item.jobExp}}<em class="vline"></em>{{item.jobDegree}}</p>
                          <div class="info-publis">
                            <h3 class="name"><img class="icon-chat"
                                                  src="https://z.zhipin.com/web/geek/resource/icon-chat-v2.png"/>尹先生<em
                              class="vline"></em>招聘经理</h3>
                          </div>
                          <button class="btn btn-startchat" href="javascript:;"
                                  data-url="/wapi/zpgeek/friend/add.json?jobId=40dd7b708ab8764133R83dW0E1E~&lid=nlp-4nYdJngY70S.search.1"
                                  redirect-url="/web/geek/chat?id=13dbfc56e23b048203Bz2tq6FVc~">
                            <img class="icon-chat icon-chat-hover"
                                 src="https://z.zhipin.com/web/geek/resource/icon-chat-hover-v2.png" alt="">
                            <span>立即沟通</span>
                          </button>
                        </div>
                        <div class="info-detail"></div>
                      </div>
                    </div>
                    <div class="info-company">
                      <div class="company-text">
                        <h3 class="name"><a href="javascript:void(0)" :title="item.comName"
                                            ka="search_list_company_1_custompage" v-html="item.comAbbreviation"></a></h3>
                        <p><a href="/i100021/" class="false-link" target="_blank"
                              ka="search_list_company_industry_1_custompage" :title="item.comIndustry">{{item.comIndustry}}</a><em
                          class="vline"></em>{{comStage[item.comStage]}}<em class="vline"></em>{{item.comScale}}</p>
                      </div>
                      <a href="javascript:void(0)"><img class="company-logo" :src="baseImageUrl + item.comLogo" alt=""></a>
                    </div>
                  </div>
                  <div class="info-append clearfix">
                    <div class="tags">
                      <span class="tag-item" v-for="skill in item.jobSkillTag.split(',')">{{skill}}</span>
                    </div>
                    <div class="info-desc">{{item.comWelfare.join(",")}}</div>
                  </div>
                </div>
              </li>
            </ul>
            <el-pagination
              style="text-align: center; margin: 30px 0;"
              background
              layout="prev, pager, next"
              :page-size="size"
              :current-page.sync="currentPage"
              @current-change="handleCurrentChange"
              :total="total">
            </el-pagination>
          </div>
          <form class="satisfaction-feedback">
            <b class="title">对搜索结果是否满意？</b>
            <div class="satisfaction level-2" data-level="1">不满意</div>
            <div class="satisfaction level-3" data-level="2">一般</div>
            <div class="satisfaction level-4" data-level="3">满意</div>
            <textarea class="ipt" name="feedback" placeholder="请填写更多反馈建议..."></textarea>
            <button class="btn disabled" disabled="disabled">提交</button>
            <input type="hidden" class="form-data" name="level" value=""/>
            <input type="hidden" class="form-data" name="query" value=""/>
            <input type="hidden" class="form-data" name="c" value="100010000"/>
            <input type="hidden" class="form-data" name="i" value=""/>
            <input type="hidden" class="form-data" name="p" value=""/>
            <input type="hidden" class="form-data" name="e" value=""/>
            <input type="hidden" class="form-data" name="d" value=""/>
            <input type="hidden" class="form-data" name="s" value=""/>
            <input type="hidden" class="form-data" name="y" value=""/>
            <input type="hidden" class="form-data" name="t" value=""/>
            <input type="hidden" class="form-data" name="a" value=""/>
            <input type="hidden" class="form-data" name="b" value=""/>
            <input type="hidden" class="form-data" name="lid" value="nlp-4nYdJngY70S"/>
          </form>
          <div class="pos-bread">
            <a href="/" title="BOSS直聘招聘" ka="job-breadcrumb-bottom-0">BOSS直聘招聘</a>&gt;
            <h1 class="link-redirect"><a href="/c100010000/" title="全国招聘" ka="job-breadcrumb-bottom-1">全国招聘</a></h1>
          </div>
        </div>
      </div>


      <!-- 通用侧边栏 -->
      <div id="siderbar">
        <div class="sider-index">
          <ul class="siderbar-top">
            <li data-value="interest">
              <a href="javascript:;" ka="side_interest"><i class="icon-sider-interest"></i>感兴趣</a>
            </li>
            <li data-value="contact">
              <a href="javascript:;" ka="side_chat"><i class="icon-sider-chat"></i>沟通过</a>
            </li>
            <li data-value="deliver">
              <a href="javascript:;" ka="side_deliver"><i class="icon-sider-resume"></i>已投递</a>
            </li>
            <li data-value="interview">
              <a href="javascript:;" ka="side_interview"><i class="icon-sider-interview"></i>面试</a>
            </li>
          </ul>
          <ul class="siderbar-bottom">
            <li>
              <a class="siderbar-back-top" href="javascript:;" title="返回顶部"></a>
            </li>
            <li>
              <a class="siderbar-feedback" href="javascript:;">反馈</a>
            </li>
            <li>
              <a class="siderbar-wechat" href="javascript:;">微信
                <div class="qrcode-layer "><i></i><img
                  src="https://static.zhipin.com/v2/web/geek/images/wechat-qrcode.jpg" alt="">关注BOSS直聘微信服务号
                </div>
              </a>
            </li>
            <li>
              <a class="siderbar-app" href="javascript:;">APP
                <div class="qrcode-layer"><i></i><img
                  src="/wapi/zpgeek/qrcode/generate.json?content=https%3A%2F%2Fwww.zhipin.com%2Fd%2Fv2%2F%3Ftype%3Dqr%26pkn%3Dmain-m%26sid%3Dmoren_14&w=200&h=200"
                  alt="">下载BOSS直聘APP
                </div>
              </a>
            </li>
          </ul>
        </div>
      </div>

      <!--通用注册登录-->
      <div class="sign-wrap sign-wrap-v2" style="display: none">


        <!--密码登录-->
        <div class="sign-form sign-pwd" style="display:none;">
          <div class="sign-slide-box">
            <a class="logo" href="https://www.zhipin.com/" ka="header-logo">
              <img src="https://static.zhipin.com/v2/web/geek/images/logo.png">
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
              <form action="/wapi/zppassport/login/account" method="post">
                <div class="sign-tab"><span class="link-signin cur">密码登录</span><span class="link-sms">短信登录</span><span
                  class="link-scan">扫码登录</span></div>
                <div class="tip-error tip-error-form"></div>
                <div class="form-row row-select">
                  <span class="dropdown-select"><i class="icon-select-arrow"></i><em class="text-select">+86</em><input
                    type="hidden" name="regionCode" value="+86"/></span>
                  <span class="ipt-wrap"><i class="icon-sign-phone"></i><input type="tel" class="ipt ipt-phone required"
                                                                               ka="signin-account" placeholder="手机号"
                                                                               name="account"/></span>
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
                  <span class="ipt-wrap"><i class="icon-sign-pwd"></i><input type="password"
                                                                             class="ipt ipt-pwd required"
                                                                             ka="signin-password" placeholder="密码"
                                                                             name="password"/></span>
                  <div class="tip-error"></div>
                </div>
                <div class="form-row">
                  <div class="row-code" id="pwdVerrifyCode">
                  </div>
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
                <div class="text-tip">没有账号 <a href="javascript:;" class="link-signup">立即注册</a></div>
              </form>
            </div>
          </div>
        </div>

        <!--短信登录-->
        <div class="sign-form sign-sms" style="display:none;">
          <div class="sign-slide-box">
            <a class="logo" href="https://www.zhipin.com/" ka="header-logo">
              <img src="https://static.zhipin.com/v2/web/geek/images/logo.png">
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
                <div class="sign-tab"><span class="link-signin">密码登录</span><span class="link-sms cur">短信登录</span><span
                  class="link-scan">扫码登录</span></div>
                <div class="tip-error tip-error-form"></div>
                <div class="form-row row-select">
                  <span class="dropdown-select"><i class="icon-select-arrow"></i><em class="text-select">+86</em><input
                    type="hidden" name="regionCode" value="+86"/></span>
                  <span class="ipt-wrap"><i class="icon-sign-phone"></i><input type="tel" class="ipt ipt-phone required"
                                                                               ka="signin-account" placeholder="手机号"
                                                                               name="phone"/></span>
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
                  <div class="row-code" id="loginVerrifyCode">
                  </div>
                  <div class="tip-error"></div>
                </div>
                <input type="hidden" name="csessionId">
                <input type="hidden" name="csig">
                <input type="hidden" name="ctoken">
                <input type="hidden" name="cscene" value="nc_login">
                <input type="hidden" value="FFFF0N00000000006DC1" name="cappKey">
                <div class="form-row">
                        <span class="ipt-wrap"><i class="icon-sign-sms"></i><input type="text"
                                                                                   class="ipt ipt-sms required"
                                                                                   ka="signup-sms" placeholder="短信验证码"
                                                                                   name="phoneCode"
                                                                                   maxlength="6"/><input
                          type="hidden" name="smsType" value="1"/><button type="button" class="btn btn-sms"
                                                                          data-url="/wapi/zppassport/send/smsCode">发送验证码</button></span>
                  <div class="tip-error"></div>
                </div>
                <div class="form-btn">
                  <button type="submit" class="btn">登录</button>
                </div>
                <div class="text-tip">没有账号 <a href="javascript:;" class="link-signup">立即注册</a></div>
              </form>
            </div>
          </div>
        </div>

        <!--扫码登录-->
        <div class="sign-form sign-scan" style="display:none;">
          <div class="sign-slide-box">
            <a class="logo" href="https://www.zhipin.com/" ka="header-logo">
              <img src="https://static.zhipin.com/v2/web/geek/images/logo.png">
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
              <div class="tip-error tip-error-form"></div>
              <div class="sign-tab"><span class="link-signin">密码登录</span><span class="link-sms">短信登录</span><span
                class="link-scan cur">扫码登录</span></div>
              <div class="qrcode-box">
                <input type="hidden" class="uuid" value=""/>
                <p><span>使用 BOSS直聘 APP 扫码登录</span><em>扫码帮助</em></p>
                <div class="qrcodeimg-box">
                  <div class="invalid-box">
                    <p>请重新刷新二维码</p>
                    <button class="btn">点击刷新</button>
                  </div>
                  <img src="" data-url="https://www.zhipin.com/qrscan/dispatcher?qrId="/>
                </div>
                <div class="qrcode-tip"><span class="gray">知道了</span>Boss现在也可以使用密码和短信登录了</div>
                <div class="hover-range-left"></div>
                <div class="hover-range-right"></div>
                <div class="sign-scan-help animation">
                  <h4>扫码帮助</h4>
                  <ul class="scan-help-tab">
                    <li class="active">我是BOSS</li>
                    <li>我是牛人</li>
                  </ul>
                  <div class="sub-title">我的&nbsp;&gt;&nbsp;登录网页版</div>
                  <ul class="scan-help-content">
                    <li class="help-boss active"></li>
                    <li class="help-geek"></li>
                  </ul>
                </div>
              </div>
              <div class="text-tip">没有账号 <a href="javascript:;" class="link-signup">立即注册</a></div>
              <div class="login-step-box">
                <div class="user-photo">
                  <img src="">
                </div>
                <div class="login-step-text">
                  <h3 class="login-step-title">扫描成功</h3>
                  <p class="login-step-detail">请在App端确认登录</p>
                </div>
              </div>
            </div>
          </div>
        </div>

        <!--注册-->
        <div class="sign-form sign-register" style="display:block;">
          <div class="sign-slide-box">
            <a class="logo" href="https://www.zhipin.com/" ka="header-logo">
              <img src="https://static.zhipin.com/v2/web/geek/images/logo.png">
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
              <form action="/wapi/zppassport/user/registered" method="post">
                <input type="hidden" name="act" value="">
                <input type="hidden" name="purpose" value="">
                <h4></h4>
                <div class="tip-error tip-error-form"></div>
                <div class="form-row row-select">
                  <span class="dropdown-select"><i class="icon-select-arrow"></i><em class="text-select">+86</em><input
                    type="hidden" name="regionCode" value="+86"/></span>
                  <span class="ipt-wrap"><i class="icon-sign-phone"></i><input type="tel" class="ipt ipt-phone required"
                                                                               ka="signin-account" placeholder="手机号"
                                                                               name="phone"/></span>
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
                  <div class="row-code" id="regVerrifyCode"></div>
                  <div class="tip-error"></div>
                </div>

                <input type="hidden" name="csessionId">
                <input type="hidden" name="csig">
                <input type="hidden" name="ctoken">
                <input type="hidden" name="cscene" value="nc_login">
                <input type="hidden" value="FFFF0N00000000006DC1" name="cappKey">
                <div class="form-row">
                  <span class="ipt-wrap"><i class="icon-sign-sms"></i>
                      <input type="text" class="ipt ipt-sms required" ka="signup-sms" placeholder="短信验证码"
                             name="phoneCode" maxlength="6"/>
                      <input type="hidden" name="smsType" value="2"/>
                      <button type="button" class="btn btn-sms" data-url="/wapi/zppassport/send/smsCode">发送验证码</button>
                  </span>
                  <div class="tip-error"></div>
                </div>
                <div class="form-btn">
                  <button type="submit" class="btn">注册</button>
                </div>
                <div class="text-tip">
                  <a href="https://www.zhipin.com/activity/cc/registerprotocol.html" target="_blank"
                     class="user-agreement">注册代表你已同意用户协议及隐私政策</a>
                  <a href="javascript:;" class="link-signin">直接登录</a>
                </div>
              </form>
            </div>
            <div class="btn-switch ewm-switch">
              <div class="switch-tip">微信极速注册<i class="icon-triangle"></i></div>
            </div>
          </div>
        </div>

        <!--扫码小程序注册-->
        <div class="sign-form sign-miniapp" style="display: none;">
          <div class="sign-slide-box">
            <a class="logo" href="https://www.zhipin.com/" ka="header-logo">
              <img src="https://static.zhipin.com/v2/web/geek/images/logo.png">
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
              <input type="hidden" class="scene" value="bbec740fc41e4cefb9a15ff21a3ec875"/>
              <h4>微信快速注册</h4>
              <div class="qrcodeimg-box">
                <div class="invalid-box">
                  <p>请重新刷新二维码</p>
                  <button class="btn">点击刷新</button>
                </div>
                <img src="" data-url="https://www.zhipin.com/qrscan/dispatcher?qrId=bbec740fc41e4cefb9a15ff21a3ec875">
              </div>
              <p class="sign-tip">请用微信“扫一扫”扫描上方二维码<br/>进入快捷注册</p>
              <div class="text-tip">已有账号 <a href="javascript:;" class="link-signin">立即登录</a></div>
            </div>
            <div class="btn-switch phone-switch">
              <div class="switch-tip">手机号注册在这里<i class="icon-triangle"></i></div>
            </div>
          </div>
        </div>

        <!--扫码小程序注册成功-->
        <div class="sign-form sign-succ">
          <h3 class="title">注册BOSS直聘</h3>
          <img class="img-succ" src="https://static.zhipin.com/zhipin-geek/v309/web/geek/images/success.png"/>
          <p>注册成功，即将跳转完善流程</p>
          <div class="btn-switch phone-switch"></div>
        </div>

        <!--注册成功完善简历-->
        <div class="sign-form sign-welcome">
          <h3 class="title">欢迎来到BOSS直聘</h3>
          <div class="welcome-box">
            <div class="welcome-text">
              <b>快速完善简历</b>
              <p>做好与Boss对话前的准备吧。</p>
            </div>
            <img src="https://static.zhipin.com/v2/web/geek/images/icon-sign-welcome.png" alt=""/>
            <div class="form-btn"><a ka="registe-complete" href="/web/geek/guide" class="btn">开始完善</a>
            </div>
            <div class="count-down"><em class="num">3s</em> 后自动跳转</div>
          </div>
        </div>
      </div>
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
                total: 0,
                size: 5,
                page: 1,
                rows:[],
                empType:{},
                comStage:{},
                query:{
                    keyword:'',
                    page: 1,
                    size: 5
                },
                currentPage: 1
            }
        },

        //监听器
        watch: {},

        created() {
            this.loadUser()
            this.findAllComStage()
            this.findAllEmpType()
            this.findAllJobInfo()
        },

        methods: {
            loadUser() {
                if (localStorage.getItem('uid') !== null) {
                    this.$axios({
                        method: 'get',
                        url: '/user',
                        params: {
                            methodName: 'findUserById',
                            uid: localStorage.getItem('uid')
                        }
                    }).then(res => {
                        if (res.data.success) {
                            this.showUser.username = res.data.data.username
                            this.showUser.rank = res.data.data.rank
                        }
                    })
                }else{
                    window.location.href="/login.html"
                }
            },
            highLightSearch(){
                this.$axios({
                    method:'post',
                    url:'/esApi/elasticsearch',
                    data: Qs.stringify(this.query),
                    params:{
                        methodName:'highLightSearch'
                    }
                }).then(res=>{
                    if (res.data.success){
                        this.rows = res.data.data.rows
                        this.total = res.data.data.total
                    }
                })
            },
            submitSearch(){
                // 数据库查询
                if (this.query.keyword === ''){
                    this.page = 1
                    this.currentPage = 1
                    this.findAllJobInfo()
                }else{
                   // ES查询
                    this.query.page = 1
                    this.currentPage = 1
                    this.highLightSearch()
                }
            },
            findAllEmpType(){
                this.$axios({
                    method:'get',
                    url:'/companyApi/company',
                    params:{
                        methodName:'findAllEmpType'
                    }
                }).then(res=>{
                    this.empType = eval('(' + res.data + ')');
                })
            },
            findAllComStage(){
                this.$axios({
                    method:'get',
                    url:'/companyApi/company',
                    params:{
                        methodName:'findAllComStage'
                    }
                }).then(res=>{
                    this.comStage = eval('(' + res.data + ')');
                })
            },
            findAllJobInfo() {
                this.$axios({
                    method: 'get',
                    url: '/jobApi/job',
                    params: {
                        methodName: "findAllByPage",
                        page: this.page,
                        size: this.size
                    }
                }).then(res=>{
                    if (res.data.success){
                        this.rows = res.data.data.rows
                        this.total = res.data.data.total
                    }
                })
            },
            toJobDetail(jobId) {
                window.location.href = "/jobDetail.html?jobId=" + jobId
            },
            handleExpCommand(command) {
                $("#sel-exp").val(command)
                if ("工作经验" !== command) {
                    $("#sel-exp").css('color', '#fc703e')
                } else {
                    $("#sel-exp").css('color', 'black')
                }
            },
            handleDegreeCommand(command) {
                $("#sel-degree").val(command)
                if ("学历要求" !== command) {
                    $("#sel-degree").css('color', '#fc703e')
                } else {
                    $("#sel-degree").css('color', 'black')
                }
            },
            handleCurrentChange(val) {
                // 数据库
                if (this.query.keyword === ''){
                    this.page = val
                    this.findAllJobInfo()
                }else{
                    // ES
                    // 之前浏览数据库数据
                    if (this.query.page !== 1){
                        this.query.page = 1
                        this.currentPage = 1
                    }else{
                        this.query.page = val
                        this.currentPage = val
                    }
                    this.highLightSearch()
                }
            }
        }
    }
</script>

<style scoped>
  .el-dropdown-menu__item:not(.is-disabled):hover {
    background-color: #f8f9fc !important;
    color: #333333 !important;
  }

  /deep/ .el-pagination.is-background .el-pager li:not(.disabled).active {
    background-color: rgb(12, 204, 181) !important;
    color: #FFF;
  }

  /deep/ .el-pagination.is-background .el-pager li:not(.disabled):hover {
    color: rgb(12, 204, 181) !important;
  }

  /deep/ .el-pager li {
    height: 30px !important;
  }
</style>
