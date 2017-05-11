/**
 * @(#)AjaxAction.java
 *
 * @author huawei
 * @version 1.0 2015-2-4
 *
 */
package com.alonelaval.struts1plus.examples.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.alonelaval.struts1plus.action.AbstractAjaxBaseStrutsAction;
import com.alonelaval.struts1plus.converter.ListJsonConverter;
import com.alonelaval.struts1plus.examples.business.AjaxJsonBusinessAction;
import com.alonelaval.struts1plus.examples.entity.TbLogVisit;
import com.alonelaval.struts1plus.validator.validate.StringValidate;

/**
 * 
 * Purpose:
 * 
 * @see	    
 * @since   1.1.0
 */
public class AjaxJsonAction extends AbstractAjaxBaseStrutsAction
{
    
    @Override
    protected void before(HttpServletRequest request) throws Exception
    {
        addConverter(List.class, new ListJsonConverter(TbLogVisit.class));
        addPropertyValidator("testText", new StringValidate("字符错误"));
        
    }

    @Override
    protected Class getBussinessAction()
    {
        return AjaxJsonBusinessAction.class;
    }

}


/**
 * $Log: AjaxAction.java,v $
 * 
 * @version 1.0 2015-2-4 
 *
 */