package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.trans.entity.gtsc14.transform.FindBillAddOrSubRoot;

public class GTSC28Test extends TestCase
{

    String interfaceCode = "gtsc28";//接口编码

    /**
     *转发器MAC地址不能为空
     */
    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "40:2c:f4:a8:38:b0"));
        list.add(new BasicNameValuePair("shopentityid", "01822K7105HMGOM07GRNH4EIISWR2K8D"));
        list.add(new BasicNameValuePair("tablesinfo", "[{\"deskarea\":\"空闲\",\"deskname\":\"101台\",\"deskno\":\"101\",\"deskstate\":\"标准台\",\"desktype\":\"中餐厅\",\"price\":\"0.00\"},{\"deskarea\":\"空闲\",\"deskname\":\"102台\",\"deskno\":\"102\",\"deskstate\":\"标准台\",\"desktype\":\"中餐厅\",\"price\":\"0.00\"},{\"deskarea\":\"空闲\",\"deskname\":\"103台\",\"deskno\":\"103\",\"deskstate\":\"标准台\",\"desktype\":\"中餐厅\",\"price\":\"0.00\"},{\"deskarea\":\"空闲\",\"deskname\":\"104台\",\"deskno\":\"104\",\"deskstate\":\"标准台\",\"desktype\":\"中餐厅\",\"price\":\"0.00\"},{\"deskarea\":\"空闲\",\"deskname\":\"105台\",\"deskno\":\"105\",\"deskstate\":\"标准台\",\"desktype\":\"中餐厅\",\"price\":\"0.00\"},{\"deskarea\":\"空闲\",\"deskname\":\"106台\",\"deskno\":\"106\",\"deskstate\":\"标准台\",\"desktype\":\"中餐厅\",\"price\":\"0.00\"},{\"deskarea\":\"空闲\",\"deskname\":\"107台\",\"deskno\":\"107\",\"deskstate\":\"标准台\",\"desktype\":\"中餐厅\",\"price\":\"0.00\"},{\"deskarea\":\"空闲\",\"deskname\":\"108台\",\"deskno\":\"108\",\"deskstate\":\"标准台\",\"desktype\":\"中餐厅\",\"price\":\"0.00\"},{\"deskarea\":\"空闲\",\"deskname\":\"109台\",\"deskno\":\"109\",\"deskstate\":\"标准台\",\"desktype\":\"中餐厅\",\"price\":\"0.00\"},{\"deskarea\":\"空闲\",\"deskname\":\"110台\",\"deskno\":\"110\",\"deskstate\":\"标准台\",\"desktype\":\"中餐厅\",\"price\":\"0.00\"},{\"deskarea\":\"空闲\",\"deskname\":\"111台\",\"deskno\":\"111\",\"deskstate\":\"标准台\",\"desktype\":\"中餐厅\",\"price\":\"0.00\"},{\"deskarea\":\"空闲\",\"deskname\":\"112台\",\"deskno\":\"112\",\"deskstate\":\"标准台\",\"desktype\":\"中餐厅\",\"price\":\"0.00\"},{\"deskarea\":\"空闲\",\"deskname\":\"113台\",\"deskno\":\"113\",\"deskstate\":\"标准台\",\"desktype\":\"中餐厅\",\"price\":\"0.00\"},{\"deskarea\":\"空闲\",\"deskname\":\"114台\",\"deskno\":\"114\",\"deskstate\":\"标准台\",\"desktype\":\"中餐厅\",\"price\":\"0.00\"},{\"deskarea\":\"空闲\",\"deskname\":\"115台\",\"deskno\":\"115\",\"deskstate\":\"标准台\",\"desktype\":\"中餐厅\",\"price\":\"0.00\"},{\"deskarea\":\"空闲\",\"deskname\":\"116台\",\"deskno\":\"116\",\"deskstate\":\"标准台\",\"desktype\":\"中餐厅\",\"price\":\"0.00\"},{\"deskarea\":\"空闲\",\"deskname\":\"117台\",\"deskno\":\"117\",\"deskstate\":\"标准台\",\"desktype\":\"中餐厅\",\"price\":\"0.00\"},{\"deskarea\":\"空闲\",\"deskname\":\"118台\",\"deskno\":\"118\",\"deskstate\":\"标准台\",\"desktype\":\"中餐厅\",\"price\":\"0.00\"}]"));
        FindBillAddOrSubRoot root = new FindBillAddOrSubRoot();
        root = (FindBillAddOrSubRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("上传房台汇总信息成功", root.getMsg().trim());
    }

}
