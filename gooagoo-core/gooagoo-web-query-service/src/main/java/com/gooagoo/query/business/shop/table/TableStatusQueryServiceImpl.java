package com.gooagoo.query.business.shop.table;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.query.shop.cache.TableCacheQueryService;
import com.gooagoo.api.business.query.shop.table.TableStatusQueryService;
import com.gooagoo.api.generator.query.behave.UserStoreQueueGeneratorQueryService;
import com.gooagoo.api.generator.query.bill.OrderDetailInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.bill.OrderInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopTableInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopTableTypeManageGeneratorQueryService;
import com.gooagoo.api.protecteds.query.shop.ShopProtectedQueryService;
import com.gooagoo.api.protecteds.query.shop.table.TableProtectedQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.entity.business.shop.table.TableDiningStatus;
import com.gooagoo.entity.business.shop.table.TableStatus;
import com.gooagoo.entity.business.shop.table.TableStatusByType;
import com.gooagoo.entity.business.shop.table.TableTypeStatus;
import com.gooagoo.entity.generator.behave.UserStoreQueue;
import com.gooagoo.entity.generator.behave.UserStoreQueueExample;
import com.gooagoo.entity.generator.bill.OrderDetailInfo;
import com.gooagoo.entity.generator.bill.OrderDetailInfoExample;
import com.gooagoo.entity.generator.bill.OrderInfo;
import com.gooagoo.entity.generator.bill.OrderInfoExample;
import com.gooagoo.entity.generator.shop.ShopTableInfo;
import com.gooagoo.entity.generator.shop.ShopTableInfoExample;
import com.gooagoo.entity.generator.shop.ShopTableInfoExample.Criteria;
import com.gooagoo.entity.generator.shop.ShopTableTypeManage;
import com.gooagoo.entity.generator.shop.ShopTableTypeManageExample;

@Service
public class TableStatusQueryServiceImpl implements TableStatusQueryService
{

    @Autowired
    private ShopTableInfoGeneratorQueryService shopTableInfoGeneratorQueryService;

    @Autowired
    private OrderInfoGeneratorQueryService orderInfoGeneratorQueryService;

    @Autowired
    private OrderDetailInfoGeneratorQueryService orderDetailInfoGeneratorQueryService;

    @Autowired
    private ShopTableTypeManageGeneratorQueryService shopTableTypeManageGeneratorQueryService;

    @Autowired
    private UserStoreQueueGeneratorQueryService userStoreQueueGeneratorQueryService;

    @Autowired
    private TableProtectedQueryService tableProtectedQueryService;

    @Autowired
    private TableCacheQueryService tableCacheQueryService;

    @Autowired
    private ShopProtectedQueryService shopProtectedQueryService;

