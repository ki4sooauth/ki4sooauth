package com.gooagoo.mobile.entity.mobe01.transform;

import java.io.Serializable;

/**
 * 账单信息 
 */
public class Billlistg implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 账单id  */
	private String billid = "";

	/** 账单类型（类型，0-订单，3-账单）  */
	private String billtype = "";

	/** 商家订单编号  */
	private String orderid = "";

	/**  訂單所屬行業類型,0-餐飲業, 1-零售業  */
	private String industrytype = "";

	/**  商家类型编号（根节点) */
	private String shoptypeid = "";

	/**  商家类型名称（根节点) */
	private String shoptypename = "";

	/** 店铺id  */
	private String shopid = "";

	/** 实体店编号  */
	private String shopentityid = "";

	/** 用户id  */
	private String userid = "";

	/** 账单得到时间（手机端用以表示消费时间）  */
	private String requesttime = "";

	/** 用户卡id  */
	private String scardno = "";

	/** 打折率  */
	private String discountrate = "";

	/** 商品累计数，当前订单商品总数  */
	private String goodstotalnum = "";

	/** 原始总价  */
	private String originalprice = "";

	/** 实收总价  */
	private String payprice = "";

	/** 本次积分  */
	private String integralnumber = "";

	/**   取货状态Y-已取货、N-未取货  */
	private String deliverystatus = "";

	/**  是否提交开发票申请,Y-已提交  N-未提交  */
	private String isapplicationinvoice = "";

	/** 是否开具发票，N-未开发票，Y-已开发票  */
	private String isinvoiced = "";

	/** 开票时间  */
	private String invoicedtime = "";

	/** 是否删除  */
	private String isdel = "";

	/** 时间戳  */
	private String ctimestamp = "";

	/** 账单图片，如有多个，以json保存，如["year","month"]  */
	private String billimg = "";

	/** 最晚开发票时间  */
	private String latestinvoicetime = "";

	/** 账单中的取货凭证二维码  */
	private String proofcode = "";

	/** 账单商品列表  */
	private java.util.List<Goodslistg> goodslistg = new java.util.ArrayList<Goodslistg>();

	/**
	 * 设置账单id 
	 * @param billid	账单id 
	 */
	public void setBillid(String billid)
	{
		this.billid = billid != null ? billid : "";
	}

	/**
	 * 获取账单id 
	 * @return	账单id 
	 */
	public String getBillid()
	{
		return this.billid;
	}

	/**
	 * 设置账单类型（类型，0-订单，3-账单） 
	 * @param billtype	账单类型（类型，0-订单，3-账单） 
	 */
	public void setBilltype(String billtype)
	{
		this.billtype = billtype != null ? billtype : "";
	}

	/**
	 * 获取账单类型（类型，0-订单，3-账单） 
	 * @return	账单类型（类型，0-订单，3-账单） 
	 */
	public String getBilltype()
	{
		return this.billtype;
	}

	/**
	 * 设置商家订单编号 
	 * @param orderid	商家订单编号 
	 */
	public void setOrderid(String orderid)
	{
		this.orderid = orderid != null ? orderid : "";
	}

	/**
	 * 获取商家订单编号 
	 * @return	商家订单编号 
	 */
	public String getOrderid()
	{
		return this.orderid;
	}

	/**
	 * 设置 訂單所屬行業類型,0-餐飲業, 1-零售業 
	 * @param industrytype	 訂單所屬行業類型,0-餐飲業, 1-零售業 
	 */
	public void setIndustrytype(String industrytype)
	{
		this.industrytype = industrytype != null ? industrytype : "";
	}

	/**
	 * 获取 訂單所屬行業類型,0-餐飲業, 1-零售業 
	 * @return	 訂單所屬行業類型,0-餐飲業, 1-零售業 
	 */
	public String getIndustrytype()
	{
		return this.industrytype;
	}

	/**
	 * 设置 商家类型编号（根节点)
	 * @param shoptypeid	 商家类型编号（根节点)
	 */
	public void setShoptypeid(String shoptypeid)
	{
		this.shoptypeid = shoptypeid != null ? shoptypeid : "";
	}

	/**
	 * 获取 商家类型编号（根节点)
	 * @return	 商家类型编号（根节点)
	 */
	public String getShoptypeid()
	{
		return this.shoptypeid;
	}

	/**
	 * 设置 商家类型名称（根节点)
	 * @param shoptypename	 商家类型名称（根节点)
	 */
	public void setShoptypename(String shoptypename)
	{
		this.shoptypename = shoptypename != null ? shoptypename : "";
	}

	/**
	 * 获取 商家类型名称（根节点)
	 * @return	 商家类型名称（根节点)
	 */
	public String getShoptypename()
	{
		return this.shoptypename;
	}

	/**
	 * 设置店铺id 
	 * @param shopid	店铺id 
	 */
	public void setShopid(String shopid)
	{
		this.shopid = shopid != null ? shopid : "";
	}

	/**
	 * 获取店铺id 
	 * @return	店铺id 
	 */
	public String getShopid()
	{
		return this.shopid;
	}

	/**
	 * 设置实体店编号 
	 * @param shopentityid	实体店编号 
	 */
	public void setShopentityid(String shopentityid)
	{
		this.shopentityid = shopentityid != null ? shopentityid : "";
	}

	/**
	 * 获取实体店编号 
	 * @return	实体店编号 
	 */
	public String getShopentityid()
	{
		return this.shopentityid;
	}

	/**
	 * 设置用户id 
	 * @param userid	用户id 
	 */
	public void setUserid(String userid)
	{
		this.userid = userid != null ? userid : "";
	}

	/**
	 * 获取用户id 
	 * @return	用户id 
	 */
	public String getUserid()
	{
		return this.userid;
	}

	/**
	 * 设置账单得到时间（手机端用以表示消费时间） 
	 * @param requesttime	账单得到时间（手机端用以表示消费时间） 
	 */
	public void setRequesttime(String requesttime)
	{
		this.requesttime = requesttime != null ? requesttime : "";
	}

	/**
	 * 获取账单得到时间（手机端用以表示消费时间） 
	 * @return	账单得到时间（手机端用以表示消费时间） 
	 */
	public String getRequesttime()
	{
		return this.requesttime;
	}

	/**
	 * 设置用户卡id 
	 * @param scardno	用户卡id 
	 */
	public void setScardno(String scardno)
	{
		this.scardno = scardno != null ? scardno : "";
	}

	/**
	 * 获取用户卡id 
	 * @return	用户卡id 
	 */
	public String getScardno()
	{
		return this.scardno;
	}

	/**
	 * 设置打折率 
	 * @param discountrate	打折率 
	 */
	public void setDiscountrate(String discountrate)
	{
		this.discountrate = discountrate != null ? discountrate : "";
	}

	/**
	 * 获取打折率 
	 * @return	打折率 
	 */
	public String getDiscountrate()
	{
		return this.discountrate;
	}

	/**
	 * 设置商品累计数，当前订单商品总数 
	 * @param goodstotalnum	商品累计数，当前订单商品总数 
	 */
	public void setGoodstotalnum(String goodstotalnum)
	{
		this.goodstotalnum = goodstotalnum != null ? goodstotalnum : "";
	}

	/**
	 * 获取商品累计数，当前订单商品总数 
	 * @return	商品累计数，当前订单商品总数 
	 */
	public String getGoodstotalnum()
	{
		return this.goodstotalnum;
	}

	/**
	 * 设置原始总价 
	 * @param originalprice	原始总价 
	 */
	public void setOriginalprice(String originalprice)
	{
		this.originalprice = originalprice != null ? originalprice : "";
	}

	/**
	 * 获取原始总价 
	 * @return	原始总价 
	 */
	public String getOriginalprice()
	{
		return this.originalprice;
	}

	/**
	 * 设置实收总价 
	 * @param payprice	实收总价 
	 */
	public void setPayprice(String payprice)
	{
		this.payprice = payprice != null ? payprice : "";
	}

	/**
	 * 获取实收总价 
	 * @return	实收总价 
	 */
	public String getPayprice()
	{
		return this.payprice;
	}

	/**
	 * 设置本次积分 
	 * @param integralnumber	本次积分 
	 */
	public void setIntegralnumber(String integralnumber)
	{
		this.integralnumber = integralnumber != null ? integralnumber : "";
	}

	/**
	 * 获取本次积分 
	 * @return	本次积分 
	 */
	public String getIntegralnumber()
	{
		return this.integralnumber;
	}

	/**
	 * 设置  取货状态Y-已取货、N-未取货 
	 * @param deliverystatus	  取货状态Y-已取货、N-未取货 
	 */
	public void setDeliverystatus(String deliverystatus)
	{
		this.deliverystatus = deliverystatus != null ? deliverystatus : "";
	}

	/**
	 * 获取  取货状态Y-已取货、N-未取货 
	 * @return	  取货状态Y-已取货、N-未取货 
	 */
	public String getDeliverystatus()
	{
		return this.deliverystatus;
	}

	/**
	 * 设置 是否提交开发票申请,Y-已提交  N-未提交 
	 * @param isapplicationinvoice	 是否提交开发票申请,Y-已提交  N-未提交 
	 */
	public void setIsapplicationinvoice(String isapplicationinvoice)
	{
		this.isapplicationinvoice = isapplicationinvoice != null ? isapplicationinvoice : "";
	}

	/**
	 * 获取 是否提交开发票申请,Y-已提交  N-未提交 
	 * @return	 是否提交开发票申请,Y-已提交  N-未提交 
	 */
	public String getIsapplicationinvoice()
	{
		return this.isapplicationinvoice;
	}

	/**
	 * 设置是否开具发票，N-未开发票，Y-已开发票 
	 * @param isinvoiced	是否开具发票，N-未开发票，Y-已开发票 
	 */
	public void setIsinvoiced(String isinvoiced)
	{
		this.isinvoiced = isinvoiced != null ? isinvoiced : "";
	}

	/**
	 * 获取是否开具发票，N-未开发票，Y-已开发票 
	 * @return	是否开具发票，N-未开发票，Y-已开发票 
	 */
	public String getIsinvoiced()
	{
		return this.isinvoiced;
	}

	/**
	 * 设置开票时间 
	 * @param invoicedtime	开票时间 
	 */
	public void setInvoicedtime(String invoicedtime)
	{
		this.invoicedtime = invoicedtime != null ? invoicedtime : "";
	}

	/**
	 * 获取开票时间 
	 * @return	开票时间 
	 */
	public String getInvoicedtime()
	{
		return this.invoicedtime;
	}

	/**
	 * 设置是否删除 
	 * @param isdel	是否删除 
	 */
	public void setIsdel(String isdel)
	{
		this.isdel = isdel != null ? isdel : "";
	}

	/**
	 * 获取是否删除 
	 * @return	是否删除 
	 */
	public String getIsdel()
	{
		return this.isdel;
	}

	/**
	 * 设置时间戳 
	 * @param ctimestamp	时间戳 
	 */
	public void setCtimestamp(String ctimestamp)
	{
		this.ctimestamp = ctimestamp != null ? ctimestamp : "";
	}

	/**
	 * 获取时间戳 
	 * @return	时间戳 
	 */
	public String getCtimestamp()
	{
		return this.ctimestamp;
	}

	/**
	 * 设置账单图片，如有多个，以json保存，如["year","month"] 
	 * @param billimg	账单图片，如有多个，以json保存，如["year","month"] 
	 */
	public void setBillimg(String billimg)
	{
		this.billimg = billimg != null ? billimg : "";
	}

	/**
	 * 获取账单图片，如有多个，以json保存，如["year","month"] 
	 * @return	账单图片，如有多个，以json保存，如["year","month"] 
	 */
	public String getBillimg()
	{
		return this.billimg;
	}

	/**
	 * 设置最晚开发票时间 
	 * @param latestinvoicetime	最晚开发票时间 
	 */
	public void setLatestinvoicetime(String latestinvoicetime)
	{
		this.latestinvoicetime = latestinvoicetime != null ? latestinvoicetime : "";
	}

	/**
	 * 获取最晚开发票时间 
	 * @return	最晚开发票时间 
	 */
	public String getLatestinvoicetime()
	{
		return this.latestinvoicetime;
	}

	/**
	 * 设置账单中的取货凭证二维码 
	 * @param proofcode	账单中的取货凭证二维码 
	 */
	public void setProofcode(String proofcode)
	{
		this.proofcode = proofcode != null ? proofcode : "";
	}

	/**
	 * 获取账单中的取货凭证二维码 
	 * @return	账单中的取货凭证二维码 
	 */
	public String getProofcode()
	{
		return this.proofcode;
	}

	/**
	 * 设置账单商品列表 
	 * @param goodslistg	账单商品列表 
	 */
	public void setGoodslistg(java.util.List<Goodslistg> goodslistg)
	{
		this.goodslistg = goodslistg;
	}

	/**
	 * 获取账单商品列表 
	 * @return	账单商品列表 
	 */
	public java.util.List<Goodslistg> getGoodslistg()
	{
		return this.goodslistg;
	}

	/**
	 * 添加账单商品列表 
	 * @return goodslistg	账单商品列表 
	 */
	public Goodslistg addMoreGoodslistg() {
		Goodslistg goodslistg = new Goodslistg();
		this.goodslistg.add(goodslistg);
		return goodslistg;
	}
}