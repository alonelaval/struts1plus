package com.alonelaval.struts1plus.converter;



public abstract class AbstractConverter implements IConverter{
	public Object convert(Class type, Object value) {
		return convert(value);
	}
}
