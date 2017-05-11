/**
 * @(#)FileValidate.java
 *
 * @author huawei
 * @version 1.0 2015-2-5
 *
 * Copyright (C) 2012,2015 , PING' AN, Inc.
 */
package com.alonelaval.struts1plus.validator.validate;


import org.apache.commons.fileupload.FileItem;

import com.alonelaval.struts1plus.validator.AbstractValidator;
import com.alonelaval.struts1plus.validator.ValidateException;

/**
 * 
 * Purpose:验证上传文件是否合规
 * 
 * @see	    
 * @since   1.1.0
 */
public class FileValidate extends AbstractValidator
{
    private int fileSize;//kB
    private String [] fileTypes;
    public FileValidate(String validateMessage,String errorPath,int fileSize,String... fileTypes){
        setValidateMessage(validateMessage);
        setErrorPath(errorPath);
        this.fileSize =fileSize;
        this.fileTypes = fileTypes;
    }
    
    public boolean doValidate(Object object) throws ValidateException
    {
        if(object == null)
            throw new ValidateException(getValidateMessage(),getErrorPath());
        if(object instanceof FileItem)
        {
            FileItem fileItem = (FileItem) object;
            
            if(fileItem.getSize() == 0){
                throw new ValidateException("上传的文件不能为空!",getErrorPath());
            }
            int fileItemSize = (int) (fileItem.getSize()/1024);
            if(fileSize < fileItemSize){
                throw new ValidateException("上传的文件不能超过"+fileSize/1024+"MB!",getErrorPath());
            }
            String fileType = fileItem.getName();
            fileType = fileType.substring(fileType.lastIndexOf('.')+1,fileType.length());
            if(!isContain(fileType, fileTypes)){
                throw new ValidateException("只能上传文件类型为：\""+getFileTypesAsString(fileTypes)+"\" 的文件",getErrorPath());
            }
            return true;
        }  
        throw new ValidateException(getValidateMessage(),getErrorPath());
    }
    static  boolean isContain(String fileType,String... fileTypes){
        for (String string : fileTypes)
            if(string.equalsIgnoreCase(fileType))
                return true;
        return false;
    }
    static String getFileTypesAsString(String... fileTypes){
        StringBuilder builder = new StringBuilder();
        for (String string : fileTypes)
            builder.append(string).append(",");
        return builder.toString().substring(0, builder.toString().length() -1);
    }
    public static void main(String[] args)
    {
        String [] fileTypes = {"gif","jpg","png"};
        int fileSize = 2048;
        System.out.println(isContain("exe", fileTypes));
        System.out.println(getFileTypesAsString(fileTypes));
    }
}


/**
 * $Log: FileValidate.java,v $
 * 
 * @version 1.0 2015-2-5 
 *
 */