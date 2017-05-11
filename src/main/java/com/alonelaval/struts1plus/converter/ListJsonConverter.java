package com.alonelaval.struts1plus.converter;

import com.alibaba.fastjson.JSON;

/**
 * 
 * Purpose:
 * 
 * @see	    
 * @since   1.1.0
 */
public class ListJsonConverter<T> extends AbstractConverter
{
    private Class<T> beanClass;
    public ListJsonConverter(Class<T> clazz){
        beanClass = clazz;
    }
    public Object convert(Object value)
    {
        if(value == null)
            return null;
        if(value instanceof String){
           return  JSON.parseArray(value.toString(), beanClass);
        }
        return null;
    }
    
}


/**
 * $Log: ListJsonConverter.java,v $
 * 
 * @version 1.0 2015-1-26 
 *
 */