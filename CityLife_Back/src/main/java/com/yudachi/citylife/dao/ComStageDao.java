package com.yudachi.citylife.dao;

import com.yudachi.citylife.pojo.ComStage;
import com.yudachi.citylife.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComStageDao {
    private static Connection connection = DBUtil.getConnection();

    public List<ComStage> findAllComStage(){
        String sql = "select id, stage from t_comstage;";
        List<ComStage> candiList=  new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                ComStage comStage = new ComStage();
                comStage.setId(resultSet.getInt(1));
                comStage.setStage(resultSet.getString(2));
                candiList.add(comStage);
            }
            return candiList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return candiList;
    }
}
