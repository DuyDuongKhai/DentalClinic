/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.users.UserDAO;
import sample.users.UserDTO;

/**
 *
 * @author SE150436 - Hoàng Quang Hòa
 */
public class UpdateDoctorInformationController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String DOCTOR_DETAIL_PAGE = "ViewDetailDoctorByIDController";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            int id = Integer.parseInt(request.getParameter("id"));
            String fullName = request.getParameter("fullName");
            int age = Integer.parseInt(request.getParameter("age"));
            String address = request.getParameter("address");
            String email = request.getParameter("email");
            int gender = Integer.parseInt(request.getParameter("gender"));
            String phoneNumber = request.getParameter("phoneNumber");
            String bio = request.getParameter("bio");
            String img = request.getParameter("img");
            UserDAO dao = new UserDAO();
            dao.updateUserDoc(id, age, address, email, gender, phoneNumber, fullName, bio,img);
            request.setAttribute("SUCCESS", "Update success !!!");
            url = DOCTOR_DETAIL_PAGE;
        } catch (Exception e) {
            log("Error at SearchController:" + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
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
