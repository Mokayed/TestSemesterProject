package junit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entity.Semester;
import entity.Teacher;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import static java.time.temporal.ChronoUnit.DAYS;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.platform.runner.JUnitPlatform;

import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author hallur
 */
@RunWith(JUnitPlatform.class)
@TestInstance(Lifecycle.PER_CLASS)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class M_O_C_K_Planning {

    @Mock
    Teacher teacher;

    @Mock
    Semester semester;

    @Mock
    LocalDate sCalendar, tCalendar;

    @BeforeAll
    public void setUp() {
        teacher = mock(Teacher.class);
        semester = mock(Semester.class);
        when(teacher.getCurrentDate()).thenReturn(LocalDate.of(2019,Month.JUNE,1));
        when(semester.getStartDate()).thenReturn(LocalDate.of(2019,Month.AUGUST,1));

    }

    @Test //2 months until semester start...
    public void monthsTest1() throws ParseException {
        sCalendar = semester.getStartDate();
        tCalendar = teacher.getCurrentDate();

        when(teacher.getMonthDiffirence(teacher.getCurrentDate(), semester.getStartDate())) //2
                .thenReturn(Period.between(
            tCalendar.withDayOfMonth(1),
            sCalendar.withDayOfMonth(1)).getMonths());

        assertThat(2, equalTo(teacher.getMonthDiffirence(teacher.getCurrentDate(), semester.getStartDate()))); //3

        verify(teacher, times(3)).getCurrentDate();
        verify(semester, times(3)).getStartDate();
    }

    @Test //1 month until semester start...
    public void monthsTest2() throws ParseException {
        sCalendar = semester.getStartDate();
        tCalendar = teacher.getCurrentDate().plusMonths(1);

        when(teacher.getMonthDiffirence(teacher.getCurrentDate(), semester.getStartDate())) //2
                .thenReturn(Period.between(
            tCalendar.withDayOfMonth(1),
            sCalendar.withDayOfMonth(1)).getMonths());

        assertThat(1, equalTo(teacher.getMonthDiffirence(teacher.getCurrentDate(), semester.getStartDate()))); //3

        verify(teacher, times(6)).getCurrentDate();
        verify(semester, times(6)).getStartDate();
    }
    @Test //amount of days for planning deadline... (1 month after planning-start)
    public void monthsTest3() {
        sCalendar = semester.getStartDate().minusMonths(1);
        tCalendar = teacher.getCurrentDate()/*.plusDays(1)*/;
        int days = (int) DAYS.between(tCalendar, sCalendar);
        System.out.println("you have " + days + " days left");
        assertThat(30, equalTo(days));
    }
}
