package com.yudachi.citylife.dao;

import com.yudachi.citylife.pojo.Admin;
import com.yudachi.citylife.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDao {
    private Connection connection = DBUtil.getConnection();

    public Admin findAdminByName(String name){
        String sql = "select * from t_admin where name = ?";
        List<Admin> candiList = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                Admin admin = new Admin();
                admin.setId(resultSet.getInt(1));
                admin.setName(resultSet.getString(2));
                admin.setPwd(resultSet.getString(3));
                candiList.add(admin);
            }
            if (!candiList.isEmpty()){
                return candiList.get(0);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
