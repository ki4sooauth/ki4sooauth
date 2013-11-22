package com.gooagoo.dao.business.marketing.cryout;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.business.marketing.cryout.CryoutInfoAdapter;

public interface CryoutInfoAdapterMapper
{

    /**
     * 分页查询用户商家吆喝
     * @param userId 用户编号
     * @param shopIdList 商家编号
     * @param cryoutType 吆喝类型
     * @param pageId (推送时间+营销内容与用户关联表主键)
     * @param pageType 分页类型(N:下一页,P:上一页)
     * @param pageSize 分页大小
     * @return
     */
    public List<CryoutInfoAdapter> pageShopCryoutInfo(@Param("userId") String userId, @Param("shopIdList") List<String> shopIdList, @Param("cryoutType") String cryoutType, @Param("pageId") String pageId, @Param("pageType") String pageType, @Param("pageSize") Integer pageSize);

    /**
     * 分页查询用户商家吆喝（手机）
     * @param userId 用户编号
     * @param shopIdList 商家编号
     * @param cryoutType 吆喝类型
     * @param pageId (推送时间+营销内容与用户关联表主键)
     * @param pageType 分页类型(N:下一页,P:上一页)
     * @param pageSize 分页大小
     * @return
     */
    public List<CryoutInfoAdapter> pageShopCryoutInfoM(@Param("userId") String userId, @Param("shopIdList") List<String> shopIdList, @Param("cryoutType") String cryoutType, @Param("pageId") String pageId, @Param("pageType") String pageType, @Param("pageSize") Integer pageSize);

    /**
     * 查询用户商家吆喝（手机）条数
     * @param userId 用户编号
     * @param shopIdList 商家编号
     * @param cryoutType 吆喝类型
     * @param pageId (推送时间+营销内容与用户关联表主键)
     * @param pageType 分页类型(N:下一页,P:上一页)
     * @return
     */
    public Integer countPageShopCryoutInfoForMobile(@Param("userId") String userId, @Param("shopIdList") List<String> shopIdList, @Param("cryoutType") String cryoutType, @Param("pageId") String pageId, @Param("pageType") String pageType);
}
