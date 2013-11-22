package com.gooagoo.gas.api.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.shop.queue.ShopQueueCoreService;
import com.gooagoo.api.business.core.shop.table.TableStatusCoreService;
import com.gooagoo.api.business.core.transaction.order.ChangeTableCoreService;
import com.gooagoo.api.business.core.user.queue.QueueCoreService;
import com.gooagoo.api.business.query.goods.cache.GoodsCacheQueryService;
import com.gooagoo.api.business.query.shop.table.TableStatusQueryService;
import com.gooagoo.api.business.query.transaction.order.OrderQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.business.shop.table.TableStatusByType;
import com.gooagoo.entity.business.shop.table.TableTypeStatus;
import com.gooagoo.entity.business.transaction.OrderDetailInfo4TableBusiness;
import com.gooagoo.entity.business.user.QueueBusiness;
import com.gooagoo.entity.generator.bill.OrderDetailInfo;
import com.gooagoo.exception.MessageException;
import com.gooagoo.gas.api.service.DeskLinkGasService;
import com.gooagoo.gas.common.MessageConst;
import com.gooagoo.gas.entity.gasj01.transform.DeskStatusRoot;
import com.gooagoo.gas.entity.gasj01.transform.Deskstatuslist;
import com.gooagoo.gas.entity.gasj02.transform.QueueRoot;
import com.gooagoo.gas.entity.gasj03.transform.DeskStatusDetailRoot;
import com.gooagoo.gas.entity.gasj03.transform.Desklist;
import com.gooagoo.gas.entity.gasj04.transform.GetMenuByDeskNoRoot;
import com.gooagoo.gas.entity.gasj04.transform.Menulist;
import com.gooagoo.gas.entity.gasj06.transform.DeskQueueTrackRoot;
import com.gooagoo.gas.entity.gasj06.transform.Deskqueuetrack;
import com.google.gson.Gson;

@Service
public class DeskLinkGasServiceImpl implements DeskLinkGasService
{
    @Autowired
    private ShopQueueCoreService shopQueueCoreService;
    @Autowired
    private TableStatusQueryService tableStatusQueryService;
    @Autowired
    private QueueCoreService queueCoreService;
    @Autowired
    private OrderQueryService orderQueryService;
    @Autowired
    private TableStatusCoreService tableStatusCoreService;
    @Autowired
    private ChangeTableCoreService changeTableCoreService;
    @Autowired
    private GoodsCacheQueryService goodsCacheQueryService;

    @Override
    public DeskStatusRoot queryDeskStatus(String shopentityid) throws Exception
    {
        GooagooLog.info("queryDeskStatus-->入参:shopEntityId=" + shopentityid);
        //1.店员查询本实体店各类型餐桌状态TableStatusQueryService.findTableTypeStatus
        List<TableTypeStatus> tableStatusList = this.tableStatusQueryService.findTableTypeStatus(null, shopentityid, null, null);
        GooagooLog.debug("店员查询本实体店各类型餐桌状态信息为" + new Gson().toJson(tableStatusList));
        //2.组装返回对象
        List<Deskstatuslist> deskstatuslist = null;
        if (CollectionUtils.isNotEmpty(tableStatusList))
        {
            deskstatuslist = new ArrayList<Deskstatuslist>();
            for (TableTypeStatus temp : tableStatusList)
            {
                Deskstatuslist deskstatus = new Deskstatuslist();
                deskstatus.setTabletypecode(temp.getTableTypeCode());//餐桌类型编码
                deskstatus.setTabletypename(temp.getTableTypeName());//餐桌类型
                deskstatus.setFree(temp.getVacancynum());//空闲数
                deskstatus.setList(temp.getQueuenum());//共有多少人排队等待使用当前类型的桌子
                deskstatus.setOccupancy(temp.getCheckoutnum());//正在结账数 
                deskstatus.setSum(temp.getTableTypeSum());//设置 当前类型餐桌总数，如:3-8人桌总数

                GooagooLog.debug("餐桌总数" + temp.getTableTypeSum() + "餐桌空闲数" + temp.getVacancynum() + "正在结帐数" + temp.getCheckoutnum());
                int usenum = Integer.valueOf(temp.getTableTypeSum()) - (Integer.valueOf(temp.getVacancynum()) + Integer.valueOf(temp.getCheckoutnum()));
                GooagooLog.debug("正在用餐数量,即已点餐数" + usenum);
                deskstatus.setUsenum(String.valueOf(usenum));//正在用餐数量,即已点餐数

                deskstatuslist.add(deskstatus);
            }
        }
        DeskStatusRoot root = new DeskStatusRoot();
        root.setDeskstatuslist(deskstatuslist);

        return root;
    }

