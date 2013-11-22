package com.gooagoo.trans.api.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.shop.cache.TableCacheCoreService;
import com.gooagoo.api.business.core.transaction.cache.OrderCacheCoreService;
import com.gooagoo.api.business.query.shop.table.TableStatusQueryService;
import com.gooagoo.api.business.query.transaction.apply.ApplyQueryService;
import com.gooagoo.api.business.query.transaction.order.ChangeTableQueryService;
import com.gooagoo.api.business.query.transaction.order.OrderQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.entity.business.transaction.OrderBusiness;
import com.gooagoo.entity.generator.bill.BillAddInfo;
import com.gooagoo.exception.MessageException;
import com.gooagoo.trans.api.TableManagerTransService;
import com.gooagoo.trans.common.MessageConst;
import com.gooagoo.trans.entity.gtsc19.transform.OpenTableRoot;
import com.gooagoo.trans.entity.gtsc19.transform.Opentablelist;
import com.gooagoo.trans.entity.gtsc20.transform.ExchangeTableRoot;
import com.gooagoo.trans.entity.gtsc20.transform.Exchangetablelist;
import com.gooagoo.trans.entity.gtsc21.transform.MergerTableRoot;
import com.gooagoo.trans.entity.gtsc21.transform.Mergertablelist;
import com.gooagoo.trans.entity.gtsc22.transform.CancelTableRoot;
import com.gooagoo.trans.entity.gtsc22.transform.Canceltablelist;
import com.gooagoo.trans.entity.gtsc23.transform.UpdatePeopleNumsRoot;
import com.gooagoo.trans.entity.gtsc23.transform.Updatepeoplenumslist;
import com.gooagoo.trans.entity.gtsc24.transform.BackDishRoot;
import com.gooagoo.trans.entity.gtsc24.transform.Backdishlist;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service
public class TableManagerTransServiceImpl implements TableManagerTransService
{
    @Autowired
    private ApplyQueryService applyQueryService;
    @Autowired
    private TableStatusQueryService tableStatusQueryService;
    @Autowired
    private ChangeTableQueryService changeTableQueryService;
    @Autowired
    private OrderQueryService orderQueryService;
    @Autowired
    private OrderCacheCoreService orderCacheCoreService;
    @Autowired
    private TableCacheCoreService tableCacheCoreService;

    @Override
    public OpenTableRoot getopenTableInfo(String mac, String shopEntityId, String cTimeStamp) throws Exception
    {
        GooagooLog.info("查询开台请求信息(getopenTableInfo)-->入参为:【shopEntityId=" + shopEntityId + " ,cTimeStamp=" + cTimeStamp + " ,mac=" + mac + "】");
        //查询开台请求信息
        List<Map<String, String>> findOpenTable = this.tableStatusQueryService.findOpenTable(mac, shopEntityId, cTimeStamp);
        GooagooLog.debug("查询开台请求信息：" + new Gson().toJson(findOpenTable));
        List<Opentablelist> opentablelist = null;
        if (CollectionUtils.isNotEmpty(findOpenTable))
        {

            opentablelist = new ArrayList<Opentablelist>();
            for (Map<String, String> map : findOpenTable)
            {
                Opentablelist inoflist = new Opentablelist();
                inoflist.setOpenid(map.get("openid"));
                inoflist.setTablename(map.get("tablename"));
                inoflist.setGuestsnumber(map.get("guestsnumber"));
                inoflist.setCtimestamp(map.get("ctimestamp"));
                opentablelist.add(inoflist);
            }
        }
        OpenTableRoot root = new OpenTableRoot();
        root.setOpentablelist(opentablelist);
        return root;
    }

