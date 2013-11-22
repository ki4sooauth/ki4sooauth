package com.gooagoo.query.generator.base.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.base.ShopToolInfoGeneratorQueryService;
import com.gooagoo.entity.generator.base.ShopToolInfo;
import com.gooagoo.entity.generator.base.ShopToolInfoExample;
import com.gooagoo.entity.generator.base.ShopToolInfoKey;
import com.gooagoo.dao.generator.base.ShopToolInfoMapper;

@Service
public class ShopToolInfoGeneratorQueryServiceImpl implements ShopToolInfoGeneratorQueryService
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

}
