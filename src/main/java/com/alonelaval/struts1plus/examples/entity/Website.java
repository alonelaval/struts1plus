package com.alonelaval.struts1plus.examples.entity;

import java.util.Date;

/**
 * Created by yubo on 2014/10/29.
 */
public interface Website
{

    //网站类型，根据此类型显示不同的信用详情页面
    public static final Integer WEBSITE_TYPE_DEFAULT      = 0;
    public static final Integer WEBSITE_TYPE_UNCLASSIFIED = 1;
    public static final Integer WEBSITE_TYPE_ECOMMERCE    = 10001; //普通电商网站，例如jd.com,dangdang.com
    public static final Integer WEBSITE_TYPE_TMALL        = 10002; //天猫商城
    
    public static final Integer WEBSITE_TYPE_TRUST_PLANETICKET = 11001;//放心机票
    public static final Integer WEBSITE_TYPE_TRUST_BANK = 11002;//放心银行
    public static final Integer WEBSITE_TYPE_TRUST_HOTEL = 11003;//放心酒店
    public static final Integer WEBSITE_TYPE_TRUST_PAY = 11004;//放心支付
    public static final Integer WEBSITE_TYPE_TRUST_LOTTERY = 11005;//放心购彩
    public static final Integer WEBSITE_TYPE_TRUST_SHOPPING = 11006;//放心购物
    public static final Integer WEBSITE_TYPE_TRUST_EDUCATION = 11007;//放心教育
    public static final Integer WEBSITE_TYPE_TRUST_TOURISM = 11008;//放心旅游
    
    //网站禁用状态
    public static final Integer DISABLED_Y = 1;
    public static final Integer DISABLED_N = 0;

    //网站认领状态
    public static final Integer WEBSITE_UNCLAIMED = 0;  //未认领
    public static final Integer WEBSITE_CLAIMED   = 1;  //已认领

    public Integer getWebsiteId();

    public String getWebsiteName();

    public Integer getWebsiteType();

    public Integer getCurCreditLevel();

    public Integer getCurCreditValue();

    public Integer getCompanyId();

    public String getWebsiteOwner();

    public String getIcp();

    public Date getCreateTime();

    public Date getIncludedTime();

    public Date getLastupdatetime();

    public String getDomain();

    public Integer getGuaranteed();

    public Integer getDeposit();

    public Integer getQueryTimes();

    public Integer getAgreedNum();

    public Integer getOpposedNum();

    public Integer getWebsiteLink();

    public Date getWebsiteStartdate();

    public Integer getClaimStatus();

    public Integer getDataVersion();

    public Integer getDisabled();

    public Integer getCreditNum();

    public Integer getWebsiteCategory();

    public Integer getCreditRank();
    
    public Double getCreditRealLevel();

}
