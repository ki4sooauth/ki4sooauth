package com.gooagoo.mobile.api.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.system.SystemBusinessCoreService;
import com.gooagoo.api.business.query.shop.cache.ShopCacheQueryService;
import com.gooagoo.api.business.query.shop.tool.ToolQueryService;
import com.gooagoo.api.business.query.system.cms.SysCmsContentQueryService;
import com.gooagoo.api.generator.query.base.ShopTypeGeneratorQueryService;
import com.gooagoo.api.generator.query.goods.GoodsCategoryGeneratorQueryService;
import com.gooagoo.api.generator.query.member.MemberCardGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.AreaParaGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopEntityInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopEntityLinkGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopGpsInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopInvoiceInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopLidInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopWifiinfoGeneratorQueryService;
import com.gooagoo.api.generator.query.sys.ShopInterfaceInfoGeneratorQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.entity.business.shop.tool.ShopToolListBusiness;
import com.gooagoo.entity.generator.base.ShopType;
import com.gooagoo.entity.generator.base.ShopTypeExample;
import com.gooagoo.entity.generator.goods.GoodsCategory;
import com.gooagoo.entity.generator.goods.GoodsCategoryExample;
import com.gooagoo.entity.generator.member.MemberCard;
import com.gooagoo.entity.generator.member.MemberCardExample;
import com.gooagoo.entity.generator.shop.AreaPara;
import com.gooagoo.entity.generator.shop.AreaParaExample;
import com.gooagoo.entity.generator.shop.ShopEntityInfo;
import com.gooagoo.entity.generator.shop.ShopEntityInfoExample;
import com.gooagoo.entity.generator.shop.ShopEntityLink;
import com.gooagoo.entity.generator.shop.ShopEntityLinkExample;
import com.gooagoo.entity.generator.shop.ShopGpsInfo;
import com.gooagoo.entity.generator.shop.ShopGpsInfoExample;
import com.gooagoo.entity.generator.shop.ShopInfo;
import com.gooagoo.entity.generator.shop.ShopInfoExample;
import com.gooagoo.entity.generator.shop.ShopInvoiceInfo;
import com.gooagoo.entity.generator.shop.ShopInvoiceInfoExample;
import com.gooagoo.entity.generator.shop.ShopLidInfo;
import com.gooagoo.entity.generator.shop.ShopLidInfoExample;
import com.gooagoo.entity.generator.shop.ShopWifiinfo;
import com.gooagoo.entity.generator.shop.ShopWifiinfoExample;
import com.gooagoo.entity.generator.sys.ShopInterfaceInfo;
import com.gooagoo.entity.generator.sys.ShopInterfaceInfoExample;
import com.gooagoo.mobile.api.BaseInfoMobileService;
import com.gooagoo.mobile.common.entity.ShopInfoEntity;
import com.gooagoo.mobile.entity.mobg01.transform.BaseInfoRoot;
import com.gooagoo.mobile.entity.mobg01.transform.Goods;
import com.gooagoo.mobile.entity.mobg01.transform.Imobilelistg;
import com.gooagoo.mobile.entity.mobg01.transform.Invoicetypec;
import com.gooagoo.mobile.entity.mobg01.transform.Invoicetypep;
import com.gooagoo.mobile.entity.mobg01.transform.Membercard;
import com.gooagoo.mobile.entity.mobg01.transform.Shopentityinfo;
import com.gooagoo.mobile.entity.mobg01.transform.Shopentitylink;
import com.gooagoo.mobile.entity.mobg01.transform.Shopgpsinfo;
import com.gooagoo.mobile.entity.mobg01.transform.Shopinfo;
import com.gooagoo.mobile.entity.mobg01.transform.Shopinfosynctimestamp;
import com.gooagoo.mobile.entity.mobg01.transform.Shopinvoiceinfo;
import com.gooagoo.mobile.entity.mobg01.transform.Shoplidinfo;
import com.gooagoo.mobile.entity.mobg01.transform.Shopsvginfo;
import com.gooagoo.mobile.entity.mobg01.transform.Shoptoollist;
import com.gooagoo.mobile.entity.mobg01.transform.Shoptype;
import com.gooagoo.mobile.entity.mobg01.transform.Shopwifiinfo;
import com.gooagoo.mobile.entity.mobg01.transform.Synctimestamp;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service
public class BaseInfoMobileServiceImpl implements BaseInfoMobileService
{
    @Autowired
    private ShopEntityInfoGeneratorQueryService shopEntityInfoGeneratorQueryService;
    @Autowired
    private ShopInfoGeneratorQueryService shopInfoGeneratorQueryService;
    @Autowired
    private ShopCacheQueryService shopCacheQueryService;
    @Autowired
    private ShopTypeGeneratorQueryService shopTypeGeneratorQueryService;
    @Autowired
    private ShopInterfaceInfoGeneratorQueryService shopInterfaceInfoGeneratorQueryService;
    @Autowired
    private ShopEntityLinkGeneratorQueryService shopEntityLinkGeneratorQueryService;
    @Autowired
    private ShopGpsInfoGeneratorQueryService shopGpsInfoGeneratorQueryService;
    @Autowired
    private ShopLidInfoGeneratorQueryService shopLidInfoGeneratorQueryService;
    @Autowired
    private ShopWifiinfoGeneratorQueryService shopWifiinfoGeneratorQueryService;
    @Autowired
    private ShopInvoiceInfoGeneratorQueryService shopInvoiceInfoGeneratorQueryService;
    @Autowired
    private AreaParaGeneratorQueryService areaParaGeneratorQueryService;
    @Autowired
    private MemberCardGeneratorQueryService memberCardGeneratorQueryService;
    @Autowired
    private GoodsCategoryGeneratorQueryService goodsCategoryGeneratorQueryService;
    @Autowired
    private SystemBusinessCoreService systemBusinessCoreService;
    @Autowired
    private SysCmsContentQueryService sysCmsContentQueryService;
    @Autowired
    private ToolQueryService toolQueryService;

