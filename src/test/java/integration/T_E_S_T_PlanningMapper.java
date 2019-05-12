/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import Entities.Semester;
import Entities.Teacher;
import Entities.User;
import database.DatabaseConnector;
import database.PlanningMapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import static java.time.temporal.ChronoUnit.DAYS;
import javax.sql.DataSource;
import static org.hamcrest.CoreMatchers.is;
import org.hamcrest.MatcherAssert;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author hallur
 */
@RunWith(JUnitPlatform.class)
public class T_E_S_T_PlanningMapper {
    private static PlanningMapper p = new PlanningMapper();
    private static Teacher teacher;
    private static User teacherUser;
    private static Semester semester;
    @BeforeAll
    public static void beforeAll() {
        teacher = mock(Teacher.class);
        teacherUser = teacher;
        semester = mock(Semester.class);
        p.setDataSource(new DataSourceMysql().getDataSource());
        when(teacher.getCurrentDate()).thenReturn(LocalDate.of(2019,Month.JUNE,1));
        when(teacherUser.getUserName()).thenReturn("Kasper");
        when(teacherUser.getPassword()).thenReturn("321");
        when(teacherUser.getRole()).thenReturn("teacher");
        when(semester.getStartDate()).thenReturn(LocalDate.of(2019,Month.AUGUST,1));
    }
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void insertTeacherAndSemester(){
            p.insertUser(teacherUser);
            p.insertSemester(semester);
            int userId = p.getPrimaryKeyIdFromTable("User");
            int semesterId = p.getPrimaryKeyIdFromTable("Semester");
            p.insertTeacher(teacher, userId, semesterId);
    }
    
    @Test
    public void testDaysDifference() {
        LocalDate teacher = p.getTeacherDate();
        LocalDate semester = p.getSemesterDate();
        assertThat(61L, is(DAYS.between(teacher, semester))); //61 days.
    }
}
