package com.gooagoo.igus.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;

public interface IGusService
{

    public TransData<Object> service(HttpServletRequest request);

}
