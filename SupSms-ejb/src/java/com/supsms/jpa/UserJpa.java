/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supsms.jpa;

import com.supsms.dao.UserDao;
import com.supsms.entity.ContactEntity;
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
public class UserJpa implements UserDao{
    
    public EntityManagerFactory emf;
    @PersistenceContext
    public EntityManager em;
    public UserEntity user;
    public Collection<UserEntity> allUser;

    @Override
    public UserEntity getById(Long id) {
        user = em.find(UserEntity.class, id);
        return user;
    }
    
    @Override
    public Collection<UserEntity> getAll() {
        return  em.createQuery("SELECT u FROM UserEntity u ").getResultList();
    }
    
    @Override
    public void add(UserEntity objToAdd) {
        em.persist(objToAdd);
        em.flush();
    }
    
    @Override
    public void update (UserEntity objToUpdate) {
        em.merge(objToUpdate);
        em.flush();
    }
    
    @Override
    public UserEntity getOneByArrayOfParam(Map array) {
        String str = "SELECT obj FROM UserEntity obj WHERE ";
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
        
        return (UserEntity) newQuery.getSingleResult();
    }
    
    @Override
    public void delete(UserEntity objToDelete) {
        em.remove(objToDelete);
        em.flush();
    }
}
