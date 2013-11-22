package com.gooagoo.api.business.core.user.queue;

import java.util.List;

import com.gooagoo.entity.business.user.QueueBusiness;
import com.gooagoo.exception.business.behave.AlreadyArrangedException;
import com.gooagoo.exception.business.behave.NotNeedArrangeException;

/**
 * 排号
 */
public interface QueueCoreService
{
    /**
     * 用餐排号
     * gasj02,mobe13
     * @param shopEntityId 实体店编号
     * @param scardno 会员卡音频编号
     * @param userId 用户编号
     * @param tableTypeCode 餐桌类型
     * @param persianNums 用餐人数
     * @return QueueBusiness 排号信息
     * @throws AlreadyArrangedException 已排号异常
     * @throws NotNeedArrangeException 无需排号异常(已有空闲餐桌无需排号)
     */
    public QueueBusiness arranging(String shopId, String shopEntityId, String scardno, String userId, String tableTypeCode, String persianNums) throws Exception;

    /**
     * 刷新排号
     * @param userId 用户编号
     * @param shopEntityId 实体店编号
     * @return QueueBusiness 排号信息
     * @throws Exception
     */
    public List<QueueBusiness> refreshArranging(String userId, String shopEntityId) throws Exception;
}
