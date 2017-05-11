/**
 * @(#)IntegerValidate.java
 *
 * @author huawei
 * @version 1.0 2015-1-27
 *
 */
package com.alonelaval.struts1plus.validator.validate;

import com.alonelaval.struts1plus.validator.AbstractValidator;
import com.alonelaval.struts1plus.validator.ValidateException;


/**
 * 
 * Purpose:
 * 
 * @see	    
 * @since   1.1.0
 */
public class IntegerValidate extends AbstractValidator
{
    public IntegerValidate(){
        setParent(new NotNullValidate());   
        setValidateMessage("不是数字类型！");
    }
    public IntegerValidate(String message,String errorPath){
        setParent(new NotNullValidate());
        setValidateMessage(message);
        setErrorPath(errorPath);
    }
    @Override
    public boolean doValidate(Object object) throws ValidateException
    {
        if(hasParent() && getParent().doValidate(object))
        {
            try{
                Integer.parseInt(object.toString());
                return true;
            }
            catch(RuntimeException ex){
                throw new ValidateException(getValidateMessage(),getErrorPath());
            }
        }
        return false;
    }
    
}


/**
 * $Log: IntegerValidate.java,v $
 * 
 * @version 1.0 2015-1-27 
 *
 */