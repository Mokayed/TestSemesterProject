/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import Entities.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;

/**
 *
 * @author MoK
 */
public class LoginMapper {

    private DatabaseConnector dbc = new DatabaseConnector();

    public void setDataSource(DataSource ds) {
        dbc.setDataSource(ds);
    }

    public boolean checkUser(String userName, String password) throws SQLException {
        try {
            dbc.open();

            String sql = "select * from User WHERE userName = ? and password = ?";
            PreparedStatement pstmt = dbc.preparedStatement(sql);
            //pstmt.setInt(1, id);
            pstmt.setString(1, userName);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                userName = rs.getString("userName");
                password = rs.getString("password");
                String role = rs.getString("role");
                User user = new User();
                user.setUserName(userName);
                user.setPassword(password);
                user.setRole(role);
                //System.out.println(user.getRole());
                System.out.println(user.toString());
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public User getUser(String userName, String password) throws SQLException {
        dbc.open();
        String sql = "select * from User WHERE userName = ? and password = ?";
        PreparedStatement pstmt = dbc.preparedStatement(sql);
        pstmt.setString(1, userName);
        pstmt.setString(2, password);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            userName = rs.getString("userName");
            password = rs.getString("password");
            String role = rs.getString("role");
            User user = new User();
            user.setUserName(userName);
            user.setPassword(password);
            user.setRole(role);
            return user;
        }
        return null;
    }
}
