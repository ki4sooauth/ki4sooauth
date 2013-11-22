<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<option value="">--请选择省 --</option>
<c:if test="${isSuccess && data != null && fn:length(data) > 0 }">
	<c:forEach var="province" items="${data }">
		<option value="${province.provinceId}">${province.provinceName }</option>
	</c:forEach>
</c:if>