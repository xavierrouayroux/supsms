/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supsms.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;
import static javax.persistence.TemporalType.TIMESTAMP;

/**
 *
 * @author xavierrouayroux
 */
@Entity
@Table(name ="conversation")
public class ConversationEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="created_at")
    @Temporal(TIMESTAMP)
    private Date createdAt;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    private UserEntity user;
    
    @OneToMany(mappedBy = "conversation")
    private Collection <SmsEntity> smss;
    
    @OneToOne
    @JoinColumn(name = "contact_id", nullable = true)
    private ContactEntity contact;
    
    public void setContact(ContactEntity newContact) {
        contact = newContact;
    }
    
    public ContactEntity getContact() {
        return contact;
    }
    
    public Collection <SmsEntity> getSmss() {
        return smss;
    }
    
    public void addSmss(SmsEntity newSms) {
        smss.add(newSms);
    }
    
    public void setUser (UserEntity newUser) {
        user = newUser;
    }
    
    public UserEntity getUser() {
        return user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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
        if (!(object instanceof ConversationEntity)) {
            return false;
        }
        ConversationEntity other = (ConversationEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.supsms.entity.ConversationEntity[ id=" + id + " ]";
    }
    
}
