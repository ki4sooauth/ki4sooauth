package com.gooagoo.core.protecteds.publish;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.goods.cache.GoodsCacheCoreService;
import com.gooagoo.api.business.core.shop.cache.ShopCacheCoreService;
import com.gooagoo.api.business.core.shop.cache.ShopEntityCacheCoreService;
import com.gooagoo.api.business.core.shop.map.MapCoreService;
import com.gooagoo.api.business.core.system.cms.SysCmsContentCoreService;
import com.gooagoo.api.generator.core.goods.GoodsBaseInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.goods.GoodsFeatureInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.shop.AreaParaGeneratorCoreService;
import com.gooagoo.api.generator.core.shop.ShopPositionGeneratorCoreService;
import com.gooagoo.api.generator.core.sys.TemplateInfoGeneratorCoreService;
import com.gooagoo.api.protecteds.core.publish.PublishProtectedCoreService;
import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.common.utils.MapCoordinatesUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.dao.business.goods.feature.FeatureBusinessMapper;
import com.gooagoo.entity.business.goods.GoodsFeatureBusiness;
import com.gooagoo.entity.generator.goods.GoodsBaseInfo;
import com.gooagoo.entity.generator.goods.GoodsBaseInfoExample;
import com.gooagoo.entity.generator.goods.GoodsFeatureInfo;
import com.gooagoo.entity.generator.goods.GoodsFeatureInfoExample;
import com.gooagoo.entity.generator.marketing.Coupon;
import com.gooagoo.entity.generator.marketing.MarketingActivity;
import com.gooagoo.entity.generator.marketing.MarketingEvent;
import com.gooagoo.entity.generator.shop.AreaPara;
import com.gooagoo.entity.generator.shop.AreaParaExample;
import com.gooagoo.entity.generator.shop.ShopPosition;
import com.gooagoo.entity.generator.sys.CmsContent;
import com.gooagoo.entity.generator.sys.TemplateInfo;
import com.gooagoo.exception.common.OperateFailException;

@Service
public class PublishProtectedCoreServiceImpl implements PublishProtectedCoreService
{

    @Autowired
    private TemplateInfoGeneratorCoreService templateInfoGeneratorCoreService;
    @Autowired
    private GoodsCacheCoreService goodsCacheCoreService;
    @Autowired
    private ShopCacheCoreService shopCacheCoreService;
    @Autowired
    private ShopEntityCacheCoreService shopEntityCacheCoreService;
    @Autowired
    private GoodsBaseInfoGeneratorCoreService goodsBaseInfoGeneratorCoreService;
    @Autowired
    private FeatureBusinessMapper featureBusinessMapper;
    @Autowired
    private GoodsFeatureInfoGeneratorCoreService goodsFeatureInfoGeneratorCoreService;
    @Autowired
    private SysCmsContentCoreService sysCmsContentCoreService;
    @Autowired
    private ShopPositionGeneratorCoreService shopPositionGeneratorCoreService;
    @Autowired
    private AreaParaGeneratorCoreService areaParaGeneratorCoreService;
    @Autowired
    private MapCoreService mapCoreService;

    private String pcContent = null;//网站模板内容
    private String mobileContent = null;//手机模板内容

    @Override
    public boolean generateEventOrCmsHtml(Object obj, String generateType) throws Exception
    {
        String generateurl = null;
        ResourceBundle bundle = ResourceBundle.getBundle("coreConfig");
        String objectId = null;
        String pubCon = null;
        String bse = "";//用户行为来源
        //行为对象类型:A-活动，G-商品，C-优惠凭证，Y-吆喝，N-通知，Q-购好奇，M-邮件，S-手机服务，0-cms栏目，1-cms文章，2-广告
        String bot = "";
        String bon = "";//行为对象名称
        String bsi = "";//行为对象所属商家编号
        if (obj instanceof CmsContent)
        {
            generateurl = bundle.getString("cms_generateurl");
            CmsContent cmsContent = (CmsContent) obj;
            objectId = cmsContent.getCmsContentId();
            //生成事件静态页面
            String conJson = cmsContent.getTemplateData();
            if (!StringUtils.hasText(conJson))
            {
                throw new OperateFailException("生成静态页面失败、模板内容为空[eventId=" + objectId + "]");
            }
            Map<String, String> conMap = JsonUtils.json2Map(conJson);
            pubCon = conMap.get("publish");
            if ("A".equals(cmsContent.getCmsContentType()))//文章
            {
                bot = "1";
            }
            else if ("C".equals(cmsContent.getCmsContentType()))//栏目
            {
                bot = "0";
            }
            if (StringUtils.hasText(cmsContent.getCmsContentName()))
            {
                bon = cmsContent.getCmsContentName();
            }
            bsi = cmsContent.getShopId();
        }
        else if (obj instanceof MarketingEvent)
        {
            generateurl = bundle.getString("event_generateurl");
            MarketingEvent marketingEvent = (MarketingEvent) obj;
            objectId = marketingEvent.getEventId();
            //生成事件静态页面
            String conJson = marketingEvent.getTemplateData();
            if (!StringUtils.hasText(conJson))
            {
                throw new OperateFailException("生成静态页面失败、模板内容为空[eventId=" + objectId + "]");
            }
            Map<String, String> conMap = JsonUtils.json2Map(conJson);
            pubCon = conMap.get("publish");
            if (StringUtils.hasText(marketingEvent.getEventName()))
            {
                bon = marketingEvent.getEventName();
            }
            bsi = marketingEvent.getShopId();
        }
        if (!StringUtils.hasText(objectId) || !StringUtils.hasText(pubCon) || !StringUtils.hasText(generateType))
        {
            return false;
        }
        if ("0".equals(generateType))//购好奇
        {
            bse = "1";//手机
            bot = "Q";
        }
        else if ("3".equals(generateType))//邮件
        {
            bse = "3";//网站
            bot = "M";
        }
        else if ("D".equals(generateType))//手机服务
        {
            bse = "1";//手机
            bot = "S";
        }
        else if ("W".equals(generateType))//网站
        {
            bse = "3";//网站
        }
        else if ("M".equals(generateType))//手机
        {
            bse = "1";//手机
        }
        //添加用户行为来源、行为类型、行为对象编号、行为对象类型、行为对象名称、行为对象所属商家编号、行为对象来源
        StringBuffer sb = new StringBuffer();
        sb.append("<input type='hidden' id='bse' name='bse' value='" + bse + "' />");//用户行为来源
        sb.append("<input type='hidden' id='bbt' name='bbt' value='9' />");//行为类型
        sb.append("<input type='hidden' id='bov' name='bov' value='" + objectId + "' />");//行为对象编号
        sb.append("<input type='hidden' id='bot' name='bot' value='" + bot + "' />");//行为对象类型
        sb.append("<input type='hidden' id='bon' name='bon' value='" + bon + "' />");//行为对象名称
        sb.append("<input type='hidden' id='bsi' name='bsi' value='" + bsi + "' />");//行为对象所属商家编号
        sb.append("<input type='hidden' id='bos' name='bos' value='' />");//行为对象来源
        pubCon += sb.toString();
        TemplateInfo templateInfo = this.templateInfoGeneratorCoreService.selectByPrimaryKey("3");
        String content = templateInfo.getTemplateCont();//模板内容
        if (StringUtils.hasText(content))
        {
            content = content.replaceAll("templateContent", pubCon);
        }
        if (!new File(generateurl).isDirectory())
        {
            new File(generateurl).mkdirs();
        }
        File file = new File(generateurl + objectId + ".html");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
        bw.write(content);
        bw.close();
        return true;
    }

