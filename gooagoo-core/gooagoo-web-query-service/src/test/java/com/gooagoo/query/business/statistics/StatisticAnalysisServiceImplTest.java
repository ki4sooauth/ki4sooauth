package com.gooagoo.query.business.statistics;

import java.util.ArrayList;
import java.util.List;

import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.business.statistics.ColumnVO;
import com.gooagoo.entity.business.user.account.Account;

import junit.framework.TestCase;

public class StatisticAnalysisServiceImplTest extends TestCase
{
    private StatisticAnalysisServiceImpl service = new StatisticAnalysisServiceImpl();
    
    private List<Account> getAccounts(){
        List<Account> accounts = new ArrayList<Account>();
        Account obj = new Account();
        obj.setUserId("01839G3JBDN5QCN00EA3SUQLM4II12PC");
        accounts.add(obj);
        obj = new Account();
        obj.setUserId("01839G3J4J7SUJV00EA3RMQLM4II12PC");
        accounts.add(obj);
        return accounts;
    }
    
    public void testGetShoppingPeriod()
    {
        List<ColumnVO> list = this.service.getShoppingPeriod("shop_000", "2012-12-12", "2013-12-20", getAccounts(), UUID.getUUID());
        for(ColumnVO obj:list){
            System.out.println(obj.getLable()+"------"+obj.getValue());
        }
    }

    public void testGetNumberOfArriveShop()
    {
        fail("Not yet implemented");
    }

    public void testGetRateOfPurchase()
    {
        fail("Not yet implemented");
    }

    public void testGetAveragePriceRange()
    {
        fail("Not yet implemented");
    }

    public void testGetBrowseCouponsFrequency()
    {
        fail("Not yet implemented");
    }

    public void testGetPhoneInteractionFrequency()
    {
        fail("Not yet implemented");
    }

    public void testGetOpenCryoutFrequency()
    {
        fail("Not yet implemented");
    }

    public void testGetCollectionCouponsFrequency()
    {
        fail("Not yet implemented");
    }

    public void testGetCryoutResponseTime()
    {
        fail("Not yet implemented");
    }

    public void testGetNoticeResponseTime()
    {
        fail("Not yet implemented");
    }

    public void testGetFavoritesCategory()
    {
        fail("Not yet implemented");
    }

    public void testGetConsumeCategory()
    {
        fail("Not yet implemented");
    }
}
