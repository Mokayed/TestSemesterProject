/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hallur
 */
public class Subject {

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User("        List<User> list = new ArrayList<>();\n" +
"        String p = null;Student", "Lasse", "123", 23, true));
        list.add(new User("Teacher", "Kasper", "321", "20-05-2010", "experiance in danish langouge"));
        for (User user : list) {
            if (user.getUserName().equals("Kasper") && user.getPassword().equals("321")) {
                System.out.println("her...");
                if (user.getRole().equals("Student")) {
                    System.out.println(user.getUserName());
                }
                if (user.getRole().equals("Teacher")) {
                    System.out.println(user.getUserName());
                }
            }
        }

    }
}
