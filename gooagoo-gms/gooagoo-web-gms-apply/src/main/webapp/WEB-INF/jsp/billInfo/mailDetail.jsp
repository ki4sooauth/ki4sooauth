<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<div class="attributeFile">
	<table border="0" cellpadding="0" cellspacing="1" class="attributeTable">
		<tr>
			<td width="152"><strong>第三方订单编号</strong></td>
			<td width="550">${orderInfo.thirdOrderId}</td>
		</tr>
		<tr>
			<td width="152"><strong>消费时间</strong></td>
			<td width="550"><label class="moneyNum"><fmt:formatDate value="${orderInfo.requestTime}" pattern="yyyy-MM-dd HH:mm:ss" /></label></td>
		</tr>
		<tr>
			<td width="152"><strong>会员卡号</strong></td>
			<td width="550">${orderInfo.scardNo}</td>
		</tr>
		<tr>
			<td width="152"><strong>商家MAC地址</strong></td>
			<td width="550">${orderInfo.mac}</td>
		</tr>
		<tr>
			<td width="152"><strong>账单商品总数</strong></td>
			<td width="550">${orderInfo.goodsTotalNum}</td>
		</tr>
		<tr>
			<td width="152"><strong>原价格</strong></td>
			<td width="550">${orderInfo.originalPrice}</td>
		</tr>
		<tr>
			<td width="152"><strong>折扣</strong></td>
			<td width="550">${orderInfo.discountRate}</td>
		</tr>
		<tr>
			<td width="152"><strong>实际支付价格</strong></td>
			<td width="550">${orderInfo.payPrice}</td>
		</tr>
		<tr>
			<td width="152"><strong>提货方式</strong></td>
			<td width="550">${orderInfo.deliveryStatusName}</td>
		</tr>
		<tr>
			<td width="152"><strong>是否店员助理提交</strong></td>
			<td width="550">${orderInfo.isSaCommit eq "Y"?"是":"否"}</td>
		</tr>
		<tr>
			<td width="152"><strong>店员助理登录帐号</strong></td>
			<td width="550">${orderInfo.account}</td>
		</tr>
		<tr>
			<td width="152"><strong>用户订单提交时间</strong></td>
			<td width="550"><fmt:formatDate value="${orderInfo.userOrderTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
		</tr>
		<tr>
			<td width="152"><strong>商家订单提交时间</strong></td>
			<td width="550"><fmt:formatDate value="${orderInfo.shopOrderTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
		</tr>
		<tr>
			<td width="152"><strong>创建时间</strong></td>
			<td width="550"><fmt:formatDate value="${orderInfo.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
		</tr>
	</table>
</div>