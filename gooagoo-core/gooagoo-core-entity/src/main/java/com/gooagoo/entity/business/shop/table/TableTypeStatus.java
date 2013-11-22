package com.gooagoo.entity.business.shop.table;

import java.io.Serializable;
import java.util.List;

/**
 *  商家列表 
 */
public class TableTypeStatus implements Serializable
{

    private static final long serialVersionUID = 1L;

    /** 餐桌类型编码  */
    private String tableTypeCode = "";

    /** 餐桌类型名称  */
    private String tableTypeName = "";
    /** 建议最小人数 */
    private String minNums = "";
    /** 建议最大人数  */
    private String maxNums = "";

    /** 当前类型餐桌总数  */
    private String tableTypeSum = "";

    /** 空闲数  */
    private String vacancynum = "";

    /** 正在结账数  */
    private String checkoutnum = "";

    /** 正在用餐数量  */
    private String usenum = "";

    /** 共有多少人排队等待使用当前类型的桌子  */
    private String queuenum = "";

    /** 排队号码列表 */
    private List<String> queueList;

    public String getTableTypeCode()
    {
        return this.tableTypeCode;
    }

    public void setTableTypeCode(String tableTypeCode)
    {
        this.tableTypeCode = tableTypeCode;
    }

    public String getTableTypeName()
    {
        return this.tableTypeName;
    }

    public void setTableTypeName(String tableTypeName)
    {
        this.tableTypeName = tableTypeName;
    }

    public String getMinNums()
    {
        return this.minNums;
    }

    public void setMinNums(String minNums)
    {
        this.minNums = minNums;
    }

    public String getMaxNums()
    {
        return this.maxNums;
    }

    public void setMaxNums(String maxNums)
    {
        this.maxNums = maxNums;
    }

    public String getTableTypeSum()
    {
        return this.tableTypeSum;
    }

    public void setTableTypeSum(String tableTypeSum)
    {
        this.tableTypeSum = tableTypeSum;
    }

    public String getVacancynum()
    {
        return this.vacancynum;
    }

    public void setVacancynum(String vacancynum)
    {
        this.vacancynum = vacancynum;
    }

    public String getCheckoutnum()
    {
        return this.checkoutnum;
    }

    public void setCheckoutnum(String checkoutnum)
    {
        this.checkoutnum = checkoutnum;
    }

    public String getUsenum()
    {
        return this.usenum;
    }

    public void setUsenum(String usenum)
    {
        this.usenum = usenum;
    }

    public String getQueuenum()
    {
        return this.queuenum;
    }

    public void setQueuenum(String queuenum)
    {
        this.queuenum = queuenum;
    }

    public List<String> getQueueList()
    {
        return this.queueList;
    }

    public void setQueueList(List<String> queueList)
    {
        this.queueList = queueList;
    }

    @Override
    public String toString()
    {
        return "TableTypeStatus [tableTypeCode=" + this.tableTypeCode + ", tableTypeName=" + this.tableTypeName + ", minNums=" + this.minNums + ", maxNums=" + this.maxNums + ", tableTypeSum=" + this.tableTypeSum + ", vacancynum=" + this.vacancynum + ", checkoutnum=" + this.checkoutnum + ", usenum=" + this.usenum + ", queuenum=" + this.queuenum + ", queueList=" + this.queueList + "]";
    }

}
