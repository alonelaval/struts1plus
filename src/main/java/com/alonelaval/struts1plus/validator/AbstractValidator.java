package com.alonelaval.struts1plus.validator;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * Purpose:
 * 
 * @see	    
 * @since   1.1.0
 */
public abstract class AbstractValidator implements IValidator
{
    private IValidator parent;
    private IValidator next;
    private String validateMessage;
    private String errorPath;
    private HttpServletRequest request;
    protected static Logger logger = null;
    
    
    public AbstractValidator()
    {
        logger = LoggerFactory.getLogger(getClass());
    }

    public IValidator getNext()
    {
        return next;
    }
    
    public IValidator getParent()
    {
        return this.parent;
    }

    public boolean hasNext()
    {
        return next != null;
    }

    public boolean hasParent()
    {
        return parent != null;
    }

    public void setParent(IValidator validator)
    {
        this.parent = validator;
    }

    public final void setNext(IValidator next)
    {   
        this.next = next;
    }

    public void setValidateMessage(String validateMessage)
    {
        this.validateMessage = validateMessage;
    }

    public String getValidateMessage()
    {
        return validateMessage;
    }

    public String getErrorPath()
    {
        return errorPath;
    }

    public void setErrorPath(String errorPath)
    {
        this.errorPath = errorPath;
    }

    public HttpServletRequest getRequest()
    {
        return request;
    }

    public void setHttpRequest(HttpServletRequest request)
    {
        this.request = request;
    }

}


/**
 * $Log: AbstractValidator.java,v $
 * 
 * @version 1.0 2015-1-26 
 *
 */