    @Override
    public ExchangeTableRoot getExchangeTableInfo(String mac, String shopEntityId, String cTimeStamp) throws Exception
    {
        GooagooLog.info("查询换台请求信息(getExchangeTableInfo)-->入参为:【shopEntityId=" + shopEntityId + " ,cTimeStamp=" + cTimeStamp + " ,mac=" + mac + "】");
        //查询换台请求信息
        List<Map<String, String>> findMergeTable = this.changeTableQueryService.findExchangeTable(mac, shopEntityId, cTimeStamp);
        GooagooLog.debug("查询换台请求信息：" + new Gson().toJson(findMergeTable));
        List<Exchangetablelist> exchangetablelist = null;
        if (CollectionUtils.isNotEmpty(findMergeTable))
        {

            exchangetablelist = new ArrayList<Exchangetablelist>();
            for (Map<String, String> map : findMergeTable)
            {
                Exchangetablelist tablelist = new Exchangetablelist();
                tablelist.setCtimestamp(map.get("ctimestamp"));
                tablelist.setExchangeid(map.get("exchangeid"));
                tablelist.setOldtablename(map.get("oldtablename"));
                tablelist.setNewtablename(map.get("newtablename"));
                exchangetablelist.add(tablelist);
            }
        }
        ExchangeTableRoot root = new ExchangeTableRoot();
        root.setExchangetablelist(exchangetablelist);
        return root;
    }

    @Override
    public MergerTableRoot getMergerTableInfo(String mac, String shopEntityId, String cTimeStamp) throws Exception
    {
        GooagooLog.info("查询并台请求信息(getMergerTableInfo)-->入参为:【shopEntityId=" + shopEntityId + " ,cTimeStamp=" + cTimeStamp + " ,mac=" + mac + "】");
        //查询并台请求信息
        List<Map<String, String>> findExchangeTable = this.changeTableQueryService.findMergeTable(mac, shopEntityId, cTimeStamp);
        GooagooLog.debug("查询并台请求信息：" + new Gson().toJson(findExchangeTable));
        List<Mergertablelist> mergertablelist = null;
        if (CollectionUtils.isNotEmpty(findExchangeTable))
        {

            mergertablelist = new ArrayList<Mergertablelist>();
            for (Map<String, String> map : findExchangeTable)
            {
                Mergertablelist tablelist = new Mergertablelist();
                tablelist.setMergerid(map.get("mergerid"));
                tablelist.setCtimestamp(map.get("ctimestamp"));
                tablelist.setTablename(map.get("tablename"));
                tablelist.setOthertablename(map.get("othertablename"));
                mergertablelist.add(tablelist);
            }
        }
        MergerTableRoot root = new MergerTableRoot();
        root.setMergertablelist(mergertablelist);
        return root;
    }

    @Override
    public CancelTableRoot getCancelTableInfo(String mac, String shopEntityId, String cTimeStamp) throws Exception
    {
        GooagooLog.info("商家查询撤台请求(getCancelTableInfo)-->入参为:【shopEntityId=" + shopEntityId + " ,cTimeStamp=" + cTimeStamp + " ,mac=" + mac + "】");
        //商家查询撤台请求
        List<Map<String, String>> findClearTable = this.tableStatusQueryService.findClearTable(mac, shopEntityId, cTimeStamp);
        GooagooLog.debug("商家查询撤台请求信息：" + new Gson().toJson(findClearTable));
        List<Canceltablelist> canceltablelist = null;
        if (CollectionUtils.isNotEmpty(findClearTable))
        {

            canceltablelist = new ArrayList<Canceltablelist>();
            for (Map<String, String> map : findClearTable)
            {
                Canceltablelist tablelist = new Canceltablelist();
                tablelist.setCancelid(map.get("cancelid"));
                tablelist.setTablename(map.get("tablename"));
                tablelist.setCancelid(map.get("ctimestamp"));
                canceltablelist.add(tablelist);
            }
        }
        CancelTableRoot root = new CancelTableRoot();
        root.setCanceltablelist(canceltablelist);
        return root;
    }

    @Override
    public UpdatePeopleNumsRoot getUpdatePeopleNumsInfo(String mac, String shopEntityId, String cTimeStamp) throws Exception
    {
        GooagooLog.info("查询修改台头请求信息(getbackDishInfo)-->入参为:【shopEntityId=" + shopEntityId + " ,cTimeStamp=" + cTimeStamp + "】");
        //查询修改台头请求
        List<Map<String, String>> findDiningNumbers = this.orderQueryService.findDiningNumbers(mac, shopEntityId, cTimeStamp);
        GooagooLog.debug("查询修改台头求信息：" + new Gson().toJson(findDiningNumbers));
        List<Updatepeoplenumslist> updatepeoplenumslist = null;
        if (CollectionUtils.isNotEmpty(findDiningNumbers))
        {

            updatepeoplenumslist = new ArrayList<Updatepeoplenumslist>();
            for (Map<String, String> map : findDiningNumbers)
            {
                Updatepeoplenumslist updatepeoplenums = new Updatepeoplenumslist();
                updatepeoplenums.setCtimestamp(map.get("ctimestamp"));
                updatepeoplenums.setUpdateheaderid(map.get("updateheaderid"));
                updatepeoplenums.setTablename(map.get("tablename"));
                updatepeoplenums.setGuestsnumber(map.get("guestsnumber"));
                updatepeoplenumslist.add(updatepeoplenums);
            }
        }
        UpdatePeopleNumsRoot root = new UpdatePeopleNumsRoot();
        root.setUpdatepeoplenumslist(updatepeoplenumslist);
        return root;
    }

