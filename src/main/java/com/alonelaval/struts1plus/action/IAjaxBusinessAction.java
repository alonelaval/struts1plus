package com.alonelaval.struts1plus.action;
/**
 * 
 * Purpose:Ajax对应的action接口
 * 
 * @see	    
 * @since   1.1.0
 */
public interface IAjaxBusinessAction extends IBusinessAction
{
    /***
     * 
     * getJsonObject：需要进行json处理的对象
     * 
     * @return
     * 
     * @author huawei   
     * @see <参见的内容>
     */
    Object getJsonObject();
    /**
     * 是否由框架来进行转换
     * isConverterJson：<对函数的简单描述>
     * 
     * @return
     * 
     * @author huawei   
     * @see <参见的内容>
     */
    boolean isConverterJson();
    
    void setJsonObject(Object obj);
}


/**
 * $Log: IAjaxBusinessAction.java,v $
 * 
 * @version 1.0 2015-1-26 
 *
 */