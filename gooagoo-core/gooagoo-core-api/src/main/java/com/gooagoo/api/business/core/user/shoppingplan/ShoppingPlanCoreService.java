package com.gooagoo.api.business.core.user.shoppingplan;

import java.util.List;

import com.gooagoo.entity.generator.behave.ShoppingPlanGoods;
import com.gooagoo.entity.generator.behave.UserShoppingPlan;
import com.gooagoo.exception.common.FormatErrorException;
import com.gooagoo.exception.common.NoDataException;
import com.gooagoo.exception.common.NullException;
import com.gooagoo.exception.common.OperateFailException;

public interface ShoppingPlanCoreService

{
    /**
     * 新增购物清单
     * @param userShoppingPlan
     * @return
     * @throws NullException
     * @throws FormatErrorException
     * @throws OperateFailException
     */
    public boolean addShoppingPlan(UserShoppingPlan userShoppingPlan) throws Exception;

    /**
     * 编辑购物清单
     * @param userShoppingPlan
     * @return
     * @throws NullException
     * @throws FormatErrorException
     * @throws OperateFailException
     */
    public boolean updateShoppingPlan(UserShoppingPlan userShoppingPlan) throws Exception;

    /**
     * 删除购物清单
     * @param shoppingListId
     * @return
     * @throws NullException
     * @throws OperateFailException
     */
    public boolean deleteShoppingPlan(String shoppingListId) throws Exception;

    /**
     * 删除购物清单商品
     * @param userId
     * @param shoppingGoodsId
     * @return
     * @throws NullException
     * @throws OperateFailException
     */
    public boolean deleteShoppingPlanGoods(String shoppingGoodsId) throws Exception;

    /**
     * 加入购物清单
     * @param userId
     * @param shoppingPlanGoodsList
     * @return
     * @throws OperateFailException
     * @throws NullException
     * @throws FormatErrorException
     * @throws NoDataException
     */
    public boolean addShoppingPlanGoods(String userId, List<ShoppingPlanGoods> shoppingPlanGoodsList) throws Exception;

}
