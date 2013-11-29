package com.gooagoo.core.generator.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.sys.NominateActivityGeneratorCoreService;
import com.gooagoo.entity.generator.sys.NominateActivity;
import com.gooagoo.entity.generator.sys.NominateActivityExample;
import com.gooagoo.entity.generator.sys.NominateActivityKey;
import com.gooagoo.dao.generator.sys.NominateActivityMapper;

@Service
public class NominateActivityGeneratorCoreServiceImpl implements NominateActivityGeneratorCoreService
{

    @Autowired
    private NominateActivityMapper nominateActivityMapper;

    @Override
    public Integer countByExample(NominateActivityExample nominateActivityExample) 
    {
        return this.nominateActivityMapper.countByExample(nominateActivityExample);
    }

    @Override
    public List<NominateActivity> selectByExample(NominateActivityExample nominateActivityExample) 
    {
        return this.nominateActivityMapper.selectByExample(nominateActivityExample);
    }

    @Override
    public NominateActivity selectUnDelByPrimaryKey(String primaryKey) 
    {
        NominateActivityKey nominateActivityKey = new NominateActivityKey();
        nominateActivityKey.setIsDel("N");
        nominateActivityKey.setId(primaryKey);
        return this.nominateActivityMapper.selectByPrimaryKey(nominateActivityKey);
    }

    @Override
    public NominateActivity selectByPrimaryKey(String primaryKey) 
    {
        NominateActivityKey nominateActivityKey = new NominateActivityKey();
        nominateActivityKey.setId(primaryKey);
        return this.nominateActivityMapper.selectByPrimaryKey(nominateActivityKey);
    }

    @Override
    public boolean physicalDeleteByExample(NominateActivityExample nominateActivityExample) 
    {
        return this.nominateActivityMapper.deleteByExample(nominateActivityExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        NominateActivityKey nominateActivityKey = new NominateActivityKey();
        nominateActivityKey.setId(primaryKey);
        return this.nominateActivityMapper.deleteByPrimaryKey(nominateActivityKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(NominateActivityExample nominateActivityExample) 
    {
        NominateActivity nominateActivity = new NominateActivity();
        nominateActivity.setIsDel("Y");
        return this.nominateActivityMapper.updateByExampleSelective(nominateActivity,nominateActivityExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        NominateActivity nominateActivity = new NominateActivity();
        nominateActivity.setId(primaryKey);
        nominateActivity.setIsDel("Y");
        return this.nominateActivityMapper.updateByPrimaryKeySelective(nominateActivity) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(NominateActivity nominateActivity) 
    {
        return this.nominateActivityMapper.insertSelective(nominateActivity) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(NominateActivity nominateActivity,NominateActivityExample nominateActivityExample) 
    {
        return this.nominateActivityMapper.updateByExampleSelective(nominateActivity,nominateActivityExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(NominateActivity nominateActivity) 
    {
        return this.nominateActivityMapper.updateByPrimaryKeySelective(nominateActivity) > 0 ? true : false;
    }

}
