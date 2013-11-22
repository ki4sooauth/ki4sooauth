package com.gooagoo.core.business.system.sys.dictionary;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gooagoo.api.business.core.system.sys.dictionary.InterfaceRequestInfoDicCoreService;
import com.gooagoo.api.generator.core.sys.InterfaceRequestInfoGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.sys.InterfaceRequestInfo;
import com.gooagoo.exception.common.OperateFailException;
import com.google.gson.Gson;

@Service
public class InterfaceRequestInfoDicCoreServiceImpl implements InterfaceRequestInfoDicCoreService

{

    @Autowired
    private InterfaceRequestInfoGeneratorCoreService interfaceRequestInfoGeneratorCoreService;

    @Override
    public boolean addInterfaceRequestInfoDic(InterfaceRequestInfo interfaceRequestInfo) throws Exception
    {
        return this.interfaceRequestInfoGeneratorCoreService.insertSelective(interfaceRequestInfo);
    }

    @Override
    public boolean updateInterfaceRequestInfoDic(InterfaceRequestInfo interfaceRequestInfo) throws Exception
    {
        return this.interfaceRequestInfoGeneratorCoreService.updateByPrimaryKeySelective(interfaceRequestInfo);
    }

    @Override
    public boolean delInterfaceRequestInfoDic(String id) throws Exception
    {
        return this.interfaceRequestInfoGeneratorCoreService.physicalDeleteByPrimaryKey(Integer.parseInt(id));
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean addAllInterfaceRequestInfoDic(List<InterfaceRequestInfo> sysList) throws Exception
    {
        if (!CollectionUtils.isNotEmpty(sysList))
        {
            GooagooLog.info("对象内容为空");
            return false;
        }
        if (!this.interfaceRequestInfoGeneratorCoreService.physicalDeleteByPrimaryKey(null))
        {
            GooagooLog.info("清空接口请求参数信息表失败");
            throw new OperateFailException("清空接口请求参数信息表失败");
        }
        for (InterfaceRequestInfo inter : sysList)
        {
            if (!this.interfaceRequestInfoGeneratorCoreService.insertSelective(inter))
            {
                throw new OperateFailException("新增接口请求参数信息失败" + new Gson().toJson(inter));
            }
        }
        return true;
    }

}
