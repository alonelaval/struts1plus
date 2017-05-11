package com.alonelaval.struts1plus.examples.business;

import java.math.BigDecimal;
import java.util.Date;

import com.alonelaval.struts1plus.action.AbstractBusinessAction;
import com.alonelaval.struts1plus.examples.entity.TestBean2;


public class TestBusinessAction extends AbstractBusinessAction  {
    
    private int intTest;
    private Date dateTest;
    private String stringTest;
    private boolean booleanTest;
    private float floatTest;
    private byte byteTest;
    private double doubleTest;
    private short shortTest;
    private long longTest;
    private char charTest;
    private TestBean2 testBean =new TestBean2();
    public int testPublic;
    protected int testProtected;
    private BigDecimal bigDecimal;
    private int websiteId;
    
    
    public String addUser(){
        System.out.println("addUserTest");
        return "index";
    }

    
    @Override
    public String execute()
    {
        System.out.println("TestBusinessAction");
        return "index";
    }



    public BigDecimal getBigDecimal()
    {
        return bigDecimal;
    }


    public void setBigDecimal(BigDecimal bigDecimal)
    {
        this.bigDecimal = bigDecimal;
    }


    public boolean isBooleanTest()
    {
        return booleanTest;
    }


    public void setBooleanTest(boolean booleanTest)
    {
        this.booleanTest = booleanTest;
    }


    public byte getByteTest()
    {
        return byteTest;
    }


    public void setByteTest(byte byteTest)
    {
        this.byteTest = byteTest;
    }


    public char getCharTest()
    {
        return charTest;
    }


    public void setCharTest(char charTest)
    {
        this.charTest = charTest;
    }


    public Date getDateTest()
    {
        return dateTest;
    }


    public void setDateTest(Date dateTest)
    {
        this.dateTest = dateTest;
    }


    public double getDoubleTest()
    {
        return doubleTest;
    }


    public void setDoubleTest(double doubleTest)
    {
        this.doubleTest = doubleTest;
    }


    public float getFloatTest()
    {
        return floatTest;
    }


    public void setFloatTest(float floatTest)
    {
        this.floatTest = floatTest;
    }


    public int getIntTest()
    {
        return intTest;
    }


    public void setIntTest(int intTest)
    {
        this.intTest = intTest;
    }


    public long getLongTest()
    {
        return longTest;
    }


    public void setLongTest(long longTest)
    {
        this.longTest = longTest;
    }


    public short getShortTest()
    {
        return shortTest;
    }


    public void setShortTest(short shortTest)
    {
        this.shortTest = shortTest;
    }


    public String getStringTest()
    {
        return stringTest;
    }


    public void setStringTest(String stringTest)
    {
        this.stringTest = stringTest;
    }


    public TestBean2 getTestBean()
    {
        return testBean;
    }


    public void setTestBean(TestBean2 testBean)
    {
        this.testBean = testBean;
    }

    public int getWebsiteId()
    {
        return websiteId;
    }

    public void setWebsiteId(int websiteId)
    {
        this.websiteId = websiteId;
    }
    
}
