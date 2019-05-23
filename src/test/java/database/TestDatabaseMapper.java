/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

/**
 *
 * @author hallur
 */
public class TestDatabaseMapper {

    private DatabaseConnector dbc = new DatabaseConnector();

    public void setDataSource(DataSource ds) {
        dbc.setDataSource(ds);
    }

    public void createTestDatabase() {
        try {
            dbc.open();
            FileReader fr = new FileReader(new File(System.getProperty("user.dir") + "/src/test/java/SqlScripts/LESTestDB.sql"));
            BufferedReader br = new BufferedReader(fr);
            String s = new String();
            StringBuffer sb = new StringBuffer();
            System.out.println("?");
            while ((s = br.readLine()) != null) {
                sb.append(s);
            }
            String[] inst = sb.toString().split(";");
             for(int i = 0; i<inst.length; i++)
            {
                // we ensure that there is no spaces before or after the request string
                // in order to not execute empty statements
                if(!inst[i].trim().equals(""))
                {
                    PreparedStatement p = dbc.preparedStatement(inst[i]);
                    System.out.println(">>"+inst[i]);
                    p.execute();
                }
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("?");
        }

    }
}
