package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.gas.entity.gasj03.transform.DeskStatusDetailRoot;

/**
 * 店员查询本实体店各类型餐桌状态
 * @author Administrator
 *
 */
public class GASJ03Test extends TestCase
{
    String interfaceCode = "gasj03";//接口编码

    /**
     * 店员助理mac地址不能为空
     */
    public void testMacIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("tabletypecode", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        list.add(new BasicNameValuePair("pageindex", ""));
        list.add(new BasicNameValuePair("pagesize", ""));
        DeskStatusDetailRoot root = new DeskStatusDetailRoot();
        root = (DeskStatusDetailRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_MAC_IS_NULL, root.getMsg().trim());
    }

    /**
     * 店员登录账号不能为空
     */
    public void testShopUseridIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("tabletypecode", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        list.add(new BasicNameValuePair("pageindex", ""));
        list.add(new BasicNameValuePair("pagesize", ""));
        DeskStatusDetailRoot root = new DeskStatusDetailRoot();
        root = (DeskStatusDetailRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_SHOPUSERID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 商家编号不能为空
     */
    public void testShopidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("tabletypecode", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        list.add(new BasicNameValuePair("pageindex", ""));
        list.add(new BasicNameValuePair("pagesize", ""));
        DeskStatusDetailRoot root = new DeskStatusDetailRoot();
        root = (DeskStatusDetailRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_SHOPID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 餐桌类型不能为空
     */
    public void testTabletypecodeIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("tabletypecode", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        list.add(new BasicNameValuePair("pageindex", ""));
        list.add(new BasicNameValuePair("pagesize", ""));
        DeskStatusDetailRoot root = new DeskStatusDetailRoot();
        root = (DeskStatusDetailRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("餐桌类型不能为空", root.getMsg().trim());
    }

    /**
     * 实体店编号不能为空
     */
    public void testShopentityidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("tabletypecode", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        list.add(new BasicNameValuePair("pageindex", ""));
        list.add(new BasicNameValuePair("pagesize", ""));
        DeskStatusDetailRoot root = new DeskStatusDetailRoot();
        root = (DeskStatusDetailRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_SHOPENTITYID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 页码不能为空
     */
    public void testPageindexIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("tabletypecode", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        list.add(new BasicNameValuePair("pageindex", ""));
        list.add(new BasicNameValuePair("pagesize", ""));
        DeskStatusDetailRoot root = new DeskStatusDetailRoot();
        root = (DeskStatusDetailRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        root = (DeskStatusDetailRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_PAGEINDEX_IS_NULL, root.getMsg().trim());
    }

    /**
     *每页信息显示条数不能为空
     */
    public void testPagesizeIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("itype", "gasj03"));
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("tabletypecode", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        list.add(new BasicNameValuePair("pageindex", ""));
        list.add(new BasicNameValuePair("pagesize", ""));
        DeskStatusDetailRoot root = new DeskStatusDetailRoot();
        root = (DeskStatusDetailRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_PAGESIZE_IS_NULL, root.getMsg().trim());
    }

    /**
     *未查询到符合条件的数据
     */
    public void testError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("tabletypecode", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        list.add(new BasicNameValuePair("pageindex", ""));
        list.add(new BasicNameValuePair("pagesize", ""));
        DeskStatusDetailRoot root = new DeskStatusDetailRoot();
        root = (DeskStatusDetailRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_COMMON_NOT_GET_WANT_DATA, root.getMsg().trim());
    }

    /**
     * 查询餐桌状态详情成功
     */
    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("tabletypecode", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        list.add(new BasicNameValuePair("pageindex", ""));
        list.add(new BasicNameValuePair("pagesize", ""));
        DeskStatusDetailRoot root = new DeskStatusDetailRoot();
        root = (DeskStatusDetailRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("查询餐桌状态详情成功", root.getMsg().trim());
    }
}
