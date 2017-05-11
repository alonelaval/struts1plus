package com.alonelaval.struts1plus.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * Purpose: 标识哪个方法可以下载文件
 * 
 * @see	    
 * @since   1.1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FileMethod
{

}


/**
 * $Log: FileMethod.java,v $
 * 
 * @version 1.0 2015-3-6 
 *
 */