package com.gooagoo.core.generator.base.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.base.ShopToolInfoGeneratorCoreService;
import com.gooagoo.entity.generator.base.ShopToolInfo;
import com.gooagoo.entity.generator.base.ShopToolInfoExample;
import com.gooagoo.entity.generator.base.ShopToolInfoKey;
import com.gooagoo.dao.generator.base.ShopToolInfoMapper;

@Service
public class ShopToolInfoGeneratorCoreServiceImpl implements ShopToolInfoGeneratorCoreService
{

    @Autowired
    private ShopToolInfoMapper shopToolInfoMapper;

    @Override
    public Integer countByExample(ShopToolInfoExample shopToolInfoExample) 
    {
        return this.shopToolInfoMapper.countByExample(shopToolInfoExample);
    }

    @Override
    public List<ShopToolInfo> selectByExample(ShopToolInfoExample shopToolInfoExample) 
    {
        return this.shopToolInfoMapper.selectByExample(shopToolInfoExample);
    }

    @Override
    public ShopToolInfo selectUnDelByPrimaryKey(String primaryKey) 
    {
        ShopToolInfoKey shopToolInfoKey = new ShopToolInfoKey();
        shopToolInfoKey.setIsDel("N");
        shopToolInfoKey.setToolId(primaryKey);
        return this.shopToolInfoMapper.selectByPrimaryKey(shopToolInfoKey);
    }

    @Override
    public ShopToolInfo selectByPrimaryKey(String primaryKey) 
    {
        ShopToolInfoKey shopToolInfoKey = new ShopToolInfoKey();
        shopToolInfoKey.setToolId(primaryKey);
        return this.shopToolInfoMapper.selectByPrimaryKey(shopToolInfoKey);
    }

    @Override
    public boolean physicalDeleteByExample(ShopToolInfoExample shopToolInfoExample) 
    {
        return this.shopToolInfoMapper.deleteByExample(shopToolInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        ShopToolInfoKey shopToolInfoKey = new ShopToolInfoKey();
        shopToolInfoKey.setToolId(primaryKey);
        return this.shopToolInfoMapper.deleteByPrimaryKey(shopToolInfoKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(ShopToolInfoExample shopToolInfoExample) 
    {
        ShopToolInfo shopToolInfo = new ShopToolInfo();
        shopToolInfo.setIsDel("Y");
        return this.shopToolInfoMapper.updateByExampleSelective(shopToolInfo,shopToolInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        ShopToolInfo shopToolInfo = new ShopToolInfo();
        shopToolInfo.setToolId(primaryKey);
        shopToolInfo.setIsDel("Y");
        return this.shopToolInfoMapper.updateByPrimaryKeySelective(shopToolInfo) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(ShopToolInfo shopToolInfo) 
    {
        return this.shopToolInfoMapper.insertSelective(shopToolInfo) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(ShopToolInfo shopToolInfo,ShopToolInfoExample shopToolInfoExample) 
    {
        return this.shopToolInfoMapper.updateByExampleSelective(shopToolInfo,shopToolInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(ShopToolInfo shopToolInfo) 
    {
        return this.shopToolInfoMapper.updateByPrimaryKeySelective(shopToolInfo) > 0 ? true : false;
    }

}
