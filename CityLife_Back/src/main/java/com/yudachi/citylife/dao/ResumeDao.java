package com.yudachi.citylife.dao;

import cn.hutool.core.util.ObjectUtil;
import com.yudachi.citylife.pojo.Resume;
import com.yudachi.citylife.util.DBUtil;
import org.apache.commons.lang3.StringUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResumeDao {
    private Connection connection = DBUtil.getConnection();


    public Integer insertAvatar(Resume resume) {
        String sql = "insert into t_resume(uid, avatar) values (?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, resume.getUid());
            ps.setString(2, resume.getAvatar());
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public Resume findResumeByUid(String uid) {
        List<Resume> candiList = new ArrayList<>();
        String sql = "select * from t_resume where uid = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, Integer.valueOf(uid));
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Resume resume = new Resume();
                resume.setId(resultSet.getInt(1));
                resume.setName(resultSet.getString(2));
                resume.setPhone(resultSet.getString(3));
                resume.setSex(resultSet.getInt(4));
                resume.setBirth(resultSet.getDate(5));
                resume.setPosition(resultSet.getString(6));
                resume.setGuard(resultSet.getString(7));
                resume.setDirection(resultSet.getString(8));
                resume.setSalary(resultSet.getString(9));
                resume.setAvatar(resultSet.getString(10));
                resume.setWorkExp(resultSet.getString(11));
                resume.setStudyExp(resultSet.getString(12));
                resume.setEvaluation(resultSet.getString(13));
                resume.setUid(resultSet.getInt(14));
                resume.setAttachTime(resultSet.getDate(15));
                resume.setWxId(resultSet.getString(16));
                resume.setEmail(resultSet.getString(17));
                candiList.add(resume);
            }
            if (candiList.size() > 0) {
                return candiList.get(0);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public Integer insertResume(Resume resume) {
        String template = judgeResumeWhereIsNotNull(resume);
        String sql = "insert into t_resume " + template;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }


    public Integer updateResume(Resume resume) {
        String sql = "update t_resume set " + updateResumeWhereIsNotNull(resume) + " where uid = " + resume.getUid();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    /**
     * 制作添加简历sql的模板
     *
     * @param resume
     * @return: java.lang.String
     **/
    private String judgeResumeWhereIsNotNull(Resume resume) {
        StringBuilder sbKey = new StringBuilder("(");
        StringBuilder sbValue = new StringBuilder("values (");
        if (!StringUtils.isEmpty(resume.getName())) {
            sbKey.append("name,");
            sbValue.append("'" + resume.getName() + "',");
        }
        if (!StringUtils.isEmpty(resume.getPhone())) {
            sbKey.append("phone,");
            sbValue.append("'" + resume.getPhone() + "',");
        }
        if (!ObjectUtil.isEmpty(resume.getSex())) {
            sbKey.append("sex,");
            sbValue.append(resume.getSex() + ",");
        }
        if (!ObjectUtil.isEmpty(resume.getBirth())) {
            sbKey.append("birth,");
            sbValue.append("'" + resume.getBirth() + "',");
        }
        if (!StringUtils.isEmpty(resume.getPosition())) {
            sbKey.append("position,");
            sbValue.append("'" + resume.getPosition() + "',");
        }
        if (!StringUtils.isEmpty(resume.getGuard())) {
            sbKey.append("guard,");
            sbValue.append("'"+resume.getGuard() + "',");
        }
        if (!StringUtils.isEmpty(resume.getDirection())) {
            sbKey.append("direction,");
            sbValue.append("'"+resume.getDirection() + "',");
        }
        if (!StringUtils.isEmpty(resume.getSalary())) {
            sbKey.append("salary,");
            sbValue.append("'" + resume.getSalary() + "',");
        }
        if (!StringUtils.isEmpty(resume.getAvatar())) {
            sbKey.append("avatar,");
            sbValue.append("'"+resume.getAvatar() + "',");
        }
        if (!StringUtils.isEmpty(resume.getWorkExp())) {
            sbKey.append("work_exp,");
            sbValue.append("'" + resume.getWorkExp() + "',");
        }
        if (!StringUtils.isEmpty(resume.getStudyExp())) {
            sbKey.append("study_exp,");
            sbValue.append("'" + resume.getStudyExp() + "',");
        }
        if (!StringUtils.isEmpty(resume.getEvaluation())) {
            sbKey.append("evaluation,");
            sbValue.append("'" + resume.getEvaluation() + "',");
        }
        if (!ObjectUtil.isEmpty(resume.getUid())) {
            sbKey.append("uid,");
            sbValue.append(resume.getUid() + ",");
        }
        if (!ObjectUtil.isEmpty(resume.getAttachTime())) {
            sbKey.append("attach_time,");
            sbValue.append("'" + resume.getAttachTime() + "',");
        }
        if (!StringUtils.isEmpty(resume.getWxId())) {
            sbKey.append("wxId,");
            sbValue.append("'"+resume.getWxId() + "',");
        }
        if (!StringUtils.isEmpty(resume.getEmail())) {
            sbKey.append("email,");
            sbValue.append("'"+resume.getEmail() + "',");
        }
        if (',' == sbKey.charAt(sbKey.length() - 1)) {
            sbKey.deleteCharAt(sbKey.length() - 1);
        }
        if (',' == sbValue.charAt(sbValue.length() - 1)) {
            sbValue.deleteCharAt(sbValue.length() - 1);
        }
        sbKey.append(")");
        sbValue.append(")");
        return sbKey.toString() + sbValue.toString();
    }

    /**
     * 制作更新简历sql的模板
     *
     * @param resume
     * @return: java.lang.String
     **/
    private String updateResumeWhereIsNotNull(Resume resume) {
        StringBuilder sbKey = new StringBuilder();
        if (!StringUtils.isEmpty(resume.getName())) {
            sbKey.append("name='" + resume.getName() + "',");
        }
        if (!StringUtils.isEmpty(resume.getPhone())) {
            sbKey.append("phone='" + resume.getPhone() + "',");
        }
        if (!ObjectUtil.isEmpty(resume.getSex())) {
            sbKey.append("sex=" + resume.getSex() + ",");
        }
        if (!ObjectUtil.isEmpty(resume.getBirth())) {
            sbKey.append("birth='" + resume.getBirth() + "',");
        }
        if (!StringUtils.isEmpty(resume.getPosition())) {
            sbKey.append("position='" + resume.getPosition() + "',");
        }
        if (!StringUtils.isEmpty(resume.getGuard())) {
            sbKey.append("guard='" + resume.getGuard() + "',");
        }
        if (!StringUtils.isEmpty(resume.getDirection())) {
            sbKey.append("direction='" + resume.getDirection() + "',");
        }
        if (!StringUtils.isEmpty(resume.getSalary())) {
            sbKey.append("salary='" + resume.getSalary() + "',");
        }
        if (!StringUtils.isEmpty(resume.getAvatar())) {
            sbKey.append("avatar='" + resume.getAvatar() + "',");
        }
        if (!StringUtils.isEmpty(resume.getWorkExp())) {
            sbKey.append("work_exp='" + resume.getWorkExp() + "',");
        }
        if (!StringUtils.isEmpty(resume.getStudyExp())) {
            sbKey.append("study_exp='" + resume.getStudyExp() + "',");
        }
        if (!StringUtils.isEmpty(resume.getEvaluation())) {
            sbKey.append("evaluation='" + resume.getEvaluation() + "',");
        }
        if (!ObjectUtil.isEmpty(resume.getAttachTime())) {
            sbKey.append("attach_time='" + resume.getAttachTime() + "',");
        }
        if (!StringUtils.isEmpty(resume.getWxId())) {
            sbKey.append("wxId='" + resume.getWxId() + "',");
        }
        if (!StringUtils.isEmpty(resume.getEmail())) {
            sbKey.append("email='" + resume.getEmail() + "',");
        }
        if (',' == sbKey.charAt(sbKey.length() - 1)) {
            sbKey.deleteCharAt(sbKey.length() - 1);
        }
        return sbKey.toString();
    }

    public Integer updateAvatar(String avatarUrl, String uid) {
        String sql = "update t_resume set avatar = ? where uid = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, avatarUrl);
            ps.setInt(2, Integer.valueOf(uid));
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public Integer insertResumePost(String uid, String jobId, String companyId) {
        String sql = "insert into t_resume_post (uid, jobId, companyId) values (?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(uid));
            ps.setInt(2, Integer.parseInt(jobId));
            ps.setInt(3, Integer.parseInt(companyId));
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
}
