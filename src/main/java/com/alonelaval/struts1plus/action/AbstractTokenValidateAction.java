package com.alonelaval.struts1plus.action;

import javax.servlet.http.HttpServletRequest;

import com.alonelaval.struts1plus.validator.validate.RequestTokenValidate;


/**
 * 
 * Purpose: 添加token验证
 * 
 * @see	    
 * @since   1.1.0
 */
public abstract class AbstractTokenValidateAction extends AbstractBaseStrutsAction
{   
    @Override
    protected  void before(HttpServletRequest request) throws Exception
    {
        addPropertyValidator(getTokenName(), new RequestTokenValidate(request,getTokenName(),"token验证异常，你无法访问该网站！"));
    }
    public abstract String getTokenName();
}


/**
 * $Log: AbstractTokenValidateAction.java,v $
 * 
 * @version 1.0 2015-1-29 
 *
 */