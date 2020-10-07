<template>
  <div class="app-container">
    <div style="margin-left: 25px;">
      <h3 style="margin-bottom: 30px;">创建职位模板</h3>
    </div>
    <el-form ref="form" :model="form" :rules="rules" label-width="120px" style="margin-left: 12px;">
      <el-form-item prop="name" label="职位名称">
        <el-input label-width="100px" v-model="form.name" style="width: 250px"></el-input>
      </el-form-item>
      <el-form-item prop="salary" label="职位薪资" label-width="120px">
        <el-input placeholder="5-10K" v-model="form.salary" style="width: 250px"></el-input>
      </el-form-item>
      <el-form-item prop="province" label="职位省份">
        <area-cascader :level="1" type="text" placeholder="请选择地区" v-model='form.province' :data="pcaa"
                       class="region"></area-cascader>
      </el-form-item>
      <el-form-item prop="exp" label="职位经历" label-width="120px">
        <el-select style="width: 250px" v-model="form.exp" placeholder="请选择工作经验">
          <el-option v-for="item in comExpList"
                     :label="item.label" :value="item.value"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item prop="degree" label="职位学历" label-width="120px">
        <el-select style="width: 250px" v-model="form.degree" placeholder="请选择学历">
          <el-option v-for="item in comDegreeList"
                     :label="item.label" :value="item.value"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item prop="type" label="职位类型" label-width="120px">
        <el-cascader
          v-model="form.type"
          :options="options"
          :props="{ expandTrigger: 'hover' }"
          @change="handleChange"></el-cascader>
      </el-form-item>
      <el-form-item prop="skill_tag" label="职位技能" label-width="120px">
        <el-tag
          :key="tag"
          v-for="tag in dynamicTags"
          closable
          :disable-transitions="false"
          @close="handleClose(tag)">
          {{tag}}
        </el-tag>
        <el-input
          class="input-new-tag"
          v-if="inputVisible"
          v-model="inputValue"
          ref="saveTagInput"
          size="small"
          @keyup.enter.native="handleInputConfirm"
          @blur="handleInputConfirm"
        >
        </el-input>
        <el-button v-else class="button-new-tag" size="small" @click="showInput">+ 添加技能标签</el-button>
      </el-form-item>
      <el-button style="margin-left: 45px" type="primary" @click="submitForm('form')">提交模板</el-button>
    </el-form>
  </div>
</template>

<script>
    import {pca, pcaa} from 'area-data';
    import Qs from 'qs'

    const comExpList = [
        {value: "在校生", label: "在校生"},
        {value: "应届生", label: "应届生"},
        {value: "1年以内", label: "1年以内"},
        {value: "1-3年", label: "1-3年"},
        {value: "3-5年", label: "3-5年"},
        {value: "5-10年", label: "5-10年"},
        {value: "10年以上", label: "10年以上"},
    ]
    const comDegreeList = [
        {value: "初中及以下", label: "初中及以下"},
        {value: "中专/中技", label: "中专/中技"},
        {value: "高中", label: "高中"},
        {value: "大专", label: "大专"},
        {value: "本科", label: "本科"},
        {value: "硕士", label: "硕士"},
        {value: "博士", label: "博士"},
    ]
    export default {
        //组件
        components: {},
        // 定义数据
        data() {
            var validSkillTag = (rule, value, callback) => {
                if (this.dynamicTags.length < 1) {
                    callback(new Error('请添加职业技能要求'));
                } else {
                    callback();
                }
            };
            var validProvince = (rule, value, callback) => {
                if (value.length < 1) {
                    callback(new Error('请选择省市区'));
                } else {
                    callback();
                }
            };
            var validSalary = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请输入职位薪资要求'));
                } else if (!(/^\d+\-\d+\K/.test(value))) {
                    callback(new Error('输入格式为num-numK'));
                } else {
                    callback();
                }
            }
            return {
                pca: pca,
                pcaa: pcaa,
                comExpList: comExpList,
                comDegreeList: comDegreeList,
                dynamicTags: [],
                inputVisible: false,
                inputValue: '',
                options:[],
                form: {
                    uid: '',
                    name: '',
                    salary: '',
                    province: '',
                    exp: '',
                    degree: '',
                    skill_tag: '',
                    type:''
                },
                rules: {
                    name: [
                        {required: true, message: '请输入职位名称', trigger: 'blur'},
                    ],
                    salary: [
                        {required: true, trigger: 'blur', validator: validSalary}
                    ],
                    province: [
                        {required: true, validator: validProvince}
                    ],
                    exp: [
                        {required: true, message: '请选择职业经验要求', trigger: 'change'}
                    ],
                    degree: [
                        {required: true, message: '请选择职业学历要求', trigger: 'change'}
                    ],
                    skill_tag: [
                        {required: true, validator: validSkillTag}
                    ],
                    type: [
                        {required: true, message: '请选择职位类型', trigger: 'change'}
                    ],
                },
            }
        },

        //监听器
        watch: {},

        created() {
          this.loadCategory()
        },
        inject: ['reload'],
        methods: {
            loadCategory(){
                this.$axios({
                    method:'get',
                    url:'/positionApi/position',
                    params:{
                        methodName: 'findAll'
                    }
                }).then(res=>{
                    let data = res.data
                    for (let i = 0; i < data.length; i++) {
                        let show = data[i].children
                        for (let j = 0; j < show.length; j++) {
                            this.options.push(show[j])
                        }
                    }
                })
            },
            handleChange(value) {
                console.log(value);
            },
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        this.form.uid = localStorage.getItem("uid")
                        this.form.province = this.form.province.join(" ")
                        this.form.skill_tag = this.dynamicTags.join(",")
                        console.log(this.form.type);
                        this.form.type = this.form.type[1]
                        this.$axios({
                            method: 'post',
                            url: '/jobApi/template',
                            data: Qs.stringify(this.form),
                            params: {
                                methodName: 'insert'
                            }
                        }).then(res => {
                            if (res.data.success) {
                                this.reload()
                            } else {
                                this.$message.error(res.data.message)
                                return false
                            }
                        })
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            handleClose(tag) {
                this.dynamicTags.splice(this.dynamicTags.indexOf(tag), 1);
            },
            showInput() {
                this.inputVisible = true;
                this.$nextTick(_ => {
                    this.$refs.saveTagInput.$refs.input.focus();
                });
            },
            handleInputConfirm() {
                let inputValue = this.inputValue;
                if (inputValue) {
                    this.dynamicTags.push(inputValue);
                }
                this.inputVisible = false;
                this.inputValue = '';
            }
        }
    }
</script>

<style scoped>
  .el-tag + .el-tag {
    margin-left: 10px;
  }

  .button-new-tag {
    margin-left: 10px;
    height: 32px;
    line-height: 30px;
    padding-top: 0;
    padding-bottom: 0;
  }

  .input-new-tag {
    width: 90px;
    margin-left: 10px;
    vertical-align: bottom;
  }

  .region .area-select {
    height: 40px;
    line-height: 25px
  }

  /deep/ .area-select {
    height: 40px;
  }

  /deep/ .area-select .area-selected-trigger {
    padding-left: 15px;
    padding-bottom: 0px;
    padding-top: 0px;
  }

  /deep/ .area-select.large {
    width: 250px;
  }
</style>
