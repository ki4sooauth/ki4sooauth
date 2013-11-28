package com.gooagoo.authzserver.api.impl;

import org.springframework.stereotype.Service;

import com.gooagoo.authzserver.api.CodeGeneratorService;
import com.gooagoo.common.utils.UUID;

/**
 *根据uuid生成code | accesstoken | refreshtoken
 */
@Service
public class UUIDGeneratorServiceImpl implements CodeGeneratorService
{
    @Override
    public String generateValue()
    {
        return UUID.getUUID();
    }
}
