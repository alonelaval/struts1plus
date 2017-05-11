/**
 * @(#)UserDataStore.java
 *
 * @author huawei
 * @version 1.0 2015-2-4
 *
 * Copyright (C) 2012,2015 , PING' AN, Inc.
 */
package com.alonelaval.struts1plus.examples.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.alonelaval.struts1plus.action.NewPage;
import com.alonelaval.struts1plus.examples.entity.TbPerson;



/**
 * 
 * Purpose:
 * 
 * @see	    
 * @since   1.1.0
 */
public class UserDataPageStore
{
    public final static List<TbPerson> users =new ArrayList<TbPerson>();
    static{
        for (int i = 0; i <21; i++)
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
    public static NewPage getUserByPage(NewPage page){
        List<TbPerson> list = new ArrayList<TbPerson>();
        int size = users.size();
        int begin = (page.getCurrentPage()-1) * page.getPageNum();
        int end = begin+page.getPageNum() <size ? begin+page.getPageNum(): size;
        sort(page.getOrderBy(), page.getIsAsc());
        for (; begin < end; begin++)
        {
            list.add(users.get(begin));
        }
        page.setTotalCount(size);
        page.setData(list);
        return page;
    }
    private static void sort(final String orderBy,final boolean isAsc){
        if(null == orderBy || orderBy.isEmpty())
            return;
        Collections.sort(users, new Comparator<TbPerson>(){
            public int compare(TbPerson o1, TbPerson o2)
            {
                if(orderBy.equals("person.personId")){
                    if(isAsc)
                        return o1.getPersonId().compareTo(o2.getPersonId());
                    else
                        return o2.getPersonId().compareTo(o1.getPersonId());
                }
                if(orderBy.equals("person.personName")){
                    if(isAsc)
                        return o1.getPersonName().compareTo(o2.getPersonName());
                    else {
                        return o2.getPersonName().compareTo(o1.getPersonName());
                    }
                }
                if(orderBy.equals("person.personIdCard")){
                    if(isAsc)
                        return o1.getPersonIdCard().compareTo(o2.getPersonIdCard());
                    else {
                        return o2.getPersonIdCard().compareTo(o1.getPersonIdCard());
                    }
                }
                return 0;
            }
            
        });
    }
    
}


/**
 * $Log: UserDataStore.java,v $
 * 
 * @version 1.0 2015-2-4 
 *
 */