/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author hallur
 */
public interface TeacherFunctions {
    int getMonthDiffirence(LocalDate date1, LocalDate date2);
    LocalDate dateToGregorianCalendar(LocalDate date);
    int daysUntilDeadLine(LocalDate teacherDate, LocalDate semesterDate);
}
