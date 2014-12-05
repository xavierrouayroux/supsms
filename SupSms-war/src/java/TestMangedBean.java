/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.supsms.dao.UserDao;
import com.supsms.entity.UserEntity;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author xavierrouayroux
 */
@Named(value = "testMangedBean")
@Dependent
@ManagedBean
public class TestMangedBean {

    /**
     * Creates a new instance of TestMangedBean
     */
    public TestMangedBean() {
    }
    
    @EJB
    UserDao userDao;
    
    public UserEntity getUserDao() {
//        UserEntity test = new UserEntity();
//        test.setEmail("testphone");
//        test.setFirstName("prenom2");
//        test.setIsAdmin(false);
//        test.setLastName("nom");
//        test.setPassword("password");
//        test.setSubscription("10E/mois");
//        test.setUserName("user name");
//        userDao.add(test);
        
        Map<String, String> m = new HashMap<>();
        m.put("firstName", "prenom");
        m.put("lastName", "nom");
       // return userDao.getById(1L);
        return userDao.getOneByArrayOfParam(m);
    }
    
}
