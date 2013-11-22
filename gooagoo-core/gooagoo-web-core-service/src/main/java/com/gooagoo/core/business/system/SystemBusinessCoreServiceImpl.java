package com.gooagoo.core.business.system;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.system.SystemBusinessCoreService;
import com.gooagoo.dao.business.sys.SystemBusinessMapper;

@Service
public class SystemBusinessCoreServiceImpl implements SystemBusinessCoreService
{

    @Autowired
    private SystemBusinessMapper systemBusinessMapper;

    @Override
    public Date getCoreSysCurrentTime()
    {
        return this.systemBusinessMapper.getCurrentTime();
    }

}
