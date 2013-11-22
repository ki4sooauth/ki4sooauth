package com.gooagoo.query.business.user.shoppingplan;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.query.user.shoppingplan.ShoppingPlanQueryService;
import com.gooagoo.api.generator.query.behave.ShoppingPlanGoodsGeneratorQueryService;
import com.gooagoo.api.generator.query.behave.UserShoppingPlanGeneratorQueryService;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.entity.business.user.ShoppingPlanDetailStepA;
import com.gooagoo.entity.business.user.ShoppingPlanDetailStepB;
import com.gooagoo.entity.generator.behave.ShoppingPlanGoods;
import com.gooagoo.entity.generator.behave.ShoppingPlanGoodsExample;
import com.gooagoo.entity.generator.behave.UserShoppingPlan;
import com.gooagoo.entity.generator.behave.UserShoppingPlanExample;
import com.gooagoo.exception.common.FormatErrorException;

@Service
public class ShoppingPlanQueryServiceImpl implements ShoppingPlanQueryService
{

    @Autowired
    UserShoppingPlanGeneratorQueryService userShoppingPlanGeneratorQueryService;

    @Autowired
    ShoppingPlanGoodsGeneratorQueryService shoppingPlanGoodsGeneratorQueryService;

    @Override
    public ShoppingPlanDetailStepA shoppingPlanSynStepA(String userId, List<Map<String, String>> usershoppingplan) throws Exception
    {
        ShoppingPlanDetailStepA shoppingPlanDetailStepA = new ShoppingPlanDetailStepA();
        if (CollectionUtils.isNotEmpty(usershoppingplan))
        {
            String mobilechange = "";
            List<ShoppingPlanDetailStepB> shoppingPlanDetailStepBList = new ArrayList<ShoppingPlanDetailStepB>();
            for (Map<String, String> map : usershoppingplan)
            {
                String shoppinglistid = map.get("shoppinglistid");
                Date ctimestamp;
                try
                {
                    ctimestamp = TimeUtils.convertStringToDate(map.get("ctimestamp"));
                }
                catch (Exception e)
                {
                    throw new FormatErrorException("日期格式转换异常");
                }
                //累加手机端新的购物计划编号(逗号累加 warm:最后会多出一个逗号)
                mobilechange = this.getNewShoppingPlan4Client(mobilechange, shoppinglistid, ctimestamp);
                //获取平台新的购物计划和购物计划商品信息
                ShoppingPlanDetailStepB shoppingPlanDetailStepB = this.getNewShoppingPlan4Platform(shoppinglistid, ctimestamp);
                if (shoppingPlanDetailStepB != null)
                {
                    shoppingPlanDetailStepBList.add(shoppingPlanDetailStepB);
                }
            }
            if (StringUtils.hasText(mobilechange))
            {
                shoppingPlanDetailStepA.setMobilechange(mobilechange.substring(0, mobilechange.length() - 1));
            }
            else
            {
                shoppingPlanDetailStepA.setMobilechange(null);
            }
            if (CollectionUtils.isNotEmpty(shoppingPlanDetailStepBList))
            {
                shoppingPlanDetailStepA.setShoppingPlanDetailStepBList(shoppingPlanDetailStepBList);
            }
            else
            {
                shoppingPlanDetailStepA.setShoppingPlanDetailStepBList(null);
            }
        }
        else
        {//商品信息为null,查询所有购物计划
         //查询购物清单主表
            UserShoppingPlanExample userShoppingPlanExample = new UserShoppingPlanExample();
            userShoppingPlanExample.createCriteria().andUserIdEqualTo(userId).andIsDelEqualTo("N");
            List<UserShoppingPlan> userShoppingPlanList = this.userShoppingPlanGeneratorQueryService.selectByExample(userShoppingPlanExample);
            List<ShoppingPlanDetailStepB> shoppingPlanDetailStepBList = null;
            if (CollectionUtils.isNotEmpty(userShoppingPlanList))
            {
                shoppingPlanDetailStepBList = new ArrayList<ShoppingPlanDetailStepB>();
                for (UserShoppingPlan userShoppingPlan : userShoppingPlanList)
                {
                    ShoppingPlanDetailStepB shoppingPlanDetailStepB = new ShoppingPlanDetailStepB();
                    shoppingPlanDetailStepB.setUserShoppingPlan(userShoppingPlan);
                    //查询购物清单商品表
                    ShoppingPlanGoodsExample shoppingPlanGoodsExample = new ShoppingPlanGoodsExample();
                    shoppingPlanGoodsExample.createCriteria().andShoppingListIdEqualTo(userShoppingPlan.getShoppingListId()).andIsDelEqualTo("N");
                    List<ShoppingPlanGoods> shoppingPlanGoodsList = this.shoppingPlanGoodsGeneratorQueryService.selectByExample(shoppingPlanGoodsExample);
                    if (CollectionUtils.isNotEmpty(shoppingPlanGoodsList))
                    {
                        shoppingPlanDetailStepB.setShoppingPlanGoodsList(shoppingPlanGoodsList);
                    }
                    else
                    {
                        shoppingPlanDetailStepB.setShoppingPlanGoodsList(null);
                    }
                    shoppingPlanDetailStepBList.add(shoppingPlanDetailStepB);
                }

            }
            else
            {
                return null;
            }
            shoppingPlanDetailStepA.setShoppingPlanDetailStepBList(shoppingPlanDetailStepBList);

        }
        return StringUtils.hasText(shoppingPlanDetailStepA.getMobilechange()) || CollectionUtils.isNotEmpty(shoppingPlanDetailStepA.getShoppingPlanDetailStepBList()) ? shoppingPlanDetailStepA : null;
    }

