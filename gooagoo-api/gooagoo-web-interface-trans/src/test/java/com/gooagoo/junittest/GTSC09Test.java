package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.trans.entity.gtsc09.transform.GetAllDeskStatusRoot;

public class GTSC09Test extends TestCase
{

    String interfaceCode = "gtsc09";//接口编码

    /**
     * 转发器MAC地址不能为空
     */
    public void testMacIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopid", "00017QB336KQEMJCR00006SXUXJ1T002"));
        list.add(new BasicNameValuePair("shopentityid", "00017R07MTBFPI81N0000NBJ43J9P00K"));
        list.add(new BasicNameValuePair("pageIndex", "1"));
        list.add(new BasicNameValuePair("pageSize", "10"));
        GetAllDeskStatusRoot root = new GetAllDeskStatusRoot();
        root = (GetAllDeskStatusRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.TRANS_PARAMETER_MAC_IS_NULL, root.getMsg().trim());
    }

    /**
     * 商家编号不能为空
     */
    public void testShopidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:fe"));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("shopentityid", "00017R07MTBFPI81N0000NBJ43J9P00K"));
        list.add(new BasicNameValuePair("pageIndex", "1"));
        list.add(new BasicNameValuePair("pageSize", "10"));
        GetAllDeskStatusRoot root = new GetAllDeskStatusRoot();
        root = (GetAllDeskStatusRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.TRANS_PARAMETER_SHOPID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 实体店编号不能为空
     */
    public void testShopentityidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:fe"));
        list.add(new BasicNameValuePair("shopid", "00017QB336KQEMJCR00006SXUXJ1T002"));
        list.add(new BasicNameValuePair("shopentityid", ""));
        list.add(new BasicNameValuePair("pageIndex", "1"));
        list.add(new BasicNameValuePair("pageSize", "10"));
        GetAllDeskStatusRoot root = new GetAllDeskStatusRoot();
        root = (GetAllDeskStatusRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.TRANS_PARAMETER_SHOPENTITYID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 页码不能为空
     */
    public void testPageIndexIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:fe"));
        list.add(new BasicNameValuePair("shopid", "00017QB336KQEMJCR00006SXUXJ1T002"));
        list.add(new BasicNameValuePair("shopentityid", "00017R07MTBFPI81N0000NBJ43J9P00K"));
        list.add(new BasicNameValuePair("pageIndex", ""));
        list.add(new BasicNameValuePair("pageSize", "10"));
        GetAllDeskStatusRoot root = new GetAllDeskStatusRoot();
        root = (GetAllDeskStatusRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("页码不能为空", root.getMsg().trim());
    }

    /**
     * 每页信息显示条数不能为空
     */
    public void testPageSizeIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:fe"));
        list.add(new BasicNameValuePair("shopid", "00017QB336KQEMJCR00006SXUXJ1T002"));
        list.add(new BasicNameValuePair("shopentityid", "00017R07MTBFPI81N0000NBJ43J9P00K"));
        list.add(new BasicNameValuePair("pageIndex", "1"));
        list.add(new BasicNameValuePair("pageSize", ""));
        GetAllDeskStatusRoot root = new GetAllDeskStatusRoot();
        root = (GetAllDeskStatusRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.TRANS_PARAMETER_PAGESIZE_IS_NULL, root.getMsg().trim());
    }

    /**
     * 未查询到符合条件的数据
     */
    public void testGetNoData()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:fe"));
        list.add(new BasicNameValuePair("shopid", "00017QB336KQEMJCR00006SXUXJ1T002"));
        list.add(new BasicNameValuePair("shopentityid", "00017R07MTBFPI81N0000NBJ43J9P00K"));
        list.add(new BasicNameValuePair("pageIndex", "1"));
        list.add(new BasicNameValuePair("pageSize", "10"));
        GetAllDeskStatusRoot root = new GetAllDeskStatusRoot();
        root = (GetAllDeskStatusRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.TRANS_COMMON_NOT_GET_WANT_DATA, root.getMsg().trim());
    }

    /**
     * 查询所有餐桌状态成功
     */
    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:fe"));
        list.add(new BasicNameValuePair("shopid", "00017QB336KQEMJCR00006SXUXJ1T002"));
        list.add(new BasicNameValuePair("shopentityid", "00017R07MTBFPI81N0000NBJ43J9P00K"));
        list.add(new BasicNameValuePair("pageIndex", "1"));
        list.add(new BasicNameValuePair("pageSize", "10"));
        GetAllDeskStatusRoot root = new GetAllDeskStatusRoot();
        root = (GetAllDeskStatusRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("查询所有餐桌状态成功", root.getMsg().trim());
    }

}
