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
@WebServlet(name = "ContactEditServlet", urlPatterns = {"/contact-edit"})
public class ContactEditServlet extends HttpServlet {

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
            String stringcontactId = request.getParameter("id");
            long contactId = new Long(stringcontactId);
            ContactEntity currentContact = contactJpa.getById(contactId);
            if (currentContact == null) {
                RequestDispatcher dis = getServletContext().getRequestDispatcher("/contact.jsp");
                dis.forward(request, response);
            }
            request.setAttribute("contact", currentContact);
        }catch (Exception ex) {
        ex.printStackTrace();
        }
        RequestDispatcher dis = getServletContext().getRequestDispatcher("/ContactEdit.jsp");
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
        String stringcontactId = request.getParameter("id");
        long contactId = new Long(stringcontactId);
        ContactEntity newContact = contactJpa.getById(contactId);
        UserEntity currentUser = (UserEntity)request.getSession().getAttribute("UtilisateurConnecte");
        PhoneNumberEntity phoneNumber = newContact.getPhoneNumber();
        AddressEntity address = newContact.getAddress();
        
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
        
        addressJpa.update(address);
        phoneNumberJpa.update(phoneNumber);
        contactJpa.update(newContact);
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
        }catch (Exception ex) {
        ex.printStackTrace();
        }
        RequestDispatcher dis = getServletContext().getRequestDispatcher("/contact.jsp");
        dis.forward(request, response);
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
