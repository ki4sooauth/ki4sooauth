package com.gooagoo.entity.generator.shop;

import java.io.Serializable;

/**
 * 分段线路信息--导航时需要
 */

public class SectionLineInfoKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String lineId;//路线编号

    public String getLineId()
    {
        return lineId;
    }

    public void setLineId(String lineId)
    {
        this.lineId = lineId;
    }

}
