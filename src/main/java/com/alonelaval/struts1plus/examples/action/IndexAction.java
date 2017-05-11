package com.alonelaval.struts1plus.examples.action;

import com.alonelaval.struts1plus.action.AbstractAjaxBaseStrutsAction;
import com.alonelaval.struts1plus.examples.business.IndexBusinessAction;

	

/**
 * 
 * Purpose:
 * 
 * @see	    
 * @since   1.1.0
 */
public class IndexAction extends AbstractAjaxBaseStrutsAction
{

    @Override	
    protected Class getBussinessAction()
    {
        return IndexBusinessAction.class;
    }

}


/**
 * $Log: IndexAction.java,v $
 * 
 * @version 1.0 2015-2-5 
 *
 */