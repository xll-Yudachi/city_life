package com.yudachi.citylife.servlet;

import com.alibaba.fastjson.JSON;
import com.yudachi.citylife.constant.Token;
import com.yudachi.citylife.dto.LoginRole;
import com.yudachi.citylife.res.ResponseResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/token")
public class TokenServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        LoginRole loginRole = new LoginRole();
        String token = request.getParameter("token");
        if (Token.USER_TOKEN.equals(token)){
            loginRole.setRole("user");
            loginRole.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
            loginRole.setIntroduction("I am an user");
            loginRole.setName("User");
            response.getWriter().append(JSON.toJSONString(new ResponseResult(true, 200, "获取token成功", JSON.toJSONString(loginRole))));
        }
    }
}
