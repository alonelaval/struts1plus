package com.alonelaval.struts1plus.action;

import javax.servlet.http.HttpServletRequest;




/**
 * 
 * Purpose:
 * 
 * @see	    
 * @since   1.1.0
 */
public class HttpRequestFactory
{
    private static ThreadLocal<HttpServletRequest> requests = new ThreadLocal<HttpServletRequest>();
    private HttpRequestFactory(){}
    private static class HttpRequestFactoryHolder{
        private static HttpRequestFactory instance = new HttpRequestFactory();
    }
    public static HttpRequestFactory getIntance(){
        return HttpRequestFactoryHolder.instance;
    }
    
    public HttpServletRequest getHttpRequest(){
        return requests.get();
    }
    public void putHttpRequest(HttpServletRequest request){
        requests.set(request);
    }
    public void removeHttpRequest(){
        requests.remove();
    }
}


/**
 * $Log: HttpRequestFactory.java,v $
 * 
 * @version 1.0 2015-3-31 
 *
 */