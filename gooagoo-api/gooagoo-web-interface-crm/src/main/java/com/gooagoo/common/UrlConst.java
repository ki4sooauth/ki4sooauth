package com.gooagoo.common;

/**
 * http服務訪問地址
 */
public class UrlConst
{
    /**
     * 營銷分析服務訪問url
     */
    public final static String ANALYSIS_URL = "http://analysis.goo.com/marketing.do?";

    /**
     * 訂單支付服務訪問url
     */
    public final static String ORDER_PAY_URL = "http://42.120.44.68:8015/unpayinterface.aspx?action=pay";

    /**
     * 訂單支付狀態查詢服務訪問url
     */
    public final static String ORDER_TRANSACTIONSTATUS_URL = "http://42.120.44.68:8015/unpayinterface.aspx?action=query";

    /**
     * 拍了付异步回调接口url
     */
    public final static String BACK_END_URL = "http://113.208.116.22:9090/paylf/plf.do?itype=plf01";
}
