<template>
  <div>
    <div id="wrap">
      <!--网站头部-->
      <div id="header">
        <div class="inner home-inner">
          <div class="nav">
            <ul>
              <li class=""><a ka="header-home" href="/">首页</a></li>
              <li class="cur"><a ka="header-job" href="#">职位</a></li>
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
                <a href="/register.html" class="btn btn-outline">注册</a>
                <a href="/login.html" class="btn btn-outline">登录</a>
              </div>
              <div style="float: right;position: relative;top: 5px;left: 10px" v-else>
                <span class="btn" style="background-color: #202329;border: 0;font-size: 14px"> 欢迎您，<a
                  href="/login.html">{{showUser.username}}</a></span>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div id="main">
        <div class="job-banner">
          <div class="inner home-inner">
            <div class="job-primary detail-box">
              <div class="info-primary">
                <div class="job-status"><span>最新</span>

                </div>
                <div class="name">
                  <h1>{{showJob.jobName}}</h1>
                  <span class="salary">{{showJob.jobSalary}}</span>
                </div>
                <p><a class="text-city" href="/xian/">{{showJob.jobProvince}}</a><em class="dolt"></em>{{showJob.jobExp}}<em
                  class="dolt"></em>{{showJob.jobDegree}}</p>
                <div class="tag-container">
                  <div class="job-tags">
                  <span v-for="item in showJob.comWelfare">
{{item}}
                  </span>
                  </div>
                </div>
              </div>
              <div class="job-op">
                <div class="btn-container">
                  <!-- 未登录 -->
                  <a class="btn btn-startchat" ka="go_chat_tosign_100001464" href="javascript:;" @click="submitResume(showJob.comId)">投递简历</a>

                </div>
                <div class="op-container">
                  <!-- 在线简历 -->
                  <a href="/resume.html" class="fl icon-resume" ka="job_online_resume_0"><i
                    class="icon"></i>填写在线简历</a>
                  <!-- 附件简历 -->
                  <a href="javascript:void(0);" @click="dialogTableVisible = true" class="fr icon-upload"
                     ka="job_attach_resume_0"><i
                    class="icon"></i>上传附件简历</a>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="smallbanner">
          <div class="inner home-inner">
            <div class="detail-op">
              <div class="btns">
                <a class="btn btn-startchat" ka="go_chat_tosign_100001464" href="javascript:;">投递简历</a>

              </div>
            </div>
            <div class="company-info">
              <div class="name">
                <h1>技术服务工程师</h1>
                <span class="badge">14-28K</span></div>
              <div class="tag-container">
                <div class="tag-more" style="opacity: 1;">
                  <span class="link-more">...</span>
                  <div class="tag-all job-tags">
                    <span>五险一金</span><span>定期体检</span><span>加班补助</span><span>年终奖</span><span>带薪年假</span><span>员工旅游</span><span>餐补</span><span>节日福利</span><span>零食下午茶</span>
                  </div>
                </div>
                <div class="job-tags">
                  <span>五险一金</span><span>定期体检</span><span>加班补助</span><span>年终奖</span><span>带薪年假</span><span>员工旅游</span><span>餐补</span><span>节日福利</span><span>零食下午茶</span>
                </div>
              </div>
              <div class="info">
                软通动力
                <a href="/gongsir/29c1ab68d5e3d3360nN63Q~~.html" target="_blank" class="link-more"
                   ka="look-all-position">查看所有职位</a>
                <div class="job-detail-guide-download-app">
                  <div class="job-detail-guide-download-app-icon"></div>
                  下载App, 不错过Boss每一条消息
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="job-box">
          <div class="inner home-inner">
            <div class="job-sider">
              <div class="sider-company">
                <p class="title">公司基本信息</p>
                <div class="company-info">
                  <a ka="job-detail-company-logo_custompage" href="/gongsi/29c1ab68d5e3d3360nN63Q~~.html" :title="                                    showJob.comName
