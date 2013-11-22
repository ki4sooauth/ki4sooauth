package com.gooagoo.api.business.core.user.shoppingplan;

import java.util.List;
import java.util.Map;

import com.gooagoo.entity.business.user.ShoppingPlanDetailStepB;
import com.gooagoo.entity.business.user.shoppingplan.ShoppingplanInfoBusiness;
import com.gooagoo.exception.common.OperateFailException;

/**
 * 购物清单同步
 */
public interface ShoppingPlanSynCoreService
{

    /**
     * 计划列表与服务器同步（单条）
     * mobd01
     * @param userId 用户编号
     * @param userShoppingplanGoods 购物计划商品列表
     * @return ShoppingplanBusiness
     * @throws Exception
     */
    public ShoppingplanInfoBusiness getSingleUserShoppingplan(String userId, String userShoppingplanGoods) throws Exception;

    /**
     * 购物清单批量同步第二步
     * @param List<ShoppingPlanDetail>
     * @return List<Map<String, String>> 只有在同步添加过时才返回,否则返回null
     * @throws OperateFailException
     */
    public List<Map<String, String>> shoppingPlanSynStepB(List<ShoppingPlanDetailStepB> shoppingPlanDetailList) throws Exception;

}
