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
import com.gooagoo.mobile.entity.mobe14.transform.GoodsSequenceRoot;
import com.gooagoo.mobile.entity.transdata.MobileTransData;
import com.gooagoo.mobile.service.ImobileService;

/**
 * 接口MOBE11:用户评论商品接口
 */
@Service("mobe14")
public class MOBE14ServiceImpl implements ImobileService
{

    @Autowired
    private ConsumeBillLinkInfoMobileService consumeBillLinkInfoMobileService;

    @Override
    public String doImobile(HttpServletRequest request) throws Exception
    {
        GoodsSequenceRoot root = new GoodsSequenceRoot();
        root.setResult("false");
        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String userid = parameter.getString("userid");
            String sessionid = parameter.getString("sessionid");
            String shopid = parameter.getString("shopid");
            String pageIndex = parameter.getString("pageindex");
            String pageSize = parameter.getString("pagesize");
            String keyWord = parameter.getString("keyword");
            String goodsCategoryLeaf = parameter.getString("goodscategoryleaf");

            //打印log
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "mobe14"));

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
            if (!StringUtils.hasText(pageIndex))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_PAGEINDEX_IS_NULL);
            }
            if (!StringUtils.hasText(pageSize))
            {
                throw new MessageException(MessageConst.MOBILE_PARAMETER_PAGESIZE_IS_NULL);
            }

            root = this.consumeBillLinkInfoMobileService.getGoodsSequenceInfo(userid, sessionid, shopid, keyWord, goodsCategoryLeaf, pageIndex, pageSize);
            root.setResult("true");
            root.setMsg("查询品类销售排行成功");
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
