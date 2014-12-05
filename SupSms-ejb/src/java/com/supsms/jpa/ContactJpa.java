/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supsms.jpa;

import com.supsms.dao.ContactDao;
import com.supsms.dao.UserDao;
import com.supsms.entity.ContactEntity;
import com.supsms.entity.UserEntity;
import java.util.Collection;
import java.util.Hashtable;
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
public class ContactJpa implements ContactDao{
    
    public EntityManagerFactory emf;
    @PersistenceContext
    public EntityManager em;
    public ContactEntity contact;
    public Collection<UserEntity> allUser;

    @Override
    public ContactEntity getById(Long id) {
        contact = em.find(ContactEntity.class, id);
        return contact;
    }
    
    @Override
    public Collection<ContactEntity> getAll() {
        return  em.createQuery("SELECT c FROM ContactEntity c ").getResultList();
    }
    
    @Override
    public void add(ContactEntity objToAdd) {
        em.persist(objToAdd);
        em.flush();
    }
    
    @Override
    public void update (ContactEntity objToUpdate) {
        em.merge(objToUpdate);
        em.flush();
    }
    
    @Override
    public ContactEntity getOneByArrayOfParam(Map array) {
        String str = "SELECT obj FROM ContactEntity obj WHERE";
        Iterator<Map.Entry<Integer, String>> it = array.entrySet().iterator();
        boolean isFirstParam = true;
        
        while (it.hasNext()) {    
            Map.Entry<Integer, String> entry = it.next();
            if (isFirstParam) {
                str +="obj.";
                str +=entry.getKey();
                str +="=";
                str +=entry.getValue();
                isFirstParam = false;
            } else {
                str +="AND obj.";
                str +=entry.getKey();
                str +="=";
                str +=entry.getValue();
            }
        }
        
        Query newQuery = em.createQuery(str);
        
        return (ContactEntity) newQuery.getSingleResult();
    }
    
    @Override
    public void delete(ContactEntity objToDelete) {
        em.remove(objToDelete);
    }
}
