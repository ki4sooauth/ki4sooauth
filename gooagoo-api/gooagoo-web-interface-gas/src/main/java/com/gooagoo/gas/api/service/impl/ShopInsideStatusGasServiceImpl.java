package com.gooagoo.gas.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.shop.position.ShopPositionQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.business.shop.MainAreaBusiness;
import com.gooagoo.entity.business.shop.SubAreaBusiness;
import com.gooagoo.gas.api.service.ShopInsideStatusGasService;
import com.gooagoo.gas.entity.gasb01.transform.StoreMainAreaRoot;
import com.gooagoo.gas.entity.gasb01.transform.Storearealist;
import com.gooagoo.gas.entity.gasb01.transform.Storesubarea;
import com.google.gson.Gson;

@Service
public class ShopInsideStatusGasServiceImpl implements ShopInsideStatusGasService
{
    @Autowired
    private ShopPositionQueryService shopPositionQueryService;

    @Override
    public StoreMainAreaRoot queryAreaPeopleNums(String shopEntityid, String positionId) throws Exception
    {
        GooagooLog.info("queryAreaPeopleNums-->入参：shopEntityid=" + shopEntityid + ",positionId");
        //1.查询区域人数信息
        List<MainAreaBusiness> mainAreaBusinessList = this.shopPositionQueryService.findShopPositionNumberOfPeople(shopEntityid, positionId);

        GooagooLog.debug("查询到的区域人数信息为:" + new Gson().toJson(mainAreaBusinessList));

        //2.封装查询到区域人数信息
        List<Storearealist> storearealist = null;
        if (CollectionUtils.isNotEmpty(mainAreaBusinessList))
        {
            storearealist = new ArrayList<Storearealist>();
            for (MainAreaBusiness tempMainAreaBusiness : mainAreaBusinessList)
            {
                Storearealist tempStorearea = new Storearealist();
                tempStorearea.setStoreareaid(tempMainAreaBusiness.getStoreAreaId());
                tempStorearea.setStoreareaname(tempMainAreaBusiness.getStoreAreaName());
                tempStorearea.setStoreareacount(tempMainAreaBusiness.getStoreAreaCount());
                tempStorearea.setStoreid(tempMainAreaBusiness.getStoreId());

                List<Storesubarea> storesubareaList = null;
                if (CollectionUtils.isNotEmpty(tempMainAreaBusiness.getSubAreaBusinessList()))
                {
                    storesubareaList = new java.util.ArrayList<Storesubarea>();
                    for (SubAreaBusiness tempSubAreaBusiness : tempMainAreaBusiness.getSubAreaBusinessList())
                    {
                        Storesubarea tempStoresubarea = new Storesubarea();
                        tempStoresubarea.setStoresubareaid(tempSubAreaBusiness.getStoreSubAreaId());
                        tempStoresubarea.setStoresubareaname(tempSubAreaBusiness.getStoreSubAreaName());
                        tempStoresubarea.setStoreareacount(tempSubAreaBusiness.getStoreAreaCount());
                        storesubareaList.add(tempStoresubarea);
                    }
                }

                tempStorearea.setStoresubarea(storesubareaList);
                storearealist.add(tempStorearea);
            }
        }

        StoreMainAreaRoot root = new StoreMainAreaRoot();
        root.setStorearealist(storearealist);

        return root;
    }
}
