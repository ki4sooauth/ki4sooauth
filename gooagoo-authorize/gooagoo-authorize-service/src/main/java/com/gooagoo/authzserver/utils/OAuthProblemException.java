package com.gooagoo.authzserver.utils;

import java.util.HashMap;
import java.util.Map;


/**
 *
 *
 *
 */
public class OAuthProblemException extends Exception
{

    private String error;
    private String description;
    private String uri;
    private String state;
    private String scope;
    private String redirectUri;

    private int responseStatus;

    private Map<String, String> parameters = new HashMap<String, String>();

    protected OAuthProblemException(String error)
    {
        this(error, "");
    }

    protected OAuthProblemException(String error, String description)
    {
        super(error + " " + description);
        this.description = description;
        this.error = error;
    }

    public static OAuthProblemException error(String error)
    {
        return new OAuthProblemException(error);
    }

    public static OAuthProblemException error(String error, String description)
    {
        return new OAuthProblemException(error, description);
    }

    public OAuthProblemException description(String description)
    {
        this.description = description;
        return this;
    }

    public OAuthProblemException uri(String uri)
    {
        this.uri = uri;
        return this;
    }

    public OAuthProblemException state(String state)
    {
        this.state = state;
        return this;
    }

    public OAuthProblemException scope(String scope)
    {
        this.scope = scope;
        return this;
    }

    public OAuthProblemException responseStatus(int responseStatus)
    {
        this.responseStatus = responseStatus;
        return this;
    }

    public OAuthProblemException setParameter(String name, String value)
    {
        this.parameters.put(name, value);
        return this;
    }

    public String getError()
    {
        return this.error;
    }

    public String getDescription()
    {
        return this.description;
    }

    public String getUri()
    {
        return this.uri;
    }

    public String getState()
    {
        return this.state;
    }

    public String getScope()
    {
        return this.scope;
    }

    public int getResponseStatus()
    {
        return this.responseStatus == 0 ? 400 : this.responseStatus;
    }

    public String get(String name)
    {
        return this.parameters.get(name);
    }

    public Map<String, String> getParameters()
    {
        return this.parameters;
    }

    public String getRedirectUri()
    {
        return this.redirectUri;
    }

    public void setRedirectUri(String redirectUri)
    {
        this.redirectUri = redirectUri;
    }

    @Override
    public String getMessage()
    {
        StringBuilder b = new StringBuilder();
        if (!OAuthUtils.isEmpty(this.error))
        {
            b.append(this.error);
        }

        if (!OAuthUtils.isEmpty(this.description))
        {
            b.append(", ").append(this.description);
        }

        if (!OAuthUtils.isEmpty(this.uri))
        {
            b.append(", ").append(this.uri);
        }

        if (!OAuthUtils.isEmpty(this.state))
        {
            b.append(", ").append(this.state);
        }

        if (!OAuthUtils.isEmpty(this.scope))
        {
            b.append(", ").append(this.scope);
        }

        return b.toString();
    }

    @Override
    public String toString()
    {
        return "OAuthProblemException{" + "error='" + this.error + '\'' + ", description='" + this.description + '\'' + ", uri='" + this.uri + '\'' + ", state='" + this.state + '\'' + ", scope='" + this.scope + '\'' + ", redirectUri='" + this.redirectUri + '\'' + ", responseStatus=" + this.responseStatus + ", parameters=" + this.parameters + '}';
    }
}