    @Override
    public BaseInfoRoot getShopBaseInfo(String type, String shopEntityId, String syninfo, String containcode) throws Exception
    {
        GooagooLog.info("getShopBaseInfo-->入参信息为:【type=" + type + " ,shopEntityId=" + shopEntityId + " ,syninfo=" + syninfo + " ,containcode=" + containcode + "】");

        //1.提取封装查询条件
        List<ShopInfoEntity> synShopInfo = new ArrayList<ShopInfoEntity>();
        Date goodsTypeCtimeStamp = null;//查询商品类别信息的时间戳
        Date shopTypeCtimeStamp = null;

        if ("2".equals(type) && StringUtils.hasText(shopEntityId))
        {//1.1 type=2时，按实体店编号查询，即查询实体店对应商家的基本信息
            ShopEntityInfo shopEntityInfo = this.shopEntityInfoGeneratorQueryService.selectUnDelByPrimaryKey(shopEntityId);
            if (shopEntityInfo == null)
            {
                GooagooLog.debug("未查询到实体店编号【shopEntityId=" + shopEntityId + "】未删除的实体店信息");
                return null;
            }
            ShopInfoEntity shopInfoEntity = new ShopInfoEntity();
            shopInfoEntity.setShopid(shopEntityInfo.getShopId());
            synShopInfo.add(shopInfoEntity);
        }
        else if ("1".equals(type) && StringUtils.hasText(syninfo))
        {//1.2 type=1时，按同步的信息查询多个商家的信息

            //1)从json串中取出要同步的信息
            Map<String, List<Map<String, String>>> syninfoMap = new Gson().fromJson(syninfo, new TypeToken<Map<String, List<Map<String, String>>>>()
            {
            }.getType());

            //2)取出同步信息中的要同步的商家信息
            List<Map<String, String>> shopInfoMap = syninfoMap.get("shopinfo");
            if (CollectionUtils.isNotEmpty(shopInfoMap))
            {
                for (Map<String, String> map : shopInfoMap)
                {
                    ShopInfoEntity tempShopInfoEntity = new ShopInfoEntity();
                    tempShopInfoEntity.setShopid(map.get("shopid"));
                    tempShopInfoEntity.setcTimeStamp(StringUtils.hasText(map.get("ctimestamp")) ? TimeUtils.convertStringToDate(map.get("ctimestamp")) : null);
                    synShopInfo.add(tempShopInfoEntity);
                }
            }

            //3)取出同步信息中的要同步的商品类别信息
            List<Map<String, String>> shoppingListGoodsTypeMap = syninfoMap.get("shoppinglistgoodstype");
            if (CollectionUtils.isNotEmpty(shoppingListGoodsTypeMap))
            {
                if (StringUtils.hasText(shoppingListGoodsTypeMap.get(0).get("ctimestamp")))
                {//有时间戳时，按时间戳查询，无时查询所有商品类别信息
                    goodsTypeCtimeStamp = TimeUtils.convertStringToDate(shoppingListGoodsTypeMap.get(0).get("ctimestamp"));//同步信息的时间戳
                }
            }

            //4)取出同步信息中的要同步的商家类别信息
            List<Map<String, String>> shopTypeMap = syninfoMap.get("shoptype");
            if (CollectionUtils.isNotEmpty(shopTypeMap))
            {
                if (StringUtils.hasText(shopTypeMap.get(0).get("ctimestamp")))
                {//有时间戳时，按时间戳查询，无时查询所有商品类别信息
                    shopTypeCtimeStamp = TimeUtils.convertStringToDate(shopTypeMap.get(0).get("ctimestamp"));//同步信息的时间戳
                }
            }
        }
        else
        {
            GooagooLog.debug("未查询到查询条件为:【type=" + type + " ,shopEntityId=" + shopEntityId + " ,syninfo=" + syninfo + " ,containcode=" + containcode + "】的基础信息");
            return null;
        }

        //---开始同步查询商家基本信息
        List<Shopinfo> shopinfoList = new ArrayList<Shopinfo>();
        List<Imobilelistg> imobilelistgList = new ArrayList<Imobilelistg>();
        List<Shopentityinfo> shopentityinfoList = new ArrayList<Shopentityinfo>();
        List<Shopentitylink> shopentitylinkList = new ArrayList<Shopentitylink>();
        List<Shoplidinfo> shoplidinfoList = new ArrayList<Shoplidinfo>();
        List<Shopgpsinfo> shopgpsinfoList = new ArrayList<Shopgpsinfo>();
        List<Shopwifiinfo> shopwifiinfoList = new ArrayList<Shopwifiinfo>();
        List<Shopinvoiceinfo> shopinvoiceinfoList = new ArrayList<Shopinvoiceinfo>();
        List<Shopsvginfo> shopsvginfoList = new ArrayList<Shopsvginfo>();
        List<Shoptoollist> shoptoollists = new ArrayList<Shoptoollist>();
        List<Membercard> membercardList = new ArrayList<Membercard>();
        List<Shopinfosynctimestamp> shopinfosynctimestampList = null;//下次商家信息同步的时间戳
        if (CollectionUtils.isNotEmpty(synShopInfo) && containcode.contains("A"))
        {
            shopinfosynctimestampList = new ArrayList<Shopinfosynctimestamp>();
            for (ShopInfoEntity tempShopInfoEntity : synShopInfo)
            {
                //获取商家基本信息下次同步的时间戳
                Shopinfosynctimestamp shopinfosynctimestamp = new Shopinfosynctimestamp();
                Date shopCtimeStamp = this.systemBusinessCoreService.getCoreSysCurrentTime();//商家基本信息下次同步时间戳
                shopinfosynctimestamp.setShopctimestamp(shopCtimeStamp != null ? TimeUtils.convertDateToString(shopCtimeStamp, TimeUtils.FORMAT1) : null);
                shopinfosynctimestamp.setShopid(tempShopInfoEntity.getShopid());
                shopinfosynctimestampList.add(shopinfosynctimestamp);
                //同步加基本信息的同步条件（商家编号、时间戳）
                String shopId = tempShopInfoEntity.getShopid();
                Date cTimeStamp = tempShopInfoEntity.getcTimeStamp();

                //2.获取商家信息
                Shopinfo shopinfo = this.getShopInfo(shopId, cTimeStamp, containcode);
                if (shopinfo != null)
                {
                    shopinfoList.add(shopinfo);
                }

                //3.获取接口地址列表信息
                //                List<Imobilelistg> imobilelistg = this.getIntefaceAddressInfo(shopId, cTimeStamp, containcode);
                //                if (CollectionUtils.isNotEmpty(imobilelistg))
                //                {
                //                    imobilelistgList.addAll(imobilelistg);
                //                }

                //4.获取实体店基本信息
                List<Shopentityinfo> shopentityinfo = this.getShopentityInfo(shopId, cTimeStamp, containcode);
                if (CollectionUtils.isNotEmpty(shopentityinfo))
                {
                    shopentityinfoList.addAll(shopentityinfo);
                }

                //5.获取实体店联系方式
                List<Shopentitylink> shopentitylink = this.getShopentityLink(shopId, cTimeStamp, containcode);
                if (CollectionUtils.isNotEmpty(shopentitylink))
                {
                    shopentitylinkList.addAll(shopentitylink);
                }

                //6.获取实体店主lid
                Shoplidinfo shoplidinfo = this.getShoplidInfo(shopId, cTimeStamp, containcode);
                if (shoplidinfo != null)
                {
                    shoplidinfoList.add(shoplidinfo);
                }

                //7.获取实体店gps信息
                List<Shopgpsinfo> shopgpsinfo = this.getShopGpsInfo(shopId, cTimeStamp, containcode);
                if (CollectionUtils.isNotEmpty(shopgpsinfo))
                {
                    shopgpsinfoList.addAll(shopgpsinfo);
                }

                //8.获取实体店wifi信息
                List<Shopwifiinfo> shopwifiinfo = this.getShopWifiInfo(shopId, cTimeStamp, containcode);
                if (CollectionUtils.isNotEmpty(shopwifiinfo))
                {
                    shopwifiinfoList.addAll(shopwifiinfo);
                }

                //9.获取实体店开发票项目信息
                List<Shopinvoiceinfo> shopinvoiceinfo = this.getShopInvoiceInfo(shopId, cTimeStamp, containcode);
                if (CollectionUtils.isNotEmpty(shopinvoiceinfo))
                {
                    shopinvoiceinfoList.addAll(shopinvoiceinfo);
                }

                //10.获取实体店svg图信息
                List<Shopsvginfo> shopsvginfo = this.getShopSvgInfo(shopId, cTimeStamp, containcode);
                if (CollectionUtils.isNotEmpty(shopsvginfo))
                {
                    shopsvginfoList.addAll(shopsvginfo);
                }

                //11.获取服务工具信息
                List<Shoptoollist> shoptoollist = this.getShopToolList(shopId, cTimeStamp, containcode);
                if (CollectionUtils.isNotEmpty(shoptoollist))
                {
                    shoptoollists.addAll(shoptoollist);
                }

                //12.获取商家会员卡基本信息
                List<Membercard> membercard = this.getMembercardInfo(shopId, cTimeStamp, containcode);
                if (CollectionUtils.isNotEmpty(membercard))
                {
                    membercardList.addAll(membercard);
                }
            }

        }

        //13.获取购物计划商品分类信息
        List<Goods> goodsList = null;
        Date goodsTypeDate = null;
        if (goodsTypeCtimeStamp != null && containcode.contains("B"))
        {
            goodsList = this.getGoodsListInfo(goodsTypeCtimeStamp, containcode);
            goodsTypeDate = this.systemBusinessCoreService.getCoreSysCurrentTime();//购物计划商品分类信息下次同步时间戳
        }

        //14.获取商家类型字典信息
        List<Shoptype> shoptypeList = null;
        Date shopTypeDate = null;
        if (shopTypeCtimeStamp != null && containcode.contains("C"))
        {
            shoptypeList = this.getShoptype(shopTypeCtimeStamp, containcode);
            shopTypeDate = this.systemBusinessCoreService.getCoreSysCurrentTime();//商家基本信息下次同步时间戳
        }

        //---完成同步查询商家基本信息

        //15.封装数据
        BaseInfoRoot root = new BaseInfoRoot();
        //同步时间戳封装
        Synctimestamp synctimestamp = null;
        if (goodsTypeDate != null || shopTypeDate != null)
        {
            GooagooLog.debug("未选择同步商家类型字典信息和商品类型信息【containcode=" + containcode + "】");
            synctimestamp = new Synctimestamp();
            synctimestamp.setGoodsctimestamp(goodsTypeDate != null ? TimeUtils.convertDateToString(goodsTypeDate, TimeUtils.FORMAT1) : null);
            synctimestamp.setShoptypectimestamp(shopTypeDate != null ? TimeUtils.convertDateToString(shopTypeDate, TimeUtils.FORMAT1) : null);
        }
        root.setShopinfosynctimestamp(shopinfosynctimestampList);
        root.setSynctimestamp(synctimestamp);
        //封装商家相关信息
        root.setShopinfo(CollectionUtils.isNotEmpty(shopinfoList) ? shopinfoList : null);
        root.setImobilelistg(CollectionUtils.isNotEmpty(imobilelistgList) ? imobilelistgList : null);
        root.setShopentityinfo(CollectionUtils.isNotEmpty(shopentityinfoList) ? shopentityinfoList : null);
        root.setShopentitylink(CollectionUtils.isNotEmpty(shopentitylinkList) ? shopentitylinkList : null);
        root.setShoplidinfo(CollectionUtils.isNotEmpty(shoplidinfoList) ? shoplidinfoList : null);
        root.setShopgpsinfo(CollectionUtils.isNotEmpty(shopgpsinfoList) ? shopgpsinfoList : null);
        root.setShopwifiinfo(CollectionUtils.isNotEmpty(shopwifiinfoList) ? shopwifiinfoList : null);
        root.setShopinvoiceinfo(CollectionUtils.isNotEmpty(shopinvoiceinfoList) ? shopinvoiceinfoList : null);
        root.setShopsvginfo(CollectionUtils.isNotEmpty(shopsvginfoList) ? shopsvginfoList : null);
        root.setShoptoollist(CollectionUtils.isNotEmpty(shoptoollists) ? shoptoollists : null);
        root.setMembercard(CollectionUtils.isNotEmpty(membercardList) ? membercardList : null);
        root.setGoods(CollectionUtils.isNotEmpty(goodsList) ? goodsList : null);
        root.setShoptype(CollectionUtils.isNotEmpty(shoptypeList) ? shoptypeList : null);

        return root;
    }