    @Override
    public QueueRoot userQueue(String shopId, String shopEntityId, String scardno, String tableTypeCode, String queueNums) throws Exception
    {
        GooagooLog.info("userQueue-->入参:shopId=" + shopId + ",shopEntityId=" + shopEntityId + "scardno=" + scardno + "tableTypeCode=" + tableTypeCode + "queueNums=" + queueNums);
        //1.店员助理给用户排号
        QueueBusiness arranging = this.queueCoreService.arranging(shopId, shopEntityId, scardno, null, tableTypeCode, queueNums);

        GooagooLog.debug("排号信息为：" + new Gson().toJson(arranging));
        if (arranging == null)
        {//餐桌够用无需排号
            throw new MessageException(MessageConst.GAS_QUEUE_DESK_FULFIL_USE);
        }
        //2.封装排号信息
        QueueRoot root = new QueueRoot();

        root.setAlreadyno(arranging.getCurrentqueueno());
        root.setPresent(arranging.getQueueNo());

        return root;
    }

    @Override
    public DeskStatusDetailRoot queryDeskStatusDetails(String shopentityid, String tableTypeCode, String tableName, String pageIndex, String pageSize) throws Exception
    {
        GooagooLog.info("queryDeskStatusDetails-->入参:shopentityid=" + shopentityid + " ,tableTypeCode=" + tableTypeCode + ", tableName=" + tableName + " ,pageIndex=" + pageIndex + " ,pageSize=" + pageSize);
        //1.店员按本实体店的餐桌类型查询餐桌状态详情
        List<TableStatusByType> tableStatusByTypeList = this.tableStatusQueryService.findTableStatusByType(shopentityid, tableTypeCode, tableName, Integer.valueOf(pageIndex), Integer.valueOf(pageSize));
        GooagooLog.debug("店员按本实体店的餐桌类型查询餐桌状态详情信息为：" + new Gson().toJson(tableStatusByTypeList));
        //2.组装返回数据

        List<Desklist> desklist = null;
        if (CollectionUtils.isNotEmpty(tableStatusByTypeList))
        {
            desklist = new ArrayList<Desklist>();
            for (TableStatusByType temp : tableStatusByTypeList)
            {
                Desklist desk = new Desklist();
                desk.setTabletypecode(temp.getTabletypecode());
                desk.setTablename(temp.getTableName());
                desk.setIsvip(temp.getIsvip());
                desk.setTablestate(temp.getTableStatus());
                desk.setOrderid(temp.getOrderid());
                desk.setMealtime(temp.getMealtime());
                desk.setScardno(temp.getScardno());
                desk.setUserordertime(temp.getUserordertime());
                desk.setGoodsnums(temp.getDishesnum());
                desk.setIschecknum(temp.getIschecknum());
                desk.setNotchecknum(temp.getNotchecknum());
                desklist.add(desk);
            }
        }

        DeskStatusDetailRoot root = new DeskStatusDetailRoot();
        root.setDesklist(desklist);
        return root;
    }

    @Override
    public GetMenuByDeskNoRoot queryMenuByDeskNo(String shopEntityId, String tableName, String pageIndex, String pageSize) throws Exception
    {
        GooagooLog.info("queryDeskStatusDetails-->入参:shopEntityId=" + shopEntityId + "tableName=" + tableName + "pageIndex=" + pageIndex + "pageSize=" + pageSize);
        //1.店员扫桌号获取用户点菜单信息
        OrderDetailInfo4TableBusiness detailInfo = this.orderQueryService.findOrderListByTable(shopEntityId, tableName, null, Integer.valueOf(pageIndex), Integer.valueOf(pageSize));

        GooagooLog.debug("店员扫桌号获取用户点菜单信息为：" + new Gson().toJson(detailInfo));

        //2.组装用户点菜单信息
        GetMenuByDeskNoRoot root = new GetMenuByDeskNoRoot();
        if (detailInfo != null)
        {
            root = new GetMenuByDeskNoRoot();
            root.setOrderid(detailInfo.getOrderid());
            root.setOrderurl(detailInfo.getBillimg());
            root.setTotalpay(detailInfo.getPayprice());

            List<Menulist> menulist = null;
            //判断菜品详情列表
            if (CollectionUtils.isNotEmpty(detailInfo.getOrderDetailInfoList()))
            {
                menulist = new ArrayList<Menulist>();
                for (OrderDetailInfo temp : detailInfo.getOrderDetailInfoList())
                {
                    Menulist menu = new Menulist();
                    menu.setFoodid(temp.getItemSerial());
                    //查询商品品类名词
                    Map<String, String> goodsInfoMap = this.goodsCacheQueryService.findGoodsInfo(temp.getGoodsId());
                    if (goodsInfoMap != null && goodsInfoMap.size() > 0)
                    {
                        menu.setFoodkind(goodsInfoMap.get("goodsCategoryLeafName"));//菜品类别名称,(取菜品类别叶节点)
                    }

                    menu.setFoodname(temp.getGoodsName());
                    menu.setFoodprice(temp.getPrice().toString());
                    menu.setFoodspay(temp.getPayPrice().toString());
                    menu.setNum(temp.getGoodsNum().toString());
                    menu.setIscheck(temp.getServeNum().toString());
                    menulist.add(menu);
                }

            }
            root.setMenulist(menulist);
        }

        return root;
    }

