package com.gooagoo.gas.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.gas.common.entity.GoodsInfoEntity;
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
            temp.setGoodsnum(Integer.valueOf(map.get("goodsnum")));
            resultGoosInfoList.add(temp);
        }
        return resultGoosInfoList;
    }
}
