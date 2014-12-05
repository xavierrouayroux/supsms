/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supsms.dao;

import com.supsms.entity.AddressEntity;
import java.util.Collection;
import java.util.Map;

/**
 *
 * @author xavierrouayroux
 */
public interface AddressDao {
    public AddressEntity getById(Long id);
    public Collection<AddressEntity> getAll();
    public void add(AddressEntity ObjAdd);
    public void update (AddressEntity objToUpdate);
    public AddressEntity getOneByArrayOfParam(Map array);
    public void delete(AddressEntity objToDelete);
}
