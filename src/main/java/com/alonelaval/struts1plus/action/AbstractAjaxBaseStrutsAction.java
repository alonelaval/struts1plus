package com.alonelaval.struts1plus.action;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.alibaba.fastjson.JSON;
import com.alonelaval.struts1plus.annotation.AjaxMethod;
import com.alonelaval.struts1plus.annotation.AnnotationProcesUtil;




/**
 * 
 * Purpose:处理请求的action
 * @see     
 * @since   1.1.0
 */
public abstract class AbstractAjaxBaseStrutsAction extends AbstractBaseStrutsAction
{
    /**
     * 需要重写
     * (non-Javadoc)
     * @throws Exception 
     * @see action.AbstractBaseStrutsAction#errorValidateProcess(javax.servlet.http.HttpServletRequest, java.lang.Exception, org.apache.struts.action.ActionMapping)
     */
    @Override
    protected final ActionForward errorValidateProcess(IBusinessAction action, HttpServletRequest request, Exception e, ActionMapping mapping, HttpServletResponse response,Method method) throws Exception
    {
        if(action instanceof IAjaxBusinessAction && AnnotationProcesUtil.getInstance().check(method,AjaxMethod.class)){
            IAjaxBusinessAction ajaxBusinessAction = (IAjaxBusinessAction)action;
            ResultJson resultJson =  new ResultJson();
            resultJson.setStatusCode(ResultJson.STATUS_CODE_PARAM_ERROR);
            resultJson.setStatusMessage(e.getMessage());
            ajaxBusinessAction.setJsonObject(resultJson );
            ajaxResponse(ajaxBusinessAction, response);
            return null;
        }
        return super.errorValidateProcess(action, request, e, mapping, response, method);
    }
    @Override
    protected final ActionForward getResponseActionForward(ActionMapping mapping, HttpServletResponse response, HttpServletRequest request, IBusinessAction businessAction, String result,Method method) throws Exception
    {
        if(businessAction instanceof IAjaxBusinessAction && AnnotationProcesUtil.getInstance().check(method,AjaxMethod.class))
          {
              IAjaxBusinessAction ajaxBusinessAction = (IAjaxBusinessAction)businessAction;
              ajaxResponse(ajaxBusinessAction, response);
              return null;
          }
        return super.getResponseActionForward(mapping, response, request, businessAction, result,method);
    }   

    private void ajaxResponse(IAjaxBusinessAction ajaxBusinessAction,HttpServletResponse response) throws IOException{
        Object jsonData= ajaxBusinessAction.getJsonObject();
        if(ajaxBusinessAction.isConverterJson()){
            jsonData = JSON.toJSONString(ajaxBusinessAction.getJsonObject());
        }
        response.getWriter().write(jsonData.toString());
    }

    
}


/**
 * $Log: BaseAction.java,v $
 * 
 * @version 1.0 2015-1-23 
 *
 */