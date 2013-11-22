package com.gooagoo.trans.entity.transdata;

import java.io.Serializable;

import com.google.gson.Gson;

public class GtsTransData extends TransData implements Serializable
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