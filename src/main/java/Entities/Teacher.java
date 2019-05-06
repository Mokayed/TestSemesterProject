/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import interfaces.TeacherFunctions;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author hallur
 */
public class Teacher extends User implements TeacherFunctions{
    private Semester semester;
    private Date currentDate;    

    public Teacher(Semester semester, Date currentDate) {
        this.semester = semester;
        this.currentDate = currentDate;
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
