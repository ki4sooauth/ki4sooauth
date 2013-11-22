package com.gooagoo.trans.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.trans.api.MemberManageTransService;
import com.gooagoo.trans.common.InterfaceUtils;
import com.gooagoo.trans.common.MessageConst;
import com.gooagoo.trans.entity.gtsb02.transform.ShopMemberCardsRoot;
import com.gooagoo.trans.entity.transdata.GtsTransData;
import com.gooagoo.trans.service.ItransService;

@Service("gtsb02")
public class GTSB02ServiceImpl implements ItransService
{
    @Autowired
    private MemberManageTransService memberManageTransService;

    @Override
    public String doItrans(HttpServletRequest request) throws Exception
    {
        ShopMemberCardsRoot root = new ShopMemberCardsRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String mac = parameter.getString("mac");
            String shopid = parameter.getString("shopid");
            String ctimestamp = parameter.getString("ctimestamp");
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "gtsb02"));
            if (!StringUtils.hasText(mac))
            {
                throw new MessageException(MessageConst.TRANS_PARAMETER_MAC_IS_NULL);
            }
            if (!StringUtils.hasText(shopid))
            {
                throw new MessageException(MessageConst.TRANS_PARAMETER_SHOPID_IS_NULL);
            }
            if (!StringUtils.hasText(ctimestamp))
            {
                throw new MessageException(MessageConst.TRANS_PARAMETER_CTIMESTAMP_IS_NULL);
            }
            root = this.memberManageTransService.getShopMemberCards(shopid, ctimestamp);
            root.setResult("true");
            root.setMsg("同步商家会员卡基本信息成功");

        }
        catch (MessageException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = ExceptionCache.get(e.getMessage());
            root.setMsg(err);
            root.setMsgcode(e.getMessage());
        }

        GtsTransData gtsTransData = new GtsTransData();
        gtsTransData.setResultJson(root.toJson());
        return gtsTransData.toJson();
    }
}
