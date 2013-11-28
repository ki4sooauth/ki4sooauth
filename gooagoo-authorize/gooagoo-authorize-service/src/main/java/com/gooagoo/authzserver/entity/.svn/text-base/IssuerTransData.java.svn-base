/**
 * ResultRoot.java
 * 
 * 功  能：返回结果
 * 类  名：ResultRoot
 * 
 * ver    变更日      公司      变更人     变更内容
 * ------------------------------------------------------------
 * V1.00  2013-03-21  sinosoft  Administrator    新建
 * 
 * Copyright@2013 Sinosoft Co.,Ltd. All Rights Reserved.
 * 采用工具 xml2obj(sinosoft version)自动生成，请勿手工修改。
 */
package com.gooagoo.authzserver.entity;

import java.io.Serializable;

import com.google.gson.Gson;

public class IssuerTransData extends TransData implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String objectId;

    public String getObjectId()
    {
        return this.objectId;
    }

    public void setObjectId(String objectId)
    {
        this.objectId = objectId;
    }

    /**
     * 转换成json
     */
    public String toJson()
    {
        Gson json = new Gson();
        return json.toJson(this);
    }

}