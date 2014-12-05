/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supsms.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author xavierrouayroux
 */
@Entity
@Table(name ="user")
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="user_name")
    private String userName;
    
    @Column(name="first_name")
    private String firstName;
    
    @Column(name="last_name")
    private String lastName;
    
    @Column(name="email")
    private String email;
    
    @Column(name="password")
    private String password;
    
    @Column(name="subscription")
    private String subscription;
    
    @Column(name="is_admin")
    private Boolean isAdmin;
    
    @OneToMany(mappedBy="user")
    private Collection <PhoneNumberEntity> phoneNumbers;
    
    @OneToMany(mappedBy = "user")
    private Collection <ContactEntity> contacts;
    
    @OneToMany(mappedBy = "user")
    private Collection <ConversationEntity> conversations;
    
    public Collection <ConversationEntity> getConversations() {
        return conversations;
    }
    
    public void addConversation (ConversationEntity newConversation) {
        conversations.add(newConversation);
    }
    
    public Collection <ContactEntity> getContacts() {
        return contacts;
    }
    
    public void addContact(ContactEntity newContact) {
        contacts.add(newContact);
    }
    
    public Collection <PhoneNumberEntity> getPhoneNumbers(){
        return phoneNumbers;
    }
    
    public void addPhoneNumber(PhoneNumberEntity number) {
        phoneNumbers.add(number);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getUserName() {
        return this.userName;
    }
    public void setUserName(String username) {
        this.userName = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSubscription() {
        return subscription;
    }

    public void setSubscription(String subscription) {
        this.subscription = subscription;
    }

    public Boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserEntity)) {
            return false;
        }
        UserEntity other = (UserEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.supsms.entity.UserEntity[ id=" + id + " ]";
    }
    
}
