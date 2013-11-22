package com.gooagoo.api.business.query.user.shoppingplan;

import java.util.List;
import java.util.Map;

import com.gooagoo.entity.business.user.ShoppingPlanDetailStepA;
import com.gooagoo.exception.common.FormatErrorException;
import com.gooagoo.exception.common.OperateFailException;

/**
 * 购物清单
 */
public interface ShoppingPlanQueryService
{

    /**
     * 购物清单批量同步第一步
     * @param userId 用户编号
     * @param List<Map<String, String>> shoppinglistid购物清单编号,ctimestamp最后修改时间
     * @return ShoppingPlanDetailStepA
     * @throws OperateFailException
     * @throws FormatErrorException
     */
    public ShoppingPlanDetailStepA shoppingPlanSynStepA(String userId, List<Map<String, String>> usershoppingplan) throws Exception;

    /**
     *  购物清单列表（分页）
     * @throws Exception
     */
    public void findShoppingPlanList() throws Exception;

    /**
     * 购物清单商品列表
     * @throws Exception
     */
    public void findShoppingPlanGoodsList() throws Exception;

    /**
     * 购物清单商品类型列表
     * @throws Exception
     */
    public void findShoppingPlanGoodsTypeList() throws Exception;

}
