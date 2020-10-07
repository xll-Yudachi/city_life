<template>
  <div class="app-container" v-html="this.showCompanyDescribe.content" />
</template>

<script>
export default {
  name: 'Preview',
  components: { },
  data() {
    return {
      id: this.$route.query.id,
      showCompanyDescribe: {}
    }
  },
  created() {
    if (this.id === undefined) {
      this.$router.push('/comAudit')
    }
    this.loadDescribe()
  },
  mounted() {
  },
  methods: {
    loadDescribe() {
      this.$axios({
        method: 'get',
        url: '/companyApi/company',
        params: {
          methodName: 'findCompanyDescribe',
          cid: this.id
        }
      }).then(res => {
        if (res.data.success) {
          this.showCompanyDescribe = res.data.data
        } else {
          this.$message.error(res.data.message)
        }
      })
    }
  }
}
</script>
<style scoped>

</style>

