package com.alonelaval.struts1plus.action;
/**
 *
 * Purpose:
 *
 * @see
 * @since   1.1.0
 */
public abstract class AbstractAjaxBusinessAction extends AbstractBusinessAction implements IAjaxBusinessAction
{
    private Object jsonObject;

    public boolean isConverterJson()
    {
        return true;
    }

    public String execute()
    {
        return null;
    }

    public Object getJsonObject()
    {
        return jsonObject;
    }

    public void setJsonObject(Object jsonObject)
    {
        this.jsonObject = jsonObject;
    }

}


/**
 * $Log: AbstractBusinessAction.java,v $
 *
 * @version 1.0 2015-1-26
 *
 */