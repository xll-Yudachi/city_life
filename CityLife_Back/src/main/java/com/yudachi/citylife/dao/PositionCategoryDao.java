package com.yudachi.citylife.dao;

import com.yudachi.citylife.dto.PositionCategoryDto;
import com.yudachi.citylife.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionCategoryDao {
    private static Connection connection =  DBUtil.getConnection();

    public List<PositionCategoryDto> findAll(){
        List<PositionCategoryDto> res = new ArrayList<>();
        String sql_one = "select * from t_position_category where parentid = 0";
        try {
            ResultSet resultSet_one = connection.prepareStatement(sql_one).executeQuery();
            while (resultSet_one.next()){
                Integer id_one  = resultSet_one.getInt(1);
                String name_one  = resultSet_one.getString(2);
                PositionCategoryDto _one = new PositionCategoryDto();
                _one.setValue(id_one);
                _one.setLabel(name_one);
                String sql_two = "select * from t_position_category where parentid = ?";
                PreparedStatement ps_two = connection.prepareStatement(sql_two);
                ps_two.setInt(1,id_one);
                ResultSet resultSet_two = ps_two.executeQuery();
                List<PositionCategoryDto> list_two = new ArrayList<>();
                while (resultSet_two.next()){
                    Integer id_two  = resultSet_two.getInt(1);
                    String name_two  = resultSet_two.getString(2);
                    PositionCategoryDto _two = new PositionCategoryDto();
                    _two.setValue(id_two);
                    _two.setLabel(name_two);
                    String sql_three = "select * from t_position_category where parentid = ?";
                    PreparedStatement ps = connection.prepareStatement(sql_three);
                    ps.setInt(1,id_two);
                    ResultSet resultSet_three = ps.executeQuery();
                    List<PositionCategoryDto> list_three = new ArrayList<>();
                    while (resultSet_three.next()){
                        Integer id_three = resultSet_three.getInt(1);
                        String name_three = resultSet_three.getString(2);
                        PositionCategoryDto _three = new PositionCategoryDto();
                        _three.setLabel(name_three);
                        _three.setValue(id_three);
                        list_three.add(_three);
                    }
                    _two.setChildren(list_three);
                    list_two.add(_two);
                }
                _one.setChildren(list_two);
                res.add(_one);
            }
            return res;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    public List<List<Integer>> getTop9Position(){
        List<List<Integer>> res = new ArrayList<>();
        String sql_one = "select * from t_position_category where parentid = 0";
        try {
            ResultSet resultSet_one = connection.prepareStatement(sql_one).executeQuery();
            int cur = 0;
            while (resultSet_one.next() && cur <= 8){
                List<Integer> list = new ArrayList<>();
                Integer id_one  = resultSet_one.getInt(1);
                String sql_two = "select * from t_position_category where parentid = ?";
                PreparedStatement ps_two = connection.prepareStatement(sql_two);
                ps_two.setInt(1,id_one);
                ResultSet resultSet_two = ps_two.executeQuery();
                while (resultSet_two.next()){
                    Integer id_two  = resultSet_two.getInt(1);
                    String sql_three = "select * from t_position_category where parentid = ?";
                    PreparedStatement ps = connection.prepareStatement(sql_three);
                    ps.setInt(1,id_two);
                    ResultSet resultSet_three = ps.executeQuery();
                    while (resultSet_three.next()){
                        Integer id_three = resultSet_three.getInt(1);
                        list.add(id_three);
                    }
                }
                res.add(list);
                cur++;
            }
            return res;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