    /**
     * 获取商家信息
     * @param synShopInfo 要同步的商家信息
     * @param cTimeStamp  同步时间戳
     * @param containcode 同步范围，用来判断当前要同步的信息是不是在同步范围内
     * @return
     */
    private Shopinfo getShopInfo(String shopId, Date cTimeStamp, String containcode) throws Exception
    {
        GooagooLog.info("获取商家信息(getShopInfo)-->入参为:【shopId=" + shopId + " ,cTimeStamp=" + cTimeStamp + " ,containcode=" + containcode + "】");

        //1.判断是否在同步信息范围内
        //        if (StringUtils.hasText(containcode))
        //        {//如果同步范围信息不为空，判断当前信息是不是在同步范围内
        //            if (!containcode.contains("a01"))
        //            {
        //                return null;
        //            }
        //        }

        //2.在同步范围内，查询同步商家信息
        ShopInfoExample shopInfoExample = new ShopInfoExample();
        if (cTimeStamp != null)
        {
            shopInfoExample.createCriteria().andShopIdEqualTo(shopId).andCTimeStampGreaterThan(cTimeStamp);
        }
        else
        {
            shopInfoExample.createCriteria().andShopIdEqualTo(shopId);
        }
        List<ShopInfo> shopInfoList = this.shopInfoGeneratorQueryService.selectByExample(shopInfoExample);

        //3.封装查询到的商家信息
        Shopinfo resultShopinfo = null;
        if (CollectionUtils.isNotEmpty(shopInfoList))
        {
            resultShopinfo = new Shopinfo();
            ShopInfo tempShopInfo = shopInfoList.get(0);

            //查询商家信息缓存
            Map<String, String> shopInfoMap = this.shopCacheQueryService.findShopInfo(shopId);

            resultShopinfo.setShopid(tempShopInfo.getShopId());
            resultShopinfo.setShopname(tempShopInfo.getShopName());
            resultShopinfo.setShoptypelv1(tempShopInfo.getShopTypeRoot().toString());
            resultShopinfo.setShoptypelv1name(shopInfoMap.get("shopTypeRootName"));//商家类型名称（根节点）
            resultShopinfo.setShoptypelv2(tempShopInfo.getShopTypeLeaf().toString());
            resultShopinfo.setShoptypelv2name(shopInfoMap.get("shopTypeLeafName"));//商家类型名称（叶节点）
            resultShopinfo.setLogor(tempShopInfo.getLogo2());//长方形
            resultShopinfo.setLogos(tempShopInfo.getLogo1());//正方形
            try
            {
                resultShopinfo.setVirtureshopurl(this.sysCmsContentQueryService.getCmsContentUrl(shopId, "M"));//虚拟商家地址
            }
            catch (Exception e)
            {
                GooagooLog.warn(e.getMessage());
            }
            resultShopinfo.setShopintegralurl(UrlUtils.getIntegralMallUrl(tempShopInfo.getShopId()));//积分商城地址
            resultShopinfo.setIsdel(tempShopInfo.getIsDel());
            resultShopinfo.setCtimestamp(TimeUtils.convertDateToString(tempShopInfo.getCTimeStamp(), TimeUtils.FORMAT1));
        }

        return resultShopinfo;
    }

