/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supsms.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author xavierrouayroux
 */
@Entity
@Table(name ="contact")
public class ContactEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="first_name")
    private String firstName;
    
    @Column(name="last_name")
    private String lastName;
    
    @Column(name="email")
    private String email;
    
    @OneToOne
    @JoinColumn(name="address_id", nullable = true)
    private AddressEntity address;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    private UserEntity user;
    
    @OneToOne
    @JoinColumn(name = "phone_number_id", nullable = false)
    private PhoneNumberEntity phoneNumber;
    
    public void setPhoneNumber(PhoneNumberEntity newPhoneNumber) {
        phoneNumber = newPhoneNumber;
    }
    
    public PhoneNumberEntity getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setUser(UserEntity newUser) {
        user = newUser;
    }
    
    public UserEntity getUser() {
        return user;
    }
    
    public void setAddress(AddressEntity newAddress) {
        address = newAddress;
    }
    
    public AddressEntity getAddress() {
        return address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactEntity)) {
            return false;
        }
        ContactEntity other = (ContactEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.supsms.entity.ContactEntity[ id=" + id + " ]";
    }
    
}
