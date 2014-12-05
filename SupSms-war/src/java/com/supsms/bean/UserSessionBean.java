/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supsms.bean;

import com.supsms.dao.UserDao;
import com.supsms.entity.UserEntity;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author xavierrouayroux
 */
@Stateless
@LocalBean
public class UserSessionBean {

    @EJB
    UserDao userDao;
    
    public UserEntity getUserDao() {
        return userDao.getById(1L);
    }
}
