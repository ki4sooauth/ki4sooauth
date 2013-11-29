package com.gooagoo.core.business.goods.manage;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.goods.manage.GoodsCoreService;
import com.gooagoo.api.generator.core.goods.GoodsBaseInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.goods.GoodsFeatureInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.goods.GoodsMarketingInfoGeneratorCoreService;
import com.gooagoo.api.protecteds.core.publish.PublishProtectedCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.thread.PublishGoodsThread;
import com.gooagoo.entity.generator.goods.GoodsBaseInfo;
import com.gooagoo.entity.generator.goods.GoodsBaseInfoExample;
import com.gooagoo.entity.generator.goods.GoodsBaseInfoExample.Criteria;
import com.gooagoo.entity.generator.goods.GoodsFeatureInfo;
import com.gooagoo.entity.generator.goods.GoodsFeatureInfoExample;
import com.gooagoo.entity.generator.goods.GoodsMarketingInfo;
import com.gooagoo.exception.GooagooException;
import com.gooagoo.exception.common.NullException;
import com.gooagoo.exception.common.OperateFailException;

@Service
public class GoodsCoreServiceImpl implements GoodsCoreService
{
    @Autowired
    private GoodsBaseInfoGeneratorCoreService goodsBaseInfoGeneratorCoreService;
    @Autowired
    private GoodsFeatureInfoGeneratorCoreService goodsFeatureInfoGeneratorCoreService;
    @Autowired
    private GoodsMarketingInfoGeneratorCoreService goodsMarketingInfoGeneratorCoreService;
    @Autowired
    private PublishProtectedCoreService publishProtectedCoreService;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean deleteGoodsInfo(String goodsId) throws Exception
    {
        boolean isOk = false;
        if (!StringUtils.hasText(goodsId))
        {
            GooagooLog.warn("删除商品信息时，goodsId为空：goodsId=" + goodsId);
            return false;
        }
        //删除商品特征信息
        GoodsFeatureInfoExample goodsFeatureInfoExample = new GoodsFeatureInfoExample();
        goodsFeatureInfoExample.createCriteria().andGoodsIdEqualTo(goodsId);
        this.goodsFeatureInfoGeneratorCoreService.deleteByExample(goodsFeatureInfoExample);
        //删除商品营销信息
        this.goodsMarketingInfoGeneratorCoreService.deleteByPrimaryKey(goodsId);
        //删除商品基本信息
        isOk = this.goodsBaseInfoGeneratorCoreService.deleteByPrimaryKey(goodsId);
        if (!isOk)
        {
            GooagooLog.warn("删除商品信息失败，goodsId=" + goodsId);
            throw new OperateFailException("删除商品信息失败");
        }
        return isOk;
    }

