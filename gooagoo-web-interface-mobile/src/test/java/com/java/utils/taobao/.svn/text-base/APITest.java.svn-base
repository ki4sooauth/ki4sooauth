package com.java.utils.taobao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class APITest
{
    protected static String testUrl = "http://gw.api.tbsandbox.com/router/rest";//沙箱环境调用地址
    protected static String appkey = "test";
    protected static String secret = "test";

    public static String testUserGet()
    {
        TreeMap<String, String> apiparamsMap = new TreeMap<String, String>();
        apiparamsMap.put("format", "xml");
        apiparamsMap.put("method", "taobao.user.seller.get");
        apiparamsMap.put("sign_method", "md5");
        apiparamsMap.put("app_key", appkey);
        apiparamsMap.put("v", "2.0");
        apiparamsMap.put("session", "test");
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        apiparamsMap.put("timestamp", timestamp);
        apiparamsMap.put("fields", "nick,user_id,type");//需要获取的字段
        // apiparamsMap.put("nick","sandbox_c_1");
        //生成签名
        String sign = Util.md5Signature(apiparamsMap, secret);
        apiparamsMap.put("sign", sign);
        StringBuilder param = new StringBuilder();
        for (Iterator<Map.Entry<String, String>> it = apiparamsMap.entrySet().iterator(); it.hasNext();)
        {
            Map.Entry<String, String> e = it.next();
            param.append("&").append(e.getKey()).append("=").append(e.getValue());
        }
        return param.toString().substring(1);
    }

    public static void main(String[] args)
    {
        String result = Util.getResult(testUrl, testUserGet());
        System.out.print(result);
    }
}