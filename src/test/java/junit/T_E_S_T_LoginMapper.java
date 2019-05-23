/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junit;

import entity.User;
import database.TestDataSource;
import servlet.ServletForwarding;
import database.LoginMapper;
import java.sql.SQLException;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;

/**
 *
 * @author MoK
 */
public class T_E_S_T_LoginMapper {

    LoginMapper lm;

    public T_E_S_T_LoginMapper() {
        lm = new LoginMapper();
        lm.setDataSource(new TestDataSource().getDataSource());
    }
    @Test
    public void testGetStudentUser() throws SQLException {
        String expResult = "Student";
        User user = lm.getUser("Hallur", "123");
        assertThat(user.getRole(), equalTo(expResult));
    }

    @Test
    public void testGetNoUser() throws SQLException {
        User user = lm.getUser("Hallur", "122q34qw233");
        assertThat(user, equalTo(null));
    }
    
    @Test
    public void testGetTeachertUser() throws SQLException {

        String expResult = "Teacher";
        User user = lm.getUser("Kasper", "123");
        assertThat(user.getRole(), equalTo(expResult));
    }

    @Test
    public void testGetAdmintUser() throws SQLException {

        String expResult = "Admin";
        User user = lm.getUser("Mo", "1234");
        assertThat(user.getRole(), equalTo(expResult));
    }

    @Test
    public void testNavigatesTeacher() {
        ServletForwarding lg = new ServletForwarding();
        String expResult = "/TestSemesterProject/TeacherServlet";
        String result = lg.Login("Teacher");
        assertThat(result, equalTo(expResult));

    }

    @Test
    public void testNavigatesStudent() {
        ServletForwarding lg = new ServletForwarding();
        String expResult = "studentPage.jsp";
        String result = lg.Login("Student");
        assertThat(result, equalTo(expResult));

    }

    @Test
    public void testNavigatesAdmin() {
        ServletForwarding lg = new ServletForwarding();
        String expResult = "adminPage.jsp";
        String result = lg.Login("Admin");
        assertThat(result, equalTo(expResult));

    }

}