    @Override
    public List<TableTypeStatus> findTableTypeStatus(String tableTypeCode, String shopEntityId, Integer pageIndex, Integer pageSize) throws Exception
    {
        List<TableTypeStatus> tableTypeStatusList = null;
        ShopTableTypeManageExample shopTableTypeManageExample = new ShopTableTypeManageExample();
        if (StringUtils.hasText(tableTypeCode))
        {
            shopTableTypeManageExample.createCriteria().andTableTypeCodeEqualTo(tableTypeCode).andIsDelEqualTo("N");
        }
        else
        {
            shopTableTypeManageExample.createCriteria().andShopEntityIdEqualTo(shopEntityId).andIsDelEqualTo("N");
        }
        if (pageIndex != null && pageSize != null)
        {
            shopTableTypeManageExample.setPage(pageIndex, pageSize);
        }
        List<ShopTableTypeManage> shopTableTypeManageList = this.shopTableTypeManageGeneratorQueryService.selectByExample(shopTableTypeManageExample);
        if (CollectionUtils.isNotEmpty(shopTableTypeManageList))
        {
            tableTypeStatusList = new ArrayList<TableTypeStatus>();
            for (ShopTableTypeManage shopTableTypeManage : shopTableTypeManageList)
            {
                TableTypeStatus tableTypeStatus = new TableTypeStatus();
                tableTypeStatus.setTableTypeCode(shopTableTypeManage.getTableTypeCode());//封装餐桌类型编码
                tableTypeStatus.setTableTypeName(shopTableTypeManage.getTableTypeName());//封装餐桌类型名称
                tableTypeStatus.setMaxNums(shopTableTypeManage.getMaxNums().toString());
                tableTypeStatus.setMinNums(shopTableTypeManage.getMinNums().toString());
                String tableTypeSum = this.tableProtectedQueryService.getTableTypeSum(shopTableTypeManage.getShopEntityId(), shopTableTypeManage.getTableTypeCode());
                tableTypeStatus.setTableTypeSum(tableTypeSum);//封装当前类型餐桌总数
                List<Map<String, String>> vacancyList = this.tableCacheQueryService.findTableInfoByTypeAndState(shopEntityId, shopTableTypeManage.getTableTypeCode(), "空闲");
                List<Map<String, String>> checkoutList = this.tableCacheQueryService.findTableInfoByTypeAndState(shopEntityId, shopTableTypeManage.getTableTypeCode(), "正在结账");
                List<Map<String, String>> useList = this.tableCacheQueryService.findTableInfoByTypeAndState(shopEntityId, shopTableTypeManage.getTableTypeCode(), "已点餐");
                tableTypeStatus.setVacancynum(CollectionUtils.isNotEmpty(vacancyList) ? vacancyList.size() + "" : tableTypeSum);//封装空闲数
                tableTypeStatus.setCheckoutnum(CollectionUtils.isNotEmpty(checkoutList) ? checkoutList.size() + "" : "0");//封装正在结账数
                tableTypeStatus.setUsenum(CollectionUtils.isNotEmpty(useList) ? useList.size() + "" : "0");//封装正在用餐数量
                UserStoreQueueExample userStoreQueueExample = new UserStoreQueueExample();
                userStoreQueueExample.createCriteria().andShopEntityIdEqualTo(shopEntityId).andIsEliminationEqualTo("N").andIsDelEqualTo("N").andQueueTypeEqualTo(shopTableTypeManage.getTableTypeCode());
                userStoreQueueExample.setOrderByClause("queue_no ASC");
                List<UserStoreQueue> userStoreQueueList = this.userStoreQueueGeneratorQueryService.selectByExample(userStoreQueueExample);
                if (CollectionUtils.isNotEmpty(userStoreQueueList))
                {
                    List<String> queueList = new ArrayList<String>();
                    for (UserStoreQueue userStoreQueue : userStoreQueueList)
                    {
                        if (userStoreQueue.getQueueNo() != null)
                        {
                            queueList.add(userStoreQueue.getQueueNo().toString());
                        }
                    }
                    tableTypeStatus.setQueuenum(queueList.size() + "");//封装共有多少人排队等待使用当前类型的桌子
                    tableTypeStatus.setQueueList(queueList);//封装排队号码列表
                }
                else
                {
                    tableTypeStatus.setQueuenum("0");//封装共有多少人排队等待使用当前类型的桌子
                    tableTypeStatus.setQueueList(null);//封装排队号码列表
                }
                tableTypeStatusList.add(tableTypeStatus);
            }
        }
        return tableTypeStatusList;
    }

