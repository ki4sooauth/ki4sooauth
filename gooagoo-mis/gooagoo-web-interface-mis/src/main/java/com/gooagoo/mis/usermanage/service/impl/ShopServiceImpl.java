package com.gooagoo.mis.usermanage.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.system.user.enterprise.MerchantStatusCoreService;
import com.gooagoo.api.generator.query.shop.DeviceTransponderGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopEntityInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopEntityLinkGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopGpsInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopLidInfoGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.generator.shop.DeviceTransponder;
import com.gooagoo.entity.generator.shop.DeviceTransponderExample;
import com.gooagoo.entity.generator.shop.ShopEntityInfo;
import com.gooagoo.entity.generator.shop.ShopEntityInfoExample;
import com.gooagoo.entity.generator.shop.ShopEntityLink;
import com.gooagoo.entity.generator.shop.ShopEntityLinkExample;
import com.gooagoo.entity.generator.shop.ShopGpsInfo;
import com.gooagoo.entity.generator.shop.ShopGpsInfoExample;
import com.gooagoo.entity.generator.shop.ShopInfo;
import com.gooagoo.entity.generator.shop.ShopInfoExample;
import com.gooagoo.entity.generator.shop.ShopInfoExample.Criteria;
import com.gooagoo.entity.generator.shop.ShopLidInfo;
import com.gooagoo.entity.generator.shop.ShopLidInfoExample;
import com.gooagoo.exception.GooagooException;
import com.gooagoo.mis.constants.MisMessageConst;
import com.gooagoo.mis.usermanage.service.ShopService;
import com.gooagoo.mis.util.UtilsMis;
import com.gooagoo.view.general.PageCondition;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.enterprise.MShopEntityInfo;
import com.gooagoo.view.mis.enterprise.MShopInfo;
import com.gooagoo.view.mis.enterprise.MShopLidInfo;

@Service(value = "shopService")
public class ShopServiceImpl implements ShopService
{

    @Autowired
    private ShopInfoGeneratorQueryService shopInfoGeneratorQueryService;
    @Autowired
    private MerchantStatusCoreService merchantStatusCoreService;
    @Autowired
    private ShopLidInfoGeneratorQueryService shopLidInfoGeneratorQueryService;
    @Autowired
    private ShopEntityInfoGeneratorQueryService shopEntityInfoGeneratorQueryService;
    @Autowired
    private ShopEntityLinkGeneratorQueryService shopEntityLinkGeneratorQueryService;
    @Autowired
    private ShopGpsInfoGeneratorQueryService shopGpsInfoGeneratorQueryService;
    @Autowired
    private DeviceTransponderGeneratorQueryService deviceTransponderGeneratorQueryService;

