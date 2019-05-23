/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.User;
import database.ProductionDataSource;
import database.LoginMapper;

/**
 *
 * @author MoK
 */
public class ServletForwarding {

    public String Login(String role) {
        LoginMapper lm = new LoginMapper();
        lm.setDataSource(new ProductionDataSource().getDataSource());

        //User user = lm.getUser(userName);
        if (role.equals("Teacher")) {
            return "/TestSemesterProject/TeacherServlet";

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
