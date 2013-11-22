package com.gooagoo.view.gms.shopinfo;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色表
 */

public class FShopRole implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date createTime;// 创建时间
	private String note;// 备注
	private String roleId;// 角色编号，唯一，通过UUID产生
	private String roleName;// 角色名称
	private String shopId;// 商家编号

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public String getNote() {
		return this.note;
	}

	public String getRoleId() {
		return this.roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "FShopRole [createTime=" + createTime + ", note=" + note+ ", roleId=" + roleId + ", roleName=" + roleName + ", shopId="+ shopId + "]";
	}

}
