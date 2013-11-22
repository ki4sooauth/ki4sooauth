package com.gooagoo.api.business.query.marketing.shortmessage;


public interface ShortMessageQueryService
{

    /**
     *      6.5.5. 查看短信详情
     * @param parameter
     * @return
     * @throws Exception
     */
    public boolean findShortMessageDetail(String parameter) throws Exception;

    /**
     *  
     6.5.6. 查询短信列表（分页）
     * @param parameter
     * @return
     * @throws Exception
     */
    public boolean findShortMessageList(String parameter) throws Exception;
}
