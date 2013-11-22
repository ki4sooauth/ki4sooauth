package com.gooagoo.view.gms.shopinfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gooagoo.view.gms.crm.FUserDetail;

/**
 * 商家登录信息及商家用户登录信息
 * @author 
 *
 */
public class GmsLoginInfo implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String shopId; //商家id;
    private Integer shopType; //商家类型;
    private String userId; //商家用户id;
    private String shopEntityId;
    private String userType; //登录者类型（S商家 A普通管理员）
    private String headPic;//头像
    private String email; //邮箱
    private String nickName;//昵称
    private List<FShopAuthority> authList; //用户权限列表
    private List<FShopAuthority> allAuthList; //全部权限列表
    private Map<String, String> wordNames = new HashMap<String, String>();

    private List<FUserDetail> statistic = new ArrayList<FUserDetail>(); //用户条件
    private List<FUserDetail> detailList = new ArrayList<FUserDetail>(); //保存用户细分

    public List<FUserDetail> getStatistic()
    {
        return this.statistic;
    }

    public void setStatistic(List<FUserDetail> statistic)
    {
        this.statistic = statistic;
    }

    public void setDetailList(List<FUserDetail> detailList)
    {
        this.detailList = detailList;
    }

    public List<FUserDetail> getDetailList()
    {
        return this.detailList;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getHeadPic()
    {
        return this.headPic;
    }

    public void setHeadPic(String headPic)
    {
        this.headPic = headPic;
    }

    public String getNickName()
    {
        return this.nickName;
    }

    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }

    public List<FShopAuthority> getAuthList()
    {
        return this.authList;
    }

    public void setAuthList(List<FShopAuthority> authList)
    {
        this.authList = authList;
    }

    public List<FShopAuthority> getAllAuthList()
    {
        return this.allAuthList;
    }

    public void setAllAuthList(List<FShopAuthority> allAuthList)
    {
        this.allAuthList = allAuthList;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public Integer getShopType()
    {
        return this.shopType;
    }

    public void setShopType(Integer shopType)
    {
        this.shopType = shopType;
    }

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getShopEntityId()
    {
        return this.shopEntityId;
    }

    public void setShopEntityId(String shopEntityId)
    {
        this.shopEntityId = shopEntityId;
    }

    public String getUserType()
    {
        return this.userType;
    }

    public void setUserType(String userType)
    {
        this.userType = userType;
    }

    public Map<String, String> getWordNames()
    {
        return this.wordNames;
    }

    public void setWordNames(Map<String, String> wordNames)
    {
        this.wordNames = wordNames;
    }

    public String getWordName(String code)
    {
        String name = null;
        if (this.wordNames != null)
        {
            name = this.wordNames.get(code);
        }
        if (name == null)
        {
            name = "";
        }
        return name;
    }

}
