/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supsms.servlet;

import com.supsms.entity.ContactEntity;
import com.supsms.entity.ConversationEntity;
import com.supsms.entity.UserEntity;
import com.supsms.jpa.ContactJpa;
import com.supsms.jpa.ConversationJpa;
import com.supsms.jpa.SmsJpa;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author xavierrouayroux
 */
public class MainServlet extends HttpServlet {
    @EJB
    private ContactJpa contactJpa;
    
    @EJB
    private ConversationJpa conversationJpa;
    
    @EJB
    private SmsJpa smsJpa;

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            UserEntity currentUser = (UserEntity)request.getSession().getAttribute("UtilisateurConnecte");
            if (currentUser == null) {
                RequestDispatcher dis = getServletContext().getRequestDispatcher("/login.jsp");
                dis.forward(request, response);
            }
            Collection<ConversationEntity> conversList;
            conversList = conversationJpa.getAllForAnUserOrderByDate(currentUser);
            request.setAttribute("conversations", conversList);
        }catch (Exception ex) {
        ex.printStackTrace();
        }
        RequestDispatcher dis = getServletContext().getRequestDispatcher("/main.jsp");
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
