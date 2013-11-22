package com.gooagoo.query.business.user.invoice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.query.user.invoice.InvoiceQueryService;
import com.gooagoo.api.generator.query.member.MemberOfCardGeneratorQueryService;
import com.gooagoo.api.generator.query.user.ReceiptInfoGeneratorQueryService;
import com.gooagoo.entity.generator.member.MemberOfCard;
import com.gooagoo.entity.generator.user.ReceiptInfo;
import com.gooagoo.entity.generator.user.ReceiptInfoExample;

@Service
public class InvoiceQueryServiceImpl implements InvoiceQueryService
{

    @Autowired
    private MemberOfCardGeneratorQueryService memberOfCardGeneratorQueryService;

    @Autowired
    private ReceiptInfoGeneratorQueryService receiptInfoGeneratorQueryService;

    @Override
    public List<ReceiptInfo> findInvoice(String scardno, String userId)
    {
        List<ReceiptInfo> receiptInfoList = null;
        if (!StringUtils.hasText(userId))
        {
            MemberOfCard memberOfCard = this.memberOfCardGeneratorQueryService.selectUnDelByPrimaryKey(scardno);
            if (memberOfCard != null)
            {
                userId = memberOfCard.getUserId();
            }
        }
        ReceiptInfoExample receiptInfoExample = new ReceiptInfoExample();
        receiptInfoExample.createCriteria().andUserIdEqualTo(userId).andIsDelEqualTo("N");
        receiptInfoList = this.receiptInfoGeneratorQueryService.selectByExample(receiptInfoExample);
        return receiptInfoList;
    }

}
