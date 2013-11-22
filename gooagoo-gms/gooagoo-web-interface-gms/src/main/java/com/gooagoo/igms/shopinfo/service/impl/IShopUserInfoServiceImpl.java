package com.gooagoo.igms.shopinfo.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.shop.user.ShopUserCoreService;
import com.gooagoo.api.generator.query.goods.GoodsBrandGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopEntityInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopUserInfoGeneratorQueryService;
import com.gooagoo.cache.SysdictionaryCache;
import com.gooagoo.common.cipher.Md5Utils;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.GMSConstant;
import com.gooagoo.common.gms.constants.MessageConst;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.gooagoo.entity.generator.goods.GoodsBrand;
import com.gooagoo.entity.generator.goods.GoodsBrandExample;
import com.gooagoo.entity.generator.shop.ShopEntityInfo;
import com.gooagoo.entity.generator.shop.ShopUserInfo;
import com.gooagoo.entity.generator.shop.ShopUserInfoExample;
import com.gooagoo.entity.generator.shop.ShopUserInfoExample.Criteria;
import com.gooagoo.igms.common.utils.GmsInterfaceUtil;
import com.gooagoo.igms.shopinfo.service.IShopUserInfoService;
import com.gooagoo.igms.shopinfo.service.ShopLoginService;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.shopinfo.BindRole;
import com.gooagoo.view.gms.shopinfo.FShopUserInfo;

@Service("ishopUserInfoService")
public class IShopUserInfoServiceImpl implements IShopUserInfoService
{
    @Autowired
    private ShopUserCoreService shopUserCoreService;
    @Autowired
    private ShopUserInfoGeneratorQueryService shopUserQueryService;
    @Autowired
    private ShopEntityInfoGeneratorQueryService shopEntityQueryService;
    @Autowired
    private GoodsBrandGeneratorQueryService brandQueryService;
    @Autowired
    private ShopLoginService shopLoginService;

    @Override
    public TransData<Object> addShopUserInfo(HttpServletRequest request) throws Exception
    {
        ShopUserInfo fShopUserInfo = ServletUtils.objectMethod(ShopUserInfo.class, request);

        fShopUserInfo.setShopId(GmsInterfaceUtil.getShopIdByInterface(request));
        fShopUserInfo.setIsDel("N");
        fShopUserInfo.setCreateTime(new Date());
        // TODO
        fShopUserInfo.setIsShopAccount("N");
        Md5Utils md5Utils = new Md5Utils();
        String encrypt = md5Utils.encrypt(fShopUserInfo.getPassword());//加密
        fShopUserInfo.setPassword(encrypt);
        boolean flag = this.shopUserCoreService.addShopUserInfo(fShopUserInfo);
        TransData<Object> r = GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL);
        r.setData(fShopUserInfo.getUserId());
        r.setOperateId(fShopUserInfo.getUserId());
        return r;
    }

    @Override
    public TransData<Object> updateShopUserInfo(HttpServletRequest request) throws Exception
    {
        ShopUserInfo fShopUserInfo = ServletUtils.objectMethod(ShopUserInfo.class, request);
        if (StringUtils.hasText(fShopUserInfo.getPassword()))
        {
            Md5Utils md5Utils = new Md5Utils();
            String encrypt = md5Utils.encrypt(fShopUserInfo.getPassword());//加密
            fShopUserInfo.setPassword(encrypt);
        }
        boolean flag = this.shopUserCoreService.updateShopUserInfo(fShopUserInfo);
        return GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, fShopUserInfo.getUserId());
    }

    @Override
    public TransData<Object> deleteShopUserInfo(HttpServletRequest request) throws Exception
    {
        String userId = ServletRequestUtils.getStringParameter(request, "userId", "");
        boolean flag = this.shopUserCoreService.deleteShopUserInfo(userId);
        return GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, userId);
    }

    @Override
    public TransData<FShopUserInfo> getShopUserInfo(HttpServletRequest request) throws Exception
    {
        String userId = ServletRequestUtils.getStringParameter(request, "userId", "");
        ShopUserInfo shopUserInfo = this.shopUserQueryService.selectByPrimaryKey(userId);
        FShopUserInfo fShopUserInfo = this.convertToFShopUserInfo(shopUserInfo);
        return GMSUtil.toTransData(true, null, fShopUserInfo);
    }

    @Override
    public TransData<PageModel<FShopUserInfo>> pageShopUserInfo(HttpServletRequest request) throws Exception
    {
        ShopLoginInfo gmsLoginInfo = this.shopLoginService.getShopLoginInfo(request);

        ShopUserInfoExample example = new ShopUserInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andShopIdEqualTo(gmsLoginInfo.getShopAndUserInfo().getShopId());
        if (StringUtils.hasText(gmsLoginInfo.getShopAndUserInfo().getUserShopEntityId()))
        {
            criteria.andShopEntityIdEqualTo(gmsLoginInfo.getShopAndUserInfo().getUserShopEntityId());
        }
        criteria.andIsDelEqualTo("N");
        criteria.andIsShopAccountNotEqualTo("Y");
        int count = this.shopUserQueryService.countByExample(example);
        int pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex", 1);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
        example.setPage(pageIndex, pageSize);
        example.setOrderByClause(" c_time_stamp desc ");

        List<ShopUserInfo> shopUserInfos = this.shopUserQueryService.selectByExample(example);
        List<FShopUserInfo> infos = new ArrayList<FShopUserInfo>();
        for (ShopUserInfo e : shopUserInfos)
        {
            FShopUserInfo info = this.convertToFShopUserInfo(e);

            infos.add(info);
        }

        PageModel<FShopUserInfo> pm = new PageModel<FShopUserInfo>();
        pm.setCount(count);
        pm.setPageIndex(pageIndex);
        pm.setPageSize(pageSize);
        pm.setResult(infos);
        return GMSUtil.toTransData(true, null, pm);
    }

    @Override
    public TransData<Object> bindRole(HttpServletRequest request) throws Exception
    {
        BindRole bindRole = ServletUtils.objectMethod(BindRole.class, request);
        boolean flag = this.shopUserCoreService.bindRoles(bindRole.getUserId(), bindRole.getRoleIds());
        return GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, bindRole.getUserId());
    }

    private FShopUserInfo convertToFShopUserInfo(ShopUserInfo shopUserInfo)
    {
        FShopUserInfo userInfo = null;
        if (shopUserInfo != null)
        {
            userInfo = new FShopUserInfo();
            BeanUtils.copyProperties(shopUserInfo, userInfo);
            if (StringUtils.hasText(userInfo.getShopEntityId()))
            {
                ShopEntityInfo shopEntityInfo = this.shopEntityQueryService.selectByPrimaryKey(userInfo.getShopEntityId());
                if (shopEntityInfo != null)
                {
                    userInfo.setShopEntityName(shopEntityInfo.getShopEntityName());
                }

                GoodsBrandExample exam = new GoodsBrandExample();
                com.gooagoo.entity.generator.goods.GoodsBrandExample.Criteria cri = exam.createCriteria();
                cri.andShopEntityIdEqualTo(userInfo.getShopEntityId());
                cri.andBrandIdEqualTo(userInfo.getBrand());
                cri.andIsDelEqualTo(GMSConstant.NO);

                List<GoodsBrand> list = this.brandQueryService.selectByExample(exam);
                if (list.size() > 0)
                {
                    userInfo.setBrandName(list.get(0).getBrandName());
                }
            }
            String idName = SysdictionaryCache.get("idtype", userInfo.getIdType());
            userInfo.setIdTypeCn(idName);
        }
        return userInfo;
    }
}
