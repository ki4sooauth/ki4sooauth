package com.gooagoo.core.business.user.shoppingplan;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gooagoo.api.business.core.goods.cache.GoodsCacheCoreService;
import com.gooagoo.api.business.core.user.shoppingplan.ShoppingPlanCoreService;
import com.gooagoo.api.generator.core.behave.ShoppingPlanGoodsGeneratorCoreService;
import com.gooagoo.api.generator.core.behave.UserShoppingPlanGeneratorCoreService;
import com.gooagoo.api.protecteds.core.user.UserProtectedCoreService;
import com.gooagoo.cache.SysdictionaryCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.generator.behave.ShoppingPlanGoods;
import com.gooagoo.entity.generator.behave.ShoppingPlanGoodsExample;
import com.gooagoo.entity.generator.behave.UserShoppingPlan;
import com.gooagoo.entity.generator.behave.UserShoppingPlanExample;
import com.gooagoo.exception.business.user.NoShoppingPlanException;
import com.gooagoo.exception.common.FormatErrorException;
import com.gooagoo.exception.common.NullException;
import com.gooagoo.exception.common.OperateFailException;

@Service
public class ShoppingPlanCoreServiceImpl implements ShoppingPlanCoreService

{

    @Autowired
    private UserShoppingPlanGeneratorCoreService userShoppingPlanGeneratorCoreService;

    @Autowired
    private ShoppingPlanGoodsGeneratorCoreService shoppingPlanGoodsGeneratorCoreService;

    @Autowired
    private UserProtectedCoreService userProtectedCoreService;

    @Autowired
    private GoodsCacheCoreService goodsCacheCoreService;

    @Override
    public boolean addShoppingPlan(UserShoppingPlan userShoppingPlan) throws Exception
    {
        //1、数据正确性校验
        this.checkAddShoppingPlanData(userShoppingPlan);
        //2、数据补充
        userShoppingPlan.setShoppingListId(UUID.getUUID());
        userShoppingPlan.setIsDel("N");
        //3、保存购物清单
        if (!this.userShoppingPlanGeneratorCoreService.insertSelective(userShoppingPlan))
        {
            GooagooLog.error("新增购物清单：保存购物清单（" + userShoppingPlan.toString() + "）异常", null);
            throw new OperateFailException("保存购物清单（" + userShoppingPlan.toString() + "）异常");
        }

        return true;
    }

