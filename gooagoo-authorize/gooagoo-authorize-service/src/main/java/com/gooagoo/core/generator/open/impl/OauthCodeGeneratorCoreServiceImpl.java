package com.gooagoo.core.generator.open.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.open.OauthCodeGeneratorCoreService;
import com.gooagoo.dao.generator.open.OauthCodeMapper;
import com.gooagoo.entity.generator.open.OauthCode;
import com.gooagoo.entity.generator.open.OauthCodeExample;
import com.gooagoo.entity.generator.open.OauthCodeKey;

@Service
public class OauthCodeGeneratorCoreServiceImpl implements OauthCodeGeneratorCoreService
{

    @Autowired
    private OauthCodeMapper oauthCodeMapper;

    @Override
    public Integer countByExample(OauthCodeExample oauthCodeExample)
    {
        return this.oauthCodeMapper.countByExample(oauthCodeExample);
    }

    @Override
    public List<OauthCode> selectByExample(OauthCodeExample oauthCodeExample)
    {
        return this.oauthCodeMapper.selectByExample(oauthCodeExample);
    }

    @Override
    public OauthCode selectByPrimaryKey(Integer primaryKey)
    {
        OauthCodeKey oauthCodeKey = new OauthCodeKey();
        oauthCodeKey.setAppKey(primaryKey);
        return this.oauthCodeMapper.selectByPrimaryKey(oauthCodeKey);
    }

    @Override
    public boolean physicalDeleteByExample(OauthCodeExample oauthCodeExample)
    {
        return this.oauthCodeMapper.deleteByExample(oauthCodeExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(Integer primaryKey)
    {
        OauthCodeKey oauthCodeKey = new OauthCodeKey();
        oauthCodeKey.setAppKey(primaryKey);
        return this.oauthCodeMapper.deleteByPrimaryKey(oauthCodeKey) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(OauthCode oauthCode)
    {
        return this.oauthCodeMapper.insertSelective(oauthCode) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(OauthCode oauthCode, OauthCodeExample oauthCodeExample)
    {
        return this.oauthCodeMapper.updateByExampleSelective(oauthCode, oauthCodeExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(OauthCode oauthCode)
    {
        return this.oauthCodeMapper.updateByPrimaryKeySelective(oauthCode) > 0 ? true : false;
    }

}
