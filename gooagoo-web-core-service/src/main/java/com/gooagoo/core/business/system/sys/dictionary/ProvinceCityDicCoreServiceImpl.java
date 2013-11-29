package com.gooagoo.core.business.system.sys.dictionary;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gooagoo.api.business.core.system.sys.dictionary.ProvinceCityDicCoreService;
import com.gooagoo.api.generator.core.base.UserCityareaGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.base.UserCityarea;
import com.gooagoo.exception.common.OperateFailException;
import com.google.gson.Gson;

@Service
public class ProvinceCityDicCoreServiceImpl implements ProvinceCityDicCoreService

{

    @Autowired
    private UserCityareaGeneratorCoreService userCityareaGeneratorCoreService;

    @Override
    public boolean addProvinceCityDic(UserCityarea userCityarea) throws Exception
    {
        userCityarea.setIsDel("N");
        return this.userCityareaGeneratorCoreService.insertSelective(userCityarea);
    }

    @Override
    public boolean updateProvinceCityDic(UserCityarea userCityarea) throws Exception
    {
        return this.userCityareaGeneratorCoreService.updateByPrimaryKeySelective(userCityarea);
    }

    @Override
    public boolean delProvinceCityDic(String id) throws Exception
    {
        UserCityarea userCityarea = new UserCityarea();
        userCityarea.setId(Integer.parseInt(id));
        userCityarea.setIsDel("Y");
        return this.userCityareaGeneratorCoreService.updateByPrimaryKeySelective(userCityarea);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean addAllProvinceCityDic(List<UserCityarea> sysList) throws Exception
    {
        if (!CollectionUtils.isNotEmpty(sysList))
        {
            GooagooLog.info("对象内容为空");
            return false;
        }
        if (!this.userCityareaGeneratorCoreService.deleteByExample(null))
        {
            GooagooLog.info("清空省份城市表失败");
            throw new OperateFailException("清空省份城市表失败");
        }
        for (UserCityarea inter : sysList)
        {
            if (!this.userCityareaGeneratorCoreService.insertSelective(inter))
            {
                throw new OperateFailException("新增省份城市失败" + new Gson().toJson(inter));
            }
        }
        return true;
    }

}
