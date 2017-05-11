/**
 * @(#)TestUserBusinessAciton.java
 *
 * @author huawei
 * @version 1.0 2015-2-4
 *
 */
package com.alonelaval.struts1plus.examples.business;

import java.util.ArrayList;
import java.util.List;

import com.alonelaval.struts1plus.action.AbstractBusinessAction;
import com.alonelaval.struts1plus.examples.entity.TbPerson;


/**
 * 
 * Purpose:
 * 
 * @see	    
 * @since   1.1.0
 */
public class TestUserBusinessAciton extends AbstractBusinessAction
{
    private List<TbPerson> users = new ArrayList<TbPerson>();
    private TbPerson person = new TbPerson() ;
    private boolean isUpdate;
    
    @Override
    public String execute()
    {
        users = UserDataStore.getUsers();
        return "index";
    }
    public String update(){
        UserDataStore.update(person);
        users = UserDataStore.getUsers();
        setMessage("更新成功！");
        return "index";
    }
    public String delete(){
        UserDataStore.delete(person);
        setMessage("删除成功！");
        users = UserDataStore.getUsers();
        return "index";
    }
    public String add(){
        UserDataStore.addUser(person);
        users = UserDataStore.getUsers();
        setMessage("添加成功！");
        return "index";
    }
    public String toAdd(){
        isUpdate = false;
        return "input";
    }
    public String toUpdate(){
        isUpdate = true;
        person = UserDataStore.geTbPerson(person);
        return "input";
    }

    public List<TbPerson> getUsers()
    {
        return users;
    }
    public void setUsers(List<TbPerson> users)
    {
        this.users = users;
    }
    public TbPerson getPerson()
    {
        return person;
    }
    public void setPerson(TbPerson person)
    {
        this.person = person;
    }
    public boolean getIsUpdate()
    {
        return isUpdate;
    }
    public void setIsUpdate(boolean isUpdate)
    {
        this.isUpdate = isUpdate;
    }
    
}


/**
 * $Log: TestUserBusinessAciton.java,v $
 * 
 * @version 1.0 2015-2-4 
 *
 */