package com.gooagoo.mobile.api;

import com.gooagoo.mobile.entity.mobb01.transform.FavoriteListgRoot;
import com.gooagoo.mobile.entity.mobb03.transform.VoucherDetailRoot;
import com.gooagoo.mobile.entity.mobb04.transform.GoodsDetailRoot;
import com.gooagoo.mobile.entity.mobb05.transform.UserCommentRoot;
import com.gooagoo.mobile.entity.mobb06.transform.FavoritePlazaMenuRoot;
import com.gooagoo.mobile.entity.mobb07.transform.FavoritePlazaRoot;
import com.gooagoo.mobile.entity.mobb08.transform.ChoiceListRoot;
import com.gooagoo.mobile.entity.mobb10.transform.FavoriteRecommendRoot;

/**
 * 收藏相关接口
 * 如果接口入参同时存在userId,sessionId,则需要先校验是否登录
 */
public interface FavoriateMobileService
{
    /**
     * 接口 mobb01 : 收藏列表（Gooagoo服务器） 
     * 当shopId或者shopEntityId有值时查询本店（本商家）收藏
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param cTimeStamp 最大时间戳
     * @param favoriateId 收藏编号
     * @param shopId 商家编号
     * @param shopEnityId 实体店编号
     * @param type 收藏类型
     * @param pageType 翻页类型
     * @param pageSize 每页显示信息条数
     * @return
     * @throws Exception
     */
    public FavoriteListgRoot getFavoritesOfGooagoo(String userId, String sessionId, String shopId, String shopEnityId, String cTimeStamp, String favoriateId, String type, String pageType, String pageSize) throws Exception;

    /**
     * 接口 mobb02 : 添加收藏 
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param adtype
     * @param shopadid
     * @param adurl 信息的url，商品、活动、优惠的访问地址;可通过解码此参数得到adtype信息ID
     * @return
     * @throws Exception
     */
    public boolean addFavorites(String userId, String sessionId, String adtype, String shopadid, String adurl) throws Exception;

    /**
     * 接口 mobb03 : 获取优惠劵信息 
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param favoriateId 多个编号，以“逗号”隔开，例如：123,4324,2123
     * @return
     * @throws Exception
     */
    public VoucherDetailRoot getCouponInfo(String userId, String sessionId, String favoriateId) throws Exception;

    /**
     * 接口 mobb04 : 获取商品详细信息及评论
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param goodsId 商品信息 ，格式：逗号分隔的字符串，如1,2,3
     * @param pageIndex 页码
     * @param pageSize 每页信息显示条数
     * @return
     * @throws Exception
     */
    public GoodsDetailRoot getGoodsDetailInfo(String userId, String sessionId, String goodsId, String pageIndex, String pageSize) throws Exception;

    /**
     * 接口 mobb05 : 获取商品所有评论
     * @param goodsId 商品编号
     * @param pageIndex 页码
     * @param pageSize 每页信息显示条数
     * @return
     * @throws Exception
     */
    public UserCommentRoot getUserComments(String goodsId, String pageIndex, String pageSize) throws Exception;

    /**
     * 接口 mobb06 : 收藏广场列表侧边栏
     * @return
     * @throws Exception
     */
    public FavoritePlazaMenuRoot getFavoritePlazaMenu() throws Exception;

    /**
     * 接口 mobb07 : 收藏广场列表（查询）
     * @param userId 用户编号，为空时表示为登录，有值时，针对用户查询收藏
     * @param keyWord 查询的关键字，用于模糊查询，如：商品名称、优惠券名称、活动名称
     * @param type 查询分类编号，对应收藏广场菜单编码
     * @return
     * @throws Exception
     */
    public FavoritePlazaRoot getFavoritePlazaListInfo(String userId, String keyWord, String type, String pageIndex, String pageSize) throws Exception;

    /**
     * 接口 mobb08 : 商家的精品查询
     * @param shopId 商家编号
     * @param userId 用户编号
     * @param type 查询的类型，G-商品（精品），C-优惠凭证，A-活动
     * @param pageIndex 页码
     * @param pageSize 每页信息显示条数
     * @return
     * @throws Exception
     */
    public ChoiceListRoot getChoiceList(String userId, String shopId, String type, String pageIndex, String pageSize) throws Exception;

    /**
     * 接口 mobb09 : 用户关注商家
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param shopId
     * @return
     * @throws Exception
     */
    public boolean userAttentionShop(String userId, String sessionId, String shopId) throws Exception;

    /**
     * 接口 mobb10 : 搜索收藏推荐
     * @param userId 用户编号
     * @param keyword 关键字，用来模糊查询，如：推荐的活动名称、商品名称、优惠券名称
     * @return
     * @throws Exception
     */
    public FavoriteRecommendRoot getFavoriteRecommend(String userId, String type, String pageIndex, String pageSize) throws Exception;

    /**
     * 接口 mobb11 : 手机端删除用户收藏接口 
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param favoriteId 收藏信息编号，如有多个以逗号分隔，如：1,2,3
     * @return
     * @throws Exception
     */
    public void DelUserFavoriate(String userId, String sessionId, String favoriteId) throws Exception;

    /**
     * 接口 mobb12 : 查询用户可用优惠券数量
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param shopid 商家编号
     * @return
     * @throws Exception
     */
    public Integer GetUserUserableCouponNums(String userId, String sessionId, String shopId) throws Exception;

}
