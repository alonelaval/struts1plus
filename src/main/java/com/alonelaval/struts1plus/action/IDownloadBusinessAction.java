package com.alonelaval.struts1plus.action;


/**
 * 
 * Purpose: 文件下载接口
 * 
 * @see	    
 * @since   1.1.0
 */
public interface IDownloadBusinessAction extends IBusinessAction 
{
    /***
     * 
     * getFileWarpper：<对函数的简单描述>
     * 
     * @return
     * 
     * @author huawei   
     * @see <参见的内容>
     */
    FileWarpper getFileWarpper();
    void setFileWarpper(FileWarpper fileWarpper);
}


/**
 * $Log: IFileBusinessAction.java,v $
 * 
 * @version 1.0 2015-1-27 
 *
 */