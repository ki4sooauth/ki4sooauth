package com.gooagoo.gas.entity.gase04.transform;

import java.io.Serializable;

/**
 * 商品优惠信息
 */
public class Userbilldetailinfo implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 账单id */
	private String billid = "";

	/** 商品id */
	private String goodsid = "";

	/** 商品名称 */
	private String goodsname = "";

	/** 商品价格 */
	private String goodsprice = "";

	/** 商品数量 */
	private String goodsnum = "";

	/** 商品图片URL，多张图以逗号分隔 */
	private String goodsimg = "";

	/** 商品所属品类的品类编号  */
	private String categoryid = "";

	/** 商品所属品类的品类名称  */
	private String categoryname = "";

	/** 商品所属品类的根节点品类编号  */
	private String rootcategoryid = "";

	/** 商品所属品类的根节点品类名称  */
	private String rootcategoryname = "";

	/** 品牌编号 */
	private String goodsbrandid = "";

	/** 品牌名称 */
	private String goodsbrandname = "";

	/** 产品特征 */
	private java.util.List<Goodsdetailextend> goodsdetailextend = new java.util.ArrayList<Goodsdetailextend>();

	/** 消费时间 */
	private String time = "";

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
	 * 设置商品id
	 * @param goodsid	商品id
	 */
	public void setGoodsid(String goodsid)
	{
		this.goodsid = goodsid != null ? goodsid : "";
	}

	/**
	 * 获取商品id
	 * @return	商品id
	 */
	public String getGoodsid()
	{
		return this.goodsid;
	}

	/**
	 * 设置商品名称
	 * @param goodsname	商品名称
	 */
	public void setGoodsname(String goodsname)
	{
		this.goodsname = goodsname != null ? goodsname : "";
	}

	/**
	 * 获取商品名称
	 * @return	商品名称
	 */
	public String getGoodsname()
	{
		return this.goodsname;
	}

	/**
	 * 设置商品价格
	 * @param goodsprice	商品价格
	 */
	public void setGoodsprice(String goodsprice)
	{
		this.goodsprice = goodsprice != null ? goodsprice : "";
	}

	/**
	 * 获取商品价格
	 * @return	商品价格
	 */
	public String getGoodsprice()
	{
		return this.goodsprice;
	}

	/**
	 * 设置商品数量
	 * @param goodsnum	商品数量
	 */
	public void setGoodsnum(String goodsnum)
	{
		this.goodsnum = goodsnum != null ? goodsnum : "";
	}

	/**
	 * 获取商品数量
	 * @return	商品数量
	 */
	public String getGoodsnum()
	{
		return this.goodsnum;
	}

	/**
	 * 设置商品图片URL，多张图以逗号分隔
	 * @param goodsimg	商品图片URL，多张图以逗号分隔
	 */
	public void setGoodsimg(String goodsimg)
	{
		this.goodsimg = goodsimg != null ? goodsimg : "";
	}

	/**
	 * 获取商品图片URL，多张图以逗号分隔
	 * @return	商品图片URL，多张图以逗号分隔
	 */
	public String getGoodsimg()
	{
		return this.goodsimg;
	}

	/**
	 * 设置商品所属品类的品类编号 
	 * @param categoryid	商品所属品类的品类编号 
	 */
	public void setCategoryid(String categoryid)
	{
		this.categoryid = categoryid != null ? categoryid : "";
	}

	/**
	 * 获取商品所属品类的品类编号 
	 * @return	商品所属品类的品类编号 
	 */
	public String getCategoryid()
	{
		return this.categoryid;
	}

	/**
	 * 设置商品所属品类的品类名称 
	 * @param categoryname	商品所属品类的品类名称 
	 */
	public void setCategoryname(String categoryname)
	{
		this.categoryname = categoryname != null ? categoryname : "";
	}

	/**
	 * 获取商品所属品类的品类名称 
	 * @return	商品所属品类的品类名称 
	 */
	public String getCategoryname()
	{
		return this.categoryname;
	}

	/**
	 * 设置商品所属品类的根节点品类编号 
	 * @param rootcategoryid	商品所属品类的根节点品类编号 
	 */
	public void setRootcategoryid(String rootcategoryid)
	{
		this.rootcategoryid = rootcategoryid != null ? rootcategoryid : "";
	}

	/**
	 * 获取商品所属品类的根节点品类编号 
	 * @return	商品所属品类的根节点品类编号 
	 */
	public String getRootcategoryid()
	{
		return this.rootcategoryid;
	}

	/**
	 * 设置商品所属品类的根节点品类名称 
	 * @param rootcategoryname	商品所属品类的根节点品类名称 
	 */
	public void setRootcategoryname(String rootcategoryname)
	{
		this.rootcategoryname = rootcategoryname != null ? rootcategoryname : "";
	}

	/**
	 * 获取商品所属品类的根节点品类名称 
	 * @return	商品所属品类的根节点品类名称 
	 */
	public String getRootcategoryname()
	{
		return this.rootcategoryname;
	}

	/**
	 * 设置品牌编号
	 * @param goodsbrandid	品牌编号
	 */
	public void setGoodsbrandid(String goodsbrandid)
	{
		this.goodsbrandid = goodsbrandid != null ? goodsbrandid : "";
	}

	/**
	 * 获取品牌编号
	 * @return	品牌编号
	 */
	public String getGoodsbrandid()
	{
		return this.goodsbrandid;
	}

	/**
	 * 设置品牌名称
	 * @param goodsbrandname	品牌名称
	 */
	public void setGoodsbrandname(String goodsbrandname)
	{
		this.goodsbrandname = goodsbrandname != null ? goodsbrandname : "";
	}

	/**
	 * 获取品牌名称
	 * @return	品牌名称
	 */
	public String getGoodsbrandname()
	{
		return this.goodsbrandname;
	}

	/**
	 * 设置产品特征
	 * @param goodsdetailextend	产品特征
	 */
	public void setGoodsdetailextend(java.util.List<Goodsdetailextend> goodsdetailextend)
	{
		this.goodsdetailextend = goodsdetailextend;
	}

	/**
	 * 获取产品特征
	 * @return	产品特征
	 */
	public java.util.List<Goodsdetailextend> getGoodsdetailextend()
	{
		return this.goodsdetailextend;
	}

	/**
	 * 设置消费时间
	 * @param time	消费时间
	 */
	public void setTime(String time)
	{
		this.time = time != null ? time : "";
	}

	/**
	 * 获取消费时间
	 * @return	消费时间
	 */
	public String getTime()
	{
		return this.time;
	}

	/**
	 * 添加产品特征
	 * @return goodsdetailextend	产品特征
	 */
	public Goodsdetailextend addMoreGoodsdetailextend() {
		Goodsdetailextend goodsdetailextend = new Goodsdetailextend();
		this.goodsdetailextend.add(goodsdetailextend);
		return goodsdetailextend;
	}
}