package com.gooagoo.igms.shopinfo.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.shop.shopentity.ShopEntityLinkCoreService;
import com.gooagoo.api.business.core.shop.shopentity.ShopGpsInfoCoreService;
import com.gooagoo.api.business.core.shop.shopentity.ShopInvoiceInfoCoreService;
import com.gooagoo.api.business.core.shop.shopentity.ShopentityCoreService;
import com.gooagoo.api.generator.query.shop.ShopEntityInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopEntityLinkGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopGpsInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopInvoiceInfoGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.GMSConstant;
import com.gooagoo.common.gms.constants.MessageConst;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.StringUtils;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.gooagoo.entity.generator.shop.ShopEntityInfo;
import com.gooagoo.entity.generator.shop.ShopEntityInfoExample;
import com.gooagoo.entity.generator.shop.ShopEntityInfoExample.Criteria;
import com.gooagoo.entity.generator.shop.ShopEntityLink;
import com.gooagoo.entity.generator.shop.ShopGpsInfo;
import com.gooagoo.entity.generator.shop.ShopInvoiceInfo;
import com.gooagoo.igms.common.utils.GmsInterfaceUtil;
import com.gooagoo.igms.shopinfo.service.IShopEntityService;
import com.gooagoo.igms.shopinfo.service.ShopLoginService;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.shopinfo.FShopEntityInfo;
import com.gooagoo.view.gms.shopinfo.FShopInvoiceInfo;
import com.google.gson.Gson;

@Service("ishopEntityService")
public class IShopEntityServiceImpl implements IShopEntityService
{
    @Autowired
    private ShopentityCoreService shopEntityCoreService;
    @Autowired
    private ShopEntityInfoGeneratorQueryService shopEntityQueryService;
    @Autowired
    private ShopGpsInfoCoreService gpsInfoCoreService;
    @Autowired
    private ShopInvoiceInfoCoreService invoiceInfoCoreService;
    @Autowired
    private ShopInvoiceInfoGeneratorQueryService invoiceQueryService;
    @Autowired
    private ShopEntityLinkCoreService shopLinkCoreService;
    @Autowired
    private ShopLoginService shopLoginService;
    @Autowired
    private ShopGpsInfoGeneratorQueryService shopGpsInfoGeneratorQueryService;
    @Autowired
    private ShopEntityLinkGeneratorQueryService shopEntityLinkGeneratorQueryService;

