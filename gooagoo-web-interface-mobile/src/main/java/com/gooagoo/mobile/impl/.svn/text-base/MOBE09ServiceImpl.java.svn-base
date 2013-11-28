package com.gooagoo.mobile.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.mobile.api.ConsumeBillLinkInfoMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.mobe09.transform.GoodsInfoFromOnecodevalueRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/**
 * 接口MOBE09:通过一维码获取商品信息接口
 */
@Service("mobe09")
public class MOBE09ServiceImpl implements ImobileService
{

    @Autowired
    private ConsumeBillLinkInfoMobileService consumeBillLinkInfoMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        GoodsInfoFromOnecodevalueRoot root = new GoodsInfoFromOnecodevalueRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String shopentityid = parameter.getString("shopentityid");
            String itemserial = parameter.getString("itemserial");
            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobe09"));
            if (!StringUtils.hasText(shopentityid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SHOPENTITYID_IS_NULL);
            }
            if (!StringUtils.hasText(itemserial))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_ITEMSERIAL_IS_NULL);
            }
            root = this.consumeBillLinkInfoMobileService.getGoodsInfoByItemserial(shopentityid, itemserial);
            root.setResult("true");
            root.setMsg("扫码取商品信息成功");
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
