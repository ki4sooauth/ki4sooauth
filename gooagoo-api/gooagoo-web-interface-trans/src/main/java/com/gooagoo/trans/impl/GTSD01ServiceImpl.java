package com.gooagoo.trans.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.GooagooException;
import com.gooagoo.exception.MessageException;
import com.gooagoo.trans.api.AudioTransService;
import com.gooagoo.trans.common.InterfaceUtils;
import com.gooagoo.trans.common.MessageConst;
import com.gooagoo.trans.entity.gtsd01.transform.FindCouponInfoByCouponidRoot;
import com.gooagoo.trans.entity.transdata.GtsTransData;
import com.gooagoo.trans.service.ItransService;

@Service("gtsd01")
public class GTSD01ServiceImpl implements ItransService
{
    @Autowired
    private AudioTransService transService;

    @Override
    public String doItrans(HttpServletRequest request) throws Exception
    {
        FindCouponInfoByCouponidRoot root = new FindCouponInfoByCouponidRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String mac = parameter.getString("mac");
            String shopentityid = parameter.getString("shopentityid");
            String couponid = parameter.getString("couponid");
            String shopId = parameter.getString("shopid");
            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "gtsd01"));
            //校验入参
            if (!StringUtils.hasText(mac))
            {
                throw new MessageException(MessageConst.TRANS_PARAMETER_MAC_IS_NULL);
            }
            if (!StringUtils.hasText(shopentityid))
            {
                throw new MessageException(MessageConst.TRANS_PARAMETER_SHOPENTITYID_IS_NULL);
            }
            if (!StringUtils.hasText(couponid))
            {
                throw new MessageException(MessageConst.TRANS_PARAMETER_COUPONID_IS_NULL);
            }
            if (!StringUtils.hasText(shopId))
            {
                throw new MessageException(MessageConst.TRANS_PARAMETER_SHOPID_IS_NULL);
            }
            root = this.transService.findCouponInfoByCouponid(shopentityid, couponid, shopId);
            root.setResult("true");
            root.setMsg("根据优惠劵编号查询商家优惠劵信息成功");
        }
        catch (GooagooException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.TRANS_AUDIO_ERROR;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (MessageException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = ExceptionCache.get(e.getMessage());
            root.setMsg(err);
        }
        GtsTransData gtsTransData = new GtsTransData();
        gtsTransData.setResultJson(root.toJson());
        return gtsTransData.toJson();
    }
}
