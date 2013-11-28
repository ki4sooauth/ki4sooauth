package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.mobile.common.HttpClientUtils;
import com.gooagoo.mobile.common.UrlConst;
import com.gooagoo.mobile.common.entity.PlfPayEntity;

public class MOBM01Test extends TestCase
{
    //    public void testSend()
    //    {
    //        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
    //        Map<String, String> json = new HashMap<String, String>();
    //        json.put("OrderId", "2013100000003403");
    //        json.put("RespCode", "0000");
    //        json.put("RespMsg", "支付成功");
    //        json.put("qn", "201311061010390028292");
    //        list.add(new BasicNameValuePair("json", JsonUtils.toJson(json)));
    //        CheckCardRoot root = new CheckCardRoot();
    //        root = (CheckCardRoot) HttpClientUtils.HttpPost(list, root, "plf01");
    //        Assert.assertEquals("", root.getMsg().trim());
    //    }

    public void testplf()
    {
        PlfPayEntity plfPayEntity = new PlfPayEntity();
        plfPayEntity.setPartnerId("131101104401");
        plfPayEntity.setMerId("104440148990039");
        plfPayEntity.setOrderId("104440148990039");
        Double amount = 10.00 * 100;
        plfPayEntity.setAmount(Integer.valueOf(amount.intValue()));
        plfPayEntity.setBackEndUrl(UrlConst.BACK_END_URL);
        plfPayEntity.setOrderDescription("");
        plfPayEntity.setOrderTime(TimeUtils.convertDateToString(new Date(), TimeUtils.FORMAT6));
        List<NameValuePair> paramlist = new ArrayList<NameValuePair>();//传入参数
        paramlist.add(new BasicNameValuePair("json", JsonUtils.toJson(plfPayEntity)));
        try
        {
            System.out.println(HttpClientUtils.HttpPost(UrlConst.ORDER_PAY_URL, paramlist));
            ;
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void testplf01()
    {
        Map<String, String> map = new HashMap<String, String>();
        map.put("OrderId", "1234566");
        map.put("RespCode", "0001");
        List<NameValuePair> paramlist = new ArrayList<NameValuePair>();//传入参数
        paramlist.add(new BasicNameValuePair("json", JsonUtils.toJson(map)));
        try
        {
            System.out.println(HttpClientUtils.HttpPost(UrlConst.BACK_END_URL, paramlist));
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
