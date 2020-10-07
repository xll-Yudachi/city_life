package com.yudachi.citylife.servlet;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.yudachi.citylife.constant.CompanyWelfareMethod;
import com.yudachi.citylife.dao.CompanyWelfareDao;
import com.yudachi.citylife.pojo.CompanyWelfare;
import com.yudachi.citylife.res.ResponseResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/welfare")
public class CompanyWelfareServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String methodName = request.getParameter("methodName");
        if (CompanyWelfareMethod.FIND_BY_ID.equals(methodName)){
            String id = request.getParameter("id");
            CompanyWelfareDao companyWelfareDao  = new CompanyWelfareDao();
            CompanyWelfare companyWelfare = companyWelfareDao.findCompanyWelfareById(Integer.valueOf(id));
            if (!ObjectUtil.isEmpty(companyWelfare)){
                response.getWriter().append(JSON.toJSONString(new ResponseResult(true, 200, "查询成功", companyWelfare)));
            }else{
                response.getWriter().append(JSON.toJSONString(new ResponseResult(false, 10000, "查询失败")));
            }
        }
    }
}
