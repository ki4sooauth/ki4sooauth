package com.gooagoo.core.business.user.shoppingplan;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.user.shoppingplan.ShoppingPlanSynCoreService;
import com.gooagoo.api.generator.core.behave.ShoppingPlanGoodsGeneratorCoreService;
import com.gooagoo.api.generator.core.behave.UserShoppingPlanGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.business.user.ShoppingPlanDetailStepB;
import com.gooagoo.entity.business.user.shoppingplan.ShoppingplanBusiness;
import com.gooagoo.entity.business.user.shoppingplan.ShoppingplanGoodsBusiness;
import com.gooagoo.entity.business.user.shoppingplan.ShoppingplanInfoBusiness;
import com.gooagoo.entity.generator.behave.ShoppingPlanGoods;
import com.gooagoo.entity.generator.behave.ShoppingPlanGoodsExample;
import com.gooagoo.entity.generator.behave.UserShoppingPlan;
import com.gooagoo.exception.common.OperateFailException;

@Service
public class ShoppingPlanSynCoreServiceImpl implements ShoppingPlanSynCoreService
{

    @Autowired
    UserShoppingPlanGeneratorCoreService userShoppingPlanGeneratorCoreService;

    @Autowired
    ShoppingPlanGoodsGeneratorCoreService shoppingPlanGoodsGeneratorCoreService;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public ShoppingplanInfoBusiness getSingleUserShoppingplan(String userId, String userShoppingplan) throws Exception
    {
        ShoppingplanInfoBusiness shoppingplanBusinessInfoResult = new ShoppingplanInfoBusiness();
        ShoppingplanBusiness shoppingplanBusiness4Json = JsonUtils.toObj(userShoppingplan, ShoppingplanBusiness.class);
        String synType = this.getUpdateType(shoppingplanBusiness4Json.getShoppinglistid(), shoppingplanBusiness4Json.getCtimestamp());
        if ("E".equals(synType))
        {
            shoppingplanBusinessInfoResult.setFlag(synType);
        }
        else if ("A".equals(synType))//手机端新建数据
        {
            String shoppingListId = this.addUserShoppingPlan(userId, shoppingplanBusiness4Json);
            if (StringUtils.hasText(shoppingListId))
            {
                //手机端新建清单，返回给手机端清单号
                shoppingplanBusinessInfoResult.setFlag(synType);
                shoppingplanBusinessInfoResult.setNewshoppinglistid(shoppingListId);
            }
        }
        else if ("M".equals(synType))//手机端数据是新的,更新服务器端数据
        {
            this.updateUserShoppingPlan(userId, shoppingplanBusiness4Json);
            shoppingplanBusinessInfoResult.setFlag(synType);
        }
        else
        {//S-服务器端数据是新的,更新服务器端数据
            ShoppingplanBusiness shoppingplanBusiness = new ShoppingplanBusiness();
            shoppingplanBusiness = this.getUsershoppingplan(shoppingplanBusiness4Json.getShoppinglistid());
            shoppingplanBusinessInfoResult.setFlag(synType);
            shoppingplanBusinessInfoResult.setShoppingplanBusiness(shoppingplanBusiness);
        }
        //"购物计划"同步信息返回给手机端
        return shoppingplanBusinessInfoResult;
    }

    /**
     * 判断购物清单更新类型
     * @param shoppingListId 购物清单id
     * @param ctimestamp 手机端购物清单最后一次修改时间
     * @return 同步类型[A-手机端新增数据、M-手机端数据是新的（包括修改和删除）、S-服务器端数据是新的（包括修改和删除）、E-手机端和服务器端数据时一样的]
     * @throws Exception 
     */
    private String getUpdateType(String shoppingListId, String ctimestamp) throws Exception
    {
        if (shoppingListId.length() != 32)//平台清单编号为32位,当不等于32为时则说明此条清单为手机端新建.
        {
            return "A";//A-手机端新增数据
        }
        UserShoppingPlan userShoppingPlan = this.userShoppingPlanGeneratorCoreService.selectUnDelByPrimaryKey(shoppingListId);
        Date date = null;
        date = TimeUtils.convertStringToDate(ctimestamp);
        int m = userShoppingPlan.getCTimeStamp().compareTo(date);
        if (m < 0)//平台时间小于手机
        {
            return "M";//更新平台数据(由于是软删,删除操作也属于更新)
        }
        else if (m > 0)//平台时间大于手机端时间
        {
            return "S";//更新手机端数据数据(由于是软删,删除操作也属于更新)   
        }
        else if (m == 0)//平台时间等于手机
        {
            return "E";//不做任何操作
        }
        return null;
    }

