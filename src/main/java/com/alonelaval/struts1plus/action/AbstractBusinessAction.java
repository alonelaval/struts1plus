package com.alonelaval.struts1plus.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *
 * Purpose:
 *
 * @see
 * @since   1.1.0
 */
public abstract class AbstractBusinessAction implements IBusinessAction
{
    private String errorInfo;
    private String message;
    protected static Logger logger =null;
    public AbstractBusinessAction(){
        logger =  LoggerFactory.getLogger(this.getClass());
    }
    public String getErrorInfo()
    {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo)
    {
        this.errorInfo = errorInfo;
    }

    public String execute()
    {
        return null;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }


}


/**
 * $Log: AbstractBusinessAction.java,v $
 *
 * @version 1.0 2015-1-26
 *
 */