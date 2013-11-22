package com.gooagoo.core.business.transaction.order;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.goods.cache.GoodsCacheCoreService;
import com.gooagoo.api.business.core.transaction.order.ShoppingCartCoreService;
import com.gooagoo.api.generator.core.bill.ShoppingCartGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.generator.bill.ShoppingCart;
import com.gooagoo.entity.generator.bill.ShoppingCartExample;
import com.gooagoo.exception.common.NullException;

@Service
public class ShoppingCartCoreServiceImpl implements ShoppingCartCoreService
{

    @Autowired
    private ShoppingCartGeneratorCoreService shoppingCartGeneratorCoreService;
    @Autowired
    private GoodsCacheCoreService goodsCacheCoreService;

    @Override
    public String addShoppingCart(ShoppingCart shoppingCart) throws Exception
    {
        //验证参数
        this.checkShoppingCart(shoppingCart);
        int goodsNum;
        if (shoppingCart.getGoodsNum() == null || shoppingCart.getGoodsNum() < 0)
        {
            goodsNum = 1;
        }
        else
        {
            goodsNum = shoppingCart.getGoodsNum();
        }
        //判断商品是否首次添加购物车(再次加入购物车则商品数量+1)
        ShoppingCartExample shoppingCartExample = new ShoppingCartExample();
        shoppingCartExample.createCriteria().andGoodsIdEqualTo(shoppingCart.getGoodsId()).andShopEntityIdEqualTo(shoppingCart.getShopEntityId()).andUserIdEqualTo(shoppingCart.getUserId()).andIsDelEqualTo("N");
        List<ShoppingCart> ShoppingCartList = this.shoppingCartGeneratorCoreService.selectByExample(shoppingCartExample);
        if (CollectionUtils.isNotEmpty(ShoppingCartList))
        {//购物车已存在此商品Y
            ShoppingCart shoppingCartExist = ShoppingCartList.get(0);
            shoppingCartExist.setGoodsNum(goodsNum + shoppingCartExist.getGoodsNum());
            shoppingCartExist.setCTimeStamp(null);
            this.editeShoppingCart(shoppingCartExist);
            return "Y";//购物车已存在此商品Y
        }
        //封装商品信息(Redis获取)
        Map<String, String> goodsInfo = this.goodsCacheCoreService.findGoodsInfo(shoppingCart.getGoodsId());
        if (goodsInfo == null || goodsInfo.size() == 0)
        {
            GooagooLog.debug("添加购物车信息:redis获取商品信息为空[goodsId=" + shoppingCart.getGoodsId() + "]");
            throw new NullException("添加购物车信息:redis获取商品信息为空[goodsId=" + shoppingCart.getGoodsId() + "]");
        }
        shoppingCart.setGoodsNum(goodsNum);
        shoppingCart.setId(UUID.getUUID());
        shoppingCart.setGoodsName(goodsInfo.get("goodsName"));
        shoppingCart.setGoodsCategoryRoot(goodsInfo.get("goodsCategoryRootId"));
        shoppingCart.setGoodsCategoryLeaf(goodsInfo.get("goodsCategoryLeafId"));
        shoppingCart.setGoodsBrand(goodsInfo.get("goodsBrand"));
        shoppingCart.setGoodsSerial(goodsInfo.get("goodsSerial"));
        shoppingCart.setItemSerial(goodsInfo.get("itemSerial"));
        shoppingCart.setPrice(StringUtils.isBlank(goodsInfo.get("price")) ? 0.00 : Double.parseDouble(goodsInfo.get("price")));
        shoppingCart.setGoodsImg(StringUtils.isBlank(goodsInfo.get("goodsImg")) ? null : JsonUtils.json2List(goodsInfo.get("goodsImg")).get(0));
        shoppingCart.setIsDel("N");
        this.shoppingCartGeneratorCoreService.insertSelective(shoppingCart);
        return "N";//购物车不存在此商品N
    }

    @Override
    public boolean editeShoppingCart(ShoppingCart shoppingCart) throws Exception
    {
        if (StringUtils.isBlank(shoppingCart.getId()))
        {
            throw new NullException("编辑购物车信息:购物车主键编号为空");
        }
        return this.shoppingCartGeneratorCoreService.updateByPrimaryKeySelective(shoppingCart);
    }

    @Override
    public boolean batchDeleteShoppingCart(String ids) throws Exception
    {
        List<String> idList = Arrays.asList(ids.split(","));
        ShoppingCartExample shoppingCartExample = new ShoppingCartExample();
        shoppingCartExample.createCriteria().andIdIn(idList).andIsDelEqualTo("N");
        return this.shoppingCartGeneratorCoreService.deleteByExample(shoppingCartExample);
    }

    /**
     * 验证购物车参数
     * @param shoppingCart
     * @throws NullException
     */
    private void checkShoppingCart(ShoppingCart shoppingCart) throws Exception
    {
        if (StringUtils.isBlank(shoppingCart.getGoodsId()))
        {
            throw new NullException("添加购物车信息:商品编号为空");
        }
        if (StringUtils.isBlank(shoppingCart.getUserId()))
        {
            throw new NullException("添加购物车信息:用户编号为空");
        }
        if (StringUtils.isBlank(shoppingCart.getShopEntityId()))
        {
            throw new NullException("添加购物车信息:实体店编号为空");
        }
        if (StringUtils.isBlank(shoppingCart.getShopId()))
        {
            throw new NullException("添加购物车信息:商家编号为空");
        }
    }

}
