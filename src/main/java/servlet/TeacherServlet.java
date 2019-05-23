/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.Teacher;
import database.ProductionDataSource;
import database.TestDataSource;
import database.PlanningMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.concurrent.TimeUnit;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 *
 * @author hallur
 */
@WebServlet(name = "TeacherServlet", urlPatterns = {"/TeacherServlet"})
public class TeacherServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String dbPick = (String) session.getAttribute("dbPick");
        PlanningMapper pm = new PlanningMapper();
        if(dbPick.equals("production")){
        pm.setDataSource(new ProductionDataSource().getDataSource());
        }
        if(dbPick.equals("test")){
        pm.setDataSource(new TestDataSource().getDataSource());
        }
        Teacher teacher = pm.getTeacher((String) session.getAttribute("currentSessionUser"));
        LocalDate semesterDeadline = teacher.getSemester().getStartDate().minusMonths(1);
        int deadlineDays = (int) DAYS.between(teacher.getCurrentDate(), semesterDeadline);
        request.setAttribute("teacher", teacher);
        request.setAttribute("deadline", semesterDeadline);
        request.setAttribute("deadlineDays", deadlineDays);
        RequestDispatcher rd = request.getRequestDispatcher("teacherPage.jsp");
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
