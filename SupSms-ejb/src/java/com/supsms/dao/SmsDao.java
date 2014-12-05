/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supsms.dao;

import com.supsms.entity.SmsEntity;
import java.util.Collection;
import java.util.Map;

/**
 *
 * @author xavierrouayroux
 */
public interface SmsDao {
    public SmsEntity getById(Long id);
    public Collection<SmsEntity> getAll();
    public void add(SmsEntity ObjAdd);
    public void update (SmsEntity objToUpdate);
    public SmsEntity getOneByArrayOfParam(Map array);
    public void delete(SmsEntity objToDelete);
}



