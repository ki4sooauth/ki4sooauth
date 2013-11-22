package com.gooagoo.mobile.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.GooagooException;
import com.gooagoo.exception.MessageException;
import com.gooagoo.exception.business.bill.OrderAlreadyExistsException;
import com.gooagoo.mobile.api.ConsumeBillLinkOrderMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.mobe05.transform.SubmitOrderFormRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/**
 * 接口MOBE05:手机提交点菜单信息接口
 */
@Service("mobe05")
public class MOBE05ServiceImpl implements ImobileService
{
    @Autowired
    private ConsumeBillLinkOrderMobileService consumeBillLinkOrderMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        SubmitOrderFormRoot root = new SubmitOrderFormRoot();
        root.setResult("false");
        try
        {

            Parameter parameter = InterfaceUtils.collectParameter(request);
            String mac = parameter.getString("mac");
            String userid = parameter.getString("userid");
            String sessionid = parameter.getString("sessionid");
            String shopid = parameter.getString("shopid");
            String goodsidlist = parameter.getString("goodsidlist");
            String tableno2d = parameter.getString("tableno2d");
            String type = parameter.getString("type");
            String shopEntityId = parameter.getString("shopentityid");
            String takeMethod = parameter.getString("takemethod");//提货方式,0-直接拿走、1-前台提货、2-送货上门 
            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobe05"));
            if (!StringUtils.hasText(mac))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_MAC_IS_NULL);
            }
            if (!StringUtils.hasText(userid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_USERID_IS_NULL);
            }
            if (!StringUtils.hasText(sessionid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SESSIONID_IS_NULL);
            }
            if (!StringUtils.hasText(shopid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SHOPID_IS_NULL);
            }
            if (!StringUtils.hasText(shopEntityId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SHOPENTITYID_IS_NULL);
            }
            if (!StringUtils.hasText(takeMethod))
            {//提货方式，0-直接拿走、1-前台提货、2-送货上门 
                throw new MessageException(MessageConst.MOBILE_PARAMETER_TAKEMETHOD_IS_NULL);
            }
            if (!StringUtils.hasText(type))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_ORDERTYPE_IS_NULL);
            }
            if ("00".equals(type) && !StringUtils.hasText(tableno2d))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_TABLENO2D_IS_NULL);
            }
            if (!StringUtils.hasText(goodsidlist))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_GOODSIDLIST_IS_NULL);
            }

            root = this.consumeBillLinkOrderMobileService.submitOrder(userid, sessionid, type, request, shopid, shopEntityId, tableno2d, goodsidlist);
            root.setMsg("订单提交成功");
            root.setResult("true");
        }
        catch (OrderAlreadyExistsException e)
        {//餐桌已被占用，请更换餐桌再提交订单
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_BILL_TABLE_IS_USE_PLEASE_CHANGE;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (GooagooException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_BILL_SUBMIT_ORDER_FAIL;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (MessageException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = ExceptionCache.get(e.getMessage());
            root.setMsg(err);
            root.setMsgcode(e.getMessage());
        }

        MobileTransData mobileTransData = new MobileTransData();
        mobileTransData.setResultJson(root.toJson());
        return mobileTransData.toJson();
    }
}
