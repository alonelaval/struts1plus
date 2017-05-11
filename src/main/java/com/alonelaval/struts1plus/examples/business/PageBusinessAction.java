/**
 * @(#)PageBusinessAction.java
 *
 * @author huawei
 * @version 1.0 2015-2-9
 *
 */
package com.alonelaval.struts1plus.examples.business;

import com.alonelaval.struts1plus.action.AbstractBusinessAction;
import com.alonelaval.struts1plus.action.NewPage;


/**
 * 
 * Purpose:
 * 
 * @see	    
 * @since   1.1.0
 */
public class PageBusinessAction extends AbstractBusinessAction
{
    private NewPage page = new NewPage();
    
    @Override
    public String execute()
    {
        if(page.getPageNum() == 0)
            page.setPageNum(10);
//        System.out.println(page.getOrderBy());
//        System.out.println(page.getIsAsc());
        page = UserDataPageStore.getUserByPage(page);
        return "page";
    }
    
    public NewPage getPage()
    {
        return page;
    }

    public void setPage(NewPage page)
    {
        this.page = page;
    }
}


/**
 * $Log: PageBusinessAction.java,v $
 * 
 * @version 1.0 2015-2-9 
 *
 */