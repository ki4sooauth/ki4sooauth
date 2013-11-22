package com.gooagoo.api.business.core.marketing.user;

import com.gooagoo.entity.generator.marketing.MarketingUserLink;
import com.gooagoo.entity.generator.marketing.MarketingUserLinkExample;

public interface MarketingUserLinkCoreService
{

    /**
     * 此方法对应数据库表marketing_user_link用于往表中添加数据
     * @param marketingUserLink 插入数据
     * @return true-添加数据成功 false-添加数据失败
     */
    public boolean insertSelective(MarketingUserLink marketingUserLink);

    /**
     * 此方法对应数据库表marketing_user_link用于更新数据，其中 create_time不提供修改功能， c_time_stamp自动设置为当前数据库时间
     * @param marketingUserLink 更新数据
     * @param marketingUserLinkExample 更新条件
     * @return true-更新数据成功 false-更新数据失败
     */
    public boolean updateByExampleSelective(MarketingUserLink marketingUserLink, MarketingUserLinkExample marketingUserLinkExample);

    /**
     * 此方法对应数据库表marketing_user_link用于更新数据，其中 create_time不提供修改功能， c_time_stamp自动设置为当前数据库时间
     * @param marketingUserLink 更新条件
     * @return true-更新数据成功 false-更新数据失败
     */
    public boolean updateByPrimaryKeySelective(MarketingUserLink marketingUserLink);

}
