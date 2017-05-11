package com.alonelaval.struts1plus.action;

import javax.servlet.http.HttpSession;

/**
 * 
 * Purpose: Session工厂
 * 
 * @see	    
 * @since   1.1.0
 */
public class HttpSessionFactory
{
    private static ThreadLocal<HttpSession> sessions = new ThreadLocal<HttpSession>();
    private HttpSessionFactory(){}
    private static class HttpSessionFactoryHolder{
        private static HttpSessionFactory instance = new HttpSessionFactory();
    }
    public static HttpSessionFactory getIntance(){
        return HttpSessionFactoryHolder.instance;
    }
    public HttpSession getHttpSession(){
        return sessions.get();
    }
    public void putHttpSession(HttpSession session){
        sessions.set(session);
    }
    public void removeHttpSession(){
        sessions.remove();
    }
}


/**
 * $Log: SessionThread.java,v $
 * 
 * @version 1.0 2015-1-29 
 *
 */