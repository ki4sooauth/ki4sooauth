package com.gooagoo.entity.para;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class Parameter
{
    private Map<String, String[]> param = new HashMap<String, String[]>();

    public String getString(String key)
    {
        String str = this.getString(key, 0);
        return str;
    }

    public Integer getInteger(String key)
    {
        return this.getInteger(key, 0);
    }

    public Date getDate(String key) throws Exception
    {
        return this.getDate(key, 0);
    }

    public Double getDouble(String key)
    {
        return this.getDouble(key, 0);
    }

    public Boolean getBoolean(String key)
    {
        return this.getBoolean(key, 0);
    }

    public List<String> getStringList(String key)
    {
        List<String> result = new ArrayList<String>();
        String[] values = this.param.get(key);
        if (values != null)
        {
            for (int i = 0; i < values.length; i++)
            {
                result.add(this.getString(key, i));
            }
        }

        return result;
    }

    public List<Integer> getIntList(String key)

    {
        List<Integer> result = new ArrayList<Integer>();
        String[] values = this.param.get(key);
        if (values != null)
        {
            for (int i = 0; i < values.length; i++)
            {
                result.add(this.getInteger(key, i));
            }
        }

        return result;
    }

    /******************************* 以下是一些私有方法 ********************************************/
    private String getString(String key, int index)
    {
        String[] values = this.param.get(key);
        if (values != null)
        {
            return values[index];
        }
        else
        {
            return null;
        }
    }

    private Date getDate(String key, int index)
    {
        try
        {
            String reg1 = "\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}(.\\d{1,3}){0,1}";
            String reg2 = "\\d{4}-\\d{1,2}-\\d{1,2}";
            String reg3 = "\\d{1,2}/\\d{1,2}/\\d{4} \\d{1,2}:\\d{1,2}:\\d{1,2}(.\\d{1,3}){0,1}";
            String reg4 = "\\d{1,2}/\\d{1,2}/\\d{4}";
            String format = null;
            String date = this.getString(key, index);
            if (date.matches(reg1))
            {
                format = "yyyy-MM-dd HH:mm:ss";
            }
            else if (date.matches(reg2))
            {
                format = "yyyy-MM-dd";
            }
            else if (date.matches(reg3))
            {
                format = "MM/dd/yyyy HH:mm:ss";
            }
            else if (date.matches(reg4))
            {
                format = "MM/dd/yyyy";
            }
            else
            {
                return null;
            }
            SimpleDateFormat df = new SimpleDateFormat(format);

            return df.parse(date);
        }
        catch (ParseException e)
        {
            return null;
        }
    }

    private Boolean getBoolean(String key, int index)
    {
        return Boolean.parseBoolean(this.getString(key, index));
    }

    private Integer getInteger(String key, int index)
    {
        try
        {
            return Integer.parseInt(this.getString(key, index));
        }
        catch (Exception e)
        {
            return null;
        }
    }

    private Double getDouble(String key, int index)
    {
        try
        {
            return Double.parseDouble(this.getString(key, index));
        }
        catch (Exception e)
        {
            return null;
        }
    }

    public Parameter(Map<String, String[]> param)
    {
        this.param = param;
    }

    public Parameter(HttpServletRequest request)
    {
        this.param = request.getParameterMap();
    }
}
