<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<c:forEach  items="${data}" var="list">
<li><a href="javascript:void(0)">${list.goodsTypeName}</a></li>
</c:forEach>