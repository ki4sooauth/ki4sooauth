package com.json.test;

import java.util.List;

import com.gooagoo.trans.common.entity.BillDetailInfoJson;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Test
{
    public static void main(String[] args)
    {
        String json = "[{\"tablename\": \"111\",\"tablestate\": \"开台\",\"tabletypename\": \"标台\",\"diningnumbers\": \"2\",\"thirdorderid\": \"KT-130809-0007\",\"totalnum\": \"2\",\"totalprice\": \"80\",\"goodsinfolist\": [" + "{\"itemserial\": \"02310\",\"goodsname\": \"牛肉面\",\"goodsnums\": \"1\",\"goodsprice\": \"40\",\"servestate\": \"0\"" + "},{\"itemserial\": \"02310\",\"goodsname\": \"牛肉面\",\"goodsnums\": \"1\",\"goodsprice\": \"40\",\"servestate\": \"0\"}]}]";
        List<BillDetailInfoJson> list = new Gson().fromJson(json, new TypeToken<List<BillDetailInfoJson>>()
        {
        }.getType());
        System.out.println(list.get(0).toString());
    }
}
