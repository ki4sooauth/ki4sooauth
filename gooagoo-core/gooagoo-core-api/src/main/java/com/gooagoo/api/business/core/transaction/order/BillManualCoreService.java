package com.gooagoo.api.business.core.transaction.order;

import com.gooagoo.entity.generator.bill.BillManual;
import com.gooagoo.exception.common.FormatErrorException;
import com.gooagoo.exception.common.NullException;
import com.gooagoo.exception.common.OperateFailException;

public interface BillManualCoreService

{

    /**
     * 新增手工账单
     * @param billManual
     * @return
     * @throws NullException
     * @throws FormatErrorException
     * @throws OperateFailException
     */
    public boolean addBillManual(BillManual billManual) throws Exception;

    /**
     * 编辑手工账单
     * @param billManual
     * @return
     * @throws NullException
     * @throws FormatErrorException
     * @throws OperateFailException
     */
    public boolean updateBillManual(BillManual billManual) throws Exception;

    /**
     * 删除手工账单
     * @param billId
     * @return
     * @throws NullException
     * @throws OperateFailException
     */
    public boolean deleteBillManual(String billId) throws Exception;

}