    /**
     * 审核商家
     */
    @Override
    public TransData<Object> verify(HttpServletRequest request) throws Exception
    {
        String shopId = request.getParameter("shopId");
        if (shopId != null)
        {
            //1.验证实体店基本信息
            if (this.checkShopEntityInfo(shopId) == null)
            {
                return new TransData<Object>(false, MisMessageConst.GMS_SHOPINFO_ENTITY_PLEASE_PERFECT_BASE, null);
            }
            //2.验证有且只有一个主实体店
            if (this.checkShopEntityInfoUniqueness(shopId))
            {
                return new TransData<Object>(false, MisMessageConst.GMS_SHOPINFO_ENTITY_PLEASE_PERFECT_ENTITYINFO, null);
            }
            //2.验证实体店联系方式
            List<ShopEntityInfo> shopEntityInfos = this.checkShopEntityInfo(shopId);
            if (!this.checkShopEntityLink(shopEntityInfos))
            {
                return new TransData<Object>(false, MisMessageConst.GMS_SHOPINFO_ENTITY_PLEASE_PERFECT_LINKWAY, null);
            }
            //3.验证实体店GPS信息
            if (!this.checkShopGapInfo(shopEntityInfos))
            {
                return new TransData<Object>(false, MisMessageConst.GMS_SHOPINFO_ENTITY_PLEASE_PERFECT_GPS, null);
            }
            //4.验证实体店Lid信息
            if (!this.checkShopLidInfo(shopEntityInfos))
            {
                return new TransData<Object>(false, MisMessageConst.GMS_SHOPINFO_ENTITY_PLEASE_PERFECT_LID, null);
            }
            //5.商家转发器验证
            if (!this.checkTranspcInfo(shopEntityInfos))
            {
                return new TransData<Object>(false, MisMessageConst.GMS_SHOPINFO_ENTITY_PLEASE_PERFECT_TRANS, null);
            }
            //6.验证通过商家状态由 L-锁定，改为P-待营业
            ShopInfo shopInfo = null;
            shopInfo = this.shopInfoGeneratorQueryService.selectUnDelByPrimaryKey(shopId);
            if (!"L".equals(shopInfo.getShopStatus()))
            {
                return new TransData<Object>(false, MisMessageConst.MIS_USERMANA_ENTERPRISE_ONLY_LOCK_STATUS_CAN_CHECK, null);
            }
            else
            {
                if ("L".equals(shopInfo.getShopStatus()))
                {
                    shopInfo.setShopStatus("P");
                    boolean flag = this.merchantStatusCoreService.updateMerchantStatus(shopId, shopInfo.getShopStatus(), "");
                    if (!flag)
                    {
                        return new TransData<Object>(false, MisMessageConst.MIS_USERMANA_ENTERPRISE_CHECK_FAIL, null);
                    }
                }
                else
                {
                    return new TransData<Object>(false, MisMessageConst.MIS_USERMANA_ENTERPRISE_ONLY_LOCK_STATUS_CAN_CHECK, null);
                }
            }
        }
        else
        {
            return new TransData<Object>(false, MisMessageConst.MIS_USERMANA_ENTERPRISE_CHECK_FAIL, null);
        }
        return new TransData<Object>(true, MisMessageConst.MIS_USERMANA_ENTERPRISE_CHECK_SUCCESS, null);
    }

    /**
     * 锁定商家
     */
    @SuppressWarnings("null")
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> lock(HttpServletRequest request) throws Exception
    {
        String userIds = ServletRequestUtils.getStringParameter(request, "id", "");//商家Id
        String[] arrId = userIds.split(",");
        for (String string : arrId)
        {
            ShopInfo shopInfo = this.shopInfoGeneratorQueryService.selectUnDelByPrimaryKey(string);
            if (shopInfo != null)
            {
                //只有正常营业商家才可以进行锁定L-锁定，P-待营业，U-正常营业
                if ("U".equals(shopInfo.getShopStatus()))
                {
                    shopInfo.setShopStatus("L");
                    boolean flag = this.merchantStatusCoreService.updateMerchantStatus(string, shopInfo.getShopStatus(), "");
                    if (!flag)
                    {
                        return new TransData<Object>(false, MisMessageConst.MIS_USERMANA_ENTERPRISE_LOCK_SHOP_FAIL, null, shopInfo.getShopId());
                    }
                }
                else
                {
                    return new TransData<Object>(false, MisMessageConst.MIS_USERMANA_ENTERPRISE_ONLY_NORMALBUSINESS_SHOP_CAN_LOCK, null, shopInfo.getShopId());
                }
            }
            else
            {
                return new TransData<Object>(false, MisMessageConst.MIS_USERMANA_ENTERPRISE_LOCK_SHOP_FAIL, null, shopInfo.getShopId());
            }
        }
        return new TransData<Object>(true, MisMessageConst.MIS_USERMANA_ENTERPRISE_LOCK_SHOP_SUCCESS, null);
    }

