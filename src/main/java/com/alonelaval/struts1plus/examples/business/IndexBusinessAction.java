/**
 * @(#)IndexBusinessAction.java
 *
 * @author huawei
 * @version 1.0 2015-2-5
 *
 */
package com.alonelaval.struts1plus.examples.business;

import com.alonelaval.struts1plus.action.AbstractBusinessAction;
import com.alonelaval.struts1plus.annotation.RedirectUrlParamMethod;
import com.alonelaval.struts1plus.annotation.UrlOverrideMethod;


/**
 * 
 * Purpose:
 * 
 * @see	    
 * @since   1.1.0
 */
public class IndexBusinessAction extends AbstractBusinessAction
{
    private String param;
    public String toList(){
        return "list";
    }
    public String toAjaxUpload(){
        return "ajaxUpload";
    }
    public String toAjaxJson(){
        return "ajaxJson";
    }
    public String toDownload(){
        return "download";
    }
    public String toUpload(){
        return "upload";
    }
    public String toIndex(){
        return "index";
    }
    public String toToken(){
        return "token";
    }
    public String toMultiChoice(){
        return "multiChoice";
    }
    public String toPage(){
        return "page";
    }
    public String toRestful(){
        return "restful";
    }
    @RedirectUrlParamMethod(forwardName="redirect",paramsName={"param","param2"})
    public String toRedirect(){
        param="redirect.jsp";
        param2="2";
        return "redirect";
    }
    @UrlOverrideMethod(forwardName="redirect",paramsName={"param","param2"})
    @RedirectUrlParamMethod(forwardName="redirect",paramsName={"param","param2"})
    public String toRedirectURL(){
        param="redirect";
        param2="2";
        return "redirect";
    }
    @UrlOverrideMethod(forwardName="redirect",paramsName={"param","param2"})
    public String toUrlOverrideURL(){
        param="UrlOverride";
        param2="2";
        return "redirect";
    }
    public String getParam()
    {
        return param;
    }
    public void setParam(String param)
    {
        this.param = param;
    }
    private String param2;
    public String getParam2()
    {
        return param2;
    }
    public void setParam2(String param2)
    {
        this.param2 = param2;
    }
    
}


/**
 * $Log: IndexBusinessAction.java,v $
 * 
 * @version 1.0 2015-2-5 
 *
 */