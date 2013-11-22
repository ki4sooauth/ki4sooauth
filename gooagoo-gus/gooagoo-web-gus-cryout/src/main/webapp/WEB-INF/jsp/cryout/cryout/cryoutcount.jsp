<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<c:choose>
<c:when test="${data != null && data > 0 }">
	有${data }条吆喝&nbsp;<a href="javascript:void(0)" onclick="javascript: loadNewCryoutlistRequest();">点击查看</a>
</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>