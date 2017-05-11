/**
 * @(#)UserDataStore.java
 *
 * @author huawei
 * @version 1.0 2015-2-4
 *
 */
package com.alonelaval.struts1plus.examples.business;

import java.util.ArrayList;
import java.util.List;

import com.alonelaval.struts1plus.examples.entity.TbPerson;



/**
 * 
 * Purpose:
 * 
 * @see	    
 * @since   1.1.0
 */
public class UserDataStore
{
    public final static List<TbPerson> users =new ArrayList<TbPerson>();
    static{
        for (int i = 0; i <10; i++)
        {
            TbPerson person = new TbPerson();
            person.setPersonId(i);
            person.setPersonEmail(i+"63@"+i+"63.com");
            person.setDeviceId(i+"");
            person.setPersonIdCard("1111111111111111");
            person.setPersonMobile("1380000000"+i);
            person.setPersonName("小"+i);
            users.add(person);
        }
    }
    
    public static  void update(TbPerson person){
        TbPerson u = null;
        for (TbPerson user : users)
        {
            if(person.getPersonId().equals(user.getPersonId())){
                u = user;
            }
        }
        users.remove(u);
        users.add(person);
    }
    public static void delete(TbPerson person) {
        
        for (TbPerson user : users)
        {
            if(person.getPersonId().equals(user.getPersonId())){
                person = user;
            }
        }
        users.remove(person);
    }
    public static List<TbPerson> getUsers(){
        return users;
    }
    public static void addUser(TbPerson person){
        users.add(person);
    }
    public static TbPerson geTbPerson(TbPerson person){
        for (TbPerson user : users)
        {
            if(person.getPersonId().equals(user.getPersonId())){
                return user;
            }
        }
        return null;
    }
    
}


/**
 * $Log: UserDataStore.java,v $
 * 
 * @version 1.0 2015-2-4 
 *
 */