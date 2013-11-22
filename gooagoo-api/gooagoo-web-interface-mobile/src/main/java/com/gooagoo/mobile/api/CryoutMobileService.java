package com.gooagoo.mobile.api;

import com.gooagoo.mobile.entity.mobc01.transform.CryoutListgRoot;
import com.gooagoo.mobile.entity.mobc02.transform.CryoutPlazaRoot;
import com.gooagoo.mobile.entity.mobc03.transform.CryoutPlazaShopListRoot;
import com.gooagoo.mobile.entity.mobc04.transform.CryoutPlazaShopRoot;
import com.gooagoo.mobile.entity.mobc05.transform.BoutiqueRecommendRoot;
import com.gooagoo.mobile.entity.mobc07.transform.RecommendCryoutListRoot;

/**
 * 吆喝相关接口
 * 如果接口接口入参同时存在userId,sessionId,则需要先校验是否登录
 */
public interface CryoutMobileService
{

    /**
     * 接口 mobc01 : 商家吆喝(Gooagoo服务器) 
     * @param shopId 商家编号
     * @param userId 用户编号
     * @param cryoutInfoId
     * @param pageType P-旧吆喝;N-新吆喝
     * @param pageSize 默认值为50
     * @param type A-全部商家;B-会员商家;C-关注商家;D-周边商家;E-系统吆喝
     * @param infotype 吆喝的类型 G-商品、A-活动、C-优惠凭证
     * @param gpsx 经度 
     * @param gpsy 经度
     * @param cTimeStamp 最大时间戳
     * @return
     */
    public CryoutListgRoot getCryoutListg(String shopId, String userId, String cryoutInfoId, String pageType, String pageSize, String type, String gpsx, String gpsy, String infotype, String cTimeStamp) throws Exception;

    /**
     * 接口 mobc02 : 吆喝广场侧边栏分类 
     * @return
     * @throws Exception
     */
    public CryoutPlazaRoot getCryoutPlazaMenu() throws Exception;

    /**
     * 接口 mobc03 : 吆喝广场商家列表
     * @param keyword 关键字，主要用该按商家名称模糊查询
     * @param type 分类编码
     * @param pageIndex 页码
     * @param pageSize 每页信息显示条数
     * @return
     * @throws Exception
     */
    public CryoutPlazaShopListRoot getCryoutPlazaShopList(String keyword, String type, String pageIndex, String pageSize) throws Exception;

    /**
     * 接口 mobc04 : 吆喝广场商家详情查询
     * @param shopId 商家编号
     * @return
     * @throws Exception
     */
    public CryoutPlazaShopRoot getCryoutPlazaShopRoot(String shopId) throws Exception;

    /**
     * 接口 mobc05 : 吆喝广场下精品推荐
     * @param userId 用户编号
     * @param shopId 商家编号
     * @param type 信息的类型 G-商品（精品），C-优惠凭证，A-活动
     * @param pageIndex 页码
     * @param pageSize 每页信息显示条数
     * @return
     * @throws Exception
     */
    public BoutiqueRecommendRoot getBoutiqueRecommend(String userId, String shopId, String type, String pageIndex, String pageSize) throws Exception;

    /**
     * 接口 mobc07 : 吆喝商家推荐吆喝 
     * @param userId
     * @return
     */
    public RecommendCryoutListRoot getRecommendCryoutList(String userId) throws Exception;

}
