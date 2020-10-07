<template>
  <div class="app-container">
    <div style="margin-bottom: 15px;" class="filter-container">
      <el-date-picker
        v-model="listQuery.uploadTime"
        type="datetimerange"
        range-separator="至"
        start-placeholder="开始日期"
        end-placeholder="结束日期"
      />
      <el-select v-model="listQuery.mediaType" placeholder="图片类型" clearable class="filter-item" style="width: 130px">
        <el-option v-for="item in mediaTypeOptions" :key="item.key" :label="item.display_name" :value="item.key" />
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
    >
      <el-table-column label="ID" prop="id" align="center" width="100" />
      <el-table-column label="图片（可预览）" prop="url" align="center" width="460">
        <template slot-scope="scope">
          <el-image
            style="width: 100px; height: 100px"
            :src="baseImageUrl + scope.row.url"
            :preview-src-list="[baseImageUrl + scope.row.url]"
          />
        </template>
      </el-table-column>
      <el-table-column label="图片类型" prop="mediaType" align="center" width="180">
        <template slot-scope="{row}">
          {{ row.mediaType | mediaTypeFilter }}
        </template>
      </el-table-column>
      <el-table-column label="状态" class-name="status-col" width="100" align="center" prop="used">
        <template slot-scope="{row}">
          <el-tag :type="row.used | statusFilter">
            {{ row.used === 0 ? '不启用' : '启用' }}
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column label="上传时间" width="175px" align="center" prop="">
        <template slot-scope="scope">
          <span>{{ scope.row.uploadTime | dateTimeFilter }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" width="130px" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button v-if="scope.row.used === 0" type="primary" size="mini" @click="handleUpdate(scope.row)">
            启用
          </el-button>
          <el-button v-else type="primary" size="mini" @click="handleUpdate(scope.row)">
            停用
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total>0" :total="total" :page.sync="listQuery.page" :limit.sync="listQuery.limit" @pagination="getList" />

  </div>
</template>

<script>
import Pagination from '@/components/Pagination'
import { formatDate, timestampToTime } from '@/utils/dateUtil'
import Qs from 'qs'
const mediaTypeOptions = [
  { key: '0', display_name: '首页广告位左上图片' },
  { key: '1', display_name: '首页广告位右上图片' },
  { key: '2', display_name: '首页广告位左下图片' },
  { key: '3', display_name: '首页广告位右下图片' },
  { key: '4', display_name: '热招城市图片' }
]
const usedMap = {
  0: '不启用',
  1: '启用'
}
export default {
  name: 'MediaList',
  components: { Pagination },
  filters: {
    statusFilter(status) {
      const statusMap = {
        0: 'danger',
        1: 'success'
      }
      return statusMap[status]
    },
    UsedFilter(status) {
      return usedMap[status]
    },
    dateTimeFilter(time) {
      return formatDate(time)
    },
    mediaTypeFilter(mediaType) {
      let mediaName
      mediaTypeOptions.forEach(item => {
        if (mediaType === parseInt(item.key)) {
          mediaName = item.display_name
        }
      })
      return mediaName
    }
  },
  data() {
    return {
      baseImageUrl: this.baseImageUrl,
      mediaTypeOptions,
      tableKey: 0,
      list: [],
      total: 0,
      listLoading: true,
      listQuery: {
        page: 1,
        limit: 20,
        used: '',
        uploadTime: '',
        startTime: '',
        endTime: '',
        mediaType: '',
        methodName: 'findAllCompany'
      },
      showCompany: {},
      statusOptions: ['审核中', '审核成功', '审核失败'],
      showReviewer: false,
      dialogFormVisible: false,
      dialogStatus: '',
      dialogPvVisible: false,
      updateMedia: {
        id: '',
        used: '',
        uploadTime: ''
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    getList() {
      if (this.listQuery.uploadTime !== null) {
        this.listQuery.startTime = timestampToTime(this.listQuery.uploadTime[0])
        this.listQuery.endTime = timestampToTime(this.listQuery.uploadTime[1])
      } else {
        this.listQuery.startTime = ''
        this.listQuery.endTime = ''
      }
      this.listLoading = true
      this.$axios({
        method: 'post',
        url: '/mediaApi/media',
        data: Qs.stringify(this.listQuery),
        params: {
          methodName: 'findAllMedia'
        }
      }).then(res => {
        if (res.data.success) {
          this.list = res.data.data.rows
          this.total = res.data.data.total
          setTimeout(() => {
            this.listLoading = false
          }, 1000)
        }
      })
    },
    handleUpdate(row) {
      this.updateMedia.id = row.id
      this.updateMedia.used = row.used
      this.$axios({
        method: 'post',
        url: '/mediaApi/media',
        data: Qs.stringify(this.updateMedia),
        params: {
          methodName: 'updateMediaById'
        }
      }).then(res => {
        if (res.data.success) {
          this.getList()
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
    }
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
  /deep/ .el-date-editor--datetimerange.el-input, .el-date-editor--datetimerange.el-input__inner {
    width: 475px;
  }
</style>
