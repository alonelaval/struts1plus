package com.alonelaval.struts1plus.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alonelaval.struts1plus.validator.IValidator;


/**
 *<validator propertyName="" value="" validateClassName="" path=""  errorPath=""/> 
 * jsp中嵌入的过滤器
 */
public class ValidatorTag extends SimpleTagSupport{
	@Override
    public void doTag() throws JspException, IOException
    {
        PageContext pageContext = (PageContext) getJspContext();  
        HttpServletResponse response =(HttpServletResponse)pageContext.getResponse();
        HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
        try
        {
            IValidator validator = (IValidator) Class.forName(getValidateClassName()).newInstance();
            if(errorInfo != null){
                validator.setValidateMessage(errorInfo);
            }
            if(errorPath != null)
                validator.setErrorPath(errorPath);
            validator.setHttpRequest(request);
            validator.doValidate(value);  
               
        }
        catch (Exception ex){
            logger.error("非法访问页面",ex);
                try
                {
                    if(redirect){
                        response.sendRedirect(request.getContextPath()+ errorPath);
                        return;
                    }
                    request.setAttribute("errorInfo", ex.getMessage());
                    request.getRequestDispatcher(errorPath).forward(request, response);
                    return;
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
        }
        super.doTag();
    }

	private boolean redirect = false;
    private String errorPath;
	private Object value;
	private String validateClassName;
    private String errorInfo;
    protected static Logger logger  =  LoggerFactory.getLogger(ValidatorTag.class);
    
	public String getValidateClassName()
    {
        return validateClassName;
    }
    public void setValidateClassName(String validateClassName)
    {
        this.validateClassName = validateClassName;
    }
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
    public String getErrorPath()
    {
        return errorPath;
    }
    public void setErrorPath(String errorPath)
    {
        this.errorPath = errorPath;
    }
    public boolean isRedirect()
    {
        return redirect;
    }
    public void setRedirect(boolean redirect)
    {
        this.redirect = redirect;
    }
    public String getErrorInfo()
    {
        return errorInfo;
    }
    public void setErrorInfo(String errorInfo)
    {
        this.errorInfo = errorInfo;
    }
    
    
}
