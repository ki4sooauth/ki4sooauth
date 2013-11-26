package com.gooagoo.authzserver.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.oltu.oauth2.common.exception.OAuthProblemException;

import com.gooagoo.authzserver.OAuth;
import com.gooagoo.authzserver.utils.OAuthUtils;

/**
 *
 *
 *
 */
public abstract class AbstractValidator<T extends HttpServletRequest> implements OAuthValidator<T>
{

    protected List<String> requiredParams = new ArrayList<String>();
    protected Map<String, String[]> optionalParams = new HashMap<String, String[]>();
    protected List<String> notAllowedParams = new ArrayList<String>();
    protected boolean enforceClientAuthentication;

    @Override
    public void validateMethod(T request) throws OAuthProblemException
    {
        if (!request.getMethod().equals(OAuth.HttpMethod.POST))
        {
            throw OAuthUtils.handleOAuthProblemException("Method not set to POST.");
        }
    }

    @Override
    public void validateContentType(T request) throws OAuthProblemException
    {
        String contentType = request.getContentType();
        //获取form表单的默认值enctype ，用来处理get/post (预设)
        final String expectedContentType = OAuth.ContentType.URL_ENCODED;
        if (!OAuthUtils.hasContentType(contentType, expectedContentType))
        {//不是预期的结果
            throw OAuthUtils.handleBadContentTypeException(expectedContentType);
        }
    }

    @Override
    public void validateRequiredParameters(T request) throws OAuthProblemException
    {
        final Set<String> missingParameters = new HashSet<String>();
        for (String requiredParam : this.requiredParams)
        {
            String val = request.getParameter(requiredParam);
            if (OAuthUtils.isEmpty(val))
            {
                missingParameters.add(requiredParam);
            }
        }
        if (!missingParameters.isEmpty())
        {
            throw OAuthUtils.handleMissingParameters(missingParameters);
        }
    }

    @Override
    public void validateOptionalParameters(T request) throws OAuthProblemException
    {
        final Set<String> missingParameters = new HashSet<String>();

        for (Map.Entry<String, String[]> requiredParam : this.optionalParams.entrySet())
        {
            final String paramName = requiredParam.getKey();
            String val = request.getParameter(paramName);
            if (!OAuthUtils.isEmpty(val))
            {
                String[] dependentParams = requiredParam.getValue();
                if (!OAuthUtils.hasEmptyValues(dependentParams))
                {
                    for (String dependentParam : dependentParams)
                    {
                        val = request.getParameter(dependentParam);
                        if (OAuthUtils.isEmpty(val))
                        {
                            missingParameters.add(dependentParam);
                        }
                    }
                }
            }
        }

        if (!missingParameters.isEmpty())
        {
            throw OAuthUtils.handleMissingParameters(missingParameters);
        }
    }

    @Override
    public void validateNotAllowedParameters(T request) throws OAuthProblemException
    {
        List<String> notAllowedParameters = new ArrayList<String>();
        for (String requiredParam : this.notAllowedParams)
        {
            String val = request.getParameter(requiredParam);
            if (!OAuthUtils.isEmpty(val))
            {
                notAllowedParameters.add(requiredParam);
            }
        }
        if (!notAllowedParameters.isEmpty())
        {
            throw OAuthUtils.handleNotAllowedParametersOAuthException(notAllowedParameters);
        }
    }

    @Override
    public void validateClientAuthenticationCredentials(T request) throws OAuthProblemException
    {
        if (this.enforceClientAuthentication)
        {
            Set<String> missingParameters = new HashSet<String>();
            String clientAuthHeader = request.getHeader(OAuth.HeaderType.AUTHORIZATION);
            String[] clientCreds = OAuthUtils.decodeClientAuthenticationHeader(clientAuthHeader);

            // Only fallback to params if the auth header is not correct. Don't allow a mix of auth header vs params
            if (clientCreds == null || OAuthUtils.isEmpty(clientCreds[0]) || OAuthUtils.isEmpty(clientCreds[1]))
            {

                if (OAuthUtils.isEmpty(request.getParameter(OAuth.OAUTH_CLIENT_ID)))
                {
                    missingParameters.add(OAuth.OAUTH_CLIENT_ID);
                }
                if (OAuthUtils.isEmpty(request.getParameter(OAuth.OAUTH_CLIENT_SECRET)))
                {
                    missingParameters.add(OAuth.OAUTH_CLIENT_SECRET);
                }
            }

            if (!missingParameters.isEmpty())
            {
                throw OAuthUtils.handleMissingParameters(missingParameters);
            }
        }
    }

    @Override
    public void performAllValidations(T request) throws OAuthProblemException
    {
        this.validateContentType(request);
        this.validateMethod(request);
        this.validateRequiredParameters(request);
        this.validateOptionalParameters(request);
        this.validateNotAllowedParameters(request);
        this.validateClientAuthenticationCredentials(request);
    }
}
