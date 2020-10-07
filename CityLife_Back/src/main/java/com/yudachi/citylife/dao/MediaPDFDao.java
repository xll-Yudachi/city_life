package com.yudachi.citylife.dao;

import com.yudachi.citylife.pojo.MediaPDF;
import com.yudachi.citylife.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MediaPDFDao {
    private Connection connection = DBUtil.getConnection();


    public Integer insertMediaPDF(MediaPDF mediaPDF) {
        String sql = "insert into t_media_pdf (url, uid) values (?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,mediaPDF.getUrl());
            ps.setInt(2, mediaPDF.getUid());
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public List<MediaPDF> findPDF(String uid) {
        String sql = "select * from t_media_pdf where uid = ?";
        List<MediaPDF> candiList = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(uid));
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                MediaPDF mediaPDF = new MediaPDF();
                mediaPDF.setId(resultSet.getInt(1));
                mediaPDF.setUrl(resultSet.getString(2));
                mediaPDF.setUid(resultSet.getInt(3));
                candiList.add(mediaPDF);
            }
            return candiList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return candiList;
    }
}
