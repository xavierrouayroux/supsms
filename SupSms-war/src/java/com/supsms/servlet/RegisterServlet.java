/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supsms.servlet;


import com.supsms.dao.PhoneNumberDao;
import com.supsms.entity.ContactEntity;
import com.supsms.entity.PhoneNumberEntity;
import com.supsms.entity.UserEntity;
import com.supsms.jpa.UserJpa;
import java.io.IOException;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fabien
 */
@Stateless
public class RegisterServlet extends HttpServlet {
    @EJB
    private UserJpa userJpa;
    @EJB
    private PhoneNumberDao phoneNumberJpa;
    

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
        String info = request.getParameter("username");
        try {
            UserEntity newUser = new UserEntity();
            newUser.setUserName(request.getParameter("username"));
            newUser.setFirstName(request.getParameter("first_name"));
            newUser.setLastName(request.getParameter("last_name"));
            newUser.setPassword(request.getParameter("pwd"));
            newUser.setEmail(request.getParameter("mail"));
            newUser.setIsAdmin(Boolean.FALSE);
            
            PhoneNumberEntity pne = new PhoneNumberEntity();
            pne.setNumber(request.getParameter("phone"));
            
            phoneNumberJpa.add(pne);
            newUser.setPhoneNumber(pne);
            
            userJpa.add(newUser);
            //info = newUser.toString();
            request.getSession().setAttribute("UtilisateurConnecte", newUser);
        } catch (Exception ex) { //info = ex.toString();
            ex.printStackTrace();
        }
        //String message = "You can now log in to SupSMS !";
        //request.setAttribute("message", message);
        request.setAttribute("message", info);
        RequestDispatcher dis = getServletContext().getRequestDispatcher("/login.jsp");
        dis.forward(request, response);
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
