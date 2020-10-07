package com.yudachi.citylife.servlet;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.yudachi.citylife.constant.CompanyMethod;
import com.yudachi.citylife.dao.*;
import com.yudachi.citylife.dto.CompanyDetail;
import com.yudachi.citylife.dto.CompanyListQuery;
import com.yudachi.citylife.dto.MoreCompanyInfo;
import com.yudachi.citylife.pojo.Company;
import com.yudachi.citylife.pojo.CompanyApply;
import com.yudachi.citylife.pojo.CompanyDescribe;
import com.yudachi.citylife.res.ResponseResult;
import com.yudachi.citylife.service.CompanyService;
import com.yudachi.citylife.util.PageResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/company")
public class CompanyServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String methodName = request.getParameter("methodName");
        if (CompanyMethod.FIND_ALL_COMPANY.equals(methodName)) {
            CompanyListQuery query = new CompanyListQuery();
            query.setPage(Integer.valueOf(request.getParameter("page")));
            query.setLimit(Integer.valueOf(request.getParameter("limit")));
            query.setAuditSubmitTime(request.getParameter("auditSubmitTime"));
            query.setAuditType(request.getParameter("auditType"));
            query.setComName(request.getParameter("comName"));
            query.setSort("+id".equals(request.getParameter("sort")) ? "asc" : "desc");
            List<CompanyDetail> allCompany = new CompanyService().findAllCompany(query);
            PageResult<CompanyDetail> pageResult = new PageResult<>();
            pageResult.setTotal(Long.valueOf(allCompany.size()));
            int start = (query.getPage() - 1) * query.getLimit();
            int end = start + query.getLimit();
            pageResult.setRows(allCompany.subList(start, Math.min(end, allCompany.size())));
            response.getWriter().append(JSON.toJSONString(new ResponseResult(true, 200, "查询成功", pageResult)));
        }

        if (CompanyMethod.FIND_COMPANY_DESCRIBE_BY_CID.equals(methodName)){
            CompanyDescribeDao companyDescribeDao = new CompanyDescribeDao();
            String cid = request.getParameter("cid");
            CompanyDescribe db_comdesc = companyDescribeDao.findCompanyDescribeByCid(Integer.parseInt(cid));
            if (db_comdesc!=null){
                response.getWriter().append(JSON.toJSONString(new ResponseResult(true, 200, "查询成功", db_comdesc)));
            }else{
                response.getWriter().append(JSON.toJSONString(new ResponseResult(false, 10000, "查询失败")));
            }
        }

        if (CompanyMethod.INSERT.equals(methodName)){
            CompanyService companyService = new CompanyService();
            try {
                Integer count = companyService.insert(request);
                if (!ObjectUtil.isEmpty(count)){
                    response.getWriter().append(JSON.toJSONString(new ResponseResult(true, 200, "添加成功", count)));
                }else{
                    response.getWriter().append(JSON.toJSONString(new ResponseResult(false, 10000, "添加失败", count)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (CompanyMethod.FIND_COMPANY_BY_ID.equals(methodName)){
            String id = request.getParameter("cid");
            CompanyDao companyDao = new CompanyDao();
            Company company = companyDao.findCompanyById(Integer.parseInt(id));
            if (!ObjectUtil.isEmpty(company)){
                response.getWriter().append(JSON.toJSONString(new ResponseResult(true, 200, "查询成功", company)));
            }else{
                response.getWriter().append(JSON.toJSONString(new ResponseResult(false, 10000, "查询失败")));
            }
        }

        if (CompanyMethod.UPDATE_BY_ID.equals(methodName)){
            String id = request.getParameter("id");
            CompanyService companyService = new CompanyService();
            try {
                Integer count = companyService.updateById(request, id);
                if (!ObjectUtil.isEmpty(count)){
                    response.getWriter().append(JSON.toJSONString(new ResponseResult(true, 200, "修改成功")));
                }else{
                    response.getWriter().append(JSON.toJSONString(new ResponseResult(false, 10000, "修改失败")));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        if (CompanyMethod.INSERT_WEL_AND_DES.equals(methodName)){
            String id = request.getParameter("comId");
            String comWelfare = request.getParameter("comWelfare");
            String comDescribe = request.getParameter("comDescribe");
            CompanyDescribeDao companyDescribeDao = new CompanyDescribeDao();
            Integer updateCount_desc = companyDescribeDao.insert(id, comDescribe);
            CompanyWelfareDao companyWelfareDao = new CompanyWelfareDao();
            Integer updateCount_wel = companyWelfareDao.insert(id, comWelfare);
            if ((!ObjectUtil.isEmpty(updateCount_desc)) && (! ObjectUtil.isEmpty(updateCount_wel))){
                MoreCompanyInfo moreCompanyInfo = new MoreCompanyInfo();
                moreCompanyInfo.setComDescribeId(updateCount_desc);
                moreCompanyInfo.setComWelfareId(updateCount_wel);
                response.getWriter().append(JSON.toJSONString(new ResponseResult(true, 200, "添加成功", moreCompanyInfo)));
            }else{
                response.getWriter().append(JSON.toJSONString(new ResponseResult(false, 10000, "添加失败")));
            }
        }

        if (CompanyMethod.UPDATE_WEL_AND_DES.equals(methodName)){
            String comWelfareId = request.getParameter("comWelfareId");
            String comDescribeId = request.getParameter("comDescribeId");
            String comDescribe = request.getParameter("comDescribe");
            String comWelfare = request.getParameter("comWelfare");
            CompanyWelfareDao companyWelfareDao = new CompanyWelfareDao();
            Integer update_wel = companyWelfareDao.updateById(comWelfareId, comWelfare);
            CompanyDescribeDao companyDescribeDao = new CompanyDescribeDao();
            Integer update_desc = companyDescribeDao.updateById(comDescribeId, comDescribe);
            if ((update_desc & update_wel) == 1){
                response.getWriter().append(JSON.toJSONString(new ResponseResult(true, 200, "修改成功")));
            }else{
                response.getWriter().append(JSON.toJSONString(new ResponseResult(false, 10000, "修改失败")));
            }
        }

        if (CompanyMethod.INSERT_COMPANYAPPLY.equals(methodName)){
            CompanyApply companyApply = new CompanyApply();
            companyApply.setUid(Integer.valueOf(request.getParameter("uid")));
            companyApply.setCid(Integer.valueOf(request.getParameter("cid")));
            companyApply.setApplyTime(new Date(System.currentTimeMillis()));
            CompanyApplyDao companyApplyDao = new CompanyApplyDao();
            Integer count = companyApplyDao.insertCompanyApply(companyApply);
            if ((count & 1) == 1){
                response.getWriter().append(JSON.toJSONString(new ResponseResult(true, 200, "添加成功")));
            }else{
                response.getWriter().append(JSON.toJSONString(new ResponseResult(false, 10000, "添加失败")));
            }
        }

        if (CompanyMethod.FIND_COMPANY_BY_UID.equals(methodName)){
            String uid = request.getParameter("uid");
            CompanyApplyDao companyApplyDao = new CompanyApplyDao();
            List<CompanyApply> companyApplyList = companyApplyDao.findCompanyApplyByUid(uid);
            CompanyDao companyDao = new CompanyDao();
            List<Company> res = new ArrayList<>();
            for (CompanyApply companyApply : companyApplyList) {
                Company company = companyDao.findCompanyById(companyApply.getCid());
                res.add(company);
            }
            response.getWriter().append(JSON.toJSONString(new ResponseResult(true, 200, "查找成功", res)));
        }

        if (CompanyMethod.FIND_ALL_EMPTYPE.equals(methodName)){
            EmpTypeDao empTypeDao = new EmpTypeDao();
            Map<Integer, String> res = new HashMap<>();
            empTypeDao.findAllEmpType().stream().forEach(item->{
                res.put(item.getId(), item.getEmpType());
            });
            response.getWriter().append(JSON.toJSONString(res));
        }

        if (CompanyMethod.FIND_ALL_COMSTAGE.equals(methodName)){
            ComStageDao comStageDao = new ComStageDao();
            Map<Integer, String> res = new HashMap<>();
            comStageDao.findAllComStage().stream().forEach(item->{
                res.put(item.getId(), item.getStage());
            });
            response.getWriter().append(JSON.toJSONString(res));
        }

        if (CompanyMethod.UPDATE_COMPANY.equals(methodName)){
            String comId = request.getParameter("comId");
            CompanyDao companyDao = new CompanyDao();
            Integer count = companyDao.updateAudit(comId);
            if (count > 0){
                response.getWriter().append(JSON.toJSONString(new ResponseResult(true, 200, "修改成功")));
            }else{
                response.getWriter().append(JSON.toJSONString(new ResponseResult(false, 10000, "修改失败")));
            }
        }

    }
}
