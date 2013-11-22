package com.gooagoo.query.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.shop.AreaParaGeneratorQueryService;
import com.gooagoo.entity.generator.shop.AreaPara;
import com.gooagoo.entity.generator.shop.AreaParaExample;
import com.gooagoo.entity.generator.shop.AreaParaKey;
import com.gooagoo.dao.generator.shop.AreaParaMapper;

@Service
public class AreaParaGeneratorQueryServiceImpl implements AreaParaGeneratorQueryService
{

    @Autowired
    private AreaParaMapper areaParaMapper;

    @Override
    public Integer countByExample(AreaParaExample areaParaExample) 
    {
        return this.areaParaMapper.countByExample(areaParaExample);
    }

    @Override
    public List<AreaPara> selectByExample(AreaParaExample areaParaExample) 
    {
        return this.areaParaMapper.selectByExample(areaParaExample);
    }

    @Override
    public AreaPara selectUnDelByPrimaryKey(String primaryKey) 
    {
        AreaParaKey areaParaKey = new AreaParaKey();
        areaParaKey.setIsDel("N");
        areaParaKey.setMapId(primaryKey);
        return this.areaParaMapper.selectByPrimaryKey(areaParaKey);
    }

    @Override
    public AreaPara selectByPrimaryKey(String primaryKey) 
    {
        AreaParaKey areaParaKey = new AreaParaKey();
        areaParaKey.setMapId(primaryKey);
        return this.areaParaMapper.selectByPrimaryKey(areaParaKey);
    }

}