    /**
     * 获取接口地址列表信息
     * @param synShopInfo 要同步的商家信息
     * @param cTimeStamp  同步时间戳
     * @param containcode 同步范围，用来判断当前要同步的信息是不是在同步范围内
     * @return
     */
    private List<Imobilelistg> getIntefaceAddressInfo(String shopId, Date cTimeStamp, String containcode)
    {
        GooagooLog.info("获取接口地址列表信息(getIntefaceAddressInfo)-->入参为:【shopId=" + shopId + " ,cTimeStamp=" + cTimeStamp + " ,containcode=" + containcode + "】");
        //        if (StringUtils.hasText(containcode))
        //        {//如果同步范围信息不为空，判断当前信息是不是在同步范围内
        //            if (!containcode.contains("a02"))
        //            {
        //                return null;
        //            }
        //        }
        //在同步范围内，查询同步接口信息
        ShopInterfaceInfoExample shopInterfaceInfoExample = new ShopInterfaceInfoExample();
        if (cTimeStamp != null)
        {
            shopInterfaceInfoExample.createCriteria().andShopIdEqualTo(shopId).andCTimeStampGreaterThan(cTimeStamp);
        }
        else
        {
            shopInterfaceInfoExample.createCriteria().andShopIdEqualTo(shopId);

        }
        List<ShopInterfaceInfo> shopInterfaceInfoList = this.shopInterfaceInfoGeneratorQueryService.selectByExample(shopInterfaceInfoExample);
        //封装查询到的接口信息
        List<Imobilelistg> imobilelistgList = null;
        if (CollectionUtils.isNotEmpty(shopInterfaceInfoList))
        {
            imobilelistgList = new ArrayList<Imobilelistg>();
            for (ShopInterfaceInfo temp : shopInterfaceInfoList)
            {
                Imobilelistg imobilelistg = new Imobilelistg();
                imobilelistg.setShopid(temp.getShopId());
                imobilelistg.setIcode(temp.getICode());
                imobilelistg.setIurl(temp.getIUrl());
                imobilelistg.setCtimestamp(TimeUtils.convertDateToString(temp.getCTimeStamp(), TimeUtils.FORMAT1));
                imobilelistgList.add(imobilelistg);
            }
        }
        return imobilelistgList;
    }

    /**
     * 获取实体店基本信息
     * @param synShopInfo 要同步的商家信息
     * @param cTimeStamp  同步时间戳
     * @param containcode 同步范围，用来判断当前要同步的信息是不是在同步范围内
     * @return
     */
    private List<Shopentityinfo> getShopentityInfo(String shopId, Date cTimeStamp, String containcode)
    {
        GooagooLog.info("获取实体店基本信息(getShopentityInfo)-->入参为:【shopId=" + shopId + " ,cTimeStamp=" + cTimeStamp + " ,containcode=" + containcode + "】");
        //        if (StringUtils.hasText(containcode))
        //        {//如果同步范围信息不为空，判断当前信息是不是在同步范围内
        //            if (!containcode.contains("a03"))
        //            {
        //                return null;
        //            }
        //        }
        //在同步范围内，查询同步实体店基本信息
        ShopEntityInfoExample shopEntityInfoExample = new ShopEntityInfoExample();
        if (cTimeStamp != null)
        {
            shopEntityInfoExample.createCriteria().andShopIdEqualTo(shopId).andCTimeStampGreaterThan(cTimeStamp);
        }
        else
        {
            shopEntityInfoExample.createCriteria().andShopIdEqualTo(shopId);

        }
        List<ShopEntityInfo> shopEntityInfoList = this.shopEntityInfoGeneratorQueryService.selectByExample(shopEntityInfoExample);
        //封装查询同步实体店基本信息
        List<Shopentityinfo> infosList = null;
        if (CollectionUtils.isNotEmpty(shopEntityInfoList))
        {
            infosList = new ArrayList<Shopentityinfo>();
            for (ShopEntityInfo temp : shopEntityInfoList)
            {
                Shopentityinfo shopentityinfo = new Shopentityinfo();
                shopentityinfo.setShopid(temp.getShopId());
                shopentityinfo.setShopentityid(temp.getShopEntityId());
                shopentityinfo.setShopentitymain(temp.getIsGeneral());
                shopentityinfo.setShopentityname(temp.getShopEntityName());
                shopentityinfo.setEnterprisename(temp.getEnterpriseName());
                shopentityinfo.setOpentime(temp.getOpenTime());
                shopentityinfo.setClosetime(temp.getCloseTime());
                shopentityinfo.setShoproadguide(temp.getShopRoadGuide());
                shopentityinfo.setIsdel(temp.getIsDel());
                shopentityinfo.setCtimestamp(TimeUtils.convertDateToString(temp.getCTimeStamp(), TimeUtils.FORMAT1));
                infosList.add(shopentityinfo);
            }
        }
        return infosList;

    }

