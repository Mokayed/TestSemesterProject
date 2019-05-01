/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author hallur
 */
public class User{
    private String role;
    private String userName;
    private String password;
    private int age;

    public User(String role, String userName, String password, int age) {
        this.role = role;
        this.userName = userName;
        this.password = password;
        this.age = age;
    }

    public User(String role, String userName, String password) {
        this.role = role;
        this.userName = userName;
        this.password = password;
    }
    
    
    
}
