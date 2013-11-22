package com.gooagoo.api.business.query.shop.query;

import java.util.List;
import java.util.Map;

import com.gooagoo.entity.business.goods.ShopGoodsDetailInfo;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.gooagoo.entity.generator.shop.ShopInfo;
import com.gooagoo.entity.generator.shop.ShopUserInfo;

public interface ShopQueryService
{
    /**
     *  查询商家信息
     * @param shopId
     * @throws Exception
     */
    public void findShopInfo(String shopId) throws Exception;

    /**
     * 获取商家的详细信息（登录）
     * @param shopInfo
     * @param shopUserInfo
     * @return
     */
    public ShopLoginInfo getShopLoginInfo(ShopInfo shopInfo, ShopUserInfo shopUserInfo);

    /**
     * 获取商家页面文字字典表
     * @param version 版本号
     * @return
     */
    public Map<String, String> getShopInterfaceNamesByShopType(String version);

    /**
     * 校验商家状态（未删除、正常营业返回true，其他返回false）
     * @param shopId
     * @return
     */
    public boolean checkShopStatus(String shopId, String shopEntityId);

    /**
     * 商家商品信息分页查询
     * @param shopId 商家编号(必填)
     * @param shopEntityId 实体店编号
     * @param goodsItemSerial 商品自定义序列号
     * @param goodsName 商品名称
     * @param goodsBrand 品牌编号
     * @param goodsCategory 品类编号
     * @param pageIndex (必填)
     * @param pageSize (必填)
     * @return
     */
    public List<ShopGoodsDetailInfo> pageShopGoodsDetailInfo(String shopId, String shopEntityId, String goodsItemSerial, String goodsName, String goodsBrand, String goodsCategory, Integer pageIndex, Integer pageSize);

    /**
     * 查询商家商品信息总记录数
     * @param shopId 商家编号(必填)
     * @param shopEntityId 实体店编号
     * @param goodsItemSerial 商品自定义序列号
     * @param goodsName 商品名称
     * @param goodsBrand 品牌编号
     * @param goodsCategory 品类编号
     * @param pageIndex (必填)
     * @param pageSize (必填)
     * @return
     */
    public Integer countShopGoodsDetailInfo(String shopId, String shopEntityId, String goodsItemSerial, String goodsName, String goodsBrand, String goodsCategory, Integer pageIndex, Integer pageSize);

}