    /**
     * 查询商家Lid信息
     */
    @Override
    public TransData<PageModel<MShopLidInfo>> searchLidInfo(HttpServletRequest request) throws Exception
    {
        ShopLidInfoExample lidExample = new ShopLidInfoExample();
        MShopLidInfo vo = ServletUtils.objectMethod(MShopLidInfo.class, request);
        PageCondition pageCondition = ServletUtils.objectMethod(PageCondition.class, request);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
        // 设置查询条件
        com.gooagoo.entity.generator.shop.ShopLidInfoExample.Criteria criteria = lidExample.createCriteria();
        criteria.andIsDelEqualTo("N");
        if (StringUtils.hasText(vo.getLidBase()))
        {
            criteria.andLidBaseLike("%" + vo.getLidBase() + "%");
        }
        if (StringUtils.hasText(vo.getShopEntityId()))
        {
            criteria.andShopEntityIdEqualTo(vo.getShopEntityId());
        }
        if (StringUtils.hasText(vo.getShopEntityId()))
        {
            criteria.andShopEntityIdEqualTo(vo.getShopEntityId());
        }
        PageModel<MShopLidInfo> pm = new PageModel<MShopLidInfo>();
        if (pageCondition != null)
        {
            pm.setPageIndex(pageCondition.getPageIndex());
            pm.setPageSize(pageSize);
        }
        Integer count = this.shopLidInfoGeneratorQueryService.countByExample(lidExample);
        pm.setCount(count);
        if (count > 0)
        {
            lidExample.setPage(pm.getPageIndex(), pageSize);// 设置分页条件
            List<ShopLidInfo> list = this.shopLidInfoGeneratorQueryService.selectByExample(lidExample);
            for (ShopLidInfo s : list)
            {
                MShopLidInfo ms = new MShopLidInfo();
                EntityTools.copyValue(s, ms);
                pm.getResult().add(ms);
            }
        }
        return new TransData<PageModel<MShopLidInfo>>(true, null, pm);
    }

    /**
     * 删除商家Lid信息
     */
    @Override
    public TransData<Object> delShopLid(HttpServletRequest request) throws Exception
    {
        // TODO Auto-generated method stub
        //        String shopEntityId = ServletRequestUtils.getStringParameter(request, "shopEntityId", "");
        //        String lid = ServletRequestUtils.getStringParameter(request, "lids", "");
        //boolean r = this.coreShopLidService.delete(shopEntityId, lid);
        boolean r = false;

        return UtilsMis.getBooleanResult(r, MisMessageConst.SYS_DEL_SUCCESS, MisMessageConst.SYS_DEL_FAIL);
    }

    /**
     * Lid信息分配
     */
    @Override
    public TransData<Object> allotLid(HttpServletRequest request) throws Exception
    {
        // TODO Auto-generated method stub
        String shopEntityId = ServletRequestUtils.getStringParameter(request, "shopEntityId", "");
        String lid = ServletRequestUtils.getStringParameter(request, "lid", "");

        MShopLidInfo mShopLidInfo = new MShopLidInfo();
        mShopLidInfo.setShopEntityId(shopEntityId);
        mShopLidInfo.setLidBase(lid);
        //boolean r = this.coreShopLidService.add(mShopLidInfo);
        boolean r = false;
        return UtilsMis.getBooleanResult(r, MisMessageConst.SYS_ADD_SUCCESS, MisMessageConst.SYS_ADD_FAIL, mShopLidInfo.getLidBase());
    }

