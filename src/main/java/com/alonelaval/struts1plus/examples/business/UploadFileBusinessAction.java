/**
 * @(#)UploadFileAction.java
 *
 * @author huawei
 * @version 1.0 2015-2-4
 *
 */
package com.alonelaval.struts1plus.examples.business;

import org.apache.commons.fileupload.FileItem;

import com.alonelaval.struts1plus.action.AbstractBusinessAction;



/**
 * 
 * Purpose: 文件上传
 * 
 * @see	    
 * @since   1.1.0
 */
public class UploadFileBusinessAction extends AbstractBusinessAction
{
    private FileItem formFile;
    
    private String  testText;
    private Integer intTest;
    
    @Override
    public String execute()
    {
        System.out.println(formFile.getName());
        System.out.println(formFile.getSize());
        setMessage("上传成功！");
        return "upload";
    }
    
    public FileItem getFormFile()
    {
        return formFile;
    }
    public void setFormFile(FileItem formFile)
    {
        this.formFile = formFile;
    }
    public String getTestText()
    {
        return testText;
    }
    public void setTestText(String testText)
    {
        this.testText = testText;
    }

    public Integer getIntTest()
    {
        return intTest;
    }

    public void setIntTest(Integer intTest)
    {
        this.intTest = intTest;
    }
    
}


/**
 * $Log: UploadFileAction.java,v $
 * 
 * @version 1.0 2015-2-4 
 *
 */