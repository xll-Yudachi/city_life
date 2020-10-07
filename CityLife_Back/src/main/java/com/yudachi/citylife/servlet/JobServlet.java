package com.yudachi.citylife.servlet;

import com.alibaba.fastjson.JSON;
import com.yudachi.citylife.constant.JobMethod;
import com.yudachi.citylife.dao.JobInfoDao;
import com.yudachi.citylife.dao.PositionCategoryDao;
import com.yudachi.citylife.dto.JobDetail;
import com.yudachi.citylife.pojo.JobInfo;
import com.yudachi.citylife.res.ResponseResult;
import com.yudachi.citylife.service.JobService;
import com.yudachi.citylife.util.PageResult;
import com.yudachi.citylife.util.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.Jedis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/job")
public class JobServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String methodName = request.getParameter("methodName");
        if (JobMethod.FIND_BY_ID.equals(methodName)){
            String jobId = request.getParameter("jobId");
            JobDetail jobDetail = new JobService().findJobById(jobId);
            response.getWriter().append(JSON.toJSONString(new ResponseResult(true, 200, "查询成功", jobDetail)));
        }
        if (JobMethod.INSERT.equals(methodName)){
            String address = request.getParameter("address");
            String content = request.getParameter("content");
            String jobId = request.getParameter("jobId");
            Integer companyId = Integer.valueOf(request.getParameter("companyId"));
            JobService jobService = new JobService();
            Integer count = jobService.insert(address, content, jobId, companyId);
            if ((count & 1) == 1){
                response.getWriter().append(JSON.toJSONString(new ResponseResult(true, 200, "添加成功")));
            }else{
                response.getWriter().append(JSON.toJSONString(new ResponseResult(false, 10000, "添加失败")));
            }
        }
        if (JobMethod.FIND_ALL_REC_LIST.equals(methodName)){
            Jedis jedis = RedisUtil.getJedis();
            String top9Position = jedis.get("top9Position");
            if (!StringUtils.isEmpty(top9Position)){
                response.getWriter().append(top9Position);
            }else{
                PositionCategoryDao dao = new PositionCategoryDao();
                List<List<Integer>> list = dao.getTop9Position();
                List<List<JobDetail>> res = new ArrayList<>();
                JobService jobService = new JobService();
                for (int i = 0; i < list.size(); i++) {
                    List<JobDetail> tmp = new ArrayList<>();
                    for (int j = 0; j < list.get(i).size(); j++) {
                        JobInfoDao jobInfoDao = new JobInfoDao();
                        List<JobInfo> jobInfoList = jobInfoDao.findByType(String.valueOf(list.get(i).get(j)));
                        jobInfoList.stream().forEach(item->{
                            JobDetail jobDetail = jobService.findJobById(String.valueOf(item.getId()));
                            tmp.add(jobDetail);
                        });
                    }
                    res.add(tmp);
                }
                jedis.set("top9Position",JSON.toJSONString(res));
                response.getWriter().append(JSON.toJSONString(res));
            }
        }
        if (JobMethod.FIND_ALL_BY_PAGE.equals(methodName)){
            Integer page = Integer.valueOf(request.getParameter("page"));
            Integer size = Integer.valueOf(request.getParameter("size"));
            JobService jobService = new JobService();
            List<Integer> jobAllId = jobService.findJobAllId();
            List<JobDetail> res = new ArrayList<>();
            for (Integer jobId : jobAllId) {
                JobDetail jobDetail = jobService.findJobById(String.valueOf(jobId));
                res.add(jobDetail);
            }
            if (page == 0){
                page = 1;
            }
            List<JobDetail> rows = res.subList((page - 1) * size, Math.min(page * size, res.size()));
            PageResult<JobDetail> pageResult = new PageResult<>();
            pageResult.setTotal(Long.valueOf(res.size()));
            pageResult.setRows(rows);
            response.getWriter().append(JSON.toJSONString(new ResponseResult(true, 200, "查询成功", pageResult)));
        }
    }
}
