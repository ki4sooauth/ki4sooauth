package com.gooagoo.api.business.query.statistics;

import java.util.List;

import com.gooagoo.entity.business.statistics.ColumnVO;
import com.gooagoo.entity.business.user.account.Account;

public interface StatisticAnalysisService
{
    /**
     * 购物周期统计
     * @param shopId 商家实体店标识
     * @param startDate 开始日期：YYYY-MM-DD
     * @param endDate 结束日期：YYYY-MM-DD
     * @param accounts 统计群体
     * @param uuid 标识一次统计的唯一性
     * @return
     */
    public List<ColumnVO> getShoppingPeriod(String shopId, String startDate, String endDate, List<Account> accounts,String uuid);

    /**
     * 到店频率统计
     * @param shopId 商家实体店标识
     * @param startDate 开始日期：YYYY-MM-DD
     * @param endDate 结束日期：YYYY-MM-DD
     * @param accounts 统计群体
     * @param uuid 标识一次统计的唯一性
     * @return
     */
    public List<ColumnVO> getNumberOfArriveShop(String shopId, String startDate, String endDate, List<Account> accounts,String uuid);

    /**
     * 购买转化率统计
     * @param shopId 商家实体店标识
     * @param startDate 开始日期：YYYY-MM-DD
     * @param endDate 结束日期：YYYY-MM-DD
     * @param accounts 统计群体
     * @param uuid 标识一次统计的唯一性
     * @return
     */
    public List<ColumnVO> getRateOfPurchase(String shopId, String startDate, String endDate, List<Account> accounts,String uuid);

    /**
     * 平均客单价统计
     * @param shopId 商家实体店标识
     * @param startDate 开始日期：YYYY-MM-DD
     * @param endDate 结束日期：YYYY-MM-DD
     * @param accounts 统计群体
     * @param uuid 标识一次统计的唯一性
     * @return
     */
    public List<ColumnVO> getAveragePriceRange(String shopId, String startDate, String endDate, List<Account> accounts,String uuid);

    /**
     * 优惠浏览频次统计
     * @param shopId 商家实体店标识
     * @param startDate 开始日期：YYYY-MM-DD
     * @param endDate 结束日期：YYYY-MM-DD
     * @param accounts 统计群体
     * @param uuid 标识一次统计的唯一性
     * @return
     */
    public List<ColumnVO> getBrowseCouponsFrequency(String shopId, String startDate, String endDate, List<Account> accounts,String uuid);

    /**
     * 手机互动频次统计
     * @param shopId 商家实体店标识
     * @param startDate 开始日期：YYYY-MM-DD
     * @param endDate 结束日期：YYYY-MM-DD
     * @param accounts 统计群体
     * @param uuid 标识一次统计的唯一性
     * @return
     */
    public List<ColumnVO> getPhoneInteractionFrequency(String shopId, String startDate, String endDate, List<Account> accounts,String uuid);

    /**
     * 吆喝打开频次统计
     * @param shopId 商家实体店标识
     * @param startDate 开始日期：YYYY-MM-DD
     * @param endDate 结束日期：YYYY-MM-DD
     * @param accounts 统计群体
     * @param uuid 标识一次统计的唯一性
     * @return
     */
    public List<ColumnVO> getOpenCryoutFrequency(String shopId, String startDate, String endDate, List<Account> accounts,String uuid);

    /**
     * 优惠收藏频次统计
     * @param shopId 商家实体店标识
     * @param startDate 开始日期：YYYY-MM-DD
     * @param endDate 结束日期：YYYY-MM-DD
     * @param accounts 统计群体
     * @param uuid 标识一次统计的唯一性
     * @return
     */
    public List<ColumnVO> getCollectionCouponsFrequency(String shopId, String startDate, String endDate, List<Account> accounts,String uuid);

    /**
     * 吆喝响应时间统计
     * @param shopId 商家实体店标识
     * @param startDate 开始日期：YYYY-MM-DD
     * @param endDate 结束日期：YYYY-MM-DD
     * @param accounts 统计群体
     * @param uuid 标识一次统计的唯一性
     * @return
     */
    public List<ColumnVO> getCryoutResponseTime(String shopId, String startDate, String endDate, List<Account> accounts,String uuid);

    /**
     * 通知响应时间统计
     * @param shopId 商家实体店标识
     * @param startDate 开始日期：YYYY-MM-DD
     * @param endDate 结束日期：YYYY-MM-DD
     * @param accounts 统计群体
     * @param uuid 标识一次统计的唯一性
     * @return
     */
    public List<ColumnVO> getNoticeResponseTime(String shopId, String startDate, String endDate, List<Account> accounts,String uuid);

    /**
     * 收藏对象品类统计
     * @param shopId 商家实体店标识
     * @param startDate 开始日期：YYYY-MM-DD
     * @param endDate 结束日期：YYYY-MM-DD
     * @param accounts 统计群体
     * @param uuid 标识一次统计的唯一性
     * @return
     */
    public List<ColumnVO> getFavoritesCategory(String shopId, String startDate, String endDate, List<Account> accounts,String uuid);

    /**
     * 历史消费品类统计
     * @param shopId 商家实体店标识
     * @param startDate 开始日期：YYYY-MM-DD
     * @param endDate 结束日期：YYYY-MM-DD
     * @param accounts 统计群体
     * @param uuid 标识一次统计的唯一性
     * @return
     */
    public List<ColumnVO> getConsumeCategory(String shopId, String startDate, String endDate, List<Account> accounts,String uuid);
}
