package com.alonelaval.struts1plus.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.alonelaval.struts1plus.annotation.AnnotationProcesUtil;
import com.alonelaval.struts1plus.annotation.FileMethod;



/**
 * 
 * Purpose: 抽象的strutsAction，该Action将承担数据验证，数据转换，数据封装到对应的业务aciotn中，
 * 而业务Action将纯粹的担任业务调用，如数据查询，数据更新，业务处理，根据对应的返回字符,返回到改Action中
 * 该strutsAction将负责转发具体业务Action中返回的路径字符，json,文件
 * 可以继续往下抽象，具体的业务模块可以抽象一个baseStrutsAction,用来做session，数据权限等验证
 * @see	    
 * @since   1.1.0
 */
public abstract class AbstractDownloadBaseAction extends AbstractBaseStrutsAction
{

    @Override
    protected final ActionForward getResponseActionForward(ActionMapping mapping, HttpServletResponse response, HttpServletRequest request, IBusinessAction businessAction, String result,Method method) throws Exception
    {
        if(businessAction instanceof IDownloadBusinessAction && AnnotationProcesUtil.getInstance().check(method,FileMethod.class)){
          IDownloadBusinessAction fileBusinessAction = (IDownloadBusinessAction)businessAction;
          if(fileResponse(fileBusinessAction, response)) //下载成功
              return null;
        }
        return super.getResponseActionForward(mapping, response, request, businessAction, result, method);
    }   
    
    private boolean fileResponse(IDownloadBusinessAction fileBusinessAction, HttpServletResponse response)throws Exception
    {
        
        FileWarpper fileWarpper = fileBusinessAction.getFileWarpper();
        if(fileWarpper == null)
            return false;
        File file = fileWarpper.getFile();
        if (file != null && file.exists() && file.isFile())
        {
            response.reset();
            OutputStream out = response.getOutputStream();
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + file.getName());
            response.setHeader("Content_Length", String.valueOf(file.length()));
            // set the MIME type.
            response.setContentType(fileWarpper.getFileType());
            // get the file length.
            BufferedInputStream br = new BufferedInputStream(new FileInputStream(file));
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = br.read(buf)) > 0)
            {
                out.write(buf, 0, len);
            }
            br.close();
            out.close();
        }
        return true;
    }
}


/**
 * $Log: BaseAction.java,v $
 * 
 * @version 1.0 2015-1-23 
 *
 */