    @Override
    public boolean generateHtml(Object obj) throws Exception
    {
        GoodsBaseInfo goodsBaseInfo = null;
        MarketingActivity marketingActivity = null;
        Coupon coupon = null;
        TemplateInfo pcTemplateInfo = null;
        TemplateInfo mobileTemplateInfo = null;
        if (obj instanceof GoodsBaseInfo)//商品
        {
            goodsBaseInfo = (GoodsBaseInfo) obj;
            pcTemplateInfo = this.templateInfoGeneratorCoreService.selectByPrimaryKey("9");
            mobileTemplateInfo = this.templateInfoGeneratorCoreService.selectByPrimaryKey("8");
        }
        else if (obj instanceof MarketingActivity)//活动
        {
            marketingActivity = (MarketingActivity) obj;
            pcTemplateInfo = this.templateInfoGeneratorCoreService.selectByPrimaryKey("6");
            mobileTemplateInfo = this.templateInfoGeneratorCoreService.selectByPrimaryKey("4");
        }
        else if (obj instanceof Coupon)//优惠券
        {
            coupon = (Coupon) obj;
            pcTemplateInfo = this.templateInfoGeneratorCoreService.selectByPrimaryKey("7");
            mobileTemplateInfo = this.templateInfoGeneratorCoreService.selectByPrimaryKey("5");
        }
        else
        {
            return false;
        }

        if (pcTemplateInfo == null || mobileTemplateInfo == null)
        {
            return false;
        }
        this.pcContent = pcTemplateInfo.getTemplateCont();//模板内容
        this.mobileContent = mobileTemplateInfo.getTemplateCont();//模板内容
        ResourceBundle bundle = ResourceBundle.getBundle("coreConfig");
        File pcFile = null;
        File mobileFile = null;
        if (goodsBaseInfo != null)
        {
            if (!new File(bundle.getString("goods_web_generateurl")).isDirectory())
            {
                new File(bundle.getString("goods_web_generateurl")).mkdirs();
            }
            if (!new File(bundle.getString("goods_mobile_generateurl")).isDirectory())
            {
                new File(bundle.getString("goods_mobile_generateurl")).mkdirs();
            }
            pcFile = new File(bundle.getString("goods_web_generateurl") + goodsBaseInfo.getGoodsId() + ".html");
            mobileFile = new File(bundle.getString("goods_mobile_generateurl") + goodsBaseInfo.getGoodsId() + ".html");
            this.replaceGoodsInfo(goodsBaseInfo, this.pcContent, this.mobileContent);//替换商品信息
        }
        else if (marketingActivity != null)
        {
            if (!new File(bundle.getString("activity_web_generateurl")).isDirectory())
            {
                new File(bundle.getString("activity_web_generateurl")).mkdirs();
            }
            if (!new File(bundle.getString("activity_mobile_generateurl")).isDirectory())
            {
                new File(bundle.getString("activity_mobile_generateurl")).mkdirs();
            }
            pcFile = new File(bundle.getString("activity_web_generateurl") + marketingActivity.getActivityId() + ".html");
            mobileFile = new File(bundle.getString("activity_mobile_generateurl") + marketingActivity.getActivityId() + ".html");
            this.replaceActivityInfo(marketingActivity, this.pcContent, this.mobileContent);//替换活动信息
        }
        else if (coupon != null)
        {
            if (!new File(bundle.getString("coupon_web_generateurl")).isDirectory())
            {
                new File(bundle.getString("coupon_web_generateurl")).mkdirs();
            }
            if (!new File(bundle.getString("coupon_mobile_generateurl")).isDirectory())
            {
                new File(bundle.getString("coupon_mobile_generateurl")).mkdirs();
            }
            pcFile = new File(bundle.getString("coupon_web_generateurl") + coupon.getCouponId() + ".html");
            mobileFile = new File(bundle.getString("coupon_mobile_generateurl") + coupon.getCouponId() + ".html");
            this.replaceCouponInfo(coupon, this.pcContent, this.mobileContent);//替换优惠券信息
        }
        else
        {
            return false;
        }
        OutputStreamWriter pcOut = new OutputStreamWriter(new FileOutputStream(pcFile));
        OutputStreamWriter mobileOut = new OutputStreamWriter(new FileOutputStream(mobileFile));
        pcOut.write(this.pcContent);
        mobileOut.write(this.mobileContent);
        pcOut.close();
        mobileOut.close();
        return true;
    }

