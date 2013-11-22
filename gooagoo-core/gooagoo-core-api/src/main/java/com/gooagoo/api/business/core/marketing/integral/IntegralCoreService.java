package com.gooagoo.api.business.core.marketing.integral;

import com.gooagoo.entity.generator.marketing.ShopIntegral;
import com.gooagoo.entity.generator.marketing.ShopIntegralConvert;
import com.gooagoo.entity.generator.member.IntegralDetailInfo;
import com.gooagoo.exception.business.integral.ExceedConvertNumsException;

/**
 * 积分兑换管理
*/
public interface IntegralCoreService
{

    /**
     *     6.3.2. 物品兑换
     * @param shopIntegralConvert
     * @return
     * @throws ExceedConvertNumsException 超过兑换次数异常
     */
    public boolean integralExchangeGoods(ShopIntegralConvert shopIntegralConvert) throws Exception;

    /**
     *    6.3.4. 添加积分兑换
     * @param shopIntegral
     * @return
     * @throws Exception
     */
    public boolean addIntegralExchange(ShopIntegral shopIntegral) throws Exception;

    /**
     *    6.3.5. 编辑积分兑换信息
     * @param shopIntegral
     * @return
     * @throws Exception
     */
    public boolean updateIntegralExchange(ShopIntegral shopIntegral) throws Exception;

    /**
     *   6.3.6. 删除积分兑换信息
     * @param shopIntegralId
     * @return
     * @throws Exception
     */
    public boolean deleteIntegralExchange(String shopIntegralId) throws Exception;

    /**
     *     6.3.8. 积分特批操作
     * @param parameter
     * @return
     * @throws Exception
     */
    public boolean integralSpecialApproval(String shopId, String userId, String integralNumber, String note) throws Exception;

    /**
     *  用户获得积分
     * @param integralDetailInfo
     * @return
     * @throws Exception
     */
    public boolean receiveIntegral(IntegralDetailInfo integralDetailInfo) throws Exception;

    /**
     *  发货状态更新到用户已收取货物
     * @param shopIntegralConvertId
     * @return
     * @throws Exception
     */
    public boolean updateDeliveryStatusToConfirm(String shopIntegralConvertId) throws Exception;

}