    //累加手机端新的购物计划编号(逗号累加 warm:最后会多出一个逗号)
    private String getNewShoppingPlan4Client(String mobilechange, String shoppinglistid, Date ctimestamp)
    {
        //平台清单编号为32位,当不等于32为时则说明此条清单为手机端新建(同步添加)
        if (shoppinglistid.length() != 32)
        {
            mobilechange += shoppinglistid + ",";
        }
        else
        {
            UserShoppingPlanExample userShoppingPlanExample = new UserShoppingPlanExample();
            userShoppingPlanExample.createCriteria().andShoppingListIdEqualTo(shoppinglistid).andCTimeStampLessThan(ctimestamp);
            List<UserShoppingPlan> userShoppingPlanList = this.userShoppingPlanGeneratorQueryService.selectByExample(userShoppingPlanExample);
            if (CollectionUtils.isNotEmpty(userShoppingPlanList))
            {
                for (UserShoppingPlan userShoppingPlan : userShoppingPlanList)
                {
                    mobilechange += userShoppingPlan.getShoppingListId() + ",";
                }
            }
        }
        return mobilechange;
    }

    //获取平台新的购物计划和购物计划商品信息(如果该购物清单手机端新,则返回null)
    private ShoppingPlanDetailStepB getNewShoppingPlan4Platform(String shoppinglistid, Date ctimestamp)
    {
        ShoppingPlanDetailStepB shoppingPlanDetailStepB = new ShoppingPlanDetailStepB();
        //平台清单编号为32位,过滤手机端新建的购物清单
        if (shoppinglistid.length() == 32)
        {
            UserShoppingPlanExample userShoppingPlanExample = new UserShoppingPlanExample();
            userShoppingPlanExample.createCriteria().andShoppingListIdEqualTo(shoppinglistid).andCTimeStampGreaterThan(ctimestamp);
            List<UserShoppingPlan> userShoppingPlanList = this.userShoppingPlanGeneratorQueryService.selectByExample(userShoppingPlanExample);
            if (CollectionUtils.isNotEmpty(userShoppingPlanList))
            {
                shoppingPlanDetailStepB.setUserShoppingPlan(userShoppingPlanList.get(0));
                ShoppingPlanGoodsExample shoppingPlanGoodsExample = new ShoppingPlanGoodsExample();
                shoppingPlanGoodsExample.createCriteria().andShoppingListIdEqualTo(shoppinglistid);
                List<ShoppingPlanGoods> shoppingPlanGoodsList = this.shoppingPlanGoodsGeneratorQueryService.selectByExample(shoppingPlanGoodsExample);
                if (CollectionUtils.isNotEmpty(shoppingPlanGoodsList))
                {
                    shoppingPlanDetailStepB.setShoppingPlanGoodsList(shoppingPlanGoodsList);
                }
                else
                {
                    shoppingPlanDetailStepB.setShoppingPlanGoodsList(null);
                }
            }
            else
            {
                return null;
            }
        }
        else
        {
            return null;
        }
        return shoppingPlanDetailStepB;
    }

    @Override
    public void findShoppingPlanList() throws Exception
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void findShoppingPlanGoodsList() throws Exception
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void findShoppingPlanGoodsTypeList() throws Exception
    {
        // TODO Auto-generated method stub

    }

}
