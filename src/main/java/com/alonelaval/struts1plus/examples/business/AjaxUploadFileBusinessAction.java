
package com.alonelaval.struts1plus.examples.business;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.fileupload.FileItem;

import com.alonelaval.struts1plus.action.AbstractAjaxBusinessAction;
import com.alonelaval.struts1plus.action.ResultJson;
import com.alonelaval.struts1plus.annotation.AjaxMethod;
import com.alonelaval.struts1plus.annotation.FileMethod;
import com.alonelaval.struts1plus.annotation.RedirectUrlParamMethod;
import com.alonelaval.struts1plus.annotation.UrlOverrideMethod;
import com.alonelaval.struts1plus.examples.entity.TbLogVisit;


/**
 * 
 * Purpose:
 * 
 * @see	    
 * @since   1.1.0
 */
public class AjaxUploadFileBusinessAction extends AbstractAjaxBusinessAction
{
    private List<TbLogVisit> datas = new ArrayList<TbLogVisit>();
    private FileItem fileToUpload;
    private FileItem fileToUpload2;
    private String  testText;
    private Integer intTest;
    private Integer intTest2;
    @UrlOverrideMethod(forwardName="1111",paramsName={})
    @RedirectUrlParamMethod(forwardName="11",paramsName={})
    @FileMethod
    @AjaxMethod
    @Override
    public String execute()
    {
        System.out.println(fileToUpload);
        System.out.println(fileToUpload.getName());
        System.out.println(fileToUpload.getSize());
        System.out.println(fileToUpload.getContentType());
        String fileType = fileToUpload.getName();
        System.out.println(intTest2);
        ResultJson resultJson = new ResultJson();
        resultJson.setStatusCode(ResultJson.STATUS_CODE_SUCCESS);
        resultJson.setStatusMessage("上传成功！");
        setJsonObject(resultJson);
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
    public FileItem getFileToUpload()
    {
        return fileToUpload;
    }
    public void setFileToUpload(FileItem fileToUpload)
    {
        this.fileToUpload = fileToUpload;
    }
    public FileItem getFileToUpload2()
    {
        return fileToUpload2;
    }
    public void setFileToUpload2(FileItem fileToUpload2)
    {
        this.fileToUpload2 = fileToUpload2;
    }
    public Integer getIntTest2()
    {
        return intTest2;
    }
    public void setIntTest2(Integer intTest2)
    {
        this.intTest2 = intTest2;
    }
    
}


/**
 * $Log: AjaxBusinessAction.java,v $
 * 
 * @version 1.0 2015-2-4 
 *
 */