<template>
  <div>
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
  </div>
</template>

<script>
    //import teacher from '@/api/admin/edu/teacher'
    export default {
        //组件
        components: {},
        // 定义数据
        data() {
            return {}
        },

        //监听器
        watch: {},

        created() {},

        methods: {},
        mounted() {
        }
    }
</script>

<style scoped>

</style>
