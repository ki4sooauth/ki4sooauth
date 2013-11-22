package com.gooagoo.core.business.system.sys.dictionary;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gooagoo.api.business.core.system.sys.dictionary.UniversalDicCoreService;
import com.gooagoo.api.generator.core.base.SysDictionaryGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.base.SysDictionary;
import com.gooagoo.exception.common.OperateFailException;
import com.google.gson.Gson;

@Service
public class UniversalDicCoreServiceImpl implements UniversalDicCoreService

{

    @Autowired
    private SysDictionaryGeneratorCoreService SysDictionaryGeneratorCoreService;

    @Override
    public boolean addUniversalDic(SysDictionary sysDictionary) throws Exception
    {
        sysDictionary.setIsDel("N");
        return this.SysDictionaryGeneratorCoreService.insertSelective(sysDictionary);
    }

    @Override
    public boolean updateUniversalDic(SysDictionary sysDictionary) throws Exception
    {
        return this.SysDictionaryGeneratorCoreService.updateByPrimaryKeySelective(sysDictionary);
    }

    @Override
    public boolean delUniversalDic(String sysDictionaryId) throws Exception
    {
        SysDictionary sysDictionary = new SysDictionary();
        sysDictionary.setSysDictionaryId(Integer.parseInt(sysDictionaryId));
        sysDictionary.setIsDel("Y");
        return this.SysDictionaryGeneratorCoreService.updateByPrimaryKeySelective(sysDictionary);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean addAllUniversalDic(List<SysDictionary> sysList) throws Exception
    {
        if (!CollectionUtils.isNotEmpty(sysList))
        {
            GooagooLog.info("对象内容为空");
            return false;
        }
        if (!this.SysDictionaryGeneratorCoreService.deleteByExample(null))
        {
            GooagooLog.info("清空后通用字典表失败");
            throw new OperateFailException("清空后通用字典表失败");
        }
        for (SysDictionary inter : sysList)
        {
            if (!this.SysDictionaryGeneratorCoreService.insertSelective(inter))
            {
                throw new OperateFailException("新增后通用字典失败" + new Gson().toJson(inter));
            }
        }
        return true;
    }

}
