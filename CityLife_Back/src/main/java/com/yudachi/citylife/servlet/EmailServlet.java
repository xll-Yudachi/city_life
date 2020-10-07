package com.yudachi.citylife.servlet;

import com.alibaba.fastjson.JSON;
import com.yudachi.citylife.constant.EmailMethod;
import com.yudachi.citylife.dao.UserDao;
import com.yudachi.citylife.dto.EmailDto;
import com.yudachi.citylife.pojo.User;
import com.yudachi.citylife.res.ResponseResult;
import com.yudachi.citylife.util.EmailUtil;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.GeneralSecurityException;

@WebServlet("/email")
public class EmailServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String methodName = request.getParameter("methodName");
        if (EmailMethod.SEND_EMAIL.equals(methodName)){
            String uid = request.getParameter("uid");
            UserDao userDao = new UserDao();
            User user = userDao.findUserById(Integer.valueOf(uid));
            EmailDto emailDto = new EmailDto();
            emailDto.setTitle(request.getParameter("title"));
            emailDto.setContent(request.getParameter("content"));
            emailDto.setEmail(user.getEmail());
            try {
                EmailUtil.sendEmail(emailDto);
                response.getWriter().append(JSON.toJSONString(new ResponseResult(true, 200, "发送成功")));
            } catch (GeneralSecurityException e) {
                e.printStackTrace();
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
    }
}
