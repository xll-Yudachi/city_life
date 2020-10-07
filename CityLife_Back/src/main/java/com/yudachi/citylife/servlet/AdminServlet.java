package com.yudachi.citylife.servlet;

import com.alibaba.fastjson.JSON;
import com.yudachi.citylife.constant.AdminMethod;
import com.yudachi.citylife.dao.AdminDao;
import com.yudachi.citylife.pojo.Admin;
import com.yudachi.citylife.res.ResponseResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
         String methodName = request.getParameter("methodName");
        if (AdminMethod.LOGIN.equals(methodName)){
            String name = request.getParameter("username");
            AdminDao adminDao = new AdminDao();
            Admin db_admin = adminDao.findAdminByName(name);
            if (db_admin!=null){
                String pwd = request.getParameter("password");
                if (db_admin.getPwd().equals(pwd)){
                    response.getWriter().append(JSON.toJSONString(new ResponseResult(true, 200, "登录成功")));
                }else{
                    response.getWriter().append(JSON.toJSONString(new ResponseResult(false, 10000, "用户名或密码错误")));
                }
            }else{
                response.getWriter().append(JSON.toJSONString(new ResponseResult(false, 10000, "登录失败")));
            }
        }
    }
}
