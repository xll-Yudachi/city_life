package com.yudachi.citylife.dao;

import cn.hutool.core.util.ObjectUtil;
import com.yudachi.citylife.pojo.JobTemplate;
import com.yudachi.citylife.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JobTemplateDao {
    private Connection connection = DBUtil.getConnection();

    public Integer insert(JobTemplate jobTemplate){
        String sql = "insert into t_job_template(uid,name,salary,province,exp,degree,skill_tag,used, type) values (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, jobTemplate.getUid());
            ps.setString(2, jobTemplate.getName());
            ps.setString(3, jobTemplate.getSalary());
            ps.setString(4, jobTemplate.getProvince());
            ps.setString(5, jobTemplate.getExp());
            ps.setString(6, jobTemplate.getDegree());
            ps.setString(7, jobTemplate.getSkillTag());
            ps.setInt(8, jobTemplate.getUsed());
            ps.setString(9, jobTemplate.getType());
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public List<JobTemplate> findAllByQuery(String name, String uid) {
        List<JobTemplate> candiList = new ArrayList<>();
        String sql = "select * from t_job_template where name in (select name from t_job_template where uid = ? and name like ? and used = 1)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, Integer.valueOf(uid));
            ps.setString(2, "%" + name + "%");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                JobTemplate jobTemplate = new JobTemplate();
                jobTemplate.setId(resultSet.getInt(1));
                jobTemplate.setName(resultSet.getString(3));
                jobTemplate.setSalary(resultSet.getString(4));
                jobTemplate.setProvince(resultSet.getString(5));
                jobTemplate.setExp(resultSet.getString(6));
                jobTemplate.setDegree(resultSet.getString(7));
                jobTemplate.setSkillTag(resultSet.getString(8));
                jobTemplate.setType(resultSet.getString(9));
                candiList.add(jobTemplate);
            }
            return candiList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return candiList;
    }

    public JobTemplate findJobTemplateById(String id) {
        List<JobTemplate> candiList = new ArrayList<>();
        String sql = "select * from t_job_template where id = ? and used = 1";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, Integer.valueOf(id));
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                JobTemplate jobTemplate = new JobTemplate();
                jobTemplate.setId(resultSet.getInt(1));
                jobTemplate.setName(resultSet.getString(3));
                jobTemplate.setSalary(resultSet.getString(4));
                jobTemplate.setProvince(resultSet.getString(5));
                jobTemplate.setExp(resultSet.getString(6));
                jobTemplate.setDegree(resultSet.getString(7));
                jobTemplate.setSkillTag(resultSet.getString(8));
                jobTemplate.setType(resultSet.getString(9));
                candiList.add(jobTemplate);
            }
            if (!ObjectUtil.isEmpty(candiList) && candiList.size() > 0){
                return candiList.get(0);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public Integer update(JobTemplate jobTemplate) {
        String sql = "update t_job_template set name = ?, salary=?, province = ?, exp = ?, degree = ?, skill_tag = ? , type = ? where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, jobTemplate.getName());
            ps.setString(2, jobTemplate.getSalary());
            ps.setString(3, jobTemplate.getProvince());
            ps.setString(4, jobTemplate.getExp());
            ps.setString(5, jobTemplate.getDegree());
            ps.setString(6, jobTemplate.getSkillTag());
            ps.setString(7, jobTemplate.getType());
            ps.setInt(8, jobTemplate.getId());
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public Integer delete(String id) {
        String sql = "update t_job_template set used = 0 where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, Integer.valueOf(id));
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public List<JobTemplate> findJobTemplateByUid(String uid) {
        List<JobTemplate> candiList = new ArrayList<>();
        String sql = "select * from t_job_template where uid = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, Integer.valueOf(uid));
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                JobTemplate jobTemplate = new JobTemplate();
                jobTemplate.setId(resultSet.getInt(1));
                jobTemplate.setName(resultSet.getString(3));
                jobTemplate.setSalary(resultSet.getString(4));
                jobTemplate.setProvince(resultSet.getString(5));
                jobTemplate.setExp(resultSet.getString(6));
                jobTemplate.setDegree(resultSet.getString(7));
                jobTemplate.setSkillTag(resultSet.getString(8));
                jobTemplate.setType(resultSet.getString(9));
                candiList.add(jobTemplate);
            }
            return candiList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return candiList;
    }
}
