/**
 * @(#)TestFileBusinessAction.java
 *
 * @author huawei
 * @version 1.0 2015-1-26
 *
 */
package com.alonelaval.struts1plus.examples.business;

import java.io.File;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.fileupload.FileItem;

import com.alonelaval.struts1plus.action.AbstractBusinessAction;
import com.alonelaval.struts1plus.action.FileWarpper;
import com.alonelaval.struts1plus.action.IDownloadBusinessAction;
import com.alonelaval.struts1plus.examples.entity.TestBean2;



/**
 * 
 * Purpose:
 * 
 * @see	    
 * @since   1.1.0
 */
public class TestFileBusinessAction extends AbstractBusinessAction implements IDownloadBusinessAction
{
    private FileItem formFile;
    private FileItem formFile2;
    
    private String  testText;
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
    private Integer integer;
    private TestBean2 testBean =new TestBean2();
    public int testPublic;
    protected int testProtected;
    private BigDecimal bigDecimal;
    private int websiteId;
    private FileWarpper fileWarpper;
    
    @Override
    public String execute()
    {
        setErrorInfo("出错了");
        return "error";
    }
    
    public String getFile()
    {
        fileWarpper =  new FileWarpper(new File("D:/testimage/新建 Microsoft Office Word 文档.docx"),"doc");
        System.out.println(fileWarpper.getFileType());
        return "index";
    }
    public static void main(String[] args)
    {
        TestFileBusinessAction testFileBusinessAction = new TestFileBusinessAction();
        testFileBusinessAction.getFile();
    }
    
    
    public FileWarpper getFileWarpper()
    {
        return fileWarpper;
    }

    
    public FileItem getFormFile()
    {
        return formFile;
    }

    public void setFormFile(FileItem formFile)
    {
        this.formFile = formFile;
    }

    public String getTestText()
    {
        return testText;
    }
    public void setTestText(String testText)
    {
        this.testText = testText;
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
    public int getTestProtected()
    {
        return testProtected;
    }
    public void setTestProtected(int testProtected)
    {
        this.testProtected = testProtected;
    }
    public int getTestPublic()
    {
        return testPublic;
    }
    public void setTestPublic(int testPublic)
    {
        this.testPublic = testPublic;
    }
    public int getWebsiteId()
    {
        return websiteId;
    }
    public void setWebsiteId(int websiteId)
    {
        this.websiteId = websiteId;
    }

    public FileItem getFormFile2()
    {
        return formFile2;
    }

    public void setFormFile2(FileItem formFile2)
    {
        this.formFile2 = formFile2;
    }

    public void setFileWarpper(FileWarpper fileWarpper)
    {
    }

    
        
    
}


/**
 * $Log: TestFileBusinessAction.java,v $
 * 
 * @version 1.0 2015-1-26 
 *
 */