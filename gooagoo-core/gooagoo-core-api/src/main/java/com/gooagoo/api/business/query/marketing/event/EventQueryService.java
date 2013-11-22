package com.gooagoo.api.business.query.marketing.event;


public interface EventQueryService
{

    /**
     *         6.6.5. 查看事件详情
     * @param parameter
     * @return
     * @throws Exception
     */
    public boolean findEventDetail(String parameter) throws Exception;

    /**
     *  
     6.6.6. 查询事件列表（分页）
     * @param parameter
     * @return
     * @throws Exception
     */
    public boolean findEventList(String parameter) throws Exception;

}
