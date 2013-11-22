package com.gooagoo.igus.personal.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.user.deliveryaddress.DeliveryAddressCoreService;
import com.gooagoo.api.generator.query.user.ConsigneeInfoGeneratorQueryService;
import com.gooagoo.cache.AreaCache;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.Constants;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.constants.MessageConst;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.generator.user.ConsigneeInfo;
import com.gooagoo.entity.generator.user.ConsigneeInfoExample;
import com.gooagoo.igus.personal.service.IShippingAddressService;
import com.gooagoo.igus.utils.MessageAnnotation;
import com.gooagoo.view.gus.common.PageModel;
import com.gooagoo.view.gus.web.personal.UConsigeeInfo;

@Service("iShippingAddressService")
public class IShippingAddressServiceImpl implements IShippingAddressService
{

    @Autowired
    private DeliveryAddressCoreService deliveryAddressCoreService;

    @Autowired
    private ConsigneeInfoGeneratorQueryService consigneeInfoService;

    @Override
    @MessageAnnotation(InterGusConstants.PERSONAL_SHIPPINGADDRESS_GETSHIPPINGADDRESSLIST)
    public TransData<Object> getShippingAddressList(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            PageModel<UConsigeeInfo> pageModel = new PageModel<UConsigeeInfo>();
            //传递userId执行查询 
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            Integer pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex", 1);
            Integer pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 6);
            ConsigneeInfoExample consigneeInfoExample = new ConsigneeInfoExample();
            consigneeInfoExample.createCriteria().andUserIdEqualTo(userId).andIsDelEqualTo("N");
            Integer count = this.consigneeInfoService.countByExample(consigneeInfoExample);
            consigneeInfoExample.setPage(pageIndex, pageSize);
            consigneeInfoExample.setOrderByClause("create_time desc");
            List<ConsigneeInfo> consigneeInfoList = this.consigneeInfoService.selectByExample(consigneeInfoExample);
            if (CollectionUtils.isEmpty(consigneeInfoList))
            {
                GooagooLog.info("查询用户收获地址列表:没有查到收货人信息");
                return new TransData<Object>(true, MessageConst.COMMON_NOTESIST, null);
            }
            List<UConsigeeInfo> uconsigeeInfoList = new ArrayList<UConsigeeInfo>();
            for (ConsigneeInfo consigneeInfo : consigneeInfoList)
            {
                UConsigeeInfo uconsigeeInfo = new UConsigeeInfo();
                uconsigeeInfo.setAddress(consigneeInfo.getAddress());
                uconsigeeInfo.setUserId(consigneeInfo.getUserId());
                if (StringUtils.isNotBlank(consigneeInfo.getTelephone()))
                {
                    String[] strs = consigneeInfo.getTelephone().split("-");
                    uconsigeeInfo.setTelephone1(strs[0]);
                    uconsigeeInfo.setTelephone2(strs[1]);
                    if (strs.length > 2)
                    {
                        uconsigeeInfo.setTelephone3(strs[2]);
                    }
                }
                uconsigeeInfo.setConsigneeId(consigneeInfo.getConsigneeId());
                uconsigeeInfo.setConsigneeName(consigneeInfo.getConsigneeName());
                uconsigeeInfo.setIsDefault(consigneeInfo.getIsDefault());
                uconsigeeInfo.setPhone(consigneeInfo.getPhone());
                uconsigeeInfo.setPostCode(consigneeInfo.getPostCode());
                uconsigeeInfo.setAreaId(consigneeInfo.getArea());
                uconsigeeInfo.setCityId(consigneeInfo.getCity());
                uconsigeeInfo.setProvinceId(consigneeInfo.getProvince());
                uconsigeeInfo.setAreaName(AreaCache.getSelf(consigneeInfo.getArea()));
                uconsigeeInfo.setCityName(AreaCache.getSelf(consigneeInfo.getCity()));
                uconsigeeInfo.setProvinceName(AreaCache.getSelf(consigneeInfo.getProvince()));
                uconsigeeInfoList.add(uconsigeeInfo);
            }
            pageModel.setPageIndex(pageIndex);
            pageModel.setPageSize(pageSize);
            pageModel.setResult(uconsigeeInfoList);
            pageModel.setCount(count);
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, pageModel);
        }
        catch (Exception e)
        {
            GooagooLog.error("获取收货地址列表:查询用户所有收货地址异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }

        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.PERSONAL_SHIPPINGADDRESS_ADDSHIPPINGADDRE)
    public TransData<Object> addShippingAddress(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            ConsigneeInfo consigneeInfo = ServletUtils.objectMethod(ConsigneeInfo.class, request);
            String telephone1 = ServletRequestUtils.getStringParameter(request, "telephone1");
            String telephone2 = ServletRequestUtils.getStringParameter(request, "telephone2");
            String telephone3 = ServletRequestUtils.getStringParameter(request, "telephone3");
            if (StringUtils.isNotBlank(telephone1) && StringUtils.isNotBlank(telephone2) && StringUtils.isNotBlank(telephone3))
            {
                consigneeInfo.setTelephone(telephone1 + "-" + telephone2 + "-" + telephone3);
            }
            if (StringUtils.isNotBlank(telephone1) && StringUtils.isNotBlank(telephone2) && StringUtils.isBlank(telephone3))
            {
                consigneeInfo.setTelephone(telephone1 + "-" + telephone2);
            }
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            consigneeInfo.setUserId(userId);
            if (!this.deliveryAddressCoreService.addDeliveryAddress(consigneeInfo))
            {
                GooagooLog.info("增加收货地址:增加收货地址失败（" + consigneeInfo.toString() + "）");
                return new TransData<Object>(false, MessageConst.PERSONAL_ISIPPINGADDRESS_ADDSHIPPINGADDRESS_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.PERSONAL_ISIPPINGADDRESS_ADDSHIPPINGADDRESS_SUCCESS, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("增加收货地址:新增用户收货地址异常", e);
            transData = new TransData<Object>(false, MessageConst.PERSONAL_ISIPPINGADDRESS_ADDSHIPPINGADDRESS_FAIL, null);
        }
        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.PERSONAL_SHIPPINGADDRESS_SETDEFAULTSHIPPINGADDRE)
    public TransData<Object> setDefaultShippingAddress(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            String consigneeId = ServletRequestUtils.getStringParameter(request, "consigneeId");
            if (this.deliveryAddressCoreService.setDeliveryAddress(userId, consigneeId))
            {
                transData = new TransData<Object>(true, MessageConst.PERSONAL_ISIPPINGADDRESS_UPDATESHIPPINGADDRESS_SUCCESS, null);
            }
            else
            {
                GooagooLog.info("设为默认收货地址:设为默认收货地址失败（" + consigneeId + "）");
                transData = new TransData<Object>(false, MessageConst.PERSONAL_ISIPPINGADDRESS_UPDATESHIPPINGADDRESS_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.PERSONAL_ISIPPINGADDRESS_SETDEFAULTSHIPPINGADDRESS_SUCCESS, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("设为默认收货地址：设置失败", e);
            transData = new TransData<Object>(false, MessageConst.PERSONAL_ISIPPINGADDRESS_SETDEFAULTSHIPPINGADDRESS_FAIL, null);
        }
        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.PERSONAL_SHIPPINGADDRESS_UPDATESHIPPINGADDRE)
    public TransData<Object> updateShippingAddress(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            //传递addressID执行修改
            ConsigneeInfo consigneeInfo = ServletUtils.objectMethod(ConsigneeInfo.class, request);
            String telephone1 = ServletRequestUtils.getStringParameter(request, "telephone1");
            String telephone2 = ServletRequestUtils.getStringParameter(request, "telephone2");
            String telephone3 = ServletRequestUtils.getStringParameter(request, "telephone3");
            if (StringUtils.isNotBlank(telephone1) && StringUtils.isNotBlank(telephone2) && StringUtils.isNotBlank(telephone3))
            {
                consigneeInfo.setTelephone(telephone1 + "-" + telephone2 + "-" + telephone3);
            }
            if (StringUtils.isNotBlank(telephone1) && StringUtils.isNotBlank(telephone2) && StringUtils.isBlank(telephone3))
            {
                consigneeInfo.setTelephone(telephone1 + "-" + telephone2);
            }
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            consigneeInfo.setUserId(userId);
            ConsigneeInfo newConsigneeInfo = this.deliveryAddressCoreService.updateDeliveryAddress(consigneeInfo);
            if (newConsigneeInfo != null)
            {
                transData = new TransData<Object>(true, MessageConst.PERSONAL_ISIPPINGADDRESS_UPDATESHIPPINGADDRESS_SUCCESS, newConsigneeInfo);
            }
            else
            {
                GooagooLog.info("修改收货地址:修改收货地址失败（" + consigneeInfo.toString() + "）");
                transData = new TransData<Object>(false, MessageConst.PERSONAL_ISIPPINGADDRESS_UPDATESHIPPINGADDRESS_FAIL, null);
            }
        }
        catch (Exception e)
        {
            GooagooLog.error("修改收货地址：修改失败", e);
            transData = new TransData<Object>(false, MessageConst.PERSONAL_ISIPPINGADDRESS_UPDATESHIPPINGADDRESS_FAIL, null);
        }
        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.PERSONAL_SHIPPINGADDRESS_DELETESHIPPINGADDRE)
    public TransData<Object> deleteShippingAddress(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            //传递addressID执行删除
            String consigneeId = ServletRequestUtils.getStringParameter(request, "consigneeId");
            if (!this.deliveryAddressCoreService.deleteDeliveryAddress(consigneeId))
            {
                GooagooLog.info("删除收货地址:删除收货地址失败（" + consigneeId + "）");
                return new TransData<Object>(false, MessageConst.PERSONAL_ISIPPINGADDRESS_DELETESHIPPINGADDRESS_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.PERSONAL_ISIPPINGADDRESS_DELETESHIPPINGADDRESS_SUCCESS, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("删除收货地址:删除用户收货地址异常", e);
            transData = new TransData<Object>(false, MessageConst.PERSONAL_ISIPPINGADDRESS_DELETESHIPPINGADDRESS_FAIL, null);
        }
        return transData;
    }
}
