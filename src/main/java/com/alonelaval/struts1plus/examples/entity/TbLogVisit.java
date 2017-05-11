package com.alonelaval.struts1plus.examples.entity;

import java.sql.Timestamp;

/**
 * TbLogVisit entity. @author MyEclipse Persistence Tools
 */

public class TbLogVisit implements java.io.Serializable
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

    private Short websiteType;

    private String visitDomain;

    private String srcIp;

    private String destIp;

    // Constructors

    /** default constructor */
    public TbLogVisit()
    {
    }

    /** minimal constructor */
    public TbLogVisit(String deviceId)
    {
        this.deviceId = deviceId;
    }

    /** full constructor */
    public TbLogVisit(String deviceId, String userAgent, String visitUrl, Timestamp visitTime, Short websiteType,
            String visitDomain, String srcIp, String destIp)
    {
        this.deviceId = deviceId;
        this.userAgent = userAgent;
        this.visitUrl = visitUrl;
        this.visitTime = visitTime;
        this.websiteType = websiteType;
        this.visitDomain = visitDomain;
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

    public Short getWebsiteType()
    {
        return this.websiteType;
    }

    public void setWebsiteType(Short websiteType)
    {
        this.websiteType = websiteType;
    }

    public String getVisitDomain()
    {
        return this.visitDomain;
    }

    public void setVisitDomain(String visitDomain)
    {
        this.visitDomain = visitDomain;
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