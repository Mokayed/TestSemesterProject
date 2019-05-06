/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author hallur
 */
public interface TeacherFunctions {
    int getMonthDiffirence(Date date1, Date date2);
    GregorianCalendar dateToGregorianCalendar(Date date);
    int daysUntilDeadLine(Date teacherDate, Date semesterDate);
}
