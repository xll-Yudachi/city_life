package com.yudachi.citylife.dao;

import com.yudachi.citylife.dto.MediaListQuery;
import com.yudachi.citylife.pojo.Media;
import com.yudachi.citylife.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MediaDao {
    private static Connection connection = DBUtil.getConnection();

    public int insertMedia(Media media) {
        String sql = "insert into t_media (media_type, url, used, upload_time) values (?,?,?,?);";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, media.getMediaType());
            ps.setString(2, media.getUrl());
            ps.setInt(3, media.getUsed());
            ps.setTimestamp(4, media.getUploadTime());
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public List<Media> findAllMedia(MediaListQuery query) {
        String sql = "select * from t_media where IF(?<>'',media_type = ?,'1:1') and IF(?<>'',used = ?,'1:1') and IF(?<>'' and ?<>'', upload_time between ? and ?, '1:1')";
        List<Media> candiList = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, query.getMediaType());
            ps.setString(2, query.getMediaType());
            ps.setString(3, query.getUsed());
            ps.setString(4, query.getUsed());
            ps.setString(5, query.getStartTime());
            ps.setString(6, query.getEndTime());
            ps.setString(7, query.getStartTime());
            ps.setString(8, query.getEndTime());
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Media media = new Media();
                media.setId(resultSet.getInt(1));
                media.setMediaType(resultSet.getInt(2));
                media.setUrl(resultSet.getString(3));
                media.setUsed(resultSet.getInt(4));
                media.setUploadTime(resultSet.getTimestamp(5));
                candiList.add(media);
            }
            return candiList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return candiList;
    }

    public Integer updateMediaById(Media media) {
        String sql = "update t_media set used = ? where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, 1 - media.getUsed());
            ps.setInt(2, media.getId());
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
}
