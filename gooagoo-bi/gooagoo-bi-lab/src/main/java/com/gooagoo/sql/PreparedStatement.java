package com.gooagoo.sql;

import java.util.ArrayList;
import java.util.List;

public class PreparedStatement
{
    private String sql;
    private List<Object> parameters = new ArrayList<Object>();

    public PreparedStatement()
    {

    }

    public PreparedStatement(String sql)
    {
        this.sql = sql;
    }

    public String getSql()
    {
        return sql;
    }

    public void setSql(String sql)
    {
        this.sql = sql;
    }

    public List<Object> getParameters()
    {
        return parameters;
    }

    public void set(Object object)
    {
        parameters.add(object);
    }
}
