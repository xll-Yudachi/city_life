package com.yudachi.citylife.dao;

import com.yudachi.citylife.pojo.User;
import com.yudachi.citylife.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static Connection connection = DBUtil.getConnection();

    public int insertUser(String phone, String pwd, Integer rank){
        String sql = "insert into t_user (username, phone, pwd, rank, email) values (?,?,?,?,?);";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, phone);
            ps.setString(2, phone);
            ps.setString(3, pwd);
            ps.setInt(4, rank);
            ps.setString(5, "452419829@qq.com");
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public User findUserByPhone(String phone){
        String sql = "select * from t_user where phone =  ?";
        List<User> candiUserList = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, phone);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setUsername(resultSet.getString(2));
                user.setPhone(resultSet.getString(3));
                user.setPwd(resultSet.getString(4));
                user.setRank(resultSet.getInt(5));
                user.setEmail(resultSet.getString(6));
                candiUserList.add(user);
            }
            if (candiUserList.isEmpty()){
                return null;
            }else{
                return candiUserList.get(0);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public User findUserById(Integer id){
        String sql = "select * from t_user where id =  ?";
        List<User> candiUserList = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setUsername(resultSet.getString(2));
                user.setPhone(resultSet.getString(3));
                user.setRank(resultSet.getInt(5));
                user.setEmail(resultSet.getString(6));
                candiUserList.add(user);
            }
            if (candiUserList.isEmpty()){
                return null;
            }else{
                return candiUserList.get(0);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
