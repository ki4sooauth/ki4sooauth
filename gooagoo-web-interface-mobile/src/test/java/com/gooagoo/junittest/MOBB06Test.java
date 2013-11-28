package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;

import com.gooagoo.mobile.entity.mobb06.transform.FavoritePlazaMenuRoot;

public class MOBB06Test extends TestCase
{

    String interfaceCode = "mobb06";//接口编码

    /**
     * 未查到符合条件的数据
     */
    public void testGetNoData()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        FavoritePlazaMenuRoot root = new FavoritePlazaMenuRoot();
        root = (FavoritePlazaMenuRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_COMMON_NOT_GET_WANT_DATA, root.getMsg().trim());
    }

    /**
     * 查询收藏广场列表侧边栏 成功
     */
    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        FavoritePlazaMenuRoot root = new FavoritePlazaMenuRoot();
        root = (FavoritePlazaMenuRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("获取收藏广场列表侧边栏成功", root.getMsg().trim());
    }

}