    /**
     * 替换商品信息
     * @param goodsBaseInfo 商品信息
     * @param pcContent
     * @param mobileContent 
     * @throws Exception 
     */
    private void replaceGoodsInfo(GoodsBaseInfo goodsBaseInfo, String pcContent, String mobileContent) throws Exception
    {
        Map<String, String> goodsCache = this.goodsCacheCoreService.findGoodsInfo(goodsBaseInfo.getGoodsId());
        Map<String, String> shopCache = this.shopCacheCoreService.findShopInfo(goodsBaseInfo.getShopId());
        Map<String, String> shopEntityCache = this.shopEntityCacheCoreService.findShopEntityInfo(goodsBaseInfo.getShopEntityId());
        List<GoodsFeatureInfo> goodsFeatureInfoList = this.featureBusinessMapper.findSingleGoodsFeatureInfo(goodsBaseInfo.getShopId(), goodsBaseInfo.getGoodsSerial());
        String bigImgUrl = "";//商品主图(大图)
        String featureHtml = "";//商品特征
        String imgHtml = "";//商品图片
        String crossHtml = "";//交叉销售商品
        String relationHtml = "";//关联销售商品
        String replaceHtml = "";//可替换商品
        String contentHtml = "";//商品推荐描述
        String solutionHtml = "";//商品解决方案
        String useHtml = "";//商品使用方法
        String featureJson1 = "";//特征Json1({特征编号_特征数值:{特征编号:特征数值<List>}})
        String featureJson2 = "";//特征Json2({特征编号_特征数值_特征编号_特征数值...:商品访问地址URL})
        String featureJson3 = "";//特征Json3(特征编码排放顺序#号分隔)
        if (StringUtils.hasText(goodsCache.get("goodsImg")))
        {
            List<String> goodsImgList = JsonUtils.json2List(goodsCache.get("goodsImg"));
            bigImgUrl = UrlUtils.getAttachUrlByImg("b", goodsImgList.get(0));
            StringBuffer sb = new StringBuffer();
            if (goodsImgList.size() > 5)
            {
                sb.append("<span class='prev'></span><span class='next'></span><div class='show_box_wrap'><ul>");
            }
            else
            {
                sb.append("<span class='prev' style='z-index: -1;'></span><span class='next' style='z-index: -1;'></span><div class='show_box_wrap'><ul style='left: 0px;' >");
            }
            for (int i = 0; i < goodsImgList.size(); i++)
            {
                if (i == 0)
                {
                    sb.append("<li class='curr'><input type='hidden' value='" + UrlUtils.getAttachUrlByImg("b", goodsImgList.get(i)) + "'><img src='" + UrlUtils.getAttachUrlByImg("s", goodsImgList.get(i)) + "' width='50' height='50' style='display: block;'/></li>");
                }
                else
                {
                    sb.append("<li><input type='hidden' value='" + UrlUtils.getAttachUrlByImg("b", goodsImgList.get(i)) + "'><img src='" + UrlUtils.getAttachUrlByImg("s", goodsImgList.get(i)) + "' width='50' height='50' style='display: block;'/></li>");
                }
            }
            sb.append("</ul></div>");
            imgHtml = sb.toString();
        }
        if (CollectionUtils.isNotEmpty(goodsFeatureInfoList))
        {
            Map<String, List<String>> featureValueMap = new HashMap<String, List<String>>();
            for (GoodsFeatureInfo goodsFeatureInfo : goodsFeatureInfoList)
            {
                List<String> valueList = featureValueMap.get(goodsFeatureInfo.getFeatureCode());
                if (CollectionUtils.isNotEmpty(valueList))
                {
                    valueList.add(goodsFeatureInfo.getFeatureValue());
                }
                else
                {
                    valueList = new ArrayList<String>();
                    valueList.add(goodsFeatureInfo.getFeatureValue());
                }
                featureValueMap.put(goodsFeatureInfo.getFeatureCode(), valueList);
            }
            //封装特征Json数据
            Map<String, Map<String, List<String>>> feature1 = new HashMap<String, Map<String, List<String>>>();
            List<GoodsFeatureBusiness> featureBusinessList = new ArrayList<GoodsFeatureBusiness>();
            Map<String, String> feature2 = new HashMap<String, String>();
            Set<String> goodsIdSet = new HashSet<String>();
            feature: for (GoodsFeatureInfo goodsFeatureInfo1 : goodsFeatureInfoList)
            {
                Map<String, List<String>> map = new HashMap<String, List<String>>();
                List<String> list = null;
                for (GoodsFeatureInfo goodsFeatureInfo2 : goodsFeatureInfoList)
                {
                    if (!goodsFeatureInfo2.getFeatureCode().equals(goodsFeatureInfo1.getFeatureCode()) && goodsFeatureInfo2.getGoodsId().equals(goodsFeatureInfo1.getGoodsId()))
                    {
                        list = map.get(goodsFeatureInfo2.getFeatureCode());
                        if (CollectionUtils.isEmpty(list))
                        {
                            list = new ArrayList<String>();
                        }
                        if (!list.contains(goodsFeatureInfo2.getFeatureValue()))
                        {
                            list.add(goodsFeatureInfo2.getFeatureValue());
                        }
                        map.put(goodsFeatureInfo2.getFeatureCode(), list);
                    }
                }
                feature1.put(goodsFeatureInfo1.getFeatureCode() + "_" + goodsFeatureInfo1.getFeatureValue(), map);
                Map<String, String> goodsCacheMap = this.goodsCacheCoreService.findGoodsInfo(goodsFeatureInfo1.getGoodsId());
                if ("P".equals(goodsCacheMap.get("publishStatus")))
                {
                    goodsIdSet.add(goodsFeatureInfo1.getGoodsId());
                }
                for (GoodsFeatureBusiness item : featureBusinessList)
                {
                    if (item.getFeatureCode().equals(goodsFeatureInfo1.getFeatureCode()))
                    {
                        continue feature;
                    }
                }
                if (goodsFeatureInfo1.getGoodsId().equals(goodsBaseInfo.getGoodsId()))
                {
                    GoodsFeatureBusiness goodsFeatureBusiness = new GoodsFeatureBusiness();
                    goodsFeatureBusiness.setFeatureCode(goodsFeatureInfo1.getFeatureCode());
                    goodsFeatureBusiness.setFeatureName(goodsFeatureInfo1.getFeatureName());
                    goodsFeatureBusiness.setFeatureValueList(featureValueMap.get(goodsFeatureInfo1.getFeatureCode()));
                    featureBusinessList.add(goodsFeatureBusiness);
                }
            }
            StringBuffer featureSB = new StringBuffer();
            for (GoodsFeatureInfo feature : goodsFeatureInfoList)
            {
                if (!featureSB.toString().contains(feature.getFeatureCode()))
                {
                    featureSB.append(feature.getFeatureCode() + "#");
                }
            }
            featureJson3 = featureSB.toString().substring(0, featureSB.toString().length() - 1);
            for (String goodsId : goodsIdSet)
            {
                StringBuffer feature2Key = new StringBuffer();
                for (GoodsFeatureInfo goodsFeatureInfo : goodsFeatureInfoList)
                {

                    if (goodsId.equals(goodsFeatureInfo.getGoodsId()))
                    {

                        feature2Key.append(goodsFeatureInfo.getFeatureCode() + "_" + goodsFeatureInfo.getFeatureValue() + "#");
                    }
                }
                feature2.put(feature2Key.toString().substring(0, feature2Key.toString().length() - 1), UrlUtils.getGoodsUrl(goodsId));
            }
            if (feature2.size() == 1)
            {
                featureHtml = "<a id='favorite' href='javascript: void(0);' class='btnOrange first'>收藏</a><a href='javascript: void(0);' class='btnOrange second' onclick='javascript: doAddGoodsToShopping(\"" + goodsBaseInfo.getGoodsId() + "\", \"" + goodsBaseInfo.getGoodsName() + "\");'>加入购物清单</a>";
            }
            else
            {
                StringBuffer sb = new StringBuffer();
                sb.append("<div class='choice_box'>");
                for (GoodsFeatureBusiness goodsFeatureBusiness : featureBusinessList)
                {
                    List<String> featureValueList = goodsFeatureBusiness.getFeatureValueList();
                    if (CollectionUtils.isNotEmpty(featureValueList))
                    {
                        sb.append("<p><span>" + goodsFeatureBusiness.getFeatureName() + "：</span>");
                        for (String value : featureValueList)
                        {
                            GoodsFeatureInfoExample goodsFeatureInfoExample = new GoodsFeatureInfoExample();
                            goodsFeatureInfoExample.createCriteria().andGoodsIdEqualTo(goodsBaseInfo.getGoodsId()).andFeatureCodeEqualTo(goodsFeatureBusiness.getFeatureCode());
                            List<GoodsFeatureInfo> featureList = this.goodsFeatureInfoGeneratorCoreService.selectByExample(goodsFeatureInfoExample);
                            if (value.equals(featureList.get(0).getFeatureValue()))
                            {
                                sb.append("<a href='javascript: void(0);' class='curr'><samp>" + value + "</samp></a>");
                            }
                            else
                            {
                                sb.append("<a href='javascript: void(0);' onclick='javascript: selectSpecial(\"" + goodsFeatureBusiness.getFeatureCode() + "\", \"" + value + "\")'><samp>" + value + "</samp></a>");
                            }
                        }
                        sb.append("</p>");
                    }
                }
                sb.append("<a id='favorite' href='javascript: void(0);' class='btnOrange first'>收藏</a></c:otherwise></c:choose><a href='javascript: void(0);' class='btnOrange second' onclick='javascript: doAddGoodsToShopping(\"" + goodsBaseInfo.getGoodsId() + "\", \"" + goodsBaseInfo.getGoodsName() + "\");'>加入购物清单</a></div>");
                featureHtml = sb.toString();
            }
            featureJson1 = JsonUtils.toJson(feature1);
            featureJson2 = JsonUtils.toJson(feature2);
        }
        else
        {
            StringBuffer sb = new StringBuffer();
            sb.append("<a id='favorite' href='javascript: void(0);' class='btnOrange first'>收藏</a><a href='javascript: void(0);' class='btnOrange second' onclick='javascript: doAddGoodsToShopping(\"" + goodsBaseInfo.getGoodsId() + "\", \"" + goodsBaseInfo.getGoodsName() + "\");'>加入购物清单</a>");
            featureHtml = sb.toString();
        }
        if (StringUtils.hasText(goodsCache.get("crossGoods")))
        {
            List<String> crossGoodsList = JsonUtils.json2List(goodsCache.get("crossGoods"));
            if (CollectionUtils.isNotEmpty(crossGoodsList))
            {
                GoodsBaseInfoExample goodsBaseInfoExample = new GoodsBaseInfoExample();
                goodsBaseInfoExample.createCriteria().andGoodsIdIn(crossGoodsList).andIsDelEqualTo("N");
                List<GoodsBaseInfo> goodsBaseInfoList = this.goodsBaseInfoGeneratorCoreService.selectByExample(goodsBaseInfoExample);
                if (CollectionUtils.isNotEmpty(goodsBaseInfoList))
                {
                    StringBuffer sb = new StringBuffer();
                    sb.append("<div class='productFav_content_box'><h2><span>交叉</span><samp class='samp_1'>销售</samp><samp>商品</samp></h2><div class='subAdd'><div class='subAdd_middle'><ul>");
                    for (int i = 0; i < goodsBaseInfoList.size(); i++)
                    {
                        Map<String, String> crossGoodsCache = this.goodsCacheCoreService.findGoodsInfo(goodsBaseInfoList.get(i).getGoodsId());
                        String smallGoodsImg = "";
                        if (crossGoodsCache != null && StringUtils.hasText(crossGoodsCache.get("goodsImg")))
                        {
                            smallGoodsImg = UrlUtils.getAttachUrlByImg("s", JsonUtils.json2List(crossGoodsCache.get("goodsImg")).get(0));
                        }
                        sb.append("<li><input type='hidden' name='crossGoodsName' value='" + goodsBaseInfoList.get(i).getGoodsName() + "'/>");
                        sb.append("<input type='hidden' name='crossGoodsId' value='" + goodsBaseInfoList.get(i).getGoodsId() + "'/>");
                        sb.append("<a href='javascript: void(0);' onclick='javascript: window.open(\"" + UrlUtils.getGoodsUrl(goodsBaseInfoList.get(i).getGoodsId()) + "\", \"\");'><img src='" + smallGoodsImg + "' width='66' height='66'/></a>");
                        if (i > 0)
                        {
                            sb.append("<span>+</span>");
                        }
                        sb.append("<p class='clear'></p></li>");
                    }
                    sb.append("</ul></div><div class='subAdd_right'><a href='javascript: void(0);' class='btnOrange' onclick='javascript: doAddCrossGoodsToShopping();'>加入购物清单</a></div></div></div>");
                    crossHtml = sb.toString();
                }
            }
        }
        if (StringUtils.hasText(goodsCache.get("relationGoods")))
        {
            List<String> relationGoodsList = JsonUtils.json2List(goodsCache.get("relationGoods"));
            if (CollectionUtils.isNotEmpty(relationGoodsList))
            {
                GoodsBaseInfoExample goodsBaseInfoExample = new GoodsBaseInfoExample();
                goodsBaseInfoExample.createCriteria().andGoodsIdIn(relationGoodsList).andIsDelEqualTo("N");
                List<GoodsBaseInfo> goodsBaseInfoList = this.goodsBaseInfoGeneratorCoreService.selectByExample(goodsBaseInfoExample);
                if (CollectionUtils.isNotEmpty(goodsBaseInfoList))
                {
                    StringBuffer sb = new StringBuffer();
                    sb.append("<div class='productFav_content_box'><h2><span>关联</span><samp class='samp_1'>销售</samp><samp>商品</samp></h2><div class='subAdd'><div class='subAdd_middle'><ul>");
                    if (goodsBaseInfoList.size() == 1)
                    {
                        Map<String, String> relationGoodsCache = this.goodsCacheCoreService.findGoodsInfo(goodsBaseInfoList.get(0).getGoodsId());
                        String smallGoodsImg = "";
                        if (relationGoodsCache != null)
                        {
                            smallGoodsImg = UrlUtils.getAttachUrlByImg("s", JsonUtils.json2List(relationGoodsCache.get("goodsImg")).get(0));
                        }
                        sb.append("<li><input type='hidden' name='relationGoodsId' value='" + goodsBaseInfoList.get(0).getGoodsId() + "'/><input type='hidden' name='relationGoodsName' value='" + goodsBaseInfoList.get(0).getGoodsName() + "'/><a href='javascript: void(0);' onclick='javascript: window.open(\"" + UrlUtils.getGoodsUrl(goodsBaseInfoList.get(0).getGoodsId()) + "\", \"\");'><img src='" + smallGoodsImg + "' width='66' height='66'/></a></li>");
                    }
                    else
                    {
                        for (int i = 0; i < goodsBaseInfoList.size(); i++)
                        {
                            Map<String, String> relationGoodsCache = this.goodsCacheCoreService.findGoodsInfo(goodsBaseInfoList.get(i).getGoodsId());
                            String smallGoodsImg = "";
                            if (relationGoodsCache != null)
                            {
                                smallGoodsImg = UrlUtils.getAttachUrlByImg("s", JsonUtils.json2List(relationGoodsCache.get("goodsImg")).get(0));
                            }
                            sb.append("<li><a href='javascript: void(0);' onclick='javascript: window.open(\"" + UrlUtils.getGoodsUrl(goodsBaseInfoList.get(i).getGoodsId()) + "\", \"\");'><img src='" + smallGoodsImg + "' width='66' height='66'/></a>");
                            if (i > 0)
                            {
                                sb.append("<span>+</span>");
                            }
                            sb.append("<p class='clear'><input type='checkbox' onclick='javascript: doSelectRelationGoods(this);' value='" + goodsBaseInfoList.get(i).getGoodsId() + "|" + goodsBaseInfoList.get(i).getGoodsName() + "'/></p></li>");
                        }
                    }
                    sb.append("</ul></div><div class='subAdd_right'><a href='javascript: void(0);' class='btnOrange' onclick='javascript: doAddRelationGoodsToShopping(this);'>加入购物清单</a></div></div></div>");
                    relationHtml = sb.toString();
                }
            }
        }
        if (StringUtils.hasText(goodsCache.get("replaceGoods")))
        {
            List<String> replaceGoodsList = JsonUtils.json2List(goodsCache.get("replaceGoods"));
            if (CollectionUtils.isNotEmpty(replaceGoodsList))
            {
                GoodsBaseInfoExample goodsBaseInfoExample = new GoodsBaseInfoExample();
                goodsBaseInfoExample.createCriteria().andGoodsIdIn(replaceGoodsList).andIsDelEqualTo("N");
                List<GoodsBaseInfo> goodsBaseInfoList = this.goodsBaseInfoGeneratorCoreService.selectByExample(goodsBaseInfoExample);
                if (CollectionUtils.isNotEmpty(goodsBaseInfoList))
                {
                    StringBuffer sb = new StringBuffer();
                    sb.append("<div class='productFav_content_box'><h2><span>可替换</span><samp class='samp_1'>销售</samp><samp>商品</samp></h2><div class='subAdd'><div class='subAdd_middle'><ul>");
                    if (goodsBaseInfoList.size() == 1)
                    {
                        Map<String, String> replaceGoodsCache = this.goodsCacheCoreService.findGoodsInfo(goodsBaseInfoList.get(0).getGoodsId());
                        String smallGoodsImg = "";
                        if (replaceGoodsCache != null)
                        {
                            smallGoodsImg = UrlUtils.getAttachUrlByImg("s", JsonUtils.json2List(replaceGoodsCache.get("goodsImg")).get(0));
                        }
                        sb.append("<li><input type='hidden' name='replaceGoodsId' value='" + goodsBaseInfoList.get(0).getGoodsId() + "'/><input type='hidden' name='replaceGoodsName' value='" + goodsBaseInfoList.get(0).getGoodsName() + "'/><a href='javascript: void(0);' onclick='javascript: window.open(\"" + UrlUtils.getGoodsUrl(goodsBaseInfoList.get(0).getGoodsId()) + "\", \"\");'><img src='" + smallGoodsImg + "' width='66' height='66'/></a></li>");
                    }
                    else
                    {
                        for (int i = 0; i < goodsBaseInfoList.size(); i++)
                        {
                            Map<String, String> replaceGoodsCache = this.goodsCacheCoreService.findGoodsInfo(goodsBaseInfoList.get(i).getGoodsId());
                            String smallGoodsImg = "";
                            if (replaceGoodsCache != null)
                            {
                                smallGoodsImg = UrlUtils.getAttachUrlByImg("s", JsonUtils.json2List(replaceGoodsCache.get("goodsImg")).get(0));
                            }
                            sb.append("<li><a href='javascript: void(0);' onclick='javascript: window.open(\"" + UrlUtils.getGoodsUrl(goodsBaseInfoList.get(i).getGoodsId()) + "\", \"\");'><img src='" + smallGoodsImg + "' width='66' height='66'/></a>");
                            if (i > 0)
                            {
                                sb.append("<span>+</span>");
                            }
                            sb.append("<p class='clear'><input type='checkbox' onclick='javascript: doSelectReplaceGoods(this);' value='" + goodsBaseInfoList.get(i).getGoodsId() + "|" + goodsBaseInfoList.get(i).getGoodsName() + "'/></p></li>");
                        }
                    }
                    sb.append("</ul></div><div class='subAdd_right'><a href='javascript: void(0);' class='btnOrange' onclick='javascript: doAddReplaceGoodsToShopping(this);'>加入购物清单</a></div></div></div>");
                    replaceHtml = sb.toString();
                }
            }
        }
        if (StringUtils.hasText(goodsCache.get("goodsContent")))
        {
            StringBuffer sb = new StringBuffer();
            sb.append("<div id='goodscontent'><p class='title'><span>商品推荐描述</span><b></b></p><p class='des_content'>" + goodsCache.get("goodsContent") + "</p></div>");
            contentHtml = sb.toString();
        }
        if (StringUtils.hasText(goodsCache.get("goodsSolution")))
        {
            StringBuffer sb = new StringBuffer();
            sb.append("<div id='goodssolution'><p class='title'><span>商品解决方案</span><b></b></p><p class='des_content'>" + goodsCache.get("goodsSolution") + "</p></div>");
            solutionHtml = sb.toString();
        }
        if (StringUtils.hasText(goodsCache.get("useMessage")))
        {
            StringBuffer sb = new StringBuffer();
            sb.append("<p class='title'><span>商品使用方法</span><b></b></p><p class='des_content'>" + goodsCache.get("useMessage") + "</p>");
            useHtml = sb.toString();
        }
        //替换网站商品信息data.shopId
        this.pcContent = pcContent.replaceAll("\\$\\{data.shopId \\}", goodsBaseInfo.getShopId())//商家编号
        .replaceAll("\\$\\{data.shopName \\}", shopCache != null ? shopCache.get("shopName") : "")//商家名称
        .replaceAll("\\$\\{data.goodsId \\}", goodsBaseInfo.getGoodsId())//商品编号
        .replaceAll("\\$\\{data.goodsName \\}", goodsBaseInfo.getGoodsName())//商品名称
        .replaceAll("\\$\\{data.goodsPrice \\}", goodsCache != null && StringUtils.hasText(goodsCache.get("price")) ? new DecimalFormat("0.00").format(Double.parseDouble(goodsCache.get("price"))) : "")//商品价格
        .replaceAll("\\$\\{data.goodsAddress \\}", goodsCache != null && StringUtils.hasText(goodsCache.get("address")) ? goodsCache.get("address") : "")//商品产地
        .replaceAll("\\$\\{data.goodsVendor \\}", goodsCache != null && StringUtils.hasText(goodsCache.get("vendor")) ? goodsCache.get("vendor") : "")//商品供应商
        .replaceAll("\\$\\{data.goodsUseMessage \\}", goodsCache != null && StringUtils.hasText(goodsCache.get("useMessage")) ? goodsCache.get("useMessage") : "")//商品使用方法
        .replaceAll("\\$\\{data.goodsImageList\\[0\\].bigImgUrl \\}", bigImgUrl)//商品主图（大图）
        .replaceAll("\\$\\{data.goodsSpecial.html \\}", featureHtml)//商品特征
        .replaceAll("\\$\\{data.goodsImageList.html \\}", imgHtml)//商品图片
        .replaceAll("\\$\\{data.goodsCross.html \\}", crossHtml)//交叉销售商品
        .replaceAll("\\$\\{data.goodsRelation.html \\}", relationHtml)//关联销售商品
        .replaceAll("\\$\\{data.goodsReplace.html \\}", replaceHtml)//可替换商品
        .replaceAll("\\$\\{data.goodsContent.html \\}", contentHtml)//商品推荐描述
        .replaceAll("\\$\\{data.goodsSolution.html \\}", solutionHtml)//商品解决方案
        .replaceAll("\\$\\{data.goodsUseMessage.html \\}", useHtml)//商品使用方法
        .replaceAll("\\$\\{data.goodsFeatureJson1 \\}", featureJson1)//商品特征Json1
        .replaceAll("\\$\\{data.goodsFeatureJson2 \\}", featureJson2)//商品特征Json2
        .replaceAll("\\$\\{data.goodsFeatureJson3 \\}", featureJson3)//商品特征Json3
        .replaceAll("\\$\\{data.imgPath \\}", "http://html." + UrlUtils.getBASE_HOST())//静态资源路径
        .replaceAll("\\$\\{data.basePath \\}", "http://merchant." + UrlUtils.getBASE_HOST() + "/wm");//应用访问路径
        //替换手机商品信息
        String mobileContentHtml = "";//内容
        String mobilePhoneHtml = "";//手机
        String shopVisitUrl = this.sysCmsContentCoreService.getCmsContentUrl(goodsBaseInfo.getShopId(), "M");//虚拟商家地址
        String mobileScriptHtml = "";//位置脚本
        String shopEntityLocation = "";//实体店位置
        if (StringUtils.hasText(goodsCache.get("goodsContent")))
        {
            StringBuffer sb = new StringBuffer();
            sb.append("<section><div class='productIntroduce'><h3>商品介绍：<span id='moreInt'>更多描述></span></h3><p>" + goodsCache.get("goodsContent") + "</p></div></section>");
            mobileContentHtml = sb.toString();
        }
        if (shopEntityCache != null && StringUtils.hasText(shopEntityCache.get("phone")))
        {
            StringBuffer sb = new StringBuffer();
            sb.append("<a href='tel:" + shopEntityCache.get("phone") + "' class='sectionA'><span class='icon-location-2'></span><span class='icon-location'></span>" + shopEntityCache.get("phone") + "</a>");
            mobilePhoneHtml = sb.toString();
        }
        else if (shopEntityCache != null && StringUtils.hasText(shopEntityCache.get("mobile")))
        {
            StringBuffer sb = new StringBuffer();
            sb.append("<a href='tel:" + shopEntityCache.get("mobile") + "' class='sectionA'><span class='icon-location-2'></span><span class='icon-location'></span>" + shopEntityCache.get("mobile") + "</a>");
            mobilePhoneHtml = sb.toString();
        }
        if (goodsCache != null && shopEntityCache != null)
        {
            String positionName = "";//位置名称(位置编号+父位置编号......)
            List<ShopPosition> list = new ArrayList<ShopPosition>();
            this.recursionFindParentPositionId(list, goodsCache.get("positionId"));
            if (CollectionUtils.isNotEmpty(list))
            {
                for (int i = list.size() - 1; i >= 0; i--)
                {
                    positionName += list.get(i).getPositionName();
                }
                for (ShopPosition shopPosition : list)
                {
                    AreaParaExample areaParaExample = new AreaParaExample();
                    areaParaExample.createCriteria().andPositionIdEqualTo(shopPosition.getPositionId()).andShopIdEqualTo(shopPosition.getShopId()).andShopEntityIdEqualTo(shopPosition.getShopEntityId()).andIsDelEqualTo("N");
                    List<AreaPara> areaParaList = this.areaParaGeneratorCoreService.selectByExample(areaParaExample);
                    if (CollectionUtils.isNotEmpty(areaParaList))
                    {
                        AreaPara areaPara = areaParaList.get(0);
                        List<String> gridList = this.mapCoreService.findGridFromPosition(goodsCache.get("positionId"));
                        if (CollectionUtils.isNotEmpty(gridList))
                        {
                            Double[] coordinateXY = MapCoordinatesUtils.getSvgCentralCoordinate(gridList, areaPara.getRatioGrid(), areaPara.getRatioSvg());
                            mobileScriptHtml = "<a href=\"javascript: void(0);\" onclick=\"javascript: toMapByApp('" + areaPara.getMapId() + "','" + coordinateXY[0].toString() + "','" + coordinateXY[1].toString() + "','" + goodsBaseInfo.getShopId() + "','" + goodsBaseInfo.getShopEntityId() + "');\" class=\"sectionA\"><span class=\"icon-location-2\"></span><b></b>" + positionName + "</a>";
                        }
                        break;
                    }
                }
            }
        }
        if (shopEntityCache != null && StringUtils.hasText(shopEntityCache.get("shopGpsBaidux")) && StringUtils.hasText(shopEntityCache.get("shopGpsBaiduy")) && StringUtils.hasText(shopEntityCache.get("shopRoadGuide")))
        {
            shopEntityLocation = "<a href='http://html.gooagoo.com/gus/merchant/mobile/html/baidumap.html?x=" + shopEntityCache.get("shopGpsBaidux") + "&y=" + shopEntityCache.get("shopGpsBaiduy") + "' class='sectionA'><span class='icon-location-2'></span><span class='icon-location-4'></span>" + shopEntityCache.get("shopRoadGuide") + "</a>";
        }
        if (!StringUtils.hasText(shopVisitUrl))
        {
            shopVisitUrl = "javascript: void(0);";
        }
        this.mobileContent = mobileContent.replaceAll("\\$\\{data.goodsId \\}", goodsBaseInfo.getGoodsId())//商品ID
        .replaceAll("\\$\\{data.goodsName \\}", goodsBaseInfo.getGoodsName())//商品名称
        .replaceAll("\\$\\{data.shopId \\}", goodsBaseInfo.getShopId())//商家编号
        .replaceAll("\\$\\{data.shopVisitUrl \\}", shopVisitUrl)//虚拟店铺地址
        .replaceAll("\\$\\{data.shopHeadPic.smallImgUrl \\}", shopCache != null ? UrlUtils.getAttachUrlByImg("s", shopCache.get("logo2")) : "")//商家LOGO（长方形小图）
        .replaceAll("\\$\\{data.shopName \\}", shopCache != null ? shopCache.get("shopName") : "")//商家名称
        .replaceAll("\\$\\{data.goodsImage.bigImgUrl \\}", goodsCache != null && StringUtils.hasText(goodsCache.get("goodsImg")) ? UrlUtils.getAttachUrlByImg("b", JsonUtils.json2List(goodsCache.get("goodsImg")).get(0)) : "")//商品图片（大图）
        //.replaceAll("\\$\\{data.goodsBrandName \\}", goodsCache != null && StringUtils.hasText(goodsCache.get("brandName")) ? goodsCache.get("brandName") : "")//商品品牌名称
        .replaceAll("\\$\\{data.goodsPrice \\}", goodsCache != null && StringUtils.hasText(goodsCache.get("price")) ? new DecimalFormat("0.00").format(Double.parseDouble(goodsCache.get("price"))) : "")//商品价格
        .replaceAll("\\$\\{data.goodsDes \\}", mobileContentHtml)//商品介绍
        .replaceAll("\\$\\{data.shopEntityPhone \\}", mobilePhoneHtml)//商品所在实体店电话
        .replaceAll("\\$\\{data.shopEntityId \\}", goodsBaseInfo.getShopEntityId())//实体店编号
        .replaceAll("\\$\\{data.positionId \\}", goodsCache != null && StringUtils.hasText(goodsCache.get("positionId")) ? goodsCache.get("positionId") : "")//位置编号
        .replaceAll("\\$\\{data.toMap \\}", StringUtils.hasText(mobileScriptHtml) ? mobileScriptHtml : "")//地图脚本
        .replaceAll("\\$\\{data.shopEntityLocation \\}", StringUtils.hasText(shopEntityLocation) ? shopEntityLocation : "")//实体店位置
        .replaceAll("\\$\\{data.imgPath \\}", "http://html." + UrlUtils.getBASE_HOST())//静态资源路径
        .replaceAll("\\$\\{data.basePath \\}", "http://merchant." + UrlUtils.getBASE_HOST() + "/wm");//应用访问路径
    }

