package com.gooagoo.view.gms.good;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用校验信息，校验json串，支持品类、实体店、会员等级
 */
public class FGoodsFeatureList implements Serializable
{
    private static final long serialVersionUID = 1L;
    private List<String> featureCode = new ArrayList<String>(); //商品特征编号
    private List<String> featureName = new ArrayList<String>(); //商品特征名称
    private List<String> featureValue = new ArrayList<String>(); //商品特征项值

    public List<String> getFeatureCode()
    {
        return featureCode;
    }

    public void setFeatureCode(List<String> featureCode)
    {
        this.featureCode = featureCode;
    }

    public List<String> getFeatureName()
    {
        return featureName;
    }

    public void setFeatureName(List<String> featureName)
    {
        this.featureName = featureName;
    }

    public List<String> getFeatureValue()
    {
        return featureValue;
    }

    public void setFeatureValue(List<String> featureValue)
    {
        this.featureValue = featureValue;
    }

}