    /**
     * 获取实体店联系方式
     * @param synShopInfo 要同步的商家信息
     * @param cTimeStamp  同步时间戳
     * @param containcode 同步范围，用来判断当前要同步的信息是不是在同步范围内
     * @return
     */
    private List<Shopentitylink> getShopentityLink(String shopId, Date cTimeStamp, String containcode)
    {
        GooagooLog.info("获取实体店联系方式信息(getShopentityLink)-->入参为:【shopId=" + shopId + " ,cTimeStamp=" + cTimeStamp + " ,containcode=" + containcode + "】");
        //        if (StringUtils.hasText(containcode))
        //        {//如果同步范围信息不为空，判断当前信息是不是在同步范围内
        //            if (!containcode.contains("a04"))
        //            {
        //                return null;
        //            }
        //        }
        //在同步范围内，查询同步实体店联系方式
        ShopEntityLinkExample shopEntityLinkExample = new ShopEntityLinkExample();
        if (cTimeStamp != null)
        {
            shopEntityLinkExample.createCriteria().andShopIdEqualTo(shopId).andCTimeStampGreaterThan(cTimeStamp);
        }
        else
        {
            shopEntityLinkExample.createCriteria().andShopIdEqualTo(shopId);

        }
        List<ShopEntityLink> shopEntityLinkList = this.shopEntityLinkGeneratorQueryService.selectByExample(shopEntityLinkExample);
        //封装查询同步实体店联系方式
        List<Shopentitylink> infosList = null;
        if (CollectionUtils.isNotEmpty(shopEntityLinkList))
        {
            infosList = new ArrayList<Shopentitylink>();
            for (ShopEntityLink temp : shopEntityLinkList)
            {
                Shopentitylink shopentitylink = new Shopentitylink();
                shopentitylink.setShopid(temp.getShopId());
                shopentitylink.setShopentityid(temp.getShopEntityId());
                shopentitylink.setMobile(temp.getMobile());
                shopentitylink.setPhone(temp.getPhone());
                shopentitylink.setPostcode(temp.getPostCode());
                shopentitylink.setProvince(temp.getProvince());
                shopentitylink.setCity(temp.getCity());
                shopentitylink.setArea(temp.getArea());
                shopentitylink.setAddress(temp.getAddress());
                shopentitylink.setIsdel(temp.getIsDel());
                shopentitylink.setCtimestamp(TimeUtils.convertDateToString(temp.getCTimeStamp(), TimeUtils.FORMAT1));
                infosList.add(shopentitylink);
            }

        }
        return infosList;

    }

    /**
     * 获取实体店主lid
     * @param synShopInfo 要同步的商家信息
     * @param cTimeStamp  同步时间戳
     * @param containcode 同步范围，用来判断当前要同步的信息是不是在同步范围内
     * @return
     */
    private Shoplidinfo getShoplidInfo(String shopId, Date cTimeStamp, String containcode)
    {
        GooagooLog.info("获取实体店主lid信息(getShoplidInfo)-->入参为:【shopId=" + shopId + " ,cTimeStamp=" + cTimeStamp + " ,containcode=" + containcode + "】");
        //        if (StringUtils.hasText(containcode))
        //        {//如果同步范围信息不为空，判断当前信息是不是在同步范围内
        //            if (!containcode.contains("a05"))
        //            {
        //                return null;
        //            }
        //        }
        //在同步范围内，查询同步实体店主lid
        ShopLidInfoExample shopLidInfoExample = new ShopLidInfoExample();
        if (cTimeStamp != null)
        {
            shopLidInfoExample.createCriteria().andShopIdEqualTo(shopId).andCTimeStampGreaterThan(cTimeStamp);
        }
        else
        {
            shopLidInfoExample.createCriteria().andShopIdEqualTo(shopId);

        }
        List<ShopLidInfo> shopLidInfoList = this.shopLidInfoGeneratorQueryService.selectByExample(shopLidInfoExample);
        //封装查询同实体店主lid
        Shoplidinfo shoplidinfo = null;
        if (CollectionUtils.isNotEmpty(shopLidInfoList))
        {
            shoplidinfo = new Shoplidinfo();
            ShopLidInfo temp = shopLidInfoList.get(0);
            shoplidinfo.setShopid(temp.getShopId());
            shoplidinfo.setLidbase(temp.getLidBase());
            shoplidinfo.setShopentityid(temp.getShopEntityId());
            shoplidinfo.setIsdel(temp.getIsDel());
            shoplidinfo.setCtimestamp(TimeUtils.convertDateToString(temp.getCTimeStamp(), TimeUtils.FORMAT1));
        }

        return shoplidinfo;
    }

    /**
     * 获取实体店gps信息
     * @param synShopInfo 要同步的商家信息
     * @param cTimeStamp  同步时间戳
     * @param containcode 同步范围，用来判断当前要同步的信息是不是在同步范围内
     * @return
     */
    private List<Shopgpsinfo> getShopGpsInfo(String shopId, Date cTimeStamp, String containcode)
    {
        GooagooLog.info("获取实体店gps信息(getShopGpsInfo)-->入参为:【shopId=" + shopId + " ,cTimeStamp=" + cTimeStamp + " ,containcode=" + containcode + "】");
        //        if (StringUtils.hasText(containcode))
        //        {//如果同步范围信息不为空，判断当前信息是不是在同步范围内
        //            if (!containcode.contains("a06"))
        //            {
        //                return null;
        //            }
        //        }
        //在同步范围内，查询实体店gps信息
        ShopGpsInfoExample shopGpsInfoExample = new ShopGpsInfoExample();
        if (cTimeStamp != null)
        {
            shopGpsInfoExample.createCriteria().andShopIdEqualTo(shopId).andCTimeStampGreaterThan(cTimeStamp);
        }
        else
        {
            shopGpsInfoExample.createCriteria().andShopIdEqualTo(shopId);
        }
        List<ShopGpsInfo> shopGpsInfoList = this.shopGpsInfoGeneratorQueryService.selectByExample(shopGpsInfoExample);
        //封装查询到的实体店gps信息
        List<Shopgpsinfo> infosList = null;
        if (CollectionUtils.isNotEmpty(shopGpsInfoList))
        {
            infosList = new ArrayList<Shopgpsinfo>();
            for (ShopGpsInfo temp : shopGpsInfoList)
            {
                Shopgpsinfo shopgpsinfo = new Shopgpsinfo();
                shopgpsinfo.setShopid(temp.getShopId());
                shopgpsinfo.setShopentityid(temp.getShopEntityId());
                shopgpsinfo.setShopgpsbaidux(temp.getShopGpsBaidux());
                shopgpsinfo.setShopgpsbaiduy(temp.getShopGpsBaiduy());
                shopgpsinfo.setShopgpsgooglex(temp.getShopGpsGooglex());
                shopgpsinfo.setShopgpsgoogley(temp.getShopGpsGoogley());
                shopgpsinfo.setNote(temp.getNote());
                shopgpsinfo.setIsdel(temp.getIsDel());
                shopgpsinfo.setCtimestamp(TimeUtils.convertDateToString(temp.getCTimeStamp(), TimeUtils.FORMAT1));
                infosList.add(shopgpsinfo);
            }
        }

        return infosList;

    }

