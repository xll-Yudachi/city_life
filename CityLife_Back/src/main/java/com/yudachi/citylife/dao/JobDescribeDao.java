package com.yudachi.citylife.dao;

import com.yudachi.citylife.pojo.JobDescribe;
import com.yudachi.citylife.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JobDescribeDao {
    private static Connection connection = DBUtil.getConnection();

    public JobDescribe findJobDescribeById(Integer id){
        String sql = "select * from t_job_describe where id = ?";
        List<JobDescribe> candiList = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                JobDescribe jobDescribe = new JobDescribe();
                jobDescribe.setId(resultSet.getInt(1));
                jobDescribe.setContent(resultSet.getString(2));
                candiList.add(jobDescribe);
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

    public Integer insert(String content) {
        String sql = "insert into t_job_describe(content) values (?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, content);
            ps.executeUpdate();
            ResultSet resultSet = ps.getGeneratedKeys();
            resultSet.next();
            return resultSet.getInt(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
}
