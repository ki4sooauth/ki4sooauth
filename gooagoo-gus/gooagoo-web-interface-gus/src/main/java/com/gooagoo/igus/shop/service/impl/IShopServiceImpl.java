package com.gooagoo.igus.shop.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.member.usermember.AttentionCoreService;
import com.gooagoo.api.business.core.member.usermember.UserMemberCoreService;
import com.gooagoo.api.business.core.user.behave.UserLastTimeCoreService;
import com.gooagoo.api.business.query.member.query.UserMemberQueryService;
import com.gooagoo.api.business.query.shop.query.UserShopQueryService;
import com.gooagoo.api.business.query.system.cms.SysCmsContentQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.Constants;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.constants.MessageConst;
import com.gooagoo.common.gus.utils.FormatDataUtils;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.entity.business.member.MemberInfoBusiness;
import com.gooagoo.entity.business.shop.MyShopInfoBusiness;
import com.gooagoo.entity.generator.behave.UserLastTimeExample;
import com.gooagoo.entity.generator.member.ConvertApply;
import com.gooagoo.entity.generator.member.MemberApply;
import com.gooagoo.entity.generator.member.MemberBaseInfo;
import com.gooagoo.exception.business.user.UserAlreadyApplyException;
import com.gooagoo.exception.business.user.UserAlreadyShopMemberException;
import com.gooagoo.igus.shop.service.IShopService;
import com.gooagoo.igus.utils.BehaveAnnotation;
import com.gooagoo.igus.utils.MessageAnnotation;
import com.gooagoo.view.gus.web.shop.UMemberInfo;
import com.gooagoo.view.gus.web.shop.UShopList;

@Service("iShopService")
public class IShopServiceImpl implements IShopService
{

    @Autowired
    private UserMemberCoreService userMemberCoreService;

    @Autowired
    private AttentionCoreService attentionCoreService;

    @Autowired
    private UserShopQueryService userShopQueryService;

    @Autowired
    private UserMemberQueryService userMemberQueryService;

    @Autowired
    private SysCmsContentQueryService sysCmsContentQueryService;

    @Autowired
    private UserLastTimeCoreService userLastTimeCoreService;

