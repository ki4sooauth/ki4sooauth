package com.gooagoo.dao.generator.shop;

import java.util.List;

import com.gooagoo.entity.generator.shop.AreaPara;
import com.gooagoo.entity.generator.shop.AreaParaExample;
import com.gooagoo.entity.generator.shop.AreaParaKey;

public interface AreaParaMapper
{

    public Integer countByExample(AreaParaExample areaParaExample);

    public List<AreaPara> selectByExample(AreaParaExample areaParaExample);

    public AreaPara selectByPrimaryKey(AreaParaKey areaParaKey);

}