    @Override
    public boolean queueCancel(String shopEntityId, String queueno) throws Exception
    {
        GooagooLog.info("queueCancel-->入参:shopEntityId=" + shopEntityId + ",queueno=" + queueno);
        boolean deleteQueueNo = this.shopQueueCoreService.deleteQueueNo(shopEntityId, queueno);
        return deleteQueueNo;
    }

    @Override
    public DeskQueueTrackRoot queryDeskQueueTracks(String shopEntityId, String tableTypeCode) throws Exception
    {
        GooagooLog.info("queryDeskQueueTracks-->入参:【shopEntityId=" + shopEntityId + " ,tableTypeCode=" + tableTypeCode + "】");
        //1.店员查询各类型餐桌排号信息        参数：shopEntityId, tableTypeCode
        List<TableTypeStatus> tableTypeStatusList = this.tableStatusQueryService.findTableTypeStatus(tableTypeCode, shopEntityId, null, null);
        GooagooLog.debug("店员查询到各类型餐桌排号信息：" + new Gson().toJson(tableTypeStatusList));

        //2.组装各类型餐桌排号信息   
        List<Deskqueuetrack> deskqueuetrackList = null;
        if (CollectionUtils.isNotEmpty(tableTypeStatusList))
        {
            deskqueuetrackList = new ArrayList<Deskqueuetrack>();
            for (TableTypeStatus tempTableTypeStatus : tableTypeStatusList)
            {
                Deskqueuetrack deskqueuetrack = new Deskqueuetrack();
                Gson json = new Gson();

                deskqueuetrack.setDeskkind(tempTableTypeStatus.getTableTypeCode());//餐桌类型
                if (CollectionUtils.isNotEmpty(tempTableTypeStatus.getQueueList()))
                {
                    String queuenos = json.toJson(tempTableTypeStatus.getQueueList());
                    deskqueuetrack.setQueuenos(queuenos);//排号记录
                }

                deskqueuetrackList.add(deskqueuetrack);
            }
        }
        //3.组装返回数据
        DeskQueueTrackRoot root = new DeskQueueTrackRoot();
        root.setDeskqueuetrack(deskqueuetrackList);
        return root;
    }

    @Override
    public boolean openTableManage(String shopEntityId, String tableName, String peopleNums) throws Exception
    {
        GooagooLog.info("openTableManage-->入参:【shopEntityId=" + shopEntityId + " ,tableName=" + tableName + " ,peopleNums=" + peopleNums + "】");
        boolean flag = this.tableStatusCoreService.openTable(shopEntityId, tableName, peopleNums);
        if (!flag)
        {
            throw new MessageException(MessageConst.GAS_TABLE_OPEN_FAIL);
        }
        return true;
    }

    @Override
    public boolean clearTableManage(String shopEntityId, String tableName) throws Exception
    {
        GooagooLog.info("clearTableManage-->入参:【shopEntityId=" + shopEntityId + " ,tableName=" + tableName + "】");
        boolean flag = this.tableStatusCoreService.clearTable(shopEntityId, tableName);
        if (!flag)
        {
            throw new MessageException(MessageConst.GAS_TABLE_CLEAR_FAIL);
        }
        return true;
    }

    @Override
    public boolean mergeTableManage(String shopEntityId, String tableNameTo, String tableNameFrom) throws Exception
    {
        GooagooLog.info("mergeTableManage-->入参:【shopEntityId=" + shopEntityId + " ,tableNameTo=" + tableNameTo + " ,tableNameFrom=" + tableNameFrom + "】");
        boolean flag = this.changeTableCoreService.mergeTable(shopEntityId, tableNameFrom, tableNameTo);
        if (!flag)
        {
            throw new MessageException(MessageConst.GAS_TABLE_MERGE_FAIL);
        }
        return true;
    }

    @Override
    public boolean exchangeTableManage(String shopEntityId, String tableNameTo, String tableNameFrom) throws Exception
    {
        GooagooLog.info("mergeTableManage-->入参:【shopEntityId=" + shopEntityId + " ,tableNameTo=" + tableNameTo + " ,tableNameFrom=" + tableNameFrom + "】");
        boolean flag = this.changeTableCoreService.exchangeTable(shopEntityId, tableNameFrom, tableNameTo);
        if (!flag)
        {
            throw new MessageException(MessageConst.GAS_TABLE_EXCHANGE_FAIL);
        }
        return true;
    }
}
