package com.gooagoo.entity.business.marketing;

import java.io.Serializable;

public class IsdeletedInfo implements Serializable
{

    /**
     * 记录被删除的信息
     */
    private static final long serialVersionUID = 1L;

    /** ，字符串，已删除通知的编号，多个用逗号分隔开  */
    private String idstr;

    /** 返回通知的总条数是否大于每页信息显示条数，若大于flag=Y，反之Flag=N  */
    private String flag;

    /**  记录平台返回通知信息中 最大的时间戳  */
    private String ctimestamp;

    /**
     * 设置，字符串，已删除通知的编号，多个用逗号分隔开 
     * @param noticeidstr   ，字符串，已删除通知的编号，多个用逗号分隔开 
     */
    public void setIdstr(String idstr)
    {
        this.idstr = idstr;
    }

    /**
     * 获取，字符串，已删除通知的编号，多个用逗号分隔开 
     * @return  ，字符串，已删除通知的编号，多个用逗号分隔开 
     */

    public String getIdstr()
    {
        return this.idstr;
    }

    /**
     * 设置返回通知的总条数是否大于每页信息显示条数，若大于flag=Y，反之Flag=N 
     * @param flag  返回通知的总条数是否大于每页信息显示条数，若大于flag=Y，反之Flag=N 
     */
    public void setFlag(String flag)
    {
        this.flag = flag;
    }

    /**
     * 获取返回通知的总条数是否大于每页信息显示条数，若大于flag=Y，反之Flag=N 
     * @return  返回通知的总条数是否大于每页信息显示条数，若大于flag=Y，反之Flag=N 
     */
    public String getFlag()
    {
        return this.flag;
    }

    /**
     * 设置 记录平台返回通知信息中 最大的时间戳 
     * @param ctimestamp     记录平台返回通知信息中 最大的时间戳 
     */
    public void setCtimestamp(String ctimestamp)
    {
        this.ctimestamp = ctimestamp;
    }

    /**
     * 获取 记录平台返回通知信息中 最大的时间戳 
     * @return   记录平台返回通知信息中 最大的时间戳 
     */
    public String getCtimestamp()
    {
        return this.ctimestamp;
    }
}