    /**
     * 获取实体店wifi信息
     * @param synShopInfo 要同步的商家信息
     * @param cTimeStamp  同步时间戳
     * @param containcode 同步范围，用来判断当前要同步的信息是不是在同步范围内
     * @return
     */
    private List<Shopwifiinfo> getShopWifiInfo(String shopId, Date cTimeStamp, String containcode)
    {
        GooagooLog.info("获取实体店wifi信息(getShopWifiInfo)-->入参为:【shopId=" + shopId + " ,cTimeStamp=" + cTimeStamp + " ,containcode=" + containcode + "】");
        //        if (StringUtils.hasText(containcode))
        //        {//如果同步范围信息不为空，判断当前信息是不是在同步范围内
        //            if (!containcode.contains("a07"))
        //            {
        //                return null;
        //            }
        //        }
        //在同步范围内，查询实体店wifi信息
        ShopWifiinfoExample shopWifiinfoExample = new ShopWifiinfoExample();
        if (cTimeStamp != null)
        {
            shopWifiinfoExample.createCriteria().andShopIdEqualTo(shopId).andCTimeStampGreaterThan(cTimeStamp);
        }
        else
        {
            shopWifiinfoExample.createCriteria().andShopIdEqualTo(shopId);
        }
        List<ShopWifiinfo> shopWifiinfoList = this.shopWifiinfoGeneratorQueryService.selectByExample(shopWifiinfoExample);
        //封装查询到的实体店wifi信息
        List<Shopwifiinfo> infosList = null;
        if (CollectionUtils.isNotEmpty(shopWifiinfoList))
        {
            infosList = new ArrayList<Shopwifiinfo>();
            for (ShopWifiinfo temp : shopWifiinfoList)
            {
                Shopwifiinfo shopwifiinfo = new Shopwifiinfo();
                shopwifiinfo.setShopid(temp.getShopId());
                shopwifiinfo.setWifiinfoid(temp.getWifiInfoId());
                shopwifiinfo.setShopentityid(temp.getShopEntityId());
                shopwifiinfo.setWifissid(temp.getWifiSsid());
                shopwifiinfo.setWifimac(temp.getWifiMac());
                shopwifiinfo.setWifipassword(temp.getWifiPassword());
                shopwifiinfo.setIsdel(temp.getIsDel());
                shopwifiinfo.setCtimestamp(TimeUtils.convertDateToString(temp.getCTimeStamp(), TimeUtils.FORMAT1));
                infosList.add(shopwifiinfo);
            }
        }

        return infosList;

    }

    /**
     * 获取实体店开发票项目信息
     * @param synShopInfo 要同步的商家信息
     * @param cTimeStamp  同步时间戳
     * @param containcode 同步范围，用来判断当前要同步的信息是不是在同步范围内
     * @return
     */
    private List<Shopinvoiceinfo> getShopInvoiceInfo(String shopId, Date cTimeStamp, String containcode)
    {
        GooagooLog.info("获取实体店开发票项目信息(getShopInvoiceInfo)-->入参为:【shopId=" + shopId + " ,cTimeStamp=" + cTimeStamp + " ,containcode=" + containcode + "】");
        //        if (StringUtils.hasText(containcode))
        //        {//如果同步范围信息不为空，判断当前信息是不是在同步范围内
        //            if (!containcode.contains("a08"))
        //            {
        //                return null;
        //            }
        //        }
        ShopEntityInfoExample shopEntityInfoExample = new ShopEntityInfoExample();
        shopEntityInfoExample.createCriteria().andShopIdEqualTo(shopId);
        //查询实体店id
        List<ShopEntityInfo> shopEntityInfoList = this.shopEntityInfoGeneratorQueryService.selectByExample(shopEntityInfoExample);
        List<String> entityIdList = new ArrayList<String>();
        for (ShopEntityInfo shopEntityInfo : shopEntityInfoList)
        {
            entityIdList.add(shopEntityInfo.getShopEntityId());
        }
        //在同步范围内，查询实体店开发票项目信息
        if (CollectionUtils.isEmpty(shopEntityInfoList))
        {//商家无对应实体店信息
            GooagooLog.debug("商家【shopId=" + shopId + "】无对应实体店信息");
            return null;
        }
        ShopInvoiceInfoExample shopInvoiceInfoExample = new ShopInvoiceInfoExample();
        if (cTimeStamp != null)
        {
            shopInvoiceInfoExample.createCriteria().andShopEntityIdIn(entityIdList).andCTimeStampGreaterThan(cTimeStamp);
        }
        else
        {
            shopInvoiceInfoExample.createCriteria().andShopEntityIdIn(entityIdList);
        }

        List<ShopInvoiceInfo> shopInvoiceInfoList = this.shopInvoiceInfoGeneratorQueryService.selectByExample(shopInvoiceInfoExample);
        //封装查询到的实体店开发票项目信息
        List<Shopinvoiceinfo> infoList = null;
        if (CollectionUtils.isNotEmpty(shopInvoiceInfoList))
        {

            infoList = new ArrayList<Shopinvoiceinfo>();

            for (ShopInvoiceInfo temp : shopInvoiceInfoList)
            {
                Shopinvoiceinfo shopinvoiceinfo = new Shopinvoiceinfo();
                //商家发票基本信息
                shopinvoiceinfo.setShopid(shopId);
                shopinvoiceinfo.setShopentityid(temp.getShopEntityId());
                shopinvoiceinfo.setCtimestamp(TimeUtils.convertDateToString(temp.getCTimeStamp(), TimeUtils.FORMAT1));
                infoList.add(shopinvoiceinfo);

                List<Invoicetypec> invoicetypecList = null;
                List<Invoicetypep> invoicetypepList = null;
                //个人发票
                if (StringUtils.hasText(temp.getName1()))
                {//有个人发票信息，则封装个人发票名称信息。由List<String>类型JSON提取出来
                    invoicetypepList = new ArrayList<Invoicetypep>();//个人发票
                    List<String> personalInvoices = new Gson().fromJson(temp.getName1(), new TypeToken<List<String>>()
                    {
                    }.getType());
                    for (String personalInvoice : personalInvoices)
                    {
                        Invoicetypep invoicetypep = new Invoicetypep();
                        invoicetypep.setName(personalInvoice);
                        invoicetypepList.add(invoicetypep);
                    }
                }

                //公司发票
                if (StringUtils.hasText(temp.getName2()))
                {//有公司发票信息，则封装公司发票名称信息。由List<String>类型JSON提取出来
                    invoicetypecList = new ArrayList<Invoicetypec>();//公司发票
                    List<String> companyInvoices = new Gson().fromJson(temp.getName2(), new TypeToken<List<String>>()
                    {
                    }.getType());
                    for (String companyInvoice : companyInvoices)
                    {
                        Invoicetypec invoicetypec = new Invoicetypec();
                        invoicetypec.setName(companyInvoice);
                        invoicetypecList.add(invoicetypec);
                    }
                }

                shopinvoiceinfo.setInvoicetypep(invoicetypepList);
                shopinvoiceinfo.setInvoicetypec(invoicetypecList);

            }
        }
        return infoList;

    }

