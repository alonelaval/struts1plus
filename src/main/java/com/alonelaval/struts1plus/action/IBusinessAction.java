package com.alonelaval.struts1plus.action;
/**
 * 
 * Purpose:业务Action接口
 * 
 * @see	    
 * @since   1.1.0
 */
public interface IBusinessAction
{
    /**
     * 
     * getErrorInfo：<对函数的简单描述>
     * 
     * @return
     * 
     * @author huawei   
     * @see <参见的内容>
     */
    String getErrorInfo();
    void setErrorInfo(String ErrorInfo);
    void setMessage(String message);
    String getMessage();
    /***
     * 
     * execute：默认调用的action方法
     * 
     * @return
     * 
     * @author huawei   
     * @see <参见的内容>
     */
    String execute();
}


/**
 * $Log: IBusinessAction.java,v $
 * 
 * @version 1.0 2015-1-23 
 *
 */