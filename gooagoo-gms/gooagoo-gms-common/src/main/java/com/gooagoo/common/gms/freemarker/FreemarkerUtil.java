package com.gooagoo.common.gms.freemarker;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import com.gooagoo.common.log.GooagooLog;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreemarkerUtil
{
    private static Map<String, Template> m = new HashMap<String, Template>();
    private static Configuration cfg = null;
    private static final String FTL_DIRECTORY_NAME = "/ftl";
    static
    {
        //通过Freemaker的Configuration读取相应的ftl
        cfg = new Configuration();
        //设定去哪里读取相应的ftl模板文件
        cfg.setDefaultEncoding("UTF-8");
        cfg.setOutputEncoding("UTF-8");
        cfg.setClassForTemplateLoading(FreemarkerUtil.class, FTL_DIRECTORY_NAME);
    }

    /**
     * 获取模板
     * @param name
     * @return
     */
    private static Template getTemplate(String name)
    {
        try
        {
            //在模板文件目录中找到名称为name的文件
            Template temp = m.get(name);
            if (temp != null)
            {
                return temp;
            }
            temp = cfg.getTemplate(name);
            m.put(name, temp);
            return temp;
        }
        catch (IOException e)
        {
            GooagooLog.error("freemarker获取模板失败,name=" + name, e);
        }
        return null;
    }

    /**
     * 将模板内容写入到输出流中
     * @param name 模板文件名称
     * @param root 模板数据
     * @param out 输出流
     */
    public static boolean print(String name, Map<String, Object> root, Writer out)
    {
        boolean isOk = false;
        try
        {
            Template temp = getTemplate(name);
            temp.process(root, out);
            isOk = true;
        }
        catch (Exception e)
        {
            GooagooLog.error("freemarker将模板内容写入到输出流中失败,name=" + name + ",root=" + root, e);
        }
        return isOk;
    }

    /**
     * 获取数据载入模板文件后的内容
     * @param name 模板文件名称
     * @param root 模板数据
     */
    public static String getContent(String name, Map<String, Object> root)
    {
        StringWriter sw = new StringWriter();
        if (FreemarkerUtil.print(name, root, sw))
        {
            return sw.toString();
        }
        return null;
    }
}