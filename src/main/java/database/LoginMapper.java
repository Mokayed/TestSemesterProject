/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import Entities.User;
import database.DatabaseConnector;
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

    public User getUser(int id) throws SQLException {
        dbc.open();

        String sql = "select * from User WHERE id = ?";
        PreparedStatement pstmt = dbc.preparedStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            String userName = rs.getString("userName");
            String password = rs.getString("password");
            String role = rs.getString("role");
            User user = new User();
            user.setUserName(userName);
            user.setPassword(password);
            user.setRole(role);
            System.out.println(user.getRole());

            return user;
        }
        return null;
    }

}