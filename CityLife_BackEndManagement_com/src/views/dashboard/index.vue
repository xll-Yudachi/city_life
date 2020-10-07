<template>
  <div class="dashboard-container">
    <div id="myChart" style="width: 400px;height: 400px;display: inline-block"></div>
    <div id="myChart_2" style="width: 400px;height: 400px;display: inline-block; margin-left: 150px"></div>
    <div id="myChart_3" style="width: 400px;height: 400px;display: inline-block;margin-top: 40px"></div>
    <div id="myChart_4" style="width: 400px;height: 400px;display: inline-block; margin-left: 150px"></div>
  </div>
</template>

<script>
    import {mapGetters} from 'vuex'

    export default {
        name: 'Dashboard',
        data() {
            return {
                resumeList: [],
                provinceMap: {},
                provinceDataList: [],
                ageMap: {},
                ageDataList: [],
                sexMap: {},
                sexDataList: [],
                postDateMap: {},
                postDateDataList: []
            }
        },
        created() {
            this.findAllResume()
        },
        computed: {},
        mounted() {},
        methods: {
            getProvinceData() {
                for (let i = 0; i < Object.keys(this.provinceMap).length; i++) {
                    this.provinceDataList.push(
                        {
                            value: this.provinceMap[Object.keys(this.provinceMap)[i]],
                            name: Object.keys(this.provinceMap)[i]
                        }
                    )
                }
            },
            getSexData() {
                for (let i = 0; i < Object.keys(this.sexMap).length; i++) {
                    this.sexDataList.push(
                        {
                            value: this.sexMap[Object.keys(this.sexMap)[i]],
                            name: Object.keys(this.sexMap)[i]
                        }
                    )
                }
            },
            getAgeData() {
                for (let i = 0; i < Object.keys(this.ageMap).length; i++) {
                    this.ageDataList.push(
                        {
                            value: this.ageMap[Object.keys(this.ageMap)[i]],
                            name: Object.keys(this.ageMap)[i] == 0
                        }
                    )
                }
            },
            getPostDateData() {
                for (let i = 0; i < Object.keys(this.postDateMap).sort().length; i++) {
                    this.postDateDataList.push(
                        {
                            value: this.postDateMap[Object.keys(this.postDateMap)[i]],
                            name: Object.keys(this.postDateMap)[i] == 0
                        }
                    )
                }
            },
            drawProvince() {
                // 基于准备好的dom，初始化echarts实例
                let myChart = this.$echarts.init(document.getElementById('myChart'))
                // 绘制图表
                myChart.setOption({
                    title: {text: '求职者省份统计'},
                    tooltip: {
                        trigger: 'item',
                        formatter: '省份<br/>{b} : {c} ({d}%)'
                    },
                    legend: {
                        bottom: 10,
                        left: 'center',
                        data: Object.keys(this.provinceMap)
                    },
                    series: [
                        {
                            type: 'pie',
                            radius: '60%',
                            center: ['50%', '50%'],
                            selectedMode: 'single',
                            data: this.provinceDataList
                        }
                    ]
                });
            },
            drawAge() {
                // 基于准备好的dom，初始化echarts实例
                let myChart = this.$echarts.init(document.getElementById('myChart_2'))
                // 绘制图表
                myChart.setOption({
                    title: {text: '求职者年龄'},
                    xAxis: {
                        name: '年龄',
                        type: 'category',
                        data: Object.keys(this.ageMap)
                    },
                    yAxis: {
                        name: '人数',
                        type: 'value',
                        scale: true,
                        minInterval: 1, //设置成1保证坐标轴分割刻度显示成整数。
                    },
                    series: [{
                        data: this.ageDataList,
                        type: 'bar'
                    }]
                });
            },
            drawSex() {
                // 基于准备好的dom，初始化echarts实例
                let myChart = this.$echarts.init(document.getElementById('myChart_3'))
                // 绘制图表
                myChart.setOption({
                    title: {text: '求职者性别统计'},
                    tooltip: {
                        trigger: 'item',
                        formatter: '性别<br/>{b} : {c} ({d}%)'
                    },
                    legend: {
                        bottom: 2,
                        left: 'center',
                        data: Object.keys(this.sexMap)
                    },
                    series: [
                        {
                            type: 'pie',
                            radius: '60%',
                            center: ['50%', '50%'],
                            selectedMode: 'single',
                            data: this.sexDataList
                        }
                    ]
                });
            },
            drawDate() {
                // 基于准备好的dom，初始化echarts实例
                let myChart = this.$echarts.init(document.getElementById('myChart_4'))
                // 绘制图表
                myChart.setOption({
                    title: {text: '简历投递时间'},
                    xAxis: {
                        name: '时间',
                        type: 'category',
                        data: Object.keys(this.postDateMap)
                    },
                    yAxis: {
                        name: '人数',
                        type: 'value',
                        scale: true,
                        minInterval: 1, //设置成1保证坐标轴分割刻度显示成整数。
                    },
                    series: [{
                        data: this.postDateDataList,
                        type: 'line'
                    }]
                });
            },
            findAllResume() {
                this.$axios({
                    method: 'get',
                    url: '/resumeApi/resume',
                    params: {
                        methodName: 'findAllResume',
                        uid: localStorage.getItem("uid")
                    }
                }).then(res => {
                    if (res.data.success) {
                        this.resumeList = res.data.data
                        for (let i = 0; i < this.resumeList.length; i++) {
                            if (this.provinceMap[this.resumeList[i].position.split(" ")[0]]) {
                                this.provinceMap[this.resumeList[i].position.split(" ")[0]]++;
                            } else {
                                this.provinceMap[this.resumeList[i].position.split(" ")[0]] = 1;
                            }

                            if (this.ageMap[this.jsGetAge(this.resumeList[i].birth)]) {
                                this.ageMap[this.jsGetAge(this.resumeList[i].birth)]++;
                            } else {
                                this.ageMap[this.jsGetAge(this.resumeList[i].birth)] = 1;
                            }

                            if (this.sexMap[this.resumeList[i].sex === 0 ? '女': '男']) {
                                this.sexMap[this.resumeList[i].sex === 0 ? '女': '男']++;
                            } else {
                                this.sexMap[this.resumeList[i].sex === 0 ? '女': '男'] = 1;
                            }

                            if (this.postDateMap[this.resumeList[i].attachTime.substring(this.resumeList[i].attachTime.indexOf("-")+1)]) {
                                this.postDateMap[this.resumeList[i].attachTime.substring(this.resumeList[i].attachTime.indexOf("-")+1)]++;
                            } else {
                                this.postDateMap[this.resumeList[i].attachTime.substring(this.resumeList[i].attachTime.indexOf("-") + 1)] = 1;
                            }
                        }
                        this.getProvinceData()
                        this.getAgeData()
                        this.getSexData()
                        this.getPostDateData()
                        this.drawProvince()
                        this.drawAge()
                        this.drawSex()
                        this.drawDate()
                    }
                })
            },
            jsGetAge(strBirthday) {
                var returnAge;
                var strBirthdayArr = strBirthday.split("-");
                var birthYear = strBirthdayArr[0];
                var birthMonth = strBirthdayArr[1];
                var birthDay = strBirthdayArr[2];
                let d = new Date();
                var nowYear = d.getFullYear();
                var nowMonth = d.getMonth() + 1;
                var nowDay = d.getDate();

                if (nowYear == birthYear) {
                    returnAge = 0;//同年 则为0岁
                } else {
                    var ageDiff = nowYear - birthYear; //年之差
                    if (ageDiff > 0) {
                        if (nowMonth == birthMonth) {
                            var dayDiff = nowDay - birthDay;//日之差
                            if (dayDiff < 0) {
                                returnAge = ageDiff - 1;
                            } else {
                                returnAge = ageDiff;
                            }
                        } else {
                            var monthDiff = nowMonth - birthMonth;//月之差
                            if (monthDiff < 0) {
                                returnAge = ageDiff - 1;
                            } else {
                                returnAge = ageDiff;
                            }
                        }
                    } else {
                        returnAge = -1;//返回-1 表示出生日期输入错误 晚于今天
                    }
                }
                return returnAge;//返回周岁年龄
            }
        }
    }
</script>

<style lang="scss" scoped>
  .dashboard {
    &-container {
      margin: 30px;
    }

    &-text {
      font-size: 30px;
      line-height: 46px;
    }
  }
</style>
