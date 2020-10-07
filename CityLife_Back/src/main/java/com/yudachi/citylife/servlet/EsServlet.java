package com.yudachi.citylife.servlet;

import cn.hutool.db.Page;
import com.alibaba.fastjson.JSON;
import com.yudachi.citylife.constant.EsMethod;
import com.yudachi.citylife.dto.JobDetail;
import com.yudachi.citylife.res.ResponseResult;
import com.yudachi.citylife.util.ESUtil;
import com.yudachi.citylife.util.PageResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/elasticsearch")
public class EsServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String methodName = request.getParameter("methodName");
        if (EsMethod.HIGHLIGHT_SEARCH.equals(methodName)){
            String keyword = request.getParameter("keyword");
            Integer page = Integer.valueOf(request.getParameter("page"));
            Integer size = Integer.valueOf(request.getParameter("size"));
            Page searchPage = new Page(page, size);
            PageResult<JobDetail> pageResult = ESUtil.searchContent(searchPage, keyword);
            response.getWriter().append(JSON.toJSONString(new ResponseResult(true, 200, "查询成功", pageResult)));
        }
    }
}
