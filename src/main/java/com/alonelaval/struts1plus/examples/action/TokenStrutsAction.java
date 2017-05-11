/**
 * @(#)TestTokenStrutsAction.java
 *
 * @author huawei
 * @version 1.0 2015-1-29
 *
 * Copyright (C) 2012,2015 , PING' AN, Inc.
 */
package com.alonelaval.struts1plus.examples.action;

import com.alonelaval.struts1plus.action.AbstractTokenValidateAction;
import com.alonelaval.struts1plus.examples.business.TokenValidateAction;

/**
 * 
 * Purpose:
 * 
 * @see	    
 * @since   1.1.0
 */
public class TokenStrutsAction extends AbstractTokenValidateAction
{
    @Override
    public String getTokenName()
    {
        return "token";
    }
    @Override
    protected Class getBussinessAction()
    {
        return TokenValidateAction.class;
    }
}


/**
 * $Log: TestTokenStrutsAction.java,v $
 * 
 * @version 1.0 2015-1-29 
 *
 */