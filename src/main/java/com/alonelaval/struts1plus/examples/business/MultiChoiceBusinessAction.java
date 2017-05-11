/**
 * @(#)MultiChoiceBusinessAction.java
 *
 * @author huawei
 * @version 1.0 2015-2-6
 *
 */
package com.alonelaval.struts1plus.examples.business;

import java.util.List;

import com.alonelaval.struts1plus.action.AbstractBusinessAction;


/**
 * 
 * Purpose:
 * 
 * @see	    
 * @since   1.1.0
 */
public class MultiChoiceBusinessAction extends AbstractBusinessAction
{
    private String  testText;
    private Integer intTest;
    private String []  favouriteFruits;
    private List hobbys;
    private int [] movies;
    
    @Override
    public String execute()
    {
        System.out.println("this is MultiChoiceBusinessAction!");   
        return "multiChoice";
    }
    public String[] getFavouriteFruits()
    {
        return favouriteFruits;
    }
    public void setFavouriteFruits(String[] favouriteFruits)
    {
        this.favouriteFruits = favouriteFruits;
    }
    public Integer getIntTest()
    {
        return intTest;
    }
    public void setIntTest(Integer intTest)
    {
        this.intTest = intTest;
    }
    public String getTestText()
    {
        return testText;
    }
    public void setTestText(String testText)
    {
        this.testText = testText;
    }
    public List getHobbys()
    {
        return hobbys;
    }
    public void setHobbys(List hobbys)
    {
        this.hobbys = hobbys;
    }
    public int[] getMovies()
    {
        return movies;
    }
    public void setMovies(int[] movies)
    {
        this.movies = movies;
    }
    
}


/**
 * $Log: MultiChoiceBusinessAction.java,v $
 * 
 * @version 1.0 2015-2-6 
 *
 */