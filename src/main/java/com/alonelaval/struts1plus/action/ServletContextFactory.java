package com.alonelaval.struts1plus.action;

import javax.servlet.ServletContext;

/**
 * 
 * Purpose:
 * 
 * @see	    
 * @since   1.1.0
 */
public class ServletContextFactory
{
    private static ThreadLocal<ServletContext> servletContexts = new ThreadLocal<ServletContext>();
    private ServletContextFactory(){}
    private static class ServletContextFactoryHolder{
        private static ServletContextFactory instance = new ServletContextFactory();
    }
    public static ServletContextFactory getIntance(){
        return ServletContextFactoryHolder.instance;
    }
    
    public ServletContext getServletContext(){
        return servletContexts.get();
    }
    public void putServletContext(ServletContext servletContext){
        servletContexts.set(servletContext);
    }
    public void removeServletContext(){
        servletContexts.remove();
    }
    
}


/**
 * $Log: ServletContextFactory.java,v $
 * 
 * @version 1.0 2015-3-9 
 *
 */