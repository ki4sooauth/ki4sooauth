package com.gooagoo.sql;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SqlBuilder
{
    private boolean filterNull = true;
    private String analysisSql;
    private Map<String, Object> param = new HashMap<String, Object>();

    public SqlBuilder(String sql)
    {
        this.analysisSql = sql.replaceAll("\\s*=\\s*", "=").replaceAll(",", " , ");
    }

    /**
     * 如果某个字段的值为null则过滤掉sql语句中的相应部分
     * @param filterNull true过滤 false 不过滤
     */
    public void setFilterNull(boolean filterNull)
    {
        this.filterNull = filterNull;
    }

    public void setWhereEntity(Object parameter)
    {
        Class<? extends Object> parameterClass = parameter.getClass(); //传入类的所有字段
        Field[] parameterFields = parameterClass.getDeclaredFields();
        String column = null;
        Object cell = null;
        for (Field field : parameterFields)
        {
            if (!Modifier.isFinal(field.getModifiers()))
            {
                try
                {
                    field.setAccessible(true); //让字段可访问 有没有get、set方法都行
                    column = getFieldName(field);
                    cell = field.get(parameter);
                    param.put(column, cell);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    private static String getFieldName(Field field)
    {
        Column column = field.getAnnotation(Column.class);
        if (column != null)
        {
            return column.value();
        }
        else
        {
            return field.getName();
        }
    }

    public PreparedStatement createStatement()
    {
        PreparedStatement statement = new PreparedStatement();
        Pattern sqlPattern = Pattern.compile("\\w+=\\?");
        Pattern paraPattern = Pattern.compile("\\w+");
        Matcher sqlMatch = sqlPattern.matcher(analysisSql);
        String paraName = null;
        String condition = null;
        Object value = null;
        while (sqlMatch.find())
        {
            condition = sqlMatch.group(0);
            Matcher paraMatch = paraPattern.matcher(condition);
            if (paraMatch.find())
            {
                paraName = paraMatch.group(0);
                value = param.get(paraName);
                if (value != null || !filterNull)
                {
                    statement.set(value);
                }
                else
                {
                    analysisSql = analysisSql.replaceFirst("\\S*" + paraName + "=\\?", "");
                }
            }
        }
        statement.setSql(expression(analysisSql));
        return statement;
    }

    private String expression(String analysisSql)
    {
        while (true)
        {
            int lenth = analysisSql.length();
            analysisSql = analysisSql.replaceAll("\\s*where\\s*(and|or)\\s*", " where ");
            analysisSql = analysisSql.replaceAll("\\s*(and|or)\\s*and", " and ");
            analysisSql = analysisSql.replaceAll("\\s*(and|or)\\s*or\\s*", " or ");
            analysisSql = analysisSql.replaceAll("\\s*(and|or)\\s*$", "");
            analysisSql = analysisSql.replaceAll("\\s*set\\s+,", " set ");
            analysisSql = analysisSql.replaceAll(",\\s+where\\s+", " where ");
            analysisSql = analysisSql.replaceAll(",\\s+,", " , ");
            analysisSql = analysisSql.replaceAll("\\s+", " ");
            if (lenth == analysisSql.length())
            {
                break;
            }
        }
        return analysisSql.replaceAll("where\\s*$", "");
    }
}
