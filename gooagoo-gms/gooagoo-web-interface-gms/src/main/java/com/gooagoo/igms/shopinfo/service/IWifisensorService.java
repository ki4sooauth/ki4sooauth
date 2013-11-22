package com.gooagoo.igms.shopinfo.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.shopinfo.FDeviceWifisensor;
import com.gooagoo.view.gms.shopinfo.FShopLidDetail;

public interface IWifisensorService
{
 
    public TransData<PageModel<FDeviceWifisensor>> pageWifiSensor(HttpServletRequest request) throws Exception;
    public TransData<FDeviceWifisensor>  detailWifiSensor(HttpServletRequest request) throws Exception;
    public TransData<Object> updateWifiSensor(HttpServletRequest request) throws Exception;
}
