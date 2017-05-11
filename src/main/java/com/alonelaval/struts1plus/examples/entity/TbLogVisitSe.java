package com.alonelaval.struts1plus.examples.entity;

import java.sql.Timestamp;

/**
 * TbLogVisitSe entity. @author MyEclipse Persistence Tools
 */

public class TbLogVisitSe implements java.io.Serializable
{

    // Fields

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Integer logId;

    private String deviceId;

    private String userAgent;

    private String visitUrl;

    private Timestamp visitTime;

    private Short seType;

    private String keyWords;

    private Short keyWordsType;

    private String srcIp;

    private String destIp;

    // Constructors

    /** default constructor */
    public TbLogVisitSe()
    {
    }

    /** minimal constructor */
    public TbLogVisitSe(String deviceId)
    {
        this.deviceId = deviceId;
    }

    /** full constructor */
    public TbLogVisitSe(String deviceId, String userAgent, String visitUrl, Timestamp visitTime, Short seType,
            String keyWords, Short keyWordsType, String srcIp, String destIp)
    {
        this.deviceId = deviceId;
        this.userAgent = userAgent;
        this.visitUrl = visitUrl;
        this.visitTime = visitTime;
        this.seType = seType;
        this.keyWords = keyWords;
        this.keyWordsType = keyWordsType;
        this.srcIp = srcIp;
        this.destIp = destIp;
    }

    // Property accessors

    public Integer getLogId()
    {
        return this.logId;
    }

    public void setLogId(Integer logId)
    {
        this.logId = logId;
    }

    public String getDeviceId()
    {
        return this.deviceId;
    }

    public void setDeviceId(String deviceId)
    {
        this.deviceId = deviceId;
    }

    public String getUserAgent()
    {
        return this.userAgent;
    }

    public void setUserAgent(String userAgent)
    {
        this.userAgent = userAgent;
    }

    public String getVisitUrl()
    {
        return this.visitUrl;
    }

    public void setVisitUrl(String visitUrl)
    {
        this.visitUrl = visitUrl;
    }

    public Timestamp getVisitTime()
    {
        return this.visitTime;
    }

    public void setVisitTime(Timestamp visitTime)
    {
        this.visitTime = visitTime;
    }

    public Short getSeType()
    {
        return this.seType;
    }

    public void setSeType(Short seType)
    {
        this.seType = seType;
    }

    public String getKeyWords()
    {
        return this.keyWords;
    }

    public void setKeyWords(String keyWords)
    {
        this.keyWords = keyWords;
    }

    public Short getKeyWordsType()
    {
        return this.keyWordsType;
    }

    public void setKeyWordsType(Short keyWordsType)
    {
        this.keyWordsType = keyWordsType;
    }

    public String getSrcIp()
    {
        return this.srcIp;
    }

    public void setSrcIp(String srcIp)
    {
        this.srcIp = srcIp;
    }

    public String getDestIp()
    {
        return this.destIp;
    }

    public void setDestIp(String destIp)
    {
        this.destIp = destIp;
    }

}