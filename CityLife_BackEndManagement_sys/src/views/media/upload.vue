<template>
  <div>
    <div>
      <h3 class="header">媒资上传</h3>
    </div>
    <el-select
      v-model="mediaType"
      placeholder="请选择媒资类型"
      style="margin-left: 35px;
    margin-bottom: 20px;"
    >
      <el-option
        v-for="item in mediaTypeList"
        :key="item.value"
        :label="item.label"
        :value="item.value"
      />
    </el-select>
    <el-upload
      ref="upload"
      accept=".jpg,.jpeg,.png,.gif,.bmp,.JPG,.JPEG,.GIF,.BMP"
      multiple
      action="/"
      style="margin-left: 35px;margin-bottom: 20px;"
      list-type="picture-card"
      :auto-upload="false"
      :http-request="uploadFile"
    >
      <div slot="file" slot-scope="{file}">
        <img
          class="el-upload-list__item-thumbnail"
          :src="file.url"
          alt=""
        >
        <span class="el-upload-list__item-actions">
          <span
            class="el-upload-list__item-preview"
            @click="handlePictureCardPreview(file)"
          >
            <i class="el-icon-zoom-in" />
          </span>
          <span
            v-if="!disabled"
            class="el-upload-list__item-delete"
            @click="handleDownload(file)"
          >
            <i class="el-icon-download" />
          </span>
          <span
            v-if="!disabled"
            class="el-upload-list__item-delete"
            @click="handleRemove(file)"
          >
            <i class="el-icon-delete" />
          </span>
        </span>
      </div>
      <i slot="default" class="el-icon-plus" />
    </el-upload>
    <div style="text-align: left;margin-left: 35px;margin-bottom: 15px">
      <el-button size="small" type="primary" @click="submitUpload">确认上传</el-button>
    </div>
    <el-dialog :visible.sync="dialogVisible">
      <img width="100%" :src="dialogImageUrl" alt="">
    </el-dialog>
  </div>
</template>

<script>
// import teacher from '@/api/admin/edu/teacher'
export default {
  // 组件
  components: {},
  // 定义数据
  data() {
    return {
      uploadForm: new FormData(),
      fileList: [], // upload多文件数组
      dialogImageUrl: '',
      dialogVisible: false,
      disabled: false,
      mediaTypeList: [{
        value: '0',
        label: '首页广告位左上图片'
      }, {
        value: '1',
        label: '首页广告位右上图片'
      }, {
        value: '2',
        label: '首页广告位左下图片'
      }, {
        value: '3',
        label: '首页广告位右下图片'
      }, {
        value: '4',
        label: '热招城市图片'
      }],
      mediaType: ''
    }
  },

  // 监听器
  watch: {},

  created() {

  },

  methods: {
    // 上传文件
    uploadFile(file) {
      this.uploadForm.append('files', file.file)
    },
    submitUpload(file) {
      const conf = {
        headers: {
          'Content-Type': 'multipart/form-data'
        }
      }
      this.uploadForm.append('mediaType', this.mediaType)
      this.$refs.upload.submit()
      this.$axios({
        method: 'post',
        url: '/uploadApi/uploadMedia',
        data: this.uploadForm,
        config: conf
      }).then(res => {
        if (res.data.success) {
          this.$message.success(res.data.message)
          this.$refs['upload'].clearFiles()
          this.mediaType = ''
        } else {
          this.$message.error(res.data.message)
        }
      })
    },
    handleRemove(file) {
      console.log(file + 're')
    },
    handlePictureCardPreview(file) {
      this.dialogImageUrl = file.url
      this.dialogVisible = true
      console.log(file.url + 'pre')
    },
    handleDownload(file) {
      console.log(file + 'dow')
    }
  }
}
</script>

<style scoped>
  .header{
    margin-left: 35px;
    margin-top: 30px;
  }
</style>
