<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<ul class="mbImg" >
	<c:if test="${not empty pm.result}">
		<c:forEach var="node" items="${pm.result}" varStatus="xh">
			<li>
				<c:if test="${empty node.icon}">
					<img src="${imgPath}/gms/common/images/default1.jpg" title="${node.name }" onclick="editTemplate('${node.code }');" />
				</c:if>
				<c:if test="${not empty node.icon}">
					<img src="${node.icon}" title="${node.name }" onclick="editTemplate('${node.code }');" />
				</c:if>
			</li>
		</c:forEach>
	</c:if>
	<c:if test="${empty pm.result}">
		<p align="center" style="font-size: 14px; line-height: 40px; font-weight: bold;">暂无模板信息!</p>
	</c:if>
</ul>
<c:if test="${not empty pm.result}">
	<%@ include file="/WEB-INF/jsp/common/page.jsp"%>
</c:if>

