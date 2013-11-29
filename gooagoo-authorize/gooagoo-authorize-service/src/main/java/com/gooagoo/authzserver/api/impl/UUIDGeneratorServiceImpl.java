package com.gooagoo.authzserver.api.impl;

import org.springframework.stereotype.Service;

import com.gooagoo.authzserver.api.CodeGeneratorService;
import com.gooagoo.common.utils.UUID;

/**
 *生成code,token 
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
