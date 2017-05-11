/**
 * @(#)ListNotEmptyValidate.java
 *
 * @author huawei
 * @version 1.0 2015-2-9
 *
 */
package com.alonelaval.struts1plus.validator.validate;

import java.util.ArrayList;
import java.util.List;

import com.alonelaval.struts1plus.validator.AbstractValidator;
import com.alonelaval.struts1plus.validator.ValidateException;

/**
 * 
 * Purpose:
 * 
 * @see	    
 * @since   1.1.0
 */
public class ListNotEmptyValidate extends AbstractValidator
{
    public ListNotEmptyValidate(){}
    public ListNotEmptyValidate(String message){
        setValidateMessage(message);
    }
    public ListNotEmptyValidate(String message,String errorPath){
        setValidateMessage(message);
        setErrorPath(errorPath);
    }
    public boolean doValidate(Object object) throws ValidateException
    {
        if(new NotNullValidate(getValidateMessage(),getErrorPath()).doValidate(object)){
            if(object instanceof List){
                List list = (List) object;
                if(!list.isEmpty()){
                    return true;
                }
            }
        }
        throw new ValidateException(getValidateMessage(),getErrorPath());
    }
    public static void main(String[] args) throws ValidateException
    {
        List list =new ArrayList();
        ListNotEmptyValidate notEmptyValidate = new ListNotEmptyValidate("不能为空");
        notEmptyValidate.doValidate(list);
    }
}


/**
 * $Log: ListNotEmptyValidate.java,v $
 * 
 * @version 1.0 2015-2-9 
 *
 */