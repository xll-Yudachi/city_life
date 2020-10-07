package com.yudachi.citylife.util;

import cn.hutool.core.io.resource.ClassPathResource;
import org.apache.commons.io.IOUtils;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;

import java.io.FileOutputStream;
import java.util.Date;

public class FastDFSUtil {

    private TrackerClient trackerClient = null;
    private TrackerServer trackerServer = null;
    private StorageServer storageServer = null;
    private StorageClient1 storageClient = null;

    public FastDFSUtil() throws Exception {
        String config = new ClassPathResource("fdfs_client.conf").getFile().getAbsolutePath();
        ClientGlobal.init(config);
        trackerClient = new TrackerClient();
        trackerServer = trackerClient.getConnection();
        storageServer = null;
        storageClient = new StorageClient1(trackerServer, storageServer);
    }

    /**
     * 上传文件方法
     * <p>Title: uploadFile</p>
     * <p>Description: </p>
     * @param fileName 文件全路径
     * @param extName 文件扩展名，不包含（.）
     * @param metas 文件扩展信息
     * @return
     * @throws Exception
     */
    public String uploadFile(String fileName, String extName, NameValuePair[] metas) throws Exception {
        String result = storageClient.upload_file1(fileName, extName, metas);
        return result;
    }

    public String uploadFile(String fileName) throws Exception {
        return uploadFile(fileName, null, null);
    }

    public String uploadFile(String fileName, String extName) throws Exception {
        return uploadFile(fileName, extName, null);
    }

    /**
     * 上传文件方法
     * <p>Title: uploadFile</p>
     * <p>Description: </p>
     * @param fileContent 文件的内容，字节数组
     * @param extName 文件扩展名
     * @param metas 文件扩展信息
     * @return
     * @throws Exception
     */
    public String uploadFile(byte[] fileContent, String extName, NameValuePair[] metas) throws Exception {

        String result = storageClient.upload_file1(fileContent, extName, metas);
        return result;
    }

    public String uploadFile(byte[] fileContent) throws Exception {
        return uploadFile(fileContent, null, null);
    }

    public String uploadFile(byte[] fileContent, String extName) throws Exception {
        return uploadFile(fileContent, extName, null);
    }

    /**
     * 文件下载
     * @param filePath 文件地址
     * @param savePath 本地保存地址
     */
    public void download(String filePath,String savePath){
        try {
            byte[] bytes = storageClient.download_file1(filePath);
            IOUtils.write(bytes,new FileOutputStream(savePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件删除
     * @param filePath 文件的地址
     * @return
     */
    public Boolean deleteFile(String filePath){
        try {
            int i = storageClient.delete_file1(filePath);
            return i==0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取文件信息
     * @param filePath 文件的地址
     * @return
     */
    public String getFileInfo(String filePath){
        try {
            FileInfo fileInfo = storageClient.get_file_info1(filePath);
            String sourceIpAddr = fileInfo.getSourceIpAddr();//文件IP地址
            long fileSize = fileInfo.getFileSize();//文件大小
            Date createTimestamp = fileInfo.getCreateTimestamp();//文件创建时间
            long crc32 = fileInfo.getCrc32();//错误码
            return filePath;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}