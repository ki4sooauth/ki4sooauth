package com.gooagoo.api.business.query.user.invoice;

import java.util.List;

import com.gooagoo.entity.generator.user.ReceiptInfo;

public interface InvoiceQueryService
{

    /**
     * 查询会员发票抬头常用信息
     * gasm01
     * @param scardno
     * @param userId
     * @return
     */
    public List<ReceiptInfo> findInvoice(String scardno, String userId);

}
