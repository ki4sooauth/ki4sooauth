package com.gooagoo.authzserver.api;

/**
 * 返回code,token
 */
public interface CodeGeneratorService
{
    /**
     * 生成uuid
     */
    public String generateValue();

}
