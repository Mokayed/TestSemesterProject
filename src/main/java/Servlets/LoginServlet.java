package Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
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

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {

        try {
            String userName = "student@student.com";
            String password = "123";

            if (request.getParameter("un").contains("@student") && request.getParameter("pw").equals(password)) {
                //HttpSession session = request.getSession(true);       
                response.sendRedirect("studentPage.jsp");      		
            }
              if (request.getParameter("un").contains("@teacher") && request.getParameter("pw").equals(password)) {
                //HttpSession session = request.getSession(true);       
                response.sendRedirect("teacherPage.jsp");      		
            }
                if (request.getParameter("un").contains("@admin") && request.getParameter("pw").equals(password)) {
                //HttpSession session = request.getSession(true);       
                response.sendRedirect("adminPage.jsp");    		
            }
            else {
                response.sendRedirect("invalidLogin.jsp"); //error page 
            }
        } catch (Throwable theException) {
            System.out.println(theException);
        }
    }
}