    @Override
    public boolean updateShoppingPlan(UserShoppingPlan userShoppingPlan) throws Exception
    {
        //1、数据正确性校验
        this.checkUpdateShoppingPlanData(userShoppingPlan);
        //2、更新购物清单
        if (!this.userShoppingPlanGeneratorCoreService.updateByPrimaryKeySelective(userShoppingPlan))
        {
            GooagooLog.error("编辑购物清单：更新购物清单（" + userShoppingPlan.toString() + "）异常", null);
            throw new OperateFailException(userShoppingPlan.toString());
        }

        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean deleteShoppingPlan(String shoppingListId) throws Exception
    {
        //1、数据正确性校验
        this.checkDeleteShoppingPlanData(shoppingListId);
        //2、删除购物清单
        if (!this.userShoppingPlanGeneratorCoreService.deleteByPrimaryKey(shoppingListId))
        {
            GooagooLog.error("删除购物清单：删除购物清单（" + shoppingListId + "）异常", null);
            throw new OperateFailException("删除购物清单（" + shoppingListId + "）异常");
        }
        //3、删除购物清单商品
        ShoppingPlanGoodsExample shoppingPlanGoodsExample = new ShoppingPlanGoodsExample();
        shoppingPlanGoodsExample.createCriteria().andShoppingListIdEqualTo(shoppingListId).andIsDelEqualTo("N");
        List<ShoppingPlanGoods> shoppingPlanGoodsList = this.shoppingPlanGoodsGeneratorCoreService.selectByExample(shoppingPlanGoodsExample);
        if (CollectionUtils.isNotEmpty(shoppingPlanGoodsList))
        {
            if (!this.shoppingPlanGoodsGeneratorCoreService.deleteByExample(shoppingPlanGoodsExample))
            {
                GooagooLog.error("删除购物清单：删除购物清单（" + shoppingListId + "）商品异常", null);
                throw new OperateFailException("删除购物清单（" + shoppingListId + "）商品异常");
            }
        }
        return true;
    }

    @Override
    public boolean deleteShoppingPlanGoods(String shoppingGoodsId) throws Exception
    {
        //1、数据正确性校验
        this.checkDeleteShoppingPlanGoodsData(shoppingGoodsId);
        //2、删除购物清单商品
        if (!this.shoppingPlanGoodsGeneratorCoreService.deleteByPrimaryKey(shoppingGoodsId))
        {
            GooagooLog.error("删除购物清单商品：删除购物清单商品（" + shoppingGoodsId + "）异常", null);
            throw new OperateFailException("删除购物清单商品（" + shoppingGoodsId + "）异常");
        }

        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean addShoppingPlanGoods(String userId, List<ShoppingPlanGoods> shoppingPlanGoodsList) throws Exception
    {
        //1、校验增加购物清单商品数据
        this.checkAddShoppingPlanGoodsData(userId, shoppingPlanGoodsList);
        //2、处理加入购物清单
        Map<String, String> data = new HashMap<String, String>();
        for (ShoppingPlanGoods shoppingPlanGoods : shoppingPlanGoodsList)
        {
            //2.1、若商品没有指定需要加入到哪个购物清单，默认选择用户最近的购物清单
            if (StringUtils.isBlank(shoppingPlanGoods.getShoppingListId()))
            {
                if (data.size() == 0)
                {
                    UserShoppingPlanExample queryCondition = new UserShoppingPlanExample();
                    queryCondition.createCriteria().andUserIdEqualTo(userId).andIsDelEqualTo("N");
                    queryCondition.setPage(1, 1);
                    queryCondition.setOrderByClause("pre_shopping_time DESC");
                    List<UserShoppingPlan> userShoppingPlanList = this.userShoppingPlanGeneratorCoreService.selectByExample(queryCondition);
                    if (userShoppingPlanList.size() != 1)
                    {
                        GooagooLog.info("加入购物清单：用户（" + userId + "）没有最新的购物清单");
                        throw new NoShoppingPlanException("用户（" + userId + "）没有最新的购物清单");
                    }
                    shoppingPlanGoods.setShoppingListId(userShoppingPlanList.get(0).getShoppingListId());
                    data.put(userId, userShoppingPlanList.get(0).getShoppingListId());
                }
                else
                {
                    shoppingPlanGoods.setShoppingListId(data.get(userId));
                }
            }
            //2.2、补充数据
            if (StringUtils.isBlank(shoppingPlanGoods.getGoodsName()))
            {
                //redis通过商品编号获取商品名称
                Map<String, String> goodsInfoCache = this.goodsCacheCoreService.findGoodsInfo(shoppingPlanGoods.getGoodsId());
                if (goodsInfoCache == null || goodsInfoCache.size() == 0)
                {
                    GooagooLog.warn("redis不存在goodsId=" + shoppingPlanGoods.getGoodsId() + "的商品信息");
                    return false;
                }
                shoppingPlanGoods.setGoodsName(goodsInfoCache.get("goodsName"));
            }
            shoppingPlanGoods.setShoppingGoodsId(UUID.getUUID());
            shoppingPlanGoods.setIsDel("N");
            //2.3、保存数据
            if (!this.shoppingPlanGoodsGeneratorCoreService.insertSelective(shoppingPlanGoods))
            {
                GooagooLog.error("加入购物清单：加入购物清单（" + shoppingPlanGoods.toString() + "）异常", null);
                throw new OperateFailException("加入购物清单（" + shoppingPlanGoods.toString() + "）异常");
            }
        }

        return true;
    }

    /**
     * 校验新增购物清单数据
     * @param userShoppingPlan
     * @return
     * @throws NullException
     * @throws FormatErrorException
     * @throws OperateFailException 
     */
    private boolean checkAddShoppingPlanData(UserShoppingPlan userShoppingPlan) throws NullException, FormatErrorException, OperateFailException
    {
        return this.checkShoppingPlanData(userShoppingPlan);
    }

    /**
     * 校验编辑购物清单数据
     * @param userShoppingPlan
     * @return
     * @throws NullException
     * @throws FormatErrorException
     * @throws OperateFailException 
     */
    private boolean checkUpdateShoppingPlanData(UserShoppingPlan userShoppingPlan) throws NullException, FormatErrorException, OperateFailException
    {
        //1、校验购物清单编号
        if (StringUtils.isBlank(userShoppingPlan.getShoppingListId()))
        {
            GooagooLog.info("校验编辑购物清单数据：购物清单编号（" + userShoppingPlan.getShoppingListId() + "）为空");
            throw new NullException("购物清单编号（" + userShoppingPlan.getShoppingListId() + "）为空");
        }
        //2、校验购物清单数据
        this.checkShoppingPlanData(userShoppingPlan);

        return true;
    }

    /**
     * 校验删除购物清单数据
     * @param shoppingListId
     * @return
     * @throws NullException
     */
    private boolean checkDeleteShoppingPlanData(String shoppingListId) throws NullException
    {
        //1、校验购物清单编号
        if (StringUtils.isBlank(shoppingListId))
        {
            GooagooLog.info("校验删除购物清单数据：购物清单编号（" + shoppingListId + "）为空");
            throw new NullException(shoppingListId);
        }

        return true;
    }

    /**
     * 校验删除购物清单商品数据
     * @param shoppingGoodsId
     * @return
     * @throws NullException
     */
    private boolean checkDeleteShoppingPlanGoodsData(String shoppingGoodsId) throws NullException
    {
        //1、校验购物清单商品编号
        if (StringUtils.isBlank(shoppingGoodsId))
        {
            GooagooLog.info("校验删除购物清单商品数据：购物清单商品编号（" + shoppingGoodsId + "）为空");
            throw new NullException("购物清单商品编号（" + shoppingGoodsId + "）为空");
        }

        return true;
    }

    /**
     * 校验增加购物清单商品数据
     * @param userId
     * @param shoppingPlanGoodsList
     * @return
     * @throws OperateFailException
     * @throws NullException
     * @throws FormatErrorException
     */
    private boolean checkAddShoppingPlanGoodsData(String userId, List<ShoppingPlanGoods> shoppingPlanGoodsList) throws OperateFailException, NullException, FormatErrorException
    {
        //1、校验用户
        if (!this.userProtectedCoreService.checkUserStatus(userId))
        {
            GooagooLog.info("校验增加购物清单商品数据：用户（" + userId + "）状态异常");
            throw new OperateFailException("用户（" + userId + "）状态异常");
        }
        return true;
    }

    /**
     * 校验购物清单数据
     * @param userShoppingPlan
     * @return
     * @throws NullException 
     * @throws FormatErrorException 
     * @throws OperateFailException 
     */
    private boolean checkShoppingPlanData(UserShoppingPlan userShoppingPlan) throws NullException, FormatErrorException, OperateFailException
    {
        //1、校验用户
        if (!this.userProtectedCoreService.checkUserStatus(userShoppingPlan.getUserId()))
        {
            GooagooLog.info("校验购物清单数据：用户（" + userShoppingPlan.getUserId() + "）状态异常");
            throw new OperateFailException("用户（" + userShoppingPlan.getUserId() + "）状态异常");
        }
        //2、校验购物清单标题
        if (StringUtils.isBlank(userShoppingPlan.getTitle()))
        {
            GooagooLog.info("校验购物清单数据：购物清单标题（" + userShoppingPlan.getTitle() + "）为空");
            throw new NullException("购物清单标题（" + userShoppingPlan.getTitle() + "）为空");
        }
        if (userShoppingPlan.getTitle().length() > 32)
        {
            GooagooLog.info("校验购物清单数据：购物清单标题（" + userShoppingPlan.getTitle() + "）长度超过32个字符");
            throw new FormatErrorException("购物清单标题（" + userShoppingPlan.getTitle() + "）长度超过32个字符");
        }
        //3、校验预计购物时间
        if (userShoppingPlan.getPreShoppingTime() == null)
        {
            GooagooLog.info("校验购物清单数据：预计购物时间（" + userShoppingPlan.getPreShoppingTime() + "）为空");
            throw new NullException("预计购物时间（" + userShoppingPlan.getPreShoppingTime() + "）为空");
        }
        //4、校验信息来源
        if (SysdictionaryCache.get("info_source", userShoppingPlan.getInfoSource()) == null)
        {
            GooagooLog.info("校验购物清单数据：信息来源（" + userShoppingPlan.getInfoSource() + "）有误");
            throw new FormatErrorException("信息来源（" + userShoppingPlan.getInfoSource() + "）有误");
        }

        return true;
    }

}
