package com.yudachi.citylife.dao;

import com.yudachi.citylife.pojo.JobInfo;
import com.yudachi.citylife.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JobInfoDao {
    private static Connection connection = DBUtil.getConnection();

    public JobInfo findJobInfoById(Integer id){
        String sql = "select * from t_job_info where id = ?";
        List<JobInfo> candiList = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                JobInfo jobInfo = new JobInfo();
                jobInfo.setId(resultSet.getInt(1));
                jobInfo.setName(resultSet.getString(2));
                jobInfo.setSalary(resultSet.getString(3));
                jobInfo.setCompanyId(resultSet.getInt(4));
                jobInfo.setDescribeId(resultSet.getInt(5));
                jobInfo.setAddress(resultSet.getString(6));
                jobInfo.setUpdateTime(resultSet.getTimestamp(7));
                jobInfo.setProvince(resultSet.getString(8));
                jobInfo.setExp(resultSet.getString(9));
                jobInfo.setDegree(resultSet.getString(10));
                jobInfo.setSkillTag(resultSet.getString(11));
                jobInfo.setType(resultSet.getString(12));
                candiList.add(jobInfo);
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

    public List<Integer> findJobAllId() {
        String sql = "select id from t_job_info";
        List<Integer> candiList = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                candiList.add(resultSet.getInt(1));
            }
            return candiList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return candiList;
    }

    public Integer insert(JobInfo jobInfo) {
        String sql = "insert into t_job_info(name,salary,company_id,describe_id,address,update_time,province,exp,degree,skill_tag,type) values (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, jobInfo.getName());
            ps.setString(2, jobInfo.getSalary());
            ps.setInt(3, jobInfo.getCompanyId());
            ps.setInt(4, jobInfo.getDescribeId());
            ps.setString(5, jobInfo.getAddress());
            ps.setTimestamp(6, jobInfo.getUpdateTime());
            ps.setString(7, jobInfo.getProvince());
            ps.setString(8, jobInfo.getExp());
            ps.setString(9, jobInfo.getDegree());
            ps.setString(10, jobInfo.getSkillTag());
            ps.setString(11, jobInfo.getType());
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public List<JobInfo> findByType(String type){
        String sql = "select * from t_job_info where type = ?";
        List<JobInfo> candiList = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, type);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                JobInfo jobInfo = new JobInfo();
                jobInfo.setId(resultSet.getInt(1));
                jobInfo.setName(resultSet.getString(2));
                jobInfo.setSalary(resultSet.getString(3));
                jobInfo.setCompanyId(resultSet.getInt(4));
                jobInfo.setDescribeId(resultSet.getInt(5));
                jobInfo.setAddress(resultSet.getString(6));
                jobInfo.setUpdateTime(resultSet.getTimestamp(7));
                jobInfo.setProvince(resultSet.getString(8));
                jobInfo.setExp(resultSet.getString(9));
                jobInfo.setDegree(resultSet.getString(10));
                jobInfo.setSkillTag(resultSet.getString(11));
                jobInfo.setType(resultSet.getString(12));
                candiList.add(jobInfo);
            }
            return candiList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return candiList;
    }
}
