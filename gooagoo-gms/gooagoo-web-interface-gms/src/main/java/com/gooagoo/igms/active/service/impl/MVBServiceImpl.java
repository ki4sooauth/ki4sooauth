package com.gooagoo.igms.active.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.igms.active.service.EventService;
import com.gooagoo.igms.active.service.MVBService;

@Service(value = "mvbService")
public class MVBServiceImpl implements MVBService
{
    @Autowired
    private EventService eventService;

    @Override
    public TransData<Object> release(HttpServletRequest request) throws Exception
    {
        return this.eventService.release(request);
    }
}
