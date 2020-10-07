<template>
  <div class="app-container">
    标题：
    <el-input style="margin: 15px 0px;width: 500px;" v-model="emailDto.title" placeholder="邮件标题"></el-input>
    <div>
      内容：
      <Editor style="margin-top: 15px" v-model="emailDto.content" :height="440"/>
    </div>
    <el-button style="margin-top: 15px" type="primary" @click="sendEmail">发送邮件</el-button>
  </div>
</template>

<script>
    //import teacher from '@/api/admin/edu/teacher'
    import Qs from 'qs'
    import Editor from '@/components/Tinymce'

    export default {
        //组件
        components: {Editor},
        // 定义数据
        data() {
            return {
                emailDto: {
                    uid: '',
                    title: '',
                    content: ''
                }
            }
        },

        //监听器
        watch: {},

        created() {
          this.checkUid()
        },
        inject: ['reload'],
        methods: {
            checkUid() {
                let uid = this.$route.params.uid
                if (uid === undefined || uid === '' || uid === null) {
                    this.$router.push("/baseInfo")
                }
            },
            sendEmail() {
                this.emailDto.uid = this.$route.params.uid
                this.$axios({
                    method: 'post',
                    url: '/emailApi/email',
                    data: Qs.stringify(this.emailDto),
                    params: {
                        methodName: 'sendEmail'
                    }
                }).then(res => {
                    if (res.data.success) {
                        this.$message.success("发送成功")
                        this.$router.push("/baseInfo")
                    }
                })
            }
        }
    }
</script>

<style scoped>

</style>
