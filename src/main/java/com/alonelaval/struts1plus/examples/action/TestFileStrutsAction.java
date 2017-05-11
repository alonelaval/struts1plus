package com.alonelaval.struts1plus.examples.action;

import com.alonelaval.struts1plus.action.AbstractBaseStrutsAction;
import com.alonelaval.struts1plus.examples.business.TestFileBusinessAction;


public class TestFileStrutsAction  extends AbstractBaseStrutsAction{
    
	@Override
	protected Class getBussinessAction() {
		return TestFileBusinessAction.class;
	}
	
}
