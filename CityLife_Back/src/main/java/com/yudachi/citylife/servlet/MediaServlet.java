package com.yudachi.citylife.servlet;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.yudachi.citylife.constant.MediaMethod;
import com.yudachi.citylife.dao.MediaDao;
import com.yudachi.citylife.dao.MediaPDFDao;
import com.yudachi.citylife.dto.MediaListQuery;
import com.yudachi.citylife.pojo.Media;
import com.yudachi.citylife.pojo.MediaPDF;
import com.yudachi.citylife.res.ResponseResult;
import com.yudachi.citylife.service.MediaService;
import com.yudachi.citylife.util.PageResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/media")
public class MediaServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String methodName = request.getParameter("methodName");
        // 查询所有的媒资信息（含过滤查询）
        if (MediaMethod.FIND_ALL_Media.equals(methodName)) {
            MediaListQuery query = new MediaListQuery();
            query.setPage(Integer.valueOf(request.getParameter("page")));
            query.setLimit(Integer.valueOf(request.getParameter("limit")));
            query.setMediaType(request.getParameter("mediaType"));
            query.setUsed(request.getParameter("used"));
            query.setStartTime(request.getParameter("startTime"));
            query.setEndTime(request.getParameter("endTime"));
            List<Media> allMedia = new MediaService().findAllMedia(query);
            PageResult<Media> pageResult = new PageResult<>();
            pageResult.setTotal(Long.valueOf(allMedia.size()));
            int start = (query.getPage() - 1) * query.getLimit();
            int end = start + query.getLimit();
            pageResult.setRows(allMedia.subList(start, Math.min(end, allMedia.size())));
            response.getWriter().append(JSON.toJSONString(new ResponseResult(true, 200, "查询成功", pageResult)));
        }

        // 根据ID修改媒资信息
        if (MediaMethod.UPDATE_MEDIA_BY_ID.equals(methodName)){
            String id = request.getParameter("id");
            String used = request.getParameter("used");
            Media media = new Media();
            media.setId(Integer.valueOf(id));
            media.setUsed(Integer.valueOf(used));
            MediaDao mediaDao = new MediaDao();
            Integer count = mediaDao.updateMediaById(media);
            if (count > 0){
                response.getWriter().append(JSON.toJSONString(new ResponseResult(true, 200, "修改成功")));
            }else{
                response.getWriter().append(JSON.toJSONString(new ResponseResult(false, 10000, "修改失败")));
            }

        }

        if (MediaMethod.FIND_PDF.equals(methodName)){
            String uid = request.getParameter("uid");
            MediaPDFDao mediaPDFDao = new MediaPDFDao();
            List<MediaPDF> mediaPDFList = mediaPDFDao.findPDF(uid).stream().filter(item -> "pdf".equals(item.getUrl().split("\\.")[1])).collect(Collectors.toList());
            MediaPDF mediaPDF;
            if (!ObjectUtil.isEmpty(mediaPDFList) && mediaPDFList.size() > 0){
                mediaPDF = mediaPDFList.get(0);
                response.getWriter().append(JSON.toJSONString(new ResponseResult(true, 200, "查询成功", mediaPDF)));
            }else{
                response.getWriter().append(JSON.toJSONString(new ResponseResult(false, 10000, "查询失败", null)));
            }

        }
    }
}
