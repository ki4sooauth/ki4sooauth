<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript">
// 关闭
function closeDiv() {
	(document.parentWindow || document.defaultView).parent.closeFancyBox();
}
</script>
</head>

<body>
	<div align="center">
		<table border="1" cellpadding="0" cellspacing="0" style="border-collapse: collapse;margin-top: 50px;" width="90%">
			<tr>
				<td class="tdOne">行为编号：</td>
				<td class="tdTwo">${behave.behaveId}</td>
				<td class="tdOne">用户编号：</td>
				<td class="tdTwo">${behave.userId}</td>
			</tr>
			<tr>
				<td class="tdOne">用户名：</td>
				<td class="tdTwo">${behave.account}</td>
				<td class="tdOne">手机唯一编号：</td>
				<td class="tdTwo">${behave.gooagooID}</td>
			</tr>
			<tr>
				<td class="tdOne">IP地址：</td>
				<td class="tdTwo">${behave.ipAddress}</td>
				<td class="tdOne">MAC地址：</td>
				<td class="tdTwo">${behave.macAddress}</td>
			</tr>
			<tr>
				<td class="tdOne">主机名：</td>
				<td class="tdTwo">${behave.hostName}</td>
				<td class="tdOne">手机号：</td>
				<td class="tdTwo">${behave.mobile}</td>
			</tr>
			<tr>
				<td class="tdOne">电子商务帐号：</td>
				<td class="tdTwo">${behave.ecAccount}</td>
				<td class="tdOne">会员卡音频编号（电子卡号）：</td>
				<td class="tdTwo">${behave.scardno}</td>
			</tr>
			<tr>
				<td class="tdOne">物理卡号：</td>
				<td class="tdTwo">${behave.phyCardNo}</td>
				<td class="tdOne">会员等级（会员卡编号）：</td>
				<td class="tdTwo">${behave.cardId}</td>
			</tr>
			<tr>
				<td class="tdOne">手机型号：</td>
				<td class="tdTwo">${behave.phoneType}</td>
				<td class="tdOne">操作系统类型：</td>
				<td class="tdTwo">${behave.systemType}</td>
			</tr>
			<tr>
				<td class="tdOne">浏览器类型：</td>
				<td class="tdTwo">${behave.browserType}</td>
				<td class="tdOne">浏览器语言设置：</td>
				<td class="tdTwo">${behave.language}</td>
			</tr>
			<tr>
				<td class="tdOne">屏幕分辨率：</td>
				<td class="tdTwo">${behave.screenResolution}</td>
				<td class="tdOne">屏幕颜色：</td>
				<td class="tdTwo">${behave.screenColor}</td>
			</tr>
			<tr>
				<td class="tdOne">行为发生时间：</td>
				<td class="tdTwo"><fmt:formatDate value="${behave.behaveTime}" type="both" pattern="yyyy-MM-dd HH:mm:ss" /></td>
				<td class="tdOne">用户行为来源：</td>
				<td class="tdTwo">
					<c:forEach items="${behave_source }" var="source">
						<c:if test="${behave.source == source.englishName }">${source.chineseName }</c:if>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td class="tdOne">操作结果：</td>
				<td class="tdTwo">
					<c:choose>
					<c:when test="${behave.operateResult eq 'Y'}">成功</c:when>
					<c:otherwise>失败</c:otherwise>
					</c:choose>
				</td>
				<td class="tdOne">行为类型：</td>
				<td class="tdTwo">
					<c:forEach items="${behave_type }" var="type">
						<c:if test="${behave.behaveType == type.englishName }">${type.chineseName }</c:if>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td class="tdOne">行为发生地区的区域编号：</td>
				<td class="tdTwo">${behave.positionId}</td>
				<td class="tdOne">所调用的接口编码：</td>
				<td class="tdTwo">${behave.remoteCode}</td>
			</tr>
			<tr>
				<td class="tdOne">行为对象编号：</td>
				<td class="tdTwo">${behave.objectValue}</td>
				<td class="tdOne">行为对象类型：</td>
				<td class="tdTwo">
				<c:choose>
					<c:when test="${behave.objectType eq 'A'}">活动</c:when>
					<c:when test="${behave.objectType eq 'G'}">商品</c:when>
					<c:when test="${behave.objectType eq 'C'}">优惠凭证</c:when>
					<c:when test="${behave.objectType eq 'Y'}">吆喝</c:when>
					<c:when test="${behave.objectType eq 'N'}">通知</c:when>
					<c:when test="${behave.objectType eq 'Q'}">购好奇</c:when>
					<c:when test="${behave.objectType eq 'M'}">邮件</c:when>
					<c:when test="${behave.objectType eq 'S'}">手机服务</c:when>
					<c:when test="${behave.objectType eq '0'}">cms栏目</c:when>
					<c:when test="${behave.objectType eq '1'}">cms文章</c:when>
					<c:when test="${behave.objectType eq '2'}">广告</c:when>
				</c:choose>
				</td>
			</tr>
			<tr>
				<td class="tdOne">行为对象名称：</td>
				<td class="tdTwo">${behave.objectName}</td>
				<td class="tdOne">行为对象所属商家编号：</td>
				<td class="tdTwo">${behave.shopId}</td>
			</tr>
			<tr>
				<td class="tdOne">行为对象所属实体店编号：</td>
				<td class="tdTwo">${behave.shopEntityId}</td>
				<td class="tdOne">行为对象来源：</td>
				<td class="tdTwo">${behave.objectSource}</td>
			</tr>
			<tr>
				<td class="tdOne">品类：</td>
				<td class="tdTwo">${behave.categoryId}</td>
				<td class="tdOne">品牌：</td>
				<td class="tdTwo">${behave.brandId}</td>
			</tr>
			<tr>
				<td class="tdOne">创建时间：</td>
				<td colspan="3" align="center"><fmt:formatDate value="${behave.createTime}" type="both" pattern="yyyy-MM-dd HH:mm:ss" /></td>
			</tr>
			<tr>
				<td class="tdOne">详细信息：</td>
				<td colspan="3" style="word-break:break-all;">${behave.detail}</td>
			</tr>
		</table>
		<input type="button" class="perMsg_btn" style="margin-top: 20px;" value="关闭" onclick="closeDiv();"/>
	</div>
</body>
</html>