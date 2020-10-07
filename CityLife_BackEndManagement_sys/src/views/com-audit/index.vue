<template>
  <div class="app-container">
    <div style="margin-bottom: 15px;" class="filter-container">
      <el-input
        v-model="listQuery.comName"
        placeholder="公司名称"
        style="width: 200px;"
        class="filter-item"
        @keyup.enter.native="handleFilter"
      />
      <el-date-picker
        v-model="listQuery.auditSubmitTime"
        type="datetimerange"
        range-separator="至"
        start-placeholder="开始日期"
        end-placeholder="结束日期"
      />
      <el-select v-model="listQuery.auditType" placeholder="审核状态" clearable class="filter-item" style="width: 130px">
        <el-option v-for="item in auditTypeOptions" :key="item.key" :label="item.display_name" :value="item.key" />
      </el-select>
      <el-select v-model="listQuery.sort" style="width: 140px" class="filter-item" @change="handleFilter">
        <el-option v-for="item in sortOptions" :key="item.key" :label="item.label" :value="item.key" />
      </el-select>
      <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">
        查找
      </el-button>
    </div>

    <el-table
      :key="tableKey"
      v-loading="listLoading"
      :data="list"
      border
      highlight-current-row
      style="width: 100%;margin-bottom: 20px;"
      @sort-change="sortChange"
    >
      <el-table-column
        label="ID"
        prop="comId"
        sortable="custom"
        align="center"
        width="80"
        :class-name="getSortClass('id')"
      />
      <el-table-column label="公司名称" min-width="100px" width="350px" align="center" prop="comName" />
      <el-table-column label="公司法人" width="140px" align="center" prop="comLr" />
      <el-table-column label="注册资金(美金)" width="145px" align="center" prop="comUsd" />
      <el-table-column label="行业方向" align="center" width="145" prop="comIndustry" />
      <el-table-column label="审核状态" class-name="status-col" width="125" align="center" prop="comAudit">
        <template slot-scope="{row}">
          <el-tag :type="row.comAudit | statusFilter">
            {{ row.comAudit === 0 ? '审核中' : (row.comAudit === 1 ? '审核通过' : '审核失败') }}
          </el-tag>
        </template>
      </el-table-column>
      <!-- <el-table-column label="申请审核时间" width="145px" align="center" prop="">
         <template slot-scope="scope">
           <span>{{ scope.row.timestamp }}</span>
         </template>
       </el-table-column>-->
      <el-table-column label="操作" align="center" width="145px" class-name="small-padding fixed-width">
        <template slot-scope="{row}">
          <el-button v-if="row.comAudit === 0" type="primary" size="mini" @click="handleUpdate(row)">
            审核
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="listQuery.page"
      :limit.sync="listQuery.limit"
      @pagination="getList"
    />

    <el-dialog :title="textMap[dialogStatus]" :visible.sync="dialogFormVisible">
      <el-form
        ref="dataForm"
        :rules="rules"
        :model="temp"
        label-position="left"
        label-width="70px"
        style="width: 500px; margin-left:50px;"
      >
        <el-form-item label="公司名称" prop="comName">
          {{ temp.comName }}
        </el-form-item>
        <el-form-item label="公司法人" prop="comLr">
          {{ temp.comLr }}
        </el-form-item>
        <el-form-item label="公司类型" prop="comEmpType">
          {{ empTypeMap[temp.comEmpType] }}
        </el-form-item>
        <el-form-item label="公司创建时间" label-width="100px" prop="comEsTime">
          {{ temp.comEsTime }}
        </el-form-item>
        <el-form-item label="公司规模" prop="comScale">
          {{ temp.comScale }}
        </el-form-item>
        <el-form-item label="公司阶段" prop="comStage">
          {{ comStageMap[temp.comStage] }}
        </el-form-item>
        <el-form-item label="公司注册资金" label-width="100px" prop="comUsd">
          {{ temp.comUsd }} 万（美元）
        </el-form-item>
        <el-form-item label="公司网页站点" label-width="100px" prop="comWebSite">
          {{ temp.comWebSite }}
        </el-form-item>
        <el-form-item label="公司福利" label-width="100px" prop="comWelfare">
          <el-tag v-for="item in temp.comWelfare " :key="item.id" style="margin-right: 10px">{{ item }}</el-tag>
        </el-form-item>
        <el-form-item label="公司Logo" label-width="100px" prop="comLogo">
          <el-image
            style="width: 100px; height: 100px"
            :src="baseImageUrl + temp.comLogo"
            :preview-src-list="[baseImageUrl + temp.comLogo]"
          />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="toPreview(temp.comId)">
          预览公司简介
        </el-button>
        <el-button type="primary" @click="updateData(temp.comId)">
          审核通过
        </el-button>
        <el-button @click="dialogFormVisible = false">
          取消
        </el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import Pagination from '@/components/Pagination' // secondary package based on el-pagination
