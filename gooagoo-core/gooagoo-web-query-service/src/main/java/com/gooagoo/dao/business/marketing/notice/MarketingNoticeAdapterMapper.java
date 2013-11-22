package com.gooagoo.dao.business.marketing.notice;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.business.marketing.notice.MarketingNoticeAdapter;

public interface MarketingNoticeAdapterMapper
{

    /**
     * 分页查询用户通知信息
     * @param userId 用户编号
     * @param shopId 商家编号
     * @param pageId (推送时间+通知编号)
     * @param pageType 分页类型(N:下一页,P:上一页)
     * @param pageSize 分页大小
     * @return
     */
    public List<MarketingNoticeAdapter> pageNoticeInfo(@Param("userId") String userId, @Param("shopId") String shopId, @Param("startPushTime") Date startPushTime, @Param("endPushTime") Date endPushTime, @Param("pageId") String pageId, @Param("pageType") String pageType, @Param("pageSize") Integer pageSize);

    /**
     * 分页查询用户通知信息（手机）
     * @param userId 用户编号
     * @param shopId 商家编号
     * @param pageId (推送时间+通知编号)
     * @param pageType 分页类型(N:下一页,P:上一页)
     * @param pageSize 分页大小
     * @return
     */
    public List<MarketingNoticeAdapter> pageNoticeInfoM(@Param("userId") String userId, @Param("shopId") String shopId, @Param("startPushTime") Date startPushTime, @Param("endPushTime") Date endPushTime, @Param("pageId") String pageId, @Param("pageType") String pageType, @Param("pageSize") Integer pageSize);

    /**
     * 分页查询用户通知信息条数
     * @param userId 用户编号
     * @param shopId 商家编号
     * @param pageId (推送时间+通知编号)
     * @param pageType 分页类型(N:下一页,P:上一页)
     * @param pageSize 分页大小
     * @return
     */
    public Integer countPageNoticeInfo(@Param("userId") String userId, @Param("shopId") String shopId, @Param("startPushTime") Date startPushTime, @Param("endPushTime") Date endPushTime, @Param("pageId") String pageId, @Param("pageType") String pageType);

}
