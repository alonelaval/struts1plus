package com.alonelaval.struts1plus.examples.action;

import javax.servlet.http.HttpServletRequest;

import com.alonelaval.struts1plus.action.AbstractBaseStrutsAction;
import com.alonelaval.struts1plus.converter.ListConverter;
import com.alonelaval.struts1plus.examples.business.MultiChoiceBusinessAction;


public class MultiChoiceAction  extends AbstractBaseStrutsAction{
    
    @Override
    protected void before(HttpServletRequest request) throws Exception
    {

//        addConverter(List.class, new ListConverter());
//        
		addPropertyConverter("hobbys",new ListConverter());
//        System.out.println(request.getRequestURI());
//        System.out.println(request.getRequestURL());
//        
    }
        
     
        
//      IValidator sessionValidator = new UserSessionValidate("无权访问网站！");
//      sessionValidator.doValidate(request.getSession());

	
	protected Class getBussinessAction() {
		return MultiChoiceBusinessAction.class;
	}
	
}
