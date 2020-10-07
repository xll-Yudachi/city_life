<template>
  <div>
    <div id="wrap">

      <!--网站头部-->
      <div id="header">
        <div class="inner home-inner">
          <div class="logo">
            <a href="https://www.zhipin.com/" ka="header-home-logo" title="BOSS直聘"><span>BOSS直聘</span></a>
          </div>
          <div class="nav-city">
            <p class="nav-city-box" ka="header-switch-city"><i class="icon-poi"></i><span
              class="nav-city-selected">全国</span><span class="switchover-city">[切换城市]</span></p>
            <div class="city-box">
              <ul class="dorpdown-province">
              </ul>
              <div class="dorpdown-city"></div>
            </div>
          </div>
          <div class="nav">
            <ul>
              <li class="cur"><a ka="header-home" href="/">首页</a></li>
              <li class=""><a ka="header-job" href="#">职位</a></li>
              <li class=""><a class="nav-school-new" ka="header-school" href="#">校园</a></li>
              <li class=""><a ka="header_brand" href="#">公司</a></li>
              <li class=""><a ka="header-app" href="#">APP</a></li>
              <li class=""><a ka="header-article" href="#">资讯</a></li>
            </ul>
          </div>
          <div class="user-nav">
            <div class="btns">
              <a href="#" rel="nofollow" ka="nlp_resume_upload" class="link-sign-resume" title="上传简历，解析内容，完善注册">上传简历</a>
              <a href="#" rel="nofollow" ka="header-geek" class="link-sign-resume" title="上传简历，解析内容，完善注册">我要找工作<span
                class="new" style="display: inline;">hot</span></a>
              <a href="#" rel="nofollow" class="link-scan" ka="header-boss" title="我要招聘">我要招聘</a>
              <div style="float: right;position: relative;top: 5px" v-if="showUser.username === ''">
                <a href="/register.html" class="btn btn-outline" >注册</a>
                <a href="/login.html" class="btn btn-outline">登录</a>
              </div>
              <div style="float: right;position: relative;top: 5px;left: 10px" v-else>
               <span class="btn" style="background-color: #202329;border: 0;font-size: 14px"> 欢迎您，<a href="/login.html" >{{showUser.username}}</a></span>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!--快速注册-->
      <div class="fast-register-box top-sign-box" v-if="showUser.username === ''" >
        <div class="inner home-inner">
          <img src="https://static.zhipin.com/v2/web/geek/images/fast-reg.png" class="icon-tip"/>
          <div class="step-form">
            <form action="/wapi/zppassport/login/phone" method="post" data-reload='true' ka="signup_g_index_done">
              <input type="hidden" name="regionCode" value="+86">
              <img src="https://static.zhipin.com/v2/web/geek/images/fast-reg-text.png"/>
              <div>
                <div class="input-box">
                  <input type="tel" placeholder="输入手机号" ka="signin-account" name="phone" class="ipt-phone">
                </div>
                <div class="input-box">
                  <input type="text" placeholder="验证码" name="phoneCode" maxlength="6" ka="signup-sms"
                         class="ipt-sms required">
                  <input type="hidden" name="smsType" value="7">
                  <a href="javascript:void(0)" class="show-code-box" data-url="/wapi/zppassport/send/smsCode">获取</a>
                </div>
                <button type="button" class="btn registe-btn" ka="signup_g_index">登录/注册</button>
                <div class="code-form-box">
                  <div class="btn getcode-btn btn-sms">确 定</div>
                  <div class="sign-form">
                    <div class="row-code"></div>
                    <input type="hidden" name="csessionId">
                    <input type="hidden" name="csig">
                    <input type="hidden" name="ctoken">
                    <input type="hidden" name="cscene" value="nc_login">
                    <input type="hidden" value="FFFF0N00000000006DC1" name="cappKey">
                  </div>
                </div>
              </div>
            </form>
          </div>
          <div class="fast-reg-desc">
          </div>
        </div>
      </div>
      <!--快速注册 end-->

      <!-- 搜索 -->
      <div class="column-search-panel">
        <div class="inner home-inner">
          <div class="search-box">
            <div class="search-form ">
              <form action="/job_detail/" method="get">
                <div class="logo"><a href="/" ka="header-home-logo" title="BOSS直聘"><span>BOSS直聘</span></a></div>
                <div class="search-form-con">
                  <div class="position-sel" ka="search_box_sel_jobtype">
                    <span class="label-text"><b>职位类型</b><i class="icon-arrow-down"></i></span>
                  </div>
                  <p class="ipt-wrap"><input type="text" name="query" class="ipt-search" maxlength="50"
                                             autocomplete="off" placeholder="搜索职位、公司"></p>
                </div>
                <input type="hidden" name="city" class="city-code" value="100010000"/>
                <input type="hidden" name="industry" class="industry-code" value=""/>
                <input type="hidden" name="position" class="position-code" value=""/>
                <button class="btn btn-search" ka="search_box_index">搜索</button>
                <div class="suggest-result">
                  <ul>
                  </ul>
                </div>

                <div class="position-box">
                  <div class="dropdown-menu">
                    <div class="select-tree" data-level="3"></div>
                  </div>
                </div>
              </form>
            </div>
            <div class="search-hot">
              <b>热门职位:</b>
              <a href="/c100010000/?query=Java&industry=&position=" ka="hot-position-1">Java</a>
              <a href="/c100010000/?query=销售&industry=&position=" ka="hot-position-2">销售</a>
              <a href="/c100010000/?query=产品经理&industry=&position=" ka="hot-position-3">产品经理</a>
              <a href="/c100010000/?query=web前端&industry=&position=" ka="hot-position-4">web前端</a>
              <a href="/c100010000/?query=服务员&industry=&position=" ka="hot-position-5">服务员</a>
              <a href="/c100010000/?query=行政&industry=&position=" ka="hot-position-6">行政</a>
              <a href="/c100010000/?query=IOS&industry=&position=" ka="hot-position-7">IOS</a>
              <a href="/c100010000/?query=Android&industry=&position=" ka="hot-position-8">Android</a>
              <a href="/c100010000/?query=UI设计&industry=&position=" ka="hot-position-9">UI设计</a>
              <a href="/c100010000/?query=产品运营&industry=&position=" ka="hot-position-10">产品运营</a>
            </div>
          </div>
        </div>
      </div>
      <!-- 搜索 end -->

      <!--主体main-->
      <div id="main" class="inner home-inner">
        <div class="home-box">
          <div class="home-sider">
            <!-- 左侧职位选择 -->
            <div class="job-menu" @mouseleave="showAllOut">

              <dl class="" v-for="(item, index) in positionCategoryList " :key="index" v-if="index < 7" @mouseenter="mouseInDl($event)" @mouseleave="mouseOutDl($event)">
                <dd>
                  <i class="icon-arrow-right"></i>
                  <b>{{item.label}}</b>
                  <a href="#" v-for="secItem in item.children">
                    {{secItem.label}}
                  </a>
                </dd>
                <div class="menu-line"></div>
                <div class="menu-sub">
                  <p class="menu-article">
                    {{item.label}}
                  </p>
                  <ul>
                    <li v-for="secItem in item.children">
                      <h4>{{secItem.label}}</h4>
                      <div class="text">
                        <a href="#" v-for="thirdItem in secItem.children">
                          {{thirdItem.label}}
                        </a>
                      </div>
                    </li>
                  </ul>
                </div>
              </dl>

              <div class="show-all" @mouseenter="showAllIn">
                显示全部职位
              </div>
              <div class="all-box">
                <dl>
                  <dd>
                    <i class="icon-arrow-right"></i>
                    <b>销售</b>
                    <a href="/c100010000-p140301/">销售专员</a>
                    <a href="/c100010000-p140302/">销售经理</a>
                    <a href="/c100010000-p140316/">销售工程师</a>
                  </dd>
                  <div class="menu-line"></div>
                  <div class="menu-sub">
                    <p class="menu-article">销售</p>
                    <ul>
                      <li>
                        <h4>销售行政/商务</h4>
                        <div class="text">
                          <a href="/c100010000-p130119/">销售运营</a>
                          <a href="/c100010000-p160302/">商务经理</a>
                          <a href="/c100010000-p160301/">商务专员</a>
                          <a href="/c100010000-p140309/">销售助理</a>
                        </div>
                      </li>
                      <li>
                        <h4>房地产经纪</h4>
                        <div class="text">
                          <a href="/c100010000-p160403/">地产中介</a>
                          <a href="/c100010000-p160401/">置业顾问</a>
                          <a href="/c100010000-p160402/">房产评估师</a>
                        </div>
                      </li>
                      <li>
                        <h4>销售</h4>
                        <div class="text">
                          <a href="/c100010000-p140304/">大客户代表</a>
                          <a href="/c100010000-p140317/">客户经理</a>
                          <a href="/c100010000-p140307/">渠道销售</a>
                          <a href="/c100010000-p140305/">BD经理</a>
                          <a href="/c100010000-p140314/">网络销售</a>
                          <a href="/c100010000-p140311/">销售顾问</a>
                          <a href="/c100010000-p140313/">广告销售</a>
                          <a href="/c100010000-p140310/">电话销售</a>
                          <a href="/c100010000-p140306/">商务渠道</a>
                          <a href="/c100010000-p140315/">营销主管</a>
                          <a href="/c100010000-p140302/">销售经理</a>
                          <a href="/c100010000-p140399/">销售</a>
                          <a href="/c100010000-p140316/">销售工程师</a>
                          <a href="/c100010000-p140308/">代理商销售</a>
                          <a href="/c100010000-p140301/">销售专员</a>
                          <a href="/c100010000-p140312/">商品经理</a>
                          <a href="/c100010000-p140303/">客户代表</a>
                        </div>
                      </li>
                      <li>
                        <h4>销售管理</h4>
                        <div class="text">
                          <a href="/c100010000-p160199/">销售管理</a>
                          <a href="/c100010000-p140402/">销售总监</a>
                          <a href="/c100010000-p160104/">团队经理</a>
                          <a href="/c100010000-p140403/">商务总监</a>
                          <a href="/c100010000-p160101/">区域总监</a>
                          <a href="/c100010000-p160103/">销售VP</a>
                          <a href="/c100010000-p160102/">城市经理</a>
                        </div>
                      </li>
                      <li>
                        <h4>其他销售职位</h4>
                        <div class="text">
                          <a href="/c100010000-p160201/">其他销售职位</a>
                        </div>
                      </li>
                    </ul>
                  </div>
                </dl>
                <dl>
                  <dd>
                    <i class="icon-arrow-right"></i>
                    <b>传媒</b>
                    <a href="/c100010000-p170205/">广告文案</a>
                    <a href="/c100010000-p170201/">广告创意设计</a>
                    <a href="/c100010000-p170102/">编辑</a>
                    <a href="/c100010000-p170101/">记者</a>
                    <a href="/c100010000-p170301/">媒介经理</a>
                  </dd>
                  <div class="menu-line"></div>
                  <div class="menu-sub">
                    <p class="menu-article">传媒</p>
                    <ul>
                      <li>
                        <h4>采编/写作/出版</h4>
                        <div class="text">
                          <a href="/c100010000-p170102/">编辑</a>
                          <a href="/c100010000-p170107/">总编</a>
                          <a href="/c100010000-p170106/">校对录入</a>
                          <a href="/c100010000-p170104/">撰稿人</a>
                          <a href="/c100010000-p170103/">采编</a>
                          <a href="/c100010000-p170101/">记者</a>
                          <a href="/c100010000-p170108/">自媒体</a>
                          <a href="/c100010000-p170109/">排版设计</a>
                          <a href="/c100010000-p170199/">采编/写作/出版</a>
                          <a href="/c100010000-p170105/">出版发行</a>
                        </div>
                      </li>
                      <li>
                        <h4>公关媒介</h4>
                        <div class="text">
                          <a href="/c100010000-p170399/">公关媒介</a>
                          <a href="/c100010000-p170301/">媒介经理</a>
                          <a href="/c100010000-p170303/">广告协调</a>
                          <a href="/c100010000-p170302/">媒介专员</a>
                          <a href="/c100010000-p170305/">活动策划执行</a>
                          <a href="/c100010000-p170304/">品牌公关</a>
                          <a href="/c100010000-p170306/">媒介策划</a>
                        </div>
                      </li>
                      <li>
                        <h4>会务会展</h4>
                        <div class="text">
                          <a href="/c100010000-p170406/">会展活动执行</a>
                          <a href="/c100010000-p170499/">会务会展</a>
                          <a href="/c100010000-p170402/">会议活动策划</a>
                          <a href="/c100010000-p170403/">会议活动执行</a>
                          <a href="/c100010000-p170404/">会展活动销售</a>
                          <a href="/c100010000-p170405/">会展活动策划</a>
                          <a href="/c100010000-p170401/">会议活动销售</a>
                        </div>
                      </li>
                      <li>
                        <h4>广告</h4>
                        <div class="text">
                          <a href="/c100010000-p170211/">广告审核</a>
                          <a href="/c100010000-p170208/">媒介投放</a>
                          <a href="/c100010000-p170205/">广告文案</a>
                          <a href="/c100010000-p170204/">策划经理</a>
                          <a href="/c100010000-p170209/">媒介合作</a>
                          <a href="/c100010000-p170201/">广告创意设计</a>
                          <a href="/c100010000-p170203/">广告设计</a>
                          <a href="/c100010000-p170202/">美术指导</a>
                          <a href="/c100010000-p170299/">广告</a>
                          <a href="/c100010000-p170212/">广告/会展项目经理</a>
                          <a href="/c100010000-p170207/">广告制作</a>
                          <a href="/c100010000-p170210/">媒介顾问</a>
                        </div>
                      </li>
                      <li>
                        <h4>影视媒体</h4>
                        <div class="text">
                          <a href="/c100010000-p170604/">音频编辑</a>
                          <a href="/c100010000-p170603/">视频编辑</a>
                          <a href="/c100010000-p170623/">剪辑师</a>
                          <a href="/c100010000-p170601/">导演/编导</a>
                          <a href="/c100010000-p170609/">影视策划</a>
                          <a href="/c100010000-p170614/">录音/音效</a>
                          <a href="/c100010000-p170606/">后期制作</a>
                          <a href="/c100010000-p170621/">主播助理</a>
                          <a href="/c100010000-p170616/">编剧</a>
                          <a href="/c100010000-p170618/">统筹制片人</a>
                          <a href="/c100010000-p170699/">影视媒体</a>
                          <a href="/c100010000-p170611/">演员/配音/模特</a>
                          <a href="/c100010000-p170617/">艺人助理</a>
                          <a href="/c100010000-p170607/">影视制作</a>
                          <a href="/c100010000-p170622/">灯光师</a>
                          <a href="/c100010000-p170613/">放映员</a>
                          <a href="/c100010000-p170608/">影视发行</a>
                          <a href="/c100010000-p170619/">执行制片人</a>
                          <a href="/c100010000-p170610/">主播</a>
                          <a href="/c100010000-p170624/">影视特效</a>
                          <a href="/c100010000-p170612/">化妆/造型/服装</a>
                          <a href="/c100010000-p170602/">摄影/摄像</a>
                          <a href="/c100010000-p170615/">制片人</a>
                          <a href="/c100010000-p170605/">经纪人</a>
                          <a href="/c100010000-p170620/">主持人/DJ</a>
                        </div>
                      </li>
                      <li>
                        <h4>其他传媒职位</h4>
                        <div class="text">
                          <a href="/c100010000-p170501/">其他传媒职位</a>
                        </div>
                      </li>
                    </ul>
                  </div>
                </dl>
                <dl>
                  <dd>
                    <i class="icon-arrow-right"></i>
                    <b>金融</b>
                    <a href="/c100010000-p180101/">投资经理</a>
                    <a href="/c100010000-p180112/">投资总监</a>
                    <a href="/c100010000-p180201/">风控</a>
                    <a href="/c100010000-p180899/">证券</a>
                  </dd>
                  <div class="menu-line"></div>
                  <div class="menu-sub">
                    <p class="menu-article">金融</p>
                    <ul>
                      <li>
                        <h4>投融资</h4>
                        <div class="text">
                          <a href="/c100010000-p180111/">其他投融资职位</a>
                          <a href="/c100010000-p180113/">投资VP</a>
                          <a href="/c100010000-p180116/">并购</a>
                          <a href="/c100010000-p180112/">投资总监</a>
                          <a href="/c100010000-p180101/">投资经理</a>
                          <a href="/c100010000-p180114/">投资合伙人</a>
                          <a href="/c100010000-p180119/">投资顾问</a>
                          <a href="/c100010000-p180104/">资产管理</a>
                          <a href="/c100010000-p180118/">投资助理</a>
                          <a href="/c100010000-p180103/">行业研究</a>
                          <a href="/c100010000-p180199/">投融资</a>
                          <a href="/c100010000-p180117/">投后管理</a>
                          <a href="/c100010000-p180115/">融资</a>
                        </div>
                      </li>
                      <li>
                        <h4>风控</h4>
                        <div class="text">
                          <a href="/c100010000-p180201/">风控</a>
                          <a href="/c100010000-p180202/">律师</a>
                          <a href="/c100010000-p180204/">合规稽查</a>
                          <a href="/c100010000-p180203/">资信评估</a>
                        </div>
                      </li>
                      <li>
                        <h4>税务审计</h4>
                        <div class="text">
                          <a href="/c100010000-p180304/">清算</a>
                          <a href="/c100010000-p180303/">会计</a>
                          <a href="/c100010000-p180302/">法务</a>
                          <a href="/c100010000-p180301/">审计</a>
                        </div>
                      </li>
                      <li>
                        <h4>银行</h4>
                        <div class="text">
                          <a href="/c100010000-p180499/">银行</a>
                          <a href="/c100010000-p180405/">客户经理</a>
                          <a href="/c100010000-p180403/">商务渠道</a>
                          <a href="/c100010000-p180102/">分析师</a>
                          <a href="/c100010000-p180404/">大堂经理</a>
                          <a href="/c100010000-p180402/">柜员</a>
                          <a href="/c100010000-p180401/">信用卡销售</a>
                          <a href="/c100010000-p180406/">信贷管理</a>
                          <a href="/c100010000-p180105/">理财顾问</a>
                          <a href="/c100010000-p180107/">风控</a>
                        </div>
                      </li>
                      <li>
                        <h4>互联网金融</h4>
                        <div class="text">
                          <a href="/c100010000-p180106/">交易员</a>
                          <a href="/c100010000-p180108/">合规稽查</a>
                          <a href="/c100010000-p180110/">清算</a>
                          <a href="/c100010000-p180501/">金融产品经理</a>
                          <a href="/c100010000-p180503/">催收员</a>
                          <a href="/c100010000-p180506/">理财顾问</a>
                          <a href="/c100010000-p180505/">投资经理</a>
                          <a href="/c100010000-p180504/">分析师</a>
                          <a href="/c100010000-p180599/">互联网金融</a>
                          <a href="/c100010000-p180502/">风控</a>
                          <a href="/c100010000-p180109/">审计</a>
                        </div>
                      </li>
                      <li>
                        <h4>保险</h4>
                        <div class="text">
                          <a href="/c100010000-p180702/">保险精算师</a>
                          <a href="/c100010000-p180701/">保险顾问</a>
                          <a href="/c100010000-p180703/">保险理赔</a>
                        </div>
                      </li>
                      <li>
                        <h4>证券</h4>
                        <div class="text">
                          <a href="/c100010000-p180899/">证券</a>
                          <a href="/c100010000-p180802/">证券分析师</a>
                          <a href="/c100010000-p180801/">证券经纪人</a>
                        </div>
                      </li>
                      <li>
                        <h4>其他金融职位</h4>
                        <div class="text">
                          <a href="/c100010000-p180601/">其他金融职位</a>
                        </div>
                      </li>
                    </ul>
                  </div>
                </dl>
                <dl>
                  <dd>
                    <i class="icon-arrow-right"></i>
                    <b>教育培训</b>
                    <a href="/c100010000-p190101/">课程设计</a>
                    <a href="/c100010000-p190202/">教务管理</a>
                    <a href="/c100010000-p190499/">IT培训</a>
                  </dd>
                  <div class="menu-line"></div>
                  <div class="menu-sub">
                    <p class="menu-article">教育培训</p>
                    <ul>
                      <li>
                        <h4>教育产品研发</h4>
                        <div class="text">
                          <a href="/c100010000-p190101/">课程设计</a>
                          <a href="/c100010000-p190104/">培训研究</a>
                          <a href="/c100010000-p190105/">培训师</a>
                          <a href="/c100010000-p190199/">教育产品研发</a>
                          <a href="/c100010000-p190107/">培训策划</a>
                          <a href="/c100010000-p190106/">其他教育产品研发职位</a>
                          <a href="/c100010000-p190102/">课程编辑</a>
                        </div>
                      </li>
                      <li>
                        <h4>教育行政</h4>
                        <div class="text">
                          <a href="/c100010000-p190203/">教学管理</a>
                          <a href="/c100010000-p190299/">教育行政</a>
                          <a href="/c100010000-p190202/">教务管理</a>
                          <a href="/c100010000-p190204/">班主任/辅导员</a>
                          <a href="/c100010000-p190205/">园长/副园长</a>
                          <a href="/c100010000-p190201/">校长/副校长</a>
                        </div>
                      </li>
                      <li>
                        <h4>教师</h4>
                        <div class="text">
                          <a href="/c100010000-p190307/">理科教师</a>
                          <a href="/c100010000-p190314/">日语教师</a>
                          <a href="/c100010000-p190306/">幼教</a>
                          <a href="/c100010000-p190313/">就业老师</a>
                          <a href="/c100010000-p190315/">其他外语教师</a>
                          <a href="/c100010000-p190319/">化学教师</a>
                          <a href="/c100010000-p190310/">音乐教师</a>
                          <a href="/c100010000-p190322/">托管老师</a>
                          <a href="/c100010000-p190303/">高中教师</a>
                          <a href="/c100010000-p190317/">数学教师</a>
                          <a href="/c100010000-p190301/">教师</a>
                          <a href="/c100010000-p190304/">初中教师</a>
                          <a href="/c100010000-p190318/">物理教师</a>
                          <a href="/c100010000-p190305/">小学教师</a>
                          <a href="/c100010000-p190311/">美术教师</a>
                          <a href="/c100010000-p190308/">文科教师</a>
                          <a href="/c100010000-p190312/">体育教师</a>
                          <a href="/c100010000-p190321/">家教</a>
                          <a href="/c100010000-p190316/">语文教师</a>
                          <a href="/c100010000-p190323/">早教老师</a>
                          <a href="/c100010000-p190309/">英语教师</a>
                          <a href="/c100010000-p190302/">助教</a>
                          <a href="/c100010000-p190320/">生物教师</a>
                        </div>
                      </li>
                      <li>
                        <h4>IT培训</h4>
                        <div class="text">
                          <a href="/c100010000-p190404/">PHP培训讲师</a>
                          <a href="/c100010000-p190408/">Web前端培训讲师</a>
                          <a href="/c100010000-p190405/">.NET培训讲师</a>
                          <a href="/c100010000-p190401/">JAVA培训讲师</a>
                          <a href="/c100010000-p190410/">动漫培训讲师</a>
                          <a href="/c100010000-p190411/">UI设计培训讲师</a>
                          <a href="/c100010000-p190499/">IT培训</a>
                          <a href="/c100010000-p190406/">C++培训讲师</a>
                          <a href="/c100010000-p190409/">软件测试培训讲师</a>
                          <a href="/c100010000-p190407/">Unity 3D培训讲师</a>
                          <a href="/c100010000-p190403/">iOS培训讲师</a>
                          <a href="/c100010000-p190402/">Android培训讲师</a>
                        </div>
                      </li>
                      <li>
                        <h4>职业培训</h4>
                        <div class="text">
                          <a href="/c100010000-p190502/">HR培训讲师</a>
                          <a href="/c100010000-p190501/">财会培训讲师</a>
                          <a href="/c100010000-p190504/">拓展培训</a>
                          <a href="/c100010000-p190503/">培训师</a>
                        </div>
                      </li>
                      <li>
                        <h4>招生</h4>
                        <div class="text">
                          <a href="/c100010000-p190601/">课程顾问</a>
                          <a href="/c100010000-p190602/">招生顾问</a>
                          <a href="/c100010000-p190603/">留学顾问</a>
                        </div>
                      </li>
                      <li>
                        <h4>特长培训</h4>
                        <div class="text">
                          <a href="/c100010000-p190716/">播音主持教师</a>
                          <a href="/c100010000-p190710/">表演教师</a>
                          <a href="/c100010000-p190712/">书法教师</a>
                          <a href="/c100010000-p190713/">钢琴教师</a>
                          <a href="/c100010000-p190717/">乐高教师</a>
                          <a href="/c100010000-p190705/">健身教练</a>
                          <a href="/c100010000-p190701/">舞蹈老师</a>
                          <a href="/c100010000-p190715/">古筝教师</a>
                          <a href="/c100010000-p190714/">吉他教师</a>
                          <a href="/c100010000-p190707/">跆拳道教练</a>
                          <a href="/c100010000-p190709/">轮滑教练</a>
                          <a href="/c100010000-p190708/">武术教练</a>
                          <a href="/c100010000-p190703/">瘦身顾问</a>
                          <a href="/c100010000-p190711/">机器人教师</a>
                          <a href="/c100010000-p190799/">教练</a>
                          <a href="/c100010000-p190706/">篮球/羽毛球教练</a>
                          <a href="/c100010000-p190702/">瑜伽老师</a>
                          <a href="/c100010000-p190704/">游泳教练</a>
                        </div>
                      </li>
                      <li>
                        <h4>其他教育培训职位</h4>
                        <div class="text">
                          <a href="/c100010000-p190801/">其他教育培训职位</a>
                        </div>
                      </li>
                    </ul>
                  </div>
                </dl>
                <dl>
                  <dd>
                    <i class="icon-arrow-right"></i>
                    <b>医疗健康</b>
                    <a href="/c100010000-p210104/">药剂师</a>
                    <a href="/c100010000-p210401/">营养师</a>
                    <a href="/c100010000-p210105/">医疗器械研发</a>
                  </dd>
                  <div class="menu-line"></div>
                  <div class="menu-sub">
                    <p class="menu-article">医疗健康</p>
                    <ul>
                      <li>
                        <h4>临床试验</h4>
                        <div class="text">
                          <a href="/c100010000-p210119/">临床协调</a>
                          <a href="/c100010000-p210120/">临床数据分析</a>
                          <a href="/c100010000-p210118/">临床研究</a>
                          <a href="/c100010000-p211001/">临床项目经理</a>
                          <a href="/c100010000-p210501/">医学总监</a>
                        </div>
                      </li>
                      <li>
                        <h4>医生/医技</h4>
                        <div class="text">
                          <a href="/c100010000-p210306/">内科医生</a>
                          <a href="/c100010000-p210114/">B超医生</a>
                          <a href="/c100010000-p210112/">医生助理</a>
                          <a href="/c100010000-p210304/">牙科医生</a>
                          <a href="/c100010000-p210303/">心理医生</a>
                          <a href="/c100010000-p210103/">医生</a>
                          <a href="/c100010000-p210111/">检验科医师</a>
                          <a href="/c100010000-p210307/">全科医生</a>
                          <a href="/c100010000-p210302/">中医</a>
                          <a href="/c100010000-p210305/">康复治疗师</a>
                          <a href="/c100010000-p210109/">验光师</a>
                          <a href="/c100010000-p210113/">医学影像</a>
                          <a href="/c100010000-p210104/">药剂师</a>
                          <a href="/c100010000-p210107/">其他医生职位</a>
                          <a href="/c100010000-p210110/">放射科医师</a>
                        </div>
                      </li>
                      <li>
                        <h4>护士/护理</h4>
                        <div class="text">
                          <a href="/c100010000-p210202/">护士长</a>
                          <a href="/c100010000-p210201/">护士</a>
                          <a href="/c100010000-p210503/">导医</a>
                        </div>
                      </li>
                      <li>
                        <h4>健康整形</h4>
                        <div class="text">
                          <a href="/c100010000-p210499/">健康整形</a>
                          <a href="/c100010000-p210404/">针灸推拿</a>
                          <a href="/c100010000-p210402/">整形师</a>
                          <a href="/c100010000-p210401/">营养师</a>
                          <a href="/c100010000-p210403/">理疗师</a>
                        </div>
                      </li>
                      <li>
                        <h4>生物制药</h4>
                        <div class="text">
                          <a href="/c100010000-p210106/">医学总监</a>
                          <a href="/c100010000-p210108/">医药研发</a>
                          <a href="/c100010000-p210115/">生物制药</a>
                          <a href="/c100010000-p210117/">药品生产</a>
                          <a href="/c100010000-p210116/">药品注册</a>
                          <a href="/c100010000-p210123/">医药项目经理</a>
                        </div>
                      </li>
                      <li>
                        <h4>医疗器械</h4>
                        <div class="text">
                          <a href="/c100010000-p210121/">医疗器械注册</a>
                          <a href="/c100010000-p210105/">医疗器械研发</a>
                          <a href="/c100010000-p210122/">医疗器械生产/质量管理</a>
                        </div>
                      </li>
                      <li>
                        <h4>药店</h4>
                        <div class="text">
                          <a href="/c100010000-p210803/">药店店员</a>
                          <a href="/c100010000-p210802/">执业药师/驻店药师</a>
                          <a href="/c100010000-p210801/">药店店长</a>
                        </div>
                      </li>
                      <li>
                        <h4>医学营销/媒体</h4>
                        <div class="text">
                          <a href="/c100010000-p210101/">医学编辑</a>
                          <a href="/c100010000-p210599/">医学营销/媒体</a>
                          <a href="/c100010000-p210102/">药学编辑</a>
                          <a href="/c100010000-p210502/">医药代表</a>
                          <a href="/c100010000-p210504/">健康顾问</a>
                          <a href="/c100010000-p210505/">医美咨询</a>
                          <a href="/c100010000-p210506/">医疗器械销售</a>
                        </div>
                      </li>
                      <li>
                        <h4>其他医疗健康职位</h4>
                        <div class="text">
                          <a href="/c100010000-p210701/">其他医疗健康职位</a>
                        </div>
                      </li>
                    </ul>
                  </div>
                </dl>
                <dl>
                  <dd>
                    <i class="icon-arrow-right"></i>
                    <b>采购/贸易</b>
                    <a href="/c100010000-p250102/">采购经理</a>
                    <a href="/c100010000-p250106/">采购主管</a>
                    <a href="/c100010000-p250299/">进出口贸易</a>
                  </dd>
                  <div class="menu-line"></div>
                  <div class="menu-sub">
                    <p class="menu-article">采购/贸易</p>
                    <ul>
                      <li>
                        <h4>采购</h4>
                        <div class="text">
                          <a href="/c100010000-p250104/">买手</a>
                          <a href="/c100010000-p250103/">采购专员</a>
                          <a href="/c100010000-p250101/">采购总监</a>
                          <a href="/c100010000-p250106/">采购主管</a>
                          <a href="/c100010000-p250199/">采购</a>
                          <a href="/c100010000-p250108/">供应商质量工程师</a>
                          <a href="/c100010000-p250107/">采购助理</a>
                          <a href="/c100010000-p250105/">采购工程师</a>
                          <a href="/c100010000-p250102/">采购经理</a>
                        </div>
                      </li>
                      <li>
                        <h4>进出口贸易</h4>
                        <div class="text">
                          <a href="/c100010000-p250299/">进出口贸易</a>
                          <a href="/c100010000-p250204/">贸易跟单</a>
                          <a href="/c100010000-p250203/">外贸业务员</a>
                          <a href="/c100010000-p250201/">外贸经理</a>
                          <a href="/c100010000-p250202/">外贸专员</a>
                        </div>
                      </li>
                      <li>
                        <h4>其他采购/贸易职位</h4>
                        <div class="text">
                          <a href="/c100010000-p250301/">其他采购/贸易类职位</a>
                        </div>
                      </li>
                    </ul>
                  </div>
                </dl>
                <dl>
                  <dd>
                    <i class="icon-arrow-right"></i>
                    <b>供应链/物流</b>
                    <a href="/c100010000-p240103/">物流专员</a>
                    <a href="/c100010000-p240107/">贸易跟单</a>
                    <a href="/c100010000-p240102/">供应链经理</a>
                  </dd>
                  <div class="menu-line"></div>
                  <div class="menu-sub">
                    <p class="menu-article">供应链/物流</p>
                    <ul>
                      <li>
                        <h4>物流</h4>
                        <div class="text">
                          <a href="/c100010000-p240109/">物流/仓储项目经理</a>
                          <a href="/c100010000-p240113/">水/空/陆运操作</a>
                          <a href="/c100010000-p240108/">调度员</a>
                          <a href="/c100010000-p240116/">核销员</a>
                          <a href="/c100010000-p240102/">供应链经理</a>
                          <a href="/c100010000-p240117/">单证员</a>
                          <a href="/c100010000-p240104/">物流经理</a>
                          <a href="/c100010000-p240106/">物流跟单</a>
                          <a href="/c100010000-p240103/">物流专员</a>
                          <a href="/c100010000-p240115/">报检员</a>
                          <a href="/c100010000-p240114/">报关员</a>
                          <a href="/c100010000-p240105/">物流运营</a>
                          <a href="/c100010000-p240199/">物流</a>
                          <a href="/c100010000-p240112/">货运代理经理</a>
                          <a href="/c100010000-p240111/">货运代理专员</a>
                          <a href="/c100010000-p240101/">供应链专员</a>
                        </div>
                      </li>
                      <li>
                        <h4>仓储</h4>
                        <div class="text">
                          <a href="/c100010000-p240204/">仓库管理员</a>
                          <a href="/c100010000-p240201/">仓库经理</a>
                          <a href="/c100010000-p240299/">仓储</a>
                          <a href="/c100010000-p240205/">仓库文员</a>
                          <a href="/c100010000-p240206/">配/理/拣/发货</a>
                        </div>
                      </li>
                      <li>
                        <h4>交通/运输</h4>
                        <div class="text">
                          <a href="/c100010000-p240302/">集装箱管理</a>
                          <a href="/c100010000-p240301/">货运司机</a>
                          <a href="/c100010000-p240306/">代驾司机</a>
                          <a href="/c100010000-p240307/">驾校教练</a>
                          <a href="/c100010000-p150208/">商务司机</a>
                          <a href="/c100010000-p240304/">快递员</a>
                          <a href="/c100010000-p240303/">配送员</a>
                          <a href="/c100010000-p240399/">交通/运输</a>
                          <a href="/c100010000-p240110/">运输经理/主管</a>
                          <a href="/c100010000-p240305/">网约车司机</a>
                        </div>
                      </li>
                      <li>
                        <h4>高端供应链职位</h4>
                        <div class="text">
                          <a href="/c100010000-p240402/">物流总监</a>
                          <a href="/c100010000-p240401/">供应链总监</a>
                          <a href="/c100010000-p240499/">高端供应链职位</a>
                        </div>
                      </li>
                      <li>
                        <h4>其他供应链职位</h4>
                        <div class="text">
                          <a href="/c100010000-p240501/">其他供应链职位</a>
                        </div>
                      </li>
                    </ul>
                  </div>
                </dl>
                <dl>
                  <dd>
                    <i class="icon-arrow-right"></i>
                    <b>房地产/建筑</b>
                    <a href="/c100010000-p220401/">物业经理</a>
                    <a href="/c100010000-p220199/">房地产规划开发</a>
                  </dd>
                  <div class="menu-line"></div>
                  <div class="menu-sub">
                    <p class="menu-article">房地产/建筑</p>
                    <ul>
                      <li>
                        <h4>房地产规划开发</h4>
                        <div class="text">
                          <a href="/c100010000-p220102/">地产项目管理</a>
                          <a href="/c100010000-p220199/">房地产规划开发</a>
                          <a href="/c100010000-p220101/">房地产策划</a>
                          <a href="/c100010000-p220103/">地产招投标</a>
                        </div>
                      </li>
                      <li>
                        <h4>设计装修与市政建设</h4>
                        <div class="text">
                          <a href="/c100010000-p220217/">软装设计师</a>
                          <a href="/c100010000-p220213/">弱电工程师</a>
                          <a href="/c100010000-p220210/">工程预算</a>
                          <a href="/c100010000-p220206/">园林设计</a>
                          <a href="/c100010000-p220225/">施工安全员</a>
                          <a href="/c100010000-p220299/">设计装修与市政建设</a>
                          <a href="/c100010000-p220211/">资料员</a>
                          <a href="/c100010000-p220214/">给排水工程师</a>
                          <a href="/c100010000-p220208/">工程监理</a>
                          <a href="/c100010000-p220204/">土木/土建/结构工程师</a>
                          <a href="/c100010000-p220223/">建筑机电工程师</a>
                          <a href="/c100010000-p220203/">建筑设计师</a>
                          <a href="/c100010000-p220209/">工程造价</a>
                          <a href="/c100010000-p220202/">建筑工程师</a>
                          <a href="/c100010000-p220207/">城市规划设计</a>
                          <a href="/c100010000-p220224/">消防工程师</a>
                          <a href="/c100010000-p220218/">施工员</a>
                          <a href="/c100010000-p220212/">建筑施工现场管理</a>
                          <a href="/c100010000-p220222/">装修项目经理</a>
                          <a href="/c100010000-p220220/">材料员</a>
                          <a href="/c100010000-p220215/">暖通工程师</a>
                          <a href="/c100010000-p220216/">幕墙工程师</a>
                          <a href="/c100010000-p220221/">BIM工程师</a>
                          <a href="/c100010000-p220201/">高级建筑工程师</a>
                          <a href="/c100010000-p120610/">景观设计</a>
                          <a href="/c100010000-p220219/">测绘/测量</a>
                          <a href="/c100010000-p220205/">室内设计</a>
                        </div>
                      </li>
                      <li>
                        <h4>房地产经纪</h4>
                        <div class="text">
                          <a href="/c100010000-p220303/">地产中介</a>
                          <a href="/c100010000-p220302/">房产评估师</a>
                          <a href="/c100010000-p220399/">房地产经纪</a>
                          <a href="/c100010000-p220301/">置业顾问</a>
                        </div>
                      </li>
                      <li>
                        <h4>物业管理</h4>
                        <div class="text">
                          <a href="/c100010000-p220406/">物业管理员</a>
                          <a href="/c100010000-p220401/">物业经理</a>
                          <a href="/c100010000-p220404/">物业维修</a>
                          <a href="/c100010000-p220405/">绿化工</a>
                          <a href="/c100010000-p220402/">物业租赁销售 </a>
                          <a href="/c100010000-p220403/">物业招商管理</a>
                        </div>
                      </li>
                      <li>
                        <h4>高端房地产职位</h4>
                        <div class="text">
                          <a href="/c100010000-p220502/">地产策划总监</a>
                          <a href="/c100010000-p220501/">地产项目总监</a>
                          <a href="/c100010000-p220599/">高端房地产职位</a>
                          <a href="/c100010000-p220504/">物业总监</a>
                          <a href="/c100010000-p220503/">地产招投标总监</a>
                          <a href="/c100010000-p220505/">房地产销售总监</a>
                        </div>
                      </li>
                      <li>
                        <h4>其他房地产职位</h4>
                        <div class="text">
                          <a href="/c100010000-p220601/">其他房地产职位</a>
                        </div>
                      </li>
                    </ul>
                  </div>
                </dl>
                <dl>
                  <dd>
                    <i class="icon-arrow-right"></i>
                    <b>咨询/翻译/法律</b>
                    <a href="/c100010000-p260101/">企业管理咨询</a>
                    <a href="/c100010000-p260201/">事务所律师</a>
                  </dd>
                  <div class="menu-line"></div>
                  <div class="menu-sub">
                    <p class="menu-article">咨询/翻译/法律</p>
                    <ul>
                      <li>
                        <h4>咨询/调研</h4>
                        <div class="text">
                          <a href="/c100010000-p260113/">婚恋咨询师</a>
                          <a href="/c100010000-p260112/">心理咨询师</a>
                          <a href="/c100010000-p260106/">咨询项目管理</a>
                          <a href="/c100010000-p260102/">数据分析师</a>
                          <a href="/c100010000-p260199/">咨询/调研</a>
                          <a href="/c100010000-p260402/">咨询经理</a>
                          <a href="/c100010000-p260104/">IT咨询顾问</a>
                          <a href="/c100010000-p260401/">咨询总监</a>
                          <a href="/c100010000-p260107/">战略咨询</a>
                          <a href="/c100010000-p260109/">市场调研</a>
                          <a href="/c100010000-p260105/">人力资源顾问</a>
                          <a href="/c100010000-p260108/">猎头顾问</a>
                          <a href="/c100010000-p260111/">知识产权/专利/商标代理人</a>
                          <a href="/c100010000-p260110/">其他咨询顾问</a>
                          <a href="/c100010000-p260101/">企业管理咨询</a>
                          <a href="/c100010000-p260103/">财务咨询顾问</a>
                        </div>
                      </li>
                      <li>
                        <h4>律师</h4>
                        <div class="text">
                          <a href="/c100010000-p260204/">律师助理</a>
                          <a href="/c100010000-p260202/">法务</a>
                          <a href="/c100010000-p150503/">专利律师</a>
                          <a href="/c100010000-p260203/">知识产权律师</a>
                          <a href="/c100010000-p260201/">事务所律师</a>
                        </div>
                      </li>
                      <li>
                        <h4>翻译</h4>
                        <div class="text">
                          <a href="/c100010000-p260404/">同声传译 </a>
                          <a href="/c100010000-p260302/">日语翻译</a>
                          <a href="/c100010000-p260304/">法语翻译</a>
                          <a href="/c100010000-p260307/">西班牙语翻译</a>
                          <a href="/c100010000-p260308/">其他语种翻译</a>
                          <a href="/c100010000-p260306/">俄语翻译</a>
                          <a href="/c100010000-p260305/">德语翻译</a>
                          <a href="/c100010000-p260303/">韩语/朝鲜语翻译</a>
                          <a href="/c100010000-p260301/">英语翻译</a>
                        </div>
                      </li>
                      <li>
                        <h4>其他咨询类职位</h4>
                        <div class="text">
                          <a href="/c100010000-p260501/">其他咨询/翻译类职位</a>
                        </div>
                      </li>
                    </ul>
                  </div>
                </dl>
                <dl>
                  <dd>
                    <i class="icon-arrow-right"></i>
                    <b>旅游</b>
                    <a href="/c100010000-p280103/">旅游顾问</a>
                    <a href="/c100010000-p280104/">导游</a>
                    <a href="/c100010000-p280299/">旅游产品开发/策划</a>
                  </dd>
                  <div class="menu-line"></div>
                  <div class="menu-sub">
                    <p class="menu-article">旅游</p>
                    <ul>
                      <li>
                        <h4>旅游服务</h4>
                        <div class="text">
                          <a href="/c100010000-p280105/">预定票务</a>
                          <a href="/c100010000-p280106/">讲解员</a>
                          <a href="/c100010000-p280199/">旅游服务</a>
                          <a href="/c100010000-p280103/">旅游顾问</a>
                          <a href="/c100010000-p280102/">签证专员</a>
                          <a href="/c100010000-p280101/">计调</a>
                          <a href="/c100010000-p280104/">导游</a>
                        </div>
                      </li>
                      <li>
                        <h4>旅游产品开发/策划</h4>
                        <div class="text">
                          <a href="/c100010000-p280201/">旅游产品经理</a>
                          <a href="/c100010000-p280202/">旅游策划师</a>
                          <a href="/c100010000-p280299/">旅游产品开发/策划</a>
                        </div>
                      </li>
                      <li>
                        <h4>其他旅游职位</h4>
                        <div class="text">
                          <a href="/c100010000-p280301/">其他旅游职位</a>
                        </div>
                      </li>
                    </ul>
                  </div>
                </dl>
                <dl>
                  <dd>
                    <i class="icon-arrow-right"></i>
                    <b>服务业</b>
                    <a href="/c100010000-p290202/">服务员</a>
                    <a href="/c100010000-p290103/">客房服务员</a>
                    <a href="/c100010000-p210607/">发型师</a>
                  </dd>
                  <div class="menu-line"></div>
                  <div class="menu-sub">
                    <p class="menu-article">服务业</p>
                    <ul>
                      <li>
                        <h4>餐饮</h4>
                        <div class="text">
                          <a href="/c100010000-p290207/">领班</a>
                          <a href="/c100010000-p290214/">行政总厨</a>
                          <a href="/c100010000-p290201/">收银</a>
                          <a href="/c100010000-p290208/">后厨</a>
                          <a href="/c100010000-p290221/">日式厨师</a>
                          <a href="/c100010000-p290204/">咖啡师</a>
                          <a href="/c100010000-p290219/">中餐厨师</a>
                          <a href="/c100010000-p290210/">茶艺师</a>
                          <a href="/c100010000-p290218/">凉菜厨师</a>
                          <a href="/c100010000-p290220/">西餐厨师</a>
                          <a href="/c100010000-p290215/">厨师长</a>
                          <a href="/c100010000-p290205/">送餐员</a>
                          <a href="/c100010000-p290213/">面点师</a>
                          <a href="/c100010000-p290216/">传菜员</a>
                          <a href="/c100010000-p290206/">餐饮店长</a>
                          <a href="/c100010000-p290299/">餐饮</a>
                          <a href="/c100010000-p290222/">烧烤师傅</a>
                          <a href="/c100010000-p290211/">西点师</a>
                          <a href="/c100010000-p290217/">洗碗工</a>
                          <a href="/c100010000-p290212/">餐饮学徒</a>
                          <a href="/c100010000-p290203/">厨师</a>
                          <a href="/c100010000-p290209/">配菜打荷</a>
                          <a href="/c100010000-p290202/">服务员</a>
                        </div>
                      </li>
                      <li>
                        <h4>酒店</h4>
                        <div class="text">
                          <a href="/c100010000-p290103/">客房服务员</a>
                          <a href="/c100010000-p290116/">客房经理</a>
                          <a href="/c100010000-p290102/">酒店前台</a>
                          <a href="/c100010000-p290101/">收银</a>
                          <a href="/c100010000-p290107/">礼仪/迎宾/接待</a>
                          <a href="/c100010000-p290104/">酒店经理</a>
                          <a href="/c100010000-p290115/">前厅经理</a>
                        </div>
                      </li>
                      <li>
                        <h4>零售</h4>
                        <div class="text">
                          <a href="/c100010000-p290309/">卖场经理</a>
                          <a href="/c100010000-p290304/">门店店长</a>
                          <a href="/c100010000-p290307/">理货员</a>
                          <a href="/c100010000-p290302/">导购</a>
                          <a href="/c100010000-p290311/">促销员</a>
                          <a href="/c100010000-p290308/">防损员</a>
                          <a href="/c100010000-p290312/">珠宝销售</a>
                          <a href="/c100010000-p290303/">店员/营业员</a>
                          <a href="/c100010000-p290306/">陈列员</a>
                          <a href="/c100010000-p290305/">督导/巡店</a>
                          <a href="/c100010000-p290301/">收银</a>
                        </div>
                      </li>
                      <li>
                        <h4>美容保健</h4>
                        <div class="text">
                          <a href="/c100010000-p210608/">美甲师</a>
                          <a href="/c100010000-p210609/">化妆师</a>
                          <a href="/c100010000-p210410/">美容店长</a>
                          <a href="/c100010000-p210408/">美体师</a>
                          <a href="/c100010000-p210411/">足疗师</a>
                          <a href="/c100010000-p210407/">纹绣师</a>
                          <a href="/c100010000-p210607/">发型师</a>
                          <a href="/c100010000-p210409/">美发学徒</a>
                          <a href="/c100010000-p210405/">美容师</a>
                          <a href="/c100010000-p210412/">按摩师</a>
                          <a href="/c100010000-p210406/">彩妆顾问</a>
                          <a href="/c100010000-p290801/">养发师</a>
                          <a href="/c100010000-p210413/">美睫师</a>
                          <a href="/c100010000-p210414/">美容顾问</a>
                        </div>
                      </li>
                      <li>
                        <h4>运动健身</h4>
                        <div class="text">
                          <a href="/c100010000-p210601/">瑜伽老师</a>
                          <a href="/c100010000-p210613/">救生员</a>
                          <a href="/c100010000-p210604/">美体教练</a>
                          <a href="/c100010000-p210603/">游泳教练</a>
                          <a href="/c100010000-p210602/">瘦身顾问</a>
                          <a href="/c100010000-p210606/">健身教练</a>
                          <a href="/c100010000-p210605/">舞蹈老师</a>
                          <a href="/c100010000-p210610/">会籍顾问</a>
                          <a href="/c100010000-p210699/">健身</a>
                        </div>
                      </li>
                      <li>
                        <h4>婚礼/花艺</h4>
                        <div class="text">
                          <a href="/c100010000-p290701/">花艺师</a>
                          <a href="/c100010000-p290702/">婚礼策划</a>
                        </div>
                      </li>
                      <li>
                        <h4>宠物服务</h4>
                        <div class="text">
                          <a href="/c100010000-p290601/">宠物美容</a>
                          <a href="/c100010000-p290602/">宠物医生</a>
                        </div>
                      </li>
                      <li>
                        <h4>安保/家政/维修</h4>
                        <div class="text">
                          <a href="/c100010000-p290106/">保洁</a>
                          <a href="/c100010000-p290122/">保洁经理</a>
                          <a href="/c100010000-p290121/">消防中控员</a>
                          <a href="/c100010000-p290111/">护工</a>
                          <a href="/c100010000-p290109/">月嫂</a>
                          <a href="/c100010000-p290105/">保安</a>
                          <a href="/c100010000-p290118/">产后康复师</a>
                          <a href="/c100010000-p290108/">保姆</a>
                          <a href="/c100010000-p290114/">家电维修</a>
                          <a href="/c100010000-p290120/">押运员</a>
                          <a href="/c100010000-p290113/">手机维修</a>
                          <a href="/c100010000-p290117/">保安经理</a>
                          <a href="/c100010000-p290110/">育婴师</a>
                          <a href="/c100010000-p290119/">钟点工</a>
                          <a href="/c100010000-p290112/">安检员</a>
                        </div>
                      </li>
                      <li>
                        <h4>其他服务业职位</h4>
                        <div class="text">
                          <a href="/c100010000-p290401/">其他服务业职位</a>
                        </div>
                      </li>
                    </ul>
                  </div>
                </dl>
                <dl>
                  <dd>
                    <i class="icon-arrow-right"></i>
                    <b>生产制造</b>
                    <a href="/c100010000-p300102/">生产总监</a>
                    <a href="/c100010000-p300105/">生产员</a>
                    <a href="/c100010000-p300201/">质量管理/测试</a>
                  </dd>
                  <div class="menu-line"></div>
                  <div class="menu-sub">
                    <p class="menu-article">生产制造</p>
                    <ul>
                      <li>
                        <h4>生产营运</h4>
                        <div class="text">
                          <a href="/c100010000-p300101/">厂长</a>
                          <a href="/c100010000-p300102/">生产总监</a>
                          <a href="/c100010000-p300104/">生产组长/拉长</a>
                          <a href="/c100010000-p300106/">生产设备管理</a>
                          <a href="/c100010000-p300105/">生产员</a>
                          <a href="/c100010000-p300199/">生产营运</a>
                          <a href="/c100010000-p300107/">生产计划管理</a>
                          <a href="/c100010000-p300108/">生产跟单</a>
                          <a href="/c100010000-p300103/">车间主任</a>
                        </div>
                      </li>
                      <li>
                        <h4>质量安全</h4>
                        <div class="text">
                          <a href="/c100010000-p300206/">审核员</a>
                          <a href="/c100010000-p300203/">故障分析师</a>
                          <a href="/c100010000-p300207/">生产安全员</a>
                          <a href="/c100010000-p230109/">汽车质量工程师</a>
                          <a href="/c100010000-p300201/">质量管理/测试</a>
                          <a href="/c100010000-p300202/">可靠度工程师</a>
                          <a href="/c100010000-p300205/">体系工程师</a>
                          <a href="/c100010000-p300204/">认证工程师</a>
                          <a href="/c100010000-p300208/">质检员</a>
                        </div>
                      </li>
                      <li>
                        <h4>新能源</h4>
                        <div class="text">
                          <a href="/c100010000-p300804/">充电桩设计</a>
                          <a href="/c100010000-p300803/">线束设计</a>
                          <a href="/c100010000-p300802/">电机工程师</a>
                          <a href="/c100010000-p300801/">电池工程师</a>
                        </div>
                      </li>
                      <li>
                        <h4>汽车制造</h4>
                        <div class="text">
                          <a href="/c100010000-p230103/">底盘工程师</a>
                          <a href="/c100010000-p230102/">车身/造型设计</a>
                          <a href="/c100010000-p230101/">汽车设计</a>
                          <a href="/c100010000-p230105/">动力系统工程师</a>
                          <a href="/c100010000-p230110/">内外饰设计工程师</a>
                          <a href="/c100010000-p230106/">汽车电子工程师</a>
                          <a href="/c100010000-p230210/">总装工程师</a>
                          <a href="/c100010000-p230107/">汽车零部件设计</a>
                          <a href="/c100010000-p230108/">汽车项目管理</a>
                        </div>
                      </li>
                      <li>
                        <h4>汽车销售与服务</h4>
                        <div class="text">
                          <a href="/c100010000-p230208/">4S店店长/维修站长</a>
                          <a href="/c100010000-p230209/">汽车改装工程师</a>
                          <a href="/c100010000-p230207/">二手车评估师</a>
                          <a href="/c100010000-p230201/">汽车销售</a>
                          <a href="/c100010000-p230206/">汽车定损理赔</a>
                          <a href="/c100010000-p230205/">汽车美容</a>
                          <a href="/c100010000-p230202/">汽车配件销售</a>
                          <a href="/c100010000-p230204/">汽车维修</a>
                          <a href="/c100010000-p230203/">汽车服务顾问</a>
                        </div>
                      </li>
                      <li>
                        <h4>机械设计/制造</h4>
                        <div class="text">
                          <a href="/c100010000-p300310/">机电工程师</a>
                          <a href="/c100010000-p300313/">夹具工程师</a>
                          <a href="/c100010000-p100813/">热设计工程师</a>
                          <a href="/c100010000-p300309/">材料工程师</a>
                          <a href="/c100010000-p300317/">铸造/锻造工程师</a>
                          <a href="/c100010000-p300315/">焊接工程师</a>
                          <a href="/c100010000-p300308/">工艺/制程工程师</a>
                          <a href="/c100010000-p300301/">机械工程师</a>
                          <a href="/c100010000-p300312/">冲压工程师</a>
                          <a href="/c100010000-p300399/">机械设计/制造</a>
                          <a href="/c100010000-p300303/">机械设备工程师</a>
                          <a href="/c100010000-p300307/">工业工程师</a>
                          <a href="/c100010000-p300316/">注塑工程师</a>
                          <a href="/c100010000-p300302/">机械设计师</a>
                          <a href="/c100010000-p300311/">CNC/数控</a>
                          <a href="/c100010000-p300306/">机械结构工程师</a>
                          <a href="/c100010000-p300305/">机械制图</a>
                          <a href="/c100010000-p100815/">精益工程师</a>
                          <a href="/c100010000-p300304/">机械维修/保养</a>
                          <a href="/c100010000-p300314/">模具工程师</a>
                        </div>
                      </li>
                      <li>
                        <h4>化工</h4>
                        <div class="text">
                          <a href="/c100010000-p300402/">实验室技术员</a>
                          <a href="/c100010000-p300405/">化妆品研发</a>
                          <a href="/c100010000-p300403/">化学分析</a>
                          <a href="/c100010000-p300404/">涂料研发</a>
                          <a href="/c100010000-p300401/">化工工程师</a>
                          <a href="/c100010000-p300406/">食品/饮料研发</a>
                          <a href="/c100010000-p300407/">化工项目经理</a>
                        </div>
                      </li>
                      <li>
                        <h4>服装/纺织/皮革</h4>
                        <div class="text">
                          <a href="/c100010000-p300509/">打样/制版</a>
                          <a href="/c100010000-p300501/">服装/纺织设计</a>
                          <a href="/c100010000-p300507/">面料辅料开发</a>
                          <a href="/c100010000-p300510/">服装/纺织/皮革跟单</a>
                        </div>
                      </li>
                      <li>
                        <h4>技工/普工</h4>
                        <div class="text">
                          <a href="/c100010000-p300610/">车工</a>
                          <a href="/c100010000-p300603/">铲车司机</a>
                          <a href="/c100010000-p300631/">切割工</a>
                          <a href="/c100010000-p300618/">机修工</a>
                          <a href="/c100010000-p300602/">叉车工</a>
                          <a href="/c100010000-p300628/">学徒工</a>
                          <a href="/c100010000-p300633/">模具工</a>
                          <a href="/c100010000-p300615/">铆工</a>
                          <a href="/c100010000-p300620/">电镀工</a>
                          <a href="/c100010000-p300629/">缝纫工</a>
                          <a href="/c100010000-p300606/">电工</a>
                          <a href="/c100010000-p300608/">木工</a>
                          <a href="/c100010000-p300612/">铣工</a>
                          <a href="/c100010000-p300623/">组装工</a>
                          <a href="/c100010000-p300625/">空调工</a>
                          <a href="/c100010000-p300627/">锅炉工</a>
                          <a href="/c100010000-p300622/">注塑工</a>
                          <a href="/c100010000-p300621/">喷塑工</a>
                          <a href="/c100010000-p300630/">搬运工</a>
                          <a href="/c100010000-p300632/">样衣工</a>
                          <a href="/c100010000-p300605/">氩弧焊工</a>
                          <a href="/c100010000-p300626/">电梯工</a>
                          <a href="/c100010000-p300613/">钳工</a>
                          <a href="/c100010000-p300609/">油漆工</a>
                          <a href="/c100010000-p300601/">普工/操作工</a>
                          <a href="/c100010000-p300624/">包装工</a>
                          <a href="/c100010000-p300616/">钣金工</a>
                          <a href="/c100010000-p300611/">磨工</a>
                          <a href="/c100010000-p300614/">钻工</a>
                          <a href="/c100010000-p300617/">抛光工</a>
                          <a href="/c100010000-p300619/">折弯工</a>
                          <a href="/c100010000-p300604/">焊工</a>
                        </div>
                      </li>
                      <li>
                        <h4>其他生产制造职位</h4>
                        <div class="text">
                          <a href="/c100010000-p300701/">其他生产制造职位</a>
                        </div>
                      </li>
                    </ul>
                  </div>
                </dl>
              </div>
            </div>
          </div>
          <div class="home-main">
            <div class="slider-box">
              <div class="promotion-main">
                <table data-sort="sortDisabled">
                  <tbody>
                  <tr class="firstRow">
                    <td valign="top" rowspan="1" colspan="2" style="word-break: break-all;"><a
                      href="https://www.zhipin.com/zt/2020/vip-kuaishou2/pc/?sid=web_banner_ks09140920%20&shid=web_banner_ks09140920"
                      target="_blank" ka="banner-promotion-activity-ks09140920" style="white-space: normal;"><img
                      src="/static/images/1.jpg"/></a>
                    </td>
                    <td width="307" valign="top" style="word-break: break-all;"><a
                      href="https://www.zhipin.com/gongsi/bfef160a859a637f0XZ709y6GQ~~.html?ka=company-intro"
                      target="_blank" ka="Banner-promotion-6218179" style="white-space: normal;"><img
                      src="/static/images/2.jpg"/></a>
                    </td>
                  </tr>
                  <tr>
                    <td valign="top" rowspan="2" colspan="2" style="word-break: break-all;"><a
                      href="https://www.zhipin.com/job_detail/?query=%E5%A4%A7%E6%95%B0%E6%8D%AE%E5%B7%A5%E7%A8%8B%E5%B8%88"
                      target="_blank" ka="https://www.zhipin.com/job_detail/?query=大数据工程师" style="white-space: normal;"><img
                      src="/static/images/3.jpg"/></a>
                    </td>
                    <td width="307" valign="top" rowspan="2" colspan="1" style="word-break: break-all;"><a
                      href="https://www.zhipin.com/job_detail/?query=%E8%AE%BE%E8%AE%A1%E5%B8%88" target="_blank"
                      ka="https://www.zhipin.com/job_detail/?query=设计师" style="white-space: normal;"><img
                      src="/static/images/4.jpg"/></a>
                    </td>
                  </tr>
                  <tr></tr>
                  </tbody>
                </table>
                <p><br/></p>
              </div>
            </div>
          </div>            <!--职位推荐列表-->
          <!--职位tab列表-->
          <div class="common-tab-box merge-city-job">
            <div class="box-title">热招职位</div>
            <h3><span class="cur" ka="index_rcmd_job_type_1">IT·互联网</span><span class=""
                                                                                ka="index_rcmd_job_type_2">产品</span><span
              class="" ka="index_rcmd_job_type_3">设计</span><span class=""
                                                                     ka="index_rcmd_job_type_4">运营</span><span
              class="" ka="index_rcmd_job_type_5">人才·事务·行政</span><span class="" ka="index_rcmd_job_type_6">高级管理</span><span
              class="" ka="index_rcmd_job_type_7">销售·房产·代理商</span><span class=""
                                                                   ka="index_rcmd_job_type_8">传媒·文案·设计</span><span
              class="" ka="index_rcmd_job_type_9">金融</span></h3>
            <ul class="cur">
              <li v-for="(item, index) in recList[0]" :key="index" v-if="index < 9" >
                <div class="sub-li">
                  <a :href="'/jobDetail.html?jobId='+  item.jobId" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">{{item.jobName}}</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">{{item.jobSalary}}</p>
                    </div>
                    <p class="job-text">{{item.jobAddress | provinceFilter}}<span class="vline"></span>{{item.jobExp}}<span class="vline"></span>{{item.jobDegree}}</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/ff3526a5364ae28e1Hd939q-.html" ka="index_rcmd_company_1" class="user-info"
                       target="_blank">
                      <p><img
                        :src="baseImageUrl + item.comLogo"
                        :alt="item.comName"></p>
                    </a>
                    <a href="/gongsi/ff3526a5364ae28e1Hd939q-.html" class="sub-li-bottom-commany-info">
                      <span class="name">{{item.comAbbreviation}}</span>
                      <span class="type">{{empType[item.comEmpType]}}</span>
                      <span class="vline"></span>
                      <span class="level">{{comStage[item.comStage]}}</span>
                    </a>
                  </div>
                </div>
              </li>
            </ul>
            <ul class="">
              <li>
                <div class="sub-li">
                  <a href="/job_detail/a2f3cba11b32fca51nB409W7E1U~.html" ka="index_rcmd_job_10" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">投资经理</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">18-36K</p>
                    </div>
                    <p class="job-text">无锡<span class="vline"></span>5-10年<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/4b724bff1b3855231nR82N25Fg~~.html" ka="index_rcmd_company_10" class="user-info"
                       target="_blank">
                      <p><img
                        src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20170915/d8943616946aa7e547b5cd2cd32b3535711eb262e57ae1b52ed95c79c1cebe78.jpg"
                        data-src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20170915/d8943616946aa7e547b5cd2cd32b3535711eb262e57ae1b52ed95c79c1cebe78.jpg?x-oss-process=image/resize,w_60,limit_0"
                        alt="澄星"></p>
                    </a>
                    <a href="/gongsi/4b724bff1b3855231nR82N25Fg~~.html" class="sub-li-bottom-commany-info">
                      <span class="name">澄星</span>
                      <span class="type">其他行业</span>
                      <span class="vline"></span>
                      <span class="level">已上市</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/15d37020a08a5c841Xd42d65E1o~.html" ka="index_rcmd_job_11" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">高级理财经理</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">15-30K</p>
                    </div>
                    <p class="job-text">西安<span class="vline"></span>3-5年<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/7d6016e3175967141nB-0969Ew~~.html" ka="index_rcmd_company_11" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20180226/d838fd3966ad99adba59b36aea8eb283e8b7a38512b73ade85d69419979e85d6.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="中融信托(中融财富)"></p>
                    </a>
                    <a href="/gongsi/7d6016e3175967141nB-0969Ew~~.html" class="sub-li-bottom-commany-info">
                      <span class="name">中融信托(中融财富)</span>
                      <span class="type">信托</span>
                      <span class="vline"></span>
                      <span class="level">不需要融资</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/c21a4b60e90f91b31Xdz3Ny6GVY~.html" ka="index_rcmd_job_12" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">投融资副总监</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">30-40K</p>
                    </div>
                    <p class="job-text">上海<span class="vline"></span>10年以上<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/f5cd81dd1ad818ba0nB82w~~.html" ka="index_rcmd_company_12" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20181114/5f94d11f64b5dd82169e0fde9b7b5cf1cfcd208495d565ef66e7dff9f98764da.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="红上财富"></p>
                    </a>
                    <a href="/gongsi/f5cd81dd1ad818ba0nB82w~~.html" class="sub-li-bottom-commany-info">
                      <span class="name">红上财富</span>
                      <span class="type">互联网金融</span>
                      <span class="vline"></span>
                      <span class="level">不需要融资</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/4757d93912c1420c1XJ-2NS7E1M~.html" ka="index_rcmd_job_13" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">蓝标公司总经理</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">15-29K</p>
                    </div>
                    <p class="job-text">上海<span class="vline"></span>10年以上<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/a5271bab11ad870d1XJz0ty1EQ~~.html" ka="index_rcmd_company_13" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20180906/f58c20d3b461a4cb5e87d74cb5bafb6cf695d697e1583e5e880a14c090f2b1fb.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="诺亚蓝标"></p>
                    </a>
                    <a href="/gongsi/a5271bab11ad870d1XJz0ty1EQ~~.html" class="sub-li-bottom-commany-info">
                      <span class="name">诺亚蓝标</span>
                      <span class="type">投资/融资</span>
                      <span class="vline"></span>
                      <span class="level">不需要融资</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/2f2e0ae6db1e16aa1XJ82N6-Elo~.html" ka="index_rcmd_job_14" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">风控</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">20-40K</p>
                    </div>
                    <p class="job-text">杭州<span class="vline"></span>1-3年<span class="vline"></span>硕士</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/22fa09a188c7165b1nB93N-5FA~~.html" ka="index_rcmd_company_14" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20180226/cdcccd257874715c64fecbdc2b5922f2cfcd208495d565ef66e7dff9f98764da.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="网商银行"></p>
                    </a>
                    <a href="/gongsi/22fa09a188c7165b1nB93N-5FA~~.html" class="sub-li-bottom-commany-info">
                      <span class="name">网商银行</span>
                      <span class="type">银行</span>
                      <span class="vline"></span>
                      <span class="level">不需要融资</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/196e618ab659c2361XN_09i8GVQ~.html" ka="index_rcmd_job_15" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">企业金融客户经理</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">30-50K</p>
                    </div>
                    <p class="job-text">南昌<span class="vline"></span>3-5年<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/2600f31bc93465de1nZ639W4.html" ka="index_rcmd_company_15" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/upload/com/logo/20190626/2a42115653da19c947f5ff47fad734b43968e64c06f964a5c17284bf66df97d7.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="恒天财富"></p>
                    </a>
                    <a href="/gongsi/2600f31bc93465de1nZ639W4.html" class="sub-li-bottom-commany-info">
                      <span class="name">恒天财富</span>
                      <span class="type">互联网金融</span>
                      <span class="vline"></span>
                      <span class="level">不需要融资</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/dae104a48f10e1611XN8392-GVs~.html" ka="index_rcmd_job_16" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">理财总监</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">15-30K</p>
                    </div>
                    <p class="job-text">北京<span class="vline"></span>5-10年<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/e73de072049aafed1nV73ts~.html" ka="index_rcmd_company_16" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/bar/brand/11156.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="诺亚财富"></p>
                    </a>
                    <a href="/gongsi/e73de072049aafed1nV73ts~.html" class="sub-li-bottom-commany-info">
                      <span class="name">诺亚财富</span>
                      <span class="type">互联网</span>
                      <span class="vline"></span>
                      <span class="level">已上市</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/ecaf4c40f4497e161Xx409y4Elo~.html" ka="index_rcmd_job_17" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">财富顾问</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">15-30K</p>
                    </div>
                    <p class="job-text">上海<span class="vline"></span>5-10年<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/965cb1bda6e10a3e1nV929m1.html" ka="index_rcmd_company_17" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20160627/f50f6c01fb18e76eeb675dff7bab879a4c6d1471b53b52eb70d568b14f0bbb11.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="中融信托"></p>
                    </a>
                    <a href="/gongsi/965cb1bda6e10a3e1nV929m1.html" class="sub-li-bottom-commany-info">
                      <span class="name">中融信托</span>
                      <span class="type">互联网金融</span>
                      <span class="vline"></span>
                      <span class="level">不需要融资</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/4b6a7d6555783c901nd82tu0ElI~.html" ka="index_rcmd_job_18" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">贸易金融部客户经理</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">15-30K</p>
                    </div>
                    <p class="job-text">南京<span class="vline"></span>3-5年<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/acbdf3a1ef2d26250XJ609y1.html" ka="index_rcmd_company_18" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20180412/8fcf137f9b3af3880292e1ee2ced7b2a.png?x-oss-process=image/resize,w_60,limit_0"
                              alt="苏宁银行"></p>
                    </a>
                    <a href="/gongsi/acbdf3a1ef2d26250XJ609y1.html" class="sub-li-bottom-commany-info">
                      <span class="name">苏宁银行</span>
                      <span class="type">银行</span>
                      <span class="vline"></span>
                      <span class="level">不需要融资</span>
                    </a>
                  </div>
                </div>
              </li>
            </ul>
            <ul class="">
              <li>
                <div class="sub-li">
                  <a href="/job_detail/a15fb8d76f8d6bfc1nR62965EVBV.html" ka="index_rcmd_job_19" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">地产中介</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">12-23K</p>
                    </div>
                    <p class="job-text">北京<span class="vline"></span>经验不限<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/d7364e46dc4759fc1nB-2d4~.html" ka="index_rcmd_company_19" class="user-info"
                       target="_blank">
                      <p><img
                        src="https://img.bosszhipin.com/beijin/mcs/bar/20191216/3e371e809d4951177b447e957f9f78d4be1bd4a3bd2a63f070bdbdada9aad826.jpg"
                        data-src="https://img.bosszhipin.com/beijin/mcs/bar/20191216/3e371e809d4951177b447e957f9f78d4be1bd4a3bd2a63f070bdbdada9aad826.jpg?x-oss-process=image/resize,w_60,limit_0"
                        alt="Lianjia.链家"></p>
                    </a>
                    <a href="/gongsi/d7364e46dc4759fc1nB-2d4~.html" class="sub-li-bottom-commany-info">
                      <span class="name">Lianjia.链家</span>
                      <span class="type">地产经纪/中介</span>
                      <span class="vline"></span>
                      <span class="level">C轮</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/fee69815432dc7691nR629m6EFJS.html" ka="index_rcmd_job_20" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">0.5-1年晋升+底薪8000+储备干部+带薪旅游</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">15-30K</p>
                    </div>
                    <p class="job-text">上海<span class="vline"></span>经验不限<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/d2146a9e0c4e924e03F_3g~~.html" ka="index_rcmd_company_20" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/bar/20191014/0f146869ce5b08d8ec6e8c50b65a9e31be1bd4a3bd2a63f070bdbdada9aad826.png?x-oss-process=image/resize,w_60,limit_0"
                              alt="上海链家"></p>
                    </a>
                    <a href="/gongsi/d2146a9e0c4e924e03F_3g~~.html" class="sub-li-bottom-commany-info">
                      <span class="name">上海链家</span>
                      <span class="type">工程施工</span>
                      <span class="vline"></span>
                      <span class="level">已上市</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/5e52cf82b2747c531nd92di8GVM~.html" ka="index_rcmd_job_21" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">建筑设计师</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">15-30K</p>
                    </div>
                    <p class="job-text">上海<span class="vline"></span>5-10年<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/ab6e55d2d66384290HZ82N-1.html" ka="index_rcmd_company_21" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20170618/b046edf46d9d66d27b1b70ca13c8a8a214e97e2f30fbde860fed3c997cc704e7.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="中建上海院"></p>
                    </a>
                    <a href="/gongsi/ab6e55d2d66384290HZ82N-1.html" class="sub-li-bottom-commany-info">
                      <span class="name">中建上海院</span>
                      <span class="type">工程施工</span>
                      <span class="vline"></span>
                      <span class="level">不需要融资</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/8103ba5755bb3e801XB82ty1GFI~.html" ka="index_rcmd_job_22" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">项目经理</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">35-55K</p>
                    </div>
                    <p class="job-text">中山<span class="vline"></span>5-10年<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/6d1ef65b112a7c7e1XF429m0Fg~~.html" ka="index_rcmd_company_22" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20180813/516b6ea3f3e5ca55ed65e450c980280fcfcd208495d565ef66e7dff9f98764da.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="盛世游艇会"></p>
                    </a>
                    <a href="/gongsi/6d1ef65b112a7c7e1XF429m0Fg~~.html" class="sub-li-bottom-commany-info">
                      <span class="name">盛世游艇会</span>
                      <span class="type">工程施工</span>
                      <span class="vline"></span>
                      <span class="level">已上市</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/310b821d9839552b03By2tW8FVQ~.html" ka="index_rcmd_job_23" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">岩土工程师</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">12-24K·14薪</p>
                    </div>
                    <p class="job-text">武汉<span class="vline"></span>3-5年<span class="vline"></span>硕士</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/d963ef19bad6228e0nZz39S6.html" ka="index_rcmd_company_23" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20180420/16ea8a2aa3d6e4032b086e8097ff0a1bcfcd208495d565ef66e7dff9f98764da.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="大成科创"></p>
                    </a>
                    <a href="/gongsi/d963ef19bad6228e0nZz39S6.html" class="sub-li-bottom-commany-info">
                      <span class="name">大成科创</span>
                      <span class="type">工程施工</span>
                      <span class="vline"></span>
                      <span class="level">已上市</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/7baf8bfc2007058e03Z72N-_GFE~.html" ka="index_rcmd_job_24" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">房产经纪人</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">25-50K</p>
                    </div>
                    <p class="job-text">常州<span class="vline"></span>经验不限<span class="vline"></span>大专</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/c975508680aa8aa11HBz2t-9EQ~~.html" ka="index_rcmd_company_24" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/upload/com/logo/20200422/41ca683fbeaf3fdcb0e178af359379b86ff8857fc68332cf250f1b7f0fc04baa.png?x-oss-process=image/resize,w_60,limit_0"
                              alt="爱家伟业房地产"></p>
                    </a>
                    <a href="/gongsi/c975508680aa8aa11HBz2t-9EQ~~.html" class="sub-li-bottom-commany-info">
                      <span class="name">爱家伟业房地产</span>
                      <span class="type">地产经纪/中介</span>
                      <span class="vline"></span>
                      <span class="level">已上市</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/16dc69a56912b0991Xd-3N69GVI~.html" ka="index_rcmd_job_25" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">地产置业顾问</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">25-50K</p>
                    </div>
                    <p class="job-text">杭州<span class="vline"></span>经验不限<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/4f285e39a72b5b041nR_09S9.html" ka="index_rcmd_company_25" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20190419/32f3f779a714c0f4cfcf44f29b14b68c400047a3618f758174ffba38cc558fe5.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="浙江链家地产"></p>
                    </a>
                    <a href="/gongsi/4f285e39a72b5b041nR_09S9.html" class="sub-li-bottom-commany-info">
                      <span class="name">浙江链家地产</span>
                      <span class="type">地产经纪/中介</span>
                      <span class="vline"></span>
                      <span class="level">已上市</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/7205ffd537c079a21XZ92dW9GVI~.html" ka="index_rcmd_job_26" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">建筑设计师（项目负责人）</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">12-24K</p>
                    </div>
                    <p class="job-text">广州<span class="vline"></span>3-5年<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/91236f752f20ff411XVz2N-7FQ~~.html" ka="index_rcmd_company_26" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20180706/44f2a3350b26d904ed034ba60eff22b1cfcd208495d565ef66e7dff9f98764da.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="广东致合房地产开..."></p>
                    </a>
                    <a href="/gongsi/91236f752f20ff411XVz2N-7FQ~~.html" class="sub-li-bottom-commany-info">
                      <span class="name">广东致合房地产开...</span>
                      <span class="type">房地产开发</span>
                      <span class="vline"></span>
                      <span class="level">不需要融资</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/7cedf1077f49fedc1XZ93d2_F1Q~.html" ka="index_rcmd_job_27" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">绿化设计所长</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">15-23K</p>
                    </div>
                    <p class="job-text">广州<span class="vline"></span>5-10年<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/8208bc0bdf4456991HR60t-5.html" ka="index_rcmd_company_27" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20160620/3ad38ea46228e740955270079db88248a913d92db28697eac97819731866a743.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="山水比德"></p>
                    </a>
                    <a href="/gongsi/8208bc0bdf4456991HR60t-5.html" class="sub-li-bottom-commany-info">
                      <span class="name">山水比德</span>
                      <span class="type">建筑设计</span>
                      <span class="vline"></span>
                      <span class="level">不需要融资</span>
                    </a>
                  </div>
                </div>
              </li>
            </ul>
            <ul class="">
              <li>
                <div class="sub-li">
                  <a href="/job_detail/8a1e4669076ada3f1nR629y8E1RS.html" ka="index_rcmd_job_28" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">就业经理</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">25-35K</p>
                    </div>
                    <p class="job-text">北京<span class="vline"></span>3-5年<span class="vline"></span>大专</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/8a7f75985e9eef80031839q7EA~~.html" ka="index_rcmd_company_28" class="user-info"
                       target="_blank">
                      <p><img
                        src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20190724/32380195e3c7a1fb9b8ff769fe2ed69ce175acd845b105f244bb4004083b2bc9_s.jpg"
                        data-src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20190724/32380195e3c7a1fb9b8ff769fe2ed69ce175acd845b105f244bb4004083b2bc9_s.jpg?x-oss-process=image/resize,w_60,limit_0"
                        alt="环球网校"></p>
                    </a>
                    <a href="/gongsi/8a7f75985e9eef80031839q7EA~~.html" class="sub-li-bottom-commany-info">
                      <span class="name">环球网校</span>
                      <span class="type">在线教育</span>
                      <span class="vline"></span>
                      <span class="level">D轮及以上</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/87160aa1fb64bc6c1nR629y7FlpS.html" ka="index_rcmd_job_29" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">课程顾问+底薪6K</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">20-40K</p>
                    </div>
                    <p class="job-text">上海<span class="vline"></span>经验不限<span class="vline"></span>大专</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/622b4177158132e51XN539-5.html" ka="index_rcmd_company_29" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/upload/com/logo/20190523/9eca1b66f5b78ecca81583065a7aec3ad81025858bcc45e28c69205d49625d0e.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="小音咖"></p>
                    </a>
                    <a href="/gongsi/622b4177158132e51XN539-5.html" class="sub-li-bottom-commany-info">
                      <span class="name">小音咖</span>
                      <span class="type">在线教育</span>
                      <span class="vline"></span>
                      <span class="level">不需要融资</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/96bb6658301978561nR629-0FFFQ.html" ka="index_rcmd_job_30" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">课程顾问+初级月薪最高5W</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">20-40K</p>
                    </div>
                    <p class="job-text">上海<span class="vline"></span>经验不限<span class="vline"></span>大专</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/622b4177158132e51XN539-5.html" ka="index_rcmd_company_30" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/upload/com/logo/20190523/9eca1b66f5b78ecca81583065a7aec3ad81025858bcc45e28c69205d49625d0e.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="小音咖"></p>
                    </a>
                    <a href="/gongsi/622b4177158132e51XN539-5.html" class="sub-li-bottom-commany-info">
                      <span class="name">小音咖</span>
                      <span class="type">在线教育</span>
                      <span class="vline"></span>
                      <span class="level">不需要融资</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/9344e6339d0cace71nR629m9EVFR.html" ka="index_rcmd_job_31" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">营销讲师</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">12-24K·15薪</p>
                    </div>
                    <p class="job-text">杭州<span class="vline"></span>1-3年<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/9b19f4f770651c2b1XN-2929.html" ka="index_rcmd_company_31" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/logo/ace892a3c348cdb3784f9617cee4ca70be1bd4a3bd2a63f070bdbdada9aad826.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="税友集团"></p>
                    </a>
                    <a href="/gongsi/9b19f4f770651c2b1XN-2929.html" class="sub-li-bottom-commany-info">
                      <span class="name">税友集团</span>
                      <span class="type">互联网</span>
                      <span class="vline"></span>
                      <span class="level">不需要融资</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/05641fc3957c8a901nR629u-EFdY.html" ka="index_rcmd_job_32" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">学科负责人（班课/深圳）</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">15-25K</p>
                    </div>
                    <p class="job-text">深圳<span class="vline"></span>3-5年<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/ac7fe97e9af7c09803F_3d2-.html" ka="index_rcmd_company_32" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/bar/20200319/d6750492b88fd0d18b0ff1281cf1538fbe1bd4a3bd2a63f070bdbdada9aad826.png?x-oss-process=image/resize,w_60,limit_0"
                              alt="晓教育集团"></p>
                    </a>
                    <a href="/gongsi/ac7fe97e9af7c09803F_3d2-.html" class="sub-li-bottom-commany-info">
                      <span class="name">晓教育集团</span>
                      <span class="type">培训机构</span>
                      <span class="vline"></span>
                      <span class="level">不需要融资</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/a68a18d20dacc2cd1nR629W-ElRX.html" ka="index_rcmd_job_33" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">高中生物主讲/教研老师</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">20-40K·13薪</p>
                    </div>
                    <p class="job-text">北京<span class="vline"></span>1-3年<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/d6f0653b1a4d44740XB_29W0.html" ka="index_rcmd_company_33" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/bar/20200916/33ff03f010a827ed063eb87d71682aa7be1bd4a3bd2a63f070bdbdada9aad826.png?x-oss-process=image/resize,w_60,limit_0"
                              alt="猿辅导"></p>
                    </a>
                    <a href="/gongsi/d6f0653b1a4d44740XB_29W0.html" class="sub-li-bottom-commany-info">
                      <span class="name">猿辅导</span>
                      <span class="type">在线教育</span>
                      <span class="vline"></span>
                      <span class="level">D轮及以上</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/5d7ecaf198883d141nB609q0E1s~.html" ka="index_rcmd_job_34" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">健身教练</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">40-80K</p>
                    </div>
                    <p class="job-text">上海<span class="vline"></span>经验不限<span class="vline"></span>学历不限</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/1222339043f2cbc21nZ60ti0.html" ka="index_rcmd_company_34" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20181218/36bb091979cd91c7e3cc08952bd48658cfcd208495d565ef66e7dff9f98764da.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="舒适堡健身"></p>
                    </a>
                    <a href="/gongsi/1222339043f2cbc21nZ60ti0.html" class="sub-li-bottom-commany-info">
                      <span class="name">舒适堡健身</span>
                      <span class="type">音乐/视频/阅读</span>
                      <span class="vline"></span>
                      <span class="level">不需要融资</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/8127892609fe119e1nR6292_FFpU.html" ka="index_rcmd_job_35" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">初/高中物理主讲老师</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">20-40K</p>
                    </div>
                    <p class="job-text">杭州<span class="vline"></span>3-5年<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/b57bc07cbff0cab01HFy2do~.html" ka="index_rcmd_company_35" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/bar/20171121/650101ebd7cd84cde4b075ffe8e1a021be1bd4a3bd2a63f070bdbdada9aad826.png?x-oss-process=image/resize,w_60,limit_0"
                              alt="杭州铭师堂"></p>
                    </a>
                    <a href="/gongsi/b57bc07cbff0cab01HFy2do~.html" class="sub-li-bottom-commany-info">
                      <span class="name">杭州铭师堂</span>
                      <span class="type">互联网</span>
                      <span class="vline"></span>
                      <span class="level">不需要融资</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/de6d65f1ea1358851nR93Nm_GVs~.html" ka="index_rcmd_job_36" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">校长</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">15-25K</p>
                    </div>
                    <p class="job-text">武汉<span class="vline"></span>3-5年<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/fac51b1826cd92631nd_2925.html" ka="index_rcmd_company_36" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20180413/0c73ea6f003db1329fc4c61e49e7941fcfcd208495d565ef66e7dff9f98764da.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="龙门尚学"></p>
                    </a>
                    <a href="/gongsi/fac51b1826cd92631nd_2925.html" class="sub-li-bottom-commany-info">
                      <span class="name">龙门尚学</span>
                      <span class="type">在线教育</span>
                      <span class="vline"></span>
                      <span class="level">已上市</span>
                    </a>
                  </div>
                </div>
              </li>
            </ul>
            <ul class="">
              <li>
                <div class="sub-li">
                  <a href="/job_detail/87a3d891a4697f5e1nR62tm_F1pU.html" ka="index_rcmd_job_37" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">后期剪辑师（原创汽车视频节目）</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">15-25K·15薪</p>
                    </div>
                    <p class="job-text">北京<span class="vline"></span>经验不限<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/ab9fdc6f043679990HY~.html" ka="index_rcmd_company_37" class="user-info"
                       target="_blank">
                      <p><img
                        src="https://img.bosszhipin.com/beijin/logo/0e0d441a2f93a236536f20e8277bf4dbbe1bd4a3bd2a63f070bdbdada9aad826.png"
                        data-src="https://img.bosszhipin.com/beijin/logo/0e0d441a2f93a236536f20e8277bf4dbbe1bd4a3bd2a63f070bdbdada9aad826.png?x-oss-process=image/resize,w_60,limit_0"
                        alt="百度"></p>
                    </a>
                    <a href="/gongsi/ab9fdc6f043679990HY~.html" class="sub-li-bottom-commany-info">
                      <span class="name">百度</span>
                      <span class="type">互联网</span>
                      <span class="vline"></span>
                      <span class="level">已上市</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/653fb2a24b5513011nR629m7F1dW.html" ka="index_rcmd_job_38" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">抖音达人</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">18-35K</p>
                    </div>
                    <p class="job-text">上海<span class="vline"></span>经验不限<span class="vline"></span>学历不限</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/b4f125303cc4360733N609S0GQ~~.html" ka="index_rcmd_company_38" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/upload/com/logo/20200709/188004249eb398061a003836dc9349a147736c4bb3ed3f50cffe829fb987c637.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="中娱"></p>
                    </a>
                    <a href="/gongsi/b4f125303cc4360733N609S0GQ~~.html" class="sub-li-bottom-commany-info">
                      <span class="name">中娱</span>
                      <span class="type">文化/体育/娱乐</span>
                      <span class="vline"></span>
                      <span class="level">不需要融资</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/c42da6bbc7cac2fc1nR62t2-GVVQ.html" ka="index_rcmd_job_39" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">主播 网红 抖音 映客 探探 快手</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">20-40K</p>
                    </div>
                    <p class="job-text">南京<span class="vline"></span>经验不限<span class="vline"></span>学历不限</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/b5633023a98af7e70H183di-Eg~~.html" ka="index_rcmd_company_39" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20200423/5fa832e9bb86db5096af16eb41fa5906c595917d1f996d804b318fd7c5318227_s.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="乐娱文化"></p>
                    </a>
                    <a href="/gongsi/b5633023a98af7e70H183di-Eg~~.html" class="sub-li-bottom-commany-info">
                      <span class="name">乐娱文化</span>
                      <span class="type">文化/体育/娱乐</span>
                      <span class="vline"></span>
                      <span class="level">不需要融资</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/d43c05380611575a1nR62ty9EVNY.html" ka="index_rcmd_job_40" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">视频策划/执行制片</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">15-25K</p>
                    </div>
                    <p class="job-text">北京<span class="vline"></span>3-5年<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/61aa287cd0ed47ad1nZz2Ni8.html" ka="index_rcmd_company_40" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/bar/20200403/8e5d340e085026b97937b7abac568424be1bd4a3bd2a63f070bdbdada9aad826.png?x-oss-process=image/resize,w_60,limit_0"
                              alt="同仁堂健康"></p>
                    </a>
                    <a href="/gongsi/61aa287cd0ed47ad1nZz2Ni8.html" class="sub-li-bottom-commany-info">
                      <span class="name">同仁堂健康</span>
                      <span class="type">医疗健康</span>
                      <span class="vline"></span>
                      <span class="level">不需要融资</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/b89c80ce2d16e7ec1HZ63d-5FVs~.html" ka="index_rcmd_job_41" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">广告公司account—AD</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">20-30K</p>
                    </div>
                    <p class="job-text">北京<span class="vline"></span>3-5年<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/5c82611c062a3e960HN93Q~~.html" ka="index_rcmd_company_41" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img2.bosszhipin.com/mcs/chatphoto/20160205/2843cb094f12b67c3812761c63961736d8ff9201eb23dced64a6c1c4b068afe7.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="新意互动"></p>
                    </a>
                    <a href="/gongsi/5c82611c062a3e960HN93Q~~.html" class="sub-li-bottom-commany-info">
                      <span class="name">新意互动</span>
                      <span class="type">互联网</span>
                      <span class="vline"></span>
                      <span class="level">不需要融资</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/ffbcbc9ac65bb03f1nV829S8EVE~.html" ka="index_rcmd_job_42" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">创意总监</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">27-50K</p>
                    </div>
                    <p class="job-text">北京<span class="vline"></span>5-10年<span class="vline"></span>大专</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/fbc82280e9e78ce81nR_2Ni0.html" ka="index_rcmd_company_42" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20170519/fe55513287b8681f80824c5f3c5af28cdfb4c2da32e22f28c7d70739ba2fb0ae.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="GPJ"></p>
                    </a>
                    <a href="/gongsi/fbc82280e9e78ce81nR_2Ni0.html" class="sub-li-bottom-commany-info">
                      <span class="name">GPJ</span>
                      <span class="type">广告营销</span>
                      <span class="vline"></span>
                      <span class="level">不需要融资</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/3f89dec8a107c6d81nR62N68F1dY.html" ka="index_rcmd_job_43" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">视频剪辑师</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">15-25K</p>
                    </div>
                    <p class="job-text">北京<span class="vline"></span>3-5年<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/aa456cb60b5eb9e81ndz3ty1.html" ka="index_rcmd_company_43" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/bar/20200916/f974d3a903a39af8a552a5f6b013ef67be1bd4a3bd2a63f070bdbdada9aad826.png?x-oss-process=image/resize,w_60,limit_0"
                              alt="作业帮"></p>
                    </a>
                    <a href="/gongsi/aa456cb60b5eb9e81ndz3ty1.html" class="sub-li-bottom-commany-info">
                      <span class="name">作业帮</span>
                      <span class="type">互联网</span>
                      <span class="vline"></span>
                      <span class="level">D轮及以上</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/2d0b5a885c0355cb1nR62N65GVtU.html" ka="index_rcmd_job_44" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">斑马AI课-动画编剧</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">11-22K·14薪</p>
                    </div>
                    <p class="job-text">北京<span class="vline"></span>1-3年<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/d6f0653b1a4d44740XB_29W0.html" ka="index_rcmd_company_44" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/bar/20200916/33ff03f010a827ed063eb87d71682aa7be1bd4a3bd2a63f070bdbdada9aad826.png?x-oss-process=image/resize,w_60,limit_0"
                              alt="猿辅导"></p>
                    </a>
                    <a href="/gongsi/d6f0653b1a4d44740XB_29W0.html" class="sub-li-bottom-commany-info">
                      <span class="name">猿辅导</span>
                      <span class="type">在线教育</span>
                      <span class="vline"></span>
                      <span class="level">D轮及以上</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/dfe5ef55208c49eb1nR62N61FlZT.html" ka="index_rcmd_job_45" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">策划总监/副总监（电商营销）</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">20-30K</p>
                    </div>
                    <p class="job-text">北京<span class="vline"></span>3-5年<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/c3d43cefcc3b614133Z-090~.html" ka="index_rcmd_company_45" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20180731/bed1d7eb682b95c0f4861f1073f7b0a7cfcd208495d565ef66e7dff9f98764da.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="灵狐科技"></p>
                    </a>
                    <a href="/gongsi/c3d43cefcc3b614133Z-090~.html" class="sub-li-bottom-commany-info">
                      <span class="name">灵狐科技</span>
                      <span class="type">互联网</span>
                      <span class="vline"></span>
                      <span class="level">已上市</span>
                    </a>
                  </div>
                </div>
              </li>
            </ul>
            <ul class="">
              <li>
                <div class="sub-li">
                  <a href="/job_detail/c496c710c44348a20H1y0tm0FVc~.html" ka="index_rcmd_job_46" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">CRO行业 临床部项目经理 PM</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">20-30K·14薪</p>
                    </div>
                    <p class="job-text">北京<span class="vline"></span>3-5年<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/d324f60687044f730Hdz3tq9.html" ka="index_rcmd_company_46" class="user-info"
                       target="_blank">
                      <p><img
                        src="https://img.bosszhipin.com/beijin/upload/com/logo/20200602/c87b809ace812a3885ea131e060656a0a395690c342631c77a6803e0d8154b10.jpg"
                        data-src="https://img.bosszhipin.com/beijin/upload/com/logo/20200602/c87b809ace812a3885ea131e060656a0a395690c342631c77a6803e0d8154b10.jpg?x-oss-process=image/resize,w_60,limit_0"
                        alt="北京海金格医药科技"></p>
                    </a>
                    <a href="/gongsi/d324f60687044f730Hdz3tq9.html" class="sub-li-bottom-commany-info">
                      <span class="name">北京海金格医药科技</span>
                      <span class="type">医疗健康</span>
                      <span class="vline"></span>
                      <span class="level">已上市</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/1962309f4be794ea0H1z3t-8Elo~.html" ka="index_rcmd_job_47" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">医美咨询</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">20-28K</p>
                    </div>
                    <p class="job-text">洛阳<span class="vline"></span>1-3年<span class="vline"></span>大专</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/6d8f3105b3b7686e33x639S_.html" ka="index_rcmd_company_47" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20190823/7a2ea657cbdcd5f9f70cad3b108d0e9ac6a167bc2bdca59546cd3b2b70de4ff3_s.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="星晨智慧物联网"></p>
                    </a>
                    <a href="/gongsi/6d8f3105b3b7686e33x639S_.html" class="sub-li-bottom-commany-info">
                      <span class="name">星晨智慧物联网</span>
                      <span class="type">医疗健康</span>
                      <span class="vline"></span>
                      <span class="level">不需要融资</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/c9cd3caedb0197b80Hx83Ni5FVM~.html" ka="index_rcmd_job_48" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">坐堂医师</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">20-30K</p>
                    </div>
                    <p class="job-text">广州<span class="vline"></span>经验不限<span class="vline"></span>学历不限</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/3862a9935cf0b47a0XZ42t6-Fw~~.html" ka="index_rcmd_company_48" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/upload/com/logo/20191016/7dee323c62e33d3a26923930d804baacc14a73852896e08fe286d6b3a5180b2b.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="广西大参林"></p>
                    </a>
                    <a href="/gongsi/3862a9935cf0b47a0XZ42t6-Fw~~.html" class="sub-li-bottom-commany-info">
                      <span class="name">广西大参林</span>
                      <span class="type">批发/零售</span>
                      <span class="vline"></span>
                      <span class="level">已上市</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/78fff0ddd7f549051nR629-5EFFU.html" ka="index_rcmd_job_49" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">医学建模工程师</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">15-25K</p>
                    </div>
                    <p class="job-text">北京<span class="vline"></span>3-5年<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/9beaa28e7f62f6c90nR40960GQ~~.html" ka="index_rcmd_company_49" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20190821/94c01dcd0165a30aa203b4a3065731dfd21fbdb94b707bb27f86a354e0ae3e45_s.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="云知声"></p>
                    </a>
                    <a href="/gongsi/9beaa28e7f62f6c90nR40960GQ~~.html" class="sub-li-bottom-commany-info">
                      <span class="name">云知声</span>
                      <span class="type">互联网</span>
                      <span class="vline"></span>
                      <span class="level">D轮及以上</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/f9433a35c044f9d21nR62tu4ElVU.html" ka="index_rcmd_job_50" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">销售</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">20-40K</p>
                    </div>
                    <p class="job-text">西双版纳<span class="vline"></span>1年以内<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/c03de4668c6579bb1nd639i0EQ~~.html" ka="index_rcmd_company_50" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20190820/a28a8a82f6fe5207017deef29511f222139eceb0631ee7b22fae1ed233b98084_s.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="豪森药业"></p>
                    </a>
                    <a href="/gongsi/c03de4668c6579bb1nd639i0EQ~~.html" class="sub-li-bottom-commany-info">
                      <span class="name">豪森药业</span>
                      <span class="type">其他行业</span>
                      <span class="vline"></span>
                      <span class="level">已上市</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/efeef3f19a6a45e91nJ_39W9GVc~.html" ka="index_rcmd_job_51" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">眼科手术医师</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">12-24K</p>
                    </div>
                    <p class="job-text">深圳<span class="vline"></span>10年以上<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/051b0a3b58c33ceb33N639-8.html" ka="index_rcmd_company_51" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20180102/c04837f3f0facdbe308327cced5b4c945571e16ac76960965dfac3104a16a43b.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="深圳博爱医疗集团"></p>
                    </a>
                    <a href="/gongsi/051b0a3b58c33ceb33N639-8.html" class="sub-li-bottom-commany-info">
                      <span class="name">深圳博爱医疗集团</span>
                      <span class="type">医疗健康</span>
                      <span class="vline"></span>
                      <span class="level">不需要融资</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/965b5f7c392896dc1nd92N-4GVM~.html" ka="index_rcmd_job_52" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">储备院长</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">30-50K</p>
                    </div>
                    <p class="job-text">北京<span class="vline"></span>10年以上<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/05d5644fb4639b0c1nd43ty8.html" ka="index_rcmd_company_52" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20161028/bb45835563e8b9c2d95d4a63e75e87259d29f3d9219bcfecbdebb2c719ca5375.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="英智康复"></p>
                    </a>
                    <a href="/gongsi/05d5644fb4639b0c1nd43ty8.html" class="sub-li-bottom-commany-info">
                      <span class="name">英智康复</span>
                      <span class="type">医疗健康</span>
                      <span class="vline"></span>
                      <span class="level">不需要融资</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/eebd5ac88885efc01XZz2Nu0GVQ~.html" ka="index_rcmd_job_53" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">牙科医生</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">15-30K</p>
                    </div>
                    <p class="job-text">南京<span class="vline"></span>1-3年<span class="vline"></span>大专</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/07d934eec0b005db1HB_292_.html" ka="index_rcmd_company_53" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20170517/e5da1d4087afea247757fa5b894aa042496c6ea7fd5d8aa3ba3448fc6b8edb9d.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="华韩整形"></p>
                    </a>
                    <a href="/gongsi/07d934eec0b005db1HB_292_.html" class="sub-li-bottom-commany-info">
                      <span class="name">华韩整形</span>
                      <span class="type">医疗健康</span>
                      <span class="vline"></span>
                      <span class="level">已上市</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/9290ab2daf3ee4dd1XZ62969EVQ~.html" ka="index_rcmd_job_54" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">超声医生</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">30-35K</p>
                    </div>
                    <p class="job-text">上海<span class="vline"></span>5-10年<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/f1fbb44bfee5a2e00nN53Nm_.html" ka="index_rcmd_company_54" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20180621/56d85397a4a83cb5d9ee59e6247155c0cfcd208495d565ef66e7dff9f98764da.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="上海美华"></p>
                    </a>
                    <a href="/gongsi/f1fbb44bfee5a2e00nN53Nm_.html" class="sub-li-bottom-commany-info">
                      <span class="name">上海美华</span>
                      <span class="type">医疗健康</span>
                      <span class="vline"></span>
                      <span class="level">不需要融资</span>
                    </a>
                  </div>
                </div>
              </li>
            </ul>
            <ul class="">
              <li>
                <div class="sub-li">
                  <a href="/job_detail/d717a612da8a71cb1nR629y6FVFQ.html" ka="index_rcmd_job_55" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">项目经理（财税）</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">15-30K</p>
                    </div>
                    <p class="job-text">北京<span class="vline"></span>5-10年<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/e1e8addc3765499c1H172dq7.html" ka="index_rcmd_company_55" class="user-info"
                       target="_blank">
                      <p><img
                        src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20180425/5a7095104685dcb7b30164524e1bc23cfd65b6e48d64cba21c87164b5e004254.jpg"
                        data-src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20180425/5a7095104685dcb7b30164524e1bc23cfd65b6e48d64cba21c87164b5e004254.jpg?x-oss-process=image/resize,w_60,limit_0"
                        alt="大账房"></p>
                    </a>
                    <a href="/gongsi/e1e8addc3765499c1H172dq7.html" class="sub-li-bottom-commany-info">
                      <span class="name">大账房</span>
                      <span class="type">互联网</span>
                      <span class="vline"></span>
                      <span class="level">已上市</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/558e2f96046d61e31XB62dy9GFA~.html" ka="index_rcmd_job_56" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">Strategy Analyst</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">15-30K</p>
                    </div>
                    <p class="job-text">北京<span class="vline"></span>1-3年<span class="vline"></span>硕士</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/33e052361693f8371nF-3d25.html" ka="index_rcmd_company_56" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/bar/20191129/3cdf5ba2149e309b38868b62ae9c22cabe1bd4a3bd2a63f070bdbdada9aad826.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="京东集团"></p>
                    </a>
                    <a href="/gongsi/33e052361693f8371nF-3d25.html" class="sub-li-bottom-commany-info">
                      <span class="name">京东集团</span>
                      <span class="type">电子商务</span>
                      <span class="vline"></span>
                      <span class="level">已上市</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/5854e5734f5710741XJ829q5FlY~.html" ka="index_rcmd_job_57" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">咨询经理</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">15-30K</p>
                    </div>
                    <p class="job-text">北京<span class="vline"></span>3-5年<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/8518dbc279823ca11nRz0t68Eg~~.html" ka="index_rcmd_company_57" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20170925/1a905adf8fa973c1d5d7cd080ea9f2a96dfa575cb13bf913ec300879c8d06826.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="中税咨询集团"></p>
                    </a>
                    <a href="/gongsi/8518dbc279823ca11nRz0t68Eg~~.html" class="sub-li-bottom-commany-info">
                      <span class="name">中税咨询集团</span>
                      <span class="type">咨询</span>
                      <span class="vline"></span>
                      <span class="level">不需要融资</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/4e6e84c7efafb95c1XJ90tq7F1o~.html" ka="index_rcmd_job_58" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">俄语翻译</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">18-36K</p>
                    </div>
                    <p class="job-text">杭州<span class="vline"></span>经验不限<span class="vline"></span>学历不限</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/9b86912e7479afbe03x6.html" ka="index_rcmd_company_58" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20180204/a6a3fc78737e5a9c3937fdc402633ff0cfcd208495d565ef66e7dff9f98764da.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="光云科技"></p>
                    </a>
                    <a href="/gongsi/9b86912e7479afbe03x6.html" class="sub-li-bottom-commany-info">
                      <span class="name">光云科技</span>
                      <span class="type">互联网</span>
                      <span class="vline"></span>
                      <span class="level">已上市</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/81b735a8f3ee80011Xx63ti7FVc~.html" ka="index_rcmd_job_59" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">数据治理顾问【资深】</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">30-50K</p>
                    </div>
                    <p class="job-text">北京<span class="vline"></span>10年以上<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/9457e17dec534e941nN63d8~.html" ka="index_rcmd_company_59" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/bar/20191220/849ba4976029c8a871753e46e7a0199ebe1bd4a3bd2a63f070bdbdada9aad826.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="BBD"></p>
                    </a>
                    <a href="/gongsi/9457e17dec534e941nN63d8~.html" class="sub-li-bottom-commany-info">
                      <span class="name">BBD</span>
                      <span class="type">数据服务</span>
                      <span class="vline"></span>
                      <span class="level">D轮及以上</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/fb70253245f8eb0f1nVy2du6ElE~.html" ka="index_rcmd_job_60" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">咨询总监</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">25-35K</p>
                    </div>
                    <p class="job-text">北京<span class="vline"></span>经验不限<span class="vline"></span>硕士</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/132a252781ac1d1f1XJ83964.html" ka="index_rcmd_company_60" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20181221/b78de3aa0e849850eca86b5a7129d025cfcd208495d565ef66e7dff9f98764da.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="百分点科技"></p>
                    </a>
                    <a href="/gongsi/132a252781ac1d1f1XJ83964.html" class="sub-li-bottom-commany-info">
                      <span class="name">百分点科技</span>
                      <span class="type">企业服务</span>
                      <span class="vline"></span>
                      <span class="level">D轮及以上</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/d294dfd552a7341c1XFy3dm9GVo~.html" ka="index_rcmd_job_61" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">执业律师（非授薪）</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">12-22K</p>
                    </div>
                    <p class="job-text">上海<span class="vline"></span>1-3年<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/4282ef11103467821XRz2d26FQ~~.html" ka="index_rcmd_company_61" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20180619/3750599696897ffbeaff1569c0336566cfcd208495d565ef66e7dff9f98764da.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="盈科上海律师事务所"></p>
                    </a>
                    <a href="/gongsi/4282ef11103467821XRz2d26FQ~~.html" class="sub-li-bottom-commany-info">
                      <span class="name">盈科上海律师事务所</span>
                      <span class="type">法律</span>
                      <span class="vline"></span>
                      <span class="level">不需要融资</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/18a78f9a681c5bbc1XFz0tq7EFQ~.html" ka="index_rcmd_job_62" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">Alliance Manager</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">30-40K</p>
                    </div>
                    <p class="job-text">上海<span class="vline"></span>5-10年<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/15cad93523fc4b7e33J-29u9.html" ka="index_rcmd_company_62" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20180321/b8f2b1bd4cb7ea66e635977aa2173583cfcd208495d565ef66e7dff9f98764da.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="毕马威"></p>
                    </a>
                    <a href="/gongsi/15cad93523fc4b7e33J-29u9.html" class="sub-li-bottom-commany-info">
                      <span class="name">毕马威</span>
                      <span class="type">咨询</span>
                      <span class="vline"></span>
                      <span class="level">不需要融资</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/0646b19c13dce5681nx93Nm6GVM~.html" ka="index_rcmd_job_63" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">战略分析专家</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">25-50K</p>
                    </div>
                    <p class="job-text">北京<span class="vline"></span>3-5年<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/8548fadc0b5c265403V93t61EQ~~.html" ka="index_rcmd_company_63" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/bar/20200916/d2bb65ff0dcaebc736a2390e9c74e0a2be1bd4a3bd2a63f070bdbdada9aad826.png?x-oss-process=image/resize,w_60,limit_0"
                              alt="滴滴"></p>
                    </a>
                    <a href="/gongsi/8548fadc0b5c265403V93t61EQ~~.html" class="sub-li-bottom-commany-info">
                      <span class="name">滴滴</span>
                      <span class="type">移动互联网</span>
                      <span class="vline"></span>
                      <span class="level">D轮及以上</span>
                    </a>
                  </div>
                </div>
              </li>
            </ul>
            <ul class="">
              <li>
                <div class="sub-li">
                  <a href="/job_detail/0be09bb2ffe798921nR62926F1NV.html" ka="index_rcmd_job_64" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">仓储运营经理</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">15-25K</p>
                    </div>
                    <p class="job-text">成都<span class="vline"></span>5-10年<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/ea9c5680f57d53d71HV90ty5.html" ka="index_rcmd_company_64" class="user-info"
                       target="_blank">
                      <p><img
                        src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20180112/541f449b75388b1699548071a381311bcfcd208495d565ef66e7dff9f98764da.jpg"
                        data-src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20180112/541f449b75388b1699548071a381311bcfcd208495d565ef66e7dff9f98764da.jpg?x-oss-process=image/resize,w_60,limit_0"
                        alt="拼多多"></p>
                    </a>
                    <a href="/gongsi/ea9c5680f57d53d71HV90ty5.html" class="sub-li-bottom-commany-info">
                      <span class="name">拼多多</span>
                      <span class="type">移动互联网</span>
                      <span class="vline"></span>
                      <span class="level">已上市</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/f32a112d929e69d61nR629-8FlNV.html" ka="index_rcmd_job_65" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">生鲜采购供应链负责人</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">40-70K·15薪</p>
                    </div>
                    <p class="job-text">北京<span class="vline"></span>5-10年<span class="vline"></span>大专</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/fc6aa2d64e0a34b01n1y0t29.html" ka="index_rcmd_company_65" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/upload/com/logo/20200718/233c7d8821216020f700ad82777cd217fdbdf01cfb4b855093fc05e02f5cb029.png?x-oss-process=image/resize,w_60,limit_0"
                              alt="美团点评"></p>
                    </a>
                    <a href="/gongsi/fc6aa2d64e0a34b01n1y0t29.html" class="sub-li-bottom-commany-info">
                      <span class="name">美团点评</span>
                      <span class="type">O2O</span>
                      <span class="vline"></span>
                      <span class="level">已上市</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/ccb8644295ae348d1Hx92di1GFc~.html" ka="index_rcmd_job_66" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">BPO海外/英语服务外包经理</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">13-23K·13薪</p>
                    </div>
                    <p class="job-text">济南<span class="vline"></span>5-10年<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/be3eb0c815e774b103B809W_.html" ka="index_rcmd_company_66" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/bar/20200417/50b39606b58338b4898092e1526445f7be1bd4a3bd2a63f070bdbdada9aad826.png?x-oss-process=image/resize,w_60,limit_0"
                              alt="优创数据技术有限公司"></p>
                    </a>
                    <a href="/gongsi/be3eb0c815e774b103B809W_.html" class="sub-li-bottom-commany-info">
                      <span class="name">优创数据技术有限公司</span>
                      <span class="type">数据服务</span>
                      <span class="vline"></span>
                      <span class="level">不需要融资</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/272be9cc77f4621403Z62NW7GVM~.html" ka="index_rcmd_job_67" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">库存管理副总监</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">25-50K</p>
                    </div>
                    <p class="job-text">北京<span class="vline"></span>5-10年<span class="vline"></span>大专</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/840d007c3d90e1df33J63Q~~.html" ka="index_rcmd_company_67" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20160330/0179f72828f99bbf0a07a4fe4d0dc5176591742118f165c1af94112d7e4e8f8a.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="美菜"></p>
                    </a>
                    <a href="/gongsi/840d007c3d90e1df33J63Q~~.html" class="sub-li-bottom-commany-info">
                      <span class="name">美菜</span>
                      <span class="type">电子商务</span>
                      <span class="vline"></span>
                      <span class="level">D轮及以上</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/afa83b2c0b8481f503Z73N60ElQ~.html" ka="index_rcmd_job_68" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">收派员</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">40-50K</p>
                    </div>
                    <p class="job-text">保定<span class="vline"></span>1-3年<span class="vline"></span>高中</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/5405f2a2431e53970XN63dS5.html" ka="index_rcmd_company_68" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20180412/8c1fe19b040b8dd26a9d0c5377554d34.png?x-oss-process=image/resize,w_60,limit_0"
                              alt="河北顺丰速运有限公司"></p>
                    </a>
                    <a href="/gongsi/5405f2a2431e53970XN63dS5.html" class="sub-li-bottom-commany-info">
                      <span class="name">河北顺丰速运有限公司</span>
                      <span class="type">物流/仓储</span>
                      <span class="vline"></span>
                      <span class="level">已上市</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/9a10bfb2851f30a703J83Ni1GVU~.html" ka="index_rcmd_job_69" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">资深物流运营专员</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">12-24K·13薪</p>
                    </div>
                    <p class="job-text">苏州<span class="vline"></span>经验不限<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/12e92393bff967950HNy3w~~.html" ka="index_rcmd_company_69" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20200429/2cb9f2750626ce710a1c731cb310972a0e87d15a8778c330d947906be2e52c23_s.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="饿了么"></p>
                    </a>
                    <a href="/gongsi/12e92393bff967950HNy3w~~.html" class="sub-li-bottom-commany-info">
                      <span class="name">饿了么</span>
                      <span class="type">O2O</span>
                      <span class="vline"></span>
                      <span class="level">不需要融资</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/ccc73b713540e15d03Fz39q7F1I~.html" ka="index_rcmd_job_70" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">承包区</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">20-21K</p>
                    </div>
                    <p class="job-text">南京<span class="vline"></span>经验不限<span class="vline"></span>学历不限</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/e4a458b3311f36091nx53tS7.html" ka="index_rcmd_company_70" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/bar/20200817/48a5ee8bef3988de0386b800f10c5355be1bd4a3bd2a63f070bdbdada9aad826.png?x-oss-process=image/resize,w_60,limit_0"
                              alt="安能物流"></p>
                    </a>
                    <a href="/gongsi/e4a458b3311f36091nx53tS7.html" class="sub-li-bottom-commany-info">
                      <span class="name">安能物流</span>
                      <span class="type">物流/仓储</span>
                      <span class="vline"></span>
                      <span class="level">D轮及以上</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/0eb7cec4e79932ff03Fz3t-6F1A~.html" ka="index_rcmd_job_71" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">安能一级及承包区</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">20-21K</p>
                    </div>
                    <p class="job-text">南京<span class="vline"></span>经验不限<span class="vline"></span>学历不限</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/e4a458b3311f36091nx53tS7.html" ka="index_rcmd_company_71" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/bar/20200817/48a5ee8bef3988de0386b800f10c5355be1bd4a3bd2a63f070bdbdada9aad826.png?x-oss-process=image/resize,w_60,limit_0"
                              alt="安能物流"></p>
                    </a>
                    <a href="/gongsi/e4a458b3311f36091nx53tS7.html" class="sub-li-bottom-commany-info">
                      <span class="name">安能物流</span>
                      <span class="type">物流/仓储</span>
                      <span class="vline"></span>
                      <span class="level">D轮及以上</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/c0862b52b9ef6db903Z92tm1Fls~.html" ka="index_rcmd_job_72" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">快递加盟商</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">21-40K</p>
                    </div>
                    <p class="job-text">南昌<span class="vline"></span>1年以内<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/9f213725b08346c31HZ529u5.html" ka="index_rcmd_company_72" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20190531/68bc48e3fafda761472aa428c628a0ddc47e6cf8d6034f41165aaf9934481249_s.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="优速快递"></p>
                    </a>
                    <a href="/gongsi/9f213725b08346c31HZ529u5.html" class="sub-li-bottom-commany-info">
                      <span class="name">优速快递</span>
                      <span class="type">物流/仓储</span>
                      <span class="vline"></span>
                      <span class="level">C轮</span>
                    </a>
                  </div>
                </div>
              </li>
            </ul>
            <ul class="">
              <li>
                <div class="sub-li">
                  <a href="/job_detail/c94e2b85d14119e91Hxz3N-9E1M~.html" ka="index_rcmd_job_73" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">外贸经理</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">15-25K</p>
                    </div>
                    <p class="job-text">嘉兴<span class="vline"></span>经验不限<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/5d627415a46b4a750nJ9.html" ka="index_rcmd_company_73" class="user-info"
                       target="_blank">
                      <p><img
                        src="https://img.bosszhipin.com/beijin/mcs/bar/20191211/cff98890aeac18b0f4dee3577d92d543be1bd4a3bd2a63f070bdbdada9aad826.jpg"
                        data-src="https://img.bosszhipin.com/beijin/mcs/bar/20191211/cff98890aeac18b0f4dee3577d92d543be1bd4a3bd2a63f070bdbdada9aad826.jpg?x-oss-process=image/resize,w_60,limit_0"
                        alt="阿里巴巴集团"></p>
                    </a>
                    <a href="/gongsi/5d627415a46b4a750nJ9.html" class="sub-li-bottom-commany-info">
                      <span class="name">阿里巴巴集团</span>
                      <span class="type">互联网</span>
                      <span class="vline"></span>
                      <span class="level">已上市</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/7d26cdd12af3bd5603J92tW-EVQ~.html" ka="index_rcmd_job_74" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">奢侈品采销经理</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">13-26K</p>
                    </div>
                    <p class="job-text">北京<span class="vline"></span>10年以上<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/8577d070dd3a5fa51XFy0tu6Eg~~.html" ka="index_rcmd_company_74" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20180823/bf78acbcb667846342a63b48c6e8ee42d52c947210a0023a2421903c7eba8751.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="奥博恒通（天津）..."></p>
                    </a>
                    <a href="/gongsi/8577d070dd3a5fa51XFy0tu6Eg~~.html" class="sub-li-bottom-commany-info">
                      <span class="name">奥博恒通（天津）...</span>
                      <span class="type">房地产开发</span>
                      <span class="vline"></span>
                      <span class="level">不需要融资</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/d460e4c4bf08243e03Zz09S6FVo~.html" ka="index_rcmd_job_75" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">资深外贸采购（五金，handtool电动工具类）</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">15-25K·13薪</p>
                    </div>
                    <p class="job-text">上海<span class="vline"></span>5-10年<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/8f7ba145cac6306a0nFz0960.html" ka="index_rcmd_company_75" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20170920/cb7fb2387e7fd37f4cc80845d1b4a6bbcfcd208495d565ef66e7dff9f98764da.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="特力集团"></p>
                    </a>
                    <a href="/gongsi/8f7ba145cac6306a0nFz0960.html" class="sub-li-bottom-commany-info">
                      <span class="name">特力集团</span>
                      <span class="type">贸易/进出口</span>
                      <span class="vline"></span>
                      <span class="level">不需要融资</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/a23c63d5bc56711a1Xd90tu7FFY~.html" ka="index_rcmd_job_76" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">商品中心副总经理（便利店）</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">15-30K</p>
                    </div>
                    <p class="job-text">南京<span class="vline"></span>10年以上<span class="vline"></span>大专</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/3f7ea70845126b991nB80t-8FQ~~.html" ka="index_rcmd_company_76" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20190506/7ef2c644aca03541c66f648259ec671e3271f3b1b94aa9b3382de4f966a10a16_s.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="Suning"></p>
                    </a>
                    <a href="/gongsi/3f7ea70845126b991nB80t-8FQ~~.html" class="sub-li-bottom-commany-info">
                      <span class="name">Suning</span>
                      <span class="type">批发/零售</span>
                      <span class="vline"></span>
                      <span class="level">已上市</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/f3fbef1ced3e25ad1XR-0961EFo~.html" ka="index_rcmd_job_77" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">跨境电商顾问</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">15-25K</p>
                    </div>
                    <p class="job-text">嘉兴<span class="vline"></span>1-3年<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/5d627415a46b4a750nJ9.html" ka="index_rcmd_company_77" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/bar/20191211/cff98890aeac18b0f4dee3577d92d543be1bd4a3bd2a63f070bdbdada9aad826.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="阿里巴巴集团"></p>
                    </a>
                    <a href="/gongsi/5d627415a46b4a750nJ9.html" class="sub-li-bottom-commany-info">
                      <span class="name">阿里巴巴集团</span>
                      <span class="type">互联网</span>
                      <span class="vline"></span>
                      <span class="level">已上市</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/ad4075dc1f2a239a1nx809y6E1Q~.html" ka="index_rcmd_job_78" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">采购主管</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">12-24K</p>
                    </div>
                    <p class="job-text">北京<span class="vline"></span>经验不限<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/ebad8a37af8239c11Xx92Q~~.html" ka="index_rcmd_company_78" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/bar/20191204/559cc995b66bdc3b0ed23e7ec5bc0fd4be1bd4a3bd2a63f070bdbdada9aad826.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="VIPKID"></p>
                    </a>
                    <a href="/gongsi/ebad8a37af8239c11Xx92Q~~.html" class="sub-li-bottom-commany-info">
                      <span class="name">VIPKID</span>
                      <span class="type">移动互联网</span>
                      <span class="vline"></span>
                      <span class="level">D轮及以上</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/a6967156b415a08d1Xdz0tq8EFo~.html" ka="index_rcmd_job_79" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">采购总监</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">20-30K</p>
                    </div>
                    <p class="job-text">北京<span class="vline"></span>5-10年<span class="vline"></span>大专</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/840d007c3d90e1df33J63Q~~.html" ka="index_rcmd_company_79" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20160330/0179f72828f99bbf0a07a4fe4d0dc5176591742118f165c1af94112d7e4e8f8a.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="美菜"></p>
                    </a>
                    <a href="/gongsi/840d007c3d90e1df33J63Q~~.html" class="sub-li-bottom-commany-info">
                      <span class="name">美菜</span>
                      <span class="type">电子商务</span>
                      <span class="vline"></span>
                      <span class="level">D轮及以上</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/395747f4cde3e6e51nR62tW_EFBU.html" ka="index_rcmd_job_80" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">商品品类经理（酒类、粮油调味、速食冲饮）</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">15-25K</p>
                    </div>
                    <p class="job-text">杭州<span class="vline"></span>经验不限<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/995bc857f163fd8d0HR60t-7.html" ka="index_rcmd_company_80" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20190406/cf5272d20d2f53a71fd19d74baeb30888e7ff2bb76411f36f82a75578d6bc642.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="拼便宜"></p>
                    </a>
                    <a href="/gongsi/995bc857f163fd8d0HR60t-7.html" class="sub-li-bottom-commany-info">
                      <span class="name">拼便宜</span>
                      <span class="type">互联网</span>
                      <span class="vline"></span>
                      <span class="level">C轮</span>
                    </a>
                  </div>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/job_detail/0dc1df6a2827f77f1nR62tS-FFdU.html" ka="index_rcmd_job_81" class="job-info"
                     target="_blank">
                    <div class="sub-li-top">
                      <p class="name">外贸经理</p>
                      <div class="guide-app-download-icon"></div>
                      <p class="salary">15-30K</p>
                    </div>
                    <p class="job-text">宁波<span class="vline"></span>3-5年<span class="vline"></span>本科</p>
                  </a>
                  <div class="sub-li-bottom">
                    <a href="/gongsi/5d627415a46b4a750nJ9.html" ka="index_rcmd_company_81" class="user-info"
                       target="_blank">
                      <p><img src=""
                              data-src="https://img.bosszhipin.com/beijin/mcs/bar/20191211/cff98890aeac18b0f4dee3577d92d543be1bd4a3bd2a63f070bdbdada9aad826.jpg?x-oss-process=image/resize,w_60,limit_0"
                              alt="阿里巴巴集团"></p>
                    </a>
                    <a href="/gongsi/5d627415a46b4a750nJ9.html" class="sub-li-bottom-commany-info">
                      <span class="name">阿里巴巴集团</span>
                      <span class="type">互联网</span>
                      <span class="vline"></span>
                      <span class="level">已上市</span>
                    </a>
                  </div>
                </div>
              </li>
            </ul>
            <p class="common-tab-more"><a class="btn btn-outline" href="/jobList.html">查看更多</a></p>
          </div>
          <!--公司tab列表-->
          <div class="common-tab-box merge-city-company">
            <div class="box-title">热门企业</div>
            <ul class="cur">
              <li>
                <div class="sub-li">
                  <a href="/gongsi/f7354a9b4ce5e4851nN73N28.html" target="_blank"
                     ka="index_rcmd_companylogo_1_custompage" class="company-info">
                    <div class="img-box">
                      <img src="https://img.bosszhipin.com/beijin/upload/com/logo/20200326/500ff152ff22d1342d10bb9382458585d27df99bb81665ffbc659e2e3c2aad28.jpg?x-oss-process=image/resize,w_100,limit_0"
                           alt="瑞祥装饰">
                    </div>
                    <div class="conpany-text">
                      <h4>瑞祥装饰</h4>
                      <p>不需要融资<span class="vline"></span>工程施工</p>
                    </div>
                  </a>
                  <a href="/gongsir/f7354a9b4ce5e4851nN73N28.html" target="_blank" ka="index_rcmd_company_1_custompage"
                     class="about-info">
                    <p><span class="text-blue">125</span>个热招职位</p>
                  </a>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/gongsi/38bd5c757efa4ab6331z.html" target="_blank" ka="index_rcmd_companylogo_2_custompage"
                     class="company-info">
                    <div class="img-box">
                      <img src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20200424/a6b7e12e59c797fe3defd1ba6b163db0fd17edca5c902374e3c4007d899331b4_s.jpg?x-oss-process=image/resize,w_100,limit_0"
                           alt="网易">
                    </div>
                    <div class="conpany-text">
                      <h4>网易</h4>
                      <p>已上市<span class="vline"></span>移动互联网</p>
                    </div>
                  </a>
                  <a href="/gongsir/38bd5c757efa4ab6331z.html" target="_blank" ka="index_rcmd_company_2_custompage"
                     class="about-info">
                    <p><span class="text-blue">3853</span>个热招职位</p>
                  </a>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/gongsi/c0aac71d2bdbea181XZ92dq8.html" target="_blank"
                     ka="index_rcmd_companylogo_3_custompage" class="company-info">
                    <div class="img-box">
                      <img src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20191106/762272f642f7480409e795fb364e9fb735c0ccb6346564b7c4163a5b6a93da62_s.jpg?x-oss-process=image/resize,w_100,limit_0"
                           alt="幼狮科技">
                    </div>
                    <div class="conpany-text">
                      <h4>幼狮科技</h4>
                      <p>未融资<span class="vline"></span>数据服务</p>
                    </div>
                  </a>
                  <a href="/gongsir/c0aac71d2bdbea181XZ92dq8.html" target="_blank" ka="index_rcmd_company_3_custompage"
                     class="about-info">
                    <p><span class="text-blue">14</span>个热招职位</p>
                  </a>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/gongsi/655e0d6566491e3b03F609U~.html" target="_blank"
                     ka="index_rcmd_companylogo_4_custompage" class="company-info">
                    <div class="img-box">
                      <img src="https://img.bosszhipin.com/beijin/upload/tmp/20190417/1ea8510bbbd2a9a5e471314659887663d3f6585d1731f6e40358edd4b43c6cab.png?x-oss-process=image/resize,w_100,limit_0"
                           alt="国金黄金">
                    </div>
                    <div class="conpany-text">
                      <h4>国金黄金</h4>
                      <p>未融资<span class="vline"></span>其他行业</p>
                    </div>
                  </a>
                  <a href="/gongsir/655e0d6566491e3b03F609U~.html" target="_blank" ka="index_rcmd_company_4_custompage"
                     class="about-info">
                    <p><span class="text-blue">167</span>个热招职位</p>
                  </a>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/gongsi/a2d6dcc42ceb4cb91XN50tm0.html" target="_blank"
                     ka="index_rcmd_companylogo_5_custompage" class="company-info">
                    <div class="img-box">
                      <img src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20200414/fa04e4c15fc1e1e0ee5574e5a2bcd4c055a9324f2b3f58bffaf0326cb828dc31_s.jpg?x-oss-process=image/resize,w_100,limit_0"
                           alt="拍店">
                    </div>
                    <div class="conpany-text">
                      <h4>拍店</h4>
                      <p>B轮<span class="vline"></span>电子商务</p>
                    </div>
                  </a>
                  <a href="/gongsir/a2d6dcc42ceb4cb91XN50tm0.html" target="_blank" ka="index_rcmd_company_5_custompage"
                     class="about-info">
                    <p><span class="text-blue">132</span>个热招职位</p>
                  </a>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/gongsi/aa456cb60b5eb9e81ndz3ty1.html" target="_blank"
                     ka="index_rcmd_companylogo_6_custompage" class="company-info">
                    <div class="img-box">
                      <img src="https://img.bosszhipin.com/beijin/mcs/bar/20200916/f974d3a903a39af8a552a5f6b013ef67be1bd4a3bd2a63f070bdbdada9aad826.png?x-oss-process=image/resize,w_100,limit_0"
                           alt="作业帮">
                    </div>
                    <div class="conpany-text">
                      <h4>作业帮</h4>
                      <p>D轮及以上<span class="vline"></span>互联网</p>
                    </div>
                  </a>
                  <a href="/gongsir/aa456cb60b5eb9e81ndz3ty1.html" target="_blank" ka="index_rcmd_company_6_custompage"
                     class="about-info">
                    <p><span class="text-blue">2357</span>个热招职位</p>
                  </a>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/gongsi/a3cdfb722b27d74433F82t4~.html" target="_blank"
                     ka="index_rcmd_companylogo_7_custompage" class="company-info">
                    <div class="img-box">
                      <img src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20181210/c63a5be9ab4d915bad2dd0957f26a9b64f2e6c09263fa9cf8e762cd91c64823d.jpg?x-oss-process=image/resize,w_100,limit_0"
                           alt="优胜教育">
                    </div>
                    <div class="conpany-text">
                      <h4>优胜教育</h4>
                      <p>不需要融资<span class="vline"></span>在线教育</p>
                    </div>
                  </a>
                  <a href="/gongsir/a3cdfb722b27d74433F82t4~.html" target="_blank" ka="index_rcmd_company_7_custompage"
                     class="about-info">
                    <p><span class="text-blue">289</span>个热招职位</p>
                  </a>
                </div>
              </li>
              <li>
                <div class="sub-li">
                  <a href="/gongsi/e3e9312266198b101nV-3Nu5.html" target="_blank"
                     ka="index_rcmd_companylogo_8_custompage" class="company-info">
                    <div class="img-box">
                      <img src="https://img.bosszhipin.com/beijin/upload/com/logo/20190520/a1e543a69a606705c1adb8b3801d1ede40d176f86a41a2528ae3942f64bbba7b.png?x-oss-process=image/resize,w_100,limit_0"
                           alt="百度外卖">
                    </div>
                    <div class="conpany-text">
                      <h4>百度外卖</h4>
                      <p>B轮<span class="vline"></span>移动互联网</p>
                    </div>
                  </a>
                  <a href="/gongsir/e3e9312266198b101nV-3Nu5.html" target="_blank" ka="index_rcmd_company_8_custompage"
                     class="about-info">
                    <p><span class="text-blue">15</span>个热招职位</p>
                  </a>
                </div>
              </li>
            </ul>
            <p class="common-tab-more"><a class="btn btn-outline" href="/gongsi/_zzz_c100010000/"
                                          ka="open_brand">查看更多</a></p>
          </div>
          <!-- 热招城市 -->
          <div class="common-tab-box hotcity-tab-box clearfix">
            <h3><span class="cur">城市热招</span></h3>
            <div class="slider-city">
              <div class="city-page-btn prev"></div>
              <div class="city-page-btn next"></div>
              <ul class="cur">
                <li class="cur slider-city-li">
                  <a href="/beijing/" ka="index_rcmd_city_1">
                    <img src="https://static.zhipin.com/zhipin-geek/v309/web/geek/images/city_101010100.png" alt="">
                    <div class="model"></div>
                  </a>
                  <a href="/shanghai/" ka="index_rcmd_city_2">
                    <img src="https://static.zhipin.com/zhipin-geek/v309/web/geek/images/city_101020100.png" alt="">
                    <div class="model"></div>
                  </a>
                  <a href="/tianjin/" ka="index_rcmd_city_3">
                    <img src="https://static.zhipin.com/zhipin-geek/v309/web/geek/images/city_101030100.png" alt="">
                    <div class="model"></div>
                  </a>
                  <a href="/xian/" ka="index_rcmd_city_4">
                    <img src="https://static.zhipin.com/zhipin-geek/v309/web/geek/images/city_101110100.png" alt="">
                    <div class="model"></div>
                  </a>
                  <a href="/suzhou/" ka="index_rcmd_city_5">
                    <img src="https://static.zhipin.com/zhipin-geek/v309/web/geek/images/city_101190400.png" alt="">
                    <div class="model"></div>
                  </a>
                  <a href="/wuhan/" ka="index_rcmd_city_6">
                    <img src="https://static.zhipin.com/zhipin-geek/v309/web/geek/images/city_101200100.png" alt="">
                    <div class="model"></div>
                  </a>
                  <a href="/nanjing/" ka="index_rcmd_city_7">
                    <img src="https://static.zhipin.com/zhipin-geek/v309/web/geek/images/city_101190100.png" alt="">
                    <div class="model"></div>
                  </a>
                  <a href="/zhengzhou/" ka="index_rcmd_city_8">
                    <img src="https://static.zhipin.com/zhipin-geek/v309/web/geek/images/city_101180100.png" alt="">
                    <div class="model"></div>
                  </a>
                  <a href="/qingdao/" ka="index_rcmd_city_9">
                    <img src="https://static.zhipin.com/zhipin-geek/v309/web/geek/images/city_101120200.png" alt="">
                    <div class="model"></div>
                  </a>
                  <a href="/hangzhou/" ka="index_rcmd_city_10">
                    <img src="https://static.zhipin.com/zhipin-geek/v309/web/geek/images/city_101210100.png" alt="">
                    <div class="model"></div>
                  </a>
                  <a href="/xiamen/" ka="index_rcmd_city_11">
                    <img src="https://static.zhipin.com/zhipin-geek/v309/web/geek/images/city_101230200.png" alt="">
                    <div class="model"></div>
                  </a>
                  <a href="/changsha/" ka="index_rcmd_city_12">
                    <img src="https://static.zhipin.com/zhipin-geek/v309/web/geek/images/city_101250100.png" alt="">
                    <div class="model"></div>
                  </a>
                  <a href="/chengdu/" ka="index_rcmd_city_13">
                    <img src="https://static.zhipin.com/zhipin-geek/v309/web/geek/images/city_101270100.png" alt="">
                    <div class="model"></div>
                  </a>
                  <a href="/guangzhoug/" ka="index_rcmd_city_14">
                    <img src="https://static.zhipin.com/zhipin-geek/v309/web/geek/images/city_101280100.png" alt="">
                    <div class="model"></div>
                  </a>
                  <a href="/shenzhen/" ka="index_rcmd_city_15">
                    <img src="https://static.zhipin.com/zhipin-geek/v309/web/geek/images/city_101280600.png" alt="">
                    <div class="model"></div>
                  </a>
                  <a href="/hefei/" ka="index_rcmd_city_16">
                    <img src="https://static.zhipin.com/zhipin-geek/v309/web/geek/images/city_101220100.png" alt="">
                    <div class="model"></div>
                  </a>
                  <a href="/chongqing/" ka="index_rcmd_city_17">
                    <img src="https://static.zhipin.com/zhipin-geek/v309/web/geek/images/city_101040100.png" alt="">
                    <div class="model"></div>
                  </a>
                  <a href="/jinan/" ka="index_rcmd_city_18">
                    <img src="https://static.zhipin.com/zhipin-geek/v309/web/geek/images/city_101120100.png" alt="">
                    <div class="model"></div>
                  </a>
                  <a href="/foshan/" ka="index_rcmd_city_19">
                    <img src="https://static.zhipin.com/zhipin-geek/v309/web/geek/images/city_101280800.png" alt="">
                    <div class="model"></div>
                  </a>
                  <a href="/dongguan/" ka="index_rcmd_city_20">
                    <img src="https://static.zhipin.com/zhipin-geek/v309/web/geek/images/city_101281600.png" alt="">
                    <div class="model"></div>
                  </a>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
      <!--底部footer-->
      <div id="footer" class="">
        <div class="inner home-inner">
          <div class="footer-social">
            <img src="https://static.zhipin.com/v2/web/geek/images/footer-logo.png" alt="">
            <p>企业服务热线和举报投诉 <span>400 065 5799</span></p>
            <p>工作日 <span>8:00 - 22:00</span></p>
            <p>休息日 <span>9:30 - 18:30</span></p>
            <p class="footer-icon">
              <a href="http://www.weibo.com/bosszhipin" rel="nofollow" ka="link-weibo" target="_blank"
                 class="icon-weibo"><span>官方微博</span></a>
              <a href="javascript:;" class="icon-weixin" ka="link-weixin"><span>微信公众号</span><img
                src="https://static.zhipin.com/v2/web/geek/images/we_chat_qr.jpg" class="qrcode-weixin"/></a>
              <a href="https://app.zhipin.com" class="icon-app" ka="link-downloadapp"><span>下载</span></a>
            </p>
          </div>
          <div class="footer-about clear-fix">
            <dl>
              <dt>企业服务</dt>
              <dd>
                <a href="https://www.zhipin.com/job_detail/" ka="link-search">职位搜索</a>
                <a href="https://news.zhipin.com/" ka="link-news">新闻资讯</a>
                <a href="https://app.zhipin.com/" ka="link-app">BOSS直聘APP</a>
              </dd>
            </dl>
            <dl>
              <dt>使用与帮助</dt>
              <dd>
                <a href="https://www.zhipin.com/web/common/protocol/index.html" rel="nofollow" ka="link-privacy"
                   target="_blank">平台协议</a>
                <a href="https://www.zhipin.com/activity/cc/anticheatguide.html" rel="nofollow" ka="link-anticheatguide"
                   target="_blank">防骗指南</a>
                <a href="https://www.zhipin.com/activity/cc/usehelp.html" rel="nofollow" ka="link-usehelp"
                   target="_blank">使用帮助</a>
              </dd>
            </dl>
            <dl>
              <dt>联系BOSS直聘</dt>
              <dd>
                <p>北京华品博睿网络技术有限公司</p>
                <p>公司地址 北京市朝阳区太阳宫中路8号冠捷大厦302</p>
                <p>联系电话 010-84150633</p>
                <p>违法和不良信息举报邮箱 <a class="report-mail" href="mailto:jubao@kanzhun.com"
                                  rel="nofollow">jubao@kanzhun.com</a></p>
              </dd>
            </dl>
          </div>
          <div class="copyright">
            <p>
              <span>Copyright © 2020 BOSS直聘</span><span>京ICP备14013441号-5</span><span>京ICP证150923号</span><span>京网文[2020]0399-066 号</span>
              <span>
                     <a href="https://www.zhipin.com/activity/cc/businesslicense.html" rel="nofollow"
                        ka="link-businesslicense" target="_blank">
                         <img src="https://static.zhipin.com/v2/web/geek/images/icon-badge-1.png" alt=""/>
                         电子营业执照
                     </a>
                </span>
              <span><a href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=11010502032801" rel="nofollow"
                       ka="link-beian" target="_blank"><img
                src="https://static.zhipin.com/v2/web/geek/images/icon-beian.png"
                alt=""/> 京公网安备11010502032801</a></span>
              <span><a href="http://sdwj.zhipin.com/web/index.html" rel="nofollow" ka="link-sdwj"
                       target="_blank">首都网警</a></span>
              <span><a href="/web/common/protocol/hr-service.html" rel="nofollow" ka="link-hr-service" target="_blank">人力资源服务许可证</a></span>
              <span><a href="https://www.12377.cn" rel="nofollow" ka="link-12377" target="_blank">网上有害信息举报专区</a></span>
            </p>
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
              <input type="hidden" class="scene" value="df3fef89071a42af947b7ff6883ddf03"/>
              <h4>微信快速注册</h4>
              <div class="qrcodeimg-box">
                <div class="invalid-box">
                  <p>请重新刷新二维码</p>
                  <button class="btn">点击刷新</button>
                </div>
                <img src="" data-url="https://www.zhipin.com/qrscan/dispatcher?qrId=df3fef89071a42af947b7ff6883ddf03">
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
    export default {
        //组件
        components: {},
        // 定义数据
        data() {
            return {
                empType:{},
                comStage:{},
                positionCategoryList: [],
                showUser:{
                    username:'',
                    rank:''
                },
                recList:[],
            }
        },
        filters:{
            provinceFilter(val){
                let pro = val.split(" ")[0]
                return pro.substring(0, pro.length - 1)
            },
        },
        //监听器
        watch: {
            positionCategoryList: function () {
                this.$nextTick(function () {
                    $('dl').hover(
                        function () {
                            $(this).addClass("cur")
                        },
                        function f() {
                            $(this).removeClass("cur")
                        }
                    )
                })
            }
        },

        created() {
            this.loadUser()
            this.loadPositionData()
            this.loadTopRecMap()
            this.findAllEmpType()
            this.findAllComStage()
        },

        methods: {
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
            mouseInDl(event){
                var el = event.currentTarget;
                $(el).addClass("cur")
            },
            mouseOutDl(event){
                var el = event.currentTarget;
                $(el).removeClass("cur")

            },
            showAllIn(){
                $('.show-all').hide()
                $(".all-box").show()
            },
            showAllOut(){
                $(".show-all").show()
                $(".all-box").hide()
            },
            loadTopRecMap(){
               this.$axios({
                   method:'get',
                   url:'/jobDetailApi/job',
                   params:{
                       methodName: 'findAllRecList'
                   }
               }).then(res=>{
                   this.recList = res.data
               })

            },
            loadUser() {
                if (localStorage.getItem('uid') != null){
                    this.$axios({
                        method: 'get',
                        url: '/positionApi/user',
                        params: {
                            methodName: 'findUserById',
                            uid: localStorage.getItem('uid')
                        }
                    }).then(res=>{
                        if (res.data.success){
                            this.showUser.username = res.data.data.username
                            this.showUser.rank = res.data.data.rank
                        }
                    })
                }
            },

            loadPositionData() {
                this.$axios({
                    method: 'get',
                    url: '/positionApi/position',
                    params: {
                        methodName: 'findAll'
                    }
                }).then(response => {
                    this.positionCategoryList = response.data;
                })
            }
        },
        mounted() {
        }
    }
</script>

<style scoped>

</style>
