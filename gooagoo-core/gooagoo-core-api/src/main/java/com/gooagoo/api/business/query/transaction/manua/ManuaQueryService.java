package com.gooagoo.api.business.query.transaction.manua;

import java.util.List;

import com.gooagoo.entity.generator.bill.BillManual;

public interface ManuaQueryService
{

    /**
     * 4.3.9. 手工账单列表（分页）
     * @param userId
     * @return  List<BillManual>
     * @throws Exception
     */
    public List<BillManual> findBillManualList(String userId) throws Exception;

}
