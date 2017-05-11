package com.alonelaval.struts1plus.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * Purpose: 对返回的哪个forward进行重写URL，重写时使用那些参数，参数的顺序为穿入的参数名称顺序
 * 如:http://127.0.0.1:8080/bds_site/param1Value/parma2Value
 * @see	    
 * @since   1.1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UrlOverrideMethod
{
    String forwardName();
    String [] paramsName();
}


/**
 * $Log: UrlOverride.java,v $
 * 
 * @version 1.0 2015-3-6 
 *
 */