package com.gooagoo.entity.business.goods;

import java.io.Serializable;
import java.util.List;

/**
 * 商品特征(用于商品发布)
 */

public class GoodsFeatureBusiness implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String featureCode;//特征编码，如color

    private String featureName;//特征名称，如颜色

    private List<String> featureValueList;//特征数值，如蓝色

    public String getFeatureCode()
    {
        return this.featureCode;
    }

    public void setFeatureCode(String featureCode)
    {
        this.featureCode = featureCode;
    }

    public String getFeatureName()
    {
        return this.featureName;
    }

    public void setFeatureName(String featureName)
    {
        this.featureName = featureName;
    }

    public List<String> getFeatureValueList()
    {
        return this.featureValueList;
    }

    public void setFeatureValueList(List<String> featureValueList)
    {
        this.featureValueList = featureValueList;
    }

}
