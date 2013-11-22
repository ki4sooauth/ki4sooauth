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
				<td class="tdOne">日志编号：</td>
				<td class="tdTwo">${sys.sysLogId}</td>
				<td class="tdOne">管理员帐号：</td>
				<td class="tdTwo">${sys.userId}</td>
			</tr>
			<tr>
				<td class="tdOne">所调用的接口编码：</td>
				<td class="tdTwo">${sys.remoteCode}</td>
				<td class="tdOne">操作类型：</td>
				<td class="tdTwo">
					<c:forEach items="${shop_behave_type }" var="type">
						<c:if test="${sys.shopBehaveType == type.englishName }">${type.chineseName }</c:if>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td class="tdOne">操作对象编号：</td>
				<td class="tdTwo">${sys.objectCode}</td>
				<td class="tdOne">操作结果：</td>
				<td class="tdTwo">
					<c:choose>
					<c:when test="${sys.operateResult eq 'Y'}">成功</c:when>
					<c:otherwise>失败</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<td class="tdOne">操作IP：</td>
				<td class="tdTwo">${sys.operateIp}</td>
				<td class="tdOne">创建时间：</td>
				<td class="tdTwo"><fmt:formatDate value="${sys.createTime}" type="both" pattern="yyyy-MM-dd HH:mm:ss" /></td>
			</tr>
			<tr>
				<td class="tdOne">详细信息：</td>
				<td colspan="3" style="word-break:break-all;">${sys.detail}</td>
			</tr>
		</table>
		<input type="button" class="perMsg_btn" style="margin-top: 20px;" value="关闭" onclick="closeDiv()"/>
	</div>
</body>
</html>