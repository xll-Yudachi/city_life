package com.yudachi.citylife.servlet;

import com.alibaba.fastjson.JSON;
import com.yudachi.citylife.res.ResponseResult;
import com.yudachi.citylife.service.UploadService;
import org.apache.commons.fileupload.FileUploadException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/uploadMedia")
public class UploadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        try {
            Integer count = new UploadService().uploadImages(request);
            if (count > 0){
                response.getWriter().append(JSON.toJSONString(new ResponseResult(true, 200, "上传成功")));
            }else{
                response.getWriter().append(JSON.toJSONString(new ResponseResult(false, 10000, "上传失败")));
            }

        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }
}
