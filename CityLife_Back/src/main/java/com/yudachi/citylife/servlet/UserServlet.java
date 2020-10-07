package com.yudachi.citylife.servlet;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.yudachi.citylife.constant.UserMethod;
import com.yudachi.citylife.dao.UserDao;
import com.yudachi.citylife.dto.LoginToken;
import com.yudachi.citylife.pojo.User;
import com.yudachi.citylife.res.ResponseResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String methodName = request.getParameter("methodName");
        if (UserMethod.FIND_BY_ID.equals(methodName)) {
            String id = request.getParameter("uid");
            UserDao userDao = new UserDao();
            User db_user = userDao.findUserById(Integer.valueOf(id));
            if (db_user != null) {
                response.getWriter().append(JSON.toJSONString(new ResponseResult(true, 200, "查询成功", db_user)));
            } else {
                response.getWriter().append(JSON.toJSONString(new ResponseResult(false, 10000, "查询失败")));
            }
        }
        if (UserMethod.LOGIN.equals(methodName)) {
            String name = request.getParameter("username");
            UserDao userDao = new UserDao();
            User db_user = userDao.findUserByPhone(name);
            if (!ObjectUtil.isEmpty(db_user)) {
                String pwd = request.getParameter("password");
                if (db_user.getPwd().equals(pwd)) {
                    LoginToken loginToken = new LoginToken();
                    loginToken.setToken("user-token");
                    loginToken.setUid(db_user.getId());
                    response.getWriter().append(JSON.toJSONString(new ResponseResult(true, 200, "登录成功", JSON.toJSONString(loginToken))));
                } else {
                    response.getWriter().append(JSON.toJSONString(new ResponseResult(false, 10000, "用户名或密码错误")));
                }
            } else {
                response.getWriter().append(JSON.toJSONString(new ResponseResult(false, 10000, "登录失败")));
            }
        }
        if (UserMethod.LOGOUT.equals(methodName)) {
            response.getWriter().append(JSON.toJSONString(new ResponseResult(true, 200, "退出成功")));
        }
    }
}
