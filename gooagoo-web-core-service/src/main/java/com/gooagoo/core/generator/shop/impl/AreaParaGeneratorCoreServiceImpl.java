package com.gooagoo.core.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.shop.AreaParaGeneratorCoreService;
import com.gooagoo.entity.generator.shop.AreaPara;
import com.gooagoo.entity.generator.shop.AreaParaExample;
import com.gooagoo.entity.generator.shop.AreaParaKey;
import com.gooagoo.dao.generator.shop.AreaParaMapper;

@Service
public class AreaParaGeneratorCoreServiceImpl implements AreaParaGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(AreaParaExample areaParaExample) 
    {
        return this.areaParaMapper.deleteByExample(areaParaExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        AreaParaKey areaParaKey = new AreaParaKey();
        areaParaKey.setMapId(primaryKey);
        return this.areaParaMapper.deleteByPrimaryKey(areaParaKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(AreaParaExample areaParaExample) 
    {
        AreaPara areaPara = new AreaPara();
        areaPara.setIsDel("Y");
        return this.areaParaMapper.updateByExampleSelective(areaPara,areaParaExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        AreaPara areaPara = new AreaPara();
        areaPara.setMapId(primaryKey);
        areaPara.setIsDel("Y");
        return this.areaParaMapper.updateByPrimaryKeySelective(areaPara) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(AreaPara areaPara) 
    {
        return this.areaParaMapper.insertSelective(areaPara) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(AreaPara areaPara,AreaParaExample areaParaExample) 
    {
        return this.areaParaMapper.updateByExampleSelective(areaPara,areaParaExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(AreaPara areaPara) 
    {
        return this.areaParaMapper.updateByPrimaryKeySelective(areaPara) > 0 ? true : false;
    }

}
