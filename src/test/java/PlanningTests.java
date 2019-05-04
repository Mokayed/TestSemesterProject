/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Entities.Semester;
import Entities.Teacher;
import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import org.hamcrest.core.IsEqual;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

/**
 *
 * @author hallur
 */
@RunWith(MockitoJUnitRunner.class)
public class PlanningTests {

    @Mock
    Teacher teacher;

    @Mock
    Semester semester;

    @Mock
    GregorianCalendar sCalendar, tCalendar;

    @Before
    public void setUp() {
        teacher = mock(Teacher.class);
        semester = mock(Semester.class);
        when(teacher.getCurrentDate()).thenReturn(new GregorianCalendar(2019, Calendar.JUNE, 01).getTime());
        when(semester.getStartDate()).thenReturn(new GregorianCalendar(2019, Calendar.AUGUST, 01).getTime());

    }

    @Test //this is for an example where teacher can start planning...
    public void twoMonthsTest() throws ParseException {
        sCalendar = new GregorianCalendar();
        sCalendar.setTime(semester.getStartDate()); //1
        tCalendar = new GregorianCalendar();
        tCalendar.setTime(teacher.getCurrentDate()); //1

        when(teacher.getMonthDiffirence(teacher.getCurrentDate(), semester.getStartDate())) //2
                .thenReturn((sCalendar.get(Calendar.MONTH) - tCalendar.get(Calendar.MONTH)));

        assertThat(2, equalTo(teacher.getMonthDiffirence(teacher.getCurrentDate(), semester.getStartDate()))); //3

        verify(teacher, times(3)).getCurrentDate();
        verify(semester, times(3)).getStartDate();
    }

    @Test //this is for an example where teacher has to stop planning (1 month has passed)
    public void oneMonthTest() throws ParseException {
        when(teacher.getCurrentDate()).thenReturn(new GregorianCalendar(2019, Calendar.JULY, 01).getTime());
        when(semester.getStartDate()).thenReturn(new GregorianCalendar(2019, Calendar.AUGUST, 01).getTime());

        sCalendar = new GregorianCalendar();
        sCalendar.setTime(semester.getStartDate()); //1
        tCalendar = new GregorianCalendar();
        tCalendar.setTime(teacher.getCurrentDate()); //1

        when(teacher.getMonthDiffirence(teacher.getCurrentDate(), semester.getStartDate())) //2
                .thenReturn((sCalendar.get(Calendar.MONTH) - tCalendar.get(Calendar.MONTH)));

        assertThat(1, equalTo(teacher.getMonthDiffirence(teacher.getCurrentDate(), semester.getStartDate()))); //3
        verify(teacher, times(3)).getCurrentDate();
        verify(semester, times(3)).getStartDate();
    }

    @Test
    public void deadLineTest() {
        sCalendar = new GregorianCalendar();
        sCalendar.setTime(semester.getStartDate());
        sCalendar.add(Calendar.MONTH, -1); //subtract a month (the deadline date)

        tCalendar = new GregorianCalendar();
        tCalendar.setTime(teacher.getCurrentDate()); //1
        long diff = sCalendar.getTime().getTime() - tCalendar.getTime().getTime();
        int daysUntilDeadLine = (int) (diff / (1000 * 60 * 60 * 24));
        assertThat(30, equalTo(daysUntilDeadLine));
    }
}
