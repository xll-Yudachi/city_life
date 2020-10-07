package com.yudachi.citylife.servlet;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.yudachi.citylife.constant.TemplateMethod;
import com.yudachi.citylife.dao.JobTemplateDao;
import com.yudachi.citylife.pojo.JobTemplate;
import com.yudachi.citylife.res.ResponseResult;
import com.yudachi.citylife.util.PageResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/template")
public class TemplateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String methodName = request.getParameter("methodName");
        if (TemplateMethod.INSERT.equals(methodName)){
            JobTemplate jobTemplate = new JobTemplate();
            jobTemplate.setUid(Integer.valueOf(request.getParameter("uid")));
            jobTemplate.setName(request.getParameter("name"));
            jobTemplate.setSalary(request.getParameter("salary"));
            jobTemplate.setProvince(request.getParameter("province"));
            jobTemplate.setExp(request.getParameter("exp"));
            jobTemplate.setDegree(request.getParameter("degree"));
            jobTemplate.setSkillTag(request.getParameter("skill_tag"));
            jobTemplate.setType(request.getParameter("type"));
            jobTemplate.setUsed(1);
            JobTemplateDao jobTemplateDao = new JobTemplateDao();
            Integer count = jobTemplateDao.insert(jobTemplate);
            if (!ObjectUtil.isEmpty(count) && (count & 1 ) == 1){
                response.getWriter().append(JSON.toJSONString(new ResponseResult(true, 200, "添加成功")));
            }else{
                response.getWriter().append(JSON.toJSONString(new ResponseResult(false, 10000, "添加失败")));
            }
        }

        if (TemplateMethod.FIND_ALL_BY_QUERY.equals(methodName)){
            Integer page = Integer.valueOf(request.getParameter("page"));
            Integer limit = Integer.valueOf(request.getParameter("limit"));
            String name = request.getParameter("name");
            String uid = request.getParameter("uid");
            JobTemplateDao jobTemplateDao = new JobTemplateDao();
            List<JobTemplate> allByQuery = jobTemplateDao.findAllByQuery(name, uid);
            Integer total = allByQuery.size();
            List<JobTemplate> rows = allByQuery.subList((page - 1) * limit, Math.min(total, page * limit));
            PageResult<JobTemplate> pageResult = new PageResult<>();
            pageResult.setTotal(Long.valueOf(total));
            pageResult.setRows(rows);
            response.getWriter().append(JSON.toJSONString(new ResponseResult(true, 200, "查询成功", pageResult)));
        }

        if (TemplateMethod.FIND_JOBTEMPLATE_BY_ID.equals(methodName)){
            String id = request.getParameter("id");
            JobTemplateDao jobTemplateDao = new JobTemplateDao();
            JobTemplate jobTemplateById = jobTemplateDao.findJobTemplateById(id);
            if (!ObjectUtil.isEmpty(jobTemplateById)){
                response.getWriter().append(JSON.toJSONString(new ResponseResult(true, 200, "查询成功", jobTemplateById)));
            }else{
                response.getWriter().append(JSON.toJSONString(new ResponseResult(false, 10000, "查询失败")));
            }
        }

        if (TemplateMethod.UPDATE.equals(methodName)){
            JobTemplate jobTemplate = new JobTemplate();
            jobTemplate.setId(Integer.valueOf(request.getParameter("id")));
            jobTemplate.setName(request.getParameter("name"));
            jobTemplate.setSalary(request.getParameter("salary"));
            jobTemplate.setProvince(request.getParameter("province"));
            jobTemplate.setExp(request.getParameter("exp"));
            jobTemplate.setDegree(request.getParameter("degree"));
            jobTemplate.setSkillTag(request.getParameter("skill_tag"));
            JobTemplateDao jobTemplateDao = new JobTemplateDao();
            Integer count = jobTemplateDao.update(jobTemplate);
            if ((count & 1) == 1){
                response.getWriter().append(JSON.toJSONString(new ResponseResult(true, 200, "更新成功")));
            }else{
                response.getWriter().append(JSON.toJSONString(new ResponseResult(false, 10000, "更新失败")));
            }
        }

        if (TemplateMethod.DELETE.equals(methodName)){
            String id = request.getParameter("id");
            JobTemplateDao jobTemplateDao = new JobTemplateDao();
            Integer count = jobTemplateDao.delete(id);
            if ((count & 1) == 1){
                response.getWriter().append(JSON.toJSONString(new ResponseResult(true, 200, "删除成功")));
            }else{
                response.getWriter().append(JSON.toJSONString(new ResponseResult(false, 10000, "删除失败")));
            }
        }

        if (TemplateMethod.FIND_JOBTEMPLATE_BY_UID.equals(methodName)){
            String uid = request.getParameter("uid");
            JobTemplateDao jobTemplateDao = new JobTemplateDao();
            List<JobTemplate> jobTemplateList = jobTemplateDao.findJobTemplateByUid(uid);
            response.getWriter().append(JSON.toJSONString(new ResponseResult(true, 200, "查询成功", jobTemplateList)));
        }
    }
}
