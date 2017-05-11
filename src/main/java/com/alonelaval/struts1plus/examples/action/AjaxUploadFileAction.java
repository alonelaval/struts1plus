/**
 * @(#)AjaxAction.java
 *
 * @author huawei
 * @version 1.0 2015-2-4
 *
 */
package com.alonelaval.struts1plus.examples.action;

import javax.servlet.http.HttpServletRequest;

import com.alonelaval.struts1plus.action.AbstractAjaxBaseStrutsAction;
import com.alonelaval.struts1plus.examples.business.AjaxUploadFileBusinessAction;
import com.alonelaval.struts1plus.validator.validate.FileValidate;

/**
 * 
 * Purpose:
 * 
 * @see	    
 * @since   1.1.0
 */
public class AjaxUploadFileAction extends AbstractAjaxBaseStrutsAction
{
    
    @Override
    protected void before(HttpServletRequest request) throws Exception
    {
        String [] fileTypes = {"gif","jpg","png"};
        FileValidate fileValidate = new FileValidate("上传文件错误",null,2048,fileTypes);
        addPropertysValidator(new String[]{"fileToUpload","fileToUpload2"}, fileValidate);
        
    }

    @Override
    protected Class getBussinessAction()
    {
        return AjaxUploadFileBusinessAction.class;
    }

}


/**
 * $Log: AjaxAction.java,v $
 * 
 * @version 1.0 2015-2-4 
 *
 */