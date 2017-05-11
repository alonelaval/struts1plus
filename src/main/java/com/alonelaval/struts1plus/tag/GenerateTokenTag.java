package com.alonelaval.struts1plus.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.alonelaval.struts1plus.validator.validate.TokenProcessor;



/**
 * 
 * Purpose: 生成界面token
 * 
 * @see	    
 * @since   1.1.0
 */
public class GenerateTokenTag extends SimpleTagSupport
{
    private String tokenName;
    private boolean isValue= false;
    @Override
    public void doTag() throws JspException, IOException
    {
        PageContext pageContext = (PageContext) getJspContext();  
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();  
        
        String tokenValue = TokenProcessor.getInstance().generateToken(request);
        if (isValue){
            pageContext.setAttribute(tokenName,tokenValue);
        }
        else{
            String output = "<input type='hidden' name='" + tokenName + "' value='" + tokenValue + "'/>";  
            pageContext.getOut().print(output); 
        }
        TokenProcessor.getInstance().saveTokenByValue(request, tokenName, tokenValue);
        super.doTag();
    }
    public boolean isValue()
    {
        return isValue;
    }
    public void setIsValue(boolean isValue)
    {
        this.isValue = isValue;
    }
    public String getTokenName()
    {
        return tokenName;
    }
    public void setTokenName(String tokenName)
    {
        this.tokenName = tokenName;
    }
    
    
    
}


/**
 * $Log: GenerateTokenTag.java,v $
 * 
 * @version 1.0 2015-1-28 
 *
 */