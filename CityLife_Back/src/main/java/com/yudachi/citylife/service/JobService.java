package com.yudachi.citylife.service;

import com.yudachi.citylife.dao.*;
import com.yudachi.citylife.dto.JobDetail;
import com.yudachi.citylife.pojo.*;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JobService {
    public List<Integer> findJobAllId(){
        JobInfoDao jobInfoDao = new JobInfoDao();
        return jobInfoDao.findJobAllId();
    }

    public JobDetail findJobById(String id){
        JobDetail jobDetail = new JobDetail();
        jobDetail.setJobId(id);

        JobInfoDao jobInfoDao = new JobInfoDao();
        JobInfo db_jobInfo = jobInfoDao.findJobInfoById(Integer.valueOf(id));
        // 填充职位基本信息
        jobDetail = jobDetailPopulatedByJobInfo(jobDetail, db_jobInfo);

        // 填充职位描述
        JobDescribeDao jobDescribeDao = new JobDescribeDao();
        JobDescribe db_jobDescribe = jobDescribeDao.findJobDescribeById(Integer.valueOf(db_jobInfo.getDescribeId()));
        jobDetail = jobDetailPopulatedByJobDescribe(jobDetail, db_jobDescribe);

        // 填充公司基本信息
        CompanyDao companyDao = new CompanyDao();
        Company db_company = companyDao.findCompanyByIdAndAudit(Integer.valueOf(db_jobInfo.getCompanyId()), 1);
        jobDetail = jobDetailPopulatedByCompany(jobDetail, db_company);

        // 填充公司描述
        CompanyDescribeDao companyDescribeDao = new CompanyDescribeDao();
        CompanyDescribe db_companyDescribe = companyDescribeDao.findCompanyDescribeByCid(db_jobInfo.getCompanyId());
        jobDetail = jobDetailPopulatedByCompanyDescribe(jobDetail, db_companyDescribe);

        // 填充公司福利
        CompanyWelfareDao companyWelfareDao= new CompanyWelfareDao();
        CompanyWelfare db_companyWelfare = companyWelfareDao.findCompanyWelfareByCid(db_jobInfo.getCompanyId());
        jobDetail = jobDetailPopulatedByCompanyWelfare(jobDetail, db_companyWelfare);

        return jobDetail;
    }

    private JobDetail jobDetailPopulatedByCompanyWelfare(JobDetail jobDetail, CompanyWelfare db_companyWelfare) {
        String[] welfareArray = db_companyWelfare.getWelfare().split(",");
        List<String> welfareList = Arrays.stream(welfareArray).collect(Collectors.toList());
        jobDetail.setComWelfare(welfareList);
        return jobDetail;
    }

    private JobDetail jobDetailPopulatedByJobDescribe(JobDetail jobDetail, JobDescribe jobDescribe) {
        jobDetail.setJobDescribe(jobDescribe.getContent());
        return jobDetail;
    }

    private JobDetail jobDetailPopulatedByCompany(JobDetail jobDetail, Company company) {
        jobDetail.setComId(String.valueOf(company.getId()));
        jobDetail.setComName(company.getName());
        jobDetail.setComLr(company.getLegalRep());
        jobDetail.setComUsd(company.getUsd());
        jobDetail.setComEsTime(company.getEstablishTime());
        jobDetail.setComEmpType(company.getEmpType());
        jobDetail.setComStatus(company.getStatus());
        jobDetail.setComStage(company.getStage());
        jobDetail.setComScale(company.getScale());
        jobDetail.setComIndustry(company.getIndustry());
        jobDetail.setComWebSite(company.getWebSite());
        jobDetail.setComLogo(company.getLogo());
        jobDetail.setComAbbreviation(company.getAbbreviation());
        return jobDetail;
    }

    private JobDetail jobDetailPopulatedByJobInfo(JobDetail jobDetail, JobInfo jobInfo){
        jobDetail.setJobName(jobInfo.getName());
        jobDetail.setJobSalary(jobInfo.getSalary());
        jobDetail.setJobAddress(jobInfo.getAddress());
        jobDetail.setJobUpdateTime(jobInfo.getUpdateTime());
        jobDetail.setJobProvince(jobInfo.getProvince());
        jobDetail.setJobExp(jobInfo.getExp());
        jobDetail.setJobDegree(jobInfo.getDegree());
        jobDetail.setJobSkillTag(jobInfo.getSkillTag());
        return jobDetail;
    }

    private JobDetail jobDetailPopulatedByCompanyDescribe(JobDetail jobDetail, CompanyDescribe companyDescribe){
        jobDetail.setComDescribe(companyDescribe.getContent());
        return jobDetail;
    }

    public Integer insert(String address, String content, String jobId, Integer companyId) {
        JobInfo jobInfo = new JobInfo();

        // 填充选择的职位模板信息
        JobTemplateDao jobTemplateDao = new JobTemplateDao();
        JobTemplate jobTemplate = jobTemplateDao.findJobTemplateById(jobId);
        jobInfo = populatedJobInfoByJobTemplate(jobInfo, jobTemplate);

        // 填充选择的公司信息
        jobInfo.setCompanyId(companyId);

        // 填充工作地址
        jobInfo.setAddress(address);

        // 填充更新时间
        jobInfo.setUpdateTime(new Timestamp(System.currentTimeMillis()));

        // 插入职位描述
        JobDescribeDao jobDescribeDao = new JobDescribeDao();
        Integer describeID = jobDescribeDao.insert(content);
        if (describeID > 0){
            jobInfo.setDescribeId(describeID);
        }

        JobInfoDao jobInfoDao = new JobInfoDao();
        return jobInfoDao.insert(jobInfo);
    }

    private JobInfo populatedJobInfoByCompany(JobInfo jobInfo, Company company) {

        return null;
    }

    private JobInfo populatedJobInfoByJobTemplate(JobInfo jobInfo, JobTemplate jobTemplate) {
        jobInfo.setName(jobTemplate.getName());
        jobInfo.setSalary(jobTemplate.getSalary());
        jobInfo.setProvince(jobTemplate.getProvince());
        jobInfo.setExp(jobTemplate.getExp());
        jobInfo.setDegree(jobTemplate.getDegree());
        jobInfo.setSkillTag(jobTemplate.getSkillTag());
        jobInfo.setType(jobTemplate.getType());
        return jobInfo;
    }
}
