/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import com.mysql.cj.jdbc.MysqlDataSource;

/**
 *
 * @author hallur
 */
public class DataSourceMysql {
    private MysqlDataSource dataSource = new MysqlDataSource();
    
    public DataSourceMysql()
    {
        try
        {
            dataSource.setServerName("localhost");
            dataSource.setPort(3306);
            dataSource.setDatabaseName("LESdb?allowPublicKeyRetrieval=true&useSSL=false");
            dataSource.setUser("root");
            dataSource.setPassword("123");
            dataSource.setUseSSL(false);
            dataSource.setAllowMultiQueries(true);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public MysqlDataSource getDataSource()
    {
        return dataSource;
}
}