    /**
     *  获取实体店svg图信息
     * @param synShopInfo 要同步的商家信息
     * @param cTimeStamp  同步时间戳
     * @param containcode 同步范围，用来判断当前要同步的信息是不是在同步范围内
     * @return
     */
    private List<Shopsvginfo> getShopSvgInfo(String shopId, Date cTimeStamp, String containcode)
    {
        GooagooLog.info("获取实体店svg图信息(getShopSvgInfo)-->入参为:【shopId=" + shopId + " ,cTimeStamp=" + cTimeStamp + " ,containcode=" + containcode + "】");
        //        if (StringUtils.hasText(containcode))
        //        {//如果同步范围信息不为空，判断当前信息是不是在同步范围内
        //            if (!containcode.contains("a09"))
        //            {
        //                return null;
        //            }
        //        }
        //在同步范围内，查询实体店svg图信息
        AreaParaExample areaParaExample = new AreaParaExample();
        if (cTimeStamp != null)
        {
            areaParaExample.createCriteria().andShopIdEqualTo(shopId).andCTimeStampGreaterThan(cTimeStamp);
        }
        else
        {
            areaParaExample.createCriteria().andShopIdEqualTo(shopId);
        }
        List<AreaPara> areaParaList = this.areaParaGeneratorQueryService.selectByExample(areaParaExample);
        //封装查询到的实体店SVG图信息
        List<Shopsvginfo> shopsvginfoList = null;
        if (CollectionUtils.isNotEmpty(areaParaList))
        {
            shopsvginfoList = new ArrayList<Shopsvginfo>();
            for (AreaPara temp : areaParaList)
            {
                Shopsvginfo shopsvginfo = new Shopsvginfo();
                shopsvginfo.setShopid(temp.getShopId());
                shopsvginfo.setShopentityid(temp.getShopEntityId());
                shopsvginfo.setMapid(temp.getMapId());
                shopsvginfo.setMapname(temp.getMapName());
                shopsvginfo.setHtmlurl(temp.getUrlHtml());
                shopsvginfo.setIspark(temp.getIsPark());
                shopsvginfo.setIsdel(temp.getIsDel());
                shopsvginfo.setCtimestamp(TimeUtils.convertDateToString(temp.getCTimeStamp(), TimeUtils.FORMAT1));
                shopsvginfoList.add(shopsvginfo);
            }

        }
        return shopsvginfoList;

    }

    /**
     *  获取服务工具信息
     * @param synShopInfo 要同步的商家信息
     * @param cTimeStamp  同步时间戳
     * @param containcode 同步范围，用来判断当前要同步的信息是不是在同步范围内
     * @return
     */
    private List<Shoptoollist> getShopToolList(String shopId, Date cTimeStamp, String containcode)
    {
        GooagooLog.info("获取服务工具信息(getShopToolList)-->入参为:【shopId=" + shopId + " ,cTimeStamp=" + cTimeStamp + " ,containcode=" + containcode + "】");
        //        if (StringUtils.hasText(containcode))
        //        {//如果同步范围信息不为空，判断当前信息是不是在同步范围内
        //            if (!containcode.contains("a10"))
        //            {
        //                return null;
        //            }
        //        }
        List<ShopToolListBusiness> shopToolListBusinessList = this.toolQueryService.findSortServiceTool(shopId, cTimeStamp, null);
        //2)封装系统定义服务工具信息
        List<Shoptoollist> infoList = null;
        if (CollectionUtils.isNotEmpty(shopToolListBusinessList))
        {
            infoList = new ArrayList<Shoptoollist>();
            for (ShopToolListBusiness temp : shopToolListBusinessList)
            {
                Shoptoollist shoptoollist = new Shoptoollist();
                shoptoollist.setShopid(temp.getShopid());
                shoptoollist.setId(temp.getId());
                shoptoollist.setToolicofocus(temp.getToolicofocus());
                shoptoollist.setToolid(temp.getToolid());
                shoptoollist.setToolname(temp.getToolname());
                shoptoollist.setToolurl(temp.getToolurl());
                shoptoollist.setToolicounfocus(temp.getToolicounfocus());
                shoptoollist.setTooltype(temp.getTooltype());
                shoptoollist.setStatus(temp.getStatus());
                shoptoollist.setLocalcmd(temp.getLocalcmd());
                shoptoollist.setVer(temp.getVer());
                shoptoollist.setRemark(temp.getRemark());
                shoptoollist.setAuthority(temp.getAuthority());
                shoptoollist.setOrderno(temp.getOrderno());
                shoptoollist.setIsdel(temp.getIsdel());
                shoptoollist.setCtimestamp(temp.getCtimestamp());
                infoList.add(shoptoollist);
            }
        }

        return infoList;

    }

