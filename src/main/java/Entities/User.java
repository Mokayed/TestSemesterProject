/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Mok
 */
public class User {

    private String role;
    private String userName;
    private String password;
    private String teacherLasteActiveDate;
    private String teacherExperiance;
    private int studentAge;
    private boolean studentPayment;

    public User(String role, String userName, String password) {
        this.role = role;
        this.userName = userName;
        this.password = password;
    }

    public User(String role, String userName, String password, String teacherLasteActiveDate, String teacherExperiance) {
        this.role = role;
        this.userName = userName;
        this.password = password;
        this.teacherLasteActiveDate = teacherLasteActiveDate;
        this.teacherExperiance = teacherExperiance;
    }

    public User(String role, String userName, String password, int studentAge, boolean studentPayment) {
        this.role = role;
        this.userName = userName;
        this.password = password;
        this.studentAge = studentAge;
        this.studentPayment = studentPayment;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTeacherLasteActiveDate() {
        return teacherLasteActiveDate;
    }

    public void setTeacherLasteActiveDate(String teacherLasteActiveDate) {
        this.teacherLasteActiveDate = teacherLasteActiveDate;
    }

    public String getTeacherExperiance() {
        return teacherExperiance;
    }

    public void setTeacherExperiance(String teacherExperiance) {
        this.teacherExperiance = teacherExperiance;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public boolean isStudentPayment() {
        return studentPayment;
    }

    public void setStudentPayment(boolean studentPayment) {
        this.studentPayment = studentPayment;
    }

    @Override
    public String toString() {
        return "User{" + "role=" + role + ", userName=" + userName + ", password=" + password + ", teacherLasteActiveDate=" + teacherLasteActiveDate + ", teacherExperiance=" + teacherExperiance + ", studentAge=" + studentAge + ", studentPayment=" + studentPayment + '}';
    }
}
