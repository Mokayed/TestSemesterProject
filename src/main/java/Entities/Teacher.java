package Entities;

import interfaces.TeacherFunctions;
import java.util.Date;
import java.util.GregorianCalendar;

public class Teacher extends User implements TeacherFunctions {

    private int id;
    private String name;
    private String education;
    private Semester semester;
    private Date lastActive;
    private Date currentDate;

    public Teacher(String name, String education, Date lastActive) {
        this.name = name;
        this.education = education;
        this.lastActive = lastActive;
    }

    public Teacher(Semester semester, Date currentDate) {
        this.semester = semester;
        this.currentDate = currentDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Date getLastActive() {
        return lastActive;
    }

    public void setLastActive(Date lastActive) {
        this.lastActive = lastActive;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    @Override
    public int getMonthDiffirence(Date date1, Date date2) {
        return 0; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GregorianCalendar dateToGregorianCalendar(Date date) {
        return null; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int daysUntilDeadLine(Date teacherDate, Date semesterDate) {
        return 0; //To change body of generated methods, choose Tools | Templates.
    }

}