    /**
     * 替换活动信息
     * @param marketingActivity 活动信息
     * @param pcContent
     * @param mobileContent
     * @throws Exception 
     */
    private void replaceActivityInfo(MarketingActivity marketingActivity, String pcContent, String mobileContent) throws Exception
    {
        Map<String, String> shopCache = this.shopCacheCoreService.findShopInfo(marketingActivity.getShopId());
        //虚拟店铺地址
        String shopVisitUrl = this.sysCmsContentCoreService.getCmsContentUrl(marketingActivity.getShopId(), "M");
        if (!StringUtils.hasText(shopVisitUrl))
        {
            shopVisitUrl = "javascript: void(0);";
        }
        //替换网站活动信息
        this.pcContent = pcContent.replaceAll("\\$\\{data.activeId \\}", marketingActivity.getActivityId())//活动ID
        .replaceAll("\\$\\{data.activeName \\}", marketingActivity.getActivityName())//活动名称
        .replaceAll("\\$\\{data.shopId \\}", marketingActivity.getShopId())//商家编号
        .replaceAll("\\$\\{data.activeImage.bigImgUrl \\}", UrlUtils.getAttachUrlByImg("b", marketingActivity.getImgUrl()))//活动图片（大图）
        .replaceAll("\\$\\{data.activeTitle \\}", marketingActivity.getTitle())//活动主题
        .replaceAll("\\$\\{data.activeContent \\}", marketingActivity.getContent())//活动内容
        .replaceAll("\\$\\{data.activePurpose \\}", marketingActivity.getPurpose())//活动目的
        .replaceAll("\\$\\{data.activeDes \\}", marketingActivity.getDescription())//活动描述
        .replaceAll("\\$\\{data.shopName \\}", shopCache != null ? shopCache.get("shopName") : "")//活动商家
        .replaceAll("\\$\\{data.activeStartTime \\}", marketingActivity.getStartTime() != null ? TimeUtils.convertDateToString(marketingActivity.getStartTime(), TimeUtils.FORMAT8) : "")//活动开始时间（格式yyyy-MM-dd）
        .replaceAll("\\$\\{data.activeEndTime \\}", marketingActivity.getEndTime() != null ? TimeUtils.convertDateToString(marketingActivity.getEndTime(), TimeUtils.FORMAT8) : "")//活动结束时间（格式yyyy-MM-dd）
        .replaceAll("\\$\\{data.imgPath \\}", "http://html." + UrlUtils.getBASE_HOST())//静态资源路径
        .replaceAll("\\$\\{data.basePath \\}", "http://merchant." + UrlUtils.getBASE_HOST() + "/wm");//应用访问路径
        //替换手机活动信息
        this.mobileContent = mobileContent.replaceAll("\\$\\{data.activeId \\}", marketingActivity.getActivityId())//活动ID
        .replaceAll("\\$\\{data.activeName \\}", marketingActivity.getActivityName())//活动名称
        .replaceAll("\\$\\{data.shopId \\}", marketingActivity.getShopId())//商家编号
        .replaceAll("\\$\\{data.shopVisitUrl \\}", shopVisitUrl)//虚拟店铺地址
        .replaceAll("\\$\\{data.shopHeadPic.smallImgUrl \\}", shopCache != null ? UrlUtils.getAttachUrlByImg("s", shopCache.get("logo2")) : "")//商家LOGO（长方形小图）
        .replaceAll("\\$\\{data.shopName \\}", shopCache != null ? shopCache.get("shopName") : "")//商家名称
        .replaceAll("\\$\\{data.activeImage.bigImgUrl \\}", UrlUtils.getAttachUrlByImg("b", marketingActivity.getImgUrl()))//活动图片（大图）
        .replaceAll("\\$\\{data.activeTitle \\}", marketingActivity.getTitle())//活动主题
        .replaceAll("\\$\\{data.activeDes \\}", marketingActivity.getDescription())//活动描述
        .replaceAll("\\$\\{data.activeStartTime \\}", marketingActivity.getStartTime() != null ? TimeUtils.convertDateToString(marketingActivity.getStartTime(), TimeUtils.FORMAT8) : "")//活动开始时间（格式yyyy-MM-dd）
        .replaceAll("\\$\\{data.activeEndTime \\}", marketingActivity.getEndTime() != null ? TimeUtils.convertDateToString(marketingActivity.getEndTime(), TimeUtils.FORMAT8) : "")//活动结束时间（格式yyyy-MM-dd）
        .replaceAll("\\$\\{data.imgPath \\}", "http://html." + UrlUtils.getBASE_HOST())//静态资源路径
        .replaceAll("\\$\\{data.basePath \\}", "http://merchant." + UrlUtils.getBASE_HOST() + "/wm");//应用访问路径
    }

