package Entities;

import interfaces.TeacherFunctions;
import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;

public class Teacher extends User implements TeacherFunctions {

    private int id;
    private String name;
    private String education;
    private Semester semester;
    private LocalDate lastActive;
    private LocalDate currentDate;

    public Teacher(String name, String education, LocalDate lastActive) {
        this.name = name;
        this.education = education;
        this.lastActive = lastActive;
    }

    public Teacher(Semester semester, LocalDate currentDate) {
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

    public LocalDate getLastActive() {
        return lastActive;
    }

    public void setLastActive(LocalDate lastActive) {
        this.lastActive = lastActive;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public LocalDate getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(LocalDate currentDate) {
        this.currentDate = currentDate;
    }

    @Override
    public int getMonthDiffirence(LocalDate date1, LocalDate date2) {
        return 0; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LocalDate dateToGregorianCalendar(LocalDate date) {
        return null; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int daysUntilDeadLine(LocalDate teacherDate, LocalDate semesterDate) {
        return 0; //To change body of generated methods, choose Tools | Templates.
    }

}