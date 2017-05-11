/**
 * @(#)UserSessionValidate.java
 *
 * @author huawei
 * @version 1.0 2015-1-29
 *
 */
package com.alonelaval.struts1plus.validator.validate;

import javax.servlet.http.HttpSession;

import com.alonelaval.struts1plus.validator.AbstractValidator;
import com.alonelaval.struts1plus.validator.ValidateException;

/**
 * 
 * Purpose: 简单版本的seesion验证，可根据业务来进行调整
 * 
 * @see	    
 * @since   1.1.0
 */
public class UserSessionValidate extends AbstractValidator
{
    public UserSessionValidate(String message){
        setValidateMessage(message);
    }
    public UserSessionValidate(){}
    public UserSessionValidate(String message,String errorPath){
        setValidateMessage(message);
        setErrorPath(errorPath);
    }
    public boolean doValidate(Object object) throws ValidateException
    {
        if(object == null )
            throw new ValidateException(getValidateMessage(),getErrorPath());
        if(!(object instanceof HttpSession))
            throw new ValidateException(getValidateMessage(),getErrorPath());
        
        return true;
    }
    
}


/**
 * $Log: UserSessionValidate.java,v $
 * 
 * @version 1.0 2015-1-29 
 *
 */