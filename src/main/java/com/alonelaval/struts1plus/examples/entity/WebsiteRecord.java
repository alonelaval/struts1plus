package com.alonelaval.struts1plus.examples.entity;

import java.util.Date;

/**
 * Created by yubo on 2014/10/29.
 */
public class WebsiteRecord implements Website
{

    private Integer websiteId;

    private String websiteName;

    private String domain;

    private Integer websiteType;

    private Integer wesiteCategory;

    private Integer curCreditLevel;

    private Integer curCreditValue;

    private Integer companyId;

    private String websiteOwner;

    private String icp;

    private Integer guaranteed;

    private Integer deposit;

    private Integer queryTimes;

    private Integer agreedNum;

    private Integer opposedNum;

    private Integer websiteLink;

    private Date createTime;

    private Date includedTime;

    private Date lastupdatetime;

    private Date websiteStartdate;

    private Integer claimStatus;

    private Integer dataVersion;

    private Integer disabled;

    private Integer creditNum;

    private Integer websiteCategory;

    private Integer creditRank;

    public Integer getWebsiteId()
    {
        return websiteId;
    }

    public void setWebsiteId(Integer websiteId)
    {
        this.websiteId = websiteId;
    }

    public String getWebsiteName()
    {
        return websiteName;
    }

    public void setWebsiteName(String websiteName)
    {
        this.websiteName = websiteName;
    }

    public Integer getWebsiteType()
    {
        return websiteType;
    }

    public void setWebsiteType(Integer websiteType)
    {
        this.websiteType = websiteType;
    }

    public Integer getCurCreditLevel()
    {
        return curCreditLevel;
    }

    public void setCurCreditLevel(Integer curCreditLevel)
    {
        this.curCreditLevel = curCreditLevel;
    }

    public Integer getCurCreditValue()
    {
        return curCreditValue;
    }

    public void setCurCreditValue(Integer curCreditValue)
    {
        this.curCreditValue = curCreditValue;
    }

    public Integer getCompanyId()
    {
        return companyId;
    }

    public void setCompanyId(Integer companyId)
    {
        this.companyId = companyId;
    }

    public String getWebsiteOwner()
    {
        return websiteOwner;
    }

    public void setWebsiteOwner(String websiteOwner)
    {
        this.websiteOwner = websiteOwner;
    }

    public String getIcp()
    {
        return icp;
    }

    public void setIcp(String icp)
    {
        this.icp = icp;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getIncludedTime()
    {
        return includedTime;
    }

    public void setIncludedTime(Date includedTime)
    {
        this.includedTime = includedTime;
    }

    public Date getLastupdatetime()
    {
        return lastupdatetime;
    }

    public void setLastupdatetime(Date lastupdatetime)
    {
        this.lastupdatetime = lastupdatetime;
    }

    public String getDomain()
    {
        return domain;
    }

    public void setDomain(String domain)
    {
        this.domain = domain;
    }

    public Integer getGuaranteed()
    {
        return guaranteed;
    }

    public void setGuaranteed(Integer guaranteed)
    {
        this.guaranteed = guaranteed;
    }

    public Integer getDeposit()
    {
        return deposit;
    }

    public void setDeposit(Integer deposit)
    {
        this.deposit = deposit;
    }

    public Integer getQueryTimes()
    {
        return queryTimes;
    }

    public void setQueryTimes(Integer queryTimes)
    {
        this.queryTimes = queryTimes;
    }

    public Integer getAgreedNum()
    {
        return agreedNum;
    }

    public void setAgreedNum(Integer agreedNum)
    {
        this.agreedNum = agreedNum;
    }

    public Integer getOpposedNum()
    {
        return opposedNum;
    }

    public void setOpposedNum(Integer opposedNum)
    {
        this.opposedNum = opposedNum;
    }

    public Integer getWebsiteLink()
    {
        return websiteLink;
    }

    public void setWebsiteLink(Integer websiteLink)
    {
        this.websiteLink = websiteLink;
    }

    public Date getWebsiteStartdate()
    {
        return websiteStartdate;
    }

    public void setWebsiteStartdate(Date websiteStartdate)
    {
        this.websiteStartdate = websiteStartdate;
    }

    public Integer getClaimStatus()
    {
        return claimStatus;
    }

    public void setClaimStatus(Integer claimStatus)
    {
        this.claimStatus = claimStatus;
    }

    public Integer getDataVersion()
    {
        return dataVersion;
    }

    public void setDataVersion(Integer dataVersion)
    {
        this.dataVersion = dataVersion;
    }

    public Integer getDisabled()
    {
        return disabled;
    }

    public void setDisabled(Integer disabled)
    {
        this.disabled = disabled;
    }

	public Integer getCreditNum()
	{
		return creditNum;
	}

	public void setCreditNum(Integer creditNum)
	{
		this.creditNum = creditNum;
	}

	public Integer getWebsiteCategory()
    {
        return websiteCategory;
    }

    public void setWebsiteCategory(Integer websiteCategory)
    {
        this.websiteCategory = websiteCategory;
    }

    public Integer getWesiteCategory()
    {
        return wesiteCategory;
    }

    public void setWesiteCategory(Integer wesiteCategory)
    {
        this.wesiteCategory = wesiteCategory;
    }

    public Integer getCreditRank()
    {
        return creditRank;
    }

    public void setCreditRank(Integer creditRank)
    {
        this.creditRank = creditRank;
    }

    @Override
    public Double getCreditRealLevel()
    {
        return this.getCurCreditLevel()/10d;
    }

    public WebsiteRecord(Integer websiteId)
    {
        super();
        this.websiteId = websiteId;
    }

}
