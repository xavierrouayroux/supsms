/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supsms.jpa;

import com.supsms.dao.PhoneNumberDao;
import com.supsms.entity.PhoneNumberEntity;
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
public class PhoneNumberJpa implements PhoneNumberDao{
    
    public EntityManagerFactory emf;
    @PersistenceContext
    public EntityManager em;
    public PhoneNumberEntity phoneNumber;
    public Collection<PhoneNumberEntity> allPhoneNumber;

    @Override
    public PhoneNumberEntity getById(Long id) {
        phoneNumber = em.find(PhoneNumberEntity.class, id);
        return phoneNumber;
    }
    
    @Override
    public Collection<PhoneNumberEntity> getAll() {
        return  em.createQuery("SELECT u FROM PhoneNumberEntity u ").getResultList();
    }
    
    @Override
    public void add(PhoneNumberEntity objToAdd) {
        em.persist(objToAdd);
        em.flush();
    }
    
    @Override
    public void update (PhoneNumberEntity objToUpdate) {
        em.merge(objToUpdate);
        em.flush();
    }
    
    @Override
    public PhoneNumberEntity getOneByArrayOfParam(Map array) {
        String str = "SELECT obj FROM PhoneNumberEntity obj WHERE ";
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
        
        return (PhoneNumberEntity) newQuery.getSingleResult();
    }
    
    @Override
    public void delete(PhoneNumberEntity objToDelete) {
        em.remove(objToDelete);
        em.flush();
    }
}