    /**
     * 查询所有商家信息(分页)
     */
    @Override
    public TransData<PageModel<MShopInfo>> searchShopList(HttpServletRequest request) throws Exception
    {
        MShopInfo vo = ServletUtils.objectMethod(MShopInfo.class, request);
        PageCondition pageCondition = ServletUtils.objectMethod(PageCondition.class, request);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
        // 设置查询条件
        ShopInfoExample shopExample = new ShopInfoExample();
        Criteria shopExampleC = shopExample.createCriteria();
        shopExampleC.andIsDelEqualTo("N");
        //商家编号
        if (StringUtils.hasText(vo.getShopId()))
        {
            shopExampleC.andShopIdLike("%" + vo.getShopId() + "%");
        }
        //邮箱地址
        if (StringUtils.hasText(vo.getEmail()))
        {
            shopExampleC.andEmailLike("%" + vo.getEmail() + "%");
        }
        //昵称
        if (StringUtils.hasText(vo.getNickName()))
        {
            shopExampleC.andNickNameLike("%" + vo.getNickName() + "%");
        }
        //商家状态
        if (StringUtils.hasText(vo.getShopStatus()))
        {
            shopExampleC.andShopStatusEqualTo(vo.getShopStatus());
        }
        //是否连锁
        if (StringUtils.hasText(vo.getIsChain()))
        {
            shopExampleC.andIsChainEqualTo(vo.getIsChain());
        }
        //部署模式
        if (StringUtils.hasText(vo.getServiceStyle()))
        {
            shopExampleC.andServiceStyleEqualTo(vo.getServiceStyle());
        }
        //创建时间
        if (!"".equals(vo.getCreateTime_FE()) && null != vo.getCreateTime_FE())
        {
            shopExampleC.andCreateTimeGreaterThanOrEqualTo(vo.getCreateTime_FE());
        }
        if (!"".equals(vo.getCreateTime_TE()) && null != vo.getCreateTime_TE())
        {
            shopExampleC.andCreateTimeLessThanOrEqualTo(UtilsMis.getMidNight(vo.getCreateTime_TE()));
        }
        //商家名称
        if (StringUtils.hasText(vo.getShopName()))
        {
            shopExampleC.andShopNameLike("%" + vo.getShopName() + "%");
        }
        PageModel<MShopInfo> pm = new PageModel<MShopInfo>();
        if (pageCondition != null)
        {
            pm.setPageIndex(pageCondition.getPageIndex());
            pm.setPageSize(pageSize);
        }
        Integer count = this.shopInfoGeneratorQueryService.countByExample(shopExample);
        pm.setCount(count);
        if (count > 0)
        {
            shopExample.setPage(pm.getPageIndex(), pageSize);// 设置分页条件
            List<ShopInfo> list = this.shopInfoGeneratorQueryService.selectByExample(shopExample);
            for (ShopInfo s : list)
            {
                MShopInfo ms = new MShopInfo();
                EntityTools.copyValue(s, ms);
                pm.getResult().add(ms);
            }
        }
        return new TransData<PageModel<MShopInfo>>(true, null, pm);
    }

    /**
     * 查询所有商家信息
     */
    @Override
    public TransData<List<MShopInfo>> searchShopListNo(HttpServletRequest request) throws Exception
    {
        MShopInfo vo = ServletUtils.objectMethod(MShopInfo.class, request);
        ShopInfoExample shopExample = new ShopInfoExample();
        Criteria shopExampleC = shopExample.createCriteria();
        shopExampleC.andIsDelEqualTo("N");
        //商家编号
        if (StringUtils.hasText(vo.getShopId()))
        {
            shopExampleC.andShopIdEqualTo(vo.getShopId());
        }
        //邮箱地址
        if (StringUtils.hasText(vo.getEmail()))
        {
            shopExampleC.andEmailEqualTo(vo.getEmail());
        }
        //昵称
        if (StringUtils.hasText(vo.getNickName()))
        {
            shopExampleC.andNickNameEqualTo(vo.getNickName());
        }
        //商家状态
        if (StringUtils.hasText(vo.getShopStatus()))
        {
            shopExampleC.andShopStatusEqualTo(vo.getShopStatus());
        }
        //是否连锁
        if (StringUtils.hasText(vo.getIsChain()))
        {
            shopExampleC.andIsChainEqualTo(vo.getIsChain());
        }
        //部署模式
        if (StringUtils.hasText(vo.getServiceStyle()))
        {
            shopExampleC.andServiceStyleEqualTo(vo.getServiceStyle());
        }
        //创建时间
        if (!"".equals(vo.getCreateTime_FE()) && null != vo.getCreateTime_FE())
        {
            shopExampleC.andCreateTimeGreaterThanOrEqualTo(vo.getCreateTime_FE());
        }
        if (!"".equals(vo.getCreateTime_TE()) && null != vo.getCreateTime_TE())
        {
            shopExampleC.andCreateTimeLessThanOrEqualTo(UtilsMis.getMidNight(vo.getCreateTime_TE()));
        }
        //商家名称
        if (StringUtils.hasText(vo.getShopName()))
        {
            shopExampleC.andShopNameEqualTo(vo.getShopName());
        }
        List<MShopInfo> shopInfoList = new ArrayList<MShopInfo>();
        List<ShopInfo> list = this.shopInfoGeneratorQueryService.selectByExample(shopExample);
        if (!CollectionUtils.isEmpty(list))
        {
            for (ShopInfo s : list)
            {
                MShopInfo ms = new MShopInfo();
                EntityTools.copyValue(s, ms);
                shopInfoList.add(ms);
            }
        }
        return new TransData<List<MShopInfo>>(true, null, shopInfoList);
    }

