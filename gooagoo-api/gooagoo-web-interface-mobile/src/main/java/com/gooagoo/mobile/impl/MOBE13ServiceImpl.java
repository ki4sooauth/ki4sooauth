package com.gooagoo.mobile.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.exception.business.behave.AlreadyArrangedException;
import com.gooagoo.exception.business.behave.NotNeedArrangeException;
import com.gooagoo.mobile.api.ConsumeBillLinkInfoMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.mobe13.transform.QueueRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/**
 * 接口MOBE13:用餐排号
 */
@Service("mobe13")
public class MOBE13ServiceImpl implements ImobileService
{

    @Autowired
    private ConsumeBillLinkInfoMobileService consumeBillLinkInfoMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        QueueRoot root = new QueueRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String userid = parameter.getString("userid");
            String shopId = parameter.getString("shopid");
            String sessionid = parameter.getString("sessionid");
            String shopentityid = parameter.getString("shopentityid");
            String nums = parameter.getString("nums");
            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobe13"));
            if (!StringUtils.hasText(userid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_USERID_IS_NULL);
            }
            if (!StringUtils.hasText(sessionid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SESSIONID_IS_NULL);
            }
            if (!StringUtils.hasText(shopId))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SHOPID_IS_NULL);
            }
            if (!StringUtils.hasText(shopentityid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SHOPENTITYID_IS_NULL);
            }
            if (!StringUtils.hasText(nums))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_NUMS_IS_NULL);
            }
            root = this.consumeBillLinkInfoMobileService.userQueue(userid, sessionid, shopId, shopentityid, nums);
            root.setResult("true");
            root.setMsg("用餐排号成功");
        }
        catch (AlreadyArrangedException e)
        {//用户已经排过号
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_BILL_ALREADY_ARRANG;
            root.setMsg(ExceptionCache.get(err));
            root.setMsgcode(err);
        }
        catch (NotNeedArrangeException e)
        {//餐桌已够用无需排号
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_BILL_NOT_NEED_QUEUE;
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
