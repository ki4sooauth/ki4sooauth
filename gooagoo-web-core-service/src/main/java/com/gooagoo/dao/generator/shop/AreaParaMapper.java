package com.gooagoo.dao.generator.shop;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.shop.AreaPara;
import com.gooagoo.entity.generator.shop.AreaParaExample;
import com.gooagoo.entity.generator.shop.AreaParaKey;

public interface AreaParaMapper
{

    public Integer countByExample(AreaParaExample areaParaExample);

    public List<AreaPara> selectByExample(AreaParaExample areaParaExample);

    public AreaPara selectByPrimaryKey(AreaParaKey areaParaKey);

    public Integer deleteByExample(AreaParaExample areaParaExample);

    public Integer deleteByPrimaryKey(AreaParaKey areaParaKey);

    public Integer insertSelective(AreaPara areaPara);

    public Integer updateAllByExample(@Param("record") AreaPara areaPara, @Param("example") AreaParaExample areaParaExample);

    public Integer updateByExampleSelective(@Param("record") AreaPara areaPara, @Param("example") AreaParaExample areaParaExample);

    public Integer updateByPrimaryKeySelective(AreaPara areaPara);

}
