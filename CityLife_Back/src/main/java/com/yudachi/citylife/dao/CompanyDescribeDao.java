package com.yudachi.citylife.dao;

import com.yudachi.citylife.pojo.CompanyDescribe;
import com.yudachi.citylife.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyDescribeDao {
    private static Connection connection = DBUtil.getConnection();

    public CompanyDescribe findCompanyDescribeById(Integer id){
        String sql = "select * from t_company_describe where id = ?";
        List<CompanyDescribe> candiList = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                CompanyDescribe companyDescribe = new CompanyDescribe();
                companyDescribe.setId(resultSet.getInt(1));
                companyDescribe.setContent(resultSet.getString(2));
                companyDescribe.setCompanyId(resultSet.getInt(3));
                candiList.add(companyDescribe);
            }
            if (!candiList.isEmpty()){
                return candiList.get(0);
            }
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public CompanyDescribe findCompanyDescribeByCid(Integer companyId){
        String sql = "select * from t_company_describe where company_id = ?";
        List<CompanyDescribe> candiList = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, companyId);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                CompanyDescribe companyDescribe = new CompanyDescribe();
                companyDescribe.setId(resultSet.getInt(1));
                companyDescribe.setContent(resultSet.getString(2));
                companyDescribe.setCompanyId(resultSet.getInt(3));
                candiList.add(companyDescribe);
            }
            if (!candiList.isEmpty()){
                return candiList.get(0);
            }
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public Integer insert(String id, String comDescribe) {
        String sql = "insert into t_company_describe(content,company_id) values (?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, comDescribe);
            ps.setInt(2, Integer.valueOf(id));
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public Integer updateById(String comDescribeId, String comDescribe) {
        String sql = "update t_company_describe set content = ? where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,comDescribe);
            ps.setInt(2, Integer.valueOf(comDescribeId));
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
}
