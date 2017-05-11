/**
 * @(#)SetCharacterEncodingFilter.java
 *
 * @author yangbl
 * @version 1.0 2015-1-21
 *
 */
package com.alonelaval.struts1plus.action;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


/**
 * Purpose:
 * 
 * @see
 * @since 1.1.0
 */

public class SetCharacterEncodingFilter implements Filter
{

    private String encoding;

    @SuppressWarnings("unused")
    private FilterConfig filterConfig = null;

    public void destroy()
    {
        this.encoding = null;
        this.filterConfig = null;

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException
    {
       
        request.setCharacterEncoding(this.encoding);
        response.setCharacterEncoding(this.encoding);

        
        chain.doFilter(request, response);
    }

    public void init(FilterConfig filterConfig) throws ServletException
    {
        this.encoding = filterConfig.getInitParameter("encoding");
    }

}

/**
 * $Log: SetCharacterEncodingFilter.java,v $
 * 
 * @version 1.0 2015-1-21
 */
