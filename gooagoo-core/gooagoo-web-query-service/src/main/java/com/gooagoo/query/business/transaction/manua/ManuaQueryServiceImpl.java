package com.gooagoo.query.business.transaction.manua;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.transaction.manua.ManuaQueryService;
import com.gooagoo.entity.generator.bill.BillManual;

@Service
public class ManuaQueryServiceImpl implements ManuaQueryService
{

    @Override
    public List<BillManual> findBillManualList(String userId) throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }

}
