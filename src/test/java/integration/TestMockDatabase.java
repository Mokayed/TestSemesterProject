package integration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import entity.User;
import database.LoginMapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author MoK
 */
@RunWith(JUnitPlatform.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestMockDatabase {

    private static LoginMapper dataMapper;

    @BeforeAll
    public void getConnection() {
        DataSource dataSource = mock(DataSource.class);
        Connection connection = mock(Connection.class);
        PreparedStatement preparedStatement = mock(PreparedStatement.class);
        ResultSet resultSet = mock(ResultSet.class);

        try {
            when(dataSource.getConnection()).thenReturn(connection);
            when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
            when(preparedStatement.executeQuery()).thenReturn(resultSet);
            when(resultSet.next()).thenReturn(true);
            when(resultSet.getString("userName")).thenReturn("Hallur");
            when(resultSet.getString("password")).thenReturn("123");
            when(resultSet.getString("role")).thenReturn("Student");
        } catch (Exception e) {
            e.printStackTrace();
        }
        dataMapper = new LoginMapper();
        dataMapper.setDataSource(dataSource);

    }

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testStudentUser() throws SQLException {
        System.out.println("Test a student user....");
        //User user = dataMapper.getUser(1);
       // assertThat(user.getUserName(), is("Hallur"));
     //   assertThat(user.getRole(), is("Student"));
    }

}