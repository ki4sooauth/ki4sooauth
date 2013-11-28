package com.gooagoo.mobile.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.mobile.common.entity.GoodsInfoEntity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ToolsUtils
{
    /**
     * 根据餐桌号信息串，取出餐桌相关信息
     * @param tableNo2d，格式：["gooagoo","00","实体店编号","桌号","房间号"]
     * @return List<String>，存放信息先后顺序为：gooagoo、00、实体店编号、桌号、房间号
     */
    public static List<String> getTableInfo(String tableNo2d)
    {
        Gson json = new Gson();
        List<String> list = json.fromJson(tableNo2d, new TypeToken<List<String>>()
        {
        }.getType());
        GooagooLog.debug("ToolsUtils->getTableInfo->取出的餐桌相关信息为：" + list.toString());
        return list;
    }

    /**
     * 根据商品信息json串获取商品信息
     * @param goodsInfo 商品信息，格式：[ { "goodsid": "00017STNPL7NIGF1T0000LEIISQNS0DL", "goodsnum":"2"}, { "goodsid": "00017STNPL7NIGF1T0000LEIISQNS0DL", "goodsnum":"20"}]
     * @return
     */
    public static List<GoodsInfoEntity> getGoodsInfo(String goodsInfo)
    {
        Gson json = new Gson();
        List<Map<String, String>> mapList = json.fromJson(goodsInfo, new TypeToken<List<Map<String, String>>>()
        {
        }.getType());

        GooagooLog.debug("ToolsUtils->getGoodsInfo->取出的商品信息为：" + mapList.toString());

        List<GoodsInfoEntity> resultGoosInfoList = new ArrayList<GoodsInfoEntity>();
        for (Map<String, String> map : mapList)
        {
            GoodsInfoEntity temp = new GoodsInfoEntity();
            temp.setGoodsId(map.get("goodsid"));
            temp.setGoodsnum(Integer.valueOf(map.get("goodsnum").trim()));
            resultGoosInfoList.add(temp);
        }
        return resultGoosInfoList;
    }

    /**
     * 解析收藏地址
     * @param favoriteUrl
     * @return
     * @throws Exception 
     */
    public static String[] analysisFavoriteUrl(String favoriteUrl) throws Exception
    {
        String[] result = new String[3];
        if (favoriteUrl.contains("coupon"))
        {
            result[0] = "coupon";
        }
        if (favoriteUrl.contains("active"))
        {
            result[0] = "active";
        }
        if (favoriteUrl.contains("goods"))
        {
            result[0] = "goods";
        }
        if (favoriteUrl.contains(".html?m="))
        {//网站端
            result[1] = favoriteUrl.substring(favoriteUrl.indexOf(".com/") + 5, favoriteUrl.indexOf(".html?m="));
            result[2] = favoriteUrl.substring(favoriteUrl.indexOf("html?m=") + 7);
        }
        else
        {//手机端
            result[1] = favoriteUrl.substring(favoriteUrl.indexOf(".com/") + 5, favoriteUrl.indexOf(".html"));
            result[2] = null;
        }

        return result;
    }

}