    @Override
    public List<TableStatusByType> findTableStatusByType(String shopEntityId, String tableTypeCode, String tableName, Integer pageIndex, Integer pageSize) throws Exception
    {
        //餐桌状态相关查询信息存放List
        List<TableStatusByType> tableStatusByTypeList = null;

        //按餐桌类型或按实体店编号从缓存中查询的餐桌状态相关信息存放List<Map<String, String>>
        List<Map<String, String>> tableInfoCacheList = null;

        //按餐桌名称从缓存中查询的餐桌状态相关信息存放Map<String, String>
        Map<String, String> oneTableMap = null;

        if (StringUtils.hasText(tableName))
        {
            //1.按餐桌名称查询餐桌状态
            oneTableMap = this.tableCacheQueryService.findTableInfoByTableName(shopEntityId, tableName);
        }
        else if (StringUtils.hasText(tableTypeCode))
        {
            //2.按餐桌类型编码查询餐桌状态
            //根据餐桌类型查询出餐桌类型名称
            tableInfoCacheList = this.tableCacheQueryService.findTableInfoByTableType(shopEntityId, tableTypeCode);
        }
        else
        {
            //3.查询所有餐桌类型餐桌状态
            tableInfoCacheList = this.tableCacheQueryService.findTableInfo(shopEntityId);
        }

        //4.判断查询出来的餐桌状态信息来源
        if (CollectionUtils.isEmpty(tableInfoCacheList) && oneTableMap != null)
        {//表示按餐桌名称,并把查询到的Map<String,String>组合到List<Map<String, String>>中，便于后续查订单信息
            tableInfoCacheList = new ArrayList<Map<String, String>>();
            tableInfoCacheList.add(oneTableMap);
        }
        else if (tableInfoCacheList == null && oneTableMap == null)
        {//未查询到数据
            GooagooLog.warn("未查询为信息为:【shopEntityId=" + shopEntityId + " ,tableTypeCode=" + tableTypeCode + " ,tableName=" + tableName + "】的餐桌信息");
            return null;
        }

        //4.查询餐桌对应订单相关信息
        if (CollectionUtils.isNotEmpty(tableInfoCacheList))
        {
            tableStatusByTypeList = new ArrayList<TableStatusByType>();
            for (Map<String, String> tableInfoCache : tableInfoCacheList)
            {
                TableStatusByType tableStatusByType = new TableStatusByType();
                tableStatusByType.setTableName(tableInfoCache.get("tablename"));//桌号
                tableStatusByType.setTableStatus(tableInfoCache.get("tablestate"));//封装餐桌状态
                tableStatusByType.setTabletypecode(tableInfoCache.get("tabletypecode"));
                if ("1".equals(tableInfoCache.get("tablestate")))
                {//餐桌状态空闲，无需查后续订单信息
                    tableStatusByType.setMealtime("00:00:00");//用餐时间
                    tableStatusByType.setDishesnum("0");
                    tableStatusByType.setIschecknum("0");
                    tableStatusByType.setNotchecknum("0");
                    tableStatusByTypeList.add(tableStatusByType);
                    continue;
                }
                //对应的最后一个订单信息
                OrderInfoExample orderInfoExample = new OrderInfoExample();
                orderInfoExample.createCriteria().andShopEntityIdEqualTo(shopEntityId).andDeskNameEqualTo(tableInfoCache.get("tablename")).andBillTypeNotEqualTo("3").andIsDelEqualTo("N");
                orderInfoExample.setOrderByClause("c_time_stamp DESC");
                List<OrderInfo> orderInfoList = this.orderInfoGeneratorQueryService.selectByExample(orderInfoExample);
                if (CollectionUtils.isNotEmpty(orderInfoList))
                {
                    OrderInfo orderInfo = orderInfoList.get(0);
                    tableStatusByType.setOrderid(orderInfo.getOrderId());
                    //点菜总数
                    Integer dishesnum = orderInfo.getGoodsTotalNum() != null ? orderInfo.getGoodsTotalNum() : 0;
                    tableStatusByType.setDishesnum(dishesnum.toString());//封装用户总共点菜总数
                    Integer ischecknum = 0;//已上菜品数
                    //订单商品详细信息
                    OrderDetailInfoExample orderDetailInfoExample = new OrderDetailInfoExample();
                    orderDetailInfoExample.createCriteria().andOrderIdEqualTo(orderInfo.getOrderId());
                    List<OrderDetailInfo> orderDetailInfoList = this.orderDetailInfoGeneratorQueryService.selectByExample(orderDetailInfoExample);
                    if (CollectionUtils.isNotEmpty(orderDetailInfoList))
                    {
                        for (OrderDetailInfo orderDetailInfo : orderDetailInfoList)
                        {
                            ischecknum += orderDetailInfo.getServeNum();
                        }
                    }
                    tableStatusByType.setIschecknum(ischecknum.toString());//封装已上菜品数
                    Integer notchecknum = dishesnum - ischecknum;//未上菜品数
                    tableStatusByType.setNotchecknum(notchecknum.toString());//封装未上菜品数
                    int minute = TimeUtils.dateDiff(5, orderInfo.getCreateTime(), new Date());
                    String mealtime = this.formatMinutes(minute);
                    tableStatusByType.setMealtime(mealtime);//用户用餐时长
                    tableStatusByType.setUserordertime(TimeUtils.convertDateToString(orderInfo.getUserOrderTime(), TimeUtils.FORMAT1));
                    if (orderInfo.getScardNo() != null)
                    {//是会员的账单
                        tableStatusByType.setIsvip("1");
                        tableStatusByType.setScardno(orderInfo.getScardNo());
                    }
                    else
                    {
                        tableStatusByType.setIsvip("0");
                    }

                }
                tableStatusByTypeList.add(tableStatusByType);
            }
        }
        return tableStatusByTypeList;
    }

    @Override
    public List<TableStatus> findTableStatus(String shopEntityId, Integer pageIndex, Integer pageSize) throws Exception
    {
        List<TableStatus> tableStatusList = null;
        ShopTableInfoExample shopTableInfoExample = new ShopTableInfoExample();
        Criteria criteria = shopTableInfoExample.createCriteria();
        criteria.andShopEntityIdEqualTo(shopEntityId).andIsDelEqualTo("N");
        if (pageIndex != null && pageSize != null)
        {
            shopTableInfoExample.setPage(pageIndex, pageSize);
        }
        shopTableInfoExample.setOrderByClause("table_name asc");
        //餐厅桌号信息表
        List<ShopTableInfo> shopTableInfoList = this.shopTableInfoGeneratorQueryService.selectByExample(shopTableInfoExample);
        if (CollectionUtils.isNotEmpty(shopTableInfoList))
        {
            tableStatusList = new ArrayList<TableStatus>();
            for (ShopTableInfo shopTableInfo : shopTableInfoList)
            {
                //餐桌类型管理
                ShopTableTypeManage shopTableTypeManage = this.shopTableTypeManageGeneratorQueryService.selectUnDelByPrimaryKey(shopTableInfo.getTableTypeCode());
                if (shopTableTypeManage != null)
                {
                    TableStatus tableStatus = new TableStatus();
                    tableStatus.setTableName(shopTableInfo.getTableName());
                    tableStatus.setDeskStatus(shopTableInfo.getStatus());
                    tableStatus.setMinNums(shopTableTypeManage.getMinNums() != null ? shopTableTypeManage.getMinNums().toString() : "0");
                    tableStatus.setMaxNums(shopTableTypeManage.getMaxNums() != null ? shopTableTypeManage.getMaxNums().toString() : "0");
                    tableStatus.setMealTime(TimeUtils.convertDateToString(shopTableTypeManage.getCTimeStamp(), TimeUtils.FORMAT5));
                    tableStatusList.add(tableStatus);
                }
            }
        }
        return tableStatusList;
    }

