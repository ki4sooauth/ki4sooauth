package com.gooagoo.mobile.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.user.deliveryaddress.DeliveryAddressCoreService;
import com.gooagoo.api.generator.query.user.ConsigneeInfoGeneratorQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.user.ConsigneeInfo;
import com.gooagoo.entity.generator.user.ConsigneeInfoExample;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.GooagooException;
import com.gooagoo.mobile.api.CommonMobileService;
import com.gooagoo.mobile.api.ConsigneeInfoMobileService;
import com.gooagoo.mobile.entity.mobo01.transform.Consigneeinfo;
import com.gooagoo.mobile.entity.mobo01.transform.GetConsigneeInfoRoot;
import com.google.gson.Gson;

@Service
public class ConsigneeInfoMobileServiceImpl implements ConsigneeInfoMobileService
{
    @Autowired
    private DeliveryAddressCoreService deliveryAddressCoreService;
    @Autowired
    private ConsigneeInfoGeneratorQueryService consigneeInfoGeneratorQueryService;
    @Autowired
    private CommonMobileService commonMobileService;

    @Override
    public GetConsigneeInfoRoot getConsigneeInfo(String userId, String sessionId) throws Exception
    {
        GooagooLog.info("getConsigneeInfo,mobo01:添加收货人地址信息入参信息为-->:userId=" + userId + ",sessionId=" + sessionId);
        //校验登陆状态
        this.commonMobileService.checkLoginStatus(userId, sessionId);
        ConsigneeInfoExample example = new ConsigneeInfoExample();
        example.createCriteria().andUserIdEqualTo(userId).andIsDelEqualTo("N");
        List<ConsigneeInfo> info = this.consigneeInfoGeneratorQueryService.selectByExample(example);

        List<Consigneeinfo> consigneeinfoList = null;
        if (CollectionUtils.isNotEmpty(consigneeinfoList))
        {
            consigneeinfoList = new ArrayList<Consigneeinfo>();
            for (ConsigneeInfo t : info)
            {
                Consigneeinfo consigneeInfo = new Consigneeinfo();
                consigneeInfo.setAddress(t.getAddress());
                consigneeInfo.setArea(t.getArea());
                consigneeInfo.setCity(t.getCity());
                consigneeInfo.setConsigneeid(t.getConsigneeId());
                consigneeInfo.setConsigneename(t.getConsigneeName());
                consigneeInfo.setIsdefault(t.getIsDefault());
                consigneeInfo.setPhone(t.getPhone());
                consigneeInfo.setPostcode(t.getPostCode());
                consigneeInfo.setProvince(t.getProvince());
                consigneeInfo.setTelephone(t.getTelephone());
                consigneeinfoList.add(consigneeInfo);

            }

        }
        GetConsigneeInfoRoot root = new GetConsigneeInfoRoot();
        root.setConsigneeinfo(consigneeinfoList);
        return root;
    }

    @Override
    public void editConsigneeInfo(String userId, String sessionId, Parameter parameter) throws Exception
    {

        GooagooLog.info("editConsigneeInfo,mobo02:编辑用户收货地址信息入参信息为-->:userId=" + userId + ",sessionId=" + sessionId + ",parameter=" + new Gson().toJson(parameter));
        //校验登陆状态
        this.commonMobileService.checkLoginStatus(userId, sessionId);

        ConsigneeInfo consigneeInfo = new ConsigneeInfo();
        consigneeInfo.setAddress(parameter.getString("address"));
        consigneeInfo.setArea(parameter.getString("area"));
        consigneeInfo.setCity(parameter.getString("city"));
        consigneeInfo.setConsigneeId(parameter.getString("consigneeid"));
        consigneeInfo.setConsigneeName(parameter.getString("consigneename"));
        consigneeInfo.setIsDefault(parameter.getString("isdefault"));
        consigneeInfo.setPhone(parameter.getString("phone"));
        consigneeInfo.setProvince(parameter.getString("province"));
        consigneeInfo.setTelephone(parameter.getString("telephone"));
        consigneeInfo.setUserId(userId);

        this.deliveryAddressCoreService.updateDeliveryAddress(consigneeInfo);

    }

    @Override
    public void delConsigneeInfo(String userId, String sessionId, String consigneeId) throws Exception
    {
        GooagooLog.info("delConsigneeInfo,mobo03:删除收货人地址信息入参信息为-->:userId=" + userId + ",sessionId=" + sessionId + ",consigneeId=" + consigneeId);
        //校验登陆状态
        this.commonMobileService.checkLoginStatus(userId, sessionId);
        if (!this.deliveryAddressCoreService.deleteDeliveryAddress(consigneeId))
        {
            GooagooLog.info("删除收货人地址信息consigneeId：" + consigneeId);
            throw new GooagooException("删除收货人地址信息失败");
        }
    }

    @Override
    public void addConsigneeInfo(String userId, String sessionId, Parameter parameter) throws Exception
    {
        GooagooLog.info("addConsigneeInfo,mobo04:新增用户收货地址信息入参信息为-->:userId=" + userId + ",sessionId=" + sessionId + ",parameter=" + new Gson().toJson(parameter));
        //校验登陆状态
        this.commonMobileService.checkLoginStatus(userId, sessionId);

        ConsigneeInfo consigneeInfo = new ConsigneeInfo();
        consigneeInfo.setAddress(parameter.getString("address"));
        consigneeInfo.setArea(parameter.getString("area"));
        consigneeInfo.setCity(parameter.getString("city"));
        consigneeInfo.setConsigneeName(parameter.getString("consigneename"));
        consigneeInfo.setIsDefault(parameter.getString("isdefault"));
        consigneeInfo.setPhone(parameter.getString("phone"));
        consigneeInfo.setProvince(parameter.getString("province"));
        consigneeInfo.setTelephone(parameter.getString("telephone"));
        consigneeInfo.setUserId(userId);

        if (!this.deliveryAddressCoreService.addDeliveryAddress(consigneeInfo))
        {
            GooagooLog.info("新增用户收货地址信息失败consigneeInfo：" + new Gson().toJson(consigneeInfo));
            throw new GooagooException("新增用户收货地址信息失败");
        }

    }
}
