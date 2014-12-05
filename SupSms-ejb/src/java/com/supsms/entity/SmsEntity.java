/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supsms.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.TIMESTAMP;

/**
 *
 * @author xavierrouayroux
 */
@Entity
@Table(name ="sms")
public class SmsEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="date_send")
    @Temporal(TIMESTAMP)
    private Date dateSend;
    
    @Column(name="content")
    private String content;
    
    @ManyToOne
    @JoinColumn(name = "conversation_id", nullable = true)
    private ConversationEntity conversation;
    
    @OneToOne
    @JoinColumn(name = "number_send", nullable = false)
    private PhoneNumberEntity numberSend;
    
    @OneToOne
    @JoinColumn(name = "number_receive", nullable = false)
    private PhoneNumberEntity numberReceive;
    
    public void setNumberReceive(PhoneNumberEntity newNumberReceive) {
        numberReceive = newNumberReceive;
    }
    
    public PhoneNumberEntity getNumberReceive() {
        return numberReceive;
    }
    
    public PhoneNumberEntity getNumberSend() {
        return numberSend;
    }
    
    public void setNumberSend(PhoneNumberEntity newNumberSend) {
        numberSend = newNumberSend;
    }
    
    public ConversationEntity getConversation() {
        return conversation;
    }
    
    public void setConversation (ConversationEntity newConversation) {
        conversation = newConversation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateSend() {
        return dateSend;
    }

    public void setDateSend(Date dateSend) {
        this.dateSend = dateSend;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        if (!(object instanceof SmsEntity)) {
            return false;
        }
        SmsEntity other = (SmsEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String str = this.getNumberSend().getNumber();
        str +="\n\r";
        str += this.getContent();
        str +="\n\r";
        str += this.getNumberReceive().getNumber();
        return str;
    }
    
}
