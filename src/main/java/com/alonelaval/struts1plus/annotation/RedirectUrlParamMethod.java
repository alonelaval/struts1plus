package com.alonelaval.struts1plus.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 
 * Purpose:对返回的哪个forward进行redirect传参，参数的顺序为穿入的参数名称顺序
 * 如:http://127.0.0.1:8080/bds_site/?param1=1111&parma2=2222
 * @see	    
 * @since   1.1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface RedirectUrlParamMethod
{
    String forwardName();
    String [] paramsName();
}


/**
 * $Log: RedirectUrlParamMethod.java,v $
 * 
 * @version 1.0 2015-3-6 
 *
 */