    /**
     *根据商家编码查询实体店list
     */
    @Override
    public TransData<List<MShopEntityInfo>> searchAllShopEntity(HttpServletRequest request) throws Exception
    {
        ShopEntityInfoExample entityExample = new ShopEntityInfoExample();
        MShopEntityInfo vo = ServletUtils.objectMethod(MShopEntityInfo.class, request);
        // 设置查询条件
        com.gooagoo.entity.generator.shop.ShopEntityInfoExample.Criteria criteria = entityExample.createCriteria();
        criteria.andIsDelEqualTo("N");
        criteria.andShopIdEqualTo(vo.getShopId());
        List<MShopEntityInfo> msList = new ArrayList<MShopEntityInfo>();
        List<ShopEntityInfo> shopList = this.shopEntityInfoGeneratorQueryService.selectByExample(entityExample);
        if (shopList.size() > 0)
        {
            for (ShopEntityInfo s : shopList)
            {
                MShopEntityInfo ms = new MShopEntityInfo();
                EntityTools.copyValue(s, ms);
                msList.add(ms);
            }
        }
        return new TransData<List<MShopEntityInfo>>(true, null, msList);
    }

    /**
     * 审核商家（未通过）
     */
    @Override
    public TransData<Object> notApproved(HttpServletRequest request) throws Exception
    {
        String shopId = ServletRequestUtils.getStringParameter(request, "shopId", "");
        String reason = ServletRequestUtils.getStringParameter(request, "reason", "");
        ShopInfo zInfo = this.shopInfoGeneratorQueryService.selectUnDelByPrimaryKey(shopId);
        if (zInfo != null)
        {
            zInfo.setNote(reason);
            zInfo.setCTimeStamp(new Date());
            boolean flag = this.merchantStatusCoreService.updateMerchantStatus(shopId, "L", zInfo.getNote());
            if (!flag)
            {

                throw new GooagooException(MisMessageConst.MIS_USERMANA_ENTERPRISE_CHECK_SUCCESS);
            }
        }
        else
        {
            throw new GooagooException(MisMessageConst.MIS_USERMANA_ENTERPRISE_CHECK_FAIL);
        }
        return UtilsMis.getBooleanResult(true, MisMessageConst.MIS_USERMANA_ENTERPRISE_CHECK_SUCCESS, null, zInfo.getShopId());
    }

    /**
     * 验证实体店基本信息
     * @param shopId
     * @return
     */
    private List<ShopEntityInfo> checkShopEntityInfo(String shopId)
    {
        ShopEntityInfoExample shopEntityInfo = new ShopEntityInfoExample();
        shopEntityInfo.createCriteria().andShopIdEqualTo(shopId).andIsDelEqualTo("N");
        List<ShopEntityInfo> shopEntityInfos = this.shopEntityInfoGeneratorQueryService.selectByExample(shopEntityInfo);
        if (shopEntityInfos != null && shopEntityInfos.size() > 0)
        {
            return shopEntityInfos;
        }
        else
        {
            return null;
        }
    }