" target="_blank">
                    <img :src="imageUrlBase + showJob.comLogo" alt=""/>
                  </a>
                  <a :href="showJob.comWebSite" target="_blank">
                    {{showJob.comAbbreviation}}
                  </a>
                </div>
                <p v-if="showJob.comStage === 0"><i class="icon-stage"></i>已上市</p>
                <p><i class="icon-scale"></i>{{showJob.comScale}}</p>
                <p><i class="icon-industry"></i><a ka="job-detail-brandindustry" href="/i100021/">{{showJob.comIndustry}}</a>
                </p>
                <p><i class="icon-net"></i>{{showJob.comWebSite}}</p>
                <p class="gray">更新于：{{showJob.jobUpdateTime | timeFilter}}</p>
              </div>
              <div class="promotion-job">
                <h3><a href="/c101110100-p100405/e_106-y_4_5_6/" rel="nofollow" ka="more-similar-jobs2" class="more"
                       target="_blank">更多相似职位</a>相似职位</h3>
                <ul>
                  <li>
                    <div class="company-logo">
                      <a ka="job_sug_brand1_custompage" href="/gongsi/02cd05cce753437e33V50w~~.html" target="_blank"
                         title="华为">
                        <img
                          src="https://img.bosszhipin.com/beijin/upload/com/logo/20200429/8f64c9d0b30a53c434b26799ca78966cec9b49ecaf1604cb263748f03d5c2b0f.png?x-oss-process=image/resize,w_100,limit_0"
                          alt=""/>
                      </a>
                    </div>
                    <div class="info-primary">
                      <div class="name"><a ka="job_sug_1" href="/job_detail/aef2bcdadaf442f20n173du5E1Y~.html"
                                           target="_blank">通用软件工程师 <span class="red">14-20K·14薪</span></a></div>
                      <p class="gray"><a ka="job_sug_brandjob1_custompage" href="/gongsir/02cd05cce753437e33V50w~~.html"
                                         target="_blank" title="华为招聘">华为</a><em class="vdot">·</em>西安</p>
                    </div>
                  </li>
                  <li>
                    <div class="company-logo">
                      <a ka="job_sug_brand2_custompage" href="/gongsi/1a2d9ab65f9eef651XF63dm9GQ~~.html" target="_blank"
                         title="西安乾景">
                        <img
                          src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20200711/a42d930b101dd318a58bd5834e2633e93935a74c86a011faf1378fb0588025ce_s.jpg?x-oss-process=image/resize,w_100,limit_0"
                          alt=""/>
                      </a>
                    </div>
                    <div class="info-primary">
                      <div class="name"><a ka="job_sug_2" href="/job_detail/b12b50458971e6391HNy39W_FVU~.html"
                                           target="_blank">硬件工程师 <span class="red">14-25K·14薪</span></a></div>
                      <p class="gray"><a ka="job_sug_brandjob2_custompage"
                                         href="/gongsir/1a2d9ab65f9eef651XF63dm9GQ~~.html" target="_blank"
                                         title="西安乾景招聘">西安乾景</a><em class="vdot">·</em>西安</p>
                    </div>
                  </li>
                  <li>
                    <div class="company-logo">
                      <a ka="job_sug_brand3_custompage" href="/gongsi/950d21d15f873b5f1nV93Nq4GFM~.html" target="_blank"
                         title="华勤通讯技术">
                        <img src="https://static.zhipin.com/zhipin-geek/v309/web/geek/images/defaultlogov2.jpg" alt=""/>
                      </a>
                    </div>
                    <div class="info-primary">
                      <div class="name"><a ka="job_sug_3" href="/job_detail/d0b16d6f0cb68ed51nd-09y-F1U~.html"
                                           target="_blank">产品经理(服务器产品) <span class="red">12-23K</span></a></div>
                      <p class="gray"><a ka="job_sug_brandjob3_custompage"
                                         href="/gongsir/950d21d15f873b5f1nV93Nq4GFM~.html" target="_blank"
                                         title="华勤通讯技术招聘">华勤通讯技术</a><em class="vdot">·</em>西安</p>
                    </div>
                  </li>
                  <li>
                    <div class="company-logo">
                      <a ka="job_sug_brand4_custompage" href="/gongsi/fa0d2795c6fd309f33x_3Ni7.html" target="_blank"
                         title="闻泰科技">
                        <img
                          src="https://img.bosszhipin.com/beijin/upload/com/logo/20190529/dc8d6e16b301f7382fa06dfbc6ffb396c8bd28de3e461c3922b6c1158cb67262.jpg?x-oss-process=image/resize,w_100,limit_0"
                          alt=""/>
                      </a>
                    </div>
                    <div class="info-primary">
                      <div class="name"><a ka="job_sug_4" href="/job_detail/32632fbbf4b6612f33B42di_E1I~.html"
                                           target="_blank">射频工程师 <span class="red">15-25K</span></a></div>
                      <p class="gray"><a ka="job_sug_brandjob4_custompage" href="/gongsir/fa0d2795c6fd309f33x_3Ni7.html"
                                         target="_blank" title="闻泰科技招聘">闻泰科技</a><em class="vdot">·</em>西安</p>
                    </div>
                  </li>
                  <li>
                    <div class="company-logo">
                      <a ka="job_sug_brand5_custompage" href="/gongsi/98afb080794b01ac0XVy29m4EA~~.html" target="_blank"
                         title="天川电气">
                        <img
                          src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20191012/64d7b6a2f6de614dcc80974840366878b07b483766447dbb1f2a2467b39d1573_s.jpg?x-oss-process=image/resize,w_100,limit_0"
                          alt=""/>
                      </a>
                    </div>
                    <div class="info-primary">
                      <div class="name"><a ka="job_sug_5" href="/job_detail/8220c4c2b92ac11233By29u7FlY~.html"
                                           target="_blank">西安技术服务工程师 <span class="red">6-8K</span></a></div>
                      <p class="gray"><a ka="job_sug_brandjob5_custompage"
                                         href="/gongsir/98afb080794b01ac0XVy29m4EA~~.html" target="_blank"
                                         title="天川电气招聘">天川电气</a><em class="vdot">·</em>西安</p>
                    </div>
                  </li>
                </ul>
                <div class="view-more"><a href="/c101110100-p100405/e_106-y_4_5_6/" rel="nofollow" target="_blank"
                                          ka="more-similar-jobs3"><i class="more">更多相似职位</i></a></div>
              </div>
              <div class="promotion-img">
                <a href="/app.html" ka="job-detail-app" target="_blank"><img
                  src="https://static.zhipin.com/zhipin-geek/v309/web/geek/images/pro-1.png" alt=""></a>
              </div>
            </div>
            <div class="job-detail">
              <div class="detail-op">
                <div class="btns">
                  <div class="op-links">
                    <a ka="job_detail_wechat_share" href="javascript:;" class="link-wechat-share"
                       data-url="/boss/share/job.json?jobId=0291c1edc23d205f1nR62928FFRU&source=2">微信扫码分享</a>
                    <a href="javascript:;" ka="job_detail_like" class="link-like "
                       data-url="/geek/tag/jobtagupdate.json?jobId=0291c1edc23d205f1nR62928FFRU&expectId=&tag=4&lid=">感兴趣</a>
                    <a ka="job_detail_report" href="javascript:;" class="link-report">举报</a>
                  </div>
                </div>

                <div class="detail-figure">
                  <img
                    src="https://img.bosszhipin.com/boss/avatar/avatar_3.png?x-oss-process=image/resize,w_100,limit_0"
                    alt=""/>
                </div>
                <h2 class="name">王女士<i class="icon-vip"></i></h2>
                <p class="gray">
                  招聘顾问<em class="vdot">·</em>刚刚在线
                </p>
              </div>
              <div class="detail-content">
                <!--已关闭职位-->

                <div class="job-sec">
                  <h3>职位描述</h3>
                  <div v-html="showJob.jobDescribe"></div>
                </div>
                <div class="job-sec company-info">
                  <h3>公司介绍</h3>
                  <div v-html="showJob.comDescribe"></div>
                </div>
                <div class="job-sec">
                  <h3>工商信息</h3>
                  <div class="name">{{showJob.comName}}</div>
                  <div class="level-list">
                    <li><span>法人代表：</span>{{showJob.comLr}}</li>
                    <li><span>注册资金：</span>{{showJob.comUsd}}万美元</li>
                    <li class="res-time"><span>成立时间：</span>{{showJob.comEsTime}}</li>
                    <li class="company-type" v-if="showJob.comEmpType === 0 "><span>企业类型：</span>有限责任公司（中外合资）</li>
                    <li class="manage-state" v-if="showJob.comStatus === 0"><span>经营状态：</span>开业</li>
                  </div>
                </div>
                <div class="job-sec">
                  <h3>工作地址</h3>
                  <div class="job-location">
                    <div class="location-address">{{showJob.jobAddress}}</div>
                    <div class="job-location-map js-open-map" :data-content="showJob.jobAddress">
                      <img
                        :src="`https://restapi.amap.com/v3/staticmap?size=836*174&markers=mid,0xFF0000,A:${jobAddressInMap}&key=${key}`"
                        alt="公司地址"/>
                      <p>点击查看地图</p>
                    </div>
                  </div>
                </div>
                <div class="job-recomend">
                  <h3><a href="/c101110100-p100405/e_106-y_4_5_6/" rel="nofollow" ka="more-similar-jobs4" class="more"
                         target="_blank">更多职位</a>看过该职位的人还看了</h3>
                  <ul>
                    <li>
                      <a ka="job_sug_6" href="/job_detail/c618837345cedd970HR609W8EFU~.html" target="_blank">
                        <div class="company-logo">
                          <img
                            src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20180511/2e671ba54284cb37d695d5565359f27ecfcd208495d565ef66e7dff9f98764da.jpg?x-oss-process=image/resize,w_100,limit_0"
                            alt=""/>
                        </div>
                        <div class="info-primary">
                          <div class="name"><b>Java开发工程师</b></div>
                          <p class="red">14-28K·16薪</p>
                          <p class="gray">
                            道通科技<em class="vdot">·</em>
                            西安
                          </p>
                        </div>
                      </a>
                    </li>
                    <li>
                      <a ka="job_sug_7" href="/job_detail/da8a9c0d597bf67833By09q8F1U~.html" target="_blank">
                        <div class="company-logo">
                          <img
                            src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20190313/004baa3b9d25822eacd1729a80be184efadd69f5f5c07ba19e482524cb16c9f9_s.jpg?x-oss-process=image/resize,w_100,limit_0"
                            alt=""/>
                        </div>
                        <div class="info-primary">
                          <div class="name"><b>千寻位置-技术支持工程师-测量测绘</b></div>
                          <p class="red">15-30K·16薪</p>
                          <p class="gray">
                            千寻位置<em class="vdot">·</em>
                            西安
                          </p>
                        </div>
                      </a>
                    </li>
                    <li>
                      <a ka="job_sug_8" href="/job_detail/b1ee4c26520426f633F92di-FVI~.html" target="_blank">
                        <div class="company-logo">
                          <img
                            src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20180412/1734aeb2de76d7c29dd112cd16318a59.jpg?x-oss-process=image/resize,w_100,limit_0"
                            alt=""/>
                        </div>
                        <div class="info-primary">
                          <div class="name"><b>云服务研发工程师</b></div>
                          <p class="red">15-30K</p>
                          <p class="gray">
                            CloudBU<em class="vdot">·</em>
                            西安
                          </p>
                        </div>
                      </a>
                    </li>
                  </ul>
                </div>
                <div class="search-box detail-search">
                  <div class="search-form">
                    <form action="/job_detail/" method="get" target="_blank">
                      <div class="search-form-con">
                        <p class="ipt-wrap"><input ka="search-job-query" name="query" type="text" class="ipt-search"
                                                   autocomplete="off" placeholder="搜索职位、公司" value="IT技术支持"></p>
                        <div class="city-sel" ka="search-select-city">
                          <i class="line"></i>
                          <span class="label-text cur"><b data-val="101110100">西安</b><i
                            class="icon-arrow-down"></i></span>
                        </div>
                      </div>
                      <input type="hidden" name="city" class="city-code" value="101110100"/>
                      <input type="hidden" name="source" value="9">
                      <button type="submit" ka="search-job" class="btn btn-search">搜索</button>
                      <div class="suggest-result">
                        <ul></ul>
                      </div>
                      <div class="city-box">
                        <ul class="dorpdown-province">
                        </ul>
                        <div class="dorpdown-city">
                        </div>
                      </div>
                    </form>
                  </div>
                </div>
                <div class="recommend-box">
                  <h3>推荐职位</h3>
                  <div class="slider-main">
                    <ul>
                      <li class="cur">
                        <a ka="job_recommend_1" href="/job_detail/6a1deb40d5c2e8e70Hx92NS1E1M~.html" target="_blank"
                           class="recommend-li">
                          <div class="name">Camera应用工程师 <span class="red">15-25K</span></div>
                          <p>讯通安添ONTIM</p>
                        </a>
                        <a ka="job_recommend_2" href="/job_detail/235a1aa738b0b63d0HR43d27GFA~.html" target="_blank"
                           class="recommend-li">
                          <div class="name">Android工程师(framework) <span class="red">14-24K</span></div>
                          <p>诚迈科技</p>
                        </a>
                        <a ka="job_recommend_3" href="/job_detail/8675bb9131b4332e0HV-2dS6FVQ~.html" target="_blank"
                           class="recommend-li">
                          <div class="name">服务器开发工程师 <span class="red">8-10K</span></div>
                          <p>莫雷尔智能科技</p>
                        </a>
                        <a ka="job_recommend_4" href="/job_detail/4409ff50ad2e553e33F83du4EVs~.html" target="_blank"
                           class="recommend-li">
                          <div class="name">前端开发工程师 <span class="red">13-26K</span></div>
                          <p>华为</p>
                        </a>
                        <a ka="job_recommend_5" href="/job_detail/009adff9741701ed0Xd92tm7Fg~~.html" target="_blank"
                           class="recommend-li">
                          <div class="name">测试工程师 <span class="red">14-28K</span></div>
                          <p>华为</p>
                        </a>
                        <a ka="job_recommend_6" href="/job_detail/96ec1329271a503633Z40tS_FlQ~.html" target="_blank"
                           class="recommend-li">
                          <div class="name">研发工程师 <span class="red">13-26K·14薪</span></div>
                          <p>华为</p>
                        </a>
                        <a ka="job_recommend_7" href="/job_detail/0e08c597c4a4b1070XJy3t-9EVo~.html" target="_blank"
                           class="recommend-li">
                          <div class="name">高级软件工程师 <span class="red">15-30K</span></div>
                          <p>华为技术有限公司</p>
                        </a>
                        <a ka="job_recommend_8" href="/job_detail/08a556b6f19ef00533x43du6F1o~.html" target="_blank"
                           class="recommend-li">
                          <div class="name">华为项目ICT集成服务工程师（统招本科） <span class="red">12-24K</span></div>
                          <p>北京外企德科人力...</p>
                        </a>
                        <a ka="job_recommend_9" href="/job_detail/e4497f525badd92933x-39i1ElQ~.html" target="_blank"
                           class="recommend-li">
                          <div class="name">云服务测试工程师 <span class="red">25-45K·16薪</span></div>
                          <p>华为</p>
                        </a>
                        <a ka="job_recommend_10" href="/job_detail/53d6a8b78a28afa533d63tm6FVs~.html" target="_blank"
                           class="recommend-li">
                          <div class="name">嵌入式工程师（会软件懂硬件） <span class="red">14-17K</span></div>
                          <p>诺维北斗</p>
                        </a>
                      </li>
                      <li class="">
                        <a ka="job_recommend_11" href="/job_detail/3f80928efacac1551XB739S9FVU~.html" target="_blank"
                           class="recommend-li">
                          <div class="name">软件工程师（Java/框架/技术负责） <span class="red">15-25K</span></div>
                          <p>陕西交通电子</p>
                        </a>
                        <a ka="job_recommend_12" href="/job_detail/c20df21f89ea9a6333F52tq1FVQ~.html" target="_blank"
                           class="recommend-li">
                          <div class="name">硬件技术开发工程师 <span class="red">13-26K</span></div>
                          <p>华为</p>
                        </a>
                        <a ka="job_recommend_13" href="/job_detail/0ae58252ebbf8a9803182NS0EVM~.html" target="_blank"
                           class="recommend-li">
                          <div class="name">java开发工程师-大数据微服务 <span class="red">15-30K</span></div>
                          <p>中软国际</p>
                        </a>
                        <a ka="job_recommend_14" href="/job_detail/f7f4f180e784a8f21HZ83NS9EFo~.html" target="_blank"
                           class="recommend-li">
                          <div class="name">高级java工程师 <span class="red">15-16K</span></div>
                          <p>中软国际</p>
                        </a>
                        <a ka="job_recommend_15" href="/job_detail/20c2dd925c2602550HB62929FFE~.html" target="_blank"
                           class="recommend-li">
                          <div class="name">高级C++服务端开发工程师 <span class="red">12-17K</span></div>
                          <p>开利软件</p>
                        </a>
                        <a ka="job_recommend_16" href="/job_detail/435215d09bb121110XF_2ty8EVI~.html" target="_blank"
                           class="recommend-li">
                          <div class="name">通信技术工程师 <span class="red">13-18K</span></div>
                          <p>华为</p>
                        </a>
                        <a ka="job_recommend_17" href="/job_detail/6c68f21cce82016d0HB90t21FFA~.html" target="_blank"
                           class="recommend-li">
                          <div class="name">区块链技术开发工程师 <span class="red">10-15K</span></div>
                          <p>陕西信企通证</p>
                        </a>
                        <a ka="job_recommend_18" href="/job_detail/6393c4c49a7515b133x92t29FFQ~.html" target="_blank"
                           class="recommend-li">
                          <div class="name">服务端软件工程师 <span class="red">15-25K</span></div>
                          <p>银河景天</p>
                        </a>
                        <a ka="job_recommend_19" href="/job_detail/8f2c93f5161a89cb031y3ti0GVE~.html" target="_blank"
                           class="recommend-li">
                          <div class="name">汽车售后服务(实习) <span class="red">10-100元/天</span></div>
                          <p>创途</p>
                        </a>
                        <a ka="job_recommend_20" href="/job_detail/b6f52d2b2540bb9d0XJ-2t21Fw~~.html" target="_blank"
                           class="recommend-li">
                          <div class="name">兼职&middot;服务员 <span class="red">13-13K</span></div>
                          <p>张亮麻辣烫</p>
                        </a>
                      </li>
                      <li class="">
                        <a ka="job_recommend_21" href="/job_detail/4f73541f92a930040Hx_09q4F1U~.html" target="_blank"
                           class="recommend-li">
                          <div class="name">高级C++服务端工程师 <span class="red">10-15K</span></div>
                          <p>开利科技</p>
                        </a>
                        <a ka="job_recommend_22" href="/job_detail/984afb2b5699d3851XFz2dm_FlU~.html" target="_blank"
                           class="recommend-li">
                          <div class="name">FAE客户技术支持工程师 <span class="red">8-16K</span></div>
                          <p>美格智能</p>
                        </a>
                        <a ka="job_recommend_23" href="/job_detail/8b3927189dde76840Xx83dW5FVE~.html" target="_blank"
                           class="recommend-li">
                          <div class="name">技术分析工程师（IDA/OD/反汇编） <span class="red">15-30K·15薪</span></div>
                          <p>道通</p>
                        </a>
                        <a ka="job_recommend_24" href="/job_detail/febf69d4a96da8580HB-3Nm_EVY~.html" target="_blank"
                           class="recommend-li">
                          <div class="name">研发工程师 <span class="red">15-30K</span></div>
                          <p>华为</p>
                        </a>
                        <a ka="job_recommend_25" href="/job_detail/7ab4a1f3b68c4dfa0XF82N-_ElI~.html" target="_blank"
                           class="recommend-li">
                          <div class="name">3DP技术支持工程师 <span class="red">12-15K</span></div>
                          <p>西安量维</p>
                        </a>
                        <a ka="job_recommend_26" href="/job_detail/717622598d3a520703x73d27E1o~.html" target="_blank"
                           class="recommend-li">
                          <div class="name">售后服务工程师 <span class="red">6-8K</span></div>
                          <p>陕西太合</p>
                        </a>
                        <a ka="job_recommend_27" href="/job_detail/4329373375d41b730Xxz39i0GFo~.html" target="_blank"
                           class="recommend-li">
                          <div class="name">技术支持工程师 <span class="red">8-10K</span></div>
                          <p>陕西精测电子</p>
                        </a>
                        <a ka="job_recommend_28" href="/job_detail/aa9134208edbb3cd0Hd43t-_FVI~.html" target="_blank"
                           class="recommend-li">
                          <div class="name">售前解决方案工程师（技术顾问） <span class="red">13-25K·13薪</span></div>
                          <p>世冠科技</p>
                        </a>
                        <a ka="job_recommend_29" href="/job_detail/b2d9d248cf49862633N-29y9EVA~.html" target="_blank"
                           class="recommend-li">
                          <div class="name">软件开发工程师 <span class="red">14-25K·15薪</span></div>
                          <p>华为技术有限公司</p>
                        </a>
                        <a ka="job_recommend_30" href="/job_detail/61ab6131f41e4bc933V-2Nq-FlI~.html" target="_blank"
                           class="recommend-li">
                          <div class="name">技术支持工程师 <span class="red">10-15K</span></div>
                          <p>中实信息</p>
                        </a>
                      </li>
                      <li class="">
                        <a ka="job_recommend_31" href="/job_detail/5b252ad581c668cf0XV_2dm_FFE~.html" target="_blank"
                           class="recommend-li">
                          <div class="name">中级服务端工程师 <span class="red">8-12K·13薪</span></div>
                          <p>维纳股份</p>
                        </a>
                        <a ka="job_recommend_32" href="/job_detail/d9f051aef8150ae533By3Ny7GVQ~.html" target="_blank"
                           class="recommend-li">
                          <div class="name">服务器PHP工程师 <span class="red">10-15K</span></div>
                          <p>聚满意</p>
                        </a>
                        <a ka="job_recommend_33" href="/job_detail/c84a48aa6eda2bf50XF83t-0E1Q~.html" target="_blank"
                           class="recommend-li">
                          <div class="name">阿里云技术服务经理 <span class="red">20-40K</span></div>
                          <p>浙江阿里巴巴云计...</p>
                        </a>
                        <a ka="job_recommend_34" href="/job_detail/3a12b90f2f20f9210XN62t24FVI~.html" target="_blank"
                           class="recommend-li">
                          <div class="name">Java（人工智能、微服务、数据平台） <span class="red">11-22K</span></div>
                          <p>中软国际</p>
                        </a>
                        <a ka="job_recommend_35" href="/job_detail/7efc74ba9287e53a1HNz3t20F1E~.html" target="_blank"
                           class="recommend-li">
                          <div class="name">射频天线工程师 <span class="red">14-25K</span></div>
                          <p>华为</p>
                        </a>
                        <a ka="job_recommend_36" href="/job_detail/77eeb110f92e96aa0X172tq_GFo~.html" target="_blank"
                           class="recommend-li">
                          <div class="name">java后台开发工程师 <span class="red">13-25K·16薪</span></div>
                          <p>腾讯</p>
                        </a>
                        <a ka="job_recommend_37" href="/job_detail/c7a87dfa1c7179d233Rz2dq0F1M~.html" target="_blank"
                           class="recommend-li">
                          <div class="name">临床技术工程师 <span class="red">10-13K·20薪</span></div>
                          <p>惠泰医疗</p>
                        </a>
                        <a ka="job_recommend_38" href="/job_detail/8f5016995922bfab03N83t-1FFc~.html" target="_blank"
                           class="recommend-li">
                          <div class="name">核心网技术支持工程师 <span class="red">11-22K</span></div>
                          <p>软通动力信息技术集团</p>
                        </a>
                        <a ka="job_recommend_39" href="/job_detail/39565d5e052a153733F63di5FVo~.html" target="_blank"
                           class="recommend-li">
                          <div class="name">科研技术服务工程师 <span class="red">5-10K</span></div>
                          <p>基恩科生物</p>
                        </a>
                        <a ka="job_recommend_40" href="/job_detail/8a56f827d7dcf5c61HR-3d6_EFY~.html" target="_blank"
                           class="recommend-li">
                          <div class="name">游戏服务器开发工程师 <span class="red">8-13K·13薪</span></div>
                          <p>西安云睿网络科技</p>
                        </a>
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <footer_cl/>
      <!-- 通用侧边栏 -->
      <siderbar/>

      <div class="container-mes">
        <ul class="message">
          <li><span class="text">你好</span></li>
          <li><span class="text">可以聊聊吗</span></li>
          <li><span class="text">我是谁谁谁我是谁谁谁</span></li>
        </ul>
        <div class="avatar">
          <img src="https://img.bosszhipin.com/boss/avatar/avatar_3.png?x-oss-process=image/resize,w_100,limit_0"/>
        </div>
      </div>
      <div class="container-tip">
        <div class="tip-box">
          <p class="tit">快速完善简历，与Boss开聊</p>
          <p>与在线Boss直接聊，最快当天拿offer</p>
          <a ka="job-detail-complete" href="javascript:;">快速完善信息</a>
          <i class="trangle"></i>
        </div>
        <div class="tip-bot"><a href="javascript:;" class="close"></a></div>
      </div>
      <div class="aladingtip">
        <img src="https://static.zhipin.com/zhipin-geek/v309/web/geek/images/tip.png">
      </div>

    </div>

    <el-dialog title="上传简历" :visible.sync="dialogTableVisible">
      <el-upload
        ref="resume"
        :on-success="handleSuccess"
        class="upload-demo"
        drag
        accept=".doc,.pdf,.docx"
        :action="PDF_URL"
        multiple>
        <i class="el-icon-upload"></i>
        <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
        <div class="el-upload__tip" slot="tip">只能上传pdf/doc/docx文件</div>
      </el-upload>
    </el-dialog>
  </div>
