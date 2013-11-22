package com.gooagoo.entity.casclient.shop;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商家用户登录详细信息
 */
public class ShopLoginInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String token;//token值
    private ShopAndUserInfo shopAndUserInfo;//商家用户信息
    private List<ShopAuth> shopAuthList = new ArrayList<ShopAuth>();//商家用户权限
    private Map<String, String> wordNames = new HashMap<String, String>();//商家界面文字字典表数据

    public String getToken()
    {
        return this.token;
    }

    public void setToken(String token)
    {
        this.token = token;
    }

    public ShopAndUserInfo getShopAndUserInfo()
    {
        return this.shopAndUserInfo;
    }

    public void setShopAndUserInfo(ShopAndUserInfo shopAndUserInfo)
    {
        this.shopAndUserInfo = shopAndUserInfo;
    }

    public List<ShopAuth> getShopAuthList()
    {
        return this.shopAuthList;
    }

    public void setShopAuthList(List<ShopAuth> shopAuthList)
    {
        this.shopAuthList = shopAuthList;
    }

    public Map<String, String> getWordNames()
    {
        return this.wordNames;
    }

    public void setWordNames(Map<String, String> wordNames)
    {
        this.wordNames = wordNames;
    }

}
