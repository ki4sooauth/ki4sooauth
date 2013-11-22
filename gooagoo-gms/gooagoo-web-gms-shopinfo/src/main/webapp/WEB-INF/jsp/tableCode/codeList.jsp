<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<ul>
   <c:forEach items="${pageModel.result}" var="tableInfo">
	<li><a href="#"><img src='${basePath}/common.do?method=getTwoCode&content=["gooagoo","00","${tableInfo.shopEntityId}","${tableInfo.tableNo}","${tableInfo.roomName}"]&size=3' 
			width="120" height="120"/></a>
		<dl>
			<dd>
				<span>${shopVo.wordNames['gmsg311']}</span>
				<samp>${tableInfo.tableNo}</samp>
			</dd>
			<dd>
				<span>${shopVo.wordNames['gmsg312']}</span>
				<samp>${tableInfo.roomName}</samp>
			</dd>
			<dd>
				<span>${shopVo.wordNames['gmsg313']}</span>
				<samp>["gooagoo","00","${tableInfo.shopEntityId}","${tableInfo.tableNo}","${tableInfo.roomName}"]</samp>
			</dd>
		</dl></li>
	</c:forEach>
</ul>