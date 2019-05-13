/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import Entities.Semester;
import Entities.Teacher;
import Entities.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.sql.DataSource;

/**
 *
 * @author hallur
 */
public class PlanningMapper {

    private DatabaseConnector dbc = new DatabaseConnector();

    public void setDataSource(DataSource ds) {
        dbc.setDataSource(ds);
    }

    public void getAllFromUser() {
        try {

            dbc.open();

            String sql = "select * from User";
            PreparedStatement pstmt = dbc.preparedStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString(1) + ", " + rs.getString(2) + ", " + rs.getString(3) + ", " + rs.getString(4));
            }

            rs.close();
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            dbc.close();
        }
    }

    public void insertUser(User user) {
        try {

            dbc.open();

            String sql = "insert into User(userName,password,role)values(?,?,?)";
            PreparedStatement pstmt = dbc.preparedStatement(sql);
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getRole());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            dbc.close();
        }
    }

    public void insertSemester(Semester semester) {
        try {

            dbc.open();

            String sql = "insert into Semester(name)values(?)";
            PreparedStatement pstmt = dbc.preparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, semester.getStartDate().toString());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            dbc.close();
        }
    }

    public void insertTeacher(Teacher teacher, int userId, int semesterId) {
        try {
            dbc.open();
            String sql = "insert into Teacher(userId,semesterId,education,lastActive,currentDate)values(?,?,?,?,?)";
            PreparedStatement pstmt = dbc.preparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, userId);
            pstmt.setInt(2, semesterId);
            pstmt.setString(3, "some_education");
            pstmt.setString(4, "some_last_active_date");
            pstmt.setString(5, teacher.getCurrentDate().toString());
            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException ex) {
            System.out.println("error was in insert teacher");
            ex.printStackTrace();
        } finally {
            dbc.close();
        }
    }

    public int getPrimaryKeyIdFromTable(String table) {
        int id = -1;
        try {

            dbc.open();
            String sql = "";
            if (table.equals("User")) {
                sql = "select id from User";
            }
            if (table.equals("Semester")) {
                sql = "select id from Semester";
            }
            PreparedStatement pstmt = dbc.preparedStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                id = rs.getInt("id");
            }

            rs.close();
            pstmt.close();
        } catch (SQLException ex) {
            System.out.println("error was in get p key");
            ex.printStackTrace();
        } finally {
            dbc.close();
        }
        return id;
    }

    public LocalDate getTeacherDate() {
        LocalDate date = null;
        try {

            dbc.open();

            String sql = "select currentDate from Teacher";
            PreparedStatement pstmt = dbc.preparedStatement(sql);
            ResultSet r = pstmt.executeQuery();
            if(r.next()){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                date = LocalDate.parse(r.getString("currentDate"), formatter);
            }
            
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            dbc.close();
        } return date;
    }

    public LocalDate getSemesterDate() {
        LocalDate date = null;
        try {

            dbc.open();

            String sql = "select name from Semester";
            PreparedStatement pstmt = dbc.preparedStatement(sql);
            ResultSet r = pstmt.executeQuery();
            if(r.next()){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                date = LocalDate.parse(r.getString("name"), formatter);
            }
            
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            dbc.close();
        } return date;
    }
}