    /**
     * 将手机新建的购物清单同步到平台
     * @param shoppinglistid
     * @return
     * @throws Exception
     */
    private String addUserShoppingPlan(String userid, ShoppingplanBusiness shoppingplanBusiness) throws Exception
    {

        UserShoppingPlan userShoppingPlan = new UserShoppingPlan();
        String shoppingListId = UUID.getUUID();
        userShoppingPlan.setShoppingListId(shoppingListId);
        userShoppingPlan.setUserId(userid);
        userShoppingPlan.setTitle(shoppingplanBusiness.getTitle());
        userShoppingPlan.setPreShoppingTime(TimeUtils.convertStringToDate(shoppingplanBusiness.getPreshoppingtime()));
        userShoppingPlan.setInfoSource("M");
        userShoppingPlan.setIsDel(shoppingplanBusiness.getIsdel());
        userShoppingPlan.setIsDel("N");
        if (StringUtils.hasText(shoppingplanBusiness.getCreatetime()))
        {
            userShoppingPlan.setCreateTime(TimeUtils.convertStringToDate(shoppingplanBusiness.getCreatetime()));
        }
        if (StringUtils.hasText(shoppingplanBusiness.getCtimestamp()))
        {
            userShoppingPlan.setCTimeStamp(TimeUtils.convertStringToDate(shoppingplanBusiness.getCtimestamp()));
        }
        if (!this.userShoppingPlanGeneratorCoreService.insertSelective(userShoppingPlan))
        {
            return null;
        }
        List<ShoppingplanGoodsBusiness> shoppingplanGoodsBusinessList = shoppingplanBusiness.getShoppingplanGoodsBusinessList();
        if (CollectionUtils.isNotEmpty(shoppingplanGoodsBusinessList))
        {
            for (ShoppingplanGoodsBusiness shoppingplanGoodsBusiness : shoppingplanGoodsBusinessList)
            {
                ShoppingPlanGoods shoppingPlanGoods = new ShoppingPlanGoods();
                shoppingPlanGoods.setShoppingGoodsId(UUID.getUUID());
                shoppingPlanGoods.setShoppingListId(shoppingplanBusiness.getShoppinglistid());
                shoppingPlanGoods.setGoodsId(shoppingplanGoodsBusiness.getGoodsid());
                shoppingPlanGoods.setGoodsName(shoppingplanGoodsBusiness.getGoodsname());
                shoppingPlanGoods.setGoodsTypeId(shoppingplanGoodsBusiness.getGoodstypeid() != null && !"".equals(shoppingplanGoodsBusiness.getGoodstypeid()) ? Integer.parseInt(shoppingplanGoodsBusiness.getGoodstypeid()) : null);
                shoppingPlanGoods.setGoodsTypeName(shoppingplanGoodsBusiness.getGoodstypename());
                shoppingPlanGoods.setShopId(shoppingplanGoodsBusiness.getShopid());
                shoppingPlanGoods.setShopName(shoppingplanGoodsBusiness.getShopname());
                shoppingPlanGoods.setIsDel(shoppingplanGoodsBusiness.getIsdel());
                shoppingPlanGoods.setCreateTime(StringUtils.hasText(shoppingplanGoodsBusiness.getCreatetime()) ? TimeUtils.convertStringToDate(shoppingplanGoodsBusiness.getCreatetime()) : null);
                shoppingPlanGoods.setCTimeStamp(StringUtils.hasText(shoppingplanGoodsBusiness.getCtimestamp()) ? TimeUtils.convertStringToDate(shoppingplanGoodsBusiness.getCtimestamp()) : null);
                if (!this.shoppingPlanGoodsGeneratorCoreService.insertSelective(shoppingPlanGoods))
                {
                    return null;
                }
            }
        }
        return shoppingListId;
    }