    /**
     * 替换优惠券信息
     * @param coupon 优惠券信息
     * @param pcContent
     * @param mobileContent
     * @throws Exception 
     */
    private void replaceCouponInfo(Coupon coupon, String pcContent, String mobileContent) throws Exception
    {
        Map<String, String> shopCache = this.shopCacheCoreService.findShopInfo(coupon.getShopId());
        String couponValue = "";
        if ("C".equals(coupon.getCouponType()))//代金券
        {

            couponValue = coupon.getCouponValue() != null ? "￥" + new DecimalFormat("0.00").format(coupon.getCouponValue()) : "";
        }
        else if ("D".equals(coupon.getCouponType()))//折扣券
        {
            couponValue = coupon.getCouponValue() != null ? String.valueOf(coupon.getCouponValue()).length() == 3 ? String.valueOf(coupon.getCouponValue() * 10).substring(0, 1) + "折" : String.valueOf(coupon.getCouponValue() * 10) + "折" : "";
        }
        //虚拟店铺地址
        String shopVisitUrl = this.sysCmsContentCoreService.getCmsContentUrl(coupon.getShopId(), "M");
        if (!StringUtils.hasText(shopVisitUrl))
        {
            shopVisitUrl = "javascript: void(0);";
        }
        //替换网站优惠券信息
        this.pcContent = pcContent.replaceAll("\\$\\{data.couponId \\}", coupon.getCouponId())//优惠凭证ID
        .replaceAll("\\$\\{data.couponName \\}", coupon.getCouponName())//优惠凭证名称
        .replaceAll("\\$\\{data.shopId \\}", coupon.getShopId())//商家编号
        .replaceAll("\\$\\{data.couponChannel \\}", coupon.getCouponChannle())//优惠凭证渠道（积分商城、精准投放、收藏广场）
        .replaceAll("\\$\\{data.couponImage.bigImgUrl \\}", UrlUtils.getAttachUrlByImg("b", coupon.getCouponUrl()))//优惠凭证图片（大图）
        .replaceAll("\\$\\{data.shopName \\}", shopCache != null ? shopCache.get("shopName") : "")//发行商家
        .replaceAll("\\$\\{data.couponType \\}", "C".equals(coupon.getCouponType()) ? "代金券" : "折扣券")//优惠凭证类型（代金券、折扣券）
        .replaceAll("\\$\\{data.couponValue \\}", couponValue)//优惠凭证额度
        .replaceAll("\\$\\{data.maxNumOwner \\}", coupon.getMaxNumOwner() != null ? coupon.getMaxNumOwner().toString() : "0")//优惠凭证个人最多收藏数量
        .replaceAll("\\$\\{data.couponUseStartTime \\}", coupon.getUseStartTime() != null ? TimeUtils.convertDateToString(coupon.getUseStartTime(), TimeUtils.FORMAT8) : "")//优惠凭证使用开始时间（格式yyyy-MM-dd）
        .replaceAll("\\$\\{data.couponUseEndTime \\}", coupon.getUseEndTime() != null ? TimeUtils.convertDateToString(coupon.getUseEndTime(), TimeUtils.FORMAT8) : "")//优惠凭证使用结束时间（格式yyyy-MM-dd）
        .replaceAll("\\$\\{data.couponPulishStartTime \\}", coupon.getPublishStartTime() != null ? TimeUtils.convertDateToString(coupon.getPublishStartTime(), TimeUtils.FORMAT8) : "")//优惠凭证使用开始时间（格式yyyy-MM-dd）
        .replaceAll("\\$\\{data.couponPublishEndTime \\}", coupon.getPublishEndTime() != null ? TimeUtils.convertDateToString(coupon.getPublishEndTime(), TimeUtils.FORMAT8) : "")//优惠凭证发行结束时间（格式yyyy-MM-dd）
        .replaceAll("\\$\\{data.couponContent \\}", coupon.getCouponContent())//优惠凭证内容
        .replaceAll("\\$\\{data.imgPath \\}", "http://html." + UrlUtils.getBASE_HOST())//静态资源路径
        .replaceAll("\\$\\{data.basePath \\}", "http://merchant." + UrlUtils.getBASE_HOST() + "/wm");//应用访问路径
        //替换手机优惠券信息
        this.mobileContent = mobileContent.replaceAll("\\$\\{data.couponId \\}", coupon.getCouponId())//优惠凭证ID
        .replaceAll("\\$\\{data.couponName \\}", coupon.getCouponName())//优惠凭证名称
        .replaceAll("\\$\\{data.shopId \\}", coupon.getShopId())//商家编号
        .replaceAll("\\$\\{data.couponChannel \\}", coupon.getCouponChannle())//优惠凭证渠道（积分商城、精准投放、收藏广场）
        .replaceAll("\\$\\{data.shopVisitUrl \\}", shopVisitUrl)//虚拟店铺地址
        .replaceAll("\\$\\{data.shopHeadPic.smallImgUrl \\}", shopCache != null ? UrlUtils.getAttachUrlByImg("s", shopCache.get("logo2")) : "")//商家LOGO（长方形小图）
        .replaceAll("\\$\\{data.shopName \\}", shopCache != null ? shopCache.get("shopName") : "")//商家名称
        .replaceAll("\\$\\{data.couponImage.bigImgUrl \\}", UrlUtils.getAttachUrlByImg("b", coupon.getCouponUrl()))//优惠凭证图片（大图）
        .replaceAll("\\$\\{data.couponType \\}", "C".equals(coupon.getCouponType()) ? "代金券" : "折扣券")//优惠凭证类别（代金券、折扣券）
        .replaceAll("\\$\\{data.couponValue \\}", couponValue)//优惠凭证额度
        .replaceAll("\\$\\{data.couponContent \\}", coupon.getCouponContent())//优惠凭证内容
        .replaceAll("\\$\\{data.imgPath \\}", "http://html." + UrlUtils.getBASE_HOST())//静态资源路径
        .replaceAll("\\$\\{data.basePath \\}", "http://merchant." + UrlUtils.getBASE_HOST() + "/wm");//应用访问路径
    }

    /**递归查询父位置信息(包含当前位置信息)
     * @param List<ShopPosition>
     * @param parentPositionId
     */
    private void recursionFindParentPositionId(List<ShopPosition> list, String parentPositionId)
    {
        ShopPosition shopPosition = this.shopPositionGeneratorCoreService.selectUnDelByPrimaryKey(parentPositionId);
        if (shopPosition != null)
        {
            list.add(shopPosition);
            if (!"-1".equals(shopPosition.getParentPositionId()))
            {
                this.recursionFindParentPositionId(list, shopPosition.getParentPositionId());
            }
        }
    }

}
