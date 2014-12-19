/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supsms.servlet;

import com.sun.xml.ws.security.impl.policy.Constants;
import com.supsms.dao.ContactDao;
import com.supsms.dao.ConversationDao;
import com.supsms.dao.SmsDao;
import com.supsms.entity.ContactEntity;
import com.supsms.entity.ConversationEntity;
import com.supsms.entity.UserEntity;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.util.Collection;
import java.util.Date;
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
    private ContactDao contactJpa;
    
    @EJB
    private ConversationDao conversationJpa;
    
    @EJB
    private SmsDao smsJpa;

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
        try {
            /* TODO output your page here. You may use following sample code. */
            UserEntity currentUser = (UserEntity)request.getSession().getAttribute("UtilisateurConnecte");
            if (currentUser == null) {
                RequestDispatcher dis = getServletContext().getRequestDispatcher("/login.jsp");
                dis.forward(request, response);
            } else {
                request.setAttribute("contacts", currentUser.getContacts());
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
        if (request.getParameter("id") != null) {
            Long conversationId = new Long(request.getParameter("id"));
            conversationJpa.delete(conversationId);
        }
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
        ConversationEntity ce = new ConversationEntity();
        String test = request.getParameter("contactSelect");
        String phone = request.getParameter("phone");
        if ("none".equals(request.getParameter("contactSelect")) || !"".equals(request.getParameter("phone"))) {
            ce.setPhoneNumber(request.getParameter("phone"));
            ce.setContact(null);
        } else {
            Long idContact = new Long(request.getParameter("contactSelect"));
            ContactEntity contact = contactJpa.getById(idContact);
            ce.setContact(contact);
            ce.setPhoneNumber(null);
        }
        ce.setUser((UserEntity)request.getSession().getAttribute("UtilisateurConnecte"));
        ce.setCreatedAt(new Date());
        conversationJpa.add(ce);
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
