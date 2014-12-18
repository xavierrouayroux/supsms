/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supsms.servlet;

import com.supsms.entity.AddressEntity;
import com.supsms.entity.ContactEntity;
import com.supsms.entity.PhoneNumberEntity;
import com.supsms.entity.UserEntity;
import com.supsms.jpa.AddressJpa;
import com.supsms.jpa.ContactJpa;
import com.supsms.jpa.PhoneNumberJpa;
import com.supsms.jpa.UserJpa;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author xavierrouayroux
 */
@WebServlet(name = "ContactServlet", urlPatterns = {"/contact"})
public class ContactServlet extends HttpServlet {
    
    @EJB
    private ContactJpa contactJpa;
    
    @EJB
    private UserJpa userJpa;
    
    @EJB
    private PhoneNumberJpa phoneNumberJpa;
    
    @EJB
    private AddressJpa addressJpa;

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
            Collection<ContactEntity> contactList;
            contactList = contactJpa.getAll();
            while (contactList.iterator().hasNext()) {
              ContactEntity currentContact = contactList.iterator().next();
              if (currentContact.getUser().getId() != currentUser.getId()) {
                  contactList.remove(currentContact);
              }
            }
            request.setAttribute("contacts", contactList);
        }
        catch (Exception ex) {
        ex.printStackTrace();
        }
        RequestDispatcher dis = getServletContext().getRequestDispatcher("/contact.jsp");
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
        ContactEntity newContact = new ContactEntity();
        UserEntity currentUser = (UserEntity)request.getSession().getAttribute("UtilisateurConnecte");
        PhoneNumberEntity phoneNumber = new PhoneNumberEntity();
        AddressEntity address = new AddressEntity();
        
        newContact.setFirstName(request.getParameter("firstName"));
        newContact.setLastName(request.getParameter("lastName"));
        newContact.setEmail(request.getParameter("email"));
        newContact.setUser(currentUser);
        
        address.setAddress1(request.getParameter("address1"));
        address.setAddress2(request.getParameter("address2"));
        address.setPostalCode(request.getParameter("postalCode"));
        address.setCity(request.getParameter("city"));
        address.setCountry(request.getParameter("country"));
        
        phoneNumber.setNumber(request.getParameter("number"));
        
        addressJpa.add(address);
        phoneNumberJpa.add(phoneNumber);
        contactJpa.add(newContact);
        
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
