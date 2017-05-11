package com.alonelaval.struts1plus.action;

import java.util.List;
import java.util.Map;

/**
 * 
 * Purpose:
 * 
 * @see	    
 * @since   1.1.0
 */
public class NewPage
{
    
    private int currentPage = 1; //当前的页数
    private int totalCount; //总共多少行
    private int pageNum ;    //每一页多少行数据
    private int pageItemNum; //分页条目 显示多少条 1 2 3 4 5 默认按每一页多少条数据来
    private int pageCount;  //一共多少页
    private List data; //当前页的数据
    private boolean hasNext;//是否有下一页
    private boolean hasPre;//是否有上一页
    private int begin;
    private int end;
    private String orderBy;
    private String groupBy;
    private boolean isAsc = false;
    private Map values;
    private boolean hasPaging;
    
    public boolean isHasPaging()
    {
        return  hasPaging;
    }

    public void setHasPaging(boolean hasPaging)
    {
        this.hasPaging = hasPaging ;
    }

    public NewPage()
    {
    }
    
    public NewPage(int pageNum)
    {
        this.pageNum = pageNum;
        this.pageItemNum = pageNum;
    }
   

    public boolean getHasNext(){
        if(getPageCount() == currentPage)
            hasNext = false;
        else
            hasNext = true;
        return hasNext;   
    }
    public boolean getHasPre(){
        if(currentPage == 1)
            hasPre = false;
        else
            hasPre = true;
        return hasPre;
    }
    
    public int getCurrentPage()
    {
        return currentPage;
    }
    public void setCurrentPage(int currentPage)
    {   
        this.currentPage = currentPage;
    }
    public int getPageCount()
    {
        return pageCount;
    }
    public int getTotalCount()
    {
        return totalCount;
    }
    public void setTotalCount(int totalCount)
    {
        this.totalCount = totalCount;
        compute();
        this.setHasPaging(getPageCount() > 1);
    }
    
    public boolean getIsAsc()
    {
        return isAsc;
    }
    public void setIsAsc(boolean isAsc)
    {
        this.isAsc = isAsc;
    }
    public List getData()
    {
        return data;
    }
    public void setData(List data)
    {
        this.data = data;
    }
    public int getPageNum()
    {
        return pageNum;
    }
    public void setPageNum(int pageNum)
    {
        this.pageNum = pageNum;
        if(this.pageItemNum == 0)
            this.pageItemNum = pageNum;
    }
    public static void main(String[] args)
    {
        NewPage page = new NewPage();
        page.setCurrentPage(10);
        page.setPageNum(10);
        page.setTotalCount(200);
        System.out.println(page.getBegin());
        System.out.println(page.getEnd());
        System.out.println(page.getPageCount());
    }
    private void compute(){
        if(totalCount % pageNum == 0){
            pageCount = totalCount/pageNum;
        }
        else
        {
           pageCount = (totalCount/pageNum) +1;
        }
        
        begin = computeBegin(this.currentPage,this.pageItemNum)+1;
        
        end = computeEnd(pageCount, currentPage, this.pageItemNum);
        
    }
    
   
    private  int computeBegin(int currentPage,int pageNum){
        if(currentPage%pageNum  == 0)
        {
            return currentPage/pageNum *pageNum - pageNum;
        }
        return (currentPage/pageNum)*pageNum;
    }
    
    
    private  int computeEnd(int pageCount,int currentPage,int pageNum){
        if(currentPage%pageNum == 0){
            return currentPage; 
        }
        if((currentPage / pageNum) < (pageCount/pageNum)){
            return (currentPage/pageNum)*pageNum+pageNum; 
        }
        if((currentPage / pageNum) == (pageCount/pageNum)){
            if(currentPage == pageCount)
                return currentPage;
            else {
                return pageCount; 
            }
        }
        return 0;
    }
    
    
    public int getPageItemNum()
    {
        return pageItemNum;
    }

    public void setPageItemNum(int pageItemNum)
    {
        this.pageItemNum = pageItemNum;
    }

    public  int getBegin(){
        return begin;
    }
    public  int getEnd(){
        return end;
    }
    public String getGroupBy()
    {
        return groupBy;
    }
    public void setGroupBy(String groupBy)
    {
        this.groupBy = groupBy;
    }
    public String getOrderBy()
    {
        return orderBy;
    }
    public void setOrderBy(String orderBy)
    {
        this.orderBy = orderBy;
    }
    
//    public void setPageAdapter(PageAdapter pageAdapter){
//        this.setTotalCount(pageAdapter.getTotalNum());
//    }

    public Map getValues()
    {
        return values;
    }

    public void setValues(Map values)
    {
        this.values = values;
    }
    
}


/**
 * $Log: Page.java,v $
 * 
 * @version 1.0 2015-2-9 
 *
 */