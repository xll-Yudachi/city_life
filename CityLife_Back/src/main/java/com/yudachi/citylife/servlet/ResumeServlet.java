package com.yudachi.citylife.servlet;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.yudachi.citylife.constant.ResumeMethod;
import com.yudachi.citylife.dao.*;
import com.yudachi.citylife.dto.ResumePostDto;
import com.yudachi.citylife.dto.StudyExp;
import com.yudachi.citylife.dto.WorkExp;
import com.yudachi.citylife.pojo.*;
import com.yudachi.citylife.res.ResponseResult;
import com.yudachi.citylife.service.UploadService;
import com.yudachi.citylife.util.DateUtil;
import com.yudachi.citylife.util.PageResult;
import org.apache.commons.fileupload.FileUploadException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/resume")
public class ResumeServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String methodName = request.getParameter("methodName");
        if (ResumeMethod.UPLOAD_PDF.equals(methodName)){
            try {
                Integer count = new UploadService().uploadPDF(request);
                if (count > 0) {
                    response.getWriter().append(JSON.toJSONString(new ResponseResult(true, 200, "上传成功")));
                } else {
                    response.getWriter().append(JSON.toJSONString(new ResponseResult(false, 10000, "上传失败")));
                }

            } catch (FileUploadException e) {
                e.printStackTrace();
            }
        }
        if (ResumeMethod.UPLOAD_AVATAR.equals(methodName)){
            try {
                Integer count = new UploadService().uploadAvatar(request);
                if (count > 0) {
                    response.getWriter().append(JSON.toJSONString(new ResponseResult(true, 200, "上传成功")));
                } else {
                    response.getWriter().append(JSON.toJSONString(new ResponseResult(false, 10000, "上传失败")));
                }

            } catch (FileUploadException e) {
                e.printStackTrace();
            }
        }
        if (ResumeMethod.FIND_RESUME_BY_UID.equals(methodName)){
            String uid = request.getParameter("uid");
            ResumeDao resumeDao = new ResumeDao();
            Resume resume = resumeDao.findResumeByUid(uid);
            if (!ObjectUtil.isEmpty(request)){
                response.getWriter().append(JSON.toJSONString(new ResponseResult(true, 200, "查询成功", resume)));
            }else{
                response.getWriter().append(JSON.toJSONString(new ResponseResult(false, 10000, "查询失败", null)));
            }
        }
        if (ResumeMethod.INSERT_PERSONINFO.equals(methodName)){
            Resume resume = new Resume();
            resume.setName(request.getParameter("name"));
            resume.setGuard(request.getParameter("guard"));
            resume.setSex(Integer.valueOf(request.getParameter("sex")));
            if ("".equals(request.getParameter("attach_time"))){
                resume.setAttachTime(null);
            }else{
                resume.setAttachTime(new Date(DateUtil.transferDateFormat(request.getParameter("attach_time")).getTime()));
            }

            if ("".equals(request.getParameter("birth"))){
                resume.setBirth(null);
            }else{
                resume.setBirth(new Date(DateUtil.transferDateFormat(request.getParameter("birth")).getTime()));
            }
            resume.setSalary(request.getParameter("salary"));
            resume.setWxId(request.getParameter("wxId"));
            resume.setPhone(request.getParameter("phone"));
            resume.setEmail(request.getParameter("email"));
            resume.setDirection(request.getParameter("direction"));
            resume.setPosition(request.getParameter("position"));
            resume.setUid(Integer.valueOf(request.getParameter("uid")));
            ResumeDao resumeDao = new ResumeDao();
            Integer count = resumeDao.insertResume(resume);
            if (count > 0){
                response.getWriter().append(JSON.toJSONString(new ResponseResult(true, 200, "添加个人信息成功")));
            }else{
                response.getWriter().append(JSON.toJSONString(new ResponseResult(false, 10000, "插入失败")));
            }
        }
        if (ResumeMethod.UPDATE_PERSONINFO.equals(methodName)){
            Resume resume = new Resume();
            resume.setName(request.getParameter("name"));
            resume.setGuard(request.getParameter("guard"));
            resume.setSex(Integer.valueOf(request.getParameter("sex")));
            if ("".equals(request.getParameter("attach_time"))){
                resume.setAttachTime(null);
            }else{
                resume.setAttachTime(new Date(DateUtil.transferDateFormat(request.getParameter("attach_time")).getTime()));
            }

            if ("".equals(request.getParameter("birth"))){
                resume.setBirth(null);
            }else{
                resume.setBirth(new Date(DateUtil.transferDateFormat(request.getParameter("birth")).getTime()));
            }
            resume.setSalary(request.getParameter("salary"));
            resume.setWxId(request.getParameter("wxId"));
            resume.setPhone(request.getParameter("phone"));
            resume.setEmail(request.getParameter("email"));
            resume.setDirection(request.getParameter("direction"));
            resume.setPosition(request.getParameter("position"));
            resume.setUid(Integer.valueOf(request.getParameter("uid")));
            ResumeDao resumeDao = new ResumeDao();
            Integer count = resumeDao.updateResume(resume);
            if (count > 0){
                response.getWriter().append(JSON.toJSONString(new ResponseResult(true, 200, "更新个人信息成功")));
            }else{
                response.getWriter().append(JSON.toJSONString(new ResponseResult(false, 10000, "更新个人信息失败")));
            }
        }
        if (ResumeMethod.INSERT_WORKEXP.equals(methodName)){
            WorkExp workExp = new WorkExp();
            workExp.setComName(request.getParameter("comName"));
            String workTime = "";
            if (!"".equals(request.getParameter("startTime"))){
                workTime += DateUtil.dealDateFormatNotHHMMSS(request.getParameter("startTime"));
            }else{
                workExp.setWorkTime("");
            }
            if (!"".equals(request.getParameter("endTime"))){
                workTime += "/" + DateUtil.dealDateFormatNotHHMMSS(request.getParameter("endTime"));
            }else{
                workExp.setWorkTime("");
            }
            workExp.setWorkTime(workTime);
            workExp.setJobType(request.getParameter("jobType"));
            workExp.setWorkContent(request.getParameter("workContent"));
            workExp.setWorkResult(request.getParameter("workResult"));
            String uid = request.getParameter("uid");
            String workExpStr = JSON.toJSONString(workExp);
            ResumeDao resumeDao = new ResumeDao();
            Resume resume = new Resume();
            resume.setWorkExp(workExpStr);
            resume.setUid(Integer.valueOf(uid));
            Integer count = resumeDao.insertResume(resume);
            if (count > 0){
                response.getWriter().append(JSON.toJSONString(new ResponseResult(true, 200, "操作成功")));
            }else{
                response.getWriter().append(JSON.toJSONString(new ResponseResult(false, 10000, "操作失败")));
            }
        }
        if (ResumeMethod.UPDATE_WORKEXP.equals(methodName)){
            WorkExp workExp = new WorkExp();
            workExp.setComName(request.getParameter("comName"));
            String workTime = "";
            if (!"".equals(request.getParameter("startTime"))){
                workTime += DateUtil.dealDateFormatNotHHMMSS(request.getParameter("startTime"));
            }else{
                workExp.setWorkTime("");
            }
            if (!"".equals(request.getParameter("endTime"))){
                workTime += "/" + DateUtil.dealDateFormatNotHHMMSS(request.getParameter("endTime"));
            }else{
                workExp.setWorkTime("");
            }
            workExp.setWorkTime(workTime);
            workExp.setJobType(request.getParameter("jobType"));
            workExp.setWorkContent(request.getParameter("workContent"));
            workExp.setWorkResult(request.getParameter("workResult"));
            String uid = request.getParameter("uid");
            String workExpStr = JSON.toJSONString(workExp);
            ResumeDao resumeDao = new ResumeDao();
            Resume resume = new Resume();
            resume.setWorkExp(workExpStr);
            resume.setUid(Integer.valueOf(uid));
            Integer count = resumeDao.updateResume(resume);
            if (count > 0){
                response.getWriter().append(JSON.toJSONString(new ResponseResult(true, 200, "操作成功")));
            }else{
                response.getWriter().append(JSON.toJSONString(new ResponseResult(false, 10000, "操作失败")));
            }
        }
        if (ResumeMethod.INSERT_STUDYEXP.equals(methodName)){
            StudyExp studyExp = new StudyExp();
            studyExp.setSchoolName(request.getParameter("schoolName"));
            String studyTime = "";
            if (!"".equals(request.getParameter("startYear"))){
                studyTime += DateUtil.dealDateFormatNotMMddHHmmss(request.getParameter("startTime"));
            }else{
                studyExp.setStudyTime("");
            }
            if (!"".equals(request.getParameter("endTime"))){
                studyTime += "-" + DateUtil.dealDateFormatNotMMddHHmmss(request.getParameter("endTime"));
            }else{
                studyExp.setStudyTime("");
            }
            studyExp.setStudyTime(studyTime);
            studyExp.setDegree(request.getParameter("degree"));
            studyExp.setMajor(request.getParameter("major"));
            studyExp.setStudyContent(request.getParameter("studyContent"));
            String uid = request.getParameter("uid");
            String studyExpStr = JSON.toJSONString(studyExp);
            ResumeDao resumeDao = new ResumeDao();
            Resume resume = new Resume();
            resume.setStudyExp(studyExpStr);
            resume.setUid(Integer.valueOf(uid));
            Integer count = resumeDao.insertResume(resume);
            if (count > 0){
                response.getWriter().append(JSON.toJSONString(new ResponseResult(true, 200, "操作成功")));
            }else{
                response.getWriter().append(JSON.toJSONString(new ResponseResult(false, 10000, "操作失败")));
            }
        }
        if (ResumeMethod.UPDATE_STUDYEXP.equals(methodName)){
            StudyExp studyExp = new StudyExp();
            studyExp.setSchoolName(request.getParameter("schoolName"));
            String studyTime = "";
            if (!"".equals(request.getParameter("startYear"))){
                studyTime += DateUtil.dealDateFormatNotMMddHHmmss(request.getParameter("startYear"));
            }else{
                studyExp.setStudyTime("");
            }
            if (!"".equals(request.getParameter("endYear"))){
                studyTime += "-" + DateUtil.dealDateFormatNotMMddHHmmss(request.getParameter("endYear"));
            }else{
                studyExp.setStudyTime("");
            }
            studyExp.setStudyTime(studyTime);
            studyExp.setDegree(request.getParameter("degree"));
            studyExp.setMajor(request.getParameter("major"));
            studyExp.setStudyContent(request.getParameter("studyContent"));
            String uid = request.getParameter("uid");
            String studyExpStr = JSON.toJSONString(studyExp);
            ResumeDao resumeDao = new ResumeDao();
            Resume resume = new Resume();
            resume.setStudyExp(studyExpStr);
            resume.setUid(Integer.valueOf(uid));
            Integer count = resumeDao.updateResume(resume);
            if (count > 0){
                response.getWriter().append(JSON.toJSONString(new ResponseResult(true, 200, "操作成功")));
            }else{
                response.getWriter().append(JSON.toJSONString(new ResponseResult(false, 10000, "操作失败")));
            }
        }
        if (ResumeMethod.INSERT_EVALUATION.equals(methodName)){
            String uid = request.getParameter("uid");
            ResumeDao resumeDao = new ResumeDao();
            Resume resume = new Resume();
            resume.setEvaluation(request.getParameter("evaluation"));
            resume.setUid(Integer.valueOf(uid));
            Integer count = resumeDao.insertResume(resume);
            if (count > 0){
                response.getWriter().append(JSON.toJSONString(new ResponseResult(true, 200, "操作成功")));
            }else{
                response.getWriter().append(JSON.toJSONString(new ResponseResult(false, 10000, "操作失败")));
            }
        }
        if (ResumeMethod.UPDATE_EVALUATION.equals(methodName)){
            String uid = request.getParameter("uid");
            ResumeDao resumeDao = new ResumeDao();
            Resume resume = new Resume();
            resume.setEvaluation(request.getParameter("evaluation"));
            resume.setUid(Integer.valueOf(uid));
            Integer count = resumeDao.updateResume(resume);
            if (count > 0){
                response.getWriter().append(JSON.toJSONString(new ResponseResult(true, 200, "操作成功")));
            }else{
                response.getWriter().append(JSON.toJSONString(new ResponseResult(false, 10000, "操作失败")));
            }
        }
        if (ResumeMethod.POST_RESUME.equals(methodName)){
            String uid = request.getParameter("uid");
            String jobId = request.getParameter("jobId");
            String companyId = request.getParameter("companyId");
            ResumeDao resumeDao = new ResumeDao();
            Integer count = resumeDao.insertResumePost(uid, jobId, companyId);
            if (count > 0){
                response.getWriter().append(JSON.toJSONString(new ResponseResult(true, 200, "操作成功")));
            }else{
                response.getWriter().append(JSON.toJSONString(new ResponseResult(false, 10000, "操作失败")));
            }
        }
        if (ResumeMethod.FIND_ALL_RESUME_POST.equals(methodName)){
            Integer page = Integer.valueOf(request.getParameter("page"));
            if (page == 0){
                page = 1;
            }
            Integer size = Integer.valueOf(request.getParameter("limit"));
            String jobName = request.getParameter("jobName");
            String comName = request.getParameter("comName");
            String uid = request.getParameter("uid");

            CompanyDao companyDao = new CompanyDao();
            CompanyApplyDao companyApplyDao = new CompanyApplyDao();
            List<CompanyApply> applies = companyApplyDao.findCompanyApplyByUid(uid);
            List<Integer> cidList = applies.stream().map(item -> item.getCid()).collect(Collectors.toList());
            List<Integer> auditList = companyDao.findAllCompanyByAudit().stream().map(item -> item.getId()).collect(Collectors.toList());
            List<Integer> adjustList = cidList.stream().filter(cid -> {
                return auditList.indexOf(cid) >= 0;
            }).collect(Collectors.toList());

            ResumePostDao resumePostDao = new ResumePostDao();
            List<ResumePost> allResumePost = resumePostDao.findAllResumePost().stream().filter(item->adjustList.indexOf(item.getCompanyId())>=0).collect(Collectors.toList());
            ResumeDao resumeDao = new ResumeDao();
            UserDao userDao = new UserDao();
            JobInfoDao jobInfoDao = new JobInfoDao();
            List<ResumePostDto> res = new ArrayList<>();
            allResumePost.forEach(item ->{
                ResumePostDto resumePostDto = new ResumePostDto();
                User user = userDao.findUserById(item.getUid());
                resumePostDto.setUsername(user.getUsername());
                resumePostDto.setPhone(user.getPhone());
                JobInfo jobInfo = jobInfoDao.findJobInfoById(item.getJobId());
                resumePostDto.setJobName(jobInfo.getName());
                Company company = companyDao.findCompanyById(jobInfo.getCompanyId());
                resumePostDto.setComName(company.getName());
                Resume resume = resumeDao.findResumeByUid(String.valueOf(user.getId()));
                resumePostDto.setUid(String.valueOf(user.getId()));
                res.add(resumePostDto);
            });
            PageResult<ResumePostDto> pageResult = new PageResult<>();
            pageResult.setTotal(Long.valueOf(res.size()));
            pageResult.setRows(res.subList((page - 1) * size, Math.min(page * size, res.size())));
            if (!ObjectUtil.isEmpty(res) && res.size() > 0){
                response.getWriter().append(JSON.toJSONString(new ResponseResult(true, 200, "查询成功", pageResult)));
            }else{
                response.getWriter().append(JSON.toJSONString(new ResponseResult(false, 10000, "查询失败")));
            }
        }
        if (ResumeMethod.FIND_ALL_RESUME.equals(methodName)){
            String uid = request.getParameter("uid");
            CompanyDao companyDao = new CompanyDao();
            CompanyApplyDao companyApplyDao = new CompanyApplyDao();
            List<CompanyApply> applies = companyApplyDao.findCompanyApplyByUid(uid);
            List<Integer> cidList = applies.stream().map(item -> item.getCid()).collect(Collectors.toList());
            List<Integer> auditList = companyDao.findAllCompanyByAudit().stream().map(item -> item.getId()).collect(Collectors.toList());
            List<Integer> adjustList = cidList.stream().filter(cid -> {
                return auditList.indexOf(cid) >= 0;
            }).collect(Collectors.toList());

            ResumePostDao resumePostDao = new ResumePostDao();
            List<Integer> hasExist = new ArrayList<>();
            List<Integer> uidList = resumePostDao.findAllResumePost().stream().filter(item->{
                if (hasExist.contains(item.getUid())){
                    return false;
                }else{
                    hasExist.add(item.getUid());
                }
                return adjustList.indexOf(item.getCompanyId())>=0;
            }).map(item-> item.getUid()).collect(Collectors.toList());
            ResumeDao resumeDao = new ResumeDao();
            List<Resume> res = new ArrayList<>();
            uidList.stream().forEach(item->{
                Resume resume = resumeDao.findResumeByUid(String.valueOf(item));
                res.add(resume);
            });
            res.sort(new Comparator<Resume>() {
                @Override
                public int compare(Resume o1, Resume o2) {
                    return (int) (o1.getBirth().getTime() - o2.getBirth().getTime());
                }
            });
            if (!ObjectUtil.isEmpty(res) && res.size() > 0){
                response.getWriter().append(JSON.toJSONString(new ResponseResult(true, 200, "查询成功", res)));
            }else{
                response.getWriter().append(JSON.toJSONString(new ResponseResult(false, 10000, "查询失败")));
            }
        }
    }
}
