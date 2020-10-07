package com.yudachi.citylife.servlet;

import com.alibaba.fastjson.JSON;
import com.yudachi.citylife.dao.UserDao;
import com.yudachi.citylife.pojo.User;
import com.yudachi.citylife.res.ResponseResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String phone = request.getParameter("phone");
        String password = request.getParameter("pwd");
        String code = request.getParameter("phoneCode");
        String methodName = request.getParameter("methodName");
        /*String methodName = "password";*/
        if ("password".equals(methodName)){
            UserDao userDao = new UserDao();
            User db_user = userDao.findUserByPhone(phone);
            if (db_user == null){
                response.getWriter().append(JSON.toJSONString(new ResponseResult(false, 10000, "账户名或密码错误")));
            }else{
                if (db_user.getPwd().equals(password)){
                    response.getWriter().append(JSON.toJSONString(new ResponseResult(true, 200, "登录成功", db_user)));
                }else{
                    response.getWriter().append(JSON.toJSONString(new ResponseResult(false, 10000, "账户名或密码错误")));
                }
            }
        }else{

        }
    }
}
