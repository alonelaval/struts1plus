package com.alonelaval.struts1plus.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public abstract class AbstractBaseAction extends Action
{
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        if(!checkUser(request,response))
        {
            return null;
        }
        return doExecute(mapping, form, request, response);
    }

    protected boolean checkUser(HttpServletRequest request,HttpServletResponse response) throws Exception
    {
        return true;
    }

    protected abstract ActionForward doExecute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception;
}
