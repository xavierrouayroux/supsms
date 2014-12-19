/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supsms.servlet;

import com.supsms.dao.ConversationDao;
import com.supsms.dao.PhoneNumberDao;
import com.supsms.dao.SmsDao;
import com.supsms.entity.ConversationEntity;
import com.supsms.entity.PhoneNumberEntity;
import com.supsms.entity.SmsEntity;
import com.supsms.entity.UserEntity;
import java.io.IOException;
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
 * @author fabien
 */
public class ConversationServlet extends HttpServlet {
    
    @EJB
    SmsDao smsdao;
    
    @EJB
    ConversationDao conversationDao;

    @EJB
    PhoneNumberDao phoneNumberDao;
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
            } 
            ConversationEntity convers = (ConversationEntity) request.getSession().getAttribute("conversation");
            ConversationEntity refreshConvers = conversationDao.getById(convers.getId());
            request.setAttribute("smsList", refreshConvers.getSms());
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        RequestDispatcher dis = getServletContext().getRequestDispatcher("/conversation.jsp");
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
        if (request.getParameter("content") != null) {
            ConversationEntity convers = (ConversationEntity) request.getSession().getAttribute("conversation");
            SmsEntity newSms = new SmsEntity();
            newSms.setConversation((ConversationEntity) request.getSession().getAttribute("conversation"));
            newSms.setDateSend(new Date());
            if (newSms.getConversation().getContact() != null) {
                newSms.setNumberReceive(newSms.getConversation().getContact().getPhoneNumber());
            } else {
                
                if (!convers.getSms().isEmpty()) {
                    SmsEntity se = convers.getSms().iterator().next();
                    newSms.setNumberReceive(se.getNumberReceive());
                } else {
                    PhoneNumberEntity pne = new PhoneNumberEntity();
                    pne.setNumber(newSms.getConversation().getPhoneNumber());
                    phoneNumberDao.add(pne);
                    newSms.setNumberReceive(pne);
                }
            }
            newSms.setContent(request.getParameter("content"));
            newSms.setNumberSend(newSms.getConversation().getUser().getPhoneNumber());

            //smsdao.add(newSms);
            convers.addSms(newSms);
            convers.setLastSms(new Date());
            conversationDao.update(convers);
        }
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
