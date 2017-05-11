package com.alonelaval.struts1plus.action;
/**
 *
 * Purpose:
 *
 * @see
 * @since   1.1.0
 */
public class ResultJson
{
    //ajax 请求服务器代码放回状态
    //成功
    public static final Integer STATUS_CODE_SUCCESS = 1;
//  失败
    public static final Integer STATUS_CODE_FAIL = 2;
    //出现异常
    public static final Integer STATUS_CODE_EXCEPTION = 0;
    //请求参数错误代码
    public static final Integer STATUS_CODE_PARAM_ERROR = -1;
   // 数据库获取不到数据信息错误
    public static final Integer STATUS_CODE_DATA_ERROR = -2;
    // SESSION 失效错误
    public static final Integer STATUS_CODE_SESSION_INVALID = -99;

    private int statusCode;

    private String statusMessage;
    
    private Object data;

    public int getStatusCode()
    {
        return statusCode;
    }

    public void setStatusCode(int statusCode)
    {
        this.statusCode = statusCode;
    }

    public String getStatusMessage()
    {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage)
    {
        this.statusMessage = statusMessage;
    }

    public Object getData()
    {
        return data;
    }

    public void setData(Object data)
    {
        this.data = data;
    }

}


/**
 * $Log: ResultJson.java,v $
 *
 * @version 1.0 2014年10月31日
 *
 */