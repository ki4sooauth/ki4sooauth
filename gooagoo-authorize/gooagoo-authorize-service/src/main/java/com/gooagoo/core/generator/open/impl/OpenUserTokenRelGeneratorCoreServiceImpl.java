package com.gooagoo.core.generator.open.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.open.OpenUserTokenRelGeneratorCoreService;
import com.gooagoo.dao.generator.open.OpenUserTokenRelMapper;
import com.gooagoo.entity.generator.open.OpenUserTokenRel;
import com.gooagoo.entity.generator.open.OpenUserTokenRelExample;
import com.gooagoo.entity.generator.open.OpenUserTokenRelKey;

@Service
public class OpenUserTokenRelGeneratorCoreServiceImpl implements OpenUserTokenRelGeneratorCoreService
{

    @Autowired
    private OpenUserTokenRelMapper openUserTokenRelMapper;

    @Override
    public Integer countByExample(OpenUserTokenRelExample openUserTokenRelExample)
    {
        return this.openUserTokenRelMapper.countByExample(openUserTokenRelExample);
    }

    @Override
    public List<OpenUserTokenRel> selectByExample(OpenUserTokenRelExample openUserTokenRelExample)
    {
        return this.openUserTokenRelMapper.selectByExample(openUserTokenRelExample);
    }

    @Override
    public OpenUserTokenRel selectByPrimaryKey(String primaryKey)
    {
        OpenUserTokenRelKey openUserTokenRelKey = new OpenUserTokenRelKey();
        openUserTokenRelKey.setTokenId(primaryKey);
        return this.openUserTokenRelMapper.selectByPrimaryKey(openUserTokenRelKey);
    }

    @Override
    public boolean physicalDeleteByExample(OpenUserTokenRelExample openUserTokenRelExample)
    {
        return this.openUserTokenRelMapper.deleteByExample(openUserTokenRelExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey)
    {
        OpenUserTokenRelKey openUserTokenRelKey = new OpenUserTokenRelKey();
        openUserTokenRelKey.setTokenId(primaryKey);
        return this.openUserTokenRelMapper.deleteByPrimaryKey(openUserTokenRelKey) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(OpenUserTokenRel openUserTokenRel)
    {
        return this.openUserTokenRelMapper.insertSelective(openUserTokenRel) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(OpenUserTokenRel openUserTokenRel, OpenUserTokenRelExample openUserTokenRelExample)
    {
        return this.openUserTokenRelMapper.updateByExampleSelective(openUserTokenRel, openUserTokenRelExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(OpenUserTokenRel openUserTokenRel)
    {
        return this.openUserTokenRelMapper.updateByPrimaryKeySelective(openUserTokenRel) > 0 ? true : false;
    }

}
