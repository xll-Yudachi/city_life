package com.yudachi.citylife.servlet;

import com.yudachi.citylife.dao.UserDao;
import com.yudachi.citylife.util.CodeUtil;
import com.yudachi.citylife.util.RedisUtil;
import com.yudachi.citylife.util.SmsUtil;
import redis.clients.jedis.Jedis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sms")
public class SmsServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String phone = request.getParameter("phone");
        UserDao userDao = new UserDao();
        String code = CodeUtil.genCode_6();
        Integer waitTime = 5 * 60;
        Jedis jedis = RedisUtil.getJedis();
        jedis.set(phone, code);
        jedis.expire(phone, waitTime);
        SmsUtil.sendMessage(phone, code, waitTime);
    }
}
