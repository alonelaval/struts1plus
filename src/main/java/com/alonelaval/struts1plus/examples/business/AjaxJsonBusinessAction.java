package com.alonelaval.struts1plus.examples.business;

import java.util.ArrayList;
import java.util.List;

import com.alonelaval.struts1plus.action.AbstractAjaxBusinessAction;
import com.alonelaval.struts1plus.action.ResultJson;
import com.alonelaval.struts1plus.annotation.AjaxMethod;
import com.alonelaval.struts1plus.examples.entity.TbLogVisit;


/**
 * 
 * Purpose:
 * 
 * @see	    
 * @since   1.1.0
 */
public class AjaxJsonBusinessAction extends AbstractAjaxBusinessAction
{
    private List<TbLogVisit> datas = new ArrayList<TbLogVisit>();
    private String  testText;
    private Integer intTest;
    
    @AjaxMethod
    @Override
    public String execute()
    {
        System.out.println(testText);
        System.out.println(intTest);
        System.out.println(datas);
        ResultJson resultJson = new ResultJson();
        resultJson.setStatusCode(ResultJson.STATUS_CODE_SUCCESS);
        resultJson.setStatusMessage("网站没有达到3星半，不能申请信用名片！");
        setJsonObject(resultJson);
        return "index";
    }
    public String toAjaxTest()
    {
        System.out.println(testText);
        System.out.println(intTest);
        System.out.println(datas);
        return "index";
    }
    public List<TbLogVisit> getDatas()
    {
        return datas;
    }
    public void setDatas(List<TbLogVisit> datas)
    {
        this.datas = datas;
    }
    public Integer getIntTest()
    {
        return intTest;
    }
    public void setIntTest(Integer intTest)
    {
        this.intTest = intTest;
    }
    public String getTestText()
    {
        return testText;
    }
    public void setTestText(String testText)
    {
        this.testText = testText;
    }
}


/**
 * $Log: AjaxBusinessAction.java,v $
 * 
 * @version 1.0 2015-2-4 
 *
 */