    /**
     * 验证实体店联系方式
     * @param shopEntityInfos
     * @return
     */
    private boolean checkShopEntityLink(List<ShopEntityInfo> shopEntityInfos)
    {
        if (shopEntityInfos != null)
        {
            for (ShopEntityInfo shopEntityInfo : shopEntityInfos)
            {
                ShopEntityLinkExample shopEntityLink = new ShopEntityLinkExample();
                shopEntityLink.createCriteria().andShopEntityIdEqualTo(shopEntityInfo.getShopEntityId()).andIsDelEqualTo("N");
                List<ShopEntityLink> shopEntityLinks = this.shopEntityLinkGeneratorQueryService.selectByExample(shopEntityLink);
                if (shopEntityLinks == null || shopEntityLinks.size() == 0)
                {
                    return false;
                }
            }
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * 验证商家实体店gsp信息
     * @param shopEntityInfos
     * @return
     */
    private boolean checkShopGapInfo(List<ShopEntityInfo> shopEntityInfos)
    {
        if (shopEntityInfos != null)
        {
            for (ShopEntityInfo shopEntityInfo : shopEntityInfos)
            {
                ShopGpsInfoExample shopGpsInfo = new ShopGpsInfoExample();
                shopGpsInfo.createCriteria().andShopEntityIdEqualTo(shopEntityInfo.getShopEntityId()).andIsDelEqualTo("N");
                List<ShopGpsInfo> shopGpsInfos = this.shopGpsInfoGeneratorQueryService.selectByExample(shopGpsInfo);
                if (shopGpsInfos == null || shopGpsInfos.size() == 0)
                {
                    return false;
                }
            }
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * 商家Lid信息验证
     * @param shopEntityInfos
     * @return
     */
    public boolean checkShopLidInfo(List<ShopEntityInfo> shopEntityInfos)
    {
        if (shopEntityInfos != null)
        {
            for (ShopEntityInfo shopEntityInfo : shopEntityInfos)
            {
                ShopLidInfoExample shopLidInfo = new ShopLidInfoExample();
                shopLidInfo.createCriteria().andShopEntityIdEqualTo(shopEntityInfo.getShopEntityId()).andIsDelEqualTo("N");
                List<ShopLidInfo> shopLidInfos = this.shopLidInfoGeneratorQueryService.selectByExample(shopLidInfo);
                if (shopLidInfos == null || shopLidInfos.size() == 0)
                {
                    return false;
                }
            }
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * 商家转发器验证
     * @param shopEntityInfos
     * @return
     */
    public boolean checkTranspcInfo(List<ShopEntityInfo> shopEntityInfos)
    {
        if (shopEntityInfos != null)
        {
            for (ShopEntityInfo shopEntityInfo : shopEntityInfos)
            {
                DeviceTransponderExample transpcInfo = new DeviceTransponderExample();
                transpcInfo.createCriteria().andShopEntityIdEqualTo(shopEntityInfo.getShopEntityId()).andIsDelEqualTo("N");
                List<DeviceTransponder> transpcInfos = this.deviceTransponderGeneratorQueryService.selectByExample(transpcInfo);
                if (transpcInfos == null || transpcInfos.size() == 0)
                {
                    return false;
                }
            }
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * 验证商家主实体店的唯一性
     * @param shopId
     * @return
     */
    private boolean checkShopEntityInfoUniqueness(String shopId)
    {
        boolean flag = true;
        if (!StringUtils.hasText(shopId))
        {
            return flag;
        }
        ShopEntityInfoExample example = new ShopEntityInfoExample();
        example.createCriteria().andIsDelEqualTo("N").andShopIdEqualTo(shopId);
        List<ShopEntityInfo> entityList = this.shopEntityInfoGeneratorQueryService.selectByExample(example);
        if (!CollectionUtils.isEmpty(entityList))
        {
            int count = 0;
            for (ShopEntityInfo entity : entityList)
            {
                if ("Y".equals(entity.getIsGeneral()))
                {
                    count++;
                }
            }
            if (count == 1)
            {
                flag = false;
            }
        }
        return flag;
    }
}
