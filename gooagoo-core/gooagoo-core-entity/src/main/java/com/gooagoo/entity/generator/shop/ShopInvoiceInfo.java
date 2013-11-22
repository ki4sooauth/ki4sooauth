package com.gooagoo.entity.generator.shop;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体店开发票项目
 */

public class ShopInvoiceInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String shopEntityId;//实体店编号

    private String name1;//个人发票项目名称，多个，json串保存

    private String name2;//公司发票项目名称，多个，json串保存

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getShopEntityId()
    {
        return this.shopEntityId;
    }

    public void setShopEntityId(String shopEntityId)
    {
        this.shopEntityId = shopEntityId;
    }

    public String getName1()
    {
        return this.name1;
    }

    public void setName1(String name1)
    {
        this.name1 = name1;
    }

    public String getName2()
    {
        return this.name2;
    }

    public void setName2(String name2)
    {
        this.name2 = name2;
    }

    public String getIsDel()
    {
        return this.isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

    public Date getCreateTime()
    {
        return this.createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getCTimeStamp()
    {
        return this.cTimeStamp;
    }

    public void setCTimeStamp(Date cTimeStamp)
    {
        this.cTimeStamp = cTimeStamp;
    }

    @Override
    public String toString()
    {
        return this.shopEntityId + "^" + this.name1 + "^" + this.name2 + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
