package Servlets;

import Entities.User;
import database.DataSource1;
import database.LogicForLogin;
import database.LoginMapper;
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
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {;
        LoginMapper lm = new LoginMapper();
        lm.setDataSource(new DataSource1().getDataSource());
        boolean susuccessfulLogin;
        try {
            String usernameInput = request.getParameter("un");
            String passwordInput = request.getParameter("pw");
            susuccessfulLogin = lm.checkUser(usernameInput, passwordInput);
            if (susuccessfulLogin == true) {
                User user = lm.getUser(usernameInput, passwordInput);
                HttpSession session = request.getSession();
                session.setAttribute("currentSessionUser", usernameInput);
                session.setAttribute("userRole", user.getRole());
                LogicForLogin lge = new LogicForLogin();
                String role = lge.Login(user.getRole());
                response.sendRedirect(role);
            } else {
                response.sendRedirect("invalidLogin.jsp"); //error page 
            }
        } catch (Throwable theException) {
            System.out.println(theException);
        }
    }
}
