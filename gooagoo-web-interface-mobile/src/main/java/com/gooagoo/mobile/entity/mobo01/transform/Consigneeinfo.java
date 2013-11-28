package com.gooagoo.mobile.entity.mobo01.transform;

import java.io.Serializable;

/**
 *  收货人地址信息
 */
public class Consigneeinfo implements Serializable
{

	private static final long serialVersionUID = 1L;

	/**  收货人信息编号，UUID */
	private String consigneeid = "";

	/**  收货人姓名  */
	private String consigneename = "";

	/** 省 */
	private String province = "";

	/** 市 */
	private String city = "";

	/** 区县 */
	private String area = "";

	/** 详细地址  */
	private String address = "";

	/**  手机号码  */
	private String phone = "";

	/** 联系电话 */
	private String telephone = "";

	/**  邮政编码  */
	private String postcode = "";

	/**  是否默认选项，Y-是，N-否  */
	private String isdefault = "";

	/**
	 * 设置 收货人信息编号，UUID
	 * @param consigneeid	 收货人信息编号，UUID
	 */
	public void setConsigneeid(String consigneeid)
	{
		this.consigneeid = consigneeid != null ? consigneeid : "";
	}

	/**
	 * 获取 收货人信息编号，UUID
	 * @return	 收货人信息编号，UUID
	 */
	public String getConsigneeid()
	{
		return this.consigneeid;
	}

	/**
	 * 设置 收货人姓名 
	 * @param consigneename	 收货人姓名 
	 */
	public void setConsigneename(String consigneename)
	{
		this.consigneename = consigneename != null ? consigneename : "";
	}

	/**
	 * 获取 收货人姓名 
	 * @return	 收货人姓名 
	 */
	public String getConsigneename()
	{
		return this.consigneename;
	}

	/**
	 * 设置省
	 * @param province	省
	 */
	public void setProvince(String province)
	{
		this.province = province != null ? province : "";
	}

	/**
	 * 获取省
	 * @return	省
	 */
	public String getProvince()
	{
		return this.province;
	}

	/**
	 * 设置市
	 * @param city	市
	 */
	public void setCity(String city)
	{
		this.city = city != null ? city : "";
	}

	/**
	 * 获取市
	 * @return	市
	 */
	public String getCity()
	{
		return this.city;
	}

	/**
	 * 设置区县
	 * @param area	区县
	 */
	public void setArea(String area)
	{
		this.area = area != null ? area : "";
	}

	/**
	 * 获取区县
	 * @return	区县
	 */
	public String getArea()
	{
		return this.area;
	}

	/**
	 * 设置详细地址 
	 * @param address	详细地址 
	 */
	public void setAddress(String address)
	{
		this.address = address != null ? address : "";
	}

	/**
	 * 获取详细地址 
	 * @return	详细地址 
	 */
	public String getAddress()
	{
		return this.address;
	}

	/**
	 * 设置 手机号码 
	 * @param phone	 手机号码 
	 */
	public void setPhone(String phone)
	{
		this.phone = phone != null ? phone : "";
	}

	/**
	 * 获取 手机号码 
	 * @return	 手机号码 
	 */
	public String getPhone()
	{
		return this.phone;
	}

	/**
	 * 设置联系电话
	 * @param telephone	联系电话
	 */
	public void setTelephone(String telephone)
	{
		this.telephone = telephone != null ? telephone : "";
	}

	/**
	 * 获取联系电话
	 * @return	联系电话
	 */
	public String getTelephone()
	{
		return this.telephone;
	}

	/**
	 * 设置 邮政编码 
	 * @param postcode	 邮政编码 
	 */
	public void setPostcode(String postcode)
	{
		this.postcode = postcode != null ? postcode : "";
	}

	/**
	 * 获取 邮政编码 
	 * @return	 邮政编码 
	 */
	public String getPostcode()
	{
		return this.postcode;
	}

	/**
	 * 设置 是否默认选项，Y-是，N-否 
	 * @param isdefault	 是否默认选项，Y-是，N-否 
	 */
	public void setIsdefault(String isdefault)
	{
		this.isdefault = isdefault != null ? isdefault : "";
	}

	/**
	 * 获取 是否默认选项，Y-是，N-否 
	 * @return	 是否默认选项，Y-是，N-否 
	 */
	public String getIsdefault()
	{
		return this.isdefault;
	}
}