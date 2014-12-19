/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supsms.servlet;

import com.supsms.entity.UserEntity;
import com.supsms.jpa.UserJpa;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
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
public class EditServlet extends HttpServlet {

    @EJB
    UserJpa userJpa;
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
        response.sendRedirect(request.getContextPath() + "/EditProfile");
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
        try {
            //Récupère l'utilisateur connecté
            UserEntity updateUser = (UserEntity)request.getSession().getAttribute("UtilisateurConnecte");

            //Modifie seulement les valeurs qui ont été renseignés
            if (!"".equals(request.getParameter("first_name"))) {
                updateUser.setFirstName(request.getParameter("first_name"));
            }
            if (!"".equals(request.getParameter("last_name"))) {
                updateUser.setLastName(request.getParameter("last_name"));
            }
            if (!"".equals(request.getParameter("pwd"))) {
                updateUser.setPassword(request.getParameter("pwd"));
            }
            if (!"".equals(request.getParameter("mail"))) {
                updateUser.setEmail(request.getParameter("mail"));
            }
            if (!"".equals(request.getParameter("phone"))) {
                updateUser.getPhoneNumber().setNumber(request.getParameter("phone"));
            }
            
            //Met à jour l'utilisateur
            userJpa.update(updateUser);
            
            //Met à jour la variable de session
            request.getSession().setAttribute("UtilisateurConnecte", updateUser);
            
            //Réactualise la page
            response.sendRedirect(request.getContextPath() + "/EditProfile");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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
