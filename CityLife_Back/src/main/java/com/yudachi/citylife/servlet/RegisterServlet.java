package com.yudachi.citylife.servlet;

import com.alibaba.fastjson.JSON;
import com.yudachi.citylife.dao.UserDao;
import com.yudachi.citylife.pojo.User;
import com.yudachi.citylife.res.ResponseResult;
import com.yudachi.citylife.util.RedisUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String phone = request.getParameter("phone");
        String pwd = request.getParameter("pwd");
        String checkPhoneCode = request.getParameter("phoneCode");
        String rank = request.getParameter("rank");
        String phoneCode = RedisUtil.getJedis().get(phone);
        ResponseResult res = null;
        if (phoneCode != null && phoneCode.equals(checkPhoneCode)) {
            UserDao userDao = new UserDao();
            User db_user = userDao.findUserByPhone(phone);
            if (db_user != null){
                res = new ResponseResult(false, 10000, "手机号已被注册");
            }else{
                int count = userDao.insertUser(phone,  pwd , Integer.valueOf(rank));
                if (count > 0){
                    res = new ResponseResult(true, 200, "注册成功");
                }else{
                    res = new ResponseResult(true, 10000, "注册成功");
                }
            }
        } else {
            res = new ResponseResult(false, 10000, "注册失败");
        }
        response.getWriter().append(JSON.toJSONString(res));
    }
}
