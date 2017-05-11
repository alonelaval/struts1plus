
package com.alonelaval.struts1plus.examples.business;

import java.io.File;

import com.alonelaval.struts1plus.action.AbstractBusinessAction;
import com.alonelaval.struts1plus.action.FileWarpper;
import com.alonelaval.struts1plus.action.IDownloadBusinessAction;
import com.alonelaval.struts1plus.annotation.FileMethod;


/**
 * 
 * Purpose:
 * 
 * @see	    
 * @since   1.1.0
 */
public class DownloadFileAction extends AbstractBusinessAction implements IDownloadBusinessAction
{
    private FileWarpper fileWarpper;
    public FileWarpper getFileWarpper()
    {
        return fileWarpper;
    }

    public void setFileWarpper(FileWarpper fileWarpper)
    {
        this.fileWarpper =fileWarpper;
    }
    @FileMethod
    @Override
    public String execute()
    {
        try
        {
            setFileWarpper(new FileWarpper(new File(getClass().getResource("timg.jpeg").getFile()),"jpg"));
//            throw new Exception("文件下载失败！");
        }
        catch (Exception e)
        {
         setErrorInfo(e.getMessage());
        }
        return "download";
    }
    public String testDownload()
    {
        try
        {
           System.out.println("111111111111111111111111");
        }
        catch (Exception e)
        {
         setErrorInfo(e.getMessage());
        }
        return "download";
    }
}


/**
 * $Log: DownloadFileAction.java,v $
 * 
 * @version 1.0 2015-2-5 
 *
 */