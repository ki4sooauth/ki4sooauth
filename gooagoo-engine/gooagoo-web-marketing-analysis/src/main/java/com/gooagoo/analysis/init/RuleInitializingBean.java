package com.gooagoo.analysis.init;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import com.gooagoo.common.log.GooagooLog;

@Service
public class RuleInitializingBean implements InitializingBean
{

    @Override
    public void afterPropertiesSet() throws Exception
    {
        try
        {
            new RuleZookeeper();
        }
        catch (Exception e)
        {
            GooagooLog.error("加载缓存异常", e);
        }
    }

}
