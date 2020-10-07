package com.yudachi.citylife.dao;

import com.yudachi.citylife.pojo.CompanyApply;
import com.yudachi.citylife.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyApplyDao {
    private Connection connection = DBUtil.getConnection();


    public Integer insertCompanyApply(CompanyApply companyApply) {
        String sql = "insert into t_company_apply (uid,cid,apply_time) values (?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, companyApply.getUid());
            ps.setInt(2, companyApply.getCid());
            ps.setDate(3, companyApply.getApplyTime());
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public List<CompanyApply> findCompanyApplyByUid(String uid) {
        List<CompanyApply> candiList = new ArrayList<>();
        String sql = "select * from t_company_apply where uid = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(uid));
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                CompanyApply companyApply = new CompanyApply();
                companyApply.setId(resultSet.getInt(1));
                companyApply.setUid(resultSet.getInt(2));
                companyApply.setCid(resultSet.getInt(3));
                companyApply.setApplyTime(resultSet.getDate(4));
                candiList.add(companyApply);
            }
            return candiList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return candiList;
    }
}
