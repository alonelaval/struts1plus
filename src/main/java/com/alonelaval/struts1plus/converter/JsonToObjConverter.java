package com.alonelaval.struts1plus.converter;

import com.alibaba.fastjson.JSON;

/**
 * 
 * Purpose:
 * 
 * @see	    
 * @since   1.1.0
 */
public class JsonToObjConverter<T> extends AbstractConverter
{
    private Class<T> beanClass;
    public JsonToObjConverter(Class<T> clazz){
        beanClass = clazz;
    }
    public Object convert(Object value)
    {
        if(value == null)
            return null;
        if(value instanceof String){
           return  JSON.parseObject(value.toString(),beanClass);
        }
        return null;
    }

}


/**
 * $Log: JsonConverter.java,v $
 * 
 * @version 1.0 2015-1-26 
 *
 */