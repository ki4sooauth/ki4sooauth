package com.gooagoo.igms.shopinfo.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.shop.shopinfo.ShopInfoCoreService;
import com.gooagoo.api.generator.query.shop.ShopEntityInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopInfoGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.MessageConst;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.gooagoo.entity.generator.shop.ShopEntityInfoExample;
import com.gooagoo.entity.generator.shop.ShopInfo;
import com.gooagoo.entity.generator.shop.ShopEntityInfoExample.Criteria;
import com.gooagoo.igms.common.utils.GmsInterfaceUtil;
import com.gooagoo.igms.shopinfo.service.IShopInfoService;
import com.gooagoo.igms.shopinfo.service.ShopLoginService;
import com.gooagoo.view.gms.shopinfo.FShopInfo;

@Service("ishopInfoService")
public class IShopInfoServiceImpl implements IShopInfoService
{
    @Autowired
    private ShopInfoGeneratorQueryService shopInfoQueryService;
    @Autowired
    private ShopInfoCoreService shopInfoCoreService;
    @Autowired
    private ShopLoginService shopLoginService;
    @Autowired
    private ShopEntityInfoGeneratorQueryService shopEntityInfoGeneratorQueryService;

    @Override
    public TransData<FShopInfo> getShopInfo(HttpServletRequest request) throws Exception
    {
        ShopInfo shopInfo = this.shopInfoQueryService.selectByPrimaryKey(GmsInterfaceUtil.getShopIdByInterface(request));
        FShopInfo fShopInfo = new FShopInfo();
        BeanUtils.copyProperties(shopInfo, fShopInfo);
        return GMSUtil.toTransData(true, null, fShopInfo);
    }

    @Override
    public TransData<Object> updateShopInfo(HttpServletRequest request) throws Exception
    {
        String nickName = ServletRequestUtils.getStringParameter(request, "nickName", "");
        boolean flag = this.shopInfoCoreService.updateShopInfo(GmsInterfaceUtil.getShopIdByInterface(request), nickName, GmsInterfaceUtil.getShopLoginTokenByInterface(request));
        return GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, GmsInterfaceUtil.getShopIdByInterface(request));
    }

    @Override
    public TransData<ShopLoginInfo> getLoginInfo(HttpServletRequest request) throws Exception
    {
        ShopLoginInfo shopLoginInfo = this.shopLoginService.getShopLoginInfo(request);

        return new TransData<ShopLoginInfo>(true, null, shopLoginInfo);
    }

    @Override
    public TransData<Object> updateNormalBusiness(HttpServletRequest request) throws Exception
    {
        boolean bool = this.shopInfoCoreService.normalBusiness(GmsInterfaceUtil.getShopIdByInterface(request));
        return GMSUtil.getBooleanResult(bool, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, GmsInterfaceUtil.getShopIdByInterface(request));
    }

    @Override
    public TransData<Object> updateShopInfos(HttpServletRequest request) throws Exception
    {
        FShopInfo shopInfo = ServletUtils.objectMethod(FShopInfo.class, request);
        //校验实体店数量，非链锁店只能新建一家实体店
        if(this.checkEntityNum(shopInfo)){
        	return GMSUtil.getBooleanResult(false, null, MessageConst.GMS_SHOPINFO_HAVE_MANY_ENTITY_CANNOT_UPDATE_IS_CHAIN_AS_N);
        }
        ShopInfo info = new ShopInfo();
        BeanUtils.copyProperties(shopInfo, info);
        boolean flag = this.shopInfoCoreService.updateShopBaseInfo(GmsInterfaceUtil.getShopLoginTokenByInterface(request),info);
        return GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, info.getShopId());
    }
    
    
    private boolean checkEntityNum(FShopInfo shopInfo) {
   	 boolean flag = false;
   	 if("N".equals(shopInfo.getIsChain())){
   		 ShopEntityInfoExample example = new ShopEntityInfoExample();
            Criteria criteria = example.createCriteria();
            criteria.andShopIdEqualTo(shopInfo.getShopId()).andIsDelEqualTo("N");
            Integer count = this.shopEntityInfoGeneratorQueryService.countByExample(example); 
            flag = count>1;
   	 }   
		 return flag;
	}
    
}
