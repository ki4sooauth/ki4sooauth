package com.gooagoo.entity.business.user;

import java.io.Serializable;
import java.util.List;

import com.gooagoo.entity.generator.shop.GeneratrixInfo;
import com.gooagoo.entity.generator.shop.SectionLineInfo;

/**
 * 商家地图svg详细信息
 */

public class AreaParaDetail implements Serializable
{

    private static final long serialVersionUID = 1L;

    // 动线信息
    private List<GeneratrixInfo> generatrixInfos;
    // 分段线信息
    private List<SectionLineInfo> sectionLineInfos;

    public List<GeneratrixInfo> getGeneratrixInfos()
    {
        return this.generatrixInfos;
    }

    public void setGeneratrixInfos(List<GeneratrixInfo> generatrixInfos)
    {
        this.generatrixInfos = generatrixInfos;
    }

    public List<SectionLineInfo> getSectionLineInfos()
    {
        return this.sectionLineInfos;
    }

    public void setSectionLineInfos(List<SectionLineInfo> sectionLineInfos)
    {
        this.sectionLineInfos = sectionLineInfos;
    }

}
