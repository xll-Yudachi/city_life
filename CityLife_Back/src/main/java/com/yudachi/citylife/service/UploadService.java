package com.yudachi.citylife.service;

import com.yudachi.citylife.constant.ApplicationMap;
import com.yudachi.citylife.dao.MediaDao;
import com.yudachi.citylife.dao.MediaPDFDao;
import com.yudachi.citylife.dao.ResumeDao;
import com.yudachi.citylife.pojo.Media;
import com.yudachi.citylife.pojo.MediaPDF;
import com.yudachi.citylife.pojo.Resume;
import com.yudachi.citylife.util.FastDFSUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UploadService {

    public Integer uploadImages(HttpServletRequest request) throws FileUploadException, UnsupportedEncodingException {
        DiskFileItemFactory fac = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(fac);
        upload.setHeaderEncoding("UTF-8");
        List<FileItem> fileItemList = upload.parseRequest(request);
        Map<String, String> params = new HashMap<>();
        List<byte[]> imageList = new ArrayList<>();
        for(FileItem fileItem:fileItemList){
            if (fileItem.isFormField()) {
                params.put(fileItem.getFieldName(), fileItem.getString("utf-8"));
            }else{
                imageList.add(fileItem.get());
            }
        }
        // 使用params.get获取参数值 send_time就是key
        String mediaType = (String) params.get("mediaType");
        // 上传图片并记录地址
        List<String> imageUrlList = new ArrayList<>();
        try {
            FastDFSUtil fdfs = new FastDFSUtil();
            for (byte[] iamgeData : imageList) {
                String uploadId = fdfs.uploadFile(iamgeData, "jpg");
                imageUrlList.add(uploadId);
            }
            MediaDao mediaDao = new MediaDao();
            // 保存已经上传图片的url
            List<String> uploaded = new ArrayList<>();
            int count = 1;
            for (String url : imageUrlList) {
                uploaded.add(url);
                Media media = new Media();
                media.setMediaType(Integer.valueOf(mediaType));
                media.setUrl(url);
                media.setUsed(0);
                media.setUploadTime(new Timestamp(System.currentTimeMillis()));
                count &= mediaDao.insertMedia(media);
                // 出现插入数据库失败的情况
                if (count == 0){
                    // 删除已经上传的图片
                    for (String uploadedUrl : uploaded) {
                        fdfs.deleteFile(uploadedUrl);
                    }
                }
            }
            return count;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Integer uploadPDF(HttpServletRequest request) throws FileUploadException, UnsupportedEncodingException {
        DiskFileItemFactory fac = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(fac);
        upload.setHeaderEncoding("UTF-8");
        List<FileItem> fileItemList = upload.parseRequest(request);
        Map<String, String> params = new HashMap<>();
        List<byte[]> imageList = new ArrayList<>();
        String mediaType = "";
        for(FileItem fileItem:fileItemList){
            if (!fileItem.isFormField()) {
                mediaType = ApplicationMap.getByMediaType(fileItem.getContentType());
                imageList.add(fileItem.get());
            }
        }
        String uid = request.getParameter("uid");
        // 上传PDF并记录地址
        List<String> pdfUrlList = new ArrayList<>();
        try {
            FastDFSUtil fdfs = new FastDFSUtil();
            for (byte[] PDFData : imageList) {
                String uploadId = fdfs.uploadFile(PDFData, mediaType);
                pdfUrlList.add(uploadId);
            }
            MediaPDFDao mediaPDFDao = new MediaPDFDao();
            // 保存已经上传PDF的url
            List<String> uploaded = new ArrayList<>();
            int count = 1;
            for (String url : pdfUrlList) {
                uploaded.add(url);
                MediaPDF mediaPDF = new MediaPDF();
                mediaPDF.setUrl(url);
                mediaPDF.setUid(Integer.valueOf(uid));
                count &= mediaPDFDao.insertMediaPDF(mediaPDF);
                // 出现插入数据库失败的情况
                if (count == 0){
                    // 删除已经上传的PDF
                    for (String uploadedUrl : uploaded) {
                        fdfs.deleteFile(uploadedUrl);
                    }
                }
            }
            return count;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Integer uploadAvatar(HttpServletRequest request) throws FileUploadException {
        DiskFileItemFactory fac = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(fac);
        upload.setHeaderEncoding("UTF-8");
        List<FileItem> fileItemList = upload.parseRequest(request);
        List<byte[]> avatarList = new ArrayList<>();
        for(FileItem fileItem:fileItemList){
            if (!fileItem.isFormField()) {
                avatarList.add(fileItem.get());
            }
        }
        String uid = request.getParameter("uid");
        // 上传头像并记录地址
        List<String> avatarUrlList = new ArrayList<>();
        try {
            FastDFSUtil fdfs = new FastDFSUtil();
            for (byte[] avatarData : avatarList) {
                String uploadId = fdfs.uploadFile(avatarData, "jpg");
                avatarUrlList.add(uploadId);
            }
            ResumeDao resumeDao = new ResumeDao();
            // 如果简历已经存在，则进行头像更新
            Resume db_resume = resumeDao.findResumeByUid(uid);
            if (db_resume != null){
                if (!StringUtils.isEmpty(db_resume.getAvatar())){
                    // 如果简历已存在，且头像已存在 则要先删除服务器的头像图片
                    fdfs.deleteFile(db_resume.getAvatar());
                }
                return resumeDao.updateAvatar(avatarUrlList.get(0), uid);
            }else{
                // 保存已经上传Avatar的url
                List<String> uploaded = new ArrayList<>();
                int count = 1;
                for (String url : avatarUrlList) {
                    uploaded.add(url);
                    Resume resume = new Resume();
                    resume.setAvatar(url);
                    resume.setUid(Integer.valueOf(uid));
                    count &= resumeDao.insertAvatar(resume);
                    // 出现插入数据库失败的情况
                    if (count == 0){
                        // 删除已经上传的头像
                        for (String uploadedUrl : uploaded) {
                            fdfs.deleteFile(uploadedUrl);
                        }
                    }
                }
                return count;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