import Qs from 'qs'

const auditTypeOptions = [
  { key: '0', display_name: '审核中' },
  { key: '1', display_name: '审核成功' },
  { key: '2', display_name: '审核失败' }
]
const empTypeMap = {
  0: '有限责任公司（中外合资）'
}
const comStageMap = {
  0: '已上市'
}

// arr to obj, such as { CN : "China", US : "USA" }
const auditTypeKeyValue = auditTypeOptions.reduce((acc, cur) => {
  acc[cur.key] = cur.display_name
  return acc
}, {})

export default {
  name: 'ComAudit',
  components: { Pagination },
  filters: {
    statusFilter(status) {
      const statusMap = {
        0: 'info',
        1: 'success',
        2: 'danger'
      }
      return statusMap[status]
    },
    typeFilter(type) {
      return auditTypeKeyValue[type]
    }
  },
  data() {
    return {
      comStageMap,
      tableKey: 0,
      list: [],
      total: 0,
      listLoading: true,
      baseImageUrl: this.baseImageUrl,
      listQuery: {
        page: 1,
        limit: 20,
        comName: '',
        auditSubmitTime: '',
        auditType: '',
        sort: '+id',
        methodName: 'findAllCompany'
      },
      showCompany: {},
      auditTypeOptions,
      sortOptions: [{ label: '升序', key: '+id' }, { label: '降序', key: '-id' }],
      statusOptions: ['审核中', '审核成功', '审核失败'],
      showReviewer: false,
      temp: {
        id: undefined,
        importance: 1,
        remark: '',
        timestamp: new Date(),
        title: '',
        type: '',
        status: 'published'
      },
      dialogFormVisible: false,
      dialogStatus: '',
      textMap: {
        update: '具体信息'
      },
      dialogPvVisible: false,
      pvData: [],
      rules: {
        type: [{ required: true, message: 'type is required', trigger: 'change' }],
        timestamp: [{ type: 'date', required: true, message: 'timestamp is required', trigger: 'change' }],
        title: [{ required: true, message: 'title is required', trigger: 'blur' }]
      },
      downloadLoading: false,
      empTypeMap
    }
  },
  created() {
    this.getList()
  },
  methods: {
    toPreview(id) {
      this.$router.push({
        path: 'comDescribe',
        query: {
          id: id
        }
      })
    },
    updateData(comId) {
      this.$axios({
        method: 'post',
        url: '/companyApi/company',
        params: {
          methodName: 'updateCompany',
          comId: comId
        }
      }).then(res => {
        if (res.data.success) {
          this.dialogFormVisible = false
          this.getList()
        }
      })
    },
    getList() {
      this.listLoading = true
      this.$axios({
        method: 'post',
        url: '/companyApi/company',
        data: Qs.stringify(this.listQuery),
        params: {
          methodName: 'findAllCompany'
        }
      }).then(res => {
        if (res.data.success) {
          console.log(this.baseImageUrl)
          this.list = res.data.data.rows
          this.total = res.data.data.total
          setTimeout(() => {
            this.listLoading = false
          }, 1000)
        }
      })
    },
    handleFilter() {
      this.listQuery.page = 1
      this.getList()
    },
    handleModifyStatus(row, status) {
      this.$message({
        message: '操作Success',
        type: 'success'
      })
      row.status = status
    },
    sortChange(data) {
      const { prop, order } = data
      if (prop === 'id') {
        this.sortByID(order)
      }
    },
    sortByID(order) {
      if (order === 'ascending') {
        this.listQuery.sort = '+id'
      } else {
        this.listQuery.sort = '-id'
      }
      this.handleFilter()
    },
    resetTemp() {
      this.temp = {
        id: undefined,
        importance: 1,
        remark: '',
        timestamp: new Date(),
        title: '',
        status: 'published',
        type: ''
      }
    },
    handleUpdate(row) {
      this.temp = Object.assign({}, row) // copy obj
      this.temp.timestamp = new Date(this.temp.timestamp)
      this.dialogStatus = 'update'
      this.dialogFormVisible = true
      this.$nextTick(() => {
        this.$refs['dataForm'].clearValidate()
      })
    },
    getSortClass: function(key) {
      const sort = this.listQuery.sort
      return sort === `+${key}`
        ? 'ascending'
        : sort === `-${key}`
          ? 'descending'
          : ''
    }
  }
}
</script>
<style scoped>
  /deep/ .el-table th.gutter {
    display: table-cell !important;
  }

  /deep/ .el-table__header-wrapper, .el-table__footer-wrapper {
    border-bottom: 1px solid #dfe6ec;
  }

  /deep/ .el-table th {
    top: 1px;
  }

</style>

