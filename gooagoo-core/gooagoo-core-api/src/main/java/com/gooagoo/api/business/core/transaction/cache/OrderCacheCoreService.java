package com.gooagoo.api.business.core.transaction.cache;


/**
 * 从缓存中查询账单相关信息
 */
public interface OrderCacheCoreService
{
    /**
     * 接口gtsc25:平台查询博立协议的账单明细
     * @param shopEntityId 实体店编号
     * @param dataDetail 账单明细信息,格式：[ { "tablename": "111", "tablestate": "开台", "tabletypename": "标台", "diningnumbers": "2", "thirdorderid": "KT-130809-0007", "totalprice": "80", "goodsinfolist": [ { "itemserial": "02310", "goodsname": "牛肉面", "goodsnums": "1", "goodsprice": "40", "servestate": "0" }, { "itemserial": "02310", "goodsname": "牛肉面", "goodsnums": "1", "goodsprice": "40", "servestate": "0" } ] } ] 
     * @return
     * @throws Exception
     */
    public boolean addOrder(String shopEntityId, String dataDetail);
}
