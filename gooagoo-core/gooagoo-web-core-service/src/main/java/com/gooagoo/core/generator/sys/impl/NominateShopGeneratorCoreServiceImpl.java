package com.gooagoo.core.generator.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.sys.NominateShopGeneratorCoreService;
import com.gooagoo.entity.generator.sys.NominateShop;
import com.gooagoo.entity.generator.sys.NominateShopExample;
import com.gooagoo.entity.generator.sys.NominateShopKey;
import com.gooagoo.dao.generator.sys.NominateShopMapper;

@Service
public class NominateShopGeneratorCoreServiceImpl implements NominateShopGeneratorCoreService
{

    @Autowired
    private NominateShopMapper nominateShopMapper;

    @Override
    public Integer countByExample(NominateShopExample nominateShopExample) 
    {
        return this.nominateShopMapper.countByExample(nominateShopExample);
    }

    @Override
    public List<NominateShop> selectByExample(NominateShopExample nominateShopExample) 
    {
        return this.nominateShopMapper.selectByExample(nominateShopExample);
    }

    @Override
    public NominateShop selectUnDelByPrimaryKey(String primaryKey) 
    {
        NominateShopKey nominateShopKey = new NominateShopKey();
        nominateShopKey.setIsDel("N");
        nominateShopKey.setId(primaryKey);
        return this.nominateShopMapper.selectByPrimaryKey(nominateShopKey);
    }

    @Override
    public NominateShop selectByPrimaryKey(String primaryKey) 
    {
        NominateShopKey nominateShopKey = new NominateShopKey();
        nominateShopKey.setId(primaryKey);
        return this.nominateShopMapper.selectByPrimaryKey(nominateShopKey);
    }

    @Override
    public boolean physicalDeleteByExample(NominateShopExample nominateShopExample) 
    {
        return this.nominateShopMapper.deleteByExample(nominateShopExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        NominateShopKey nominateShopKey = new NominateShopKey();
        nominateShopKey.setId(primaryKey);
        return this.nominateShopMapper.deleteByPrimaryKey(nominateShopKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(NominateShopExample nominateShopExample) 
    {
        NominateShop nominateShop = new NominateShop();
        nominateShop.setIsDel("Y");
        return this.nominateShopMapper.updateByExampleSelective(nominateShop,nominateShopExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        NominateShop nominateShop = new NominateShop();
        nominateShop.setId(primaryKey);
        nominateShop.setIsDel("Y");
        return this.nominateShopMapper.updateByPrimaryKeySelective(nominateShop) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(NominateShop nominateShop) 
    {
        return this.nominateShopMapper.insertSelective(nominateShop) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(NominateShop nominateShop,NominateShopExample nominateShopExample) 
    {
        return this.nominateShopMapper.updateByExampleSelective(nominateShop,nominateShopExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(NominateShop nominateShop) 
    {
        return this.nominateShopMapper.updateByPrimaryKeySelective(nominateShop) > 0 ? true : false;
    }

}
