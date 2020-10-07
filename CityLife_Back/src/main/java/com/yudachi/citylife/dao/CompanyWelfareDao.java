package com.yudachi.citylife.dao;

import com.yudachi.citylife.pojo.CompanyWelfare;
import com.yudachi.citylife.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyWelfareDao {
    private static Connection connection = DBUtil.getConnection();

    public CompanyWelfare findCompanyWelfareById(Integer id){
        String sql = "select * from t_company_welfare where id = ?";
        List<CompanyWelfare> candiList = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                CompanyWelfare companyWelfare = new CompanyWelfare();
                companyWelfare.setId(resultSet.getInt(1));
                companyWelfare.setCompanyId(resultSet.getInt(2));
                companyWelfare.setWelfare(resultSet.getString(3));
                candiList.add(companyWelfare);
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

    public CompanyWelfare findCompanyWelfareByCid(Integer companyId){
        String sql = "select * from t_company_welfare where company_id = ?";
        List<CompanyWelfare> candiList = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, companyId);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                CompanyWelfare companyWelfare = new CompanyWelfare();
                companyWelfare.setId(resultSet.getInt(1));
                companyWelfare.setCompanyId(resultSet.getInt(2));
                companyWelfare.setWelfare(resultSet.getString(3));
                candiList.add(companyWelfare);
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

    public Integer insert(String id, String comWelfare) {
        String sql = "insert into t_company_welfare(company_id, welfare) values (?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, Integer.valueOf(id));
            ps.setString(2, comWelfare);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public Integer updateById(String comWelfareId, String comWelfare) {
        String sql = "update t_company_welfare set welfare = ? where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, comWelfare);
            ps.setInt(2, Integer.valueOf(comWelfareId));
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
}
