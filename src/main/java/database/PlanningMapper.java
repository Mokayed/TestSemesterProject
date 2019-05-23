/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import entity.Semester;
import entity.Teacher;
import entity.User;
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

            String sql = "insert into Semester(name, startDate)values(?,?)";
            PreparedStatement pstmt = dbc.preparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, semester.getName());
            pstmt.setString(2, semester.getStartDate().toString());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            dbc.close();
        }
    }

    public Teacher getTeacher(String userName) {
        Teacher teacher = null;
        try {
            dbc.open();
            String sql = "select currentDate as tDate, userName as uName, startDate as sDate,name as sName from Teacher inner join User on Teacher.userId = User.id inner join Semester on Teacher.semesterId = Semester.id where User.userName = ?;";
            PreparedStatement pstmt = dbc.preparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, userName);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                //String name, Semester semester, LocalDate currentDate
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate sDate = LocalDate.parse(rs.getString("sDate"), formatter);
                LocalDate tDate = LocalDate.parse(rs.getString("tDate"), formatter);
                teacher = new Teacher(rs.getString("uName"), new Semester(sDate,
                        rs.getString("sName")), tDate
                );

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            dbc.close();
        }
        return teacher;
    }

    public static void main(String[] args) {
        PlanningMapper pm = new PlanningMapper();
        pm.setDataSource(new ProductionDataSource().getDataSource());
        System.out.println(pm.getTeacher("Kasper").toString());
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

    public LocalDate getTeacherDate(String education) {
        LocalDate date = null;
        try {

            dbc.open();

            String sql = "select currentDate from Teacher where education = ?";
            PreparedStatement pstmt = dbc.preparedStatement(sql);
            pstmt.setString(1, education);
            ResultSet r = pstmt.executeQuery();
            if (r.next()) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                date = LocalDate.parse(r.getString("currentDate"), formatter);
            }

            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            dbc.close();
        }
        return date;
    }

    public LocalDate getSemesterDate(String name) {
        LocalDate date = null;
        try {

            dbc.open();

            String sql = "select startDate from Semester where name = ?";
            PreparedStatement pstmt = dbc.preparedStatement(sql);
            pstmt.setString(1, name);
            ResultSet r = pstmt.executeQuery();
            if (r.next()) {
                System.out.println("are we ever in here");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                date = LocalDate.parse(r.getString("startDate"), formatter);
            }

            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            dbc.close();
        }
        return date;
    }

    public LocalDate getSemesterDate(LocalDate semester) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
