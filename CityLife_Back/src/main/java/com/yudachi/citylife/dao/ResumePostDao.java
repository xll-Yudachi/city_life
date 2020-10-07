package com.yudachi.citylife.dao;

import com.yudachi.citylife.pojo.ResumePost;
import com.yudachi.citylife.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResumePostDao {
    private Connection connection = DBUtil.getConnection();

    public List<ResumePost> findAllResumePost(){
        String sql = "select * from t_resume_post";
        List<ResumePost> candiList = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                ResumePost resumePost = new ResumePost();
                resumePost.setId(resultSet.getInt(1));
                resumePost.setUid(resultSet.getInt(2));
                resumePost.setJobId(resultSet.getInt(3));
                resumePost.setCompanyId(resultSet.getInt(4));
                candiList.add(resumePost);
            }
            return candiList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return candiList;
    }
}
