/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import database.*;
import com.mysql.cj.jdbc.MysqlDataSource;

/**
 *
 * @author hallur
 */
public class TestDataSource {
    
    private MysqlDataSource dataSource = new MysqlDataSource();

    public TestDataSource() {
        try {
            dataSource.setServerName("localhost");
            dataSource.setPort(3306);

            dataSource.setDatabaseName("LESdbTest?allowPublicKeyRetrieval=true&useSSL=false");
            dataSource.setUser("user");
            dataSource.setPassword("1234");
            dataSource.setUseSSL(false);
            dataSource.setAllowMultiQueries(true);
            dataSource.setServerTimezone("UTC");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MysqlDataSource getDataSource() {
        return dataSource;
    }
}
