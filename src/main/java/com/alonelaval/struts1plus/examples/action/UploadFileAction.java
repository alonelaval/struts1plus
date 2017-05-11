/**
 * @(#)UploadAction.java
 *
 * @author huawei
 * @version 1.0 2015-2-4
 *
 * Copyright (C) 2012,2015 , PING' AN, Inc.
 */
package com.alonelaval.struts1plus.examples.action;

import javax.servlet.http.HttpServletRequest;

import com.alonelaval.struts1plus.action.AbstractBaseStrutsAction;
import com.alonelaval.struts1plus.examples.business.UploadFileBusinessAction;
import com.alonelaval.struts1plus.validator.validate.StringNotEmptyValidate;

/**
 * 
 * Purpose:
 * 
 * @see	    
 * @since   1.1.0
 */
public class UploadFileAction extends AbstractBaseStrutsAction
{
    
    @Override
    protected void after(HttpServletRequest request)
    {
        addPropertyValidator("testText", new StringNotEmptyValidate("名称不能为空！","error"));
        super.after(request);
    }

    @Override
    protected Class getBussinessAction()
    {
        return UploadFileBusinessAction.class;
    }

}


/**
 * $Log: UploadAction.java,v $
 * 
 * @version 1.0 2015-2-4 
 *
 */