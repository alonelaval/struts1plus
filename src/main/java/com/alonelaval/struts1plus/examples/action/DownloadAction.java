/**
 * @(#)DownLoadAction.java
 *
 * @author huawei
 * @version 1.0 2015-2-5
 *
 */
package com.alonelaval.struts1plus.examples.action;

import com.alonelaval.struts1plus.action.AbstractDownloadBaseAction;
import com.alonelaval.struts1plus.examples.business.DownloadFileAction;


/**
 * 
 * Purpose:
 * 
 * @see	    
 * @since   1.1.0
 */
public class DownloadAction extends AbstractDownloadBaseAction
{
    @Override
    protected Class getBussinessAction()
    {
        return DownloadFileAction.class;
    }
}


/**
 * $Log: DownLoadAction.java,v $
 * 
 * @version 1.0 2015-2-5 
 *
 */