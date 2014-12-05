/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supsms.jpa;

import com.supsms.dao.SmsDao;
import com.supsms.entity.SmsEntity;
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
public class SmsJpa implements SmsDao{
    
    public EntityManagerFactory emf;
    @PersistenceContext
    public EntityManager em;
    public SmsEntity sms;
    public Collection<SmsEntity> allSms;

    @Override
    public SmsEntity getById(Long id) {
        sms = em.find(SmsEntity.class, id);
        return sms;
    }
    
    @Override
    public Collection<SmsEntity> getAll() {
        return  em.createQuery("SELECT u FROM SmsEntity u ").getResultList();
    }
    
    @Override
    public void add(SmsEntity objToAdd) {
        em.persist(objToAdd);
        em.flush();
    }
    
    @Override
    public void update (SmsEntity objToUpdate) {
        em.merge(objToUpdate);
        em.flush();
    }
    
    @Override
    public SmsEntity getOneByArrayOfParam(Map array) {
        String str = "SELECT obj FROM SmsEntity obj WHERE ";
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
        
        return (SmsEntity) newQuery.getSingleResult();
    }
    
    @Override
    public void delete(SmsEntity objToDelete) {
        em.remove(objToDelete);
        em.flush();
    }
}



