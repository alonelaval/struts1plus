/**
 * @(#)StringValidate.java
 *
 * @author huawei
 * @version 1.0 2015-1-30
 *
 */
package com.alonelaval.struts1plus.validator.validate;

import org.apache.commons.lang.StringUtils;

import com.alonelaval.struts1plus.validator.AbstractValidator;
import com.alonelaval.struts1plus.validator.ValidateException;


/**
 * 
 * Purpose:
 * 
 * @see	    
 * @since   1.1.0
 */
public class StringValidate extends AbstractValidator
{
    public StringValidate(){}
    public StringValidate(String message){
        setValidateMessage(message);
    }
    public StringValidate(String message,String errorPath){
        setValidateMessage(message);
        setErrorPath(errorPath);
    }
    public boolean doValidate(Object object) throws ValidateException
    {
        if(object == null)
            throw new ValidateException(getValidateMessage());
        if(object instanceof String)
            if(StringUtils.isBlank(object.toString()))
                throw new ValidateException(getValidateMessage(),getErrorPath());
            else
                return true;
       throw new ValidateException(getValidateMessage(),getErrorPath());
    }
}


/**
 * $Log: StringValidate.java,v $
 * 
 * @version 1.0 2015-1-30 
 *
 */