    /**
     * 将手机更新的购物清单同步到平台
     * @param userid
     * @param usershoppingplanmob
     * @return
     * @throws Exception
     */
    private boolean updateUserShoppingPlan(String userid, ShoppingplanBusiness shoppingplanBusiness) throws Exception
    {
        UserShoppingPlan userShoppingPlan = new UserShoppingPlan();
        userShoppingPlan.setShoppingListId(shoppingplanBusiness.getShoppinglistid());
        userShoppingPlan.setUserId(userid);
        userShoppingPlan.setTitle(shoppingplanBusiness.getTitle());
        userShoppingPlan.setPreShoppingTime(TimeUtils.convertStringToDate(shoppingplanBusiness.getPreshoppingtime()));
        userShoppingPlan.setInfoSource("M");
        userShoppingPlan.setIsDel(shoppingplanBusiness.getIsdel());
        userShoppingPlan.setCTimeStamp(TimeUtils.convertStringToDate(shoppingplanBusiness.getCtimestamp()));
        if (!this.userShoppingPlanGeneratorCoreService.updateByPrimaryKeySelective(userShoppingPlan))
        {
            return false;
        }
        //当手机端删除购物计划时平台做更新同步后将该清单下的商品清空
        ShoppingPlanGoodsExample shoppingPlanGoodsExample = new ShoppingPlanGoodsExample();
        shoppingPlanGoodsExample.createCriteria().andShoppingListIdEqualTo(shoppingplanBusiness.getShoppinglistid());
        List<ShoppingPlanGoods> shoppingPlanGoodsList = this.shoppingPlanGoodsGeneratorCoreService.selectByExample(shoppingPlanGoodsExample);
        if (CollectionUtils.isNotEmpty(shoppingPlanGoodsList))
        {
            for (ShoppingPlanGoods shoppingPlanGoods : shoppingPlanGoodsList)
            {
                if (!this.shoppingPlanGoodsGeneratorCoreService.deleteByPrimaryKey(shoppingPlanGoods.getShoppingGoodsId()))
                {
                    return false;
                }
            }
        }
        List<ShoppingplanGoodsBusiness> shoppingplanGoodsBusinessList = shoppingplanBusiness.getShoppingplanGoodsBusinessList();
        for (ShoppingplanGoodsBusiness shoppingplanGoodsBusiness : shoppingplanGoodsBusinessList)
        {
            ShoppingPlanGoods shoppingPlanGoods = new ShoppingPlanGoods();
            shoppingPlanGoods.setShoppingGoodsId(UUID.getUUID());
            shoppingPlanGoods.setShoppingListId(shoppingplanBusiness.getShoppinglistid());
            shoppingPlanGoods.setGoodsId(shoppingplanGoodsBusiness.getGoodsid());
            shoppingPlanGoods.setGoodsName(shoppingplanGoodsBusiness.getGoodsname());
            shoppingPlanGoods.setGoodsTypeId(StringUtils.hasText(shoppingplanGoodsBusiness.getGoodstypeid()) ? Integer.parseInt(shoppingplanGoodsBusiness.getGoodstypeid()) : null);
            shoppingPlanGoods.setGoodsTypeName(shoppingplanGoodsBusiness.getGoodstypename());
            shoppingPlanGoods.setShopId(shoppingplanGoodsBusiness.getShopid());
            shoppingPlanGoods.setShopName(shoppingplanGoodsBusiness.getShopname());
            shoppingPlanGoods.setIsDel(shoppingplanGoodsBusiness.getIsdel());
            shoppingPlanGoods.setCreateTime(shoppingplanGoodsBusiness.getCreatetime() != null ? TimeUtils.convertStringToDate(shoppingplanGoodsBusiness.getCreatetime()) : null);
            shoppingPlanGoods.setCTimeStamp(shoppingplanGoodsBusiness.getCtimestamp() != null ? TimeUtils.convertStringToDate(shoppingplanGoodsBusiness.getCtimestamp()) : null);
            if (!this.shoppingPlanGoodsGeneratorCoreService.insertSelective(shoppingPlanGoods))
            {
                return false;
            }
        }
        return true;

    }