    @Override
    public List<TableDiningStatus> findTableDiningStatus(String shopEntityId, String tableName, Integer pageIndex, Integer pageSize) throws Exception
    {
        List<TableDiningStatus> tableDiningStatusList = null;
        OrderInfoExample orderInfoExample = new OrderInfoExample();
        com.gooagoo.entity.generator.bill.OrderInfoExample.Criteria criteria = orderInfoExample.createCriteria();
        if (StringUtils.hasText(tableName))
        {
            criteria.andDeskNameEqualTo(tableName);
        }
        criteria.andBillTypeNotEqualTo("3").andShopEntityIdEqualTo(shopEntityId).andIsDelEqualTo("N").andDeskNameIsNotNull();
        orderInfoExample.setPage(pageIndex, pageSize);
        List<OrderInfo> orderInfoList = this.orderInfoGeneratorQueryService.selectByExample(orderInfoExample);
        if (CollectionUtils.isNotEmpty(orderInfoList))
        {
            tableDiningStatusList = new ArrayList<TableDiningStatus>();
            for (OrderInfo orderInfo : orderInfoList)
            {
                Map<String, String> tableCache = this.tableCacheQueryService.findTableInfoByTableName(shopEntityId, orderInfo.getDeskName());
                if (tableCache != null && tableCache.size() > 0)
                {
                    GooagooLog.debug("在缓存中未查询到餐桌状态信息【shopEntityId=" + shopEntityId + " ,tableName=" + orderInfo.getDeskName() + "】");

                    TableDiningStatus tableDiningStatus = new TableDiningStatus();
                    tableDiningStatus.setTableName(orderInfo.getDeskName());
                    tableDiningStatus.setScardno(orderInfo.getScardNo());//会员卡音频编号
                    tableDiningStatus.setMemberType(StringUtils.hasText(orderInfo.getScardNo()) ? "0" : "1");//餐桌上客户类型 0-会员 1-非会员
                    //redis获取
                    tableDiningStatus.setTabletypecode(tableCache.get("tabletypecode"));//餐桌类型编号
                    tableDiningStatus.setTableTypeName(tableCache.get("tabletype"));//餐桌类型名称
                    tableDiningStatus.setTableStatus(tableCache.get("tablestate"));//餐桌状态
                    int minute = TimeUtils.dateDiff(5, orderInfo.getCreateTime(), new Date());
                    String mealtime = this.formatMinutes(minute);
                    tableDiningStatus.setMealtime(mealtime);
                    tableDiningStatus.setUserordertime(orderInfo.getUserOrderTime() != null ? TimeUtils.convertDateToString(orderInfo.getUserOrderTime(), TimeUtils.FORMAT1) : "");
                    tableDiningStatusList.add(tableDiningStatus);
                }
            }
        }
        return tableDiningStatusList;
    }

    @Override
    public List<Map<String, String>> findOpenTable(String mac, String shopEntityId, String ctimestamp) throws Exception
    {
        return this.shopProtectedQueryService.findByType(mac, shopEntityId, ctimestamp, "4");
    }

    @Override
    public List<Map<String, String>> findClearTable(String mac, String shopEntityId, String ctimestamp) throws Exception
    {
        return this.shopProtectedQueryService.findByType(mac, shopEntityId, ctimestamp, "7");
    }

    /**
     * 分钟转换小时:分:秒
     * @param minute
     * @return HH:mm:ss
     */
    private String formatMinutes(Integer minute)
    {
        String h = new Integer(minute / 60).toString();
        String m = new Integer(minute % 60).toString();
        if (h.length() == 1)
        {
            h = "0" + h;
        }
        if (m.length() == 1)
        {
            m = "0" + m;
        }
        return h + ":" + m + ":00";
    }

}
