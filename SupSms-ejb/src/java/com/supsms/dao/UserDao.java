/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supsms.dao;

import com.supsms.entity.UserEntity;
import java.util.Collection;
import java.util.Map;

/**
 *
 * @author xavierrouayroux
 */
public interface UserDao {
    public UserEntity getById(Long id);
    public Collection<UserEntity> getAll();
    public void add(UserEntity ObjAdd);
    public void update (UserEntity objToUpdate);
    public UserEntity getOneByArrayOfParam(Map array);
    public void delete(UserEntity objToDelete);
    public UserEntity getByLoginAndMdp(String login, String mdp);
}
