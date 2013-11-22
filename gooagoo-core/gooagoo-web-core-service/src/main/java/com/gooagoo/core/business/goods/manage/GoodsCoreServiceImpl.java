package com.gooagoo.core.business.goods.manage;

import java.util.List;

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
import com.gooagoo.entity.generator.goods.GoodsBaseInfo;
import com.gooagoo.entity.generator.goods.GoodsBaseInfoExample;
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
    public boolean addGoodsBaseInfo(GoodsBaseInfo goodsBaseInfo) throws Exception
    {
        goodsBaseInfo.setIsDel("N");
        goodsBaseInfo.setPublishStatus("W");
        return this.goodsBaseInfoGeneratorCoreService.insertSelective(goodsBaseInfo);
    }

    @Override
    public boolean updateGoodsBaseInfo(GoodsBaseInfo goodsBaseInfo) throws Exception
    {
        goodsBaseInfo.setPublishStatus("W");
        return this.goodsBaseInfoGeneratorCoreService.updateByPrimaryKeySelective(goodsBaseInfo);
    }

    @Override
    public boolean addGoodsMarketingInfo(GoodsMarketingInfo goodsMarketingInfo) throws Exception
    {
        goodsMarketingInfo.setIsDel("N");
        return this.goodsMarketingInfoGeneratorCoreService.insertSelective(goodsMarketingInfo);
    }

    @Override
    public boolean updateGoodsMarketingInfo(GoodsMarketingInfo goodsMarketingInfo) throws Exception
    {
        return this.goodsMarketingInfoGeneratorCoreService.updateByPrimaryKeySelective(goodsMarketingInfo);
    }

    @Override
    public boolean addGoodsFeatureInfo(GoodsFeatureInfo goodsFeatureInfo) throws Exception
    {
        goodsFeatureInfo.setIsDel("N");
        return this.goodsFeatureInfoGeneratorCoreService.insertSelective(goodsFeatureInfo);
    }

    @Override
    public boolean updateGoodsFeatureInfo(GoodsFeatureInfo goodsFeatureInfo) throws Exception
    {
        return this.goodsFeatureInfoGeneratorCoreService.updateByPrimaryKeySelective(goodsFeatureInfo);
    }

    @Override
    public boolean deleteGoodsFeatureInfo(String id) throws Exception
    {
        if (!StringUtils.hasText(id))
        {
            GooagooLog.warn("删除商品特征信息：主键为空");
            return false;
        }
        return this.goodsFeatureInfoGeneratorCoreService.deleteByPrimaryKey(id);
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
        if (CollectionUtils.isNotEmpty(goodsFeatureInfoList))
        {
            for (GoodsFeatureInfo goodsFeatureInfo : goodsFeatureInfoList)
            {
                this.updateGoodsFeatureInfo(goodsFeatureInfo);
            }
        }
        else
        {
            //商品特征信息为选填 页面为空时 ，按商品id删除
            GoodsFeatureInfo goodsFeatureInfo = new GoodsFeatureInfo();
            goodsFeatureInfo.setGoodsId(goodsBaseInfo.getGoodsId());
            goodsFeatureInfo.setIsDel("Y");
            GoodsFeatureInfoExample goodsFeatureInfoExample = new GoodsFeatureInfoExample();
            goodsFeatureInfoExample.createCriteria().andGoodsIdEqualTo(goodsFeatureInfo.getGoodsId());
            return this.goodsFeatureInfoGeneratorCoreService.updateByExampleSelective(goodsFeatureInfo, goodsFeatureInfoExample);
        }
        return true;
    }
    //备用
    /*
     * private boolean addGoodsBaseInfo(GoodsBaseInfo goodsBaseInfo) throws Exception
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
        return this.goodsFeatureInfoGeneratorCoreService.insertSelective(goodsFeatureInfo);
    }

    private boolean updateGoodsFeatureInfo(GoodsFeatureInfo goodsFeatureInfo) throws Exception
    {
        return this.goodsFeatureInfoGeneratorCoreService.updateByPrimaryKeySelective(goodsFeatureInfo);
    }
     */

}
