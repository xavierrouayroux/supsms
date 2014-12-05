/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supsms.jpa;

import com.supsms.dao.AddressDao;
import com.supsms.entity.AddressEntity;
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
public class AddressJpa implements AddressDao{
    
    public EntityManagerFactory emf;
    @PersistenceContext
    public EntityManager em;
    public AddressEntity address;
    public Collection<AddressEntity> allAddress;

    @Override
    public AddressEntity getById(Long id) {
        address = em.find(AddressEntity.class, id);
        return address;
    }
    
    @Override
    public Collection<AddressEntity> getAll() {
        return  em.createQuery("SELECT u FROM AddressEntity u ").getResultList();
    }
    
    @Override
    public void add(AddressEntity objToAdd) {
        em.persist(objToAdd);
        em.flush();
    }
    
    @Override
    public void update (AddressEntity objToUpdate) {
        em.merge(objToUpdate);
        em.flush();
    }
    
    @Override
    public AddressEntity getOneByArrayOfParam(Map array) {
        String str = "SELECT obj FROM AddressEntity obj WHERE ";
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
        
        return (AddressEntity) newQuery.getSingleResult();
    }
    
    @Override
    public void delete(AddressEntity objToDelete) {
        em.remove(objToDelete);
        em.flush();
    }
}
