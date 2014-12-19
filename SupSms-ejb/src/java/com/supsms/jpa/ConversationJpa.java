/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supsms.jpa;

import com.supsms.dao.ConversationDao;
import com.supsms.entity.ConversationEntity;
import com.supsms.entity.UserEntity;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author xavierrouayroux
 */
@Stateless
public class ConversationJpa implements ConversationDao{
    
    public EntityManagerFactory emf;
    @PersistenceContext
    public EntityManager em;
    public ConversationEntity conversation;
    public Collection<ConversationEntity> allConversation;

    @Override
    public ConversationEntity getById(Long id) {
        conversation = em.find(ConversationEntity.class, id);
        return conversation;
    }
    
    @Override
    public Collection<ConversationEntity> getAll() {
        return  em.createQuery("SELECT u FROM ConversationEntity u ").getResultList();
    }
    
    @Override
    public void add(ConversationEntity objToAdd) {
        em.persist(objToAdd);
        em.flush();
    }
    
    @Override
    public void update (ConversationEntity objToUpdate) {
        em.merge(objToUpdate);
        em.flush();
    }
    
    @Override
    public ConversationEntity getOneByArrayOfParam(Map array) {
        String str = "SELECT obj FROM ConversationEntity obj WHERE ";
        Iterator<Map.Entry<Integer, String>> it = array.entrySet().iterator();
        boolean isFirstParam = true;
        
        while (it.hasNext()) {    
            Map.Entry<Integer, String> entry = it.next();
            if (isFirstParam) {
                str +="obj.";
                str +=entry.getKey();
                str +="='";
                str +=entry.getValue();
                str +="'";
                isFirstParam = false;
            } else {
                str +="AND obj.";
                str +=entry.getKey();
                str +="='";
                str +=entry.getValue();
                str +="'";
            }
        }
        
        Query newQuery = em.createQuery(str);
        
        return (ConversationEntity) newQuery.getSingleResult();
    }
    
    @Override
    public void delete(Long objToDeleteId) {
        em.remove(em.find(ConversationEntity.class, objToDeleteId));
        em.flush();
    }
    
    @Override
    public Collection<ConversationEntity> getAllForAnUserOrderByDate(UserEntity user){
        return  em.createQuery("SELECT u FROM ConversationEntity u WHERE u.user=:user ORDER BY u.lastSms DESC, u.createdAt DESC").setParameter("user", user).getResultList();
    }
}

