package com.gooagoo.authzserver.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.oltu.oauth2.common.exception.OAuthProblemException;

/**
 *
 *
 *
 */
public interface OAuthValidator<T extends HttpServletRequest>
{
    //验证提交方法
    public void validateMethod(T request) throws OAuthProblemException;

    //验证form 提交
    public void validateContentType(T request) throws OAuthProblemException;

    //必填参数
    public void validateRequiredParameters(T request) throws OAuthProblemException;

    //选填参数
    public void validateOptionalParameters(T request) throws OAuthProblemException;

    //不被允许的参数
    public void validateNotAllowedParameters(T request) throws OAuthProblemException;

    //验证客户端授权凭证
    public void validateClientAuthenticationCredentials(T request) throws OAuthProblemException;

    //执行所有的验证
    public void performAllValidations(T request) throws OAuthProblemException;

}
