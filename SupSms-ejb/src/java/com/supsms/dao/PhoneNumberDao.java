/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supsms.dao;

import com.supsms.entity.PhoneNumberEntity;
import java.util.Collection;
import java.util.Map;

/**
 *
 * @author xavierrouayroux
 */
public interface PhoneNumberDao {
    public PhoneNumberEntity getById(Long id);
    public Collection<PhoneNumberEntity> getAll();
    public void add(PhoneNumberEntity ObjAdd);
    public void update (PhoneNumberEntity objToUpdate);
    public PhoneNumberEntity getOneByArrayOfParam(Map array);
    public void delete(PhoneNumberEntity objToDelete);
}