</template>

<script>
    //import teacher from '@/api/admin/edu/teacher'
    import footer_cl from "../footer/footer"
    import siderbar from "../siderbar/siderbar";
    import dateUtil from "../../utils/dateUtil";

    export default {
        //组件
        components: {footer_cl, siderbar},
        // 定义数据
        data() {
            return {
                dialogTableVisible: false,
                imageUrlBase: this.imageBaseUrl,
                showUser: {
                    username: "",
                    rank: ""
                },
                showJob: {},
                jobAddressInMap: "",
                key: "d559927603b2cb90711b7ffcac66a5b7",
                PDF_URL: "/resumeApi/resume?methodName=uploadPDF&uid=" + localStorage.getItem("uid"),
                hasResume: false
            }
        },
        filters: {
            timeFilter(val) {
                return dateUtil.timestampToTime(val)
            }
        },

        //监听器
        watch: {},

        created() {
            this.loadUser()
            this.loadJobDetail()
        },

        methods: {
            submitResume(companyId){
                this.findResumeByUid(companyId);
            },
            postResume(companyId){
                this.$axios({
                    method: 'post',
                    url: '/resume',
                    params: {
                        methodName: 'postResume',
                        uid: localStorage.getItem('uid'),
                        jobId: decodeURI(this.getQueryString("jobId")),
                        companyId: companyId
                    }
                }).then(res => {
                    if (res.data.success) {
                        this.$message.success("简历投递成功")
                    }
                })
            },
            findResumeByUid(companyId){
                this.$axios({
                    method: 'get',
                    url: '/resume',
                    params: {
                        methodName: 'findResumeByUid',
                        uid: localStorage.getItem('uid')
                    }
                }).then(res => {
                    if (res.data.success) {
                        if (res.data.data === undefined){
                            this.$message.warning("请先制作简历")
                        }else{
                            this.postResume(companyId)
                        }
                    }
                })
            },
            handleSuccess(response, file, fileList) {
                this.$refs.resume.clearFiles();
                this.dialogTableVisible = false
                this.$message.success("上传成功")
            },
            loadUser() {
                if (localStorage.getItem('uid') != null) {
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
            getQueryString(name) {
                let reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
                let r = window.location.search.substr(1).match(reg);
                if (r != null) return unescape(r[2]);
                return null;
            },
            loadJobDetail() {
                let jobId = decodeURI(this.getQueryString("jobId"));
                this.$axios({
                    method: 'get',
                    url: '/job',
                    params: {
                        methodName: 'findJobInfoById',
                        jobId: jobId
                    }
                }).then(res => {
                    if (res.data.success) {
                        this.showJob = res.data.data;
                        this.loadMapInfo()
                    }
                })
            },
            loadMapInfo() {
                //https://restapi.amap.com/v3/geocode/geo?address=北京市朝阳区阜通东大街6号&output=XML&key=<用户的key>
                this.$axios({
                    method: 'get',
                    url: "https://restapi.amap.com/v3/geocode/geo",
                    params: {
                        address: this.showJob.jobAddress,
                        key: this.key
                    }
                }).then(res => {
                    // res.data.geocodes[0].location
                    this.jobAddressInMap = res.data.geocodes[0].location
                })
            },
        },
        mounted() {
        }
    }
</script>

<style scoped>
  .sign-form .ipt-phone {
    padding-left: 94px;
  }

  .level-list {
    margin-top: 5px;
    height: 66px;
    padding: 0 0 10px;
  }

  /deep/ .el-dialog {
    width: 400px;
  }
</style>
