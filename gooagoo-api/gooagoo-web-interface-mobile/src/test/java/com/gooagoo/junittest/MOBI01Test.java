package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.mobile.entity.mobi01.transform.MapActivityRoot;

public class MOBI01Test extends TestCase
{

    String interfaceCode = "mobi01";//接口编码

    public void testMapidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mapid", ""));
        MapActivityRoot root = new MapActivityRoot();
        root = (MapActivityRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("", root.getMsg().trim());
    }

}
