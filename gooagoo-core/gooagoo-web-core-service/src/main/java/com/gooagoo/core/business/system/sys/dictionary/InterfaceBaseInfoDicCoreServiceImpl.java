package com.gooagoo.core.business.system.sys.dictionary;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gooagoo.api.business.core.system.sys.dictionary.InterfaceBaseInfoDicCoreService;
import com.gooagoo.api.generator.core.sys.InterfaceBaseInfoGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.sys.InterfaceBaseInfo;
import com.gooagoo.exception.common.OperateFailException;
import com.google.gson.Gson;

@Service
public class InterfaceBaseInfoDicCoreServiceImpl implements InterfaceBaseInfoDicCoreService

{
    @Autowired
    private InterfaceBaseInfoGeneratorCoreService interfaceBaseInfoGeneratorCoreService;

    @Override
    public boolean addInterfaceBaseInfoDic(InterfaceBaseInfo interfaceBaseInfo) throws Exception
    {
        interfaceBaseInfo.setIsDel("N");
        return this.interfaceBaseInfoGeneratorCoreService.insertSelective(interfaceBaseInfo);
    }

    @Override
    public boolean updateInterfaceBaseInfoDic(InterfaceBaseInfo interfaceBaseInfo) throws Exception
    {
        return this.interfaceBaseInfoGeneratorCoreService.updateByPrimaryKeySelective(interfaceBaseInfo);
    }

    @Override
    public boolean delInterfaceBaseInfoDic(String iCode) throws Exception
    {
        InterfaceBaseInfo interfaceBaseInfo = new InterfaceBaseInfo();
        interfaceBaseInfo.setICode(iCode);
        interfaceBaseInfo.setIsDel("Y");
        return this.interfaceBaseInfoGeneratorCoreService.updateByPrimaryKeySelective(interfaceBaseInfo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean addAllInterfaceBaseInfoDic(List<InterfaceBaseInfo> sysList) throws Exception
    {
        if (!CollectionUtils.isNotEmpty(sysList))
        {
            GooagooLog.info("对象内容为空");
            return false;
        }
        if (!this.interfaceBaseInfoGeneratorCoreService.deleteByExample(null))
        {
            GooagooLog.info("清空接口基础信息表失败");
            throw new OperateFailException("清空接口基础信息表失败");
        }
        for (InterfaceBaseInfo inter : sysList)
        {
            if (!this.interfaceBaseInfoGeneratorCoreService.insertSelective(inter))
            {
                throw new OperateFailException("新增接口基础信息失败" + new Gson().toJson(inter));
            }
        }
        return true;
    }

}
