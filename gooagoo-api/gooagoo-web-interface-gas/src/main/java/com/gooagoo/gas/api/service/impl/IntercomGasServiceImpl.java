package com.gooagoo.gas.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.shop.ShopUserInfoGeneratorQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.shop.ShopUserInfo;
import com.gooagoo.entity.generator.shop.ShopUserInfoExample;
import com.gooagoo.gas.api.service.IntercomGasService;
import com.gooagoo.gas.entity.gash01.transform.IntercomRoot;
import com.gooagoo.gas.entity.gash01.transform.Intercomuserinfo;
import com.google.gson.Gson;

@Service
public class IntercomGasServiceImpl implements IntercomGasService
{
    @Autowired
    private ShopUserInfoGeneratorQueryService shopUserInfoGeneratorQueryService;

    @Override
    public IntercomRoot queryShopPositionInfos(String shopEntityId) throws Exception
    {
        GooagooLog.info("queryShopPositionInfos-->入参:shopEntityId=" + shopEntityId);
        ShopUserInfoExample shopUserInfoExample = new ShopUserInfoExample();
        shopUserInfoExample.createCriteria().andShopEntityIdEqualTo(shopEntityId).andIsDelEqualTo("N");
        //查询店员列表
        List<ShopUserInfo> selectByExample = this.shopUserInfoGeneratorQueryService.selectByExample(shopUserInfoExample);
        GooagooLog.debug("查询店员列表" + new Gson().toJson(selectByExample));
        //店员信息
        List<Intercomuserinfo> intercomuserinfoList = null;
        if (CollectionUtils.isNotEmpty(selectByExample))
        {
            intercomuserinfoList = new ArrayList<Intercomuserinfo>();

            for (ShopUserInfo temp : selectByExample)
            {
                Intercomuserinfo intercomuserinfo = new Intercomuserinfo();
                intercomuserinfo.setShopentityid(temp.getShopEntityId());
                intercomuserinfo.setShopuserid(temp.getUserId());//店员助理id
                intercomuserinfo.setShopusername(temp.getName());
                intercomuserinfo.setShopuserimg(temp.getHeadImg());
                intercomuserinfoList.add(intercomuserinfo);
            }
        }
        //组装返回参数
        IntercomRoot root = new IntercomRoot();
        root.setIntercomuserinfo(intercomuserinfoList);
        return root;
    }
}
