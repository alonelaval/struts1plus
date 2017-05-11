package com.alonelaval.struts1plus.examples.action;

import javax.servlet.http.HttpServletRequest;

import com.alonelaval.struts1plus.action.AbstractBaseStrutsAction;
import com.alonelaval.struts1plus.examples.business.TestBusinessAction;
import com.alonelaval.struts1plus.validator.validate.NotNullValidate;

public class TestStrutsAction  extends AbstractBaseStrutsAction{
    
    @Override
    protected void before(HttpServletRequest request) throws Exception
    {

//        addConverter(List.class, new ListJsonConverter(TbLogVisit.class));
//        
//		addPropertyConverter("dateTest",new TestMyConverter());
//        System.out.println(request.getRequestURI());
//        System.out.println(request.getRequestURL());
        addPropertyValidator("websiteId",new NotNullValidate("myerror","websiteID不能为空！"));
//        
    }
        
     
        
//      IValidator sessionValidator = new UserSessionValidate("无权访问网站！");
//      sessionValidator.doValidate(request.getSession());

	
	protected Class getBussinessAction() {
		return TestBusinessAction.class;
	}
	
}