    @Override
    public BackDishRoot getbackDishInfo(String shopEntityId, String cTimeStamp) throws Exception
    {
        GooagooLog.info("查询退菜请求信息(getbackDishInfo)-->入参为:【shopEntityId=" + shopEntityId + " ,cTimeStamp=" + cTimeStamp + "】");
        //商家查询退菜请求
        List<OrderBusiness> findAddApplyInfo = this.applyQueryService.findAddApplyInfo(shopEntityId, cTimeStamp, "1");
        GooagooLog.debug("查询退菜请求信息：" + new Gson().toJson(findAddApplyInfo));
        List<Backdishlist> backdishlist = null;
        if (CollectionUtils.isNotEmpty(findAddApplyInfo))
        {
            backdishlist = new ArrayList<Backdishlist>();
            for (OrderBusiness temp : findAddApplyInfo)
            {

                if (CollectionUtils.isNotEmpty(temp.getBillAddInfoList()))
                {

                    for (BillAddInfo billAddInfo : temp.getBillAddInfoList())
                    {
                        Backdishlist backdish = new Backdishlist();
                        backdish.setTablename(temp.getOrderInfo().getDeskName());
                        backdish.setCtimestamp(TimeUtils.convertDateToString(billAddInfo.getCTimeStamp(), TimeUtils.FORMAT1));
                        backdish.setOrderid(billAddInfo.getOrderId());
                        backdish.setItemserial(billAddInfo.getItemSerial());
                        backdish.setGoodsnum(billAddInfo.getGoodsNum().toString());
                        //backdish.setBackdishreason(backdishreason)退菜理由
                        //backdish.setOnepairnumber(onepairnumber)单位
                        backdishlist.add(backdish);
                    }
                }
            }
        }
        BackDishRoot root = new BackDishRoot();
        root.setBackdishlist(backdishlist);
        return root;
    }

    @Override
    public boolean getbillDetailInfo(String mac, String shopEntityId, String dataDetail, String cTimeStamp) throws Exception
    {
        GooagooLog.info("平台查询博立协议的账单明细(getbillDetailInfo)-->入参为:【mac=" + mac + " ,shopEntityId=" + shopEntityId + ",dataDetail=" + dataDetail + ",cTimeStamp=" + cTimeStamp + " 】");
        boolean flag = this.orderCacheCoreService.addOrder(shopEntityId, dataDetail);
        if (!flag)
        {
            throw new MessageException(MessageConst.TRANS_BILL_UPLOAD_THIRDSHOP_BILLDETAIL_FAIL);
        }
        return true;
    }

    @Override
    public boolean saveTableState(String mac, String shopEntityId, String cTimeStamp, String tablesInfo) throws Exception
    {
        GooagooLog.info("平台查询博立协议的房台汇总信息(saveTableState)-->入参为:【shopEntityId=" + shopEntityId + ",tablesInfo=" + tablesInfo + ",cTimeStamp=" + cTimeStamp + " 】");
        List<Map<String, String>> tablesInfoMapList = new Gson().fromJson(tablesInfo, new TypeToken<List<Map<String, String>>>()
        {
        }.getType());

        boolean flag = this.tableCacheCoreService.updateTableStatus(mac, shopEntityId, tablesInfoMapList);
        if (!flag)
        {
            throw new MessageException(MessageConst.TRANS_BILL_UPLOAD_THIRDSHOP_TOTAL_TABLESTATUS_FAIL);
        }
        return true;
    }
}
