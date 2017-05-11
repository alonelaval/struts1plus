
package com.alonelaval.struts1plus.examples.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.alonelaval.struts1plus.action.AbstractBaseStrutsAction;
import com.alonelaval.struts1plus.converter.ListJsonConverter;
import com.alonelaval.struts1plus.examples.business.TestAjaxBusinessAction;
import com.alonelaval.struts1plus.examples.entity.TbLogVisit;
import com.alonelaval.struts1plus.validator.IValidator;
import com.alonelaval.struts1plus.validator.validate.UserSessionValidate;

/**
 * 
 * Purpose:
 * 
 * @see	    
 * @since   1.1.0
 */
public class TestAjaxStrutsAction extends AbstractBaseStrutsAction
{
    @Override
    protected Class getBussinessAction()
    {
        return TestAjaxBusinessAction.class;
    }
    @Override
    protected void before(HttpServletRequest request) throws Exception
    {
        IValidator sessionValidator = new UserSessionValidate("无权访问网站！");
        sessionValidator.doValidate(request.getSession());
        addConverter(List.class, new ListJsonConverter(TbLogVisit.class));
    }
    

}


/**
 * $Log: TestAjaxStrutsAction.java,v $
 * 
 * @version 1.0 2015-1-26 
 *
 */