    /**
     * 查询平台购物清单并封装返回结果
     * @param shoppinglistid
     * @return
     * @throws Exception
     */
    private ShoppingplanBusiness getUsershoppingplan(String shoppingListId) throws Exception
    {
        ShoppingplanBusiness shoppingplanBusinessResult = null;
        UserShoppingPlan userShoppingPlan = this.userShoppingPlanGeneratorCoreService.selectByPrimaryKey(shoppingListId);
        if (userShoppingPlan != null)
        {
            shoppingplanBusinessResult = new ShoppingplanBusiness();
            shoppingplanBusinessResult.setCreatetime(TimeUtils.convertDateToString(userShoppingPlan.getCreateTime(), TimeUtils.FORMAT1));
            shoppingplanBusinessResult.setCtimestamp(TimeUtils.convertDateToString(userShoppingPlan.getCTimeStamp(), TimeUtils.FORMAT1));
            shoppingplanBusinessResult.setInfosource(userShoppingPlan.getInfoSource());
            shoppingplanBusinessResult.setIsdel(userShoppingPlan.getIsDel());
            shoppingplanBusinessResult.setPreshoppingtime(TimeUtils.convertDateToString(userShoppingPlan.getPreShoppingTime(), TimeUtils.FORMAT1));
            shoppingplanBusinessResult.setShoppinglistid(userShoppingPlan.getShoppingListId());
            shoppingplanBusinessResult.setTitle(userShoppingPlan.getTitle());
        }
        ShoppingPlanGoodsExample shoppingPlanGoodsExample = new ShoppingPlanGoodsExample();
        shoppingPlanGoodsExample.createCriteria().andShoppingListIdEqualTo(shoppingListId).andIsDelEqualTo("N");
        List<ShoppingPlanGoods> shoppingPlanGoodsList = this.shoppingPlanGoodsGeneratorCoreService.selectByExample(shoppingPlanGoodsExample);
        if (CollectionUtils.isNotEmpty(shoppingPlanGoodsList))
        {
            List<ShoppingplanGoodsBusiness> shoppingplanGoodsBusinessList = new ArrayList<ShoppingplanGoodsBusiness>();
            for (ShoppingPlanGoods item : shoppingPlanGoodsList)
            {
                ShoppingplanGoodsBusiness shoppingplanGoodsBusiness = new ShoppingplanGoodsBusiness();
                shoppingplanGoodsBusiness.setCreatetime(TimeUtils.convertDateToString(item.getCreateTime(), TimeUtils.FORMAT1));
                shoppingplanGoodsBusiness.setCtimestamp(TimeUtils.convertDateToString(item.getCTimeStamp(), TimeUtils.FORMAT1));
                shoppingplanGoodsBusiness.setGoodsid(item.getGoodsId());
                shoppingplanGoodsBusiness.setGoodsname(item.getGoodsName());
                shoppingplanGoodsBusiness.setGoodstypeid(item.getGoodsTypeId() != null ? item.getGoodsTypeId().toString() : null);
                shoppingplanGoodsBusiness.setGoodstypename(item.getGoodsTypeName());
                shoppingplanGoodsBusiness.setIsdel(item.getIsDel());
                shoppingplanGoodsBusiness.setShopid(item.getShopId());
                shoppingplanGoodsBusiness.setShopname(item.getShopName());
                shoppingplanGoodsBusiness.setShoppinggoodsid(item.getShoppingGoodsId());
                shoppingplanGoodsBusinessList.add(shoppingplanGoodsBusiness);
            }
            shoppingplanBusinessResult.setShoppingplanGoodsBusinessList(shoppingplanGoodsBusinessList);
        }
        return shoppingplanBusinessResult;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public List<Map<String, String>> shoppingPlanSynStepB(List<ShoppingPlanDetailStepB> shoppingPlanDetailList) throws Exception
    {
        List<Map<String, String>> map4List = new ArrayList<Map<String, String>>();
        if (CollectionUtils.isNotEmpty(shoppingPlanDetailList))
        {
            for (ShoppingPlanDetailStepB shoppingPlanDetail : shoppingPlanDetailList)
            {
                //购物清单主表
                UserShoppingPlan userShoppingPlan = shoppingPlanDetail.getUserShoppingPlan();
                //购物清单商品表
                List<ShoppingPlanGoods> shoppingPlanGoodsList = shoppingPlanDetail.getShoppingPlanGoodsList();
                //手机端购物清单编号
                String shoppinglistidm = userShoppingPlan.getShoppingListId();
                //平台清单编号为32位,当不等于32为时则说明此条清单为手机端新建(同步添加)
                if (shoppinglistidm.length() != 32)
                {
                    Map<String, String> map = this.synAddShoppingPlan(shoppinglistidm, userShoppingPlan, shoppingPlanGoodsList);
                    map4List.add(map);
                }
                //平台清单编号为32位,当不等于32为时则说明此条清单为手机端新建(同步更新)
                else
                {
                    this.synUpdateShoppingPlan(userShoppingPlan, shoppingPlanGoodsList);
                }
            }
        }
        return CollectionUtils.isNotEmpty(map4List) ? map4List : null;
    }

    /**
     * 同步添加购物清单
     * @param shoppinglistidm 手机端购物清单编号
     * @param UserShoppingPlan 购物清单主表
     * @param List<ShoppingPlanGoods> 购物清单商品表
     * @return Map<String, String> shoppinglistid购物清单编号,shoppinglistidm手机端购物清单编号
     * @throws OperateFailException
     */
    private Map<String, String> synAddShoppingPlan(String shoppinglistidm, UserShoppingPlan userShoppingPlan, List<ShoppingPlanGoods> shoppingPlanGoodsList) throws OperateFailException
    {
        String shoppinglistid = UUID.getUUID();//平台生成的购物清单编号
        userShoppingPlan.setShoppingListId(shoppinglistid);
        userShoppingPlan.setCreateTime(userShoppingPlan.getCreateTime());
        userShoppingPlan.setCTimeStamp(userShoppingPlan.getCTimeStamp());
        userShoppingPlan.setIsDel("N");
        if (!this.userShoppingPlanGeneratorCoreService.insertSelective(userShoppingPlan))
        {
            GooagooLog.error("同步添加购物清单主表失败(shoppinglistid=" + shoppinglistid + ")", new Throwable());
            throw new OperateFailException("同步添加购物清单主表异常");
        }
        if (CollectionUtils.isNotEmpty(shoppingPlanGoodsList))
        {
            for (ShoppingPlanGoods shoppingPlanGoods : shoppingPlanGoodsList)
            {
                String shoppinggoodsid = UUID.getUUID();
                shoppingPlanGoods.setShoppingGoodsId(shoppinggoodsid);
                shoppingPlanGoods.setShoppingListId(shoppinglistid);
                shoppingPlanGoods.setCreateTime(shoppingPlanGoods.getCreateTime());
                shoppingPlanGoods.setCTimeStamp(shoppingPlanGoods.getCTimeStamp());
                shoppingPlanGoods.setIsDel("N");
                if (!this.shoppingPlanGoodsGeneratorCoreService.insertSelective(shoppingPlanGoods))
                {
                    GooagooLog.error("同步添加购物清单商品表失败(shoppinggoodsid=" + shoppinggoodsid + ")", new Throwable());
                    throw new OperateFailException("同步添加购物清单商品表异常");
                }
            }
        }
        Map<String, String> map = new HashMap<String, String>();
        map.put("shoppinglistid", shoppinglistid);//购物清单编号
        map.put("shoppinglistidm", shoppinglistidm);//手机端购物清单编号
        return map;
    }

    /**
     * 同步更新购物清单
     * @param shoppinglistid 平台生成的购物清单编号
     * @param shoppinglistidm 手机端购物清单编号
     * @param UserShoppingPlan 购物清单主表
     * @return void
     * @throws OperateFailException
     */
    private void synUpdateShoppingPlan(UserShoppingPlan userShoppingPlan, List<ShoppingPlanGoods> shoppingPlanGoodsList) throws OperateFailException
    {
        //1.修改购物清单主表信息
        if (!this.userShoppingPlanGeneratorCoreService.updateByPrimaryKeySelective(userShoppingPlan))
        {
            GooagooLog.error("同步更新购物清单主表失败(shoppinglistid=" + userShoppingPlan.getShoppingListId() + ")", new Throwable());
            throw new OperateFailException("同步更新购物清单主表异常");
        }

        //2.删除购物订单中商品信息
        this.shoppingPlanGoodsGeneratorCoreService.deleteByPrimaryKey(userShoppingPlan.getShoppingListId());
        //3.添加新增或修改的购物清单商品信息
        if (CollectionUtils.isNotEmpty(shoppingPlanGoodsList))
        {
            for (ShoppingPlanGoods shoppingPlanGoods : shoppingPlanGoodsList)
            {
                String shoppinggoodsid = UUID.getUUID();
                shoppingPlanGoods.setShoppingGoodsId(shoppinggoodsid);
                shoppingPlanGoods.setShoppingListId(userShoppingPlan.getShoppingListId());
                //shoppingPlanGoods.setCreateTime(new Date());
                //shoppingPlanGoods.setIsDel("N");
                if (!this.shoppingPlanGoodsGeneratorCoreService.insertSelective(shoppingPlanGoods))
                {
                    GooagooLog.error("同步添加购物清单商品表失败(shoppinggoodsid=" + shoppinggoodsid + ")", new Throwable());
                    throw new OperateFailException("同步添加购物清单商品表异常");
                }
            }
        }
        //        if (CollectionUtils.isNotEmpty(shoppingPlanGoodsList))
        //        {
        //            for (ShoppingPlanGoods shoppingPlanGoods : shoppingPlanGoodsList)
        //            {
        //                if (this.shoppingPlanGoodsGeneratorCoreService.updateByPrimaryKeySelective(shoppingPlanGoods) < 1)
        //                {
        //                    GooagooLog.error("同步更新购物清单商品表失败(shoppinggoodsid=" + shoppingPlanGoods.getShoppingGoodsId() + ")", new Throwable());
        //                    throw new OperateFailException("同步更新购物清单商品表异常");
        //                }
        //            }
        //        }
    }

}
