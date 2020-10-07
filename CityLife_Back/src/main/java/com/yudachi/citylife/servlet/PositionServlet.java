package com.yudachi.citylife.servlet;

import com.alibaba.fastjson.JSON;
import com.yudachi.citylife.dao.PositionCategoryDao;
import com.yudachi.citylife.dto.PositionCategoryDto;
import com.yudachi.citylife.util.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.Jedis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/position")
public class PositionServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String methodName = (String) request.getParameter("methodName");
        if ("findAll".equals(methodName)){
            Jedis jedis = RedisUtil.getJedis();
            String position = jedis.get("position");
            if (!StringUtils.isEmpty(position)){
                response.getWriter().append(position);
            }else{
                PositionCategoryDao dao = new PositionCategoryDao();
                List<PositionCategoryDto> positionCategoryList = dao.findAll();
                jedis.set("position", JSON.toJSONString(positionCategoryList));
                response.getWriter().append(JSON.toJSONString(positionCategoryList));
            }
        }
    }
}
