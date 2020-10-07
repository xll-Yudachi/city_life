package com.yudachi.citylife.servlet;

import com.alibaba.fastjson.JSON;
import com.yudachi.citylife.constant.IndustryMethod;
import com.yudachi.citylife.dao.IndustryDao;
import com.yudachi.citylife.pojo.Industry;
import com.yudachi.citylife.res.ResponseResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/industry")
public class IndustryServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String methodName = request.getParameter("methodName");
        if (IndustryMethod.FIND_ALL_INDUSTRY.equals(methodName)){
            IndustryDao industryDao = new IndustryDao();
            List<Industry> allIndustry = industryDao.findAllIndustry();
            response.getWriter().append(JSON.toJSONString(new ResponseResult(true, 200, "查询成功", allIndustry)));
        }
    }
}
