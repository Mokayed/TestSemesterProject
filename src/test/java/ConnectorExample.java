/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import data.Connector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;

/**
 *
 * @author hallur
 */
@RunWith(JUnitPlatform.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ConnectorExample {

    Connection conn;
    Connector connector;

    @BeforeAll
    public void getConnection() throws SQLException {
        conn = mock(Connection.class);
        connector = mock(Connector.class);
        Mockito.when(connector.getConnection()).thenReturn(
                DriverManager.getConnection("jdbc:mysql://localhost:3306/LESdb", "root", "123"));
    }

    @Test
    public void testUser() throws SQLException {
        Statement s = connector.getConnection().createStatement();
        ResultSet rs = s.executeQuery("select * from User");
        while (rs.next()) {
            if (rs.getString(2).equals("hallur")) {
                assertThat("student", is(rs.getString(4)));
            }
        }
    }
    @AfterAll
    public void cleanUp() throws SQLException{
    Statement s = connector.getConnection().createStatement();
        s.execute("truncate table User"); //we cant truncate, lets find a better way to clean in the end.
    }
}