    @Override
    @MessageAnnotation(InterGusConstants.SHOP_GETSHOPLIST)
    public TransData<Object> getShopList(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            String cardType2 = ServletRequestUtils.getStringParameter(request, "cardType");
            if (StringUtils.isBlank(cardType2))
            {
                cardType2 = null;
            }
            String orderByClause = ServletRequestUtils.getStringParameter(request, "orderBy");
            if (StringUtils.isBlank(orderByClause))
            {
                orderByClause = null;
            }
            String shopName = ServletRequestUtils.getStringParameter(request, "shopName");
            if (StringUtils.isBlank(shopName))
            {
                shopName = null;
            }
            String shopTypeRoot = ServletRequestUtils.getStringParameter(request, "shopType");
            if (StringUtils.isBlank(shopTypeRoot))
            {
                shopTypeRoot = null;
            }
            Integer pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex", 1);
            Integer pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 6);
            List<MyShopInfoBusiness> myShopInfoBusinessList = this.userShopQueryService.findMyShopList(userId, shopTypeRoot, shopName, cardType2, pageIndex, pageSize, orderByClause);
            if (CollectionUtils.isEmpty(myShopInfoBusinessList))
            {
                GooagooLog.info("获取商家列表:没有查到我的商家类表");
                return new TransData<Object>(true, MessageConst.SHOP_ISHOP_GETSHOPLIST_NOTEXIST, null);
            }
            List<UShopList> uShopList = new ArrayList<UShopList>();
            for (MyShopInfoBusiness myShopInfoBusiness : myShopInfoBusinessList)
            {
                try
                {
                    UShopList ushopList = new UShopList();
                    ushopList.setShopId(myShopInfoBusiness.getShopId());
                    ushopList.setShopName(myShopInfoBusiness.getShopName());
                    ushopList.setShopType(myShopInfoBusiness.getShopTypeRoot());
                    ushopList.setCardImg(FormatDataUtils.formatCardImageInfo(myShopInfoBusiness.getMyCardImageUrl()));
                    ushopList.setCardId(myShopInfoBusiness.getMyCardId());
                    ushopList.setCardType(myShopInfoBusiness.getMyCardType2());
                    ushopList.setCardName(myShopInfoBusiness.getMyCardName());
                    ushopList.setUseableIntegralNumber(myShopInfoBusiness.getMyUseableIntegralNumber());
                    try
                    {
                        ushopList.setPopularity(Integer.parseInt(myShopInfoBusiness.getShopPopularity()));
                    }
                    catch (Exception e)
                    {
                        ushopList.setPopularity(0);
                    }
                    try
                    {
                        ushopList.setShopUrl(this.sysCmsContentQueryService.getCmsContentUrl(myShopInfoBusiness.getShopId(), "W"));
                    }
                    catch (Exception e)
                    {
                        GooagooLog.error("获取商家列表：生成商家（" + myShopInfoBusiness.getShopId() + "）访问链接异常", e);
                    }
                    uShopList.add(ushopList);
                }
                catch (Exception e)
                {
                    GooagooLog.error("获取商家列表：组装单个商家信息异常", e);
                }
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, uShopList);
        }
        catch (Exception e)
        {
            GooagooLog.error("获取商家列表：获取会员商家异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }
        return transData;

    }

    @Override
    @BehaveAnnotation(InterGusConstants.SHOP_PHYCARDCONVERTAPPLY)
    public TransData<Object> phyCardConvertApply(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            ConvertApply convertApply = new ConvertApply();
            convertApply.setPhyNo(ServletRequestUtils.getStringParameter(request, "cardId"));
            convertApply.setIdNo(ServletRequestUtils.getStringParameter(request, "idNo"));
            convertApply.setMobile(ServletRequestUtils.getStringParameter(request, "mobile"));
            convertApply.setShopId(ServletRequestUtils.getStringParameter(request, "shopId"));
            convertApply.setSource("W");
            convertApply.setApplyTime(new Date());
            convertApply.setUserId(userId);
            if (!this.userMemberCoreService.applyConvertPhysicalCard(convertApply))
            {
                GooagooLog.info("物理卡转换申请：物理卡转换申请失败");
                return new TransData<Object>(false, MessageConst.SHOP_ISHOP_PHYCARDCONVERTAPPLY_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.SHOP_ISHOP_PHYCARDCONVERTAPPLY_SUCCESS, null);
        }
        catch (UserAlreadyApplyException e)
        {
            GooagooLog.error("物理卡转换申请：用户已申请异常", e);
            transData = new TransData<Object>(false, MessageConst.SHOP_ISHOP_PHYCARDCONVERTAPPLY_EXIST, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("物理卡转换申请：物理卡转换异常", e);
            transData = new TransData<Object>(false, MessageConst.SHOP_ISHOP_PHYCARDCONVERTAPPLY_FAIL, null);
        }
        return transData;
    }

    @Override
    @BehaveAnnotation(InterGusConstants.SHOP_ATTENTION)
    public TransData<Object> attention(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            String shopId = ServletRequestUtils.getStringParameter(request, "shopId");
            if (!this.attentionCoreService.addAttention(userId, shopId))
            {
                GooagooLog.info("关注商家：关注商家失败");
                return new TransData<Object>(false, MessageConst.CRYOUT_ICRYOUT_ATTENTION_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.CRYOUT_ICRYOUT_ATTENTION_SUCCESS, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("关注商家：加关注异常", e);
            transData = new TransData<Object>(false, MessageConst.CRYOUT_ICRYOUT_ATTENTION_FAIL, null);
        }
        return transData;
    }

    @Override
    @BehaveAnnotation(InterGusConstants.SHOP_MEMBERAPPLY)
    public TransData<Object> memberApply(HttpServletRequest request)
    {

        TransData<Object> transData = null;
        try
        {
            MemberApply memberApply = ServletUtils.objectMethod(MemberApply.class, request);
            if (StringUtils.isNotBlank(ServletRequestUtils.getStringParameter(request, "birthday")))
            {
                memberApply.setBirthday(TimeUtils.convertStringToDate(ServletRequestUtils.getStringParameter(request, "birthday")));
            }
            memberApply.setUserId(ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID));
            if (StringUtils.isNotBlank(memberApply.getIdNo()))
            {
                memberApply.setIdType("00");
            }
            memberApply.setSource("W");
            memberApply.setApplyTime(new Date());
            if (!this.userMemberCoreService.applyMember(memberApply))
            {
                GooagooLog.info("申请会员：申请会员失败");
                return new TransData<Object>(false, MessageConst.SHOP_ISHOP_MEMBERAPPLY_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.SHOP_ISHOP_MEMBERAPPLY_SUCCESS, null);
        }
        catch (UserAlreadyShopMemberException e)
        {
            GooagooLog.error("申请会员：用户已是商家会员异常", e);
            transData = new TransData<Object>(false, MessageConst.SHOP_ISHOP_MEMBERAPPLY_EXIST, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("申请会员：申请会员异常", e);
            transData = new TransData<Object>(false, MessageConst.SHOP_ISHOP_MEMBERAPPLY_FAIL, null);
        }
        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.SHOP_REMOVEATTENTION)
    public TransData<Object> removeAttention(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            String shopId = ServletRequestUtils.getStringParameter(request, "shopId");
            if (!this.attentionCoreService.deleteAttention(userId, shopId))
            {
                GooagooLog.info("取消关注：取消关注失败");
                return new TransData<Object>(false, MessageConst.SHOP_ISHOP_REMOVEATTENTION_FAIL, null);
            }
            try
            {
                UserLastTimeExample userLastTimeExample = new UserLastTimeExample();
                userLastTimeExample.createCriteria().andUserIdEqualTo(userId).andShopIdEqualTo(shopId).andCardType2EqualTo("0");
                if (!this.userLastTimeCoreService.physicalDeleteByExample(userLastTimeExample))
                {
                    GooagooLog.info("取消关注：删除user_last_time表相关数据失败");
                }
            }
            catch (Exception e)
            {
                GooagooLog.error("取消关注：删除user_last_time表相关数据异常", e);
            }
            transData = new TransData<Object>(true, MessageConst.SHOP_ISHOP_REMOVEATTENTION_SUCCESS, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("取消关注：取消关注异常", e);
            transData = new TransData<Object>(false, MessageConst.SHOP_ISHOP_REMOVEATTENTION_FAIL, null);
        }
        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.SHOP_REMOVEMEMBER)
    public TransData<Object> removeMember(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            String shopId = ServletRequestUtils.getStringParameter(request, "shopId");
            if (!this.userMemberCoreService.deleteMember(null, userId, shopId))
            {
                GooagooLog.info("删除会员：删除会员失败");
                return new TransData<Object>(false, MessageConst.SHOP_ISHOP_REMOVEMEMBER_FAIL, null);
            }
            try
            {
                UserLastTimeExample userLastTimeExample = new UserLastTimeExample();
                userLastTimeExample.createCriteria().andUserIdEqualTo(userId).andShopIdEqualTo(shopId).andCardType2NotEqualTo("0");
                if (!this.userLastTimeCoreService.physicalDeleteByExample(userLastTimeExample))
                {
                    GooagooLog.info("删除会员：删除user_last_time表相关数据失败");
                }
            }
            catch (Exception e)
            {
                GooagooLog.error("删除会员：删除user_last_time表相关数据异常", e);
            }
            transData = new TransData<Object>(true, MessageConst.SHOP_ISHOP_REMOVEMEMBER_SUCCESS, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("删除会员：删除会员异常", e);
            transData = new TransData<Object>(false, MessageConst.SHOP_ISHOP_REMOVEMEMBER_FAIL, null);
        }
        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.SHOP_GETMEMBERBASEINFO)
    public TransData<Object> getMemberBaseInfo(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String scardno = ServletRequestUtils.getStringParameter(request, "cardId");
            String shopId = ServletRequestUtils.getStringParameter(request, "shopId");
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            MemberInfoBusiness memberBaseInfo = this.userMemberQueryService.findMemberInfo(userId, shopId, scardno);
            if (memberBaseInfo == null)
            {
                return new TransData<Object>(true, MessageConst.SHOP_ISHOP_GETMEMBERBASEINFO_FAIL, null);
            }
            UMemberInfo uMemberInfo = new UMemberInfo();
            uMemberInfo.setName(memberBaseInfo.getName());
            uMemberInfo.setAddress(memberBaseInfo.getAddress());
            uMemberInfo.setBirthday(memberBaseInfo.getBirthday());
            uMemberInfo.setIdNo(memberBaseInfo.getIdno());
            uMemberInfo.setSex(memberBaseInfo.getSex());
            uMemberInfo.setMobile(memberBaseInfo.getMobile());
            transData = new TransData<Object>(true, MessageConst.SHOP_ISHOP_GETMEMNERBASEINFO_SUCCESS, uMemberInfo);
        }
        catch (Exception e)
        {
            GooagooLog.error("查询会员信息（做修改操作）：查询会员信息失败", e);
            transData = new TransData<Object>(false, MessageConst.SHOP_ISHOP_GETMEMNERBASEINFO_FAIL, null);
        }
        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.SHOP_UPDATEMEMBERBASEINFO)
    public TransData<Object> updateMemberBaseInfo(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            MemberBaseInfo memberBaseInfo = ServletUtils.objectMethod(MemberBaseInfo.class, request);
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            if (StringUtils.isNotBlank(memberBaseInfo.getIdNo()))
            {
                memberBaseInfo.setIdType("00");
            }
            if (!this.userMemberCoreService.updateMemberInfo(userId, memberBaseInfo, null))
            {
                GooagooLog.info("修改会员信息：修改会员信息失败（" + memberBaseInfo.toString() + "）");
                return new TransData<Object>(false, MessageConst.SHOP_ISHOP_UPDATEMEMBERBASEINFO_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.SHOP_ISHOP_UPDATEMEMBERBASEINFO_SUCCESS, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("修改会员信息：修改失败", e);
            transData = new TransData<Object>(false, MessageConst.SHOP_ISHOP_UPDATEMEMBERBASEINFO_FAIL, null);
        }
        return transData;
    }

}
