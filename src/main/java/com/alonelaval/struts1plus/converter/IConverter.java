package com.alonelaval.struts1plus.converter;

import org.apache.commons.beanutils.Converter;

public interface IConverter extends Converter {
	   Object convert( Object value);
}
