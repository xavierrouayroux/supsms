/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supsms.dao;

import com.supsms.entity.ConversationEntity;
import com.supsms.entity.UserEntity;
import java.util.Collection;
import java.util.Map;

/**
 *
 * @author xavierrouayroux
 */
public interface ConversationDao {
    public ConversationEntity getById(Long id);
    public Collection<ConversationEntity> getAll();
    public void add(ConversationEntity ObjAdd);
    public void update (ConversationEntity objToUpdate);
    public ConversationEntity getOneByArrayOfParam(Map array);
    public void delete(Long objToDeleteId);
    public Collection<ConversationEntity> getAllForAnUserOrderByDate(UserEntity user);
}

