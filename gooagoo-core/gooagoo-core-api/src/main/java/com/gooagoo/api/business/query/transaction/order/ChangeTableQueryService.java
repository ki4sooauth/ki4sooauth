package com.gooagoo.api.business.query.transaction.order;

import java.util.List;
import java.util.Map;

public interface ChangeTableQueryService
{

    /**
     * 商家查询换台请求
     * @param mac
     * @param shopEntityId
     * @param ctimestamp
     * @throws Exception
     */
    public List<Map<String, String>> findExchangeTable(String mac, String shopEntityId, String ctimestamp) throws Exception;

    /**
     * 商家查询并台请求
     * @param mac
     * @param shopEntityId
     * @param ctimestamp
     * @throws Exception
     */
    public List<Map<String, String>> findMergeTable(String mac, String shopEntityId, String ctimestamp) throws Exception;
}
