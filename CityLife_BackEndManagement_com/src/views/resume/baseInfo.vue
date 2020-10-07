<template>
  <div class="app-container">
    <div class="filter-container" style="margin-bottom: 15px">
      <el-input v-model="listQuery.name" placeholder="职位名称" style="width: 200px;" class="filter-item"/>
      <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">
        查找
      </el-button>
    </div>
    <el-table
      v-loading="listLoading"
      :data="list"
      element-loading-text="Loading"
      border
      fit
      highlight-current-row
    >
      <el-table-column align="center" label="ID" width="95">
        <template slot-scope="scope">
          {{ scope.$index + 1}}
        </template>
      </el-table-column>
      <el-table-column label="用户名" align="center" width="170">
        <template slot-scope="scope">
          {{ scope.row.username }}
        </template>
      </el-table-column>
      <el-table-column label="联系方式" width="180" align="center">
        <template slot-scope="scope">
          <span>{{ scope.row.phone }}</span>
        </template>
      </el-table-column>
      <el-table-column label="职位" width="200" align="center">
        <template slot-scope="scope">
          {{ scope.row.jobName}}
        </template>
      </el-table-column>
      <el-table-column label="公司" width="270" align="center">
        <template slot-scope="scope">
          {{ scope.row.comName}}
        </template>
      </el-table-column>
      <el-table-column class-name="status-col" label="操作" width="240" align="center">
        <template slot-scope="{row}">
          <el-button type="primary" size="small" style="float: left" icon="el-icon-edit" @click="handleResume(row)">
            查看简历
          </el-button>
          <el-button type="success" size="small" style="float: right;margin:0px 5px;" icon="el-icon-chat-line-round"
                     @click="handlePostEmail(row)">回复邮件
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <pagination v-show="total>0" :total="total" :page.sync="listQuery.page" :limit.sync="listQuery.limit"
                @pagination="loadBaseInfo"/>
  </div>
</template>

<script>
    //import teacher from '@/api/admin/edu/teacher'
    import Qs from 'qs'
    import pagination from '@/components/Pagination'

    export default {
        //组件
        components: {pagination},
        // 定义数据
        data() {
            return {
                list: null,
                listQuery: {
                    page: 1,
                    limit: 20,
                    jobName:'',
                    comName:'',
                    uid:''
                },
                listLoading: false,
                total: 0,
                form: {
                    id: '',
                    username: '',
                    phone: '',
                    jobName: '',
                    comName: ''
                },
                formLabelWidth: '120px',
            }
        },

        //监听器
        watch: {},

        created() {
            this.loadBaseInfo()
        },

        methods: {
            handleResume(row) {
                this.$router.push({ name: 'resume', params: { uid: row.uid }});
            },
            handlePostEmail(row) {
                this.$router.push({ name: 'sendEmail', params: { uid: row.uid}});
            },
            loadBaseInfo() {
                this.listQuery.uid = localStorage.getItem("uid")
                this.$axios({
                    method: 'post',
                    url: '/resumeApi/resume',
                    data: Qs.stringify(this.listQuery),
                    params: {
                        methodName: 'findAllResumePost'
                    }
                }).then(res => {
                    if (res.data.success) {
                        this.list = res.data.data.rows
                        this.total = res.data.data.total
                    }
                })
            },
            handleFilter() {
                this.listQuery.page = 1
                this.loadBaseInfo()
            },
        }
    }
</script>

<style scoped>
  /deep/ .el-table th.gutter{
    display: table-cell!important;
  }
  /deep/ .el-table__header-wrapper, .el-table__footer-wrapper {
    border-bottom: 1px solid #dfe6ec;
  }
  /deep/ .el-table th{
    top: 1px;
  }
</style>
