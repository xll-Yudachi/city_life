package com.yudachi.citylife.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class JobDetail {
    private String comId;
    private String jobId;
    private String jobName;
    private String jobSalary;
    private String jobAddress;
    private String jobDescribe;
    private Date jobUpdateTime;
    private String jobProvince;
    private String jobExp;
    private String jobDegree;
    private String jobSkillTag;
    private String comName;
    /**
     * 公司法人
     */
    private String comLr;
    /**
     * 公司注册资金
     */
    private Float comUsd;
    /**
     * 公司创建时间
     */
    private Date comEsTime;
    /**
     * 公司类型
     */
    private Integer comEmpType;
    private Integer comStatus;
    private String comDescribe;
    /**
     * 公司阶段 (0 - 已上市)
     */
    private Integer comStage;

    /**
     * 公司规模
     */
    private String comScale;

    /**
     * 公司行业方向
     */
    private String comIndustry;

    /**
     * 公司网站首页
     */
    private String comWebSite;

    private String comLogo;

    /**
     * 公司简称
     */
    private String comAbbreviation;

    /**
     * 公司福利
     */
    private List<String> comWelfare;
}
