package com.gooagoo.api.business.query.marketing.cryout;

import java.util.List;

import com.gooagoo.entity.business.marketing.cryout.ShopCryoutInfo;
import com.gooagoo.entity.business.marketing.cryout.ShopCryoutInfoBusiness;

public interface CryoutQueryService
{

    /**
     * 商家吆喝（分页）
     * mobc01,mobc06
     * @param source 来源
     * @param userId 用户编号
     * @param shopId 商家编号
     * @param shopType 商家类型
     * @param cryoutType 吆喝类型
     * @param pageId 第一次为空  第二次分页时候需要将返回对象中的pageId传过来
     * @param pageType 分页类型 N上一页 P下一页
     * @param pageSize 分页大小
     * @param cTimeStamp 最大时间戳 yyyy-MM-dd HH:mm:ss
     * @return
     * @throws Exception
     */
    public ShopCryoutInfoBusiness findCryoutList(String source, String userId, String shopId, String shopType, String cryoutType, String pageId, String pageType, Integer pageSize, String cTimeStamp) throws Exception;

    /**
     *  6.4.10. 他们在说（通过模型分析）
     * @param parameter
     * @return
     * @throws Exception
     */
    public List<ShopCryoutInfo> findCryoutOther(String userId) throws Exception;

}
