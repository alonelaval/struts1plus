
package com.alonelaval.struts1plus.examples.action;

import com.alonelaval.struts1plus.action.AbstractBaseStrutsAction;
import com.alonelaval.struts1plus.examples.business.PageBusinessAction;


/**
 * 
 * Purpose:
 * 
 * @see	    
 * @since   1.1.0
 */
public class PageAction extends AbstractBaseStrutsAction
{
    @Override
    protected Class getBussinessAction()
    {
        return PageBusinessAction.class;
    }

}


/**
 * $Log: PageAction.java,v $
 * 
 * @version 1.0 2015-2-9 
 *
 */