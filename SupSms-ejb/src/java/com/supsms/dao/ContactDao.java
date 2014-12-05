/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supsms.dao;

import com.supsms.entity.ContactEntity;
import java.util.Collection;
import java.util.Map;

/**
 *
 * @author xavierrouayroux
 */
public interface ContactDao {
    public ContactEntity getById(Long id);
    public Collection<ContactEntity> getAll();
    public void add(ContactEntity ObjAdd);
    public void update (ContactEntity objToUpdate);
    public ContactEntity getOneByArrayOfParam(Map array);
    public void delete(ContactEntity objToDelete);
}
