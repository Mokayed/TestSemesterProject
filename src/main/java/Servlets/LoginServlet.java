package Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author MoK
 */
@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    List<User> list = new ArrayList<>();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
        List<User> list = new ArrayList<>();
        list.add(new User("Student", "Lasse", "123", 23, true));
        list.add(new User("Student", "Mo", "123", 23, true));
        list.add(new User("Student", "Hallur", "123", 23, true));
        list.add(new User("Teacher", "Kasper", "321", "20-05-2010", "experiance in danish langouge"));
        list.add(new User("Admin", "John", "321"));
        try {
            String usernameInput = request.getParameter("un");
            String passwordInput = request.getParameter("pw");
            //HttpSession session = request.getSession();
            for (User user : list) {
                if (user.getUserName().equals(usernameInput) && user.getPassword().equals(passwordInput)) {
                    if (user.getRole().equals("Teacher")) {
                        //HttpSession session = request.getSession(true);       
                        response.sendRedirect("teacherPage.jsp");
                        return;
                    }
                    if (user.getRole().equals("Student")) {
                        //HttpSession session = request.getSession(true);       
                        response.sendRedirect("studentPage.jsp");
                        return;
                    }
                    if (user.getRole().equals("Admin")) {
                        //HttpSession session = request.getSession(true);       
                        response.sendRedirect("adminPage.jsp");
                        return;
                    } else {
                        response.sendRedirect("invalidLogin.jsp"); //error page 
                        return;
                    }
                }
            }
        } catch (Throwable theException) {
            System.out.println(theException);
        }
    }
}
