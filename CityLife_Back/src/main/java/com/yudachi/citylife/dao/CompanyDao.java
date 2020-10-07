package com.yudachi.citylife.dao;

import com.mysql.jdbc.Statement;
import com.yudachi.citylife.dto.CompanyListQuery;
import com.yudachi.citylife.pojo.Company;
import com.yudachi.citylife.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyDao {
    private static Connection connection = DBUtil.getConnection();

    public List<Company> findAllCompany(CompanyListQuery query) {
        String sql = "select * from t_company where IF(?<>'',name like '%" + query.getComName() + "%','1:1') and IF(?<>'',audit = ?,'1:1') order by id "+ query.getSort();
        List<Company> candiList = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, query.getComName());
            ps.setString(2, query.getAuditType());
            ps.setString(3, query.getAuditType());
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Company company = new Company();
                company.setId(resultSet.getInt(1));
                company.setName(resultSet.getString(2));
                company.setLegalRep(resultSet.getString(3));
                company.setUsd(resultSet.getFloat(4));
                company.setEstablishTime(resultSet.getDate(5));
                company.setEmpType(resultSet.getInt(6));
                company.setStatus(resultSet.getInt(7));
                company.setStage(resultSet.getInt(8));
                company.setScale(resultSet.getString(9));
                company.setIndustry(resultSet.getString(10));
                company.setWebSite(resultSet.getString(11));
                company.setLogo(resultSet.getString(12));
                company.setAbbreviation(resultSet.getString(13));
                company.setAudit(resultSet.getInt(14));
                candiList.add(company);
            }
            if (!candiList.isEmpty()) {
                return candiList;
            }
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public Company findCompanyById(Integer id) {
        String sql = "select * from t_company where id = ? and audit = 1";
        List<Company> candiList = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Company company = new Company();
                company.setId(resultSet.getInt(1));
                company.setName(resultSet.getString(2));
                company.setLegalRep(resultSet.getString(3));
                company.setUsd(resultSet.getFloat(4));
                company.setEstablishTime(resultSet.getDate(5));
                company.setEmpType(resultSet.getInt(6));
                company.setStatus(resultSet.getInt(7));
                company.setStage(resultSet.getInt(8));
                company.setScale(resultSet.getString(9));
                company.setIndustry(resultSet.getString(10));
                company.setWebSite(resultSet.getString(11));
                company.setLogo(resultSet.getString(12));
                company.setAbbreviation(resultSet.getString(13));
                candiList.add(company);
            }
            if (!candiList.isEmpty()) {
                return candiList.get(0);
            }
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public Company findCompanyByIdAndAudit(Integer id, Integer audit) {
        String sql = "select * from t_company where id = ? and audit = ?";
        List<Company> candiList = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, audit);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Company company = new Company();
                company.setId(resultSet.getInt(1));
                company.setName(resultSet.getString(2));
                company.setLegalRep(resultSet.getString(3));
                company.setUsd(resultSet.getFloat(4));
                company.setEstablishTime(resultSet.getDate(5));
                company.setEmpType(resultSet.getInt(6));
                company.setStatus(resultSet.getInt(7));
                company.setStage(resultSet.getInt(8));
                company.setScale(resultSet.getString(9));
                company.setIndustry(resultSet.getString(10));
                company.setWebSite(resultSet.getString(11));
                company.setLogo(resultSet.getString(12));
                company.setAbbreviation(resultSet.getString(13));
                candiList.add(company);
            }
            if (!candiList.isEmpty()) {
                return candiList.get(0);
            }
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public Company findCompanyByAudit(Integer audit) {
        String sql = "select * from t_company where audit = ?";
        List<Company> candiList = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, audit);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Company company = new Company();
                company.setId(resultSet.getInt(1));
                company.setName(resultSet.getString(2));
                company.setLegalRep(resultSet.getString(3));
                company.setUsd(resultSet.getFloat(4));
                company.setEstablishTime(resultSet.getDate(5));
                company.setEmpType(resultSet.getInt(6));
                company.setStatus(resultSet.getInt(7));
                company.setStage(resultSet.getInt(8));
                company.setScale(resultSet.getString(9));
                company.setIndustry(resultSet.getString(10));
                company.setWebSite(resultSet.getString(11));
                company.setLogo(resultSet.getString(12));
                company.setAbbreviation(resultSet.getString(13));
                candiList.add(company);
            }
            if (!candiList.isEmpty()) {
                return candiList.get(0);
            }
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public Integer insert(Company company) {
        String sql = "insert into t_company(name,legal_rep,usd,establish_time,emp_type,status,stage,scale,industry,web_site,logo,abbreviation,audit) values (?,?,?,?,?,?,?,?,?,?,?,?,?) ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, company.getName());
            ps.setString(2, company.getLegalRep());
            ps.setFloat(3,company.getUsd());
            ps.setDate(4, company.getEstablishTime());
            ps.setInt(5, company.getEmpType());
            ps.setInt(6, company.getStatus());
            ps.setInt(7, company.getStage());
            ps.setString(8, company.getScale());
            ps.setString(9, company.getIndustry());
            ps.setString(10,company.getWebSite());
            ps.setString(11, company.getLogo());
            ps.setString(12, company.getAbbreviation());
            ps.setInt(13, company.getAudit());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public Integer updateById(Company company) {
        String sql = "update t_company set name = ?,legal_rep=?,usd=?,establish_time=?,emp_type=?,status=?,stage=?,scale=?,industry=?,web_site=?" + (company.getLogo().equals("")?"":",logo='" + company.getLogo() + "'") + ", abbreviation=?,audit=? where id = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, company.getName());
            ps.setString(2, company.getLegalRep());
            ps.setFloat(3,company.getUsd());
            ps.setDate(4, company.getEstablishTime());
            ps.setInt(5, company.getEmpType());
            ps.setInt(6, company.getStatus());
            ps.setInt(7, company.getStage());
            ps.setString(8, company.getScale());
            ps.setString(9, company.getIndustry());
            ps.setString(10,company.getWebSite());
            ps.setString(11, company.getAbbreviation());
            ps.setInt(12, company.getAudit());
            ps.setInt(13, company.getId());
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public List<Company> findAllCompanyByAudit(){
        String sql = "select * from t_company where audit = 1";
        List<Company> candiList = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Company company = new Company();
                company.setId(resultSet.getInt(1));
                company.setName(resultSet.getString(2));
                company.setLegalRep(resultSet.getString(3));
                company.setUsd(resultSet.getFloat(4));
                company.setEstablishTime(resultSet.getDate(5));
                company.setEmpType(resultSet.getInt(6));
                company.setStatus(resultSet.getInt(7));
                company.setStage(resultSet.getInt(8));
                company.setScale(resultSet.getString(9));
                company.setIndustry(resultSet.getString(10));
                company.setWebSite(resultSet.getString(11));
                company.setLogo(resultSet.getString(12));
                company.setAbbreviation(resultSet.getString(13));
                candiList.add(company);
            }
            return candiList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return candiList;
    }

    public Integer updateAudit(String comId) {
        String sql = "update t_company set audit = 1 where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, comId);
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
}
