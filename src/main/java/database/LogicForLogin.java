/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import Entities.User;

/**
 *
 * @author MoK
 */
public class LogicForLogin {

    public String Login(String role) {
        LoginMapper lm = new LoginMapper();
        lm.setDataSource(new DataSource1().getDataSource());

        //User user = lm.getUser(userName);
        if (role.equals("Teacher")) {
            return "teacherPage.jsp";

        }
        if (role.equals("Student")) {
            return "studentPage.jsp";
        }
        if (role.equals("Admin")) {
            //HttpSession session = request.getSession(true);       
            return "adminPage.jsp";

        }
        return "worng";
    }

}
