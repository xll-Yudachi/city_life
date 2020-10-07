<template>
  <div class="app-container" v-cloak>
    <h2 v-if="!hasPDF">暂未上传PDF文档</h2>
    <pdf v-else ref="pdf" :src="PDFUrl" v-for="i in numPages" :key="i" :page='i'>
    </pdf>
  </div>
</template>

<script>
    //import teacher from '@/api/admin/edu/teacher'
    import Qs from 'qs'
    import pdf from 'vue-pdf'
    export default {
        //组件
        components: {pdf},
        // 定义数据
        data() {
            return {
                numPages: null,
                PDFUrl:'',
                hasPDF:false
            }
        },

        //监听器
        watch: {},

        created() {
            this.loadPDF()
        },

        methods: {
            // 解决pdf只显示第一页的问题
            getNumPages() {
                let loadingTask = pdf.createLoadingTask(this.PDFUrl)
                loadingTask.promise.then(pdf => {
                    this.numPages = pdf.numPages
                }).catch(err => {
                    console.error('pdf 加载失败-->', err)
                })
            },
            loadPDF() {
                let uid = this.$route.params.uid
                if (uid === undefined || uid === '' || uid === null){
                    this.$router.push("/baseInfo")
                }else{
                    this.$axios({
                        method: 'get',
                        url: '/resumeApi/media',
                        params: {
                            methodName: 'findPDF',
                            uid : uid
                        }
                    }).then(res => {
                        if (res.data.success) {
                            this.PDFUrl = "/PDFApi/"+  res.data.data.url
                            this.getNumPages()
                            this.hasPDF = true
                        }
                    })
                }
            }
        }
    }
</script>

<style scoped>
  [v-cloak]{
    display: none;
  }
</style>
