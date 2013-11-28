package com.gooagoo.authzserver.api;

/**
 * 返回code|accesstoken|refreshtoken
 */
public interface CodeGeneratorService
{
    /**
     * 生成uuid
     */
    public String generateValue();

}
