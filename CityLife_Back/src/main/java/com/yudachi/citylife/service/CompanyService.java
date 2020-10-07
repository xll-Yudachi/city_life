package com.yudachi.citylife.service;

import cn.hutool.core.util.ObjectUtil;
import com.yudachi.citylife.dao.CompanyDao;
import com.yudachi.citylife.dao.CompanyDescribeDao;
import com.yudachi.citylife.dao.CompanyWelfareDao;
import com.yudachi.citylife.dto.CompanyDetail;
import com.yudachi.citylife.dto.CompanyListQuery;
import com.yudachi.citylife.pojo.Company;
import com.yudachi.citylife.pojo.CompanyDescribe;
import com.yudachi.citylife.pojo.CompanyWelfare;
import com.yudachi.citylife.util.DateUtil;
import com.yudachi.citylife.util.FastDFSUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.*;

public class CompanyService {
    public List<CompanyDetail> findAllCompany(CompanyListQuery query) {
        List<CompanyDetail> res = new ArrayList<>();
        CompanyDao companyDao = new CompanyDao();
        List<Company> allCompany = companyDao.findAllCompany(query);
        if (allCompany == null) {
            return res;
        }

        allCompany.stream().forEach(company -> {
            // 填充公司基本信息
            CompanyDetail companyDetail = new CompanyDetail();
            companyDetail = copyFrom(company, companyDetail);
            // 填充公司描述
            CompanyDescribeDao companyDescribeDao  = new CompanyDescribeDao();
            CompanyDescribe describe = companyDescribeDao.findCompanyDescribeByCid(company.getId());
            companyDetail.setComDescribe(describe.getContent());
           // 填充公司福利
            CompanyWelfareDao companyWelfareDao = new CompanyWelfareDao();
            CompanyWelfare welfare = companyWelfareDao.findCompanyWelfareByCid(company.getId());
            companyDetail.setComWelfare(Arrays.asList(welfare.getWelfare().split(",").clone()));
           res.add(companyDetail);
        });
        return res;
    }

    public Integer insert(HttpServletRequest request) throws Exception {

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

        Company company = new Company();
        company.setName(params.get("comName"));
        company.setLegalRep(params.get("comLr"));
        company.setUsd(Float.valueOf(params.get("comUsd")));
        company.setEmpType(Integer.valueOf(params.get("comEmpType")));
        company.setEstablishTime(new Date(DateUtil.parseTime(params.get("comEsTime")).getTime()));
        company.setStatus(0);
        company.setStage(Integer.valueOf(params.get("comStage")));
        company.setScale(params.get("comScale"));
        company.setIndustry(params.get("comIndustry"));
        company.setWebSite(params.get("comWebSite"));
        company.setAbbreviation(params.get("comAbbreviation"));
        company.setAudit(0);
        FastDFSUtil fdfs = new FastDFSUtil();

        String uploadId = fdfs.uploadFile(imageList.get(0), "jpg");
        company.setLogo(uploadId);
        CompanyDao companyDao = new CompanyDao();
        Integer id = companyDao.insert(company);
        if (!ObjectUtil.isEmpty(id)){
            return id;
        }else{
            fdfs.deleteFile(uploadId);
            return null;
        }
    }

    private CompanyDetail copyFrom(Company src, CompanyDetail des){
        des.setComId(src.getId());
        des.setComName(src.getName());
        des.setComLr(src.getLegalRep());
        des.setComUsd(src.getUsd());
        des.setComEsTime(src.getEstablishTime());
        des.setComEmpType(src.getEmpType());
        des.setComStatus(src.getStatus());
        des.setComStage(src.getStage());
        des.setComScale(src.getScale());
        des.setComIndustry(src.getIndustry());
        des.setComWebSite(src.getWebSite());
        des.setComLogo(src.getLogo());
        des.setComAbbreviation(src.getAbbreviation());
        des.setComAudit(src.getAudit());
        return des;
    }

    public Integer updateById(HttpServletRequest request, String id) throws Exception {
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

        Company company = new Company();
        company.setName(params.get("comName"));
        company.setLegalRep(params.get("comLr"));
        company.setUsd(Float.valueOf(params.get("comUsd")));
        company.setEmpType(Integer.valueOf(params.get("comEmpType")));
        company.setEstablishTime(new Date(DateUtil.parseTime(params.get("comEsTime")).getTime()));
        company.setStatus(0);
        company.setStage(Integer.valueOf(params.get("comStage")));
        company.setScale(params.get("comScale"));
        company.setIndustry(params.get("comIndustry"));
        company.setWebSite(params.get("comWebSite"));
        company.setAbbreviation(params.get("comAbbreviation"));
        company.setAudit(0);
        String uploadId = "";
        String logoUrl = "";
        FastDFSUtil fdfs = new FastDFSUtil();
        if (imageList.size()  > 0){
            // 修改图片
            // 删除fdfs存储的图片 进行图片同步
            Company db_com = new CompanyDao().findCompanyById(Integer.valueOf(id));
            logoUrl = db_com.getLogo();
            // 上传新图片
            uploadId = fdfs.uploadFile(imageList.get(0), "jpg");
            company.setLogo(uploadId);
        }else{
            // 不修改图片
            company.setLogo("");
        }
        company.setId(Integer.parseInt(id));
        CompanyDao companyDao = new CompanyDao();
        Integer count = companyDao.updateById(company);
        if (count == 0){
            // 更新失败,删除新生成
            fdfs.deleteFile(uploadId);
        }else{
            fdfs.deleteFile(logoUrl);
        }
        return count;
    }
}