    /**
     *  获取商家会员卡基本信息
     * @param synShopInfo 要同步的商家信息
     * @param cTimeStamp  同步时间戳
     * @param containcode 同步范围，用来判断当前要同步的信息是不是在同步范围内
     * @return
     */
    private List<Membercard> getMembercardInfo(String shopId, Date cTimeStamp, String containcode)
    {
        GooagooLog.info("获取商家会员卡基本信息(getMembercardInfo)-->入参为:【shopId=" + shopId + " ,cTimeStamp=" + cTimeStamp + " ,containcode=" + containcode + "】");
        //        if (StringUtils.hasText(containcode))
        //        {//如果同步范围信息不为空，判断当前信息是不是在同步范围内
        //            if (!containcode.contains("a11"))
        //            {
        //                return null;
        //            }
        //        }
        //在同步范围内，查询商家会员卡基本信息
        MemberCardExample memberCardExample = new MemberCardExample();
        if (cTimeStamp != null)
        {
            memberCardExample.createCriteria().andShopIdEqualTo(shopId).andCTimeStampGreaterThan(cTimeStamp);
        }
        else
        {
            memberCardExample.createCriteria().andShopIdEqualTo(shopId);
        }
        List<MemberCard> memberCardList = this.memberCardGeneratorQueryService.selectByExample(memberCardExample);
        //封装查询到的商家会员卡基本信息
        List<Membercard> infoList = null;
        if (CollectionUtils.isNotEmpty(memberCardList))
        {
            infoList = new ArrayList<Membercard>();
            for (MemberCard temp : memberCardList)
            {
                Membercard membercard = new Membercard();
                membercard.setShopid(temp.getShopId());
                membercard.setCardid(temp.getCardId());
                membercard.setCardname(temp.getCardName());
                membercard.setCardtype(temp.getCardType2());
                membercard.setCardlvl(temp.getCardLvl());
                membercard.setNeedapproval(temp.getNeedApproval());
                membercard.setNeedjifen(temp.getNeedJifen().toString());
                membercard.setCardurl(temp.getCardUrl());
                membercard.setCardheadurl(UrlUtils.getAttachUrlByImg("dh_top", temp.getCardUrl()));
                membercard.setDescription(temp.getDescription());
                membercard.setUselimited(temp.getUseLimited().toString());
                membercard.setIsdel(temp.getIsDel());
                membercard.setCtimestamp(TimeUtils.convertDateToString(temp.getCTimeStamp(), TimeUtils.FORMAT1));
                infoList.add(membercard);
            }
        }
        return infoList;

    }

    /**
     *  获取购物计划商品分类信息
     * @param cTimeStamp  同步时间戳
     * @param containcode 同步范围，用来判断当前要同步的信息是不是在同步范围内
     * @return
     */
    private List<Goods> getGoodsListInfo(Date cTimeStamp, String containcode)
    {
        GooagooLog.info("获取购物计划商品分类信息(getGoodsListInfo)-->入参为:【cTimeStamp=" + cTimeStamp + " ,containcode=" + containcode + "】");
        //        if (StringUtils.hasText(containcode))
        //        {//如果同步范围信息不为空，判断当前信息是不是在同步范围内
        //            if (!containcode.contains("b01"))
        //            {
        //                return null;
        //            }
        //        }
        //在同步信息范围内,查询要同步的购物计划商品分类信息
        GoodsCategoryExample goodsCategoryExample = new GoodsCategoryExample();
        if (cTimeStamp != null)
        {//时间戳为空时，查询所有
            goodsCategoryExample.createCriteria().andCTimeStampGreaterThan(cTimeStamp);
        }
        List<GoodsCategory> goodsCategoryList = this.goodsCategoryGeneratorQueryService.selectByExample(goodsCategoryExample);
        //封装查询到的购物计划商品分类信息
        List<Goods> goodsList = null;
        if (CollectionUtils.isNotEmpty(goodsCategoryList))
        {
            goodsList = new ArrayList<Goods>();
            for (GoodsCategory temp : goodsCategoryList)
            {
                Goods goods = new Goods();
                goods.setCategoryid(temp.getCategoryId());
                goods.setCategoryname(temp.getCategoryName());
                goods.setParentcategoryid(temp.getParentCategoryId());
                goods.setIsdel(temp.getIsDel());
                if ("-1".equals(temp.getParentCategoryId()))
                {
                    goods.setPicurl(temp.getPicUrl());
                }
                else
                {
                    goods.setPicurl(null);
                }
                goods.setCtimestamp(TimeUtils.convertDateToString(temp.getCTimeStamp(), TimeUtils.FORMAT1));
                goodsList.add(goods);
            }

        }
        return goodsList;

    }

    /**
     *  获取商家类型字典信息
     * @param cTimeStamp  同步时间戳
     * @param containcode 同步范围，用来判断当前要同步的信息是不是在同步范围内
     * @return
     */
    private List<Shoptype> getShoptype(Date cTimeStamp, String containcode)
    {
        GooagooLog.info("获取商家类型字典信息(getShoptype)-->入参为:【cTimeStamp=" + cTimeStamp + " ,containcode=" + containcode + "】");

        //        //1.判断是否在同步信息范围内
        //        if (StringUtils.hasText(containcode))
        //        {//如果同步范围信息不为空，判断当前信息是不是在同步范围内
        //            if (!containcode.contains("b02"))
        //            {
        //                return null;
        //            }
        //        }

        //1.在同步信息范围内,查询要同步的商家类型字典信息
        ShopTypeExample shopTypeExample = new ShopTypeExample();
        if (cTimeStamp != null)
        {//时间戳为空时，查询所有一级商家品类
            shopTypeExample.createCriteria().andCTimeStampGreaterThan(cTimeStamp).andParentShopTypeIdEqualTo("-1");
        }
        else
        {
            shopTypeExample.createCriteria().andParentShopTypeIdEqualTo("-1");
        }
        shopTypeExample.setOrderByClause("shop_type_id desc");
        List<ShopType> shopTypeList = this.shopTypeGeneratorQueryService.selectByExample(shopTypeExample);

        //2.封装查询到的商家类型字典信息
        List<Shoptype> resultShopTypeList = null;
        if (CollectionUtils.isNotEmpty(shopTypeList))
        {
            resultShopTypeList = new ArrayList<Shoptype>();
            for (ShopType shopType : shopTypeList)
            {
                Shoptype tempShoptype = new Shoptype();
                tempShoptype.setShoptypeid(shopType.getShopTypeId().toString());
                tempShoptype.setShoptypename(shopType.getShopTypeName());
                tempShoptype.setSortorder(shopType.getSortOrder().toString());
                tempShoptype.setIsdel(shopType.getIsDel());
                tempShoptype.setCtimestamp(TimeUtils.convertDateToString(shopType.getCTimeStamp(), TimeUtils.FORMAT1));
                resultShopTypeList.add(tempShoptype);
            }
        }
        return resultShopTypeList;

    }

}
