package com.yudachi.citylife.dao;

import com.yudachi.citylife.pojo.Industry;
import com.yudachi.citylife.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IndustryDao {
    private Connection connection = DBUtil.getConnection();

    public List<Industry> findAllIndustry(){
        String sql = "select id,industry from t_industry;";
        List<Industry> candiList=  new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                Industry industry = new Industry();
                industry.setId(resultSet.getInt(1));
                industry.setIndustry(resultSet.getString(2));
                candiList.add(industry);
            }
            return candiList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return candiList;
    }
}