    @Override
    public boolean reviewedActivity(String goodsId, String status, String note) throws Exception
    {
        GoodsBaseInfo goodsBaseInfo = this.goodsBaseInfoGeneratorCoreService.selectByPrimaryKey(goodsId);
        if (goodsBaseInfo == null)
        {
            GooagooLog.warn("审核商品：商品不存在，goodsId=" + goodsId);
            return false;
        }
        if (!"W".equals(goodsBaseInfo.getPublishStatus()))
        {
            GooagooLog.warn("审核商品：商品状态不是待审核，goodsId=" + goodsId + ",publishStatus=" + goodsBaseInfo.getPublishStatus());
            return false;
        }
        goodsBaseInfo = new GoodsBaseInfo();
        goodsBaseInfo.setGoodsId(goodsId);
        goodsBaseInfo.setAuditNote(note);
        if ("Y".equals(status))
        {
            goodsBaseInfo.setPublishStatus("A");
        }
        else
        {
            goodsBaseInfo.setPublishStatus("B");
        }
        return this.goodsBaseInfoGeneratorCoreService.updateByPrimaryKeySelective(goodsBaseInfo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean addGoodsInfo(GoodsBaseInfo goodsBaseInfo, GoodsMarketingInfo goodsMarketingInfo, List<GoodsFeatureInfo> goodsFeatureInfoList) throws Exception
    {
        if (goodsBaseInfo == null)
        {
            throw new NullException("添加商品信息（删除商品基本、营销、特征信息）goodsBaseInfo为空");
        }
        if (goodsMarketingInfo == null)
        {
            throw new NullException("添加商品信息（删除商品基本、营销、特征信息）goodsMarketingInfo为空");
        }
        this.addGoodsBaseInfo(goodsBaseInfo);
        this.addGoodsMarketingInfo(goodsMarketingInfo);
        if (CollectionUtils.isNotEmpty(goodsFeatureInfoList))
        {
            for (GoodsFeatureInfo goodsFeatureInfo : goodsFeatureInfoList)
            {
                this.addGoodsFeatureInfo(goodsFeatureInfo);
            }
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean updateGoodsInfo(GoodsBaseInfo goodsBaseInfo, GoodsMarketingInfo goodsMarketingInfo, List<GoodsFeatureInfo> goodsFeatureInfoList) throws Exception
    {
        if (goodsBaseInfo == null)
        {
            throw new NullException("更新商品信息（删除商品基本、营销、特征信息）goodsBaseInfo为空");
        }
        if (goodsMarketingInfo == null)
        {
            throw new NullException("更新商品信息（删除商品基本、营销、特征信息）goodsMarketingInfo为空");
        }
        this.updateGoodsBaseInfo(goodsBaseInfo);
        this.updateGoodsMarketingInfo(goodsMarketingInfo);
        //删除商品特征信息
        GoodsFeatureInfoExample goodsFeatureInfoExample = new GoodsFeatureInfoExample();
        goodsFeatureInfoExample.createCriteria().andGoodsIdEqualTo(goodsBaseInfo.getGoodsId());
        this.goodsFeatureInfoGeneratorCoreService.deleteByExample(goodsFeatureInfoExample);
        //添加商品特征信息
        if (CollectionUtils.isNotEmpty(goodsFeatureInfoList))
        {
            for (GoodsFeatureInfo goodsFeatureInfo : goodsFeatureInfoList)
            {
                this.addGoodsFeatureInfo(goodsFeatureInfo);
            }
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean publishGoods(String goodsId) throws Exception
    {
        GoodsBaseInfo goodsBaseInfo = this.goodsBaseInfoGeneratorCoreService.selectByPrimaryKey(goodsId);
        if (goodsBaseInfo == null)
        {
            GooagooLog.warn("审核商品：商品不存在，goodsId=" + goodsId);
            return false;
        }
        if (!"A".equals(goodsBaseInfo.getPublishStatus()))
        {
            GooagooLog.warn("审核活动：活动状态不是待审核，goodsId=" + goodsId + ",publishStatus=" + goodsBaseInfo.getPublishStatus());
            return false;
        }
        goodsBaseInfo.setPublishStatus("P");

        if (!this.goodsBaseInfoGeneratorCoreService.updateByPrimaryKeySelective(goodsBaseInfo))
        {
            GooagooLog.info("发布商品失败[goodsId=" + goodsId + "]");
            return false;
        }
        GoodsBaseInfoExample goodsBaseInfoExample = new GoodsBaseInfoExample();
        goodsBaseInfoExample.createCriteria().andShopIdEqualTo(goodsBaseInfo.getShopId()).andGoodsSerialEqualTo(goodsBaseInfo.getGoodsSerial()).andPublishStatusEqualTo("P").andIsDelEqualTo("N");
        List<GoodsBaseInfo> goodsList = this.goodsBaseInfoGeneratorCoreService.selectByExample(goodsBaseInfoExample);
        for (GoodsBaseInfo goods : goodsList)
        {
            if (!this.publishProtectedCoreService.generateHtml(goods))
            {
                GooagooLog.info("生成商品静态页面失败[goodsId=" + goods.getGoodsId() + "]");
                throw new GooagooException("生成商品静态页面失败[goodsId=" + goods.getGoodsId() + "]");
            }
        }
        return true;
    }

    @Override
    public boolean anewPublishGoods(String goodsId) throws Exception
    {
        GoodsBaseInfo goodsBaseInfo = this.goodsBaseInfoGeneratorCoreService.selectByPrimaryKey(goodsId);
        if (goodsBaseInfo == null)
        {
            GooagooLog.warn("审核商品：商品不存在，goodsId=" + goodsId);
            return false;
        }
        return this.publishProtectedCoreService.generateHtml(goodsBaseInfo);
    }

    @Override
    public boolean anewAllPublishGoods(String shopId, String shopEntityId) throws Exception
    {
        GoodsBaseInfoExample goodsBaseInfoExample = new GoodsBaseInfoExample();
        Criteria criteria = goodsBaseInfoExample.createCriteria().andPublishStatusEqualTo("P").andIsDelEqualTo("N");
        if (StringUtils.hasText(shopId))
        {
            criteria.andShopIdEqualTo(shopId);
        }
        else if (StringUtils.hasText(shopEntityId))
        {
            criteria.andShopEntityIdEqualTo(shopEntityId);
        }
        else
        {
            return false;
        }
        List<GoodsBaseInfo> list = this.goodsBaseInfoGeneratorCoreService.selectByExample(goodsBaseInfoExample);
        if (CollectionUtils.isEmpty(list))
        {
            return false;
        }
        ResourceBundle bundle = ResourceBundle.getBundle("coreConfig");
        Integer goodsNum = Integer.parseInt(bundle.getString("goods_number_thread"));
        //每goodsNum个商品开启一个线程
        for (int fromIndex = 0; fromIndex < list.size(); fromIndex += goodsNum)
        {
            int toIndex = fromIndex + goodsNum;
            if (toIndex > list.size())
            {
                toIndex = list.size();
            }
            new PublishGoodsThread(list.subList(fromIndex, toIndex), this.publishProtectedCoreService).run();
        }
        return true;
    }

    private boolean addGoodsBaseInfo(GoodsBaseInfo goodsBaseInfo) throws Exception
    {
        goodsBaseInfo.setIsDel("N");
        goodsBaseInfo.setPublishStatus("W");
        return this.goodsBaseInfoGeneratorCoreService.insertSelective(goodsBaseInfo);
    }

    private boolean updateGoodsBaseInfo(GoodsBaseInfo goodsBaseInfo) throws Exception
    {
        goodsBaseInfo.setPublishStatus("W");
        return this.goodsBaseInfoGeneratorCoreService.updateByPrimaryKeySelective(goodsBaseInfo);
    }

    private boolean addGoodsMarketingInfo(GoodsMarketingInfo goodsMarketingInfo) throws Exception
    {
        goodsMarketingInfo.setIsDel("N");
        return this.goodsMarketingInfoGeneratorCoreService.insertSelective(goodsMarketingInfo);
    }

    private boolean updateGoodsMarketingInfo(GoodsMarketingInfo goodsMarketingInfo) throws Exception
    {
        return this.goodsMarketingInfoGeneratorCoreService.updateByPrimaryKeySelective(goodsMarketingInfo);
    }

    private boolean addGoodsFeatureInfo(GoodsFeatureInfo goodsFeatureInfo) throws Exception
    {
        goodsFeatureInfo.setIsDel("N");
        goodsFeatureInfo.setCreateTime(null);
        goodsFeatureInfo.setCTimeStamp(null);
        return this.goodsFeatureInfoGeneratorCoreService.insertSelective(goodsFeatureInfo);
    }

    public static void main(String[] args)
    {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");
        for (int fromIndex = 0; fromIndex < list.size(); fromIndex += 3)
        {
            int toIndex = fromIndex + 3;
            if (toIndex > list.size())
            {
                toIndex = list.size();
            }
            System.out.println(list.subList(fromIndex, toIndex));
        }

    }
}