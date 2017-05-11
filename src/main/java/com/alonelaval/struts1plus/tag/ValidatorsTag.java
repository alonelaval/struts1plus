package com.alonelaval.struts1plus.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
public class ValidatorsTag extends TagSupport {
	@Override
	public int doStartTag() throws JspException {
		return TagSupport.EVAL_BODY_INCLUDE;
	}
}

/**
 * 
 * 	<validators>
		<validator name="" value="" class=""/>
		<validator name="" value="" class=""/>
		<validator name="" value="" class=""/>
	<validators/>
 */
