package com.gooagoo.view.gms.marketing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 营销模板
 */
public class FTemplateData implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String templateDataId;//模板数据id（主键）
    private String templateId;//模板id
    private String shopId;//商家id
    private String shopEntityId;//商家实体店id
    private String dataSource;//数据来源（A-活动，E-事件，C-优惠凭证）
    private List<String> data = new ArrayList<String>();//数据 key=data1,data2...datan

    public String getTemplateDataId()
    {
        return this.templateDataId;
    }

    public void setTemplateDataId(String templateDataId)
    {
        this.templateDataId = templateDataId;
    }

    public String getTemplateId()
    {
        return this.templateId;
    }

    public void setTemplateId(String templateId)
    {
        this.templateId = templateId;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getShopEntityId()
    {
        return this.shopEntityId;
    }

    public void setShopEntityId(String shopEntityId)
    {
        this.shopEntityId = shopEntityId;
    }

    public String getDataSource()
    {
        return this.dataSource;
    }

    public void setDataSource(String dataSource)
    {
        this.dataSource = dataSource;
    }

    public List<String> getData()
    {
        return this.data;
    }

    public void setData(List<String> data)
    {
        this.data = data;
    }

}
