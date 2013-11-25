package com.gooagoo.mobile.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.exception.common.OperateFailException;
import com.gooagoo.mobile.api.ShoppingPlanMobileService;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.mobd07.transform.UserShoppingPlanBTBRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/**
 * 接口MODB07:计划列表与服务器同步（批量，步骤2） 
 */
@Service("mobd07")
public class MOBD07ServiceImpl implements ImobileService
{

    @Autowired
    private ShoppingPlanMobileService shoppingPlanMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        UserShoppingPlanBTBRoot root = new UserShoppingPlanBTBRoot();
        root.setResult("false");
        try
        {
            //获取传入参数,做非空校验
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String userid = parameter.getString("userid");
            String sessionid = parameter.getString("sessionid");
            String usershoppingplan = parameter.getString("usershoppingplan");

            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobd07"));

            if (!StringUtils.hasText(userid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_USERID_IS_NULL);
            }
            if (!StringUtils.hasText(sessionid))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_SESSIONID_IS_NULL);
            }
            if (!StringUtils.hasText(usershoppingplan))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_USERSHOPPINGPLAN_IS_NULL);
            }

            root = this.shoppingPlanMobileService.shoppingPlanSynStepB(userid, sessionid, usershoppingplan);
            root.setResult("true");
            root.setMsg("计划列表与服务器同步成功");
        }
        catch (OperateFailException e)
        {
            //同步更新购物清单主表异常
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.MOBILE_SHOPPINGPLAN_SYN_INFO_FAIL;
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