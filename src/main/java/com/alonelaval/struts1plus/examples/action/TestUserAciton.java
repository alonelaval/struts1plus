/**
 * @(#)TestUserAciton.java
 *
 * @author huawei
 * @version 1.0 2015-2-4
 *
 * Copyright (C) 2012,2015 , PING' AN, Inc.
 */
package com.alonelaval.struts1plus.examples.action;

import javax.servlet.http.HttpServletRequest;

import com.alonelaval.struts1plus.action.AbstractBaseStrutsAction;
import com.alonelaval.struts1plus.examples.business.TestUserBusinessAciton;
import com.alonelaval.struts1plus.validator.validate.StringNotEmptyValidate;

/**
 * 
 * Purpose:
 * 
 * @see	    
 * @since   1.1.0
 */
public class TestUserAciton extends AbstractBaseStrutsAction
{
    
    @Override
    protected void before(HttpServletRequest request) throws Exception
    {
        addPropertyValidator("person.personName", new StringNotEmptyValidate("名称不能为空！","error"));
        addPropertyValidator("person.personIdCard", new StringNotEmptyValidate("证件号码不能为空！","error"));
        super.before(request);
    }

    @Override
    protected Class getBussinessAction()
    {
        return TestUserBusinessAciton.class;
    }

}


/**
 * $Log: TestUserAciton.java,v $
 * 
 * @version 1.0 2015-2-4 
 *
 */