    @Override
    public TransData<Object> addEntity(HttpServletRequest request) throws Exception
    {
        ShopLoginInfo shopInfo = this.shopLoginService.getShopLoginInfo(request);
        ShopEntityInfo shopEntityInfo = ServletUtils.objectMethod(ShopEntityInfo.class, request);
        
        //校验实体店数量，非链锁店只能新建一家实体店
        if(this.checkEntityNum(shopInfo)){
        	return GMSUtil.getBooleanResult(false, null, MessageConst.GMS_SHOPINFO_NOT_CHAIN_SHOP_ONLY_HAVE_ONE_ENTITY);
        }
        if (!this.isGeneral(request, shopEntityInfo))
        {
            return GMSUtil.getBooleanResult(false, null, MessageConst.GMS_SHOPINFO_NOT_UNIQUE_GENERAL_ENTITY);
        }
        if(isUniqueEntityName(shopEntityInfo.getShopEntityName(),shopInfo.getShopAndUserInfo().getShopId(),null)){
            return GMSUtil.getBooleanResult(false, null, MessageConst.GMS_SHOPINFO_ENTITYNAME_ALREADY_EXIST);
        }
        String shopEntityId = StringUtils.getUUID();
        shopEntityInfo.setShopEntityId(shopEntityId);
        shopEntityInfo.setIsDel("N");
        shopEntityInfo.setCreateTime(new Date());
        shopEntityInfo.setShopId(shopInfo.getShopAndUserInfo().getShopId());

        boolean flag = this.shopEntityCoreService.addShopEntityInfo(shopEntityInfo);

        TransData<Object> r = GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL);
        r.setOperateId(shopEntityId);
        r.setData(shopEntityId);
        return r;
    }

    private boolean checkEntityNum(ShopLoginInfo shopInfo) {
    	 boolean flag = false;
    	 if("N".equals(shopInfo.getShopAndUserInfo().getShopIsChain())){
    		 ShopEntityInfoExample example = new ShopEntityInfoExample();
             Criteria criteria = example.createCriteria();
             criteria.andShopIdEqualTo(shopInfo.getShopAndUserInfo().getShopId()).andIsDelEqualTo("N");
             Integer count = this.shopEntityQueryService.countByExample(example); 
             flag = count>0;
    	 }   
		 return flag;
	}

	/**
     * 检查是否有总店
     * @param shopInfo
     * @param shopEntityInfo
     * @return
     * @throws Exception
     */
    private boolean isGeneral(HttpServletRequest request, ShopEntityInfo shopEntityInfo) throws Exception
    {
        ShopEntityInfoExample example = new ShopEntityInfoExample();
        Criteria criteria = example.createCriteria();
        String entityId= shopEntityInfo.getShopEntityId();
        criteria.andShopIdEqualTo(GmsInterfaceUtil.getShopIdByInterface(request)).andIsDelEqualTo("N");
        if(org.springframework.util.StringUtils.hasText(entityId)){
        	criteria.andShopEntityIdNotEqualTo(entityId);
        }
        criteria.andIsGeneralEqualTo("Y");
        Integer count = this.shopEntityQueryService.countByExample(example);
        if (count > 0 && shopEntityInfo.getIsGeneral().equals("Y"))
        {
        	GooagooLog.warn("校验是否有总店时，总店己存在！");
            return false;
        }
        return true;
    }

    @Override
    public TransData<Object> updateEntity(HttpServletRequest request) throws Exception
    {
        ShopEntityInfo shopEntityInfo = ServletUtils.objectMethod(ShopEntityInfo.class, request);
        if (!this.isGeneral(request, shopEntityInfo))
        {
            return GMSUtil.getBooleanResult(false, null, MessageConst.GMS_SHOPINFO_NOT_UNIQUE_GENERAL_ENTITY);
        }
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);
        if(isUniqueEntityName(shopEntityInfo.getShopEntityName(),shopId,shopEntityInfo.getShopEntityId())){
            return GMSUtil.getBooleanResult(false, null, MessageConst.GMS_SHOPINFO_ENTITYNAME_ALREADY_EXIST);
        }
        boolean flag = this.shopEntityCoreService.updateShopEntityInfo(shopEntityInfo);
        return GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, shopEntityInfo.getShopEntityId());
    }

    @Override
    public TransData<Object> deleteEntity(HttpServletRequest request) throws Exception
    {
        String shopEntityId = ServletRequestUtils.getStringParameter(request, "shopEntityId", "");
        boolean flag = this.shopEntityCoreService.deleteShopEntityInfo(shopEntityId);
        return GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, shopEntityId);
    }

    @Override
    public TransData<FShopEntityInfo> getEntity(HttpServletRequest request) throws Exception
    {
        String shopEntityId = ServletRequestUtils.getStringParameter(request, "shopEntityId", "");
        ShopEntityInfo shopEntityInfo = this.shopEntityQueryService.selectByPrimaryKey(shopEntityId);
        FShopEntityInfo entityInfo = new FShopEntityInfo();
        BeanUtils.copyProperties(shopEntityInfo, entityInfo);
        ShopGpsInfo shopGpsInfo = this.shopGpsInfoGeneratorQueryService.selectUnDelByPrimaryKey(shopEntityInfo.getShopEntityId());
        if (shopGpsInfo != null)
        {
            entityInfo.setShopGpsBaidux(shopGpsInfo.getShopGpsBaidux());
            entityInfo.setShopGpsBaiduy(shopGpsInfo.getShopGpsBaiduy());
            entityInfo.setShopGpsGooglex(shopGpsInfo.getShopGpsGoogley());
            entityInfo.setShopGpsGoogley(shopGpsInfo.getShopGpsGoogley());
        }
        ShopEntityLink shopEntityLink = this.shopEntityLinkGeneratorQueryService.selectUnDelByPrimaryKey(shopEntityInfo.getShopEntityId());
        if (shopEntityLink != null)
        {
            entityInfo.setMobile(shopEntityLink.getMobile());
            entityInfo.setAddress(shopEntityLink.getAddress());
            entityInfo.setArea(shopEntityLink.getArea());
            entityInfo.setCity(shopEntityLink.getCity());
            entityInfo.setMobile(shopEntityLink.getMobile());
            entityInfo.setPhone(shopEntityLink.getPhone());
            entityInfo.setPostCode(shopEntityLink.getPostCode());
            entityInfo.setProvince(shopEntityLink.getProvince());
        }
        return GMSUtil.toTransData(true, null, entityInfo);
    }

    @Override
    public TransData<PageModel<FShopEntityInfo>> pageEntity(HttpServletRequest request) throws Exception
    {
        ShopLoginInfo shopInfo = this.shopLoginService.getShopLoginInfo(request);
        ShopEntityInfoExample example = new ShopEntityInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andShopIdEqualTo(shopInfo.getShopAndUserInfo().getShopId());
        if (shopInfo.getShopAndUserInfo().getUserIsShopAccount().equals("N"))
        {
            criteria.andShopEntityIdEqualTo(shopInfo.getShopAndUserInfo().getUserShopEntityId());
        }
        criteria.andIsDelEqualTo(GMSConstant.NO);

        int count = this.shopEntityQueryService.countByExample(example);

        int pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex", 1);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);

        example.setPage(pageIndex, pageSize);
        example.setOrderByClause(" c_time_stamp desc ");
        List<ShopEntityInfo> list = this.shopEntityQueryService.selectByExample(example);

        List<FShopEntityInfo> infos = new ArrayList<FShopEntityInfo>();
        for (ShopEntityInfo e : list)
        {
            FShopEntityInfo info = new FShopEntityInfo();
            BeanUtils.copyProperties(e, info);
            infos.add(info);
        }

        PageModel<FShopEntityInfo> pm = new PageModel<FShopEntityInfo>();
        pm.setCount(count);
        pm.setPageIndex(pageIndex);
        pm.setPageSize(pageSize);
        pm.setResult(infos);

        return GMSUtil.toTransData(true, null, pm);
    }

    @Override
    public TransData<Object> updateShopLink(HttpServletRequest request) throws Exception
    {
        ShopEntityLink entityLink = ServletUtils.objectMethod(ShopEntityLink.class, request);
        ShopLoginInfo shopInfo = this.shopLoginService.getShopLoginInfo(request);
        entityLink.setShopId(shopInfo.getShopAndUserInfo().getShopId());
        boolean flag = this.shopLinkCoreService.updateShopEntityLink(entityLink);
        return GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, shopInfo.getShopAndUserInfo().getShopId());
    }

    @Override
    public TransData<Object> updateGPSInfo(HttpServletRequest request) throws Exception
    {
        ShopGpsInfo fgpsInfo = ServletUtils.objectMethod(ShopGpsInfo.class, request);
        ShopLoginInfo shopInfo = this.shopLoginService.getShopLoginInfo(request);
        fgpsInfo.setShopId(shopInfo.getShopAndUserInfo().getShopId());
        fgpsInfo.setCreateTime(new Date());
        fgpsInfo.setIsDel(GMSConstant.NO);
        fgpsInfo.setNote("");
        boolean flag = this.gpsInfoCoreService.updateShopGpsInfo(fgpsInfo);
        return GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, shopInfo.getShopAndUserInfo().getShopId());
    }

    @Override
    public TransData<Object> addShopLink(HttpServletRequest request) throws Exception
    {
        ShopEntityLink entityLink = ServletUtils.objectMethod(ShopEntityLink.class, request);
        ShopLoginInfo shopInfo = this.shopLoginService.getShopLoginInfo(request);
        entityLink.setShopId(shopInfo.getShopAndUserInfo().getShopId());
        entityLink.setIsDel("N");
        entityLink.setCreateTime(new Date());
        boolean flag = this.shopLinkCoreService.updateShopEntityLink(entityLink);
        return GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, shopInfo.getShopAndUserInfo().getShopId());
    }

    @Override
    public TransData<Object> addGPSInfo(HttpServletRequest request) throws Exception
    {
        ShopGpsInfo fgpsInfo = ServletUtils.objectMethod(ShopGpsInfo.class, request);
        ShopLoginInfo shopInfo = this.shopLoginService.getShopLoginInfo(request);
        fgpsInfo.setShopId(shopInfo.getShopAndUserInfo().getShopId());
        fgpsInfo.setIsDel("N");
        fgpsInfo.setCreateTime(new Date());
        boolean flag = this.gpsInfoCoreService.updateShopGpsInfo(fgpsInfo);
        return GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, shopInfo.getShopAndUserInfo().getShopId());
    }

    @SuppressWarnings("unchecked")
    @Override
    public TransData<Object> addShopInvoiceInfo(HttpServletRequest request) throws Exception
    {
        ShopInvoiceInfo invoiceInfo = ServletUtils.objectMethod(ShopInvoiceInfo.class, request);
        String invoiceType = ServletRequestUtils.getStringParameter(request, "invoiceType", "");
        String invNames = ServletRequestUtils.getStringParameter(request, "invNames", "");
        String[] strings = invNames.split(",");

        List<String> lists1 = new Gson().fromJson(new Gson().toJson(strings), List.class);
        List<String> stringList = new ArrayList<String>();
        for (String string : lists1)
        {
            if (org.springframework.util.StringUtils.hasText(string))
            {
                stringList.add(string);
            }
        }
        String json = new Gson().toJson(stringList, List.class);
        invoiceInfo.setIsDel("N");
        invoiceInfo.setCreateTime(new Date());
        ShopInvoiceInfo info = this.invoiceQueryService.selectByPrimaryKey(invoiceInfo.getShopEntityId());
        if (invoiceType.equals("1"))
        {
            invoiceInfo.setName1(json);
            invoiceInfo.setName2(info.getName2());
        }
        else
        {
            invoiceInfo.setName2(json);
            invoiceInfo.setName1(info.getName1());
        }
        invoiceInfo.setShopEntityId(invoiceInfo.getShopEntityId());
        boolean flag = this.invoiceInfoCoreService.upateShopInvoiceInfo(invoiceInfo);
        return GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, invoiceInfo.getShopEntityId());
    }

    @Override
    public TransData<Object> delShopInvoiceInfo(HttpServletRequest request) throws Exception
    {
        ShopInvoiceInfo fgpsInfo = ServletUtils.objectMethod(ShopInvoiceInfo.class, request);
        boolean flag = this.invoiceInfoCoreService.upateShopInvoiceInfo(fgpsInfo);
        return GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, fgpsInfo.getShopEntityId());
    }

    @Override
    public TransData<List<FShopInvoiceInfo>> ListShopInvoiceInfo(HttpServletRequest request) throws Exception
    {
        String shopEntityId = ServletRequestUtils.getStringParameter(request, "shopEntityId", "");
        ShopLoginInfo shopInfo = this.shopLoginService.getShopLoginInfo(request);
        if (shopInfo.getShopAndUserInfo().getUserIsShopAccount().equals("N"))
        {
            shopEntityId = shopInfo.getShopAndUserInfo().getUserShopEntityId();
        }
        if (shopEntityId.isEmpty())
        {
            return GMSUtil.toTransData(false, "", null);
        }
        ShopInvoiceInfo invoiceInfo = this.invoiceQueryService.selectByPrimaryKey(shopEntityId);
        if (invoiceInfo == null)
        {
            return GMSUtil.toTransData(false, "", null);
        }
        else
        {
            List<FShopInvoiceInfo> invoiceInfosList = new ArrayList<FShopInvoiceInfo>();
            Gson gson = new Gson();
            List<String> n1 = gson.fromJson(invoiceInfo.getName1(), List.class);
            for (String e : n1)
            {
                FShopInvoiceInfo info = new FShopInvoiceInfo();
                info.setInvoiceName(e);
                info.setInvoiceType("1");
                info.setShopEntityId(shopEntityId);
                invoiceInfosList.add(info);
            }
            List<String> n2 = gson.fromJson(invoiceInfo.getName2(), List.class);
            for (String e : n2)
            {
                FShopInvoiceInfo info = new FShopInvoiceInfo();
                info.setInvoiceName(e);
                info.setInvoiceType("2");
                info.setShopEntityId(shopEntityId);
                invoiceInfosList.add(info);
            }
            return GMSUtil.toTransData(true, "", invoiceInfosList);
        }
    }
    
    
    
    private boolean isUniqueEntityName(String shopEntityName,String shopId,String entityId){
    	ShopEntityInfoExample shopEntityInfoExample = new ShopEntityInfoExample();
    	Criteria createCriteria = shopEntityInfoExample.createCriteria();
    	createCriteria.andIsDelEqualTo(GMSConstant.NO);
		createCriteria.andShopIdEqualTo(shopId).andShopEntityNameEqualTo(shopEntityName);
		if(org.springframework.util.StringUtils.hasText(entityId)){
			createCriteria.andShopEntityIdNotEqualTo(entityId);
		}
    	
    	Integer count = this.shopEntityQueryService.countByExample(shopEntityInfoExample);
    	return  count>0;
    	
    	
    	
    }

}
