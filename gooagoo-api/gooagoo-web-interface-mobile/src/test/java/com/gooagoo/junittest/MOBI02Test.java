package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.mobile.entity.mobi02.transform.MapPositionRoot;

public class MOBI02Test extends TestCase
{

    String interfaceCode = "mobi02";//接口编码

    public void testShopentityidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("shopentityid", ""));
        MapPositionRoot root = new MapPositionRoot();
        root = (MapPositionRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("", root.getMsg().trim());
    }

}
