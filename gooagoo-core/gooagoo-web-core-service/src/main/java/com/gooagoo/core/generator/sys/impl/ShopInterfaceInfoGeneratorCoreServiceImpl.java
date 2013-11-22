package com.gooagoo.core.generator.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.sys.ShopInterfaceInfoGeneratorCoreService;
import com.gooagoo.entity.generator.sys.ShopInterfaceInfo;
import com.gooagoo.entity.generator.sys.ShopInterfaceInfoExample;
import com.gooagoo.entity.generator.sys.ShopInterfaceInfoKey;
import com.gooagoo.dao.generator.sys.ShopInterfaceInfoMapper;

@Service
public class ShopInterfaceInfoGeneratorCoreServiceImpl implements ShopInterfaceInfoGeneratorCoreService
{

    @Autowired
    private ShopInterfaceInfoMapper shopInterfaceInfoMapper;

    @Override
    public Integer countByExample(ShopInterfaceInfoExample shopInterfaceInfoExample) 
    {
        return this.shopInterfaceInfoMapper.countByExample(shopInterfaceInfoExample);
    }

    @Override
    public List<ShopInterfaceInfo> selectByExample(ShopInterfaceInfoExample shopInterfaceInfoExample) 
    {
        return this.shopInterfaceInfoMapper.selectByExample(shopInterfaceInfoExample);
    }

    @Override
    public ShopInterfaceInfo selectUnDelByPrimaryKey(String primaryKey) 
    {
        ShopInterfaceInfoKey shopInterfaceInfoKey = new ShopInterfaceInfoKey();
        shopInterfaceInfoKey.setIsDel("N");
        shopInterfaceInfoKey.setId(primaryKey);
        return this.shopInterfaceInfoMapper.selectByPrimaryKey(shopInterfaceInfoKey);
    }

    @Override
    public ShopInterfaceInfo selectByPrimaryKey(String primaryKey) 
    {
        ShopInterfaceInfoKey shopInterfaceInfoKey = new ShopInterfaceInfoKey();
        shopInterfaceInfoKey.setId(primaryKey);
        return this.shopInterfaceInfoMapper.selectByPrimaryKey(shopInterfaceInfoKey);
    }

    @Override
    public boolean physicalDeleteByExample(ShopInterfaceInfoExample shopInterfaceInfoExample) 
    {
        return this.shopInterfaceInfoMapper.deleteByExample(shopInterfaceInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        ShopInterfaceInfoKey shopInterfaceInfoKey = new ShopInterfaceInfoKey();
        shopInterfaceInfoKey.setId(primaryKey);
        return this.shopInterfaceInfoMapper.deleteByPrimaryKey(shopInterfaceInfoKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(ShopInterfaceInfoExample shopInterfaceInfoExample) 
    {
        ShopInterfaceInfo shopInterfaceInfo = new ShopInterfaceInfo();
        shopInterfaceInfo.setIsDel("Y");
        return this.shopInterfaceInfoMapper.updateByExampleSelective(shopInterfaceInfo,shopInterfaceInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        ShopInterfaceInfo shopInterfaceInfo = new ShopInterfaceInfo();
        shopInterfaceInfo.setId(primaryKey);
        shopInterfaceInfo.setIsDel("Y");
        return this.shopInterfaceInfoMapper.updateByPrimaryKeySelective(shopInterfaceInfo) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(ShopInterfaceInfo shopInterfaceInfo) 
    {
        return this.shopInterfaceInfoMapper.insertSelective(shopInterfaceInfo) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(ShopInterfaceInfo shopInterfaceInfo,ShopInterfaceInfoExample shopInterfaceInfoExample) 
    {
        return this.shopInterfaceInfoMapper.updateByExampleSelective(shopInterfaceInfo,shopInterfaceInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(ShopInterfaceInfo shopInterfaceInfo) 
    {
        return this.shopInterfaceInfoMapper.updateByPrimaryKeySelective(shopInterfaceInfo) > 0 ? true : false;
    }

}
