/**
 * @(#)TestTokenValidateAction.java
 *
 * @author huawei
 * @version 1.0 2015-1-29
 *
 */
package com.alonelaval.struts1plus.examples.business;

import javax.servlet.http.HttpSession;

import com.alonelaval.struts1plus.action.AbstractBusinessAction;
import com.alonelaval.struts1plus.action.HttpSessionFactory;
import com.alonelaval.struts1plus.action.ServletContextFactory;




/**
 * 
 * Purpose:
 * 
 * @see	    
 * @since   1.1.0
 */
public class TokenValidateAction extends AbstractBusinessAction
{
    private String  testText;
    private Integer intTest;
    @Override
    public String execute()
    {
        
        HttpSession session = HttpSessionFactory.getIntance().getHttpSession(); 
        
        System.out.println(HttpSessionFactory.getIntance().getHttpSession().getId());
        System.out.println(ServletContextFactory.getIntance().getServletContext().getContextPath());
//        System.out.println("标志验证成功！");
        return "token";
    }
    public Integer getIntTest()
    {
        return intTest;
    }
    public void setIntTest(Integer intTest)
    {
        this.intTest = intTest;
    }
    public String getTestText()
    {
        return testText;
    }
    public void setTestText(String testText)
    {
        this.testText = testText;
    }
}


/**
 * $Log: TestTokenValidateAction.java,v $
 * 
 * @version 1.0 2015-1-29 
 *
 */