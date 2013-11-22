package com.gooagoo.core.business.system.sys.dictionary;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gooagoo.api.business.core.system.sys.dictionary.ShoppingListDicCoreService;
import com.gooagoo.api.generator.core.base.ShoppingListGoodsTypeGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.base.ShoppingListGoodsType;
import com.gooagoo.exception.common.OperateFailException;
import com.google.gson.Gson;

@Service
public class ShoppingListDicCoreServiceImpl implements ShoppingListDicCoreService

{

    @Autowired
    private ShoppingListGoodsTypeGeneratorCoreService shoppingListGoodsTypeGeneratorCoreService;

    @Override
    public boolean addShoppingListDic(ShoppingListGoodsType shoppingListGoodsType) throws Exception
    {
        shoppingListGoodsType.setIsDel("N");
        return this.shoppingListGoodsTypeGeneratorCoreService.insertSelective(shoppingListGoodsType);
    }

    @Override
    public boolean updateShoppingListDic(ShoppingListGoodsType shoppingListGoodsType) throws Exception
    {
        return this.shoppingListGoodsTypeGeneratorCoreService.updateByPrimaryKeySelective(shoppingListGoodsType);
    }

    @Override
    public boolean delShoppingListDic(String goodsTypeId) throws Exception
    {
        ShoppingListGoodsType shoppingListGoodsType = new ShoppingListGoodsType();
        shoppingListGoodsType.setGoodsTypeId(Integer.parseInt(goodsTypeId));
        shoppingListGoodsType.setIsDel("Y");
        return this.shoppingListGoodsTypeGeneratorCoreService.updateByPrimaryKeySelective(shoppingListGoodsType);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean addAllShoppingListDic(List<ShoppingListGoodsType> sysList) throws Exception
    {
        if (!CollectionUtils.isNotEmpty(sysList))
        {
            GooagooLog.info("对象内容为空");
            return false;
        }
        if (!this.shoppingListGoodsTypeGeneratorCoreService.deleteByExample(null))
        {
            GooagooLog.info("清空购物清单商品类型表失败");
            throw new OperateFailException("清空购物清单商品类型表失败");
        }
        for (ShoppingListGoodsType inter : sysList)
        {
            if (!this.shoppingListGoodsTypeGeneratorCoreService.insertSelective(inter))
            {
                throw new OperateFailException("新增购物清单商品类型失败" + new Gson().toJson(inter));
            }
        }
        return true;
    }

}
