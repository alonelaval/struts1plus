/**
 * @(#)TestAjaxBusinessAction.java
 *
 * @author huawei
 * @version 1.0 2015-1-26
 *
 */
package com.alonelaval.struts1plus.examples.business;

import java.util.ArrayList;
import java.util.List;

import com.alonelaval.struts1plus.action.AbstractAjaxBusinessAction;
import com.alonelaval.struts1plus.examples.entity.TbLogVisit;


/**
 * 
 * Purpose:ajax请求，ajax输出
 * 
 * @see	    
 * @since   1.1.0
 */
public class TestAjaxBusinessAction extends AbstractAjaxBusinessAction
{
    private List<TbLogVisit> datas = new ArrayList<TbLogVisit>();
    public String execute()
    {
        initData();
        setJsonObject(datas);
        return null;
    }
    
    private void initData(){
        for (int i = 0; i < 10; i++)
        {
            TbLogVisit visit = new TbLogVisit();
            visit.setDestIp("测试"+i);
            visit.setDeviceId("测试"+i);
            datas.add(visit);
        }
    }
    
    public String getJson(){
        System.out.println("getJson");
        return null;
    }

    public List<TbLogVisit> getDatas()
    {
        return datas;
    }

    public void setDatas(List<TbLogVisit> datas)
    {
        this.datas = datas;
    }

}


/**
 * $Log: TestAjaxBusinessAction.java,v $
 * 
 * @version 1.0 2015-1-26 
 *
 */