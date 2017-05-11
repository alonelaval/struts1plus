package com.alonelaval.struts1plus.examples.entity;

/**
 * TbPerson entity. @author MyEclipse Persistence Tools
 */

public class TbPerson implements java.io.Serializable
{

    // Fields

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Integer personId;

    private String deviceId;

    private String personName;

    private String personIdCard;

    private String personMobile;

    private String personEmail;

    // Constructors

    /** default constructor */
    public TbPerson()
    {
    }

    /** minimal constructor */
    public TbPerson(String deviceId)
    {
        this.deviceId = deviceId;
    }

    /** full constructor */
    public TbPerson(String deviceId, String personName, String personIdCard, String personMobile, String personEmail)
    {
        this.deviceId = deviceId;
        this.personName = personName;
        this.personIdCard = personIdCard;
        this.personMobile = personMobile;
        this.personEmail = personEmail;
    }

    // Property accessors

    public Integer getPersonId()
    {
        return this.personId;
    }

    public void setPersonId(Integer personId)
    {
        this.personId = personId;
    }

    public String getDeviceId()
    {
        return this.deviceId;
    }

    public void setDeviceId(String deviceId)
    {
        this.deviceId = deviceId;
    }

    public String getPersonName()
    {
        return this.personName;
    }

    public void setPersonName(String personName)
    {
        this.personName = personName;
    }

    public String getPersonIdCard()
    {
        return this.personIdCard;
    }

    public void setPersonIdCard(String personIdCard)
    {
        this.personIdCard = personIdCard;
    }

    public String getPersonMobile()
    {
        return this.personMobile;
    }

    public void setPersonMobile(String personMobile)
    {
        this.personMobile = personMobile;
    }

    public String getPersonEmail()
    {
        return this.personEmail;
    }

    public void setPersonEmail(String personEmail)
    {
        this.personEmail = personEmail;
    }

}