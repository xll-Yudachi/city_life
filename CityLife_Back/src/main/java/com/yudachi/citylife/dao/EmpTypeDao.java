package com.yudachi.citylife.dao;

import com.yudachi.citylife.pojo.EmpType;
import com.yudachi.citylife.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpTypeDao {

    private static Connection connection = DBUtil.getConnection();

    public List<EmpType> findAllEmpType(){
        String sql = "select id, emp_type from t_emptype;";
        List<EmpType> candiList=  new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                EmpType empType = new EmpType();
                empType.setId(resultSet.getInt(1));
                empType.setEmpType(resultSet.getString(2));
                candiList.add(empType);
            }
            return candiList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return candiList;
    }
}
