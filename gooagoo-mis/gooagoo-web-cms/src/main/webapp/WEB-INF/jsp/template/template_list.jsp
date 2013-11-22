<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<ul class="mbImg">
	<c:if test="${not empty pm.result}">
		<c:forEach var="itemChild" items="${pm.result}" varStatus="xh">
		<li>
			<c:if test="${empty itemChild.templateImg}">
				<img src="${imgPath}/gms/common/images/default1.jpg" title="${itemChild.templateName }" onclick="editTemplateForm('${itemChild.templateId }');" width="100px;" height="100px;"/>
			</c:if>
			<c:if test="${not empty itemChild.templateImg}">
				<img src="${itemChild.templateImg}" title="${itemChild.templateName }" onclick="editTemplateForm('${itemChild.templateId }');" width="100px;" height="100px;"/>
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
