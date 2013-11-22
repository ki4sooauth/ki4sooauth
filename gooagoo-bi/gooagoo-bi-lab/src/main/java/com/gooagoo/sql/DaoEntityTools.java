package com.gooagoo.sql;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

public class DaoEntityTools<T>
{
    private static Logger log = Logger.getLogger("gooagoo_db");

    public static <T> T setValue(ResultSet rs, Class<T> clazz) throws Exception
    {
        T obj = clazz.newInstance(); //返回对象
        Field[] Fields = clazz.getDeclaredFields();

        for (Field field : Fields)
        {
            if (!Modifier.isFinal(field.getModifiers()))
            {
                field.setAccessible(true); //让字段可访问 有没有get、set方法都行
                String fieldName = null;
                try
                {
                    fieldName = getFieldName(field);
                    field.set(obj, rs.getObject(fieldName));
                }
                catch (Exception e)
                {
                    log.debug(fieldName + "不存在");
                }
                field.setAccessible(false); //让字段可访问 有没有get、set方法都行
            }
        }
        return obj;
    }

    public static <T> List<T> setListValue(ResultSet rs, Class<T> clazz) throws Exception
    {
        List<T> list = new ArrayList<T>();
        ResultSetMetaData rsmd = rs.getMetaData();
        int numberOfColumns = rsmd.getColumnCount();
        Set<String> databaseColumns = new HashSet<String>(); //数据库中所有的列
        for (int i = 1; i <= numberOfColumns; i++)
        {
            databaseColumns.add(rsmd.getColumnName(i));
        }

        Field[] fields = clazz.getDeclaredFields();
        List<Field> validFields = new ArrayList<Field>(); //有效的字段(能和数据库对应上的)
        for (Field field : fields)
        {
            if (databaseColumns.contains(getFieldName(field)))
            {
                validFields.add(field);
            }
        }
        while (rs.next())
        {
            T obj = clazz.newInstance(); //返回对象
            for (Field field : validFields)
            {
                if (!Modifier.isFinal(field.getModifiers()))
                {
                    field.setAccessible(true); //让字段可访问 有没有get、set方法都行
                    String fieldName = getFieldName(field);
                    field.set(obj, rs.getObject(fieldName));
                    field.setAccessible(false); //让字段可访问 有没有get、set方法都行
                }
            }
            list.add(obj);
        }
        return list;
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
}
