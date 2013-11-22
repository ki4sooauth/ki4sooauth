package com.gooagoo.core.business.system.sys.dictionary;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gooagoo.api.business.core.system.sys.dictionary.BoutiqueSquareDicCoreService;
import com.gooagoo.api.generator.core.base.QualitySquareGoodsTypeGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.base.QualitySquareGoodsType;
import com.gooagoo.exception.common.OperateFailException;
import com.google.gson.Gson;

@Service
public class BoutiqueSquareDicCoreServiceImpl implements BoutiqueSquareDicCoreService

{

    @Autowired
    private QualitySquareGoodsTypeGeneratorCoreService qualitySquareGoodsTypeGeneratorCoreService;

    @Override
    public boolean addBoutiqueSquareDic(QualitySquareGoodsType qualitySquareGoodsType) throws Exception
    {
        qualitySquareGoodsType.setIsDel("N");
        return this.qualitySquareGoodsTypeGeneratorCoreService.insertSelective(qualitySquareGoodsType);
    }

    @Override
    public boolean updateBoutiqueSquareDic(QualitySquareGoodsType qualitySquareGoodsType) throws Exception
    {
        return this.qualitySquareGoodsTypeGeneratorCoreService.updateByPrimaryKeySelective(qualitySquareGoodsType);
    }

    @Override
    public boolean delBoutiqueSquareDic(String goodsTypeId) throws Exception
    {
        QualitySquareGoodsType qualitySquareGoodsType = new QualitySquareGoodsType();
        qualitySquareGoodsType.setGoodsTypeId(Integer.parseInt(goodsTypeId));
        qualitySquareGoodsType.setIsDel("Y");
        return this.qualitySquareGoodsTypeGeneratorCoreService.updateByPrimaryKeySelective(qualitySquareGoodsType);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean addAllBoutiqueSquareDic(List<QualitySquareGoodsType> sysList) throws Exception
    {
        if (!CollectionUtils.isNotEmpty(sysList))
        {
            GooagooLog.info("对象内容为空");
            return false;
        }
        if (!this.qualitySquareGoodsTypeGeneratorCoreService.deleteByExample(null))
        {
            GooagooLog.info("清空精品广场商品类型表失败");
            throw new OperateFailException("清空精品广场商品类型表失败");
        }
        for (QualitySquareGoodsType inter : sysList)
        {
            if (!this.qualitySquareGoodsTypeGeneratorCoreService.insertSelective(inter))
            {
                throw new OperateFailException("新增精品广场商品类型失败" + new Gson().toJson(inter));
            }
        }
        return